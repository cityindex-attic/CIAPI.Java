package CIAPI.Java;

import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import CIAPI.Java.async.CallBack;
import CIAPI.Java.urlstuff.UrlHelper;

/**
 * Json Api for making asynchronous calls to an API
 * 
 * @author justin nelson
 * 
 */
public class AsyncJsonApi {

	private JsonClient client;
	private String baseUrl;
	private ExecutorService exec;

	/**
	 * Creates a new AsyncJsonApi with a given JsonClient and base Url
	 * 
	 * @param baseUrl
	 *            the base url of hte API
	 * @param client
	 *            the JsonClient to pass calls to.
	 */
	public AsyncJsonApi(String baseUrl, JsonClient client) {
		this.baseUrl = baseUrl;
		this.client = client;
		exec = new ThreadPoolExecutor(2, 20, 1, TimeUnit.HOURS, new ArrayBlockingQueue<Runnable>(50));
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
	 * @param callback
	 *            the code to be ran after this method executes
	 * @return A future that will hold the result of the computation
	 * @throws ApiException
	 */
	public Future<Object> beginCallGetMethod(final String methodName, final Map<String, String> parameters,
			final Class<?> returnType, final CallBack callback) throws ApiException {
		FutureTask<Object> future = new FutureTask<Object>(new Callable<Object>() {
			@Override
			public Object call() throws Exception {
				String url = hlpr.createRoute(baseUrl, methodName, parameters);
				Object result = client.makeGetRequest(url, returnType);
				callback.doCallBack(result);
				return result;
			}
		});
		// TODO Need a way to handle exceptions
		exec.execute(future);
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
	 * @param callback
	 *            the code to be ran after this method executes
	 * @return A future that will hold the result of the computation
	 * @throws ApiException
	 */
	public Future<Object> beginCallPostMethod(final String methodName, final Map<String, String> parameters,
			final Object inputData, final Class<?> returnType, final CallBack callback) throws ApiException {
		FutureTask<Object> future = new FutureTask<Object>(new Callable<Object>() {
			@Override
			public Object call() throws Exception {
				String url = hlpr.createRoute(baseUrl, methodName, parameters);
				Object result = client.makePostRequest(url, inputData, returnType);
				callback.doCallBack(result);
				return result;
			}
		});
		exec.execute(future);
		return future;
	}
}
