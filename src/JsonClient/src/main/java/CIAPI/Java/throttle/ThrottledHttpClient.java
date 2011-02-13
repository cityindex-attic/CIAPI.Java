package CIAPI.Java.throttle;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.client.ClientProtocolException;

import CIAPI.Java.httpstuff.HttpGetRequestItem;
import CIAPI.Java.httpstuff.HttpPostRequestItem;
import CIAPI.Java.httpstuff.SimpleHttpClient;

/**
 * An http client that will follow a specified throttle threshold.
 * 
 * @author justin nelson
 * 
 */
public class ThrottledHttpClient implements SimpleHttpClient {

	private RequestQueue queue;

	/**
	 * Creates a basic throttled client.
	 */
	public ThrottledHttpClient() {
		this(new FixedWidthThrottleTimer(100));
	}

	public ThrottledHttpClient(ThrottleTimer timer){
		queue = new RequestQueue(timer);
	}
	
	@Override
	public InputStream makeGetRequest(String url) throws ClientProtocolException, IOException {
		if (url == null)
			throw new NullPointerException("The url cannot be null");
		HttpGetRequestItem request = new HttpGetRequestItem(url);
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
		HttpPostRequestItem request = new HttpPostRequestItem(url, content);
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
