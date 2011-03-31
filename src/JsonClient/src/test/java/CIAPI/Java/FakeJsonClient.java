package CIAPI.Java;

import JsonClient.Java.ApiException;
import JsonClient.Java.JsonClient;

public class FakeJsonClient implements JsonClient {

	private RequestTranslator translator;

	/**
	 * Creates a new FakeJsonClient that uses the given request translator to
	 * make its responses
	 * 
	 * @param translator
	 */
	public FakeJsonClient(RequestTranslator translator) {
		this.translator = translator;
	}

	/**
	 * Creates a fake JSON client that simply returns JSON objects representing
	 * the request data
	 */
	public FakeJsonClient() {
		this(new RequestTranslator() {
			@Override
			public Object translatePostRequest(String url, Object content, Class<?> clazz) {
				if (clazz != String.class)
					throw new UnsupportedOperationException("Can only retrieve strings.");
				return "{" + "url:" + url + "," + "content:" + content.toString() + "," + "clazz:" + clazz.getName()
						+ "}";
			}

			@Override
			public Object translateGetRequest(String url, Class<?> clazz) {
				if (clazz != String.class)
					throw new UnsupportedOperationException("Can only retrieve strings.");
				return "{" + "url:" + url + "," + "clazz:" + clazz.getName() + "}";
			}
		});
	}

	@Override
	public Object makeGetRequest(String url, Class<?> clazz) throws ApiException {
		return translator.translateGetRequest(url, clazz);
	}

	@Override
	public Object makePostRequest(String url, Object content, Class<?> clazz) throws ApiException {
		return translator.translatePostRequest(url, content, clazz);
	}
}
