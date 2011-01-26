package CIAPI.Java.throttle;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.client.ClientProtocolException;

import CIAPI.Java.SimpleHttpClient;

public class ThrottledHttpClient implements SimpleHttpClient {
	
	@Override
	public InputStream makeGetRequest(String url) throws ClientProtocolException, IOException {
		return null;
	}

	@Override
	public InputStream makePostRequest(String url, String content) throws ClientProtocolException, IOException {
		return null;
	}
}
