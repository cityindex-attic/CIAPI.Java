package CIAPI.Java.examples.ciapi;

import CIAPI.Java.ApiException;
import CIAPI.Java.JsonApi;

/**
 * Auto-generated interface for interacting with the REST CIAPI
 * 
 */
public interface ServiceMethods {

	/**
	 * !This is an auto generated method signature!
	 * 
	 * Create a new session. The is how you "log on" to the CIAPI.
	 * 
	 * 
	 * @param UserName
	 *            Username is case sensitive
	 * 
	 * @param Password
	 *            Password is case sensitive
	 * 
	 * @param api
	 *            The JsonApi implementation that you would like.
	 */
	public CIAPI.Java.examples.ciapi.dto.CreateSessionResponseDTO CreateSession(String UserName, String Password,
			JsonApi api) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * Delete a session. This is how you "log off" from the CIAPI.
	 * 
	 * 
	 * @param userName
	 *            Username is case sensitive. May be set as a service parameter
	 *            or as a request header.
	 * 
	 * @param session
	 *            The session token. May be set as a service parameter or as a
	 *            request header.
	 * 
	 * @param api
	 *            The JsonApi implementation that you would like.
	 */
	public CIAPI.Java.examples.ciapi.dto.SessionDeletionResponseDTO DeleteSession(String userName, String session,
			JsonApi api) throws ApiException;

