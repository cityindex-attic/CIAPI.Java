package modelobjects;

import java.lang.reflect.Type;
import java.util.Map;
import java.util.Map.Entry;

import modelobjects.Parameter.DeSerializer;

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
		return convertJsonTypeToJavaType(type);
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

	public String toCode(String key) {
		// Enums are parsed differently
		if (enum_ != null || options != null) {
			return enumToCode(key);
		}
		String javadocComment = String.format("/**\n" + " * %s\n" + " * Auto generated Class\n" + " */\n", description);
		String classDescriptor = String.format("public class %s {\n", id);
		StringBuilder membersBuilder = new StringBuilder();
		if (properties != null) {
			for (Entry<String, Property> entry : properties.entrySet()) {
				membersBuilder.append(String.format("\tpublic %s %s\n", entry.getValue().getType(), entry.getKey()));
			}
		} else {
			System.out.println("");
		}
		String members = membersBuilder.toString();
		String classEnd = "}";
		return javadocComment + classDescriptor + members + classEnd;
	}

	private String enumToCode(String key) {
		if (enum_ == null || options == null) {
			throw new IllegalStateException("Enums must have both the 'enum' and 'options' property.");
		}
		if (options.length != enum_.length) {
			throw new IllegalStateException("The 'enum' and 'options' property must have the same length.");
		}
		String javadocComment = String.format("/**\n" + " * %s\n" + " * Auto generated Enum\n" + " */\n", description);
		String enumDescriptor = String.format("public enum %s {\n", key);
		StringBuilder itemBuilder = new StringBuilder();
		for (Option o : options) {
			itemBuilder.append("\t/**\n" + "\t * " + o.getDescription() + "\n" + "\t */\n");
			itemBuilder.append("\t" + o.getLabel() + ",\n");
		}
		String items = itemBuilder.substring(0, itemBuilder.length() - 2)+"\n";
		String enumEnd = "}";
		return javadocComment + enumDescriptor + items + enumEnd;
	}

	/**
	 * Converts a Json type into a Java type.
	 * 
	 * @param jsonType
	 * @return
	 */
	public static String convertJsonTypeToJavaType(String jsonType) {
		if (jsonType.equals("string"))
			return "String";
		else if (jsonType.equals("number")) {
			return "double";
		} else if (jsonType.equals("integer")) {
			return "int";
		} else if (jsonType.equals("boolean")) {
			return "boolean";
		} else {
			throw new IllegalArgumentException("Unexpected json type: " + jsonType);
		}
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
