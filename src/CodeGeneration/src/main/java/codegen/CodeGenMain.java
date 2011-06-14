package codegen;

import static CIAPI.Java.logging.Log.debug;
import static CIAPI.Java.logging.Log.error;
import static CIAPI.Java.logging.Log.info;
import static CIAPI.Java.logging.Log.trace;
import static CIAPI.Java.logging.Log.warn;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

/**
 * Main class for running stuff
 * 
 * @author Justin Nelson
 */
public class CodeGenMain {
	/**
	 * Stuff...It's a main...what do you expect?
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws ClassNotFoundException,
			IOException {
		info("Beginning the process of generating code");
		if (args.length == 0 || args[0].matches("(-h|-H|--help)")
				|| args.length % 2 == 1) {
			debug("Given arguments did not match the expected arguments");
			CodeGenMain.printUsage();
			return;
		}
		List<ClParam> params = parseParams(args);
		String outputLocation = CodeGenMain.generateCode(params);
		if (outputLocation != null) {
			info("Success!  Generated code!: " + outputLocation);
		} else {
			warn("Code was not generated");
		}
	}

	/**
	 * Uses the specific params to print the usage instructions to standard out
	 */
	private static void printUsage() {
		String usage = "Please specify the following arguments:\n"
				+ SpecificParams.toUsageString();
		System.out.println(usage);
	}

	/**
	 * Given a set of command line parameters, generate the code using a
	 * SchemaReader.
	 * 
	 * @param params
	 *            the command line args after they've been parsed
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws ClassNotFoundException
	 */
	public static String generateCode(List<ClParam> params)
			throws ClassNotFoundException, IOException {
		CodeGenConfig conf = parseClParams(params);
		SchemaReader.generateCode(conf);
		return conf.getSaveLocation();
	}

	private static CodeGenConfig parseClParams(List<ClParam> parms) {
		if (parms.size() < 3 && parms.size() != 1) {
			error(new IllegalArgumentException(
					"You must provide the 4 location parameters or a config file."));
		}
		// Find all of the required parameters
		String schemaLocation = null;
		String smdLocation = null;
		String saveLocation = null;
		String replacementDirectory = null;
		String configLocation = null;
		for (ClParam p : parms) {
			if (p.option.equals("-sch")) {
				schemaLocation = p.value;
			} else if (p.option.equals("-smd")) {
				smdLocation = p.value;
			} else if (p.option.equals("-l")) {
				saveLocation = p.value;
			} else if (p.option.equals("-t")) {
			} else if (p.option.equals("-r")) {
				replacementDirectory = p.value;
			} else if (p.option.equals("-c")) {
				configLocation = p.value;
			}
		}
		// If a config file was supplied, we will use the values from that
		if (configLocation != null) {
			CodeGenConfig conf = CodeGenConfig.loadFile(configLocation);
			return conf;
		}
		// If any of the other values are null, then we have a problem
		if (schemaLocation == null || smdLocation == null
				|| saveLocation == null || replacementDirectory == null) {
			error("Did not find all required parameters");
			printUsage();
			return null;
		}
		return new CodeGenConfig(smdLocation, schemaLocation,
				replacementDirectory, saveLocation);
	}

	public static InputStream openFileOrUrl(String path) throws IOException {
		if (path.startsWith("http")) {
			debug("Attempting to open url: " + path);
			URL url = new URL(path);
			return url.openStream();
		} else {
			debug("Attempting to open local file: " + path);
			return new FileInputStream(new File(path));
		}
	}

	/**
	 * Parses params into objects.
	 * 
	 * @param array
	 *            command line arguments from main
	 * @return a list of ClParam objects that represent the parameters passed
	 *         into main
	 */
	private static List<ClParam> parseParams(String[] array) {
		List<ClParam> ret = new ArrayList<ClParam>();
		for (int i = 0; i < array.length; i += 2) {
			ret.add(new ClParam(array[i], array[i + 1]));
		}
		trace("Parsed " + ret.size() + " parameters from the command line.");
		return ret;
	}

	/**
	 * The specific parameters we need for generating code
	 * 
	 * @author Justin Nelson
	 */
	static enum SpecificParams {
		CONFIG_LOCATION(
				"-c",
				"Where the code gen config file is located. Use this parameter, or all of the rest."), SCHEMA_URI(
				"-sch", "The local file or URL location of the SMD descriptor"), SMD_URI(
				"-smd",
				"The local file or URL location of the Schema descriptor"), SAVE_LOCATION(
				"-l", "The location to save the generated code"), REPLACEMNT_FILE_DIR(
				"-r", "The directory where your replacement files are located.");

		public final String option;
		public final String description;

		private SpecificParams(String option, String description) {
			this.option = option;
			this.description = description;
		}

		/**
		 * Will combine the switch and the description of it's behavior and
		 * return a pretty string
		 * 
		 * @return what the given {@link SpecificParams} is used for.
		 */
		public static String toUsageString() {
			String ret = "";
			for (SpecificParams p : values()) {
				ret += "\t" + p.option + " <" + p.description + ">\n";
			}
			return ret;
		}

		/**
		 * Will find a {@link SpecificParams} that matches the given option.
		 * 
		 * @param option
		 *            the option to match
		 * @return the {@link SpecificParams} matching the option. Or
		 *         <code>null</code> if no matches are found.
		 */
		public static SpecificParams fromOption(String option) {
			for (SpecificParams p : values()) {
				if (p.option.equals(option)) {
					return p;
				}
			}
			warn("Could not parse generic option: " + option);
			return null;
		}
	}

	/**
	 * A class representing a generic command line paramter. It has 2 parts, an
	 * option (-l, -smd) and a value.
	 * 
	 * @author Justin Nelson
	 * 
	 */
	static class ClParam {
		public final String option;
		public final String value;

		public ClParam(String option, String value) {
			this.option = option;
			this.value = value;
			checkValues();
		}

		/**
		 * Given the generic parameter will try to find the matching specific
		 * parameter.
		 * 
		 * @return
		 */
		public SpecificParams toSpecificParam() {
			return SpecificParams.fromOption(option);
		}

		private void checkValues() {
			if (!option.startsWith("-")) {
				throw new IllegalArgumentException("The parameter '" + option
						+ "' is not a valid switch.");
			}
		}
	}
}
