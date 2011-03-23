package CIAPI.Java.examples.ciapi.impl;

import CIAPI.Java.ApiException;
import CIAPI.Java.JsonApi;
import CIAPI.Java.examples.ciapi.ServiceMethods;

public class ServiceMethodsImpl implements ServiceMethods {

	private JsonApi api = new JsonApi("someBaseUrl", null);

	/**
	 * !This is an auto generated method!
	 * 
	 * Create a new session. The is how you "log on" to the CIAPI.
	 */
	@Override
	public CIAPI.Java.examples.ciapi.dto.CreateSessionResponseDTO CreateSession(String UserName, String Password)
			throws ApiException {
		// Collect variables from method
		String target = "session";
		String uriTemplate = "/";
		String transport = "POST";
		String envelope = "JSON";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL.
		filledUri = filledUri.replace("{UserName}", UserName);
		filledUri = filledUri.replace("{Password}", Password);

		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		// return type result type get/post url params return type.class
		CIAPI.Java.examples.ciapi.dto.CreateSessionResponseDTO result = (CIAPI.Java.examples.ciapi.dto.CreateSessionResponseDTO) api
				.callGetMethod(fullUrl, CIAPI.Java.examples.ciapi.dto.CreateSessionResponseDTO.class);
		return result;
	}

	/**
	 * !This is an auto generated method!
	 * 
	 * Delete a session. This is how you "log off" from the CIAPI.
	 */
	@Override
	public CIAPI.Java.examples.ciapi.dto.SessionDeletionResponseDTO DeleteSession(String userName, String session)
			throws ApiException {
		// Collect variables from method
		String target = "session";
		String uriTemplate = "/deleteSession?userName={userName}&session={session}";
		String transport = "POST";
		String envelope = "JSON";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL.
		filledUri = filledUri.replace("{userName}", userName);
		filledUri = filledUri.replace("{session}", session);

		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		// return type result type get/post url params return type.class
		CIAPI.Java.examples.ciapi.dto.SessionDeletionResponseDTO result = (CIAPI.Java.examples.ciapi.dto.SessionDeletionResponseDTO) api
				.callGetMethod(fullUrl, CIAPI.Java.examples.ciapi.dto.SessionDeletionResponseDTO.class);
		return result;
	}

	/**
	 * !This is an auto generated method!
	 * 
	 * Get historic price bars in OHLC (open, high, low, close) format, suitable
	 * for plotting candlestick chartsReturns price bars in ascending order up
	 * to the current time.When there are no prices per a particular time
	 * period, no price bar is returned. Thus, it can appear that the array of
	 * price bars has "gaps", i.e. the gap between the datetime of each price
	 * bar might not be equal to interval x spanSample Urls:
	 * /market/1234/history
	 * ?interval=MINUTE&span=15&pricebars=180/market/735/history
	 * ?interval=HOUR&span
	 * =1&pricebars=240/market/1577/history?interval=DAY&span=1&pricebars=10
	 */
	@Override
	public CIAPI.Java.examples.ciapi.dto.GetPriceBarResponseDTO GetPriceBars(String marketId, String interval,
			int span, String priceBars) throws ApiException {
		// Collect variables from method
		String target = "market";
		String uriTemplate = "/{marketId}/barhistory?interval={interval}&span={span}&pricebars={priceBars}";
		String transport = "GET";
		String envelope = "URL";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL.

		filledUri = filledUri.replace("{marketId}", marketId);

		filledUri = filledUri.replace("{interval}", interval);

		filledUri = filledUri.replace("{span}", span + "");

		filledUri = filledUri.replace("{priceBars}", priceBars);

		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		// return type result type get/post url params return type.class
		CIAPI.Java.examples.ciapi.dto.GetPriceBarResponseDTO result = (CIAPI.Java.examples.ciapi.dto.GetPriceBarResponseDTO) api
				.callGetMethod(fullUrl, CIAPI.Java.examples.ciapi.dto.GetPriceBarResponseDTO.class);
		return result;
	}

	/**
	 * !This is an auto generated method!
	 * 
	 * Get historic price ticks. Returns price ticks in ascending order up to
	 * the current time. The length of time between each tick will be different.
	 */
	@Override
	public CIAPI.Java.examples.ciapi.dto.GetPriceTickResponseDTO GetPriceTicks(String marketId, String priceTicks)
			throws ApiException {
		// Collect variables from method
		String target = "market";
		String uriTemplate = "/{marketId}/tickhistory?priceticks={priceTicks}";
		String transport = "GET";
		String envelope = "URL";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL.

		filledUri = filledUri.replace("{marketId}", marketId);

		filledUri = filledUri.replace("{priceTicks}", priceTicks);

		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		// return type result type get/post url params return type.class
		CIAPI.Java.examples.ciapi.dto.GetPriceTickResponseDTO result = (CIAPI.Java.examples.ciapi.dto.GetPriceTickResponseDTO) api
				.callGetMethod(fullUrl, CIAPI.Java.examples.ciapi.dto.GetPriceTickResponseDTO.class);
		return result;
	}

