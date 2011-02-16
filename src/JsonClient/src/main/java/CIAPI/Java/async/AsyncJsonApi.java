package CIAPI.Java.async;

import java.util.ArrayList;
import java.util.List;
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

	private List<CallBack> universalCallBacks;

	/**
	 * Creates a new AsyncJsonApi with a given JsonClient and base Url.
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
		universalCallBacks = new ArrayList<CallBack>();
	}

	/**
	 * Gets an instance of an Api call. Will add all of the universal call backs
	 * to the new call.
	 * 
	 * @param methodName
	 *            the name of the method to call.
	 * 
	 * @return a new ApiCall object that will allow you to add events to it.
	 */
	public AsyncApiCall createNewCall(String methodName) {
		AsyncApiCall call = new AsyncApiCall(baseUrl, methodName, client, exec);
		for (CallBack cb : universalCallBacks) {
			call.addCallCompleteListener(cb);
		}
		return call;
	}

	/**
	 * Adds a new call back to add to all new calls.
	 * 
	 * @param cb
	 *            the callback to add to all new api calls
	 */
	public void addUniversalCallBack(CallBack cb) {
		universalCallBacks.add(cb);
	}
}
