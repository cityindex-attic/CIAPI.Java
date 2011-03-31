package JsonClient.Java.async;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import JsonClient.Java.JsonClient;
import JsonClient.Java.urlstuff.UrlHelper;

/**
 * Class representing a single async call to the api.<br />
 * Allows for you to register individual events per call.
 * 
 * @author Justin Nelson
 * 
 */
public class AsyncApiCall {

	private String baseUrl;
	private JsonClient client;
	private ExecutorService exec;

	private Map<String, String> initialParams;

	private List<CallBack> callBaks;
	private Future<Object> future;

	private boolean done;
	private boolean started;

	protected AsyncApiCall(String baseUrl, Map<String, String> initialParams,
			JsonClient client, ExecutorService exec) {
		this.baseUrl = baseUrl;
		this.client = client;
		this.initialParams = initialParams;
		this.exec = exec;
		callBaks = new ArrayList<CallBack>();
		done = false;
		started = false;
	}

	/**
	 * Adds a new callback to the call. You are allowed to add a new callback
	 * after the call has been started, but not after it is done.
	 * 
	 * @param cb
	 */
	public synchronized void addCallCompleteListener(CallBack cb) {
		if (cb == null)
			throw new NullPointerException("The call back cannot be null");
		if (done)
			throw new IllegalStateException(
					"Cannot add a call back to a call that has completed.");
		callBaks.add(cb);
	}

	public synchronized Future<Object> callGetMethod(
			final String extendedUrlPart, final Map<String, String> params,
			final Class<?> returnType) {
		UrlHelper hlpr = new UrlHelper(baseUrl, extendedUrlPart, params);
		return callGetMethod(hlpr, returnType);
	}

	public synchronized Future<Object> callGetMethod(
			final String fullSecondHalfUrl, final Class<?> returnType) {
		UrlHelper hlpr;
		try {
			hlpr = UrlHelper.parseUrl(baseUrl + "/" + fullSecondHalfUrl);
			return callGetMethod(hlpr, returnType);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		}
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
	protected synchronized Future<Object> callGetMethod(
			final UrlHelper urlHlpr, final Class<?> returnType) {
		if (started)
			throw new IllegalStateException("Cannot call more than once.");
		started = true;
		placeParamsInHlpr(urlHlpr, initialParams);
		// Submit a task to the the executor.
		future = exec.submit(new Callable<Object>() {
			@Override
			public Object call() throws Exception {
				String url = urlHlpr.toUrl();
				// synchronously make a request in another thread
				Object result = client.makeGetRequest(url, returnType);
				done = true;
				return result;
			}
		});
		// start listening for the future to complete
		listenForDone(urlHlpr.getExtendedUrl());
		return future;
	}

	public synchronized Future<Object> callPostMethod(
			final String extendedUrlPart, final Map<String, String> params,
			final Object inputData, final Class<?> returnType) {
		UrlHelper hlpr = new UrlHelper(baseUrl, extendedUrlPart, params);
		return callPostMethod(hlpr, inputData, returnType);
	}

	public synchronized Future<Object> callPostMethod(
			final String fullSecondHalfUrl, final Object inputData,
			final Class<?> returnType) {
		UrlHelper hlpr;
		try {
			hlpr = UrlHelper.parseUrl(baseUrl + "/" + fullSecondHalfUrl);
			return callPostMethod(hlpr, inputData, returnType);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Method for starting a call to a JsonApi.<br />
	 * If you want to end this method immediately, you should call the
	 * Future.get() method. This will block until the results are returned.
	 * 
	 * @param parameters
	 *            The parameters being passed into the method
	 * @param inputData
	 *            the data to pass into the POST method
	 * @param returnType
	 *            The type this method will return
	 * @return A future that will hold the result of the computation
	 */
	protected synchronized Future<Object> callPostMethod(
			final UrlHelper urlHlpr, final Object inputData,
			final Class<?> returnType) {
		if (started)
			throw new IllegalStateException("Cannot call more than once.");
		started = true;
		placeParamsInHlpr(urlHlpr, initialParams);
		// Submit a task to the the executor.
		future = exec.submit(new Callable<Object>() {
			@Override
			public Object call() throws Exception {
				String url = urlHlpr.toUrl();
				// synchronously make a request in another thread
				Object result = client.makePostRequest(url, inputData,
						returnType);
				done = true;
				return result;
			}
		});
		// start listening for the future to complete
		listenForDone(urlHlpr.getExtendedUrl());
		return future;
	}

	/**
	 * Waits for the Future to be done, and then executes the CallBacks that
	 * have been registered to the call.<br />
	 * If the method throws any exceptions, the handleException method will be
	 * called instead.
	 */
	private void listenForDone(final String methodName) {
		// New thread for the purpose of listening for a response to complete.
		Thread doneListener = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					// This call blocks until the result is calculated
					Object result = future.get();
					// Pass the result to all of the registered callbacks
					for (CallBack cb : callBaks) {
						cb.doCallBack(result, baseUrl, methodName);
					}
				} catch (Exception e) {
					// If any exceptions occur during the request the handle
					// exception method will be called on every callback.
					for (CallBack cb : callBaks) {
						cb.handleException(e);
					}
				}
			}
		});
		// We want the threads to die if all of the main threads exit.
		doneListener.setDaemon(true);
		doneListener.start();
	}

	private static void placeParamsInHlpr(UrlHelper hlpr,
			Map<String, String> paramsToAdd) {
		Map<String, String> result = hlpr.getParams();
		for (Entry<String, String> entry : paramsToAdd.entrySet()) {
			result.put(entry.getKey(), entry.getValue());
		}
		hlpr.setParams(result);
	}
}
