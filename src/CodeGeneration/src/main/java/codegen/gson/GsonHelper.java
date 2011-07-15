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

/**
 * Universal class for creating a Gson opbject.
 * 
 * @author Justin Nelson
 * 
 */
public class GsonHelper {
	private static Map<Class<?>, JsonDeserializer<?>> customs;

	static {
		customs = new HashMap<Class<?>, JsonDeserializer<?>>();
		customs.put(DTO.class, DTO.getDeSerializer());
		customs.put(Parameter.class, Parameter.getDeSerializer());
		customs.put(Type.class, Type.getDeSerializer());
	}

	/**
	 * Will retrieve a new custom Gson
	 * 
	 * @return
	 */
	public static Gson gson() {
		return gson(null);
	}

	/**
	 * Will retrieve a new custom Gson.
	 * 
	 * @param exception
	 *            this type will not have a custom handeler asigned to it
	 * @return
	 */
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
