package codegen;

import static CIAPI.Java.logging.Log.debug;
import static CIAPI.Java.logging.Log.trace;
import static CIAPI.Java.logging.Log.error;
import static CIAPI.Java.logging.Log.warn;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
 * Provides functionality for parsing SMD and Schema definition. Also can generate code given a set
 * of Replacement files and Code Template Files.
 * 
 * @author Justin Nelson
 * 
 */
public class SchemaReader {

	private String replacementDir;

	private SMDDescriptor smd;
	private List<DTO> dtos;

	private Map<Class<?>, List<ReplacementRoot>> replacements;

	/**
	 * Creates a new schema reader with the given schema and smd url.
	 * 
	 * @param schemaStream
	 *            the stream containing the schema data
	 * @param smdStream
	 *            the stream containing the smd data
	 * @param replacementDirectory
	 *            the directory where you have all of the replacement files you would like to use.
	 *            This will look recursively.
	 * @throws ClassNotFoundException
	 *             if we cannot find the type that was referenced from one of the replacement files
	 * @throws IOException
	 *             if any file reading goes wrong
	 */
	public SchemaReader(InputStream schemaStream, InputStream smdStream, String replacementDirectory)
			throws ClassNotFoundException {
		this.replacementDir = replacementDirectory;
		this.replacements = loadReplacements(replacementDirectory);
		// create out Gson. Need to register adapters for some of our classes to work around some
		// JSON oddities
		GsonBuilder gb = new GsonBuilder();
		gb.registerTypeAdapter(DTO.class, DTO.getDeSerializer());
		gb.registerTypeAdapter(Parameter.class, Parameter.getDeSerializer());
		Gson g = gb.create();
		trace("Attempting to parse the SMD stream");
		smd = g.fromJson(new InputStreamReader(smdStream), SMDDescriptor.class);
		trace("Successfully parsed stream");
		// using some extra JSON parsing to pull individual DAOs out of the one big DAO return
		// object.
		JsonParser parser = new JsonParser();
		trace("Attempting to parse the Schema stream");
		JsonObject obj = (JsonObject) parser.parse(new InputStreamReader(schemaStream));
		dtos = new ArrayList<DTO>();
		for (Entry<String, JsonElement> entry : obj.entrySet()) {
			DTO result = g.fromJson(entry.getValue(), DTO.class);
			result.setName(entry.getKey());
			dtos.add(result);
		}
		trace("Successfully parsed stream");
	}

	/**
	 * Given a directory, will find all of the replacement files located in that directory. It will
	 * assume any file ending in xml is a replacement file.
	 * 
	 * @param replacementDirectory
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws FileNotFoundException
	 */
	private Map<Class<?>, List<ReplacementRoot>> loadReplacements(String replacementDirectory)
			throws ClassNotFoundException {
		debug("Loading all replacements defined in directory: " + replacementDirectory);
		Map<Class<?>, List<ReplacementRoot>> ret = new HashMap<Class<?>, List<ReplacementRoot>>();
		// Loop through each file in the given directory that is and xml file
		for (File fName : listFilesRecursively(new File(replacementDirectory), xmlFileFilter)) {
			// Turn each file into a ReplacementRoot
			trace("Parsing file into replacement object:" + fName.getAbsolutePath());
			ReplacementRoot root = null;
			try {
				root = new ReplacementRoot(fName.getAbsolutePath());
			} catch (FileNotFoundException e) {
				warn("Failed to parse ReplRoot file because : " + e.getMessage());
				continue;
			}
			List<ReplacementRoot> toAddTo;
			// Now we sort the Replacement files by the class they represent
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

	private final FileFilter xmlFileFilter = new FileFilter() {
		@Override
		public boolean accept(File pathname) {
			return pathname.getName().endsWith("xml");
		}
	};

	/**
	 * This will list all files in the given directory that match the given filter
	 * 
	 * @param root
	 *            the directory to look in
	 * @param filter
	 *            the filter to apply
	 * @return a list of files that match the given filter
	 */
	private static List<File> listFilesRecursively(File root, FileFilter filter) {
		List<File> ret = new ArrayList<File>();
		if (root.isFile()) {
			if (filter.accept(root)) {
				// if the root is a single file, just return a list containing the single file
				ret.add(root);
			}
			return ret;
		} else {
			// otherwise we will add the files in the directory if they are regular files
			File[] files = root.listFiles();
			for (File f : files) {
				if (f.isFile() && filter.accept(f)) {
					ret.add(f);
				} else {
					// or we will recursively add more files
					ret.addAll(listFilesRecursively(f, filter));
				}
			}
			return ret;
		}
	}

	/**
	 * Gets all of the model objects from a given Schema url
	 * 
	 * @return the Model objects for a given schema.
	 */
	public List<DTO> getAllModelItems() {
		return dtos;
	}

	/**
	 * @return the object representing all of the services of a given smd
	 */
	public SMDDescriptor getServices() {
		return smd;
	}

	/**
	 * Generates code from the supplied SMD, DTOs, Replacement files, Template files, and desired
	 * package location
	 * 
	 * @param packageName
	 *            the name of the package you are generating. Can be a namespace or other grouping
	 * @param saveLocation
	 *            the root folder to save your files
	 * @throws JsonIOException
	 * @throws JsonSyntaxException
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	public void createPackage(String saveLocation) throws IOException {
		// Process all replacements that go with services
		List<ReplacementRoot> serviceReplacements = this.replacements.get(getServices().getClass());
		if (serviceReplacements == null) {
			error(new FileNotFoundException("No replacement templates for service methods were found: "
					+ replacementDir));
		}
		for (ReplacementRoot repl : serviceReplacements) {
			debug("Processing replacement file: " + repl.getInitialLocation());
			TemplateFiller filler = new TemplateFiller(repl);
			filler.saveToFile(saveLocation, getServices());
		}

		debug("Beginning processing of all dto template replacements");
		// Process all replacements that go with each DTO
		for (DTO dto : getAllModelItems()) {
			List<ReplacementRoot> dtoReplacements = this.replacements.get(dto.getClass());
			if (dtoReplacements == null) {
				error(new FileNotFoundException("No replacement templates were found for the dtos: " + replacementDir));
			}
			for (ReplacementRoot repl : dtoReplacements) {
				trace("Processing replacement file: " + repl.getInitialLocation());
				TemplateFiller filler = new TemplateFiller(repl);
				filler.saveToFile(saveLocation, dto);
			}
		}
	}
}
