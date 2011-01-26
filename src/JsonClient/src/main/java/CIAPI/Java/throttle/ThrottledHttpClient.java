package CIAPI.Java.throttle;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.client.ClientProtocolException;

import CIAPI.Java.httpstuff.HttpGetRequestItem;
import CIAPI.Java.httpstuff.HttpPostRequestItem;
import CIAPI.Java.httpstuff.SimpleHttpClient;

public class ThrottledHttpClient implements SimpleHttpClient {

	private RequestQueue queue;

	public ThrottledHttpClient() {
		queue = new RequestQueue();
		queue.start();
	}

	@Override
	public InputStream makeGetRequest(String url) throws ClientProtocolException, IOException {
		HttpGetRequestItem request = new HttpGetRequestItem(url);
		queue.add(request);
		while (!request.isComplete()) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return request.getResult();
	}

	@Override
	public InputStream makePostRequest(String url, String content) throws ClientProtocolException, IOException {
		HttpPostRequestItem request = new HttpPostRequestItem(url, content);
		queue.add(request);
		while (!request.isComplete()) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return request.getResult();
	}
}
