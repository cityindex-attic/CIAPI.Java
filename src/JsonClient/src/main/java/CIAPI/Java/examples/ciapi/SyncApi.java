package CIAPI.Java.examples.ciapi;

import CIAPI.Java.ApiException;
import CIAPI.Java.JsonApi;
import CIAPI.Java.cachestuff.Cache;
import CIAPI.Java.cachestuff.CachedJsonClient;
import CIAPI.Java.examples.ciapi.dto.ApiActiveStopLimitOrderDTO;
import CIAPI.Java.examples.ciapi.dto.ApiOpenPositionDTO;
import CIAPI.Java.examples.ciapi.dto.ApiTradeHistoryDTO;
import CIAPI.Java.examples.ciapi.dto.ApiTradeOrderResponseDTO;
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
import CIAPI.Java.examples.ciapi.dto.ListTradeHistoryResponseDTO;
import CIAPI.Java.examples.ciapi.dto.MarketDTO;
import CIAPI.Java.examples.ciapi.dto.MarketInformationResponseDTO;
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
 * made synchronously.
 * 
 * @author Justin Nelson
 */
public class SyncApi {
	private JsonApi api;

	private String username;
	private String password;
	private String sessionId;

	public String getSessionId() {
		return sessionId;
	}

	private boolean keepAlive;
	private ServiceMethods methods;

	protected SyncApi(String baseUrl, Cache<CachedJsonClient.Pair<String, Class<?>>, Object> cache, RequestQueue queue) {
		methods = new ServiceMethodsImpl();
		api = new JsonApi(baseUrl, new CachedJsonClient(cache, new ThrottledHttpClient(
				new DefaultHttpRequestItemFactory(), queue)));
	}

	public void logIn(String username, String password, boolean keepAlive) throws ApiException {
		CreateSessionResponseDTO response = methods.CreateSession(username, password, api);
		sessionId = response.getSession();
		this.keepAlive = keepAlive;
		this.username = username;
		if (keepAlive) {
			this.password = password;
		}
		api.addConstantParameter("UserName", username);
		api.addConstantParameter("Session", sessionId);
	}

	public boolean logOff() throws ApiException {
		SessionDeletionResponseDTO response = methods.DeleteSession(username, sessionId, api);
		if (response.getLoggedOut()) {
			api.clearConstantParams();
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

	public MarketInformationResponseDTO getMarketInformation(String marketId) throws ApiException {
		MarketInformationResponseDTO response = methods.GetMarketInformation(marketId, api);
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

	public MarketDTO[] listCfdMarkets(String searchByMarketName, String searchByMarketCode, int clientAccountId,
			int maxResults) throws ApiException {
		ListCfdMarketsResponseDTO response = methods.ListCfdMarkets(searchByMarketName, searchByMarketCode,
				clientAccountId, maxResults, api);
		return response.getMarkets();
	}

	public MarketDTO[] listSpreadMarkets(String searchByMarketName, String searchByMarketCode, int clientAccountId,
			int maxResults) throws ApiException {
		ListSpreadMarketsResponseDTO response = methods.ListSpreadMarkets(searchByMarketName, searchByMarketCode,
				clientAccountId, maxResults, api);
		return response.getMarkets();
	}

	public ApiTradeOrderResponseDTO order(int MarketId, String Direction, double Quantity, double BidPrice,
			double OfferPrice, String AuditId, int TradingAccountId, String Applicability, String ExpiryDateTimeUTC)
			throws ApiException {
		ApiTradeOrderResponseDTO response = methods.Order(MarketId, Direction, Quantity, BidPrice, OfferPrice, AuditId,
				TradingAccountId, Applicability, ExpiryDateTimeUTC, api);
		return response;
	}

	public ApiTradeOrderResponseDTO cancelOrder(int orderId) throws ApiException {
		ApiTradeOrderResponseDTO response = methods.CancelOrder(orderId, api);
		return response;
	}

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

	private void keepAlive() throws ApiException {
		if (keepAlive) {
			logIn(username, password, keepAlive);
		}
	}
}
