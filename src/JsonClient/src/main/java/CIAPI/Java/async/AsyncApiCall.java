package CIAPI.Java.async;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import CIAPI.Java.ApiException;
import CIAPI.Java.JsonClient;
import CIAPI.Java.urlstuff.UrlHelper;

/**
 * Class representing a single async call to the api
 * 
 * @author justin nelson
 * 
 */
public class AsyncApiCall {

	private String baseUrl;
	private JsonClient client;
	private ExecutorService exec;

	private List<CallBack> callBaks;
	private Future<Object> future;

	private boolean done;

	protected AsyncApiCall(String baseUrl, JsonClient client, ExecutorService exec) {
		this.baseUrl = baseUrl;
		this.client = client;
		this.exec = exec;
		callBaks = new ArrayList<CallBack>();
		done = false;
	}

	/**
	 * Adds a new callback to the call
	 * 
	 * @param cb
	 */
	public void addCallCompleteListener(CallBack cb) {
		if (done)
			throw new IllegalStateException("Cannot add a call back to a call that has completed.");
		callBaks.add(cb);
	}

	private UrlHelper hlpr = new UrlHelper();

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
	 * @throws ApiException
	 */
	public Future<Object> beginCallGetMethod(final String methodName, final Map<String, String> parameters,
			final Class<?> returnType) throws ApiException {
		// TODO: Still can't handle exceptions
		future = exec.submit(new Callable<Object>() {
			@Override
			public Object call() throws Exception {
				String url = hlpr.createRoute(baseUrl, methodName, parameters);
				Object result = client.makeGetRequest(url, returnType);
				for (CallBack callBack : callBaks) {
					callBack.doCallBack(result);
				}
				done = true;
				return result;
			}
		});
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
	 * @throws ApiException
	 */
	public Future<Object> beginCallPostMethod(final String methodName, final Map<String, String> parameters,
			final Object inputData, final Class<?> returnType) throws ApiException {
		future = exec.submit(new Callable<Object>() {
			@Override
			public Object call() throws Exception {
				String url = hlpr.createRoute(baseUrl, methodName, parameters);
				Object result = client.makePostRequest(url, inputData, returnType);
				for (CallBack callBack : callBaks) {
					callBack.doCallBack(result);
				}
				done = true;
				return result;
			}
		});
		return future;
	}
}
