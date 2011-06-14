package CIAPI.Java;

import CIAPI.Java.core.ServiceMethods;
import CIAPI.Java.core.dto.ApiActiveStopLimitOrderDTO;
import CIAPI.Java.core.dto.ApiLogOffResponseDTO;
import CIAPI.Java.core.dto.ApiLogOnResponseDTO;
import CIAPI.Java.core.dto.ApiMarketDTO;
import CIAPI.Java.core.dto.ApiOpenPositionDTO;
import CIAPI.Java.core.dto.ApiStopLimitOrderHistoryDTO;
import CIAPI.Java.core.dto.ApiTradeHistoryDTO;
import CIAPI.Java.core.dto.GetMarketInformationResponseDTO;
import CIAPI.Java.core.dto.GetNewsDetailResponseDTO;
import CIAPI.Java.core.dto.GetPriceBarResponseDTO;
import CIAPI.Java.core.dto.GetPriceTickResponseDTO;
import CIAPI.Java.core.dto.ListActiveStopLimitOrderResponseDTO;
import CIAPI.Java.core.dto.ListCfdMarketsResponseDTO;
import CIAPI.Java.core.dto.ListNewsHeadlinesResponseDTO;
import CIAPI.Java.core.dto.ListOpenPositionsResponseDTO;
import CIAPI.Java.core.dto.ListSpreadMarketsResponseDTO;
import CIAPI.Java.core.dto.ListStopLimitOrderHistoryResponseDTO;
import CIAPI.Java.core.dto.ListTradeHistoryResponseDTO;
import CIAPI.Java.core.dto.NewsDTO;
import CIAPI.Java.core.dto.NewsDetailDTO;
import CIAPI.Java.core.dto.PriceBarDTO;
import CIAPI.Java.core.dto.PriceTickDTO;
import CIAPI.Java.core.impl.ServiceMethodsImpl;
import JsonClient.Java.ApiException;
import JsonClient.Java.DefaultJsonClient;
import JsonClient.Java.JsonApi;
import JsonClient.Java.cachestuff.Cache;
import JsonClient.Java.cachestuff.CachedJsonClient;
import JsonClient.Java.cachestuff.Pair;
import JsonClient.Java.httpstuff.DefaultHttpRequestItemFactory;
import JsonClient.Java.throttle.RequestQueue;
import JsonClient.Java.throttle.ThrottledHttpClient;

/**
 * API for connecting to the City Index Trading RESTful API. All requests are
 * made synchronously.
 * 
 * @author Justin Nelson
 */
public class SyncApi {
	private JsonApi api;

	private String username;
	private String password;
	private String sessionId;

	/**
	 * The session ID for the currently open session
	 * 
	 * @return a String representing the current Session Id. If the Id is null
	 *         or empty, then we are currently logged off
	 */
	public String getSessionId() {
		return sessionId;
	}

	private boolean keepAlive;
	private ServiceMethods methods;

	protected SyncApi(String baseUrl, Cache<Pair<String, Class<?>>, Object> cache, RequestQueue queue) {
		methods = new ServiceMethodsImpl();
		api = new JsonApi(baseUrl, new DefaultJsonClient());
		//api = new JsonApi(baseUrl, new CachedJsonClient(cache, new ThrottledHttpClient(
		//		new DefaultHttpRequestItemFactory(), queue)));
	}

	/**
	 * Logs this instance on to the CIAPI. Multiple calls of logOn will possibly
	 * change the Session Id, but the class should function as normal.
	 * 
	 * @param username
	 *            The name of the user to authenticate as
	 * @param password
	 *            The password for the given user Id
	 * @param keepAlive
	 *            if true, the client will auto-renew the session token if it
	 *            expires.
	 * @throws ApiException
	 */
	public void logIn(String username, String password, boolean keepAlive) throws ApiException {
		ApiLogOnResponseDTO response = methods.LogOn(username, password, api);
		sessionId = response.getSession();
		this.keepAlive = keepAlive;
		this.username = username;
		if (keepAlive) {
			// need to save the password if we are going to re-use it to
			// authenticate with
			this.password = password;
		}
		api.addConstantParameter("UserName", username);
		api.addConstantParameter("session", sessionId);
	}

