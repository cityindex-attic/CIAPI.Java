package CIAPI.Java;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.google.gson.Gson;

/**
 * A default implementation of JsonClient. <br />
 * Basically takes the result of a call to an Api and constructs objects to
 * return using Gson.
 * 
 * @author justin nelson
 * 
 */
public class DefaultJsonClient implements JsonClient {

	private DefaultSimpleHttpClient client;

	/**
	 * Constructs a DefaultJsonClient
	 */
	public DefaultJsonClient() {
		client = new DefaultSimpleHttpClient();
	}

	@Override
	public Object makeGetRequest(String url, Class<?> clazz) throws ApiException {
		try {
			Gson g = new Gson();
			InputStream data = client.makeGetRequest(url);
			Object result = g.fromJson(new InputStreamReader(data), clazz);
			return result;
		} catch (Exception e) {
			throw new ApiException(e);
		}
	}

	@Override
	public Object makePostRequest(String url, Object content, Class<?> clazz) throws ApiException {
		Gson g = new Gson();
		String strContent = (content instanceof String) ? (String) content : g.toJson(content);
		try {
			Scanner responseEntityData = new Scanner(client.makePostRequest(url, strContent));
			String data = "";
			while (responseEntityData.hasNextLine())
				data += responseEntityData.nextLine();
			Object result = g.fromJson(data, clazz);
			return result;
		} catch (Exception e) {
			throw new ApiException(e);
		}
	}
}