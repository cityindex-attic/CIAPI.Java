package CIAPI.Java.examples.ciapi;

import java.util.concurrent.Future;
import CIAPI.Java.ApiException;
import CIAPI.Java.JsonApi;
import CIAPI.Java.async.AsyncJsonApi;
import CIAPI.Java.async.CallBack;

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
	 * @param logOnRequest
	 *            Create a new session. The is how you "log on" to the CIAPI.
	 * 
	 * @param api
	 *            The JsonApi implementation that you would like.
	 */
	public CIAPI.Java.examples.ciapi.dto.CreateSessionResponseDTO CreateSession(
			CIAPI.Java.examples.ciapi.dto.LogOnRequestDTO logOnRequest, JsonApi api) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * Create a new session. The is how you "log on" to the CIAPI.
	 * 
	 * 
	 * @param logOnRequest
	 *            Create a new session. The is how you "log on" to the CIAPI.
	 * 
	 * @param api
	 *            The AsyncJsonApi implementation that you would like.
	 */
	public Future<Object> CreateSessionAsync(CIAPI.Java.examples.ciapi.dto.LogOnRequestDTO logOnRequest,
			AsyncJsonApi api, CallBack... callBacks) throws ApiException;

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
	 *            The AsyncJsonApi implementation that you would like.
	 */
	public Future<Object> DeleteSessionAsync(String userName, String session, AsyncJsonApi api, CallBack... callBacks)
			throws ApiException;

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
	 *            The AsyncJsonApi implementation that you would like.
	 */
	public Future<Object> GetPriceBarsAsync(String marketId, String interval, int span, String priceBars,
			AsyncJsonApi api, CallBack... callBacks) throws ApiException;

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
	 *            The AsyncJsonApi implementation that you would like.
	 */
	public Future<Object> GetPriceTicksAsync(String marketId, String priceTicks, AsyncJsonApi api,
			CallBack... callBacks) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * Get Market Information for the specified market. You must be authorised
	 * to view the market, or the query will fail.
	 * 
	 * 
	 * @param marketId
	 *            The marketId
	 * 
	 * @param api
	 *            The JsonApi implementation that you would like.
	 */
	public CIAPI.Java.examples.ciapi.dto.GetMarketInformationResponseDTO GetMarketInformation(String marketId,
			JsonApi api) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * Get Market Information for the specified market. You must be authorised
	 * to view the market, or the query will fail.
	 * 
	 * 
	 * @param marketId
	 *            The marketId
	 * 
	 * @param api
	 *            The AsyncJsonApi implementation that you would like.
	 */
	public Future<Object> GetMarketInformationAsync(String marketId, AsyncJsonApi api, CallBack... callBacks)
			throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * Get Market Information for markets that fit the query.
	 * 
	 * 
	 * @param searchByMarketCode
	 *            Should the search be done by market code
	 * 
	 * @param searchByMarketName
	 *            Should the search be done by market Name
	 * 
	 * @param spreadProductType
	 *            Should the search include spread bet markets
	 * 
	 * @param cfdProductType
	 *            Should the search include CFD markets
	 * 
	 * @param binaryProductType
	 *            Should the search include binary markets
	 * 
	 * @param query
	 *            The text to search for. Matches part of market name / code
	 *            from the start.
	 * 
	 * @param maxResults
	 *            The maximum number of results to return
	 * 
	 * @param api
	 *            The JsonApi implementation that you would like.
	 */
	public CIAPI.Java.examples.ciapi.dto.ListMarketInformationSearchResponseDTO ListMarketInformationSearch(
			boolean searchByMarketCode, boolean searchByMarketName, boolean spreadProductType, boolean cfdProductType,
			boolean binaryProductType, String query, int maxResults, JsonApi api) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * Get Market Information for markets that fit the query.
	 * 
	 * 
	 * @param searchByMarketCode
	 *            Should the search be done by market code
	 * 
	 * @param searchByMarketName
	 *            Should the search be done by market Name
	 * 
	 * @param spreadProductType
	 *            Should the search include spread bet markets
	 * 
	 * @param cfdProductType
	 *            Should the search include CFD markets
	 * 
	 * @param binaryProductType
	 *            Should the search include binary markets
	 * 
	 * @param query
	 *            The text to search for. Matches part of market name / code
	 *            from the start.
	 * 
	 * @param maxResults
	 *            The maximum number of results to return
	 * 
	 * @param api
	 *            The AsyncJsonApi implementation that you would like.
	 */
	public Future<Object> ListMarketInformationSearchAsync(boolean searchByMarketCode, boolean searchByMarketName,
			boolean spreadProductType, boolean cfdProductType, boolean binaryProductType, String query, int maxResults,
			AsyncJsonApi api, CallBack... callBacks) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * Get Market Information for the specified list of markets. You must be
	 * authorised to view all the markets in the supplied list, or the query
	 * will fail.
	 * 
	 * 
	 * @param listMarketInformationRequestDTO
	 *            Get Market Information for the specified list of markets. You
	 *            must be authorised to view all the markets in the supplied
	 *            list, or the query will fail.
	 * 
	 * @param api
	 *            The JsonApi implementation that you would like.
	 */
	public CIAPI.Java.examples.ciapi.dto.ListMarketInformationResponseDTO ListMarketInformation(
			CIAPI.Java.examples.ciapi.dto.ListMarketInformationRequestDTO[] listMarketInformationRequestDTO, JsonApi api)
			throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * Get Market Information for the specified list of markets. You must be
	 * authorised to view all the markets in the supplied list, or the query
	 * will fail.
	 * 
	 * 
	 * @param listMarketInformationRequestDTO
	 *            Get Market Information for the specified list of markets. You
	 *            must be authorised to view all the markets in the supplied
	 *            list, or the query will fail.
	 * 
	 * @param api
	 *            The AsyncJsonApi implementation that you would like.
	 */
	public Future<Object> ListMarketInformationAsync(
			CIAPI.Java.examples.ciapi.dto.ListMarketInformationRequestDTO[] listMarketInformationRequestDTO,
			AsyncJsonApi api, CallBack... callBacks) throws ApiException;

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
	 *            The AsyncJsonApi implementation that you would like.
	 */
	public Future<Object> ListNewsHeadlinesAsync(String category, int maxResults, AsyncJsonApi api,
			CallBack... callBacks) throws ApiException;

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
	 * Get the detail of a specific news story
	 * 
	 * 
	 * @param storyId
	 *            The news story Id
	 * 
	 * @param api
	 *            The AsyncJsonApi implementation that you would like.
	 */
	public Future<Object> GetNewsDetailAsync(String storyId, AsyncJsonApi api, CallBack... callBacks)
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
	 *            The AsyncJsonApi implementation that you would like.
	 */
	public Future<Object> ListCfdMarketsAsync(String searchByMarketName, String searchByMarketCode,
			int clientAccountId, int maxResults, AsyncJsonApi api, CallBack... callBacks) throws ApiException;

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
	 *            The AsyncJsonApi implementation that you would like.
	 */
	public Future<Object> ListSpreadMarketsAsync(String searchByMarketName, String searchByMarketCode,
			int clientAccountId, int maxResults, AsyncJsonApi api, CallBack... callBacks) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * Place an order on a particular market
	 * 
	 * 
	 * @param order
	 *            The order request
	 * 
	 * @param api
	 *            The JsonApi implementation that you would like.
	 */
	public CIAPI.Java.examples.ciapi.dto.ApiTradeOrderResponseDTO Order(
			CIAPI.Java.examples.ciapi.dto.NewStopLimitOrderRequestDTO order, JsonApi api) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * Place an order on a particular market
	 * 
	 * 
	 * @param order
	 *            The order request
	 * 
	 * @param api
	 *            The AsyncJsonApi implementation that you would like.
	 */
	public Future<Object> OrderAsync(CIAPI.Java.examples.ciapi.dto.NewStopLimitOrderRequestDTO order, AsyncJsonApi api,
			CallBack... callBacks) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * Cancel an order
	 * 
	 * 
	 * @param cancelOrder
	 *            The cancel order request
	 * 
	 * @param api
	 *            The JsonApi implementation that you would like.
	 */
	public CIAPI.Java.examples.ciapi.dto.ApiTradeOrderResponseDTO CancelOrder(
			CIAPI.Java.examples.ciapi.dto.CancelOrderRequestDTO cancelOrder, JsonApi api) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * Cancel an order
	 * 
	 * 
	 * @param cancelOrder
	 *            The cancel order request
	 * 
	 * @param api
	 *            The AsyncJsonApi implementation that you would like.
	 */
	public Future<Object> CancelOrderAsync(CIAPI.Java.examples.ciapi.dto.CancelOrderRequestDTO cancelOrder,
			AsyncJsonApi api, CallBack... callBacks) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * Not Implemented.
	 * 
	 * 
	 * @param tradingAccountId
	 *            Not Implemented.
	 * 
	 * @param openOrders
	 *            Not Implemented.
	 * 
	 * @param acceptedOrders
	 *            Not Implemented.
	 * 
	 * @param api
	 *            The JsonApi implementation that you would like.
	 */
	public CIAPI.Java.examples.ciapi.dto.ListOrdersResponseDTO ListOrders(int tradingAccountId, boolean openOrders,
			boolean acceptedOrders, JsonApi api) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * Not Implemented.
	 * 
	 * 
	 * @param tradingAccountId
	 *            Not Implemented.
	 * 
	 * @param openOrders
	 *            Not Implemented.
	 * 
	 * @param acceptedOrders
	 *            Not Implemented.
	 * 
	 * @param api
	 *            The AsyncJsonApi implementation that you would like.
	 */
	public Future<Object> ListOrdersAsync(int tradingAccountId, boolean openOrders, boolean acceptedOrders,
			AsyncJsonApi api, CallBack... callBacks) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * Queries for a specified trading account's trades / open positions.
	 * 
	 * 
	 * @param tradingAccountId
	 *            Queries for a specified trading account's trades / open
	 *            positions.
	 * 
	 * @param api
	 *            The JsonApi implementation that you would like.
	 */
	public CIAPI.Java.examples.ciapi.dto.ListOpenPositionsResponseDTO ListOpenPositions(int tradingAccountId,
			JsonApi api) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * Queries for a specified trading account's trades / open positions.
	 * 
	 * 
	 * @param tradingAccountId
	 *            Queries for a specified trading account's trades / open
	 *            positions.
	 * 
	 * @param api
	 *            The AsyncJsonApi implementation that you would like.
	 */
	public Future<Object> ListOpenPositionsAsync(int tradingAccountId, AsyncJsonApi api, CallBack... callBacks)
			throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * Queries for a specified trading account's active stop / limit orders.
	 * 
	 * 
	 * @param tradingAccountId
	 *            Queries for a specified trading account's active stop / limit
	 *            orders.
	 * 
	 * @param api
	 *            The JsonApi implementation that you would like.
	 */
	public CIAPI.Java.examples.ciapi.dto.ListActiveStopLimitOrderResponseDTO ListActiveStopLimitOrders(
			int tradingAccountId, JsonApi api) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * Queries for a specified trading account's active stop / limit orders.
	 * 
	 * 
	 * @param tradingAccountId
	 *            Queries for a specified trading account's active stop / limit
	 *            orders.
	 * 
	 * @param api
	 *            The AsyncJsonApi implementation that you would like.
	 */
	public Future<Object> ListActiveStopLimitOrdersAsync(int tradingAccountId, AsyncJsonApi api, CallBack... callBacks)
			throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * Queries for a active stop limit order with a specified order id. It will
	 * return a null value if the order doesn't exist, or is not an active stop
	 * limit order.
	 * 
	 * 
	 * @param orderId
	 *            Queries for a active stop limit order with a specified order
	 *            id. It will return a null value if the order doesn't exist, or
	 *            is not an active stop limit order.
	 * 
	 * @param api
	 *            The JsonApi implementation that you would like.
	 */
	public CIAPI.Java.examples.ciapi.dto.GetActiveStopLimitOrderResponseDTO GetActiveStopLimitOrder(String orderId,
			JsonApi api) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * Queries for a active stop limit order with a specified order id. It will
	 * return a null value if the order doesn't exist, or is not an active stop
	 * limit order.
	 * 
	 * 
	 * @param orderId
	 *            Queries for a active stop limit order with a specified order
	 *            id. It will return a null value if the order doesn't exist, or
	 *            is not an active stop limit order.
	 * 
	 * @param api
	 *            The AsyncJsonApi implementation that you would like.
	 */
	public Future<Object> GetActiveStopLimitOrderAsync(String orderId, AsyncJsonApi api, CallBack... callBacks)
			throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * Queries for a trade / open position with a specified order id. It will
	 * return a null value if the order doesn't exist, or is not a trade / open
	 * position.
	 * 
	 * 
	 * @param orderId
	 *            Queries for a trade / open position with a specified order id.
	 *            It will return a null value if the order doesn't exist, or is
	 *            not a trade / open position.
	 * 
	 * @param api
	 *            The JsonApi implementation that you would like.
	 */
	public CIAPI.Java.examples.ciapi.dto.GetOpenPositionResponseDTO GetOpenPosition(String orderId, JsonApi api)
			throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * Queries for a trade / open position with a specified order id. It will
	 * return a null value if the order doesn't exist, or is not a trade / open
	 * position.
	 * 
	 * 
	 * @param orderId
	 *            Queries for a trade / open position with a specified order id.
	 *            It will return a null value if the order doesn't exist, or is
	 *            not a trade / open position.
	 * 
	 * @param api
	 *            The AsyncJsonApi implementation that you would like.
	 */
	public Future<Object> GetOpenPositionAsync(String orderId, AsyncJsonApi api, CallBack... callBacks)
			throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * Queries for a specified trading account's trade history.
	 * 
	 * 
	 * @param tradingAccountId
	 *            Queries for a specified trading account's trade history.
	 * 
	 * @param maxResults
	 *            Queries for a specified trading account's trade history.
	 * 
	 * @param api
	 *            The JsonApi implementation that you would like.
	 */
	public CIAPI.Java.examples.ciapi.dto.ListTradeHistoryResponseDTO ListTradeHistory(int tradingAccountId,
			int maxResults, JsonApi api) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * Queries for a specified trading account's trade history.
	 * 
	 * 
	 * @param tradingAccountId
	 *            Queries for a specified trading account's trade history.
	 * 
	 * @param maxResults
	 *            Queries for a specified trading account's trade history.
	 * 
	 * @param api
	 *            The AsyncJsonApi implementation that you would like.
	 */
	public Future<Object> ListTradeHistoryAsync(int tradingAccountId, int maxResults, AsyncJsonApi api,
			CallBack... callBacks) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * Queries for a specified trading account's stop / limit order history.
	 * 
	 * 
	 * @param tradingAccountId
	 *            Queries for a specified trading account's stop / limit order
	 *            history.
	 * 
	 * @param maxResults
	 *            Queries for a specified trading account's stop / limit order
	 *            history.
	 * 
	 * @param api
	 *            The JsonApi implementation that you would like.
	 */
	public CIAPI.Java.examples.ciapi.dto.ListStopLimitOrderHistoryResponseDTO ListStopLimitOrderHistory(
			int tradingAccountId, int maxResults, JsonApi api) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * Queries for a specified trading account's stop / limit order history.
	 * 
	 * 
	 * @param tradingAccountId
	 *            Queries for a specified trading account's stop / limit order
	 *            history.
	 * 
	 * @param maxResults
	 *            Queries for a specified trading account's stop / limit order
	 *            history.
	 * 
	 * @param api
	 *            The AsyncJsonApi implementation that you would like.
	 */
	public Future<Object> ListStopLimitOrderHistoryAsync(int tradingAccountId, int maxResults, AsyncJsonApi api,
			CallBack... callBacks) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * Queries for an order by a specific order id. The current implementation
	 * only returns active orders (i.e. those with a status of 1 - Pending, 2 -
	 * Accepted, 3 - Open, 6 - Suspended, 8 - Yellow Card, 11 - Triggered).
	 * 
	 * 
	 * @param orderId
	 *            Queries for an order by a specific order id. The current
	 *            implementation only returns active orders (i.e. those with a
	 *            status of 1 - Pending, 2 - Accepted, 3 - Open, 6 - Suspended,
	 *            8 - Yellow Card, 11 - Triggered).
	 * 
	 * @param api
	 *            The JsonApi implementation that you would like.
	 */
	public CIAPI.Java.examples.ciapi.dto.GetOrderResponseDTO GetOrder(String orderId, JsonApi api) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * Queries for an order by a specific order id. The current implementation
	 * only returns active orders (i.e. those with a status of 1 - Pending, 2 -
	 * Accepted, 3 - Open, 6 - Suspended, 8 - Yellow Card, 11 - Triggered).
	 * 
	 * 
	 * @param orderId
	 *            Queries for an order by a specific order id. The current
	 *            implementation only returns active orders (i.e. those with a
	 *            status of 1 - Pending, 2 - Accepted, 3 - Open, 6 - Suspended,
	 *            8 - Yellow Card, 11 - Triggered).
	 * 
	 * @param api
	 *            The AsyncJsonApi implementation that you would like.
	 */
	public Future<Object> GetOrderAsync(String orderId, AsyncJsonApi api, CallBack... callBacks) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * Place a trade on a particular market
	 * 
	 * 
	 * @param trade
	 *            Place a trade on a particular market
	 * 
	 * @param api
	 *            The JsonApi implementation that you would like.
	 */
	public CIAPI.Java.examples.ciapi.dto.ApiTradeOrderResponseDTO Trade(
			CIAPI.Java.examples.ciapi.dto.NewTradeOrderRequestDTO trade, JsonApi api) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * Place a trade on a particular market
	 * 
	 * 
	 * @param trade
	 *            Place a trade on a particular market
	 * 
	 * @param api
	 *            The AsyncJsonApi implementation that you would like.
	 */
	public Future<Object> TradeAsync(CIAPI.Java.examples.ciapi.dto.NewTradeOrderRequestDTO trade, AsyncJsonApi api,
			CallBack... callBacks) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * Update a trade
	 * 
	 * 
	 * @param update
	 *            Update a trade
	 * 
	 * @param api
	 *            The JsonApi implementation that you would like.
	 */
	public CIAPI.Java.examples.ciapi.dto.ApiTradeOrderResponseDTO Update(
			CIAPI.Java.examples.ciapi.dto.UpdateTradeOrderRequestDTO update, JsonApi api) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * Update a trade
	 * 
	 * 
	 * @param update
	 *            Update a trade
	 * 
	 * @param api
	 *            The AsyncJsonApi implementation that you would like.
	 */
	public Future<Object> UpdateAsync(CIAPI.Java.examples.ciapi.dto.UpdateTradeOrderRequestDTO update,
			AsyncJsonApi api, CallBack... callBacks) throws ApiException;

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
	 *            The AsyncJsonApi implementation that you would like.
	 */
	public Future<Object> GenerateExceptionAsync(int errorCode, AsyncJsonApi api, CallBack... callBacks)
			throws ApiException;

}
