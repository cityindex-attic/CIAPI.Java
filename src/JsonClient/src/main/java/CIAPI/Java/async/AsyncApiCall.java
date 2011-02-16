package CIAPI.Java.async;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import CIAPI.Java.ApiException;
import CIAPI.Java.JsonClient;
import CIAPI.Java.urlstuff.UrlHelper;

/**
 * Class representing a single async call to the api
 * 
 * @author Justin Nelson
 * 
 */
public class AsyncApiCall {

	private String baseUrl;
	private JsonClient client;
	private ExecutorService exec;

	private List<CallBack> callBaks;
	private Future<Object> future;

	private boolean done;
	private boolean started;

	protected AsyncApiCall(String baseUrl, JsonClient client, ExecutorService exec) {
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
	 * Method for starting a call to a JsonApi
	 * 
	 * @param methodName
	 *            The name of the method you are calling. If calling hte base
	 *            ulr, leave the name blank
	 * @param parameters
	 *            The parameters being passed into the method
	 * @param returnType
	 *            The type this method will return
	 * @return A future that will hold the result of the computation
	 */
	public synchronized Future<Object> beginCallGetMethod(final String methodName,
			final Map<String, String> parameters, final Class<?> returnType) {
		if (started)
			throw new IllegalStateException("Cannot call more than once.");
		started = true;
		future = exec.submit(new Callable<Object>() {
			@Override
			public Object call() throws Exception {
				String url = new UrlHelper(baseUrl, methodName, parameters).toUrl();
				Object result = client.makeGetRequest(url, returnType);
				done = true;
				return result;
			}
		});
		listenForDone();
		return future;
	}

	/**
	 * Method for starting a call to a JsonApi
	 * 
	 * @param methodName
	 *            The name of the method you are calling. If calling hte base
	 *            ulr, leave the name blank
	 * @param parameters
	 *            The parameters being passed into the method
	 * @param inputData
	 *            the data to pass into the POST method
	 * @param returnType
	 *            The type this method will return
	 * @return A future that will hold the result of the computation
	 */
	public synchronized Future<Object> beginCallPostMethod(final String methodName,
			final Map<String, String> parameters, final Object inputData, final Class<?> returnType) {
		if (started)
			throw new IllegalStateException("Cannot call more than once.");
		started = true;
		future = exec.submit(new Callable<Object>() {
			@Override
			public Object call() throws Exception {
				String url = new UrlHelper(baseUrl, methodName, parameters).toUrl();
				Object result = client.makePostRequest(url, inputData, returnType);
				done = true;
				return result;
			}
		});
		listenForDone();
		return future;
	}

	private void listenForDone() {
		Thread doneListener = new Thread(new Runnable() {
			@Override
			public void run() {
				for (CallBack cb : callBaks) {
					try {
						cb.doCallBack(future.get());
					} catch (Exception e) {
						cb.handleException(e);
					}
				}
			}
		});
		doneListener.setDaemon(true);
		doneListener.start();
	}
}
