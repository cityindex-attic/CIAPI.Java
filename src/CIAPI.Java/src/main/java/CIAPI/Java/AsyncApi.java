package CIAPI.Java;

import java.util.Arrays;
import java.util.concurrent.Future;

import CIAPI.Java.core.ServiceMethods;
import CIAPI.Java.core.dto.ApiLogOffResponseDTO;
import CIAPI.Java.core.dto.ApiLogOnRequestDTO;
import CIAPI.Java.core.dto.ApiLogOnResponseDTO;
import CIAPI.Java.core.impl.ServiceMethodsImpl;
import JsonClient.Java.ApiException;
import JsonClient.Java.async.AsyncJsonApi;
import JsonClient.Java.async.CallBack;
import JsonClient.Java.cachestuff.Cache;
import JsonClient.Java.cachestuff.CachedJsonClient;
import JsonClient.Java.cachestuff.Pair;
import JsonClient.Java.httpstuff.DefaultHttpRequestItemFactory;
import JsonClient.Java.throttle.RequestQueue;
import JsonClient.Java.throttle.ThrottledHttpClient;

/**
 * API for connecting to the City Index Trading RESTful API. All requests are
 * made asynchronously.
 * 
 * @author Justin Nelson
 */
public class AsyncApi {
	private AsyncJsonApi api;
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

	protected AsyncApi(String baseUrl, Cache<Pair<String, Class<?>>, Object> cache, RequestQueue queue) {
		methods = new ServiceMethodsImpl();
		api = new AsyncJsonApi(baseUrl, new CachedJsonClient(cache, new ThrottledHttpClient(
				new DefaultHttpRequestItemFactory(), queue)));
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
	public Future<Object> logIn(final String username, final String password, final boolean keepAlive, CallBack...callbacks)
			throws ApiException {
		ApiLogOnRequestDTO logOn = new ApiLogOnRequestDTO();
		logOn.setPassword(password);
		logOn.setUserName(username);
		CallBack[] cbs = Arrays.copyOf(callbacks, callbacks.length + 1);
		cbs[cbs.length-1] = logOnCallback;
		return methods.LogOnAsync(username, password, api, cbs);
	}

	private final CallBack logOnCallback = new CallBack() {
		@Override
		public void doCallBack(Object result, String baseUrl, String methodName) {
			ApiLogOnResponseDTO response = (ApiLogOnResponseDTO) result;
			sessionId = response.getSession();
			AsyncApi.this.keepAlive = keepAlive;
			AsyncApi.this.username = username;
			if (keepAlive) {
				// need to save the password if we are going to re-use it to
				// authenticate with
				AsyncApi.this.password = password;
			}
			api.addConstantParameter("UserName", username);
			api.addConstantParameter("Session", sessionId);
		}
	};

	/**
	 * Removes the user's session token from the server. Also, sets the client
	 * to not keep-alive. If the log out fails, the token will naturally expire.
	 * 
	 * @return whether or not the log out was successful
	 * @throws ApiException
	 */
	public Future<Object> logOff() throws ApiException {
		return methods.DeleteSessionAsync(username, sessionId, api, new CallBack() {
			@Override
			public void doCallBack(Object result, String baseUrl, String methodName) {
				keepAlive = false;
				ApiLogOffResponseDTO response = (ApiLogOffResponseDTO) result;
				if (response.getLoggedOut()) {
					api.clearConstantParams();
					sessionId = null;
				}
			}
		});
	}

	public Future<Object> getPriceBars(String marketId, String interval, int span, String priceBars,
			CallBack... callBacks) throws ApiException {
		return methods.GetPriceBarsAsync(marketId, interval, span, priceBars, api, callBacks);
	}

	public Future<Object> getPriceTicks(String marketId, String priceTicks, CallBack... callBacks) throws ApiException {
		return methods.GetPriceTicksAsync(marketId, priceTicks, api, callBacks);
	}

	public Future<Object> getMarketInformation(String marketId, CallBack... callBacks) throws ApiException {
		return methods.GetMarketInformationAsync(marketId, api, callBacks);
	}

	public Future<Object> listNewsHeadlines(String category, int maxResults, CallBack... callBacks) throws ApiException {
		return methods.ListNewsHeadlinesAsync(category, maxResults, api, callBacks);
	}

	public Future<Object> getNewsDetail(String storyId, CallBack... callBacks) throws ApiException {
		return methods.GetNewsDetailAsync(storyId, api, callBacks);
	}

	public Future<Object> listCfdMarkets(String searchByMarketName, String searchByMarketCode, int clientAccountId,
			int maxResults, CallBack... callBacks) throws ApiException {
		return methods.ListCfdMarketsAsync(searchByMarketName, searchByMarketCode, clientAccountId, maxResults, api,
				callBacks);
	}

	public Future<Object> listSpreadMarkets(String searchByMarketName, String searchByMarketCode, int clientAccountId,
			int maxResults, CallBack... callBacks) throws ApiException {
		return methods.ListSpreadMarketsAsync(searchByMarketName, searchByMarketCode, clientAccountId, maxResults, api,
				callBacks);
	}

	public Future<Object> listOpenPositions(int tradingAccountId, CallBack... callBacks) throws ApiException {
		return methods.ListOpenPositionsAsync(tradingAccountId, api, callBacks);
	}

	public Future<Object> listActiveStopLimitOrders(int tradingAccountId, CallBack... callbacks) throws ApiException {
		return methods.ListActiveStopLimitOrdersAsync(tradingAccountId, api, callbacks);
	}

	public Future<Object> listTradeHistory(int tradingAccountId, int maxResults, CallBack... callbacks)
			throws ApiException {
		return methods.ListTradeHistoryAsync(tradingAccountId, maxResults, api, callbacks);
	}

	public Future<Object> listStopLimitOrderHistory(int tradingAccountId, int maxResults, CallBack... callbacks)
			throws ApiException {
		return methods.ListStopLimitOrderHistoryAsync(tradingAccountId, maxResults, api, callbacks);
	}

	private void keepAlive() throws ApiException {
		if (keepAlive) {
			logIn(username, password, keepAlive, logOnCallback);
		}
	}
}