	/**
	 * !This is an auto generated method!
	 * 
	 * Get Market Information for the specified market.
	 */
	@Override
	public CIAPI.Java.examples.ciapi.dto.MarketInformationResponseDTO GetMarketInformation(String marketId)
			throws ApiException {
		// Collect variables from method
		String target = "market";
		String uriTemplate = "/{marketId}/information";
		String transport = "GET";
		String envelope = "URL";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL.

		filledUri = filledUri.replace("{marketId}", marketId);

		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		// return type result type get/post url params return type.class
		CIAPI.Java.examples.ciapi.dto.MarketInformationResponseDTO result = (CIAPI.Java.examples.ciapi.dto.MarketInformationResponseDTO) api
				.callGetMethod(fullUrl, CIAPI.Java.examples.ciapi.dto.MarketInformationResponseDTO.class);
		return result;
	}

	/**
	 * !This is an auto generated method!
	 * 
	 * Get a list of current news headlines
	 */
	@Override
	public CIAPI.Java.examples.ciapi.dto.ListNewsHeadlinesResponseDTO ListNewsHeadlines(String category, int maxResults)
			throws ApiException {
		// Collect variables from method
		String target = "news";
		String uriTemplate = "?Category={category}&MaxResults={maxResults}";
		String transport = "GET";
		String envelope = "URL";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL.

		filledUri = filledUri.replace("{category}", category);

		filledUri = filledUri.replace("{maxResults}", maxResults + "");

		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		// return type result type get/post url params return type.class
		CIAPI.Java.examples.ciapi.dto.ListNewsHeadlinesResponseDTO result = (CIAPI.Java.examples.ciapi.dto.ListNewsHeadlinesResponseDTO) api
				.callGetMethod(fullUrl, CIAPI.Java.examples.ciapi.dto.ListNewsHeadlinesResponseDTO.class);
		return result;
	}

	/**
	 * !This is an auto generated method!
	 * 
	 * Get the detail of a specific news story
	 */
	@Override
	public CIAPI.Java.examples.ciapi.dto.GetNewsDetailResponseDTO GetNewsDetail(String storyId) throws ApiException {
		// Collect variables from method
		String target = "news";
		String uriTemplate = "/{storyId}";
		String transport = "GET";
		String envelope = "URL";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL.

		filledUri = filledUri.replace("{storyId}", storyId);

		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		// return type result type get/post url params return type.class
		CIAPI.Java.examples.ciapi.dto.GetNewsDetailResponseDTO result = (CIAPI.Java.examples.ciapi.dto.GetNewsDetailResponseDTO) api
				.callGetMethod(fullUrl, CIAPI.Java.examples.ciapi.dto.GetNewsDetailResponseDTO.class);
		return result;
	}

	/**
	 * !This is an auto generated method!
	 * 
	 * Returns a list of CFD markets filtered by market name and/or market code
	 */
	@Override
	public CIAPI.Java.examples.ciapi.dto.ListCfdMarketsResponseDTO ListCfdMarkets(String searchByMarketName,
			String searchByMarketCode, int clientAccountId, int maxResults) throws ApiException {
		// Collect variables from method
		String target = "cfd/markets";
		String uriTemplate = "?MarketName={searchByMarketName}&MarketCode={searchByMarketCode}&ClientAccountId={clientAccountId}&MaxResults={maxResults}";
		String transport = "GET";
		String envelope = "URL";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL.

		filledUri = filledUri.replace("{searchByMarketName}", searchByMarketName);

		filledUri = filledUri.replace("{searchByMarketCode}", searchByMarketCode);

		filledUri = filledUri.replace("{clientAccountId}", clientAccountId + "");

		filledUri = filledUri.replace("{maxResults}", maxResults + "");

		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		// return type result type get/post url params return type.class
		CIAPI.Java.examples.ciapi.dto.ListCfdMarketsResponseDTO result = (CIAPI.Java.examples.ciapi.dto.ListCfdMarketsResponseDTO) api
				.callGetMethod(fullUrl, CIAPI.Java.examples.ciapi.dto.ListCfdMarketsResponseDTO.class);
		return result;
	}

