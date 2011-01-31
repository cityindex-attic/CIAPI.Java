package CIAPI.Java.throttle;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

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
	private BlockingQueue<HttpRequestItem> requests;

	private Thread theWork;
	private boolean stop = false;

	/**
	 * Creates a new request queue. Will not process requests until start is
	 * called.
	 */
	public RequestQueue() {
		requests = new ArrayBlockingQueue<HttpRequestItem>(1);
		Runnable processThread = new Runnable() {
			@Override
			public void run() {
				while (!stop) {
					try {
						HttpRequestItem request = requests.take();
						if (request == null)
							continue;
						synchronized (request) {
							request.makeRequest();
							request.notifyAll();
						}
					} catch (ClientProtocolException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		theWork = new Thread(processThread);
		theWork.setDaemon(true);
		theWork.start();
	}

	/**
	 * Adds a new item to the queue to be processed
	 * 
	 * @param request
	 *            the request to process
	 * @throws InterruptedException
	 */
	public void add(HttpRequestItem request) throws InterruptedException {
		synchronized (request) {
			requests.put(request);
			while (!request.isComplete()) {
				request.wait();
			}
		}
	}
}
