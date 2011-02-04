package CIAPI.Java.httpstuff;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;

/**
 * An object for making a Get request
 * 
 * @author justin nelson
 * 
 */
public class HttpGetRequestItem extends AbstractHttpRequestItem {

	/**
	 * @param url
	 *            the url to make the request to
	 */
	public HttpGetRequestItem(String url) {
		super(url);
	}

	@Override
	protected HttpRequestBase getRequestItem(String url) {
		return new HttpGet(url);
	}
}
