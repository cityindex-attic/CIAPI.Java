package CIAPI.Java.examples.ciapi;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import CIAPI.Java.ApiException;
import CIAPI.Java.DefaultJsonClient;
import CIAPI.Java.async.AsyncApiCall;
import CIAPI.Java.async.AsyncJsonApi;
import CIAPI.Java.async.CallBack;
import CIAPI.Java.cachestuff.CachedJsonClient;
import CIAPI.Java.cachestuff.DefaultCache;
import CIAPI.Java.examples.ciapi.dto.CILogOnOrOffRequest;
import CIAPI.Java.examples.ciapi.dto.CreateSessionResponse;
import CIAPI.Java.examples.ciapi.dto.DeleteSessionResponse;
import CIAPI.Java.logging.Log;
import CIAPI.Java.throttle.RequestsPerTimespanTimer;
import CIAPI.Java.throttle.ThrottledHttpClient;

public class AsyncApi {
	private final String Api_Base_Url = "http://174.129.8.69/TradingApisession";

	private AsyncJsonApi api;

	private String username;
	private String password;
	private String sessionId;

	private List<CallBack> universalCallBacks;

	/**
	 * Creates a new API to access the trading API. It will use the username and
	 * password you supply it. This does not automatically log a user in.
	 * 
	 * @param username
	 *            the username to authenticate with
	 * @param password
	 *            the password to authenticate with
	 * @param universalCallBacks
	 *            These callbacks will be called everytime a method is called.
	 *            This can be used for logging or similar tasks.
	 * @throws ApiException
	 */
	public AsyncApi(String username, String password, List<CallBack> universalCallBacks) throws ApiException {
		// null check to make sure we blow up when the error actually happens
		// instead of later in the code
		if (username == null)
			throw new NullPointerException("The username must not be null");
		if (password == null)
			throw new NullPointerException("The password must not be null");
		this.username = username;
		this.password = password;
		// if the list is null, substitute an empty list
		this.universalCallBacks = universalCallBacks == null ? new ArrayList<CallBack>() : universalCallBacks;
		// Add a logging callback
		this.universalCallBacks.add(new CallBack() {
			private int count = 0;

			@Override
			public void doCallBack(Object result, String baseUrl, String methodName) {
				Log.debug("Made async request. Count: " + ++count);
			}
		});
	}

	/**
	 * Uses the username and password supplied in the constructor to log on to
	 * the CIAPI.
	 * 
	 * @return The Future associated with this call. If you want the response
	 *         immediately, call Future.get().
	 * 
	 * @throws ApiException
	 */
	public Future<Object> logon() throws ApiException {
		AsyncJsonApi unAuth = new AsyncJsonApi(Api_Base_Url, new DefaultJsonClient());
		AsyncApiCall call = unAuth.createNewCall("");
		call.addCallCompleteListener(new CallBack() {
			@Override
			public void doCallBack(Object result, String baseUrl, String methodName) {
				CreateSessionResponse session = (CreateSessionResponse) result;
				sessionId = session.getSession();
				ThrottledHttpClient client = new ThrottledHttpClient(new RequestsPerTimespanTimer(10, 1000),
						new UsernameSessionHttpRequestItemFactory(username, sessionId));
				api = new AsyncJsonApi(Api_Base_Url, new CachedJsonClient(
						new DefaultCache<CachedJsonClient.Pair<String, Class<?>>, Object>(1000 * 60), client));
				for (CallBack cb : universalCallBacks)
					api.addUniversalCallBack(cb);
			}
		});
		return call.callPostMethod(null, new CILogOnOrOffRequest(username, password), CreateSessionResponse.class);
	}

	/**
	 * Deletes the session token to essentially log a user off. If you want the
	 * response immediately, call Future.get().
	 * 
	 * @return
	 * 
	 * @throws ApiException
	 */
	public Future<Object> logoff() throws ApiException {
		AsyncApiCall call = api.createNewCall("deleteSession");
		call.addCallCompleteListener(new CallBack() {
			@Override
			public void doCallBack(Object result, String baseUrl, String methodName) {
				DeleteSessionResponse resp = (DeleteSessionResponse) result;
				if (resp == null) throw new NullPointerException();
				// Nothing to do here.
			}
		});
		return call.callPostMethod(null, new CILogOnOrOffRequest(username, password), DeleteSessionResponse.class);
	}
}
