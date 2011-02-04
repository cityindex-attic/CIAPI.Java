package CIAPI.Java.throttle;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.apache.http.client.ClientProtocolException;

import CIAPI.Java.httpstuff.AbstractHttpRequestItem;
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
	private BlockingQueue<AbstractHttpRequestItem> requests;

	private Thread theWork;
	private boolean stop = false;

	private ThrottleTimer timer;

	/**
	 * Creates a new request queue. Will not process requests until start is
	 * called.
	 * 
	 * @param timer
	 */
	public RequestQueue(ThrottleTimer timer) {
		if (timer == null)
			throw new NullPointerException("The timer cannot be null");
		requests = new ArrayBlockingQueue<AbstractHttpRequestItem>(100);
		this.timer = timer;
		Runnable processThread = new Runnable() {
			@Override
			public void run() {
				while (!stop) {
					try {
						Thread.sleep(RequestQueue.this.timer.timeLeft());
						HttpRequestItem request = requests.take();
						synchronized (request) {
							request.makeRequest();
							RequestQueue.this.timer.madeRequest();
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
	public void add(AbstractHttpRequestItem request) throws InterruptedException {
		if (request == null)
			throw new NullPointerException("The request cannot be null");
		synchronized (request) {
			requests.put(request);
			while (!request.isComplete()) {
				request.wait();
			}
		}
	}
}
