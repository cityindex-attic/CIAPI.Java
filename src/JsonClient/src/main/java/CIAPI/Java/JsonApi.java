package CIAPI.Java;

import java.util.Map;

import CIAPI.Java.urlstuff.UrlHelper;

/**
 * High-level JSON API
 * 
 * @author justin nelson
 * 
 */
public class JsonApi {

	private JsonClient client;
	private String baseUrl;

	/**
	 * Create a new JsonApi given a base URL for the API and the JsonClient to
	 * use.
	 * 
	 * @param baseUrl
	 *            the base url for the API
	 * @param client
	 *            the JsonCLient to pass requests to.
	 */
	public JsonApi(String baseUrl, JsonClient client) {
		this.baseUrl = baseUrl;
		this.client = client;
	}

	private UrlHelper hlpr = new UrlHelper();

	/**
	 * Call an API's GET method
	 * 
	 * @param methodName
	 *            The name of the method. Use null or "" for no method name (use
	 *            the base URL)
	 * @param parameters
	 *            the parameters for this method
	 * @param returnType
	 *            the type that this method should return
	 * @return an object of type returnType. Can safely be cast.
	 * @throws ApiException
	 *             If an error occurred during the call.
	 */
	public Object callGetMethod(String methodName, Map<String, String> parameters, Class<?> returnType)
			throws ApiException {
		String url = hlpr.createRoute(baseUrl, methodName, parameters);
		return client.makeGetRequest(url, returnType);
	}

	/**
	 * Call an API's GET method
	 * 
	 * @param methodName
	 *            The name of the method. Use null or "" for no method name (use
	 *            the base URL)
	 * @param parameters
	 *            the parameters for this method
	 * @param inputData
	 *            the data to pass into the request
	 * @param returnType
	 *            the type that this method should return
	 * @return an object of type returnType. Can safely be cast.
	 * @throws ApiException
	 *             If an error occurred during the call.
	 */
	public Object callPostMethod(String methodName, Map<String, String> parameters, Object inputData,
			Class<?> returnType) throws ApiException {
		String url = hlpr.createRoute(baseUrl, methodName, parameters);
		return client.makePostRequest(url, inputData, returnType);
	}
}
