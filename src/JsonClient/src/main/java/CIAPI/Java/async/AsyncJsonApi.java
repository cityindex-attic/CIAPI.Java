package CIAPI.Java.async;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import CIAPI.Java.JsonClient;

/**
 * Json Api for making asynchronous calls to an API.
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
	 *            the base url of the API
	 * @param client
	 *            the JsonClient to pass calls to.
	 */
	public AsyncJsonApi(String baseUrl, JsonClient client) {
		this.baseUrl = baseUrl;
		this.client = client;
		exec = new ThreadPoolExecutor(2, 20, 1, TimeUnit.HOURS, new ArrayBlockingQueue<Runnable>(50));
	}

	/**
	 * Gets an instance of an Api call.  
	 * @return a new ApiCall object that will allow you to add events to it.
	 */
	public AsyncApiCall createNewCall(){
		return new AsyncApiCall(baseUrl, client, exec);
	}
}
