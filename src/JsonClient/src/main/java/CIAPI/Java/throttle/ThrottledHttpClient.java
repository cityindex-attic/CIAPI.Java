package CIAPI.Java.throttle;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.impl.DefaultHttpRequestFactory;

import CIAPI.Java.httpstuff.DefaultHttpRequestItemFactory;
import CIAPI.Java.httpstuff.HttpGetRequestItem;
import CIAPI.Java.httpstuff.HttpPostRequestItem;
import CIAPI.Java.httpstuff.HttpRequestItemFactory;
import CIAPI.Java.httpstuff.SimpleHttpClient;

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
	 * Creates a basic throttled client.
	 */
	public ThrottledHttpClient() {
		this(new FixedWidthThrottleTimer(100), new DefaultHttpRequestItemFactory());
	}

	public ThrottledHttpClient(ThrottleTimer timer, HttpRequestItemFactory fact) {
		queue = new RequestQueue(timer);
		factory = fact;
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

	public void setHttpRequestFactory(HttpRequestItemFactory fact) {
		factory = fact;
	}
}
