package modelobjects;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class Parameter {

	private String type;
	private String description;
	private int minLength;
	private int maxLength;
	private JsonElement default_;
	private boolean required;

	public String getType() {
		return type;
	}

	public String getDescription() {
		return description;
	}

	public int getMinLength() {
		return minLength;
	}

	public int getMaxLength() {
		return maxLength;
	}

	public JsonElement getDefault(){
		return default_;
	}
	
	public static JsonDeserializer<Parameter> getDeSerializer(){
		return new DeSerializer();
	}
	
	static class DeSerializer implements JsonDeserializer<Parameter> {
		@Override
		public Parameter deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
				throws JsonParseException {
			Gson g = new Gson();
			Parameter ret = g.fromJson(json, Parameter.class);
			JsonObject obj = json.getAsJsonObject();
			ret.default_ = obj.get("default");
			return ret;
		}
	}
}