	/**
	 * Removes the user's session token from the server. Also, sets the client
	 * to not keep-alive. If the log out fails, the token will naturally expire.
	 * 
	 * @return whether or not the log out was successful
	 * @throws ApiException
	 */
	public boolean logOff() throws ApiException {
		keepAlive = false;
		ApiLogOffResponseDTO response = methods.DeleteSession(username, sessionId, api);
		if (response.getLoggedOut()) {
			api.clearConstantParams();
			sessionId = null;
			return true;
		} else {
			return false;
		}
	}

	public PriceBarDTO[] getPriceBars(String marketId, String interval, int span, String priceBars) throws ApiException {
		GetPriceBarResponseDTO response = methods.GetPriceBars(marketId, interval, span, priceBars, api);
		return response.getPriceBars();
	}

	public PriceTickDTO[] getPriceTicks(String marketId, String priceTicks) throws ApiException {
		GetPriceTickResponseDTO response = methods.GetPriceTicks(marketId, priceTicks, api);
		return response.getPriceTicks();
	}

	public GetMarketInformationResponseDTO getMarketInformation(String marketId) throws ApiException {
		GetMarketInformationResponseDTO response = methods.GetMarketInformation(marketId, api);
		return response;
	}

	public NewsDTO[] listNewsHeadlines(String category, int maxResults) throws ApiException {
		ListNewsHeadlinesResponseDTO response = methods.ListNewsHeadlines(category, maxResults, api);
		return response.getHeadlines();
	}

	public NewsDetailDTO getNewsDetail(String storyId) throws ApiException {
		GetNewsDetailResponseDTO response = methods.GetNewsDetail(storyId, api);
		return response.getNewsDetail();
	}

	public ApiMarketDTO[] listCfdMarkets(String searchByMarketName, String searchByMarketCode, int clientAccountId,
			int maxResults) throws ApiException {
		ListCfdMarketsResponseDTO response = methods.ListCfdMarkets(searchByMarketName, searchByMarketCode,
				clientAccountId, maxResults, api);
		return response.getMarkets();
	}

	public ApiMarketDTO[] listSpreadMarkets(String searchByMarketName, String searchByMarketCode, int clientAccountId,
			int maxResults) throws ApiException {
		ListSpreadMarketsResponseDTO response = methods.ListSpreadMarkets(searchByMarketName, searchByMarketCode,
				clientAccountId, maxResults, api);
		return response.getMarkets();
	}

	public ApiOpenPositionDTO[] listOpenPositions(int tradingAccountId) throws ApiException {
		ListOpenPositionsResponseDTO response = methods.ListOpenPositions(tradingAccountId, api);
		return response.getOpenPositions();
	}

	public ApiActiveStopLimitOrderDTO[] listActiveStopLimitOrders(int tradingAccountId) throws ApiException {
		ListActiveStopLimitOrderResponseDTO response = methods.ListActiveStopLimitOrders(tradingAccountId, api);
		return response.getActiveStopLimitOrders();
	}

	public ApiTradeHistoryDTO[] listTradeHistory(int tradingAccountId, int maxResults) throws ApiException {
		ListTradeHistoryResponseDTO response = methods.ListTradeHistory(tradingAccountId, maxResults, api);
		return response.getTradeHistory();
	}

	public ApiStopLimitOrderHistoryDTO[] listStopLimitOrderHistory(int tradingAccountId, int maxResults)
			throws ApiException {
		ListStopLimitOrderHistoryResponseDTO response = methods.ListStopLimitOrderHistory(tradingAccountId, maxResults,
				api);
		return response.getStopLimitOrderHistory();
	}

	private void keepAlive() throws ApiException {
		if (keepAlive) {
			logIn(username, password, keepAlive);
		}
	}
}