	/**
	 * !This is an auto generated method!
	 * 
	 * Returns a list of Spread Betting markets filtered by market name and/or
	 * market code
	 */
	@Override
	public CIAPI.Java.examples.ciapi.dto.ListSpreadMarketsResponseDTO ListSpreadMarkets(String searchByMarketName,
			String searchByMarketCode, int clientAccountId, int maxResults) throws ApiException {
		// Collect variables from method
		String target = "spread/markets";
		String uriTemplate = "?MarketName={searchByMarketName}&MarketCode={searchByMarketCode}&ClientAccountId={clientAccountId}&MaxResults={maxResults}";
		String transport = "GET";
		String envelope = "URL";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL.

		filledUri = filledUri.replace("{searchByMarketName}", searchByMarketName);

		filledUri = filledUri.replace("{searchByMarketCode}", searchByMarketCode);

		filledUri = filledUri.replace("{clientAccountId}", clientAccountId + "");

		filledUri = filledUri.replace("{maxResults}", maxResults + "");

		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		// return type result type get/post url params return type.class
		CIAPI.Java.examples.ciapi.dto.ListSpreadMarketsResponseDTO result = (CIAPI.Java.examples.ciapi.dto.ListSpreadMarketsResponseDTO) api
				.callGetMethod(fullUrl, CIAPI.Java.examples.ciapi.dto.ListSpreadMarketsResponseDTO.class);
		return result;
	}

	/**
	 * !This is an auto generated method!
	 * 
	 * Place an order on a particular market
	 */
	@Override
	public CIAPI.Java.examples.ciapi.dto.ApiTradeOrderResponseDTO Order(int MarketId, String Direction,
			double Quantity, double BidPrice, double OfferPrice, String AuditId, int TradingAccountId,
			String Applicability, String ExpiryDateTimeUTC) throws ApiException {
		// Collect variables from method
		String target = "order";
		String uriTemplate = "/order";
		String transport = "POST";
		String envelope = "JSON";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL.

		filledUri = filledUri.replace("{MarketId}", MarketId + "");

		filledUri = filledUri.replace("{Direction}", Direction);

		filledUri = filledUri.replace("{Quantity}", Quantity + "");

		filledUri = filledUri.replace("{BidPrice}", BidPrice + "");

		filledUri = filledUri.replace("{OfferPrice}", OfferPrice + "");

		filledUri = filledUri.replace("{AuditId}", AuditId);

		filledUri = filledUri.replace("{TradingAccountId}", TradingAccountId + "");

		filledUri = filledUri.replace("{Applicability}", Applicability);

		filledUri = filledUri.replace("{ExpiryDateTimeUTC}", ExpiryDateTimeUTC);

		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		// return type result type get/post url params return type.class
		CIAPI.Java.examples.ciapi.dto.ApiTradeOrderResponseDTO result = (CIAPI.Java.examples.ciapi.dto.ApiTradeOrderResponseDTO) api
				.callGetMethod(fullUrl, CIAPI.Java.examples.ciapi.dto.ApiTradeOrderResponseDTO.class);
		return result;
	}

	/**
	 * !This is an auto generated method!
	 * 
	 * Cancel an order
	 */
	@Override
	public CIAPI.Java.examples.ciapi.dto.ApiTradeOrderResponseDTO CancelOrder(int OrderId) throws ApiException {
		// Collect variables from method
		String target = "order";
		String uriTemplate = "/cancel";
		String transport = "POST";
		String envelope = "JSON";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL.

		filledUri = filledUri.replace("{OrderId}", OrderId + "");

		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		// return type result type get/post url params return type.class
		CIAPI.Java.examples.ciapi.dto.ApiTradeOrderResponseDTO result = (CIAPI.Java.examples.ciapi.dto.ApiTradeOrderResponseDTO) api
				.callGetMethod(fullUrl, CIAPI.Java.examples.ciapi.dto.ApiTradeOrderResponseDTO.class);
		return result;
	}

