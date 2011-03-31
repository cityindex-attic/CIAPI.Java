package JsonClient.Java.throttle;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.client.ClientProtocolException;

import JsonClient.Java.httpstuff.DefaultHttpRequestItemFactory;
import JsonClient.Java.httpstuff.HttpGetRequestItem;
import JsonClient.Java.httpstuff.HttpPostRequestItem;
import JsonClient.Java.httpstuff.HttpRequestItemFactory;
import JsonClient.Java.httpstuff.SimpleHttpClient;

/**
 * An http client that will follow a specified throttle threshold.
 * 
 * @author justin nelson
 * 
 */
public class ThrottledHttpClient implements SimpleHttpClient {
	private HttpRequestItemFactory factory;
	private RequestQueue queue;

	/**
	 * Creates a basic throttled client. Uses a FixedWidthThrottleTimer and
	 * DefaultHttpRequestItemFactory
	 */
	public ThrottledHttpClient() {
		this(new DefaultHttpRequestItemFactory(), new RequestQueue(new FixedWidthThrottleTimer(100)));
	}

	/**
	 * Creates a basic throttled client.
	 * 
	 * @param fact
	 *            the given fact
	 */
	public ThrottledHttpClient(HttpRequestItemFactory fact, RequestQueue queue) {
		this.queue = queue;
		this.factory = fact;
	}

	@Override
	public InputStream makeGetRequest(String url) throws ClientProtocolException, IOException {
		if (url == null)
			throw new NullPointerException("The url cannot be null");
		HttpGetRequestItem request = factory.getHttpGetRequestItem(url);
		try {
			queue.add(request);
		} catch (InterruptedException e) {
			e.printStackTrace();
			// retry once
			try {
				queue.add(request);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		return request.getResult();
	}

	@Override
	public InputStream makePostRequest(String url, String content) throws ClientProtocolException, IOException {
		if (url == null)
			throw new NullPointerException("The url cannot be null");
		HttpPostRequestItem request = factory.getHttpPostRequestItem(url, content);
		try {
			queue.add(request);
		} catch (InterruptedException e) {
			e.printStackTrace();
			// retry once
			try {
				queue.add(request);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		return request.getResult();
	}
}
