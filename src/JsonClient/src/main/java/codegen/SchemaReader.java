package codegen;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

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

	private String schemaUrl, smdUrl;

	public SchemaReader(String schemaUrl, String smdUrl) {
		this.schemaUrl = schemaUrl;
		this.smdUrl = smdUrl;
	}

	public Map<String, DTO> getAllRoutesItems() throws JsonIOException, JsonSyntaxException, MalformedURLException,
			IOException {
		Map<String, DTO> ret = new HashMap<String, DTO>();
		GsonBuilder gb = new GsonBuilder();
		gb.registerTypeAdapter(DTO.class, DTO.getDeSerializer());
		Gson g = gb.create();
		JsonParser parser = new JsonParser();
		JsonObject obj = (JsonObject) parser.parse(new InputStreamReader(new URL(schemaUrl).openStream()));
		for (Entry<String, JsonElement> entry : obj.entrySet()) {
			ret.put(entry.getKey(), g.fromJson(entry.getValue(), DTO.class));
		}
		return ret;
	}

	public SMDDescriptor getServices() throws JsonSyntaxException, JsonIOException, MalformedURLException, IOException {
		GsonBuilder gb = new GsonBuilder();
		gb.registerTypeAdapter(Parameter.class, Parameter.getDeSerializer());
		Gson g = gb.create();
		SMDDescriptor result = g.fromJson(new InputStreamReader(new URL(smdUrl).openStream()), SMDDescriptor.class);
		return result;
	}

	public void createPackage(String packageName, String saveLocation) throws JsonIOException, JsonSyntaxException,
			MalformedURLException, IOException {
		for (Entry<String, DTO> entry : getAllRoutesItems().entrySet()) {
			PrintStream out = new PrintStream(new File(saveLocation + File.separatorChar + entry.getKey() + ".java"));
			out.println(entry.getValue().toCode(entry.getKey(), packageName));
			out.close();
		}
		PrintStream out = new PrintStream(new File(saveLocation + File.separatorChar + "ServiceMethods" + ".java"));
		out.println(getServices().toCode(packageName));
		out.close();
	}
}