	/**
	 * !This is an auto generated method!
	 * 
	 * TODO
	 */
	@Override
	public CIAPI.Java.examples.ciapi.dto.ListOrdersResponseDTO ListOrders(int tradingAccountId, boolean openOrders,
			boolean acceptedOrders) throws ApiException {
		// Collect variables from method
		String target = "order";
		String uriTemplate = "/orders?TradingAccountId={tradingAccountId}&OpenOrders={openOrders}&AcceptedOrders={acceptedOrders}";
		String transport = "GET";
		String envelope = "URL";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL.

		filledUri = filledUri.replace("{tradingAccountId}", tradingAccountId + "");

		filledUri = filledUri.replace("{openOrders}", openOrders + "");

		filledUri = filledUri.replace("{acceptedOrders}", acceptedOrders + "");

		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		// return type result type get/post url params return type.class
		CIAPI.Java.examples.ciapi.dto.ListOrdersResponseDTO result = (CIAPI.Java.examples.ciapi.dto.ListOrdersResponseDTO) api
				.callGetMethod(fullUrl, CIAPI.Java.examples.ciapi.dto.ListOrdersResponseDTO.class);
		return result;
	}

	/**
	 * !This is an auto generated method!
	 * 
	 * TODO
	 */
	@Override
	public CIAPI.Java.examples.ciapi.dto.ListOpenPositionsResponseDTO ListOpenPositions(int tradingAccountId)
			throws ApiException {
		// Collect variables from method
		String target = "order";
		String uriTemplate = "/order/openpositions?TradingAccountId={tradingAccountId}";
		String transport = "GET";
		String envelope = "URL";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL.

		filledUri = filledUri.replace("{tradingAccountId}", tradingAccountId + "");

		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		// return type result type get/post url params return type.class
		CIAPI.Java.examples.ciapi.dto.ListOpenPositionsResponseDTO result = (CIAPI.Java.examples.ciapi.dto.ListOpenPositionsResponseDTO) api
				.callGetMethod(fullUrl, CIAPI.Java.examples.ciapi.dto.ListOpenPositionsResponseDTO.class);
		return result;
	}

	/**
	 * !This is an auto generated method!
	 * 
	 * TODO
	 */
	@Override
	public CIAPI.Java.examples.ciapi.dto.ListActiveStopLimitOrderResponseDTO ListActiveStopLimitOrders(
			int tradingAccountId) throws ApiException {
		// Collect variables from method
		String target = "order";
		String uriTemplate = "/order/activestoplimitorders?TradingAccountId={tradingAccountId}";
		String transport = "GET";
		String envelope = "URL";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL.

		filledUri = filledUri.replace("{tradingAccountId}", tradingAccountId + "");

		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		// return type result type get/post url params return type.class
		CIAPI.Java.examples.ciapi.dto.ListActiveStopLimitOrderResponseDTO result = (CIAPI.Java.examples.ciapi.dto.ListActiveStopLimitOrderResponseDTO) api
				.callGetMethod(fullUrl, CIAPI.Java.examples.ciapi.dto.ListActiveStopLimitOrderResponseDTO.class);
		return result;
	}

	/**
	 * !This is an auto generated method!
	 * 
	 * TODO
	 */
	@Override
	public CIAPI.Java.examples.ciapi.dto.ListTradeHistoryResponseDTO ListTradeHistory(int tradingAccountId,
			int maxResults) throws ApiException {
		// Collect variables from method
		String target = "order";
		String uriTemplate = "/order/tradehistory?TradingAccountId={tradingAccountId}&MaxResults={maxResults}";
		String transport = "GET";
		String envelope = "URL";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL.

		filledUri = filledUri.replace("{tradingAccountId}", tradingAccountId + "");

		filledUri = filledUri.replace("{maxResults}", maxResults + "");

		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		// return type result type get/post url params return type.class
		CIAPI.Java.examples.ciapi.dto.ListTradeHistoryResponseDTO result = (CIAPI.Java.examples.ciapi.dto.ListTradeHistoryResponseDTO) api
				.callGetMethod(fullUrl, CIAPI.Java.examples.ciapi.dto.ListTradeHistoryResponseDTO.class);
		return result;
	}

	/**
	 * !This is an auto generated method!
	 * 
	 * TODO
	 */
	@Override
	public CIAPI.Java.examples.ciapi.dto.ListStopLimitOrderHistoryResponseDTO ListStopLimitOrderHistory(
			int tradingAccountId, int maxResults) throws ApiException {
		// Collect variables from method
		String target = "order";
		String uriTemplate = "/order/stoplimitorderhistory?TradingAccountId={tradingAccountId}&MaxResults={maxResults}";
		String transport = "GET";
		String envelope = "URL";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL.

		filledUri = filledUri.replace("{tradingAccountId}", tradingAccountId + "");

		filledUri = filledUri.replace("{maxResults}", maxResults + "");

		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		// return type result type get/post url params return type.class
		CIAPI.Java.examples.ciapi.dto.ListStopLimitOrderHistoryResponseDTO result = (CIAPI.Java.examples.ciapi.dto.ListStopLimitOrderHistoryResponseDTO) api
				.callGetMethod(fullUrl, CIAPI.Java.examples.ciapi.dto.ListStopLimitOrderHistoryResponseDTO.class);
		return result;
	}

