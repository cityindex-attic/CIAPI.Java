package JsonClient.Java.httpstuff;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.client.ClientProtocolException;

/**
 * A very simple Http client for making GET and POST requests to a URL.
 * 
 * @author justin nelson
 * 
 */
public class DefaultSimpleHttpClient implements SimpleHttpClient {

	HttpRequestItemFactory factory = new DefaultHttpRequestItemFactory();
	
	@Override
	public InputStream makeGetRequest(String url) throws ClientProtocolException, IOException {
		if (url == null)
			throw new NullPointerException("The url cannot be null");
		HttpGetRequestItem request = factory.getHttpGetRequestItem(url);
		request.makeRequest();
		return request.getResult();
	}

	@Override
	public InputStream makePostRequest(String url, String content) throws ClientProtocolException, IOException {
		if (url == null)
			throw new NullPointerException("The url cannot be null");
		HttpPostRequestItem request = factory.getHttpPostRequestItem(url, content);
		request.makeRequest();
		return request.getResult();
	}
}