	/**
	 * !This is an auto generated method signature!
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
	 * 
	 * 
	 * @param marketId
	 *            The marketId
	 * 
	 * @param interval
	 *            The pricebar interval
	 * 
	 * @param span
	 *            The number of each interval per pricebar.
	 * 
	 * @param priceBars
	 *            The total number of pricebars to return
	 * 
	 * @param api
	 *            The JsonApi implementation that you would like.
	 */
	public CIAPI.Java.examples.ciapi.dto.GetPriceBarResponseDTO GetPriceBars(String marketId, String interval,
			int span, String priceBars, JsonApi api) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * Get historic price ticks. Returns price ticks in ascending order up to
	 * the current time. The length of time between each tick will be different.
	 * 
	 * 
	 * @param marketId
	 *            The marketId
	 * 
	 * @param priceTicks
	 *            The total number of price ticks to return
	 * 
	 * @param api
	 *            The JsonApi implementation that you would like.
	 */
	public CIAPI.Java.examples.ciapi.dto.GetPriceTickResponseDTO GetPriceTicks(String marketId, String priceTicks,
			JsonApi api) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * Get Market Information for the specified market.
	 * 
	 * 
	 * @param marketId
	 *            The marketId
	 * 
	 * @param api
	 *            The JsonApi implementation that you would like.
	 */
	public CIAPI.Java.examples.ciapi.dto.MarketInformationResponseDTO GetMarketInformation(String marketId, JsonApi api)
			throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * Get a list of current news headlines
	 * 
	 * 
	 * @param category
	 *            Filter headlines by category
	 * 
	 * @param maxResults
	 *            Restrict the number of headlines returned
	 * 
	 * @param api
	 *            The JsonApi implementation that you would like.
	 */
	public CIAPI.Java.examples.ciapi.dto.ListNewsHeadlinesResponseDTO ListNewsHeadlines(String category,
			int maxResults, JsonApi api) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * Get the detail of a specific news story
	 * 
	 * 
	 * @param storyId
	 *            The news story Id
	 * 
	 * @param api
	 *            The JsonApi implementation that you would like.
	 */
	public CIAPI.Java.examples.ciapi.dto.GetNewsDetailResponseDTO GetNewsDetail(String storyId, JsonApi api)
			throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * Returns a list of CFD markets filtered by market name and/or market code
	 * 
	 * 
	 * @param searchByMarketName
	 *            The characters that the CFD market name should start with
	 * 
	 * @param searchByMarketCode
	 *            The characters that the market code should start with
	 *            (normally this is the RIC code for the market)
	 * 
	 * @param clientAccountId
	 *            The logged on user's ClientAccountId. (This only shows you
	 *            markets that you can trade on)
	 * 
	 * @param maxResults
	 *            The maximum number of markets to return.
	 * 
	 * @param api
	 *            The JsonApi implementation that you would like.
	 */
	public CIAPI.Java.examples.ciapi.dto.ListCfdMarketsResponseDTO ListCfdMarkets(String searchByMarketName,
			String searchByMarketCode, int clientAccountId, int maxResults, JsonApi api) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * Returns a list of Spread Betting markets filtered by market name and/or
	 * market code
	 * 
	 * 
	 * @param searchByMarketName
	 *            The characters that the Spread market name should start with
	 * 
	 * @param searchByMarketCode
	 *            The characters that the Spread market code should start with
	 *            (normally this is the RIC code for the market)
	 * 
	 * @param clientAccountId
	 *            The logged on user's ClientAccountId. (This only shows you
	 *            markets that you can trade on)
	 * 
	 * @param maxResults
	 *            The maximum number of markets to return.
	 * 
	 * @param api
	 *            The JsonApi implementation that you would like.
	 */
	public CIAPI.Java.examples.ciapi.dto.ListSpreadMarketsResponseDTO ListSpreadMarkets(String searchByMarketName,
			String searchByMarketCode, int clientAccountId, int maxResults, JsonApi api) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * Place an order on a particular market
	 * 
	 * 
	 * @param MarketId
	 *            A market's unique identifier
	 * 
	 * @param Direction
	 *            Direction identifier for order/trade, values supported are buy
	 *            or sell
	 * 
	 * @param Quantity
	 *            Size of the order/trade
	 * 
	 * @param BidPrice
	 *            Market prices are quoted as a pair (buy/sell or bid/offer),
	 *            the BidPrice is the lower of the two
	 * 
	 * @param OfferPrice
	 *            Market prices are quote as a pair (buy/sell or bid/offer), the
	 *            OfferPrice is the higher of the market price pair
	 * 
	 * @param AuditId
	 *            Unique identifier for a price tick
	 * 
	 * @param TradingAccountId
	 *            TradingAccount associated with the trade/order request
	 * 
	 * @param Applicability
	 *            Identifier which relates to the expiry of the order/trade,
	 *            i.e. GoodTillDate (GTD), GoodTillCancelled (GTC) or GoodForDay
	 *            (GFD)
	 * 
	 * @param ExpiryDateTimeUTC
	 *            The associated expiry DateTime for a pair of GoodTillDate
	 *            IfDone orders
	 * 
	 * @param api
	 *            The JsonApi implementation that you would like.
	 */
	public CIAPI.Java.examples.ciapi.dto.ApiTradeOrderResponseDTO Order(int MarketId, String Direction,
			double Quantity, double BidPrice, double OfferPrice, String AuditId, int TradingAccountId,
			String Applicability, String ExpiryDateTimeUTC, JsonApi api) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * Cancel an order
	 * 
	 * 
	 * @param OrderId
	 *            The order identifier
	 * 
	 * @param api
	 *            The JsonApi implementation that you would like.
	 */
	public CIAPI.Java.examples.ciapi.dto.ApiTradeOrderResponseDTO CancelOrder(int OrderId, JsonApi api)
			throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * TODO
	 * 
	 * 
	 * @param tradingAccountId
	 *            TODO
	 * 
	 * @param openOrders
	 *            TODO
	 * 
	 * @param acceptedOrders
	 *            TODO
	 * 
	 * @param api
	 *            The JsonApi implementation that you would like.
	 */
	public CIAPI.Java.examples.ciapi.dto.ListOrdersResponseDTO ListOrders(int tradingAccountId, boolean openOrders,
			boolean acceptedOrders, JsonApi api) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * TODO
	 * 
	 * 
	 * @param tradingAccountId
	 *            TODO
	 * 
	 * @param api
	 *            The JsonApi implementation that you would like.
	 */
	public CIAPI.Java.examples.ciapi.dto.ListOpenPositionsResponseDTO ListOpenPositions(int tradingAccountId,
			JsonApi api) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * TODO
	 * 
	 * 
	 * @param tradingAccountId
	 *            TODO
	 * 
	 * @param api
	 *            The JsonApi implementation that you would like.
	 */
	public CIAPI.Java.examples.ciapi.dto.ListActiveStopLimitOrderResponseDTO ListActiveStopLimitOrders(
			int tradingAccountId, JsonApi api) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * TODO
	 * 
	 * 
	 * @param tradingAccountId
	 *            TODO
	 * 
	 * @param maxResults
	 *            TODO
	 * 
	 * @param api
	 *            The JsonApi implementation that you would like.
	 */
	public CIAPI.Java.examples.ciapi.dto.ListTradeHistoryResponseDTO ListTradeHistory(int tradingAccountId,
			int maxResults, JsonApi api) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * TODO
	 * 
	 * 
	 * @param tradingAccountId
	 *            TODO
	 * 
	 * @param maxResults
	 *            TODO
	 * 
	 * @param api
	 *            The JsonApi implementation that you would like.
	 */
	public CIAPI.Java.examples.ciapi.dto.ListStopLimitOrderHistoryResponseDTO ListStopLimitOrderHistory(
			int tradingAccountId, int maxResults, JsonApi api) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * Place a trade on a particular market
	 * 
	 * 
	 * @param MarketId
	 *            A market's unique identifier
	 * 
	 * @param Direction
	 *            Direction identifier for order/trade, values supported are buy
	 *            or sell
	 * 
	 * @param Quantity
	 *            Size of the order/trade
	 * 
	 * @param BidPrice
	 *            Market prices are quoted as a pair (buy/sell or bid/offer),
	 *            the BidPrice is the lower of the two
	 * 
	 * @param OfferPrice
	 *            Market prices are quote as a pair (buy/sell or bid/offer), the
	 *            OfferPrice is the higher of the market price pair
	 * 
	 * @param AuditId
	 *            Unique identifier for a price tick
	 * 
	 * @param TradingAccountId
	 *            TradingAccount associated with the trade/order request
	 * 
	 * @param api
	 *            The JsonApi implementation that you would like.
	 */
	public CIAPI.Java.examples.ciapi.dto.ApiTradeOrderResponseDTO Trade(int MarketId, String Direction,
			double Quantity, double BidPrice, double OfferPrice, String AuditId, int TradingAccountId, JsonApi api)
			throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * Whether a User is allowed to see Charting Data
	 * 
	 * 
	 * @param id
	 *            Whether a User is allowed to see Charting Data
	 * 
	 * @param api
	 *            The JsonApi implementation that you would like.
	 */
	public Boolean GetChartingEnabled(String id, JsonApi api) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * What are the Users Terms and Conditions
	 * 
	 * 
	 * @param clientaccount
	 *            What are the Users Terms and Conditions
	 * 
	 * @param api
	 *            The JsonApi implementation that you would like.
	 */
	public String GetTermsAndConditions(String clientaccount, JsonApi api) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * Returns the Users ClientAccountId and a list of their TradingAccounts
	 * 
	 * 
	 * @param api
	 *            The JsonApi implementation that you would like.
	 */
	public CIAPI.Java.examples.ciapi.dto.AccountInformationResponseDTO GetClientAndTradingAccount(JsonApi api)
			throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * Simulates an error condition.
	 * 
	 * 
	 * @param errorCode
	 *            Simulates an error condition.
	 * 
	 * @param api
	 *            The JsonApi implementation that you would like.
	 */
	public CIAPI.Java.examples.ciapi.dto.ErrorResponseDTO GenerateException(int errorCode, JsonApi api)
			throws ApiException;

}
