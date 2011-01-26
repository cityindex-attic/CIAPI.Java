package CIAPI.Java;

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

	@Override
	public InputStream makeGetRequest(String url) throws ClientProtocolException, IOException {
		HttpGetRequestItem request = new HttpGetRequestItem(url);
		return request.makeRequest();
	}

	@Override
	public InputStream makePostRequest(String url, String content) throws ClientProtocolException, IOException {
		HttpPostRequestItem request = new HttpPostRequestItem(url, content);
		return request.makeRequest();
	}
}
