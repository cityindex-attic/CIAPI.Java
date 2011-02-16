package CIAPI;

import java.io.UnsupportedEncodingException;

import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.DefaultHttpClient;

import CIAPI.Java.httpstuff.HttpGetRequestItem;
import CIAPI.Java.httpstuff.HttpPostRequestItem;
import CIAPI.Java.httpstuff.HttpRequestItemFactory;

public class UsernamePasswordHttpRequestItemFactory implements HttpRequestItemFactory {

	private String username;
	private String password;

	public UsernamePasswordHttpRequestItemFactory(String username, String password) {
		this.username = username;
		this.password = password;
	}

	@Override
	public HttpPostRequestItem getHttpPostRequestItem(String url, String content) throws UnsupportedEncodingException {
		return new HttpPostRequestItem(url, content) {
			@Override
			protected void beforeRequest(HttpRequestBase requestMethod, DefaultHttpClient httpClient) {
				super.beforeRequest(requestMethod, httpClient);
				requestMethod.addHeader("username", username);
				requestMethod.addHeader("password", password);
			}
		};
	}

	@Override
	public HttpGetRequestItem getHttpGetRequestItem(String url) {
		return new HttpGetRequestItem(url) {
			@Override
			protected void beforeRequest(HttpRequestBase requestMethod, DefaultHttpClient httpClient) {
				super.beforeRequest(requestMethod, httpClient);
				requestMethod.addHeader("username", username);
				requestMethod.addHeader("password", password);
			}
		};
	}
}
