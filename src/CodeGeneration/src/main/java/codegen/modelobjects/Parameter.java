package codegen.modelobjects;

import java.lang.reflect.Type;

import codegen.gson.GsonHelper;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class Parameter extends TypedSchemaItem {

	private String name;
	private int minLength;
	private int maxLength;
	private JsonElement default_;
	private boolean required;

	public String getName() {
		return name;
	}


	public String get$ref() {
		return type.get$ref();
	}

	public int getMinLength() {
		return minLength;
	}

	public int getMaxLength() {
		return maxLength;
	}

	public JsonElement getDefaultValue() {
		return default_;
	}

	public String toCode(String packageName) {
		return getType(packageName) + " " + name;
	}

	public static JsonDeserializer<Parameter> getDeSerializer() {
		return new DeSerializer();
	}

	/**
	 * Custom deserializer. Only does the enum_ part. Otherwise just uses the
	 * Gson de serialization
	 * 
	 * @author justin nelson
	 * 
	 */
	static class DeSerializer implements JsonDeserializer<Parameter> {
		@Override
		public Parameter deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
				throws JsonParseException {
			Gson g = GsonHelper.gson(Parameter.class);
			Parameter ret = g.fromJson(json, Parameter.class);
			JsonObject obj = json.getAsJsonObject();
			ret.default_ = obj.get("default");
			return ret;
		}
	}
}
