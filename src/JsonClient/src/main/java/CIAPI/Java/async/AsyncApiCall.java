package CIAPI.Java.async;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import CIAPI.Java.JsonClient;
import CIAPI.Java.urlstuff.UrlHelper;

/**
 * Class representing a single async call to the api.<br />
 * Allows for you to register individual events per call. 
 * 
 * @author Justin Nelson
 * 
 */
public class AsyncApiCall {

	private String baseUrl;
	private String methodName;
	private JsonClient client;
	private ExecutorService exec;

	private List<CallBack> callBaks;
	private Future<Object> future;

	private boolean done;
	private boolean started;

	protected AsyncApiCall(String baseUrl, String methodName, JsonClient client, ExecutorService exec) {
		this.baseUrl = baseUrl;
		this.client = client;
		this.exec = exec;
		callBaks = new ArrayList<CallBack>();
		done = false;
		started = false;
	}

	/**
	 * Adds a new callback to the call
	 * 
	 * @param cb
	 */
	public void addCallCompleteListener(CallBack cb) {
		if (cb == null)
			throw new NullPointerException("The call back cannot be null");
		if (done)
			throw new IllegalStateException("Cannot add a call back to a call that has completed.");
		callBaks.add(cb);
	}

	/**
	 * Method for starting a call to a JsonApi. <br />
	 * If you want to end this method immediately, you should call the
	 * Future.get() method. This will block until the results are returned.
	 * 
	 * @param parameters
	 *            The parameters being passed into the method
	 * @param returnType
	 *            The type this method will return
	 * @return A future that will hold the result of the computation
	 */
	public synchronized Future<Object> beginCallGetMethod(final Map<String, String> parameters, final Class<?> returnType) {
		if (started)
			throw new IllegalStateException("Cannot call more than once.");
		started = true;
		future = exec.submit(new Callable<Object>() {
			@Override
			public Object call() throws Exception {
				String url = new UrlHelper(baseUrl, methodName, parameters).toUrl();
				// synchronously make a request in another thread
				Object result = client.makeGetRequest(url, returnType);
				done = true;
				return result;
			}
		});
		// start listening for the future to complete
		listenForDone();
		return future;
	}

	/**
	 * Method for starting a call to a JsonApi
	 * 
	 * @param parameters
	 *            The parameters being passed into the method
	 * @param inputData
	 *            the data to pass into the POST method
	 * @param returnType
	 *            The type this method will return
	 * @return A future that will hold the result of the computation
	 */
	public synchronized Future<Object> beginCallPostMethod(final Map<String, String> parameters, final Object inputData, final Class<?> returnType) {
		if (started)
			throw new IllegalStateException("Cannot call more than once.");
		started = true;
		future = exec.submit(new Callable<Object>() {
			@Override
			public Object call() throws Exception {
				String url = new UrlHelper(baseUrl, methodName, parameters).toUrl();
				// synchronously make a request in another thread
				Object result = client.makePostRequest(url, inputData, returnType);
				done = true;
				return result;
			}
		});
		// start listening for the future to complete
		listenForDone();
		return future;
	}

	/**
	 * Waits for the Future to be done, and then executes the CallBacks that
	 * have been registered to the call.<br />
	 * If the method throws any exceptions, the handleException method will be
	 * called instead.
	 */
	private void listenForDone() {
		Thread doneListener = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					// This call blocks until the result is calculated
					Object result = future.get();
					for (CallBack cb : callBaks) {
						cb.doCallBack(result);
					}
				} catch (Exception e) {
					for (CallBack cb : callBaks) {
						cb.handleException(e);
					}
				}
			}
		});
		doneListener.setDaemon(true);
		doneListener.start();
	}
}
