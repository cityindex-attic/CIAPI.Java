package codegen;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import JsonClient.Java.ApiException;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

/**
 * Main class for running stuff
 * 
 * @author Justin Nelson
 */
public class CodeGenMain {
	private static String schemaLocation = "files/smdFiles/schema.js";
	private static String smdLocation = "files/smdFiles/smd.js";

	/**
	 * Stuff...It's a main...what do you expect?
	 * 
	 * @param args
	 * @throws JsonIOException
	 * @throws JsonSyntaxException
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public static void main(String[] args) throws JsonIOException, JsonSyntaxException,
			MalformedURLException, IOException, ApiException, ParserConfigurationException,
			SAXException {
		List<ClParam> params = parseParams(args);
		SchemaReader rdr = new SchemaReader(new FileInputStream(schemaLocation),
				new FileInputStream(smdLocation));
		rdr.createPackage("CIAPI.Java",
				"/home/justin/workspace/CIAPI.Java/src/CIAPI.Java/src/main/java/CIAPI/Java/");
	}

	public static List<ClParam> parseParams(String[] array) {
		List<ClParam> ret = new ArrayList<ClParam>();
		for (int i = 0; i < array.length; i += 2) {
			ret.add(new ClParam(array[i], array[i + 1]));
		}
		return ret;
	}

	static enum SpecificParams {
		SCHEMA_URI("-sch", "The URI location of the SMD descriptor."), 
		SMD_URI("-smd", "The URI location of the Schema descriptor.");
		
		public final String option;
		public final String description;

		private SpecificParams(String option, String description) {
			this.option = option;
			this.description = description;
		}
	}

	static class ClParam {
		public final String option;
		public final String value;

		public ClParam(String option, String value) {
			this.option = option;
			this.value = value;
			checkValues();
		}

		private void checkValues() {
			if (!option.startsWith("-")) {
				throw new IllegalArgumentException("The parameter '" + option
						+ "' is not a valid switch.");
			}
		}
	}
}
