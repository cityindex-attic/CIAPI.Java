package codegen.modelobjects;

import static CIAPI.Java.logging.Log.debug;
import static CIAPI.Java.logging.Log.error;
import static CIAPI.Java.logging.Log.info;
import static CIAPI.Java.logging.Log.trace;
import static CIAPI.Java.logging.Log.warn;

import codegen.gson.GsonHelper;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public class Type {
	private String $ref;

	public String get$ref() {
		return $ref;
	}

	@Override
	public String toString() {
		return convertJsonTypeToJavaType(get$ref());
	}

	public static JsonDeserializer<Type> getDeSerializer() {
		return new DeSerializer();
	}

	private static String convertJsonTypeToJavaType(String type) {
		if (type.equals("string"))
			return "String";
		else if (type.equals("number")) {
			return "double";
		} else if (type.equals("integer")) {
			return "int";
		} else if (type.equals("boolean")) {
			return "boolean";
		} else {
			return type;
		}
	}

	static class DeSerializer implements JsonDeserializer<Type> {
		@Override
		public Type deserialize(JsonElement json,
				java.lang.reflect.Type typeOfT,
				JsonDeserializationContext context) throws JsonParseException {
			Gson g = GsonHelper.gson(Type.class);
			if (json.isJsonPrimitive()) {
				Type t = new Type();
				t.$ref = json.getAsString();
				return t;
			} else if (json.isJsonArray()) {
				g = GsonHelper.gson();
				JsonArray arr = json.getAsJsonArray();
				Type t = g.fromJson(arr.get(1), Type.class);
				return t;
			} else {
				Type t = g.fromJson(json, Type.class);
				return t;
			}
		}
	}
}
