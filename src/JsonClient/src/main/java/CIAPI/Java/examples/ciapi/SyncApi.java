package CIAPI.Java.examples.ciapi;

import java.util.HashMap;
import java.util.Map;

import CIAPI.Java.ApiException;
import CIAPI.Java.DefaultJsonClient;
import CIAPI.Java.JsonApi;
import CIAPI.Java.cachestuff.CachedJsonClient;
import CIAPI.Java.cachestuff.DefaultCache;
import CIAPI.Java.examples.ciapi.dto.AccountInformationResponse;
import CIAPI.Java.examples.ciapi.dto.CILogOnOrOffRequest;
import CIAPI.Java.examples.ciapi.dto.CreateSessionResponse;
import CIAPI.Java.examples.ciapi.dto.DeleteSessionResponse;
import CIAPI.Java.throttle.RequestsPerTimespanTimer;
import CIAPI.Java.throttle.ThrottledHttpClient;

/**
 * API for connecting to the City Index Trading RESTful API. All requests are
 * made synchronously.
 * 
 * @author Justin Nelson
 * 
 */
public class SyncApi {
	private final String Api_Base_Url = "http://ciapipreprod.cityindextest9.co.uk/TradingApi";

	private JsonApi api;

	private String username;
	private String password;
	private String sessionId;

	/**
	 * Creates a new API to access the trading API. It will use the username and
	 * password you supply it. This does not automatically log a user in.
	 * 
	 * @param username
	 *            the username to authenticate with
	 * @param password
	 *            the password to authenticate with
	 * @throws ApiException
	 */
	public SyncApi(String username, String password) throws ApiException {
		// null check to make sure we blow up when the error actually happens
		// instead of later in the code
		if (username == null)
			throw new NullPointerException("The username must not be null");
		if (password == null)
			throw new NullPointerException("The password must not be null");
		this.username = username;
		this.password = password;
	}

	/**
	 * Uses the username and password supplied in the constructor to log on to
	 * the CIAPI.
	 * 
	 * @throws ApiException
	 */
	public void logon() throws ApiException {
		JsonApi unAuth = new JsonApi(Api_Base_Url, new DefaultJsonClient());
		CreateSessionResponse session = (CreateSessionResponse) unAuth.callPostMethod("session", null,
				new CILogOnOrOffRequest(username, password), CreateSessionResponse.class);
		sessionId = session.getSession();
		ThrottledHttpClient client = new ThrottledHttpClient(new RequestsPerTimespanTimer(10, 1000),
				new UsernameSessionHttpRequestItemFactory(username, sessionId));
		api = new JsonApi(Api_Base_Url, new CachedJsonClient(
				new DefaultCache<CachedJsonClient.Pair<String, Class<?>>, Object>(1000 * 60), client));
	}

	/**
	 * Deletes the session token to essentially log a user off.
	 * 
	 * @throws ApiException
	 */
	public void logoff() throws ApiException {
		DeleteSessionResponse resp = (DeleteSessionResponse) api.callPostMethod("session/deleteSession",
				createParamMap("username", username, "password", password),
				new CILogOnOrOffRequest(username, password), DeleteSessionResponse.class);
		// TODO, figure out why the session token isn't getting deleted. Or why
		// it is getting deleted but returning false.
		if (!resp.getLoggedOut()) {
			throw new ApiException("Failed to delete session token.");
		}
		api = null;
		sessionId = null;
	}

	/**
	 * Gets trading account info for the currently logged on user.
	 * 
	 * @return an object holding the account info for the currently logged in
	 *         user.
	 * @throws ApiException
	 */
	public AccountInformationResponse getClientAndTradingAccount() throws ApiException {
		// Null check so we can throw a better error
		if (api == null) {
			throw new IllegalStateException("You must be logged in to use this method.  Use logOn() to log on.");
		}
		AccountInformationResponse resp = (AccountInformationResponse) api.callGetMethod(
				"useraccount/UserAccount/ClientAndTradingAccount", null, AccountInformationResponse.class);
		return resp;
	}

	/**
	 * @return The session id for the currently logged on user. The id will be
	 *         null if this client is not currently logged on.
	 */
	public String getSessionId() {
		return sessionId;
	}

	/**
	 * @return whether or not the user is logged on
	 */
	public boolean isLoggedOn() {
		return getSessionId() != null && api != null;
	}

	private static Map<String, String> createParamMap(String... args) {
		if (args.length % 2 != 0)
			throw new IllegalArgumentException("Arguments must be even");
		Map<String, String> ret = new HashMap<String, String>();
		for (int i = 0; i < args.length; i += 2) {
			ret.put(args[i], args[i + 1]);
		}
		return ret;
	}
}
