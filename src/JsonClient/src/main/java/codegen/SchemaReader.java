package codegen;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import codegen.codecreation.DTOCreator;
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
 * Given urls, will create DTO objects and Service objects that can be turned
 * into code. <br />
 * 
 * @author Justin Nelson
 * 
 */
public class SchemaReader {

	private SMDDescriptor smd;
	private Map<String, DTO> dtos;

	/**
	 * Creates a new schema reader with the given schema and smd url.
	 * 
	 * @param schemaStream
	 *            the stream containing the schema data
	 * @param smdStream
	 *            the stream containing the smd data
	 */
	public SchemaReader(InputStream schemaStream, InputStream smdStream) {
		dtos = new HashMap<String, DTO>();
		GsonBuilder gb = new GsonBuilder();
		gb.registerTypeAdapter(DTO.class, DTO.getDeSerializer());
		gb.registerTypeAdapter(Parameter.class, Parameter.getDeSerializer());
		Gson g = gb.create();
		JsonParser parser = new JsonParser();
		JsonObject obj = (JsonObject) parser.parse(new InputStreamReader(schemaStream));
		for (Entry<String, JsonElement> entry : obj.entrySet()) {
			dtos.put(entry.getKey(), g.fromJson(entry.getValue(), DTO.class));
		}
		smd = g.fromJson(new InputStreamReader(smdStream), SMDDescriptor.class);
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
	 * Generates all methods an model objects for a given pair of smd and schema
	 * url.
	 * 
	 * @param packageName
	 * @param saveLocation
	 * @throws JsonIOException
	 * @throws JsonSyntaxException
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public void createPackage(String packageName, String saveLocation) throws JsonIOException, JsonSyntaxException,
			MalformedURLException, IOException {
		for (Entry<String, DTO> entry : getAllModelItems().entrySet()) {
			PrintStream out = new PrintStream(new File(saveLocation + File.separatorChar + entry.getKey() + ".java"));
			out.println(new DTOCreator(entry.getKey(), entry.getValue(), packageName).toCode());
			out.close();
		}
		PrintStream out = new PrintStream(new File(saveLocation + File.separatorChar + "ServiceMethods" + ".java"));
		out.println(getServices().toCode(packageName));
		out.close();
	}
}
