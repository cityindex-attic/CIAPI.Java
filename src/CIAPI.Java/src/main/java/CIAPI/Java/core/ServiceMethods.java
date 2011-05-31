package CIAPI.Java.core;

import java.util.concurrent.Future;

import CIAPI.Java.core.dto.AccountInformationResponseDTO;
import CIAPI.Java.core.dto.ApiErrorResponseDTO;
import CIAPI.Java.core.dto.ApiIfDoneDTO;
import CIAPI.Java.core.dto.ApiLogOffResponseDTO;
import CIAPI.Java.core.dto.ApiLogOnResponseDTO;
import CIAPI.Java.core.dto.ApiTradeOrderResponseDTO;
import CIAPI.Java.core.dto.GetActiveStopLimitOrderResponseDTO;
import CIAPI.Java.core.dto.GetMarketInformationResponseDTO;
import CIAPI.Java.core.dto.GetNewsDetailResponseDTO;
import CIAPI.Java.core.dto.GetOpenPositionResponseDTO;
import CIAPI.Java.core.dto.GetOrderResponseDTO;
import CIAPI.Java.core.dto.GetPriceBarResponseDTO;
import CIAPI.Java.core.dto.GetPriceTickResponseDTO;
import CIAPI.Java.core.dto.ListActiveStopLimitOrderResponseDTO;
import CIAPI.Java.core.dto.ListCfdMarketsResponseDTO;
import CIAPI.Java.core.dto.ListMarketInformationResponseDTO;
import CIAPI.Java.core.dto.ListMarketInformationSearchResponseDTO;
import CIAPI.Java.core.dto.ListNewsHeadlinesResponseDTO;
import CIAPI.Java.core.dto.ListOpenPositionsResponseDTO;
import CIAPI.Java.core.dto.ListSpreadMarketsResponseDTO;
import CIAPI.Java.core.dto.ListStopLimitOrderHistoryResponseDTO;
import CIAPI.Java.core.dto.ListTradeHistoryResponseDTO;
import CIAPI.Java.core.dto.NewStopLimitOrderRequestDTO;
import JsonClient.Java.ApiException;
import JsonClient.Java.JsonApi;
import JsonClient.Java.async.AsyncJsonApi;
import JsonClient.Java.async.CallBack;

/**
 * Auto-generated interface for interacting with the REST CIAPI
 * 
 */
public interface ServiceMethods {

