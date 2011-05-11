package codegen;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import codegen.codetemplates.templatecompletion.TemplateFiller;
import codegen.codetemplates.templatecompletion.replacementrule.ReplacementRoot;
import codegen.modelobjects.DTO;
import codegen.modelobjects.Parameter;
import codegen.modelobjects.SMDDescriptor;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

/**
 * Given urls, will create DTO objects and Service objects that can be turned into code. <br />
 * 
 * @author Justin Nelson
 * 
 */
public class SchemaReader {

	private SMDDescriptor smd;
	private Map<String, DTO> dtos;

	private Map<Class<?>, List<ReplacementRoot>> replacements;

	/**
	 * Creates a new schema reader with the given schema and smd url.
	 * 
	 * @param schemaStream
	 *            the stream containing the schema data
	 * @param smdStream
	 *            the stream containing the smd data
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 */
	public SchemaReader(InputStream schemaStream, InputStream smdStream, String replacementDirectory)
			throws ParserConfigurationException, SAXException, IOException, ClassNotFoundException {
		this.replacements = loadReplacements(replacementDirectory);
		dtos = new HashMap<String, DTO>();
		GsonBuilder gb = new GsonBuilder();
		gb.registerTypeAdapter(DTO.class, DTO.getDeSerializer());
		gb.registerTypeAdapter(Parameter.class, Parameter.getDeSerializer());
		Gson g = gb.create();
		JsonParser parser = new JsonParser();
		smd = g.fromJson(new InputStreamReader(smdStream), SMDDescriptor.class);
		JsonObject obj = (JsonObject) parser.parse(new InputStreamReader(schemaStream));
		for (Entry<String, JsonElement> entry : obj.entrySet()) {
			dtos.put(entry.getKey(), g.fromJson(entry.getValue(), DTO.class));
		}
	}

	private Map<Class<?>, List<ReplacementRoot>> loadReplacements(String replacementDirectory)
			throws ParserConfigurationException, SAXException, IOException, ClassNotFoundException {
		Map<Class<?>, List<ReplacementRoot>> ret = new HashMap<Class<?>, List<ReplacementRoot>>();
		for (File fName : new File(replacementDirectory).listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				return pathname.getName().endsWith("xml");
			}
		})) {
			ReplacementRoot root = new ReplacementRoot(fName.getAbsolutePath());
			List<ReplacementRoot> toAddTo;
			if (ret.containsKey(root.getRequiredClass())) {
				toAddTo = ret.get(root.getRequiredClass());
			} else {
				toAddTo = new ArrayList<ReplacementRoot>();
				ret.put(root.getRequiredClass(), toAddTo);
			}
			toAddTo.add(root);
		}
		return ret;
	}

	/**
	 * Gets all of the model objects from a given Schema url
	 * 
	 * @return the Model objects for a given schema.
	 */
	public Map<String, DTO> getAllModelItems() {
		return dtos;
	}

	/**
	 * @return the object representing all of the services of a given smd
	 */
	public SMDDescriptor getServices() {
		return smd;
	}

	/**
	 * Generates all methods an model objects for a given pair of smd and schema url.
	 * 
	 * @param packageName
	 * @param saveLocation
	 * @throws JsonIOException
	 * @throws JsonSyntaxException
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public void createPackage(String packageName, String saveLocation) throws JsonIOException,
			JsonSyntaxException, MalformedURLException, IOException {
		createDirectories(saveLocation);
		// Process all replacements that go with services
		List<ReplacementRoot> serviceReplacements = this.replacements.get(getServices().getClass());
		for (ReplacementRoot repl : serviceReplacements) {
			TemplateFiller filler = new TemplateFiller(repl);
			String resolvedFileName = repl.fileName(getServices(), packageName);
			PrintStream smdOut = new PrintStream(new File(saveLocation + File.separatorChar
					+ resolvedFileName));
			smdOut.println(filler.fillTemplate(getServices(), packageName, packageName + ".dto"));
			smdOut.close();
		}

		// Process all replacements that go with each DTO
		for (Entry<String, DTO> entry : getAllModelItems().entrySet()) {
			List<ReplacementRoot> dtoReplacements = this.replacements.get(entry.getValue()
					.getClass());
			for (ReplacementRoot repl : dtoReplacements) {
				String resolvedFileName = repl.fileName(entry.getValue(), entry.getKey(),
						packageName);
				TemplateFiller filler = new TemplateFiller(repl);
				PrintStream dtoOut = new PrintStream(new File(saveLocation + File.separatorChar
						+ "dto/" + resolvedFileName + ".java"));
				dtoOut.println(filler.fillTemplate(entry.getValue(), entry.getKey(), packageName + ".dto"));
				dtoOut.close();
			}
		}
	}

	/**
	 * Ensures that all of the necessary directories are created to put the code in.
	 * 
	 * @throws IOException
	 */
	private static void createDirectories(String baseDirectory) throws IOException {
		File f = new File(baseDirectory);
		ensureDirIsGood(f);
		String methodImplDir = baseDirectory + File.separatorChar + "impl";
		f = new File(methodImplDir);
		ensureDirIsGood(f);
		String dtoDir = baseDirectory + File.separatorChar + "dto";
		f = new File(dtoDir);
		ensureDirIsGood(f);
	}

	private static void ensureDirIsGood(File f) throws IOException {
		// we need for to exist
		if (f.exists()) {
			// We need f to be a directory
			if (!f.isDirectory()) {
				throw new IllegalArgumentException(
						"The given save location must be the base director to save the code: "
								+ f.getAbsolutePath());
			} else {
				return;
			}
		}
		// if f did not exist, we need to create f
		if (!f.mkdirs()) {
			throw new IOException("There was an error creating the directoriy: "
					+ f.getAbsolutePath());
		}
	}
}
