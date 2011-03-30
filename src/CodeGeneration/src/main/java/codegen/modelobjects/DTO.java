package codegen.modelobjects;

import java.lang.reflect.Type;
import java.util.Map;

import codegen.codecreation.DTOCreator;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class DTO {

	private String id;
	private String type;
	private String description;
	private Map<String, Property> properties;
	private int[] enum_;
	private Option[] options;

	public String getId() {
		return id;
	}

	public String getType() {
		return DTOCreator.convertJsonTypeToJavaType(type);
	}

	public String getRawType() {
		return type;
	}

	public String getDescription() {
		return description;
	}

	public Map<String, Property> getProperties() {
		return properties;
	}

	public int[] getEnum_() {
		return enum_;
	}

	public Option[] getOptions() {
		return options;
	}

	public static JsonDeserializer<DTO> getDeSerializer() {
		return new DeSerializer();
	}

	static class DeSerializer implements JsonDeserializer<DTO> {
		@Override
		public DTO deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
				throws JsonParseException {
			Gson g = new Gson();
			DTO ret = g.fromJson(json, DTO.class);
			JsonObject obj = json.getAsJsonObject();
			JsonElement enumElem = obj.get("enum");
			if (enumElem != null) {
				ret.enum_ = jsonArrTOJavaintArr(enumElem.getAsJsonArray());
			}
			return ret;
		}

		private int[] jsonArrTOJavaintArr(JsonArray arr) {
			int[] ret = new int[arr.size()];
			for (int i = 0; i < arr.size(); i++) {
				ret[i] = arr.get(i).getAsInt();
			}
			return ret;
		}
	}
}
