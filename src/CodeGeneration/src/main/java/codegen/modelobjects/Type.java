package codegen.modelobjects;

import static CIAPI.Java.logging.Log.debug;
import static CIAPI.Java.logging.Log.error;
import static CIAPI.Java.logging.Log.info;
import static CIAPI.Java.logging.Log.trace;
import static CIAPI.Java.logging.Log.warn;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public class Type {
	private String $ref;

	public String get$ref() {
		return $ref;
	}
	public static JsonDeserializer<Type> getDeSerializer() {
		return new DeSerializer();
	}
	static class DeSerializer implements JsonDeserializer<Type> {
		@Override
		public Type deserialize(JsonElement json, java.lang.reflect.Type typeOfT, JsonDeserializationContext context)
				throws JsonParseException {
			Gson g = new Gson();
			trace("Custom deserializing a type");
			if (json.isJsonPrimitive()) {
				Type t = new Type();
				t.$ref = json.getAsString();
				return t;
			} else {
				return g.fromJson(json, Type.class);
			}
		}
	}
}
