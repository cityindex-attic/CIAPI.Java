package CIAPI.Java.throttle;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;

import org.apache.http.client.ClientProtocolException;

import CIAPI.Java.httpstuff.HttpRequestItem;

/**
 * Queue that continually processes requests while requests are waiting. Will
 * observer a given throttle rate.
 * 
 * @author justin nelson
 * 
 */
public class RequestQueue {

	protected static final long SLEEP_TIME = 100;
	private boolean keepGoing = false;
	private Queue<HttpRequestItem> requests;

	public RequestQueue() {
		requests = new ArrayDeque<HttpRequestItem>();
		Runnable processThread = new Runnable() {
			@Override
			public void run() {
				while (true) {
					if (!keepGoing || requests.isEmpty()) {
						try {
							Thread.sleep(SLEEP_TIME);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					} else {
						HttpRequestItem request = requests.remove();
						try {
							request.makeRequest();
						} catch (ClientProtocolException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		};
		new Thread(processThread).start();
	}

	public void add(HttpRequestItem request) {
		requests.add(request);
	}

	public void start() {
		keepGoing = true;
	}

	public void stop() {
		keepGoing = false;
	}
}
