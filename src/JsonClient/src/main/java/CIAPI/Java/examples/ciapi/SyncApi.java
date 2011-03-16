package CIAPI.Java.examples.ciapi;

import java.util.HashMap;
import java.util.Map;

import CIAPI.Java.ApiException;
import CIAPI.Java.DefaultJsonClient;
import CIAPI.Java.JsonApi;
import CIAPI.Java.cachestuff.CachedJsonClient;
import CIAPI.Java.cachestuff.DefaultCache;
import CIAPI.Java.examples.ciapi.dto.AccountInformationResponseDTO;
import CIAPI.Java.examples.ciapi.dto.ApiTradeOrderResponseDTO;
import CIAPI.Java.examples.ciapi.dto.CreateSessionResponseDTO;
import CIAPI.Java.examples.ciapi.dto.ListCfdMarketsResponseDTO;
import CIAPI.Java.examples.ciapi.dto.LogOnRequestDTO;
import CIAPI.Java.examples.ciapi.dto.OrderDTO;
import CIAPI.Java.examples.ciapi.dto.SessionDeletionRequestDTO;
import CIAPI.Java.examples.ciapi.dto.SessionDeletionResponseDTO;
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
		CreateSessionResponseDTO session = (CreateSessionResponseDTO) unAuth.callPostMethod("session", null,
				new LogOnRequestDTO(username, password), CreateSessionResponseDTO.class);
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
		SessionDeletionResponseDTO resp = (SessionDeletionResponseDTO) api.callPostMethod("session/deleteSession",
				createParamMap("session", sessionId, "userName", username), new SessionDeletionRequestDTO(username,
						sessionId), SessionDeletionResponseDTO.class);
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
	 * 
	 * // auto generate these from param list
	 * 
	 * @param id
	 *            // params // Auto generate from return type
	 * @return // return
	 */
	public boolean GetChartingEnabled(String id) throws ApiException {
		// Collect variables from method
		String target = "useraccount";
		String uriTemplate = "/UserAccount/{id}/ChartingEnabled";
		String transport = "GET";
		String envelope = "URL";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		int holeCount = 0;
		// Done collecting variables
		// Fill in necessary holes in the URL.
		filledUri = uriTemplate.replace("{id}", id);
		holeCount++;
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		Map<String, String> params = new HashMap<String, String>();
		// build up the rest of the parameters
		// end building the rest of the parameters
		// return type result type get/post url params return type.class
		Boolean result = (Boolean) api.callGetMethod(fullUrl, params, Boolean.class);
		return result;
	}

	/**
	 * 
	 * // auto generate these from param list
	 * 
	 * @param id
	 *            // params // Auto generate from return type
	 * @return // return
	 */
	public AccountInformationResponseDTO GetClientAndTradingAccount() throws ApiException {
		// Collect variables from method
		String target = "useraccount";
		String uriTemplate = "/UserAccount/ClientAndTradingAccount";
		String transport = "GET";
		String envelope = "URL";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		int holeCount = 0;
		// Done collecting variables
		// Fill in necessary holes in the URL.
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		Map<String, String> params = new HashMap<String, String>();
		// build up the rest of the parameters
		// end building the rest of the parameters
		// return type result type get/post url params return type.class
		AccountInformationResponseDTO result = (AccountInformationResponseDTO) api.callGetMethod(fullUrl, params,
				AccountInformationResponseDTO.class);
		return result;
	}

	/**
	 * 
	 * // auto generate these from param list
	 * 
	 * @param id
	 *            // params // Auto generate from return type
	 * @return // return
	 */
	public String GetTermsAndConditions(String clientaccount) throws ApiException {
		// Collect variables from method
		String target = "useraccount";
		String uriTemplate = "/UserAccount/{clientaccount}/TermsAndConditions";
		String transport = "GET";
		String envelope = "URL";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		int holeCount = 0;
		// Done collecting variables
		// Fill in necessary holes in the URL.
		filledUri = filledUri.replace("{clientaccount}", clientaccount);
		holeCount++;
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		Map<String, String> params = new HashMap<String, String>();
		// build up the rest of the parameters
		// end building the rest of the parameters
		// return type result type get/post url params return type.class
		String result = (String) api.callGetMethod(fullUrl, params, String.class);
		return result;
	}

	/**
	 * 
	 * // auto generate these from param list
	 * 
	 * @param id
	 *            // params // Auto generate from return type
	 * @return // return
	 */
	public CreateSessionResponseDTO CreateSession(String UserName, String Password) throws ApiException {
		// Collect variables from method
		String target = "session";
		String uriTemplate = "/";
		String transport = "POST";
		String envelope = "JSON";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		int holeCount = 0;
		// Done collecting variables
		// Fill in necessary holes in the URL.
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		Map<String, String> params = new HashMap<String, String>();
		// build up the rest of the parameters
		// end building the rest of the parameters
		// return type result type get/post url params return type.class
		// TODO, how do I know that this takes a LogOnRequestDTO?
		CreateSessionResponseDTO result = (CreateSessionResponseDTO) api.callPostMethod(fullUrl, params, null,
				CreateSessionResponseDTO.class);
		return result;
	}

	/**
	 * 
	 * // auto generate these from param list
	 * 
	 * @param id
	 *            // params // Auto generate from return type
	 * @return // return
	 */
	public SessionDeletionResponseDTO DeleteSession(String userName, String session) throws ApiException {
		// Collect variables from method
		String target = "session";
		String uriTemplate = "/deleteSession?userName={userName}&session={session}";
		String transport = "POST";
		String envelope = "JSON";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		int holeCount = 0;
		// Done collecting variables
		// Fill in necessary holes in the URL.
		filledUri = filledUri.replace("{userName}", userName);
		holeCount++;
		filledUri = filledUri.replace("{session}", session);
		holeCount++;
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		Map<String, String> params = new HashMap<String, String>();
		// build up the rest of the parameters
		// end building the rest of the parameters
		// return type result type get/post url params return type.class
		// TODO, how do I know that this takes an empty object `{}`?
		SessionDeletionResponseDTO result = (SessionDeletionResponseDTO) api.callPostMethod(fullUrl, params, null,
				SessionDeletionResponseDTO.class);
		return result;
	}

	/**
	 * 
	 * // auto generate these from param list
	 * 
	 * @param id
	 *            // params // Auto generate from return type
	 * @return // return
	 */
	public ListCfdMarketsResponseDTO ListCfdMarkets(String searchByMarketName, String searchByMarketCode,
			int clientAccountId, int maxResults) throws ApiException {
		// Collect variables from method
		String target = "cfd/markets";
		String uriTemplate = "?MarketName={searchByMarketName}&MarketCode={searchByMarketCode}&ClientAccountId={clientAccountId}&MaxResults={maxResults}";
		String transport = "GET";
		String envelope = "URL";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		int holeCount = 0;
		// Done collecting variables
		// Fill in necessary holes in the URL.
		filledUri = filledUri.replace("{userName}", userName);
		holeCount++;
		filledUri = filledUri.replace("{session}", session);
		holeCount++;
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		Map<String, String> params = new HashMap<String, String>();
		// build up the rest of the parameters
		// end building the rest of the parameters
		// return type result type get/post url params return type.class
		// TODO, how do I know that this takes an empty object `{}`?
		ListCfdMarketsResponseDTO result = (ListCfdMarketsResponseDTO) api.callPostMethod(fullUrl, params, null,
				ListCfdMarketsResponseDTO.class);
		return result;
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
