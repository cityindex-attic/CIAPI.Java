package CIAPI.Java;

import java.util.Map;

import CIAPI.Java.urlstuff.UrlHelper;

public class JsonApi {

	private JsonClient client;
	private String baseUrl;

	public JsonApi(String baseUrl, JsonClient client) {
		this.baseUrl = baseUrl;
		this.client = client;
	}

	private UrlHelper hlpr = new UrlHelper();

	public Object callGetMethod(String methodName, Map<String, String> parameters,
			Class<?> returnType) throws ApiException {
		String url = hlpr.createRoute(baseUrl, methodName, parameters);
		return client.makeGetRequest(url, returnType);
	}

	public Object callPostMethod(String methodName, Map<String, String> parameters,
			Object inputData, Class<?> returnType) throws ApiException {
		String url = hlpr.createRoute(baseUrl, methodName, parameters);
		return client.makePostRequest(url, inputData, returnType);
	}
}
