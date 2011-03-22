package CIAPI.Java.examples.ciapi;

import CIAPI.Java.ApiException;
import CIAPI.Java.JsonApi;
import CIAPI.Java.examples.ciapi.dto.AccountInformationResponseDTO;
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
import CIAPI.Java.examples.ciapi.dto.ListStopLimitOrderHistoryResponseDTO;
import CIAPI.Java.examples.ciapi.dto.ListTradeHistoryResponseDTO;
import CIAPI.Java.examples.ciapi.dto.MarketInformationResponseDTO;
import CIAPI.Java.examples.ciapi.dto.SessionDeletionResponseDTO;

/**
 * API for connecting to the City Index Trading RESTful API. All requests are
 * made synchronously.
 * 
 * The body of this class will eventually be auto-generated. Right now it just
 * serves as an example of what we need the generated code to look like.
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
		// Done collecting variables
		// Fill in necessary holes in the URL.
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		// return type result type get/post url params return type.class
		AccountInformationResponseDTO result = (AccountInformationResponseDTO) api.callGetMethod(fullUrl,
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
		// Done collecting variables
		// Fill in necessary holes in the URL.
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		// return type result type get/post url params return type.class
		// TODO, how do I know that this takes a LogOnRequestDTO?
		CreateSessionResponseDTO result = (CreateSessionResponseDTO) api.callPostMethod(fullUrl, null,
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
		// Done collecting variables
		// Fill in necessary holes in the URL.
		filledUri = filledUri.replace("{userName}", userName);
		filledUri = filledUri.replace("{session}", session);
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		// return type result type get/post url params return type.class
		// TODO, how do I know that this takes an empty object `{}`?
		SessionDeletionResponseDTO result = (SessionDeletionResponseDTO) api.callPostMethod(fullUrl, null,
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
		// Done collecting variables
		// Fill in necessary holes in the URL.
		filledUri = filledUri.replace("{searchByMarketName}", searchByMarketName + "");
		filledUri = filledUri.replace("{searchByMarketCode}", searchByMarketCode + "");
		filledUri = filledUri.replace("{clientAccountId}", clientAccountId + "");
		filledUri = filledUri.replace("{maxResults}", maxResults + "");
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		// return type result type get/post url params return type.class
		ListCfdMarketsResponseDTO result = (ListCfdMarketsResponseDTO) api.callGetMethod(fullUrl,
				ListCfdMarketsResponseDTO.class);
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
	public MarketInformationResponseDTO GetMarketInformation(String marketId) throws ApiException {
		// Collect variables from method
		String target = "market";
		String uriTemplate = "/{marketId}/information";
		String transport = "GET";
		String envelope = "URL";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL.
		filledUri = filledUri.replace("{marketId}", marketId + "");
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		// return type result type get/post url params return type.class
		MarketInformationResponseDTO result = (MarketInformationResponseDTO) api.callGetMethod(fullUrl,
				MarketInformationResponseDTO.class);
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
	public GetNewsDetailResponseDTO GetNewsDetail(String storyId) throws ApiException {
		// Collect variables from method
		String target = "news";
		String uriTemplate = "/{storyId}";
		String transport = "GET";
		String envelope = "URL";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL.
		filledUri = filledUri.replace("{storyId}", storyId + "");
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		// return type result type get/post url params return type.class
		GetNewsDetailResponseDTO result = (GetNewsDetailResponseDTO) api.callGetMethod(fullUrl,
				GetNewsDetailResponseDTO.class);
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
	public ListNewsHeadlinesResponseDTO ListNewsHeadlines(String category, int maxResults) throws ApiException {
		// Collect variables from method
		String target = "news";
		String uriTemplate = "?Category={category}&MaxResults={maxResults}";
		String transport = "GET";
		String envelope = "URL";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL.
		filledUri = filledUri.replace("{category}", category + "");
		filledUri = filledUri.replace("{maxResults}", maxResults + "");
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		// return type result type get/post url params return type.class
		ListNewsHeadlinesResponseDTO result = (ListNewsHeadlinesResponseDTO) api.callGetMethod(fullUrl,
				ListNewsHeadlinesResponseDTO.class);
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
	public GetPriceBarResponseDTO GetPriceBars(String marketId, String interval, int span, String priceBars)
			throws ApiException {
		// Collect variables from method
		String target = "market";
		String uriTemplate = "/{marketId}/barhistory?interval={interval}&span={span}&pricebars={priceBars}";
		String transport = "GET";
		String envelope = "URL";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL.
		filledUri = filledUri.replace("{marketId}", marketId + "");
		filledUri = filledUri.replace("{interval}", interval + "");
		filledUri = filledUri.replace("{span}", span + "");
		filledUri = filledUri.replace("{priceBars}", priceBars + "");
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		// return type result type get/post url params return type.class
		GetPriceBarResponseDTO result = (GetPriceBarResponseDTO) api.callGetMethod(fullUrl,
				GetPriceBarResponseDTO.class);
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
	public GetPriceTickResponseDTO GetPriceTicks(String marketId, String priceTicks) throws ApiException {
		// Collect variables from method
		String target = "market";
		String uriTemplate = "/{marketId}/tickhistory?priceticks={priceTicks}";
		String transport = "GET";
		String envelope = "URL";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL.
		filledUri = filledUri.replace("{marketId}", marketId + "");
		filledUri = filledUri.replace("{priceTicks}", priceTicks + "");
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		// return type result type get/post url params return type.class
		GetPriceTickResponseDTO result = (GetPriceTickResponseDTO) api.callGetMethod(fullUrl,
				GetPriceTickResponseDTO.class);
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
	public ListSpreadMarketsResponseDTO ListSpreadMarkets(String searchByMarketName, String searchByMarketCode,
			int clientAccountId, int maxResults) throws ApiException {
		// Collect variables from method
		String target = "spread/markets";
		String uriTemplate = "?MarketName={searchByMarketName}&MarketCode={searchByMarketCode}&ClientAccountId={clientAccountId}&MaxResults={maxResults}";
		String transport = "GET";
		String envelope = "URL";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL.
		filledUri = filledUri.replace("{searchByMarketName}", searchByMarketName + "");
		filledUri = filledUri.replace("{searchByMarketCode}", searchByMarketCode + "");
		filledUri = filledUri.replace("{clientAccountId}", clientAccountId + "");
		filledUri = filledUri.replace("{maxResults}", maxResults + "");
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		// return type result type get/post url params return type.class
		ListSpreadMarketsResponseDTO result = (ListSpreadMarketsResponseDTO) api.callGetMethod(fullUrl,
				ListSpreadMarketsResponseDTO.class);
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
	public ApiTradeOrderResponseDTO CancelOrder(int OrderId) throws ApiException {
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
		// TODO, how am I suposed to know I need to pass in a cancel order
		// request?
		// return type result type get/post url params return type.class
		ApiTradeOrderResponseDTO result = (ApiTradeOrderResponseDTO) api.callPostMethod(fullUrl, null,
				ApiTradeOrderResponseDTO.class);
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
	public ListActiveStopLimitOrderResponseDTO ListActiveStopLimitOrders(int tradingAccountId) throws ApiException {
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
		ListActiveStopLimitOrderResponseDTO result = (ListActiveStopLimitOrderResponseDTO) api.callGetMethod(fullUrl,
				ListActiveStopLimitOrderResponseDTO.class);
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
	public ListOpenPositionsResponseDTO ListOpenPositions(int tradingAccountId) throws ApiException {
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
		ListOpenPositionsResponseDTO result = (ListOpenPositionsResponseDTO) api.callGetMethod(fullUrl,
				ListOpenPositionsResponseDTO.class);
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
	public ListOrdersResponseDTO ListOrders(int tradingAccountId, boolean openOrders, boolean acceptedOrders)
			throws ApiException {
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
		ListOrdersResponseDTO result = (ListOrdersResponseDTO) api.callGetMethod(fullUrl, ListOrdersResponseDTO.class);
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
	public ListStopLimitOrderHistoryResponseDTO ListOrders(int tradingAccountId, int maxResults) throws ApiException {
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
		ListStopLimitOrderHistoryResponseDTO result = (ListStopLimitOrderHistoryResponseDTO) api.callGetMethod(fullUrl,
				ListStopLimitOrderHistoryResponseDTO.class);
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
	public ListTradeHistoryResponseDTO ListTradeHistory(int tradingAccountId, int maxResults) throws ApiException {
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
		ListTradeHistoryResponseDTO result = (ListTradeHistoryResponseDTO) api.callGetMethod(fullUrl,
				ListTradeHistoryResponseDTO.class);
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
	public ApiTradeOrderResponseDTO Order(int MarketId, String Direction, double Quantity, double BidPrice,
			double OfferPrice, String AuditId, int TradingAccountId, String Applicability, String ExpiryDateTimeUTC)
			throws ApiException {
		// Collect variables from method
		String target = "order";
		String uriTemplate = "/order";
		String transport = "POST";
		String envelope = "JSON";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL.
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		// return type result type get/post url params return type.class

		ApiTradeOrderResponseDTO result = (ApiTradeOrderResponseDTO) api.callPostMethod(fullUrl, null,
				ApiTradeOrderResponseDTO.class);
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
	public ApiTradeOrderResponseDTO Trade(int MarketId, String Direction, double Quantity, double BidPrice,
			double OfferPrice, String AuditId, int TradingAccountId) throws ApiException {
		// Collect variables from method
		String target = "order";
		String uriTemplate = "/trade";
		String transport = "POST";
		String envelope = "JSON";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL.
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		// return type result type get/post url params return type.class

		ApiTradeOrderResponseDTO result = (ApiTradeOrderResponseDTO) api.callPostMethod(fullUrl, null,
				ApiTradeOrderResponseDTO.class);
		return result;
	}
}
