package CIAPI.Java;

import java.util.Map;

import CIAPI.Java.urlstuff.UrlHelper;

public class BetterJsonClient implements JsonClient {

	private JsonClient slave;

	public BetterJsonClient(JsonClient slave) {
		this.slave = slave;
	}

	public Object makeGetRequest(String baseUrl, String extendedUrl, Map<String, String> params,
			Class<?> clazz) throws ApiException {
		return makeGetRequest(combineParts(baseUrl, extendedUrl, params), clazz);
	}

	public Object makePostRequest(String baseUrl, String extendedUrl, Map<String, String> params,
			Object content, Class<?> clazz) throws ApiException {
		return makePostRequest(combineParts(baseUrl, extendedUrl, params), content, clazz);
	}

	/**
	 * Just passes the call down to the slave
	 */
	@Override
	public Object makeGetRequest(String url, Class<?> clazz) throws ApiException {
		return slave.makeGetRequest(url, clazz);
	}

	/**
	 * Just passes the call down to the slave
	 */
	@Override
	public Object makePostRequest(String url, Object content, Class<?> clazz) throws ApiException {
		return slave.makePostRequest(url, content, clazz);
	}

	private static final UrlHelper hlpr = new UrlHelper();
	private static String combineParts(String baseUrl, String extendedUrl,
			Map<String, String> params) {
		String finalUrl = baseUrl;
		finalUrl = hlpr.urlDirCombine(finalUrl, extendedUrl);
		finalUrl += hlpr.mapToParamList(params);
		return finalUrl;
	}
}