	/**
	 * !This is an auto generated method!
	 * 
	 * Place a trade on a particular market
	 */
	@Override
	public CIAPI.Java.examples.ciapi.dto.ApiTradeOrderResponseDTO Trade(int MarketId, String Direction,
			double Quantity, double BidPrice, double OfferPrice, String AuditId, int TradingAccountId)
			throws ApiException {
		// Collect variables from method
		String target = "order";
		String uriTemplate = "/trade";
		String transport = "POST";
		String envelope = "JSON";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL.

		filledUri = filledUri.replace("{MarketId}", MarketId + "");

		filledUri = filledUri.replace("{Direction}", Direction);

		filledUri = filledUri.replace("{Quantity}", Quantity + "");

		filledUri = filledUri.replace("{BidPrice}", BidPrice + "");

		filledUri = filledUri.replace("{OfferPrice}", OfferPrice + "");

		filledUri = filledUri.replace("{AuditId}", AuditId);

		filledUri = filledUri.replace("{TradingAccountId}", TradingAccountId + "");

		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		// return type result type get/post url params return type.class
		CIAPI.Java.examples.ciapi.dto.ApiTradeOrderResponseDTO result = (CIAPI.Java.examples.ciapi.dto.ApiTradeOrderResponseDTO) api
				.callGetMethod(fullUrl, CIAPI.Java.examples.ciapi.dto.ApiTradeOrderResponseDTO.class);
		return result;
	}

	/**
	 * !This is an auto generated method!
	 * 
	 * Whether a User is allowed to see Charting Data
	 */
	@Override
	public Boolean GetChartingEnabled(String id) throws ApiException {
		// Collect variables from method
		String target = "useraccount";
		String uriTemplate = "/UserAccount/{id}/ChartingEnabled";
		String transport = "GET";
		String envelope = "URL";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL.

		filledUri = filledUri.replace("{id}", id);

		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		// return type result type get/post url params return type.class
		Boolean result = (Boolean) api.callGetMethod(fullUrl, Boolean.class);
		return result;
	}

	/**
	 * !This is an auto generated method!
	 * 
	 * What are the Users Terms and Conditions
	 */
	@Override
	public String GetTermsAndConditions(String clientaccount) throws ApiException {
		// Collect variables from method
		String target = "useraccount";
		String uriTemplate = "/UserAccount/{clientaccount}/TermsAndConditions";
		String transport = "GET";
		String envelope = "URL";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL.

		filledUri = filledUri.replace("{clientaccount}", clientaccount);

		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		// return type result type get/post url params return type.class
		String result = (String) api.callGetMethod(fullUrl, String.class);
		return result;
	}

	/**
	 * !This is an auto generated method!
	 * 
	 * Returns the Users ClientAccountId and a list of their TradingAccounts
	 */
	@Override
	public CIAPI.Java.examples.ciapi.dto.AccountInformationResponseDTO GetClientAndTradingAccount() throws ApiException {
		// Collect variables from method
		String target = "useraccount";
		String uriTemplate = "/UserAccount/ClientAndTradingAccount";
		String transport = "GET";
		String envelope = "URL";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL.

		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		// return type result type get/post url params return type.class
		CIAPI.Java.examples.ciapi.dto.AccountInformationResponseDTO result = (CIAPI.Java.examples.ciapi.dto.AccountInformationResponseDTO) api
				.callGetMethod(fullUrl, CIAPI.Java.examples.ciapi.dto.AccountInformationResponseDTO.class);
		return result;
	}

	/**
	 * !This is an auto generated method!
	 * 
	 * Simulates an error condition.
	 */
	@Override
	public CIAPI.Java.examples.ciapi.dto.ErrorResponseDTO GenerateException(int errorCode) throws ApiException {
		// Collect variables from method
		String target = "errors";
		String uriTemplate = "?errorCode={errorCode}";
		String transport = "GET";
		String envelope = "URL";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL.

		filledUri = filledUri.replace("{errorCode}", errorCode + "");

		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		// return type result type get/post url params return type.class
		CIAPI.Java.examples.ciapi.dto.ErrorResponseDTO result = (CIAPI.Java.examples.ciapi.dto.ErrorResponseDTO) api
				.callGetMethod(fullUrl, CIAPI.Java.examples.ciapi.dto.ErrorResponseDTO.class);
		return result;
	}

}
