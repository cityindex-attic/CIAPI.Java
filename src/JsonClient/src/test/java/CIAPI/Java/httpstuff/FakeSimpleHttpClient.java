package CIAPI.Java.httpstuff;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.client.ClientProtocolException;

import JsonClient.Java.httpstuff.SimpleHttpClient;

public class FakeSimpleHttpClient implements SimpleHttpClient {

	@Override
	public InputStream makeGetRequest(String url) throws ClientProtocolException, IOException {
		return new FakeHttpRequestItem(url).makeRequest();
	}

	@Override
	public InputStream makePostRequest(String url, String content) throws ClientProtocolException, IOException {
		return new FakeHttpRequestItem(url, content).makeRequest();
	}
}
