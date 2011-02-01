package CIAPI.Java;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

import CIAPI.Java.httpstuff.DefaultSimpleHttpClient;
import CIAPI.Java.httpstuff.SimpleHttpClient;

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

	private SimpleHttpClient client;

	/**
	 * Constructs a DefaultJsonClient. Uses a DefaultSimpleHttpClient for making
	 * requests.
	 */
	public DefaultJsonClient() {
		this(new DefaultSimpleHttpClient());
	}

	/**
	 * Creates a DefaultJsonClient with the given SimpleHttpClient for making
	 * requests.
	 * 
	 * @param httpClient
	 *            the client to pass requests to.
	 */
	public DefaultJsonClient(SimpleHttpClient httpClient) {
		if (httpClient == null)
			throw new NullPointerException("THe simple http client must not be null");
		client = httpClient;
	}

	@Override
	public Object makeGetRequest(String url, Class<?> clazz) throws ApiException {
		if (url == null || url.trim().length() == 0)
			throw new IllegalArgumentException("The url must not be null or empty");
		if (clazz == null)
			throw new NullPointerException("The clazz must not be null");
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
		if (url == null || url.trim().length() == 0)
			throw new IllegalArgumentException("The url must not be null or empty");
		if (clazz == null)
			throw new NullPointerException("The clazz must not be null");
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
