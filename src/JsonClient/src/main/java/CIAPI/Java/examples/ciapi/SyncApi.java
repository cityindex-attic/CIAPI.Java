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
import CIAPI.Java.examples.ciapi.dto.ListTradeHistoryResponse;
import CIAPI.Java.examples.ciapi.dto.Order;
import CIAPI.Java.examples.ciapi.dto.TradeOrderResponse;
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
		// first we make a quick unauthenticated call to get credentials.
		JsonApi unAuth = new JsonApi(Api_Base_Url, new DefaultJsonClient());
		CreateSessionResponse session = (CreateSessionResponse) unAuth.callPostMethod("session", null,
				new CILogOnOrOffRequest(username, password), CreateSessionResponse.class);
		sessionId = session.getSession();
		if (sessionId == null) {
			throw new NullPointerException("Error logging in.  Returned session was null.");
		}
		// then we create an authenticated client that adds the username and
		// session id to each request.
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
				createParamMap("session", sessionId, "userName", username),
				new CILogOnOrOffRequest(username, sessionId), DeleteSessionResponse.class);
		// TODO, figure out why the session token isn't getting deleted. Or why
		// it is getting deleted but returning false.
		if (!resp.getLoggedOut()) {
			throw new ApiException("Failed to delete session token.");
		}
		// Set these to null so they can't accidentally be used later
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
		checkLoggedOn();
		AccountInformationResponse resp = (AccountInformationResponse) api.callGetMethod(
				"useraccount/UserAccount/ClientAndTradingAccount", null, AccountInformationResponse.class);
		return resp;
	}

	/**
	 * Lists the trading history for the given account id
	 * 
	 * @param tradingAccountId
	 * @param maxResults
	 * @return
	 * @throws ApiException
	 */
	public ListTradeHistoryResponse listTradeHistory(int tradingAccountId, int maxResults) throws ApiException {
		checkLoggedOn();
		ListTradeHistoryResponse resp = (ListTradeHistoryResponse) api.callGetMethod("order/order/tradehistory",
				createParamMap("tradingAccountId", tradingAccountId, "maxResults", maxResults),
				ListTradeHistoryResponse.class);
		return resp;
	}

	public TradeOrderResponse order() throws ApiException {
		TradeOrderResponse resp = (TradeOrderResponse) api.callPostMethod("order/", null, new Order(),
				TradeOrderResponse.class);
		return resp;
	}

	public boolean getChartingEnabled(int id) throws ApiException {
		boolean chartingEnabled = (Boolean) api.callGetMethod("useraccount/UserAccount/" + id + "/ChartingEnabled",
				null, Boolean.class);
		return chartingEnabled;
	}

	private void checkLoggedOn() {
		if (!isLoggedOn()) {
			throw new IllegalStateException("You must be logged in to use this method.  Use logOn() to log on.");
		}
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

	/**
	 * Helper method for taking a list of strings and turning it into a Map
	 * 
	 * @param args
	 *            a list of pairs of parameters
	 * @return a map containing an 'UnZipped' version of the list.
	 */
	private static Map<String, String> createParamMap(Object... args) {
		if (args == null) {
			// I prefer to allow null when a sane default exists.
			// the rest of the json api code handles a null map well
			return null;
		}
		if (args.length % 2 != 0)
			throw new IllegalArgumentException("Arguments must be even");
		Map<String, String> ret = new HashMap<String, String>();
		// Grab items 2 at a time and place them in the map.
		for (int i = 0; i < args.length; i += 2) {
			ret.put(args[i].toString(), args[i + 1].toString());
		}
		return ret;
	}
}
