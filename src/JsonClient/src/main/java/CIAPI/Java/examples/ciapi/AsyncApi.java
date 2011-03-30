package CIAPI.Java.examples.ciapi;

import java.util.concurrent.Future;

import CIAPI.Java.ApiException;
import CIAPI.Java.JsonApi;
import CIAPI.Java.async.AsyncJsonApi;
import CIAPI.Java.async.CallBack;
import CIAPI.Java.cachestuff.Cache;
import CIAPI.Java.cachestuff.CachedJsonClient;
import CIAPI.Java.examples.ciapi.dto.ApiActiveStopLimitOrderDTO;
import CIAPI.Java.examples.ciapi.dto.ApiOpenPositionDTO;
import CIAPI.Java.examples.ciapi.dto.ApiStopLimitOrderHistoryDTO;
import CIAPI.Java.examples.ciapi.dto.ApiTradeHistoryDTO;
import CIAPI.Java.examples.ciapi.dto.ApiTradeOrderResponseDTO;
import CIAPI.Java.examples.ciapi.dto.CancelOrderRequestDTO;
import CIAPI.Java.examples.ciapi.dto.CreateSessionResponseDTO;
import CIAPI.Java.examples.ciapi.dto.GetNewsDetailResponseDTO;
import CIAPI.Java.examples.ciapi.dto.GetPriceBarResponseDTO;
import CIAPI.Java.examples.ciapi.dto.GetPriceTickResponseDTO;
import CIAPI.Java.examples.ciapi.dto.ListActiveStopLimitOrderResponseDTO;
import CIAPI.Java.examples.ciapi.dto.ListCfdMarketsResponseDTO;
import CIAPI.Java.examples.ciapi.dto.ListNewsHeadlinesResponseDTO;
import CIAPI.Java.examples.ciapi.dto.ListOpenPositionsResponseDTO;
import CIAPI.Java.examples.ciapi.dto.ListOrdersResponseDTO;
import CIAPI.Java.examples.ciapi.dto.ListSpreadMarketsResponseDTO;
import CIAPI.Java.examples.ciapi.dto.ListStopLimitOrderHistoryResponseDTO;
import CIAPI.Java.examples.ciapi.dto.ListTradeHistoryResponseDTO;
import CIAPI.Java.examples.ciapi.dto.LogOnRequestDTO;
import CIAPI.Java.examples.ciapi.dto.MarketDTO;
import CIAPI.Java.examples.ciapi.dto.NewStopLimitOrderRequestDTO;
import CIAPI.Java.examples.ciapi.dto.NewsDTO;
import CIAPI.Java.examples.ciapi.dto.NewsDetailDTO;
import CIAPI.Java.examples.ciapi.dto.PriceBarDTO;
import CIAPI.Java.examples.ciapi.dto.PriceTickDTO;
import CIAPI.Java.examples.ciapi.dto.SessionDeletionResponseDTO;
import CIAPI.Java.examples.ciapi.impl.ServiceMethodsImpl;
import CIAPI.Java.httpstuff.DefaultHttpRequestItemFactory;
import CIAPI.Java.throttle.RequestQueue;
import CIAPI.Java.throttle.ThrottledHttpClient;

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

	protected AsyncApi(String baseUrl, Cache<CachedJsonClient.Pair<String, Class<?>>, Object> cache, RequestQueue queue) {
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
	public Future<Object> logIn(final String username, final String password, final boolean keepAlive, CallBack callBack)
			throws ApiException {
		LogOnRequestDTO logOn = new LogOnRequestDTO();
		logOn.setPassword(password);
		logOn.setUserName(username);
		return methods.CreateSessionAsync(logOn, api, logOnCallback, callBack);
	}

	private final CallBack logOnCallback = new CallBack() {
		@Override
		public void doCallBack(Object result, String baseUrl, String methodName) {
			CreateSessionResponseDTO response = (CreateSessionResponseDTO) result;
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
				SessionDeletionResponseDTO response = (SessionDeletionResponseDTO) result;
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

	public Future<Object> order(int MarketId, String Direction, double Quantity, double BidPrice, double OfferPrice,
			String AuditId, int TradingAccountId, String Applicability, String ExpiryDateTimeUTC, CallBack... callBacks)
			throws ApiException {
		NewStopLimitOrderRequestDTO data = new NewStopLimitOrderRequestDTO();
		data.setMarketId(MarketId);
		data.setDirection(Direction);
		data.setQuantity(Quantity);
		data.setBidPrice(BidPrice);
		data.setOfferPrice(OfferPrice);
		data.setAuditId(AuditId);
		data.setTradingAccountId(TradingAccountId);
		data.setApplicability(Applicability);
		data.setExpiryDateTimeUTC(ExpiryDateTimeUTC);
		return methods.OrderAsync(data, api, callBacks);
	}

	public Future<Object> cancelOrder(int orderId, CallBack...callBacks) throws ApiException {
		CancelOrderRequestDTO data = new CancelOrderRequestDTO();
		return methods.CancelOrderAsync(data, api, callBacks);
	}
	/* The below methods need to be converted to async versions of the same code

	public ListOrdersResponseDTO listOrders(int tradingAccountId, boolean openOrders, boolean acceptedOrders)
			throws ApiException {
		ListOrdersResponseDTO response = methods.ListOrders(tradingAccountId, openOrders, acceptedOrders, api);
		return response;
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

	public ApiTradeOrderResponseDTO trade(int MarketId, String Direction, double Quantity, double BidPrice,
			double OfferPrice, String AuditId, int TradingAccountId) throws ApiException {
		ApiTradeOrderResponseDTO response = methods.Trade(MarketId, Direction, Quantity, BidPrice, OfferPrice, AuditId,
				TradingAccountId, api);
		return response;
	}

	public boolean getChartingEnabled(String id) throws ApiException {
		return methods.GetChartingEnabled(id, api);
	}

	public String getTermsAndConditions(String clientaccount) throws ApiException {
		return methods.GetTermsAndConditions(clientaccount, api);
	}

	public AccountInformationResponseDTO getClientAndTradingAccount() throws ApiException {
		AccountInformationResponseDTO response = methods.GetClientAndTradingAccount(api);
		return response;
	}
	
	*/

	private void keepAlive() throws ApiException {
		if (keepAlive) {
			logIn(username, password, keepAlive, logOnCallback);
		}
	}
}
