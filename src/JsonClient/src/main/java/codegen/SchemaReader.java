package codegen;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class SchemaReader {
	/**
	 * Given a DTO schema url will return all of the DTO objects
	 * 
	 * @param schemaUrl
	 * @return
	 * @throws JsonIOException
	 * @throws JsonSyntaxException
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public Map<String, DTO> getAllRoutesItems(String schemaUrl) throws JsonIOException, JsonSyntaxException,
			MalformedURLException, IOException {
		Map<String, DTO> ret = new HashMap<String, DTO>();
		Gson g = new Gson();
		JsonParser parser = new JsonParser();
		JsonObject obj = (JsonObject) parser.parse(new InputStreamReader(new URL(schemaUrl).openStream()));
		for (Entry<String, JsonElement> entry : obj.entrySet()) {
			ret.put(entry.getKey(), g.fromJson(entry.getValue(), DTO.class));
		}
		return ret;
	}
}