	/**
	 * !This is an auto generated method signature!
	 * 
	 * <p>
	 * Create a new session. This is how you "log on" to the CIAPI. Post a <a
	 * onclick="dojo.hash('#type.ApiLogOnRequestDTO'); return false;"
	 * class="json-link" href="#">ApiLogOnRequestDTO</a> to the uri specified
	 * below
	 * </p>
	 * 
	 * 
	 * @param api
	 *            The JsonApi implementation that you would like.
	 */
	public ApiLogOnResponseDTO LogOn(String UserName, String Password,
			JsonApi api) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * <p>
	 * Create a new session. This is how you "log on" to the CIAPI. Post a <a
	 * onclick="dojo.hash('#type.ApiLogOnRequestDTO'); return false;"
	 * class="json-link" href="#">ApiLogOnRequestDTO</a> to the uri specified
	 * below
	 * </p>
	 * 
	 * 
	 * @param api
	 *            The AsyncJsonApi implementation that you would like.
	 */
	public Future<Object> LogOnAsync(String UserName, String Password,
			AsyncJsonApi api, CallBack... callBacks) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * <p>
	 * Delete a session. This is how you "log off" from the CIAPI.
	 * </p>
	 * 
	 * 
	 * @param api
	 *            The JsonApi implementation that you would like.
	 */
	public ApiLogOffResponseDTO DeleteSession(String userName, String session,
			JsonApi api) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * <p>
	 * Delete a session. This is how you "log off" from the CIAPI.
	 * </p>
	 * 
	 * 
	 * @param api
	 *            The AsyncJsonApi implementation that you would like.
	 */
	public Future<Object> DeleteSessionAsync(String userName, String session,
			AsyncJsonApi api, CallBack... callBacks) throws ApiException;

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
	 * @param api
	 *            The JsonApi implementation that you would like.
	 */
	public GetPriceBarResponseDTO GetPriceBars(String marketId,
			String interval, int span, String priceBars, JsonApi api)
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
	 * @param api
	 *            The AsyncJsonApi implementation that you would like.
	 */
	public Future<Object> GetPriceBarsAsync(String marketId, String interval,
			int span, String priceBars, AsyncJsonApi api, CallBack... callBacks)
			throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * Get historic price ticks. Returns price ticks in ascending order up to
	 * the current time. The length of time between each tick will be different.
	 * 
	 * 
	 * @param api
	 *            The JsonApi implementation that you would like.
	 */
	public GetPriceTickResponseDTO GetPriceTicks(String marketId,
			String priceTicks, JsonApi api) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * Get historic price ticks. Returns price ticks in ascending order up to
	 * the current time. The length of time between each tick will be different.
	 * 
	 * 
	 * @param api
	 *            The AsyncJsonApi implementation that you would like.
	 */
	public Future<Object> GetPriceTicksAsync(String marketId,
			String priceTicks, AsyncJsonApi api, CallBack... callBacks)
			throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * <p>
	 * Get Market Information for the specified market.
	 * </p>
	 * 
	 * 
	 * @param api
	 *            The JsonApi implementation that you would like.
	 */
	public GetMarketInformationResponseDTO GetMarketInformation(
			String marketId, JsonApi api) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * <p>
	 * Get Market Information for the specified market.
	 * </p>
	 * 
	 * 
	 * @param api
	 *            The AsyncJsonApi implementation that you would like.
	 */
	public Future<Object> GetMarketInformationAsync(String marketId,
			AsyncJsonApi api, CallBack... callBacks) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * <p>
	 * Queries for market information.
	 * </p>
	 * 
	 * 
	 * @param api
	 *            The JsonApi implementation that you would like.
	 */
	public ListMarketInformationSearchResponseDTO ListMarketInformationSearch(
			boolean searchByMarketCode, boolean searchByMarketName,
			boolean spreadProductType, boolean cfdProductType,
			boolean binaryProductType, String query, int maxResults, JsonApi api)
			throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * <p>
	 * Queries for market information.
	 * </p>
	 * 
	 * 
	 * @param api
	 *            The AsyncJsonApi implementation that you would like.
	 */
	public Future<Object> ListMarketInformationSearchAsync(
			boolean searchByMarketCode, boolean searchByMarketName,
			boolean spreadProductType, boolean cfdProductType,
			boolean binaryProductType, String query, int maxResults,
			AsyncJsonApi api, CallBack... callBacks) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * <p>
	 * Queries for market information.
	 * </p>
	 * 
	 * 
	 * @param api
	 *            The JsonApi implementation that you would like.
	 */
	public ListMarketInformationResponseDTO ListMarketInformation(
			int[] MarketIds, JsonApi api) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * <p>
	 * Queries for market information.
	 * </p>
	 * 
	 * 
	 * @param api
	 *            The AsyncJsonApi implementation that you would like.
	 */
	public Future<Object> ListMarketInformationAsync(int[] MarketIds,
			AsyncJsonApi api, CallBack... callBacks) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * Get a list of current news headlines
	 * 
	 * 
	 * @param api
	 *            The JsonApi implementation that you would like.
	 */
	public ListNewsHeadlinesResponseDTO ListNewsHeadlines(String category,
			int maxResults, JsonApi api) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * Get a list of current news headlines
	 * 
	 * 
	 * @param api
	 *            The AsyncJsonApi implementation that you would like.
	 */
	public Future<Object> ListNewsHeadlinesAsync(String category,
			int maxResults, AsyncJsonApi api, CallBack... callBacks)
			throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * Get the detail of a specific news story
	 * 
	 * 
	 * @param api
	 *            The JsonApi implementation that you would like.
	 */
	public GetNewsDetailResponseDTO GetNewsDetail(String storyId, JsonApi api)
			throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * Get the detail of a specific news story
	 * 
	 * 
	 * @param api
	 *            The AsyncJsonApi implementation that you would like.
	 */
	public Future<Object> GetNewsDetailAsync(String storyId, AsyncJsonApi api,
			CallBack... callBacks) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * Returns a list of CFD markets filtered by market name and/or market code
	 * 
	 * 
	 * @param api
	 *            The JsonApi implementation that you would like.
	 */
	public ListCfdMarketsResponseDTO ListCfdMarkets(String searchByMarketName,
			String searchByMarketCode, int clientAccountId, int maxResults,
			JsonApi api) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * Returns a list of CFD markets filtered by market name and/or market code
	 * 
	 * 
	 * @param api
	 *            The AsyncJsonApi implementation that you would like.
	 */
	public Future<Object> ListCfdMarketsAsync(String searchByMarketName,
			String searchByMarketCode, int clientAccountId, int maxResults,
			AsyncJsonApi api, CallBack... callBacks) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * Returns a list of Spread Betting markets filtered by market name and/or
	 * market code
	 * 
	 * 
	 * @param api
	 *            The JsonApi implementation that you would like.
	 */
	public ListSpreadMarketsResponseDTO ListSpreadMarkets(
			String searchByMarketName, String searchByMarketCode,
			int clientAccountId, int maxResults, JsonApi api)
			throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * Returns a list of Spread Betting markets filtered by market name and/or
	 * market code
	 * 
	 * 
	 * @param api
	 *            The AsyncJsonApi implementation that you would like.
	 */
	public Future<Object> ListSpreadMarketsAsync(String searchByMarketName,
			String searchByMarketCode, int clientAccountId, int maxResults,
			AsyncJsonApi api, CallBack... callBacks) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * <p>
	 * Place an order on a particular market. Post a <a
	 * onclick="dojo.hash('#type.NewStopLimitOrderRequestDTO'); return false;"
	 * class="json-link" href="#">NewStopLimitOrderRequestDTO</a> to the uri
	 * specified below.
	 * </p>
	 * <p>
	 * Do not set any order id fields when requesting a new order, the platform
	 * will generate them.
	 * </p>
	 * 
	 * 
	 * @param api
	 *            The JsonApi implementation that you would like.
	 */
	public ApiTradeOrderResponseDTO Order(int OrderId, int MarketId,
			String Currency, boolean AutoRollover, String Direction,
			double Quantity, double BidPrice, double OfferPrice,
			String AuditId, int TradingAccountId, ApiIfDoneDTO[] IfDone,
			NewStopLimitOrderRequestDTO OcoOrder, String Applicability,
			String ExpiryDateTimeUTC, boolean Guaranteed, double TriggerPrice,
			JsonApi api) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * <p>
	 * Place an order on a particular market. Post a <a
	 * onclick="dojo.hash('#type.NewStopLimitOrderRequestDTO'); return false;"
	 * class="json-link" href="#">NewStopLimitOrderRequestDTO</a> to the uri
	 * specified below.
	 * </p>
	 * <p>
	 * Do not set any order id fields when requesting a new order, the platform
	 * will generate them.
	 * </p>
	 * 
	 * 
	 * @param api
	 *            The AsyncJsonApi implementation that you would like.
	 */
	public Future<Object> OrderAsync(int OrderId, int MarketId,
			String Currency, boolean AutoRollover, String Direction,
			double Quantity, double BidPrice, double OfferPrice,
			String AuditId, int TradingAccountId, ApiIfDoneDTO[] IfDone,
			NewStopLimitOrderRequestDTO OcoOrder, String Applicability,
			String ExpiryDateTimeUTC, boolean Guaranteed, double TriggerPrice,
			AsyncJsonApi api, CallBack... callBacks) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * <p>
	 * Cancel an order. Post a <a
	 * onclick="dojo.hash('#type.CancelOrderRequestDTO'); return false;"
	 * class="json-link" href="#">CancelOrderRequestDTO</a> to the uri specified
	 * below
	 * </p>
	 * 
	 * 
	 * @param api
	 *            The JsonApi implementation that you would like.
	 */
	public ApiTradeOrderResponseDTO CancelOrder(int OrderId,
			int TradingAccountId, JsonApi api) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * <p>
	 * Cancel an order. Post a <a
	 * onclick="dojo.hash('#type.CancelOrderRequestDTO'); return false;"
	 * class="json-link" href="#">CancelOrderRequestDTO</a> to the uri specified
	 * below
	 * </p>
	 * 
	 * 
	 * @param api
	 *            The AsyncJsonApi implementation that you would like.
	 */
	public Future<Object> CancelOrderAsync(int OrderId, int TradingAccountId,
			AsyncJsonApi api, CallBack... callBacks) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * <p>
	 * Update an order (for adding a stop/limit or attaching an OCO
	 * relationship). Post an <a onclick=
	 * "dojo.hash('#type.UpdateStopLimitOrderRequestDTO'); return false;"
	 * class="json-link" href="#">UpdateStopLimitOrderRequestDTO</a> to the uri
	 * specified below
	 * </p>
	 * 
	 * 
	 * @param api
	 *            The JsonApi implementation that you would like.
	 */
	public ApiTradeOrderResponseDTO UpdateOrder(JsonApi api)
			throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * <p>
	 * Update an order (for adding a stop/limit or attaching an OCO
	 * relationship). Post an <a onclick=
	 * "dojo.hash('#type.UpdateStopLimitOrderRequestDTO'); return false;"
	 * class="json-link" href="#">UpdateStopLimitOrderRequestDTO</a> to the uri
	 * specified below
	 * </p>
	 * 
	 * 
	 * @param api
	 *            The AsyncJsonApi implementation that you would like.
	 */
	public Future<Object> UpdateOrderAsync(AsyncJsonApi api,
			CallBack... callBacks) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * <p>
	 * Queries for a specified trading account's trades / open positions.
	 * </p>
	 * <p>
	 * This uri is intended to be used to support a grid in a UI. One usage
	 * pattern is to subscribe to streaming orders, call this for the initial
	 * data to display in the grid, and call <a
	 * onclick="dojo.hash('#service.GetOpenPosition'); return false;"
	 * class="json-link" href="#">GetOpenPosition</a> when you get updates on
	 * the order stream to get the updated data in this format.
	 * </p>
	 * 
	 * 
	 * @param api
	 *            The JsonApi implementation that you would like.
	 */
	public ListOpenPositionsResponseDTO ListOpenPositions(int tradingAccountId,
			JsonApi api) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * <p>
	 * Queries for a specified trading account's trades / open positions.
	 * </p>
	 * <p>
	 * This uri is intended to be used to support a grid in a UI. One usage
	 * pattern is to subscribe to streaming orders, call this for the initial
	 * data to display in the grid, and call <a
	 * onclick="dojo.hash('#service.GetOpenPosition'); return false;"
	 * class="json-link" href="#">GetOpenPosition</a> when you get updates on
	 * the order stream to get the updated data in this format.
	 * </p>
	 * 
	 * 
	 * @param api
	 *            The AsyncJsonApi implementation that you would like.
	 */
	public Future<Object> ListOpenPositionsAsync(int tradingAccountId,
			AsyncJsonApi api, CallBack... callBacks) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * <p>
	 * Queries for a specified trading account's active stop / limit orders.
	 * </p>
	 * <p>
	 * This uri is intended to be used to support a grid in a UI. One usage
	 * pattern is to subscribe to streaming orders, call this for the initial
	 * data to display in the grid, and call <a
	 * onclick="dojo.hash('#service.GetActiveStopLimitOrder'); return false;"
	 * class="json-link" href="#">GetActiveStopLimitOrder</a> when you get
	 * updates on the order stream to get the updated data in this format.
	 * </p>
	 * 
	 * 
	 * @param api
	 *            The JsonApi implementation that you would like.
	 */
	public ListActiveStopLimitOrderResponseDTO ListActiveStopLimitOrders(
			int tradingAccountId, JsonApi api) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * <p>
	 * Queries for a specified trading account's active stop / limit orders.
	 * </p>
	 * <p>
	 * This uri is intended to be used to support a grid in a UI. One usage
	 * pattern is to subscribe to streaming orders, call this for the initial
	 * data to display in the grid, and call <a
	 * onclick="dojo.hash('#service.GetActiveStopLimitOrder'); return false;"
	 * class="json-link" href="#">GetActiveStopLimitOrder</a> when you get
	 * updates on the order stream to get the updated data in this format.
	 * </p>
	 * 
	 * 
	 * @param api
	 *            The AsyncJsonApi implementation that you would like.
	 */
	public Future<Object> ListActiveStopLimitOrdersAsync(int tradingAccountId,
			AsyncJsonApi api, CallBack... callBacks) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * <p>
	 * Queries for a active stop limit order with a specified order id. It will
	 * return a null value if the order doesn't exist, or is not an active stop
	 * limit order.
	 * <p>
	 * <p>
	 * This uri is intended to be used to support a grid in a UI. One usage
	 * pattern is to subscribe to streaming orders, call <a onclick=
	 * "dojo.hash('#service.ListActiveStopLimitOrders'); return false;"
	 * class="json-link" href="#">ListActiveStopLimitOrders</a> for the initial
	 * data to display in the grid, and call this uri when you get updates on
	 * the order stream to get the updated data in this format.
	 * </p>
	 * <p>
	 * For a more comprehensive order response, see <a
	 * onclick="dojo.hash('#service.GetOrder'); return false;" class="json-link"
	 * href="#">GetOrder</a>
	 * <p>
	 * 
	 * 
	 * @param api
	 *            The JsonApi implementation that you would like.
	 */
	public GetActiveStopLimitOrderResponseDTO GetActiveStopLimitOrder(
			String orderId, JsonApi api) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * <p>
	 * Queries for a active stop limit order with a specified order id. It will
	 * return a null value if the order doesn't exist, or is not an active stop
	 * limit order.
	 * <p>
	 * <p>
	 * This uri is intended to be used to support a grid in a UI. One usage
	 * pattern is to subscribe to streaming orders, call <a onclick=
	 * "dojo.hash('#service.ListActiveStopLimitOrders'); return false;"
	 * class="json-link" href="#">ListActiveStopLimitOrders</a> for the initial
	 * data to display in the grid, and call this uri when you get updates on
	 * the order stream to get the updated data in this format.
	 * </p>
	 * <p>
	 * For a more comprehensive order response, see <a
	 * onclick="dojo.hash('#service.GetOrder'); return false;" class="json-link"
	 * href="#">GetOrder</a>
	 * <p>
	 * 
	 * 
	 * @param api
	 *            The AsyncJsonApi implementation that you would like.
	 */
	public Future<Object> GetActiveStopLimitOrderAsync(String orderId,
			AsyncJsonApi api, CallBack... callBacks) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * <p>
	 * Queries for a trade / open position with a specified order id. It will
	 * return a null value if the order doesn't exist, or is not a trade / open
	 * position.
	 * </p>
	 * <p>
	 * This uri is intended to be used to support a grid in a UI. One usage
	 * pattern is to subscribe to streaming orders, call <a
	 * onclick="dojo.hash('#service.ListOpenPositions'); return false;"
	 * class="json-link" href="#">ListOpenPositions</a> for the initial data to
	 * display in the grid, and call this uri when you get updates on the order
	 * stream to get the updated data in this format.
	 * </p>
	 * <p>
	 * For a more comprehensive order response, see <a
	 * onclick="dojo.hash('#service.GetOrder'); return false;" class="json-link"
	 * href="#">GetOrder</a>
	 * <p>
	 * 
	 * 
	 * @param api
	 *            The JsonApi implementation that you would like.
	 */
	public GetOpenPositionResponseDTO GetOpenPosition(String orderId,
			JsonApi api) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * <p>
	 * Queries for a trade / open position with a specified order id. It will
	 * return a null value if the order doesn't exist, or is not a trade / open
	 * position.
	 * </p>
	 * <p>
	 * This uri is intended to be used to support a grid in a UI. One usage
	 * pattern is to subscribe to streaming orders, call <a
	 * onclick="dojo.hash('#service.ListOpenPositions'); return false;"
	 * class="json-link" href="#">ListOpenPositions</a> for the initial data to
	 * display in the grid, and call this uri when you get updates on the order
	 * stream to get the updated data in this format.
	 * </p>
	 * <p>
	 * For a more comprehensive order response, see <a
	 * onclick="dojo.hash('#service.GetOrder'); return false;" class="json-link"
	 * href="#">GetOrder</a>
	 * <p>
	 * 
	 * 
	 * @param api
	 *            The AsyncJsonApi implementation that you would like.
	 */
	public Future<Object> GetOpenPositionAsync(String orderId,
			AsyncJsonApi api, CallBack... callBacks) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * <p>
	 * Queries for a specified trading account's trade history. The result set
	 * will contain orders with a status of <b>(3 - Open, 9 - Closed)</b>, and
	 * includes <b>orders that were a trade / stop / limit order</b>.
	 * </p>
	 * <p>
	 * There's currently no corresponding GetTradeHistory (as with
	 * ListOpenPositions).
	 * </p>
	 * 
	 * 
	 * @param api
	 *            The JsonApi implementation that you would like.
	 */
	public ListTradeHistoryResponseDTO ListTradeHistory(int tradingAccountId,
			int maxResults, JsonApi api) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * <p>
	 * Queries for a specified trading account's trade history. The result set
	 * will contain orders with a status of <b>(3 - Open, 9 - Closed)</b>, and
	 * includes <b>orders that were a trade / stop / limit order</b>.
	 * </p>
	 * <p>
	 * There's currently no corresponding GetTradeHistory (as with
	 * ListOpenPositions).
	 * </p>
	 * 
	 * 
	 * @param api
	 *            The AsyncJsonApi implementation that you would like.
	 */
	public Future<Object> ListTradeHistoryAsync(int tradingAccountId,
			int maxResults, AsyncJsonApi api, CallBack... callBacks)
			throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * <p>
	 * Queries for a specified trading account's stop / limit order history. The
	 * result set will include <b>only orders that were originally stop / limit
	 * orders</b> that currently have one of the following statuses <b>(3 -
	 * Open, 4 - Cancelled, 5 - Rejected, 9 - Closed, 10 - Red Card)</b>
	 * </p>
	 * <p>
	 * There's currently no corresponding GetStopLimitOrderHistory (as with
	 * ListActiveStopLimitOrders).
	 * </p>
	 * 
	 * 
	 * @param api
	 *            The JsonApi implementation that you would like.
	 */
	public ListStopLimitOrderHistoryResponseDTO ListStopLimitOrderHistory(
			int tradingAccountId, int maxResults, JsonApi api)
			throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * <p>
	 * Queries for a specified trading account's stop / limit order history. The
	 * result set will include <b>only orders that were originally stop / limit
	 * orders</b> that currently have one of the following statuses <b>(3 -
	 * Open, 4 - Cancelled, 5 - Rejected, 9 - Closed, 10 - Red Card)</b>
	 * </p>
	 * <p>
	 * There's currently no corresponding GetStopLimitOrderHistory (as with
	 * ListActiveStopLimitOrders).
	 * </p>
	 * 
	 * 
	 * @param api
	 *            The AsyncJsonApi implementation that you would like.
	 */
	public Future<Object> ListStopLimitOrderHistoryAsync(int tradingAccountId,
			int maxResults, AsyncJsonApi api, CallBack... callBacks)
			throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * <p>
	 * Queries for an order by a specific order id.
	 * </p>
	 * <p>
	 * The current implementation only returns active orders (i.e. those with a
	 * status of <b>1 - Pending, 2 - Accepted, 3 - Open, 6 - Suspended, 8 -
	 * Yellow Card, 11 - Triggered)</b>.
	 * </p>
	 * 
	 * 
	 * @param api
	 *            The JsonApi implementation that you would like.
	 */
	public GetOrderResponseDTO GetOrder(String orderId, JsonApi api)
			throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * <p>
	 * Queries for an order by a specific order id.
	 * </p>
	 * <p>
	 * The current implementation only returns active orders (i.e. those with a
	 * status of <b>1 - Pending, 2 - Accepted, 3 - Open, 6 - Suspended, 8 -
	 * Yellow Card, 11 - Triggered)</b>.
	 * </p>
	 * 
	 * 
	 * @param api
	 *            The AsyncJsonApi implementation that you would like.
	 */
	public Future<Object> GetOrderAsync(String orderId, AsyncJsonApi api,
			CallBack... callBacks) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * <p>
	 * Place a trade on a particular market. Post a <a
	 * onclick="dojo.hash('#type.NewTradeOrderRequestDTO'); return false;"
	 * class="json-link" href="#">NewTradeOrderRequestDTO</a> to the uri
	 * specified below.
	 * </p>
	 * <p>
	 * Do not set any order id fields when requesting a new trade, the platform
	 * will generate them.
	 * </p>
	 * 
	 * 
	 * @param api
	 *            The JsonApi implementation that you would like.
	 */
	public ApiTradeOrderResponseDTO Trade(int MarketId, String Currency,
			boolean AutoRollover, String Direction, double Quantity,
			String QuoteId, double BidPrice, double OfferPrice, String AuditId,
			int TradingAccountId, ApiIfDoneDTO[] IfDone, int[] Close,
			JsonApi api) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * <p>
	 * Place a trade on a particular market. Post a <a
	 * onclick="dojo.hash('#type.NewTradeOrderRequestDTO'); return false;"
	 * class="json-link" href="#">NewTradeOrderRequestDTO</a> to the uri
	 * specified below.
	 * </p>
	 * <p>
	 * Do not set any order id fields when requesting a new trade, the platform
	 * will generate them.
	 * </p>
	 * 
	 * 
	 * @param api
	 *            The AsyncJsonApi implementation that you would like.
	 */
	public Future<Object> TradeAsync(int MarketId, String Currency,
			boolean AutoRollover, String Direction, double Quantity,
			String QuoteId, double BidPrice, double OfferPrice, String AuditId,
			int TradingAccountId, ApiIfDoneDTO[] IfDone, int[] Close,
			AsyncJsonApi api, CallBack... callBacks) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * Update a trade (for adding a stop/limit etc). Post an <a
	 * onclick="dojo.hash('#type.UpdateTradeOrderRequestDTO'); return false;"
	 * class="json-link" href="#">UpdateTradeOrderRequestDTO</a> to the uri
	 * specified below</p>
	 * 
	 * 
	 * @param api
	 *            The JsonApi implementation that you would like.
	 */
	public ApiTradeOrderResponseDTO UpdateTrade(int OrderId, JsonApi api)
			throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * Update a trade (for adding a stop/limit etc). Post an <a
	 * onclick="dojo.hash('#type.UpdateTradeOrderRequestDTO'); return false;"
	 * class="json-link" href="#">UpdateTradeOrderRequestDTO</a> to the uri
	 * specified below</p>
	 * 
	 * 
	 * @param api
	 *            The AsyncJsonApi implementation that you would like.
	 */
	public Future<Object> UpdateTradeAsync(int OrderId, AsyncJsonApi api,
			CallBack... callBacks) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * Whether a User is allowed to see Charting Data.
	 * 
	 * 
	 * @param api
	 *            The JsonApi implementation that you would like.
	 */
	public Boolean GetChartingEnabled(String id, JsonApi api)
			throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * Whether a User is allowed to see Charting Data.
	 * 
	 * 
	 * @param api
	 *            The AsyncJsonApi implementation that you would like.
	 */
	public Future<Object> GetChartingEnabledAsync(String id, AsyncJsonApi api,
			CallBack... callBacks) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * What are the Users Terms and Conditions.
	 * 
	 * 
	 * @param api
	 *            The JsonApi implementation that you would like.
	 */
	public String GetTermsAndConditions(String clientaccount, JsonApi api)
			throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * What are the Users Terms and Conditions.
	 * 
	 * 
	 * @param api
	 *            The AsyncJsonApi implementation that you would like.
	 */
	public Future<Object> GetTermsAndConditionsAsync(String clientaccount,
			AsyncJsonApi api, CallBack... callBacks) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * Returns the Users ClientAccountId and a list of their TradingAccounts.
	 * There are no parameters for this call.
	 * 
	 * 
	 * @param api
	 *            The JsonApi implementation that you would like.
	 */
	public AccountInformationResponseDTO GetClientAndTradingAccount(JsonApi api)
			throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * Returns the Users ClientAccountId and a list of their TradingAccounts.
	 * There are no parameters for this call.
	 * 
	 * 
	 * @param api
	 *            The AsyncJsonApi implementation that you would like.
	 */
	public Future<Object> GetClientAndTradingAccountAsync(AsyncJsonApi api,
			CallBack... callBacks) throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * Simulates an error condition.
	 * 
	 * 
	 * @param api
	 *            The JsonApi implementation that you would like.
	 */
	public ApiErrorResponseDTO GenerateException(int errorCode, JsonApi api)
			throws ApiException;

	/**
	 * !This is an auto generated method signature!
	 * 
	 * Simulates an error condition.
	 * 
	 * 
	 * @param api
	 *            The AsyncJsonApi implementation that you would like.
	 */
	public Future<Object> GenerateExceptionAsync(int errorCode,
			AsyncJsonApi api, CallBack... callBacks) throws ApiException;
}
