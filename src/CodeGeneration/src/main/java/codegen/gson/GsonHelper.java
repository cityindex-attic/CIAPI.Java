package codegen.gson;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import codegen.modelobjects.DTO;
import codegen.modelobjects.Parameter;
import codegen.modelobjects.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;

public class GsonHelper {
	private static Map<Class<?>, JsonDeserializer<?>> customs;

	static {
		customs = new HashMap<Class<?>, JsonDeserializer<?>>();
		customs.put(DTO.class, DTO.getDeSerializer());
		customs.put(Parameter.class, Parameter.getDeSerializer());
		customs.put(Type.class, Type.getDeSerializer());
	}

	public static Gson gson() {
		return gson(null);
	}

	public static Gson gson(Class<?> exception) {
		GsonBuilder gb = new GsonBuilder();
		for (Entry<Class<?>, JsonDeserializer<?>> e : customs.entrySet()) {
			if (!e.getKey().equals(exception)) {
				gb.registerTypeAdapter(e.getKey(), e.getValue());
			}
		}
		return gb.create();
	}
}
