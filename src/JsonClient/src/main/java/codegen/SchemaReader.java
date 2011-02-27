package codegen;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import modelobjects.DTO;
import modelobjects.Parameter;
import modelobjects.SMDDescriptor;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class SchemaReader {

	public Map<String, DTO> getAllRoutesItems(String schemaUrl) throws JsonIOException, JsonSyntaxException,
			MalformedURLException, IOException {
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

	public SMDDescriptor getServices(String smdUrl) throws JsonSyntaxException, JsonIOException, MalformedURLException,
			IOException {
		GsonBuilder gb = new GsonBuilder();
		gb.registerTypeAdapter(Parameter.class, Parameter.getDeSerializer());
		Gson g = gb.create();
		SMDDescriptor result = g.fromJson(new InputStreamReader(new URL(smdUrl).openStream()), SMDDescriptor.class);
		return result;
	}
}
