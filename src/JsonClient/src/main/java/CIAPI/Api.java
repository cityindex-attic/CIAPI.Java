package CIAPI;

import CIAPI.Java.ApiException;
import CIAPI.Java.DefaultJsonClient;
import CIAPI.Java.JsonApi;
import CIAPI.Java.cachestuff.CachedJsonClient;
import CIAPI.Java.cachestuff.DefaultCache;
import CIAPI.Java.httpstuff.DefaultSimpleHttpClient;
import CIAPI.Java.httpstuff.SimpleHttpClient;
import CIAPI.Java.throttle.RequestsPerTimespanTimer;
import CIAPI.Java.throttle.ThrottledHttpClient;

/**
 * API for connecting to the City Index Trading RESTful API.
 * 
 * @author Justin Nelson
 * 
 */
public class Api {
	private final String Api_Base_Url = "http://174.129.8.69/TradingApisession";

	private JsonApi api;

	private String username;
	private String password;
	private String sessionId;

	/**
	 * Creates a new API to access the trading API. It will use the username and
	 * password you supply it.
	 * 
	 * @param username
	 *            the username to authenticate with
	 * @param password
	 *            the password to authenticate with
	 * @throws ApiException
	 */
	public Api(String username, String password) throws ApiException {
		this.username = username;
		this.password = password;
		logon();
	}

	/**
	 * Uses the username and password supplied in the constructor to log on to
	 * the CIAPI.
	 * 
	 * @throws ApiException
	 */
	private void logon() throws ApiException {
		JsonApi unAuth = new JsonApi(Api_Base_Url, new DefaultJsonClient());
		CreateSessionResponse session = (CreateSessionResponse) unAuth.callPostMethod("", null, new CILogOnRequest(
				username, password), CreateSessionResponse.class);
		sessionId = session.getSession();
		ThrottledHttpClient client = new ThrottledHttpClient(new RequestsPerTimespanTimer(10, 1000),
				new UsernamePasswordHttpRequestItemFactory(username, sessionId));
		api = new JsonApi(Api_Base_Url, new CachedJsonClient(
				new DefaultCache<CachedJsonClient.Pair<String, Class<?>>, Object>(1000 * 60), client));
	}
}
