package CIAPI.Java.examples.ciapi;

import java.io.UnsupportedEncodingException;

import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.DefaultHttpClient;

import CIAPI.Java.httpstuff.HttpGetRequestItem;
import CIAPI.Java.httpstuff.HttpPostRequestItem;
import CIAPI.Java.httpstuff.HttpRequestItemFactory;

/**
 * Factory that creates RequestItems that set username and password in the headders.
 * @author Justin Nelson
 *
 */
public class UsernamePasswordHttpRequestItemFactory implements HttpRequestItemFactory {

	private String username;
	private String password;

	/**
	 * Creates a new factory to set the username and password headers
	 * @param username the username to authenticate with
	 * @param password the password to authenticate with
	 */
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
