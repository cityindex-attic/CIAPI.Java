package CIAPI.Java.core.impl;

import java.util.concurrent.Future;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import JsonClient.Java.ApiException;
import JsonClient.Java.JsonApi;
import JsonClient.Java.async.AsyncJsonApi;
import JsonClient.Java.async.CallBack;
import JsonClient.Java.async.AsyncApiCall;

import CIAPI.Java.core.ServiceMethods;
import CIAPI.Java.core.dto.*;

public class ServiceMethodsImpl implements ServiceMethods {

	private Gson g = new Gson();

	/**
	 * !This is an auto generated method!
	 * 
	 * <p>
	 * Create a new session. This is how you "log on" to the CIAPI. Post a <a
	 * onclick="dojo.hash('#type.ApiLogOnRequestDTO'); return false;" class="json-link" href="#">ApiLogOnRequestDTO</a>
	 * to the uri specified below
	 * </p>
	 */
	@Override
	public ApiLogOnResponseDTO LogOn(ApiLogOnRequestDTO apiLogOnRequest, JsonApi api) throws ApiException {
		// Collect variables from method
		String target = "session";
		String uriTemplate = "/";
		String transport = "POST";
		String envelope = "JSON";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL if it is GET.
		if (transport.equals("GET")) {
			// Concatenating the empty string is a hackey way of converting all params to a String

			filledUri = filledUri.replace("{apiLogOnRequest}", apiLogOnRequest + "");
		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		Object result = null;
		Class<?> retClazz = ApiLogOnResponseDTO.class;
		if (transport.equals("GET")) {
			result = (ApiLogOnResponseDTO) api.callGetMethod(fullUrl, ApiLogOnResponseDTO.class);
		} else if (transport.equals("POST")) {

			result = api.callPostMethod(fullUrl, g.toJson(apiLogOnRequest), retClazz);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return (ApiLogOnResponseDTO) result;
	}

	/**
	 * !This is an auto generated method!
	 * 
	 * <p>
	 * Create a new session. This is how you "log on" to the CIAPI. Post a <a
	 * onclick="dojo.hash('#type.ApiLogOnRequestDTO'); return false;" class="json-link" href="#">ApiLogOnRequestDTO</a>
	 * to the uri specified below
	 * </p>
	 */
	@Override
	public Future<Object> LogOnAsync(ApiLogOnRequestDTO apiLogOnRequest, AsyncJsonApi api, CallBack... callBacks)
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
		if (transport.equals("GET")) {
			// Concatenating the empty string is a hackey way of converting all params to a String

			filledUri = filledUri.replace("{apiLogOnRequest}", apiLogOnRequest + "");
		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		AsyncApiCall call = api.createNewCall();
		for (CallBack cb : callBacks) {
			call.addCallCompleteListener(cb);
		}
		Future<Object> result = null;
		Class<?> retClazz = ApiLogOnResponseDTO.class;
		if (transport.equals("GET")) {
			result = call.callGetMethod(fullUrl, retClazz);
		} else if (transport.equals("POST")) {

			result = call.callPostMethod(fullUrl, g.toJson(apiLogOnRequest), retClazz);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}

	/**
	 * !This is an auto generated method!
	 * 
	 * <p>
	 * Delete a session. This is how you "log off" from the CIAPI.
	 * </p>
	 */
	@Override
	public ApiLogOffResponseDTO DeleteSession(String userName, String session, JsonApi api) throws ApiException {
		// Collect variables from method
		String target = "session";
		String uriTemplate = "/deleteSession?userName={userName}&session={session}";
		String transport = "POST";
		String envelope = "JSON";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL if it is GET.
		if (transport.equals("GET")) {
			// Concatenating the empty string is a hackey way of converting all params to a String

			filledUri = filledUri.replace("{userName}", userName + "");
			filledUri = filledUri.replace("{session}", session + "");
		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		Object result = null;
		Class<?> retClazz = ApiLogOffResponseDTO.class;
		if (transport.equals("GET")) {
			result = (ApiLogOffResponseDTO) api.callGetMethod(fullUrl, ApiLogOffResponseDTO.class);
		} else if (transport.equals("POST")) {

			result = api.callPostMethod(fullUrl, g.toJson(userName), retClazz);
			result = api.callPostMethod(fullUrl, g.toJson(session), retClazz);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return (ApiLogOffResponseDTO) result;
	}

	/**
	 * !This is an auto generated method!
	 * 
	 * <p>
	 * Delete a session. This is how you "log off" from the CIAPI.
	 * </p>
	 */
	@Override
	public Future<Object> DeleteSessionAsync(String userName, String session, AsyncJsonApi api, CallBack... callBacks)
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
		if (transport.equals("GET")) {
			// Concatenating the empty string is a hackey way of converting all params to a String

			filledUri = filledUri.replace("{userName}", userName + "");
			filledUri = filledUri.replace("{session}", session + "");
		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		AsyncApiCall call = api.createNewCall();
		for (CallBack cb : callBacks) {
			call.addCallCompleteListener(cb);
		}
		Future<Object> result = null;
		Class<?> retClazz = ApiLogOffResponseDTO.class;
		if (transport.equals("GET")) {
			result = call.callGetMethod(fullUrl, retClazz);
		} else if (transport.equals("POST")) {

			result = call.callPostMethod(fullUrl, g.toJson(userName), retClazz);
			result = call.callPostMethod(fullUrl, g.toJson(session), retClazz);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}

	/**
	 * !This is an auto generated method!
	 * 
	 * Get historic price bars in OHLC (open, high, low, close) format, suitable for plotting candlestick chartsReturns
	 * price bars in ascending order up to the current time.When there are no prices per a particular time period, no
	 * price bar is returned. Thus, it can appear that the array of price bars has "gaps", i.e. the gap between the
	 * datetime of each price bar might not be equal to interval x spanSample Urls:
	 * /market/1234/history?interval=MINUTE&
	 * span=15&pricebars=180/market/735/history?interval=HOUR&span=1&pricebars=240/market
	 * /1577/history?interval=DAY&span=1&pricebars=10
	 */
	@Override
	public GetPriceBarResponseDTO GetPriceBars(String marketId, String interval, int span, String priceBars, JsonApi api)
			throws ApiException {
		// Collect variables from method
		String target = "market";
		String uriTemplate = "/{marketId}/barhistory?interval={interval}&span={span}&pricebars={priceBars}";
		String transport = "GET";
		String envelope = "URL";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL if it is GET.
		if (transport.equals("GET")) {
			// Concatenating the empty string is a hackey way of converting all params to a String

			filledUri = filledUri.replace("{marketId}", marketId + "");
			filledUri = filledUri.replace("{interval}", interval + "");
			filledUri = filledUri.replace("{span}", span + "");
			filledUri = filledUri.replace("{priceBars}", priceBars + "");
		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		Object result = null;
		Class<?> retClazz = GetPriceBarResponseDTO.class;
		if (transport.equals("GET")) {
			result = (GetPriceBarResponseDTO) api.callGetMethod(fullUrl, GetPriceBarResponseDTO.class);
		} else if (transport.equals("POST")) {

			result = api.callPostMethod(fullUrl, g.toJson(marketId), retClazz);
			result = api.callPostMethod(fullUrl, g.toJson(interval), retClazz);
			result = api.callPostMethod(fullUrl, g.toJson(span), retClazz);
			result = api.callPostMethod(fullUrl, g.toJson(priceBars), retClazz);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return (GetPriceBarResponseDTO) result;
	}

	/**
	 * !This is an auto generated method!
	 * 
	 * Get historic price bars in OHLC (open, high, low, close) format, suitable for plotting candlestick chartsReturns
	 * price bars in ascending order up to the current time.When there are no prices per a particular time period, no
	 * price bar is returned. Thus, it can appear that the array of price bars has "gaps", i.e. the gap between the
	 * datetime of each price bar might not be equal to interval x spanSample Urls:
	 * /market/1234/history?interval=MINUTE&
	 * span=15&pricebars=180/market/735/history?interval=HOUR&span=1&pricebars=240/market
	 * /1577/history?interval=DAY&span=1&pricebars=10
	 */
	@Override
	public Future<Object> GetPriceBarsAsync(String marketId, String interval, int span, String priceBars,
			AsyncJsonApi api, CallBack... callBacks) throws ApiException {
		// Collect variables from method
		String target = "market";
		String uriTemplate = "/{marketId}/barhistory?interval={interval}&span={span}&pricebars={priceBars}";
		String transport = "GET";
		String envelope = "URL";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL.
		if (transport.equals("GET")) {
			// Concatenating the empty string is a hackey way of converting all params to a String

			filledUri = filledUri.replace("{marketId}", marketId + "");
			filledUri = filledUri.replace("{interval}", interval + "");
			filledUri = filledUri.replace("{span}", span + "");
			filledUri = filledUri.replace("{priceBars}", priceBars + "");
		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		AsyncApiCall call = api.createNewCall();
		for (CallBack cb : callBacks) {
			call.addCallCompleteListener(cb);
		}
		Future<Object> result = null;
		Class<?> retClazz = GetPriceBarResponseDTO.class;
		if (transport.equals("GET")) {
			result = call.callGetMethod(fullUrl, retClazz);
		} else if (transport.equals("POST")) {

			result = call.callPostMethod(fullUrl, g.toJson(marketId), retClazz);
			result = call.callPostMethod(fullUrl, g.toJson(interval), retClazz);
			result = call.callPostMethod(fullUrl, g.toJson(span), retClazz);
			result = call.callPostMethod(fullUrl, g.toJson(priceBars), retClazz);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}

	/**
	 * !This is an auto generated method!
	 * 
	 * Get historic price ticks. Returns price ticks in ascending order up to the current time. The length of time
	 * between each tick will be different.
	 */
	@Override
	public GetPriceTickResponseDTO GetPriceTicks(String marketId, String priceTicks, JsonApi api) throws ApiException {
		// Collect variables from method
		String target = "market";
		String uriTemplate = "/{marketId}/tickhistory?priceticks={priceTicks}";
		String transport = "GET";
		String envelope = "URL";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL if it is GET.
		if (transport.equals("GET")) {
			// Concatenating the empty string is a hackey way of converting all params to a String

			filledUri = filledUri.replace("{marketId}", marketId + "");
			filledUri = filledUri.replace("{priceTicks}", priceTicks + "");
		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		Object result = null;
		Class<?> retClazz = GetPriceTickResponseDTO.class;
		if (transport.equals("GET")) {
			result = (GetPriceTickResponseDTO) api.callGetMethod(fullUrl, GetPriceTickResponseDTO.class);
		} else if (transport.equals("POST")) {

			result = api.callPostMethod(fullUrl, g.toJson(marketId), retClazz);
			result = api.callPostMethod(fullUrl, g.toJson(priceTicks), retClazz);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return (GetPriceTickResponseDTO) result;
	}

	/**
	 * !This is an auto generated method!
	 * 
	 * Get historic price ticks. Returns price ticks in ascending order up to the current time. The length of time
	 * between each tick will be different.
	 */
	@Override
	public Future<Object> GetPriceTicksAsync(String marketId, String priceTicks, AsyncJsonApi api,
			CallBack... callBacks) throws ApiException {
		// Collect variables from method
		String target = "market";
		String uriTemplate = "/{marketId}/tickhistory?priceticks={priceTicks}";
		String transport = "GET";
		String envelope = "URL";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL.
		if (transport.equals("GET")) {
			// Concatenating the empty string is a hackey way of converting all params to a String

			filledUri = filledUri.replace("{marketId}", marketId + "");
			filledUri = filledUri.replace("{priceTicks}", priceTicks + "");
		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		AsyncApiCall call = api.createNewCall();
		for (CallBack cb : callBacks) {
			call.addCallCompleteListener(cb);
		}
		Future<Object> result = null;
		Class<?> retClazz = GetPriceTickResponseDTO.class;
		if (transport.equals("GET")) {
			result = call.callGetMethod(fullUrl, retClazz);
		} else if (transport.equals("POST")) {

			result = call.callPostMethod(fullUrl, g.toJson(marketId), retClazz);
			result = call.callPostMethod(fullUrl, g.toJson(priceTicks), retClazz);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}

	/**
	 * !This is an auto generated method!
	 * 
	 * <p>
	 * Get Market Information for the specified market.
	 * </p>
	 */
	@Override
	public GetMarketInformationResponseDTO GetMarketInformation(String marketId, JsonApi api) throws ApiException {
		// Collect variables from method
		String target = "market";
		String uriTemplate = "/{marketId}/information";
		String transport = "GET";
		String envelope = "URL";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL if it is GET.
		if (transport.equals("GET")) {
			// Concatenating the empty string is a hackey way of converting all params to a String

			filledUri = filledUri.replace("{marketId}", marketId + "");
		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		Object result = null;
		Class<?> retClazz = GetMarketInformationResponseDTO.class;
		if (transport.equals("GET")) {
			result = (GetMarketInformationResponseDTO) api
					.callGetMethod(fullUrl, GetMarketInformationResponseDTO.class);
		} else if (transport.equals("POST")) {

			result = api.callPostMethod(fullUrl, g.toJson(marketId), retClazz);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return (GetMarketInformationResponseDTO) result;
	}

	/**
	 * !This is an auto generated method!
	 * 
	 * <p>
	 * Get Market Information for the specified market.
	 * </p>
	 */
	@Override
	public Future<Object> GetMarketInformationAsync(String marketId, AsyncJsonApi api, CallBack... callBacks)
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
		if (transport.equals("GET")) {
			// Concatenating the empty string is a hackey way of converting all params to a String

			filledUri = filledUri.replace("{marketId}", marketId + "");
		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		AsyncApiCall call = api.createNewCall();
		for (CallBack cb : callBacks) {
			call.addCallCompleteListener(cb);
		}
		Future<Object> result = null;
		Class<?> retClazz = GetMarketInformationResponseDTO.class;
		if (transport.equals("GET")) {
			result = call.callGetMethod(fullUrl, retClazz);
		} else if (transport.equals("POST")) {

			result = call.callPostMethod(fullUrl, g.toJson(marketId), retClazz);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}

	/**
	 * !This is an auto generated method!
	 * 
	 * <p>
	 * Queries for market information.
	 * </p>
	 */
	@Override
	public ListMarketInformationSearchResponseDTO ListMarketInformationSearch(boolean searchByMarketCode,
			boolean searchByMarketName, boolean spreadProductType, boolean cfdProductType, boolean binaryProductType,
			String query, int maxResults, JsonApi api) throws ApiException {
		// Collect variables from method
		String target = "market";
		String uriTemplate = "/informationsearch?SearchByMarketCode={searchByMarketCode}&SearchByMarketName={searchByMarketName}&SpreadProductType={spreadProductType}&CfdProductType={cfdProductType}&BinaryProductType={binaryProductType}&Query={query}&MaxResults={maxResults}";
		String transport = "GET";
		String envelope = "URL";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL if it is GET.
		if (transport.equals("GET")) {
			// Concatenating the empty string is a hackey way of converting all params to a String

			filledUri = filledUri.replace("{searchByMarketCode}", searchByMarketCode + "");
			filledUri = filledUri.replace("{searchByMarketName}", searchByMarketName + "");
			filledUri = filledUri.replace("{spreadProductType}", spreadProductType + "");
			filledUri = filledUri.replace("{cfdProductType}", cfdProductType + "");
			filledUri = filledUri.replace("{binaryProductType}", binaryProductType + "");
			filledUri = filledUri.replace("{query}", query + "");
			filledUri = filledUri.replace("{maxResults}", maxResults + "");
		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		Object result = null;
		Class<?> retClazz = ListMarketInformationSearchResponseDTO.class;
		if (transport.equals("GET")) {
			result = (ListMarketInformationSearchResponseDTO) api.callGetMethod(fullUrl,
					ListMarketInformationSearchResponseDTO.class);
		} else if (transport.equals("POST")) {

			result = api.callPostMethod(fullUrl, g.toJson(searchByMarketCode), retClazz);
			result = api.callPostMethod(fullUrl, g.toJson(searchByMarketName), retClazz);
			result = api.callPostMethod(fullUrl, g.toJson(spreadProductType), retClazz);
			result = api.callPostMethod(fullUrl, g.toJson(cfdProductType), retClazz);
			result = api.callPostMethod(fullUrl, g.toJson(binaryProductType), retClazz);
			result = api.callPostMethod(fullUrl, g.toJson(query), retClazz);
			result = api.callPostMethod(fullUrl, g.toJson(maxResults), retClazz);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return (ListMarketInformationSearchResponseDTO) result;
	}

	/**
	 * !This is an auto generated method!
	 * 
	 * <p>
	 * Queries for market information.
	 * </p>
	 */
	@Override
	public Future<Object> ListMarketInformationSearchAsync(boolean searchByMarketCode, boolean searchByMarketName,
			boolean spreadProductType, boolean cfdProductType, boolean binaryProductType, String query, int maxResults,
			AsyncJsonApi api, CallBack... callBacks) throws ApiException {
		// Collect variables from method
		String target = "market";
		String uriTemplate = "/informationsearch?SearchByMarketCode={searchByMarketCode}&SearchByMarketName={searchByMarketName}&SpreadProductType={spreadProductType}&CfdProductType={cfdProductType}&BinaryProductType={binaryProductType}&Query={query}&MaxResults={maxResults}";
		String transport = "GET";
		String envelope = "URL";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL.
		if (transport.equals("GET")) {
			// Concatenating the empty string is a hackey way of converting all params to a String

			filledUri = filledUri.replace("{searchByMarketCode}", searchByMarketCode + "");
			filledUri = filledUri.replace("{searchByMarketName}", searchByMarketName + "");
			filledUri = filledUri.replace("{spreadProductType}", spreadProductType + "");
			filledUri = filledUri.replace("{cfdProductType}", cfdProductType + "");
			filledUri = filledUri.replace("{binaryProductType}", binaryProductType + "");
			filledUri = filledUri.replace("{query}", query + "");
			filledUri = filledUri.replace("{maxResults}", maxResults + "");
		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		AsyncApiCall call = api.createNewCall();
		for (CallBack cb : callBacks) {
			call.addCallCompleteListener(cb);
		}
		Future<Object> result = null;
		Class<?> retClazz = ListMarketInformationSearchResponseDTO.class;
		if (transport.equals("GET")) {
			result = call.callGetMethod(fullUrl, retClazz);
		} else if (transport.equals("POST")) {

			result = call.callPostMethod(fullUrl, g.toJson(searchByMarketCode), retClazz);
			result = call.callPostMethod(fullUrl, g.toJson(searchByMarketName), retClazz);
			result = call.callPostMethod(fullUrl, g.toJson(spreadProductType), retClazz);
			result = call.callPostMethod(fullUrl, g.toJson(cfdProductType), retClazz);
			result = call.callPostMethod(fullUrl, g.toJson(binaryProductType), retClazz);
			result = call.callPostMethod(fullUrl, g.toJson(query), retClazz);
			result = call.callPostMethod(fullUrl, g.toJson(maxResults), retClazz);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}

	/**
	 * !This is an auto generated method!
	 * 
	 * Get a list of current news headlines
	 */
	@Override
	public ListNewsHeadlinesResponseDTO ListNewsHeadlines(String category, int maxResults, JsonApi api)
			throws ApiException {
		// Collect variables from method
		String target = "news";
		String uriTemplate = "?Category={category}&MaxResults={maxResults}";
		String transport = "GET";
		String envelope = "URL";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL if it is GET.
		if (transport.equals("GET")) {
			// Concatenating the empty string is a hackey way of converting all params to a String

			filledUri = filledUri.replace("{category}", category + "");
			filledUri = filledUri.replace("{maxResults}", maxResults + "");
		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		Object result = null;
		Class<?> retClazz = ListNewsHeadlinesResponseDTO.class;
		if (transport.equals("GET")) {
			result = (ListNewsHeadlinesResponseDTO) api.callGetMethod(fullUrl, ListNewsHeadlinesResponseDTO.class);
		} else if (transport.equals("POST")) {

			result = api.callPostMethod(fullUrl, g.toJson(category), retClazz);
			result = api.callPostMethod(fullUrl, g.toJson(maxResults), retClazz);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return (ListNewsHeadlinesResponseDTO) result;
	}

	/**
	 * !This is an auto generated method!
	 * 
	 * Get a list of current news headlines
	 */
	@Override
	public Future<Object> ListNewsHeadlinesAsync(String category, int maxResults, AsyncJsonApi api,
			CallBack... callBacks) throws ApiException {
		// Collect variables from method
		String target = "news";
		String uriTemplate = "?Category={category}&MaxResults={maxResults}";
		String transport = "GET";
		String envelope = "URL";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL.
		if (transport.equals("GET")) {
			// Concatenating the empty string is a hackey way of converting all params to a String

			filledUri = filledUri.replace("{category}", category + "");
			filledUri = filledUri.replace("{maxResults}", maxResults + "");
		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		AsyncApiCall call = api.createNewCall();
		for (CallBack cb : callBacks) {
			call.addCallCompleteListener(cb);
		}
		Future<Object> result = null;
		Class<?> retClazz = ListNewsHeadlinesResponseDTO.class;
		if (transport.equals("GET")) {
			result = call.callGetMethod(fullUrl, retClazz);
		} else if (transport.equals("POST")) {

			result = call.callPostMethod(fullUrl, g.toJson(category), retClazz);
			result = call.callPostMethod(fullUrl, g.toJson(maxResults), retClazz);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}

	/**
	 * !This is an auto generated method!
	 * 
	 * Get the detail of a specific news story
	 */
	@Override
	public GetNewsDetailResponseDTO GetNewsDetail(String storyId, JsonApi api) throws ApiException {
		// Collect variables from method
		String target = "news";
		String uriTemplate = "/{storyId}";
		String transport = "GET";
		String envelope = "URL";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL if it is GET.
		if (transport.equals("GET")) {
			// Concatenating the empty string is a hackey way of converting all params to a String

			filledUri = filledUri.replace("{storyId}", storyId + "");
		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		Object result = null;
		Class<?> retClazz = GetNewsDetailResponseDTO.class;
		if (transport.equals("GET")) {
			result = (GetNewsDetailResponseDTO) api.callGetMethod(fullUrl, GetNewsDetailResponseDTO.class);
		} else if (transport.equals("POST")) {

			result = api.callPostMethod(fullUrl, g.toJson(storyId), retClazz);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return (GetNewsDetailResponseDTO) result;
	}

	/**
	 * !This is an auto generated method!
	 * 
	 * Get the detail of a specific news story
	 */
	@Override
	public Future<Object> GetNewsDetailAsync(String storyId, AsyncJsonApi api, CallBack... callBacks)
			throws ApiException {
		// Collect variables from method
		String target = "news";
		String uriTemplate = "/{storyId}";
		String transport = "GET";
		String envelope = "URL";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL.
		if (transport.equals("GET")) {
			// Concatenating the empty string is a hackey way of converting all params to a String

			filledUri = filledUri.replace("{storyId}", storyId + "");
		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		AsyncApiCall call = api.createNewCall();
		for (CallBack cb : callBacks) {
			call.addCallCompleteListener(cb);
		}
		Future<Object> result = null;
		Class<?> retClazz = GetNewsDetailResponseDTO.class;
		if (transport.equals("GET")) {
			result = call.callGetMethod(fullUrl, retClazz);
		} else if (transport.equals("POST")) {

			result = call.callPostMethod(fullUrl, g.toJson(storyId), retClazz);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}

	/**
	 * !This is an auto generated method!
	 * 
	 * Returns a list of CFD markets filtered by market name and/or market code
	 */
	@Override
	public ListCfdMarketsResponseDTO ListCfdMarkets(String searchByMarketName, String searchByMarketCode,
			int clientAccountId, int maxResults, JsonApi api) throws ApiException {
		// Collect variables from method
		String target = "cfd/markets";
		String uriTemplate = "?MarketName={searchByMarketName}&MarketCode={searchByMarketCode}&ClientAccountId={clientAccountId}&MaxResults={maxResults}";
		String transport = "GET";
		String envelope = "URL";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL if it is GET.
		if (transport.equals("GET")) {
			// Concatenating the empty string is a hackey way of converting all params to a String

			filledUri = filledUri.replace("{searchByMarketName}", searchByMarketName + "");
			filledUri = filledUri.replace("{searchByMarketCode}", searchByMarketCode + "");
			filledUri = filledUri.replace("{clientAccountId}", clientAccountId + "");
			filledUri = filledUri.replace("{maxResults}", maxResults + "");
		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		Object result = null;
		Class<?> retClazz = ListCfdMarketsResponseDTO.class;
		if (transport.equals("GET")) {
			result = (ListCfdMarketsResponseDTO) api.callGetMethod(fullUrl, ListCfdMarketsResponseDTO.class);
		} else if (transport.equals("POST")) {

			result = api.callPostMethod(fullUrl, g.toJson(searchByMarketName), retClazz);
			result = api.callPostMethod(fullUrl, g.toJson(searchByMarketCode), retClazz);
			result = api.callPostMethod(fullUrl, g.toJson(clientAccountId), retClazz);
			result = api.callPostMethod(fullUrl, g.toJson(maxResults), retClazz);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return (ListCfdMarketsResponseDTO) result;
	}

	/**
	 * !This is an auto generated method!
	 * 
	 * Returns a list of CFD markets filtered by market name and/or market code
	 */
	@Override
	public Future<Object> ListCfdMarketsAsync(String searchByMarketName, String searchByMarketCode,
			int clientAccountId, int maxResults, AsyncJsonApi api, CallBack... callBacks) throws ApiException {
		// Collect variables from method
		String target = "cfd/markets";
		String uriTemplate = "?MarketName={searchByMarketName}&MarketCode={searchByMarketCode}&ClientAccountId={clientAccountId}&MaxResults={maxResults}";
		String transport = "GET";
		String envelope = "URL";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL.
		if (transport.equals("GET")) {
			// Concatenating the empty string is a hackey way of converting all params to a String

			filledUri = filledUri.replace("{searchByMarketName}", searchByMarketName + "");
			filledUri = filledUri.replace("{searchByMarketCode}", searchByMarketCode + "");
			filledUri = filledUri.replace("{clientAccountId}", clientAccountId + "");
			filledUri = filledUri.replace("{maxResults}", maxResults + "");
		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		AsyncApiCall call = api.createNewCall();
		for (CallBack cb : callBacks) {
			call.addCallCompleteListener(cb);
		}
		Future<Object> result = null;
		Class<?> retClazz = ListCfdMarketsResponseDTO.class;
		if (transport.equals("GET")) {
			result = call.callGetMethod(fullUrl, retClazz);
		} else if (transport.equals("POST")) {

			result = call.callPostMethod(fullUrl, g.toJson(searchByMarketName), retClazz);
			result = call.callPostMethod(fullUrl, g.toJson(searchByMarketCode), retClazz);
			result = call.callPostMethod(fullUrl, g.toJson(clientAccountId), retClazz);
			result = call.callPostMethod(fullUrl, g.toJson(maxResults), retClazz);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}

	/**
	 * !This is an auto generated method!
	 * 
	 * Returns a list of Spread Betting markets filtered by market name and/or market code
	 */
	@Override
	public ListSpreadMarketsResponseDTO ListSpreadMarkets(String searchByMarketName, String searchByMarketCode,
			int clientAccountId, int maxResults, JsonApi api) throws ApiException {
		// Collect variables from method
		String target = "spread/markets";
		String uriTemplate = "?MarketName={searchByMarketName}&MarketCode={searchByMarketCode}&ClientAccountId={clientAccountId}&MaxResults={maxResults}";
		String transport = "GET";
		String envelope = "URL";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL if it is GET.
		if (transport.equals("GET")) {
			// Concatenating the empty string is a hackey way of converting all params to a String

			filledUri = filledUri.replace("{searchByMarketName}", searchByMarketName + "");
			filledUri = filledUri.replace("{searchByMarketCode}", searchByMarketCode + "");
			filledUri = filledUri.replace("{clientAccountId}", clientAccountId + "");
			filledUri = filledUri.replace("{maxResults}", maxResults + "");
		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		Object result = null;
		Class<?> retClazz = ListSpreadMarketsResponseDTO.class;
		if (transport.equals("GET")) {
			result = (ListSpreadMarketsResponseDTO) api.callGetMethod(fullUrl, ListSpreadMarketsResponseDTO.class);
		} else if (transport.equals("POST")) {

			result = api.callPostMethod(fullUrl, g.toJson(searchByMarketName), retClazz);
			result = api.callPostMethod(fullUrl, g.toJson(searchByMarketCode), retClazz);
			result = api.callPostMethod(fullUrl, g.toJson(clientAccountId), retClazz);
			result = api.callPostMethod(fullUrl, g.toJson(maxResults), retClazz);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return (ListSpreadMarketsResponseDTO) result;
	}

	/**
	 * !This is an auto generated method!
	 * 
	 * Returns a list of Spread Betting markets filtered by market name and/or market code
	 */
	@Override
	public Future<Object> ListSpreadMarketsAsync(String searchByMarketName, String searchByMarketCode,
			int clientAccountId, int maxResults, AsyncJsonApi api, CallBack... callBacks) throws ApiException {
		// Collect variables from method
		String target = "spread/markets";
		String uriTemplate = "?MarketName={searchByMarketName}&MarketCode={searchByMarketCode}&ClientAccountId={clientAccountId}&MaxResults={maxResults}";
		String transport = "GET";
		String envelope = "URL";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL.
		if (transport.equals("GET")) {
			// Concatenating the empty string is a hackey way of converting all params to a String

			filledUri = filledUri.replace("{searchByMarketName}", searchByMarketName + "");
			filledUri = filledUri.replace("{searchByMarketCode}", searchByMarketCode + "");
			filledUri = filledUri.replace("{clientAccountId}", clientAccountId + "");
			filledUri = filledUri.replace("{maxResults}", maxResults + "");
		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		AsyncApiCall call = api.createNewCall();
		for (CallBack cb : callBacks) {
			call.addCallCompleteListener(cb);
		}
		Future<Object> result = null;
		Class<?> retClazz = ListSpreadMarketsResponseDTO.class;
		if (transport.equals("GET")) {
			result = call.callGetMethod(fullUrl, retClazz);
		} else if (transport.equals("POST")) {

			result = call.callPostMethod(fullUrl, g.toJson(searchByMarketName), retClazz);
			result = call.callPostMethod(fullUrl, g.toJson(searchByMarketCode), retClazz);
			result = call.callPostMethod(fullUrl, g.toJson(clientAccountId), retClazz);
			result = call.callPostMethod(fullUrl, g.toJson(maxResults), retClazz);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}

	/**
	 * !This is an auto generated method!
	 * 
	 * <p>
	 * Place an order on a particular market. Post a <a
	 * onclick="dojo.hash('#type.NewStopLimitOrderRequestDTO'); return false;" class="json-link"
	 * href="#">NewStopLimitOrderRequestDTO</a> to the uri specified below.
	 * </p>
	 * <p>
	 * Do not set any order id fields when requesting a new order, the platform will generate them.
	 * </p>
	 */
	@Override
	public ApiTradeOrderResponseDTO Order(NewStopLimitOrderRequestDTO order, JsonApi api) throws ApiException {
		// Collect variables from method
		String target = "order";
		String uriTemplate = "/newstoplimitorder";
		String transport = "POST";
		String envelope = "JSON";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL if it is GET.
		if (transport.equals("GET")) {
			// Concatenating the empty string is a hackey way of converting all params to a String

			filledUri = filledUri.replace("{order}", order + "");
		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		Object result = null;
		Class<?> retClazz = ApiTradeOrderResponseDTO.class;
		if (transport.equals("GET")) {
			result = (ApiTradeOrderResponseDTO) api.callGetMethod(fullUrl, ApiTradeOrderResponseDTO.class);
		} else if (transport.equals("POST")) {

			result = api.callPostMethod(fullUrl, g.toJson(order), retClazz);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return (ApiTradeOrderResponseDTO) result;
	}

	/**
	 * !This is an auto generated method!
	 * 
	 * <p>
	 * Place an order on a particular market. Post a <a
	 * onclick="dojo.hash('#type.NewStopLimitOrderRequestDTO'); return false;" class="json-link"
	 * href="#">NewStopLimitOrderRequestDTO</a> to the uri specified below.
	 * </p>
	 * <p>
	 * Do not set any order id fields when requesting a new order, the platform will generate them.
	 * </p>
	 */
	@Override
	public Future<Object> OrderAsync(NewStopLimitOrderRequestDTO order, AsyncJsonApi api, CallBack... callBacks)
			throws ApiException {
		// Collect variables from method
		String target = "order";
		String uriTemplate = "/newstoplimitorder";
		String transport = "POST";
		String envelope = "JSON";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL.
		if (transport.equals("GET")) {
			// Concatenating the empty string is a hackey way of converting all params to a String

			filledUri = filledUri.replace("{order}", order + "");
		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		AsyncApiCall call = api.createNewCall();
		for (CallBack cb : callBacks) {
			call.addCallCompleteListener(cb);
		}
		Future<Object> result = null;
		Class<?> retClazz = ApiTradeOrderResponseDTO.class;
		if (transport.equals("GET")) {
			result = call.callGetMethod(fullUrl, retClazz);
		} else if (transport.equals("POST")) {

			result = call.callPostMethod(fullUrl, g.toJson(order), retClazz);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}

	/**
	 * !This is an auto generated method!
	 * 
	 * <p>
	 * Cancel an order. Post a <a onclick="dojo.hash('#type.CancelOrderRequestDTO'); return false;" class="json-link"
	 * href="#">CancelOrderRequestDTO</a> to the uri specified below
	 * </p>
	 */
	@Override
	public ApiTradeOrderResponseDTO CancelOrder(CancelOrderRequestDTO cancelOrder, JsonApi api) throws ApiException {
		// Collect variables from method
		String target = "order";
		String uriTemplate = "/cancel";
		String transport = "POST";
		String envelope = "JSON";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL if it is GET.
		if (transport.equals("GET")) {
			// Concatenating the empty string is a hackey way of converting all params to a String

			filledUri = filledUri.replace("{cancelOrder}", cancelOrder + "");
		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		Object result = null;
		Class<?> retClazz = ApiTradeOrderResponseDTO.class;
		if (transport.equals("GET")) {
			result = (ApiTradeOrderResponseDTO) api.callGetMethod(fullUrl, ApiTradeOrderResponseDTO.class);
		} else if (transport.equals("POST")) {

			result = api.callPostMethod(fullUrl, g.toJson(cancelOrder), retClazz);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return (ApiTradeOrderResponseDTO) result;
	}

	/**
	 * !This is an auto generated method!
	 * 
	 * <p>
	 * Cancel an order. Post a <a onclick="dojo.hash('#type.CancelOrderRequestDTO'); return false;" class="json-link"
	 * href="#">CancelOrderRequestDTO</a> to the uri specified below
	 * </p>
	 */
	@Override
	public Future<Object> CancelOrderAsync(CancelOrderRequestDTO cancelOrder, AsyncJsonApi api, CallBack... callBacks)
			throws ApiException {
		// Collect variables from method
		String target = "order";
		String uriTemplate = "/cancel";
		String transport = "POST";
		String envelope = "JSON";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL.
		if (transport.equals("GET")) {
			// Concatenating the empty string is a hackey way of converting all params to a String

			filledUri = filledUri.replace("{cancelOrder}", cancelOrder + "");
		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		AsyncApiCall call = api.createNewCall();
		for (CallBack cb : callBacks) {
			call.addCallCompleteListener(cb);
		}
		Future<Object> result = null;
		Class<?> retClazz = ApiTradeOrderResponseDTO.class;
		if (transport.equals("GET")) {
			result = call.callGetMethod(fullUrl, retClazz);
		} else if (transport.equals("POST")) {

			result = call.callPostMethod(fullUrl, g.toJson(cancelOrder), retClazz);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}

	/**
	 * !This is an auto generated method!
	 * 
	 * <p>
	 * Update an order (for adding a stop/limit or attaching an OCO relationship). Post an <a
	 * onclick="dojo.hash('#type.UpdateStopLimitOrderRequestDTO'); return false;" class="json-link"
	 * href="#">UpdateStopLimitOrderRequestDTO</a> to the uri specified below
	 * </p>
	 */
	@Override
	public ApiTradeOrderResponseDTO UpdateOrder(UpdateStopLimitOrderRequestDTO order, JsonApi api) throws ApiException {
		// Collect variables from method
		String target = "order";
		String uriTemplate = "/updatestoplimitorder";
		String transport = "POST";
		String envelope = "JSON";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL if it is GET.
		if (transport.equals("GET")) {
			// Concatenating the empty string is a hackey way of converting all params to a String

			filledUri = filledUri.replace("{order}", order + "");
		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		Object result = null;
		Class<?> retClazz = ApiTradeOrderResponseDTO.class;
		if (transport.equals("GET")) {
			result = (ApiTradeOrderResponseDTO) api.callGetMethod(fullUrl, ApiTradeOrderResponseDTO.class);
		} else if (transport.equals("POST")) {

			result = api.callPostMethod(fullUrl, g.toJson(order), retClazz);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return (ApiTradeOrderResponseDTO) result;
	}

	/**
	 * !This is an auto generated method!
	 * 
	 * <p>
	 * Update an order (for adding a stop/limit or attaching an OCO relationship). Post an <a
	 * onclick="dojo.hash('#type.UpdateStopLimitOrderRequestDTO'); return false;" class="json-link"
	 * href="#">UpdateStopLimitOrderRequestDTO</a> to the uri specified below
	 * </p>
	 */
	@Override
	public Future<Object> UpdateOrderAsync(UpdateStopLimitOrderRequestDTO order, AsyncJsonApi api,
			CallBack... callBacks) throws ApiException {
		// Collect variables from method
		String target = "order";
		String uriTemplate = "/updatestoplimitorder";
		String transport = "POST";
		String envelope = "JSON";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL.
		if (transport.equals("GET")) {
			// Concatenating the empty string is a hackey way of converting all params to a String

			filledUri = filledUri.replace("{order}", order + "");
		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		AsyncApiCall call = api.createNewCall();
		for (CallBack cb : callBacks) {
			call.addCallCompleteListener(cb);
		}
		Future<Object> result = null;
		Class<?> retClazz = ApiTradeOrderResponseDTO.class;
		if (transport.equals("GET")) {
			result = call.callGetMethod(fullUrl, retClazz);
		} else if (transport.equals("POST")) {

			result = call.callPostMethod(fullUrl, g.toJson(order), retClazz);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}

	/**
	 * !This is an auto generated method!
	 * 
	 * <p>
	 * Queries for a specified trading account's trades / open positions.
	 * </p>
	 * <p>
	 * This uri is intended to be used to support a grid in a UI. One usage pattern is to subscribe to streaming orders,
	 * call this for the initial data to display in the grid, and call <a
	 * onclick="dojo.hash('#service.GetOpenPosition'); return false;" class="json-link" href="#">GetOpenPosition</a>
	 * when you get updates on the order stream to get the updated data in this format.
	 * </p>
	 */
	@Override
	public ListOpenPositionsResponseDTO ListOpenPositions(int tradingAccountId, JsonApi api) throws ApiException {
		// Collect variables from method
		String target = "order";
		String uriTemplate = "/openpositions?TradingAccountId={tradingAccountId}";
		String transport = "GET";
		String envelope = "URL";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL if it is GET.
		if (transport.equals("GET")) {
			// Concatenating the empty string is a hackey way of converting all params to a String

			filledUri = filledUri.replace("{tradingAccountId}", tradingAccountId + "");
		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		Object result = null;
		Class<?> retClazz = ListOpenPositionsResponseDTO.class;
		if (transport.equals("GET")) {
			result = (ListOpenPositionsResponseDTO) api.callGetMethod(fullUrl, ListOpenPositionsResponseDTO.class);
		} else if (transport.equals("POST")) {

			result = api.callPostMethod(fullUrl, g.toJson(tradingAccountId), retClazz);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return (ListOpenPositionsResponseDTO) result;
	}

	/**
	 * !This is an auto generated method!
	 * 
	 * <p>
	 * Queries for a specified trading account's trades / open positions.
	 * </p>
	 * <p>
	 * This uri is intended to be used to support a grid in a UI. One usage pattern is to subscribe to streaming orders,
	 * call this for the initial data to display in the grid, and call <a
	 * onclick="dojo.hash('#service.GetOpenPosition'); return false;" class="json-link" href="#">GetOpenPosition</a>
	 * when you get updates on the order stream to get the updated data in this format.
	 * </p>
	 */
	@Override
	public Future<Object> ListOpenPositionsAsync(int tradingAccountId, AsyncJsonApi api, CallBack... callBacks)
			throws ApiException {
		// Collect variables from method
		String target = "order";
		String uriTemplate = "/openpositions?TradingAccountId={tradingAccountId}";
		String transport = "GET";
		String envelope = "URL";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL.
		if (transport.equals("GET")) {
			// Concatenating the empty string is a hackey way of converting all params to a String

			filledUri = filledUri.replace("{tradingAccountId}", tradingAccountId + "");
		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		AsyncApiCall call = api.createNewCall();
		for (CallBack cb : callBacks) {
			call.addCallCompleteListener(cb);
		}
		Future<Object> result = null;
		Class<?> retClazz = ListOpenPositionsResponseDTO.class;
		if (transport.equals("GET")) {
			result = call.callGetMethod(fullUrl, retClazz);
		} else if (transport.equals("POST")) {

			result = call.callPostMethod(fullUrl, g.toJson(tradingAccountId), retClazz);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}

	/**
	 * !This is an auto generated method!
	 * 
	 * <p>
	 * Queries for a specified trading account's active stop / limit orders.
	 * </p>
	 * <p>
	 * This uri is intended to be used to support a grid in a UI. One usage pattern is to subscribe to streaming orders,
	 * call this for the initial data to display in the grid, and call <a
	 * onclick="dojo.hash('#service.GetActiveStopLimitOrder'); return false;" class="json-link"
	 * href="#">GetActiveStopLimitOrder</a> when you get updates on the order stream to get the updated data in this
	 * format.
	 * </p>
	 */
	@Override
	public ListActiveStopLimitOrderResponseDTO ListActiveStopLimitOrders(int tradingAccountId, JsonApi api)
			throws ApiException {
		// Collect variables from method
		String target = "order";
		String uriTemplate = "/activestoplimitorders?TradingAccountId={tradingAccountId}";
		String transport = "GET";
		String envelope = "URL";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL if it is GET.
		if (transport.equals("GET")) {
			// Concatenating the empty string is a hackey way of converting all params to a String

			filledUri = filledUri.replace("{tradingAccountId}", tradingAccountId + "");
		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		Object result = null;
		Class<?> retClazz = ListActiveStopLimitOrderResponseDTO.class;
		if (transport.equals("GET")) {
			result = (ListActiveStopLimitOrderResponseDTO) api.callGetMethod(fullUrl,
					ListActiveStopLimitOrderResponseDTO.class);
		} else if (transport.equals("POST")) {

			result = api.callPostMethod(fullUrl, g.toJson(tradingAccountId), retClazz);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return (ListActiveStopLimitOrderResponseDTO) result;
	}

	/**
	 * !This is an auto generated method!
	 * 
	 * <p>
	 * Queries for a specified trading account's active stop / limit orders.
	 * </p>
	 * <p>
	 * This uri is intended to be used to support a grid in a UI. One usage pattern is to subscribe to streaming orders,
	 * call this for the initial data to display in the grid, and call <a
	 * onclick="dojo.hash('#service.GetActiveStopLimitOrder'); return false;" class="json-link"
	 * href="#">GetActiveStopLimitOrder</a> when you get updates on the order stream to get the updated data in this
	 * format.
	 * </p>
	 */
	@Override
	public Future<Object> ListActiveStopLimitOrdersAsync(int tradingAccountId, AsyncJsonApi api, CallBack... callBacks)
			throws ApiException {
		// Collect variables from method
		String target = "order";
		String uriTemplate = "/activestoplimitorders?TradingAccountId={tradingAccountId}";
		String transport = "GET";
		String envelope = "URL";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL.
		if (transport.equals("GET")) {
			// Concatenating the empty string is a hackey way of converting all params to a String

			filledUri = filledUri.replace("{tradingAccountId}", tradingAccountId + "");
		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		AsyncApiCall call = api.createNewCall();
		for (CallBack cb : callBacks) {
			call.addCallCompleteListener(cb);
		}
		Future<Object> result = null;
		Class<?> retClazz = ListActiveStopLimitOrderResponseDTO.class;
		if (transport.equals("GET")) {
			result = call.callGetMethod(fullUrl, retClazz);
		} else if (transport.equals("POST")) {

			result = call.callPostMethod(fullUrl, g.toJson(tradingAccountId), retClazz);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}

	/**
	 * !This is an auto generated method!
	 * 
	 * <p>
	 * Queries for a active stop limit order with a specified order id. It will return a null value if the order doesn't
	 * exist, or is not an active stop limit order.
	 * <p>
	 * <p>
	 * This uri is intended to be used to support a grid in a UI. One usage pattern is to subscribe to streaming orders,
	 * call <a onclick="dojo.hash('#service.ListActiveStopLimitOrders'); return false;" class="json-link"
	 * href="#">ListActiveStopLimitOrders</a> for the initial data to display in the grid, and call this uri when you
	 * get updates on the order stream to get the updated data in this format.
	 * </p>
	 * <p>
	 * For a more comprehensive order response, see <a onclick="dojo.hash('#service.GetOrder'); return false;"
	 * class="json-link" href="#">GetOrder</a>
	 * <p>
	 */
	@Override
	public GetActiveStopLimitOrderResponseDTO GetActiveStopLimitOrder(String orderId, JsonApi api) throws ApiException {
		// Collect variables from method
		String target = "order";
		String uriTemplate = "/{orderId}/activestoplimitorder";
		String transport = "GET";
		String envelope = "URL";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL if it is GET.
		if (transport.equals("GET")) {
			// Concatenating the empty string is a hackey way of converting all params to a String

			filledUri = filledUri.replace("{orderId}", orderId + "");
		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		Object result = null;
		Class<?> retClazz = GetActiveStopLimitOrderResponseDTO.class;
		if (transport.equals("GET")) {
			result = (GetActiveStopLimitOrderResponseDTO) api.callGetMethod(fullUrl,
					GetActiveStopLimitOrderResponseDTO.class);
		} else if (transport.equals("POST")) {

			result = api.callPostMethod(fullUrl, g.toJson(orderId), retClazz);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return (GetActiveStopLimitOrderResponseDTO) result;
	}

	/**
	 * !This is an auto generated method!
	 * 
	 * <p>
	 * Queries for a active stop limit order with a specified order id. It will return a null value if the order doesn't
	 * exist, or is not an active stop limit order.
	 * <p>
	 * <p>
	 * This uri is intended to be used to support a grid in a UI. One usage pattern is to subscribe to streaming orders,
	 * call <a onclick="dojo.hash('#service.ListActiveStopLimitOrders'); return false;" class="json-link"
	 * href="#">ListActiveStopLimitOrders</a> for the initial data to display in the grid, and call this uri when you
	 * get updates on the order stream to get the updated data in this format.
	 * </p>
	 * <p>
	 * For a more comprehensive order response, see <a onclick="dojo.hash('#service.GetOrder'); return false;"
	 * class="json-link" href="#">GetOrder</a>
	 * <p>
	 */
	@Override
	public Future<Object> GetActiveStopLimitOrderAsync(String orderId, AsyncJsonApi api, CallBack... callBacks)
			throws ApiException {
		// Collect variables from method
		String target = "order";
		String uriTemplate = "/{orderId}/activestoplimitorder";
		String transport = "GET";
		String envelope = "URL";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL.
		if (transport.equals("GET")) {
			// Concatenating the empty string is a hackey way of converting all params to a String

			filledUri = filledUri.replace("{orderId}", orderId + "");
		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		AsyncApiCall call = api.createNewCall();
		for (CallBack cb : callBacks) {
			call.addCallCompleteListener(cb);
		}
		Future<Object> result = null;
		Class<?> retClazz = GetActiveStopLimitOrderResponseDTO.class;
		if (transport.equals("GET")) {
			result = call.callGetMethod(fullUrl, retClazz);
		} else if (transport.equals("POST")) {

			result = call.callPostMethod(fullUrl, g.toJson(orderId), retClazz);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}

	/**
	 * !This is an auto generated method!
	 * 
	 * <p>
	 * Queries for a trade / open position with a specified order id. It will return a null value if the order doesn't
	 * exist, or is not a trade / open position.
	 * </p>
	 * <p>
	 * This uri is intended to be used to support a grid in a UI. One usage pattern is to subscribe to streaming orders,
	 * call <a onclick="dojo.hash('#service.ListOpenPositions'); return false;" class="json-link"
	 * href="#">ListOpenPositions</a> for the initial data to display in the grid, and call this uri when you get
	 * updates on the order stream to get the updated data in this format.
	 * </p>
	 * <p>
	 * For a more comprehensive order response, see <a onclick="dojo.hash('#service.GetOrder'); return false;"
	 * class="json-link" href="#">GetOrder</a>
	 * <p>
	 */
	@Override
	public GetOpenPositionResponseDTO GetOpenPosition(String orderId, JsonApi api) throws ApiException {
		// Collect variables from method
		String target = "order";
		String uriTemplate = "/{orderId}/openposition";
		String transport = "GET";
		String envelope = "URL";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL if it is GET.
		if (transport.equals("GET")) {
			// Concatenating the empty string is a hackey way of converting all params to a String

			filledUri = filledUri.replace("{orderId}", orderId + "");
		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		Object result = null;
		Class<?> retClazz = GetOpenPositionResponseDTO.class;
		if (transport.equals("GET")) {
			result = (GetOpenPositionResponseDTO) api.callGetMethod(fullUrl, GetOpenPositionResponseDTO.class);
		} else if (transport.equals("POST")) {

			result = api.callPostMethod(fullUrl, g.toJson(orderId), retClazz);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return (GetOpenPositionResponseDTO) result;
	}

	/**
	 * !This is an auto generated method!
	 * 
	 * <p>
	 * Queries for a trade / open position with a specified order id. It will return a null value if the order doesn't
	 * exist, or is not a trade / open position.
	 * </p>
	 * <p>
	 * This uri is intended to be used to support a grid in a UI. One usage pattern is to subscribe to streaming orders,
	 * call <a onclick="dojo.hash('#service.ListOpenPositions'); return false;" class="json-link"
	 * href="#">ListOpenPositions</a> for the initial data to display in the grid, and call this uri when you get
	 * updates on the order stream to get the updated data in this format.
	 * </p>
	 * <p>
	 * For a more comprehensive order response, see <a onclick="dojo.hash('#service.GetOrder'); return false;"
	 * class="json-link" href="#">GetOrder</a>
	 * <p>
	 */
	@Override
	public Future<Object> GetOpenPositionAsync(String orderId, AsyncJsonApi api, CallBack... callBacks)
			throws ApiException {
		// Collect variables from method
		String target = "order";
		String uriTemplate = "/{orderId}/openposition";
		String transport = "GET";
		String envelope = "URL";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL.
		if (transport.equals("GET")) {
			// Concatenating the empty string is a hackey way of converting all params to a String

			filledUri = filledUri.replace("{orderId}", orderId + "");
		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		AsyncApiCall call = api.createNewCall();
		for (CallBack cb : callBacks) {
			call.addCallCompleteListener(cb);
		}
		Future<Object> result = null;
		Class<?> retClazz = GetOpenPositionResponseDTO.class;
		if (transport.equals("GET")) {
			result = call.callGetMethod(fullUrl, retClazz);
		} else if (transport.equals("POST")) {

			result = call.callPostMethod(fullUrl, g.toJson(orderId), retClazz);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}

	/**
	 * !This is an auto generated method!
	 * 
	 * <p>
	 * Queries for a specified trading account's trade history. The result set will contain orders with a status of
	 * <b>(3 - Open, 9 - Closed)</b>, and includes <b>orders that were a trade / stop / limit order</b>.
	 * </p>
	 * <p>
	 * There's currently no corresponding GetTradeHistory (as with ListOpenPositions).
	 * </p>
	 */
	@Override
	public ListTradeHistoryResponseDTO ListTradeHistory(int tradingAccountId, int maxResults, JsonApi api)
			throws ApiException {
		// Collect variables from method
		String target = "order";
		String uriTemplate = "/tradehistory?TradingAccountId={tradingAccountId}&MaxResults={maxResults}";
		String transport = "GET";
		String envelope = "URL";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL if it is GET.
		if (transport.equals("GET")) {
			// Concatenating the empty string is a hackey way of converting all params to a String

			filledUri = filledUri.replace("{tradingAccountId}", tradingAccountId + "");
			filledUri = filledUri.replace("{maxResults}", maxResults + "");
		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		Object result = null;
		Class<?> retClazz = ListTradeHistoryResponseDTO.class;
		if (transport.equals("GET")) {
			result = (ListTradeHistoryResponseDTO) api.callGetMethod(fullUrl, ListTradeHistoryResponseDTO.class);
		} else if (transport.equals("POST")) {

			result = api.callPostMethod(fullUrl, g.toJson(tradingAccountId), retClazz);
			result = api.callPostMethod(fullUrl, g.toJson(maxResults), retClazz);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return (ListTradeHistoryResponseDTO) result;
	}

	/**
	 * !This is an auto generated method!
	 * 
	 * <p>
	 * Queries for a specified trading account's trade history. The result set will contain orders with a status of
	 * <b>(3 - Open, 9 - Closed)</b>, and includes <b>orders that were a trade / stop / limit order</b>.
	 * </p>
	 * <p>
	 * There's currently no corresponding GetTradeHistory (as with ListOpenPositions).
	 * </p>
	 */
	@Override
	public Future<Object> ListTradeHistoryAsync(int tradingAccountId, int maxResults, AsyncJsonApi api,
			CallBack... callBacks) throws ApiException {
		// Collect variables from method
		String target = "order";
		String uriTemplate = "/tradehistory?TradingAccountId={tradingAccountId}&MaxResults={maxResults}";
		String transport = "GET";
		String envelope = "URL";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL.
		if (transport.equals("GET")) {
			// Concatenating the empty string is a hackey way of converting all params to a String

			filledUri = filledUri.replace("{tradingAccountId}", tradingAccountId + "");
			filledUri = filledUri.replace("{maxResults}", maxResults + "");
		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		AsyncApiCall call = api.createNewCall();
		for (CallBack cb : callBacks) {
			call.addCallCompleteListener(cb);
		}
		Future<Object> result = null;
		Class<?> retClazz = ListTradeHistoryResponseDTO.class;
		if (transport.equals("GET")) {
			result = call.callGetMethod(fullUrl, retClazz);
		} else if (transport.equals("POST")) {

			result = call.callPostMethod(fullUrl, g.toJson(tradingAccountId), retClazz);
			result = call.callPostMethod(fullUrl, g.toJson(maxResults), retClazz);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}

	/**
	 * !This is an auto generated method!
	 * 
	 * <p>
	 * Queries for a specified trading account's stop / limit order history. The result set will include <b>only orders
	 * that were originally stop / limit orders</b> that currently have one of the following statuses <b>(3 - Open, 4 -
	 * Cancelled, 5 - Rejected, 9 - Closed, 10 - Red Card)</b>
	 * </p>
	 * <p>
	 * There's currently no corresponding GetStopLimitOrderHistory (as with ListActiveStopLimitOrders).
	 * </p>
	 */
	@Override
	public ListStopLimitOrderHistoryResponseDTO ListStopLimitOrderHistory(int tradingAccountId, int maxResults,
			JsonApi api) throws ApiException {
		// Collect variables from method
		String target = "order";
		String uriTemplate = "/stoplimitorderhistory?TradingAccountId={tradingAccountId}&MaxResults={maxResults}";
		String transport = "GET";
		String envelope = "URL";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL if it is GET.
		if (transport.equals("GET")) {
			// Concatenating the empty string is a hackey way of converting all params to a String

			filledUri = filledUri.replace("{tradingAccountId}", tradingAccountId + "");
			filledUri = filledUri.replace("{maxResults}", maxResults + "");
		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		Object result = null;
		Class<?> retClazz = ListStopLimitOrderHistoryResponseDTO.class;
		if (transport.equals("GET")) {
			result = (ListStopLimitOrderHistoryResponseDTO) api.callGetMethod(fullUrl,
					ListStopLimitOrderHistoryResponseDTO.class);
		} else if (transport.equals("POST")) {

			result = api.callPostMethod(fullUrl, g.toJson(tradingAccountId), retClazz);
			result = api.callPostMethod(fullUrl, g.toJson(maxResults), retClazz);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return (ListStopLimitOrderHistoryResponseDTO) result;
	}

	/**
	 * !This is an auto generated method!
	 * 
	 * <p>
	 * Queries for a specified trading account's stop / limit order history. The result set will include <b>only orders
	 * that were originally stop / limit orders</b> that currently have one of the following statuses <b>(3 - Open, 4 -
	 * Cancelled, 5 - Rejected, 9 - Closed, 10 - Red Card)</b>
	 * </p>
	 * <p>
	 * There's currently no corresponding GetStopLimitOrderHistory (as with ListActiveStopLimitOrders).
	 * </p>
	 */
	@Override
	public Future<Object> ListStopLimitOrderHistoryAsync(int tradingAccountId, int maxResults, AsyncJsonApi api,
			CallBack... callBacks) throws ApiException {
		// Collect variables from method
		String target = "order";
		String uriTemplate = "/stoplimitorderhistory?TradingAccountId={tradingAccountId}&MaxResults={maxResults}";
		String transport = "GET";
		String envelope = "URL";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL.
		if (transport.equals("GET")) {
			// Concatenating the empty string is a hackey way of converting all params to a String

			filledUri = filledUri.replace("{tradingAccountId}", tradingAccountId + "");
			filledUri = filledUri.replace("{maxResults}", maxResults + "");
		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		AsyncApiCall call = api.createNewCall();
		for (CallBack cb : callBacks) {
			call.addCallCompleteListener(cb);
		}
		Future<Object> result = null;
		Class<?> retClazz = ListStopLimitOrderHistoryResponseDTO.class;
		if (transport.equals("GET")) {
			result = call.callGetMethod(fullUrl, retClazz);
		} else if (transport.equals("POST")) {

			result = call.callPostMethod(fullUrl, g.toJson(tradingAccountId), retClazz);
			result = call.callPostMethod(fullUrl, g.toJson(maxResults), retClazz);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}

	/**
	 * !This is an auto generated method!
	 * 
	 * <p>
	 * Queries for an order by a specific order id.
	 * </p>
	 * <p>
	 * The current implementation only returns active orders (i.e. those with a status of <b>1 - Pending, 2 - Accepted,
	 * 3 - Open, 6 - Suspended, 8 - Yellow Card, 11 - Triggered)</b>.
	 * </p>
	 */
	@Override
	public GetOrderResponseDTO GetOrder(String orderId, JsonApi api) throws ApiException {
		// Collect variables from method
		String target = "order";
		String uriTemplate = "/{orderId}";
		String transport = "GET";
		String envelope = "URL";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL if it is GET.
		if (transport.equals("GET")) {
			// Concatenating the empty string is a hackey way of converting all params to a String

			filledUri = filledUri.replace("{orderId}", orderId + "");
		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		Object result = null;
		Class<?> retClazz = GetOrderResponseDTO.class;
		if (transport.equals("GET")) {
			result = (GetOrderResponseDTO) api.callGetMethod(fullUrl, GetOrderResponseDTO.class);
		} else if (transport.equals("POST")) {

			result = api.callPostMethod(fullUrl, g.toJson(orderId), retClazz);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return (GetOrderResponseDTO) result;
	}

	/**
	 * !This is an auto generated method!
	 * 
	 * <p>
	 * Queries for an order by a specific order id.
	 * </p>
	 * <p>
	 * The current implementation only returns active orders (i.e. those with a status of <b>1 - Pending, 2 - Accepted,
	 * 3 - Open, 6 - Suspended, 8 - Yellow Card, 11 - Triggered)</b>.
	 * </p>
	 */
	@Override
	public Future<Object> GetOrderAsync(String orderId, AsyncJsonApi api, CallBack... callBacks) throws ApiException {
		// Collect variables from method
		String target = "order";
		String uriTemplate = "/{orderId}";
		String transport = "GET";
		String envelope = "URL";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL.
		if (transport.equals("GET")) {
			// Concatenating the empty string is a hackey way of converting all params to a String

			filledUri = filledUri.replace("{orderId}", orderId + "");
		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		AsyncApiCall call = api.createNewCall();
		for (CallBack cb : callBacks) {
			call.addCallCompleteListener(cb);
		}
		Future<Object> result = null;
		Class<?> retClazz = GetOrderResponseDTO.class;
		if (transport.equals("GET")) {
			result = call.callGetMethod(fullUrl, retClazz);
		} else if (transport.equals("POST")) {

			result = call.callPostMethod(fullUrl, g.toJson(orderId), retClazz);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}

	/**
	 * !This is an auto generated method!
	 * 
	 * <p>
	 * Place a trade on a particular market. Post a <a
	 * onclick="dojo.hash('#type.NewTradeOrderRequestDTO'); return false;" class="json-link"
	 * href="#">NewTradeOrderRequestDTO</a> to the uri specified below.
	 * </p>
	 * <p>
	 * Do not set any order id fields when requesting a new trade, the platform will generate them.
	 * </p>
	 */
	@Override
	public ApiTradeOrderResponseDTO Trade(NewTradeOrderRequestDTO trade, JsonApi api) throws ApiException {
		// Collect variables from method
		String target = "order";
		String uriTemplate = "/newtradeorder";
		String transport = "POST";
		String envelope = "JSON";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL if it is GET.
		if (transport.equals("GET")) {
			// Concatenating the empty string is a hackey way of converting all params to a String

			filledUri = filledUri.replace("{trade}", trade + "");
		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		Object result = null;
		Class<?> retClazz = ApiTradeOrderResponseDTO.class;
		if (transport.equals("GET")) {
			result = (ApiTradeOrderResponseDTO) api.callGetMethod(fullUrl, ApiTradeOrderResponseDTO.class);
		} else if (transport.equals("POST")) {

			result = api.callPostMethod(fullUrl, g.toJson(trade), retClazz);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return (ApiTradeOrderResponseDTO) result;
	}

	/**
	 * !This is an auto generated method!
	 * 
	 * <p>
	 * Place a trade on a particular market. Post a <a
	 * onclick="dojo.hash('#type.NewTradeOrderRequestDTO'); return false;" class="json-link"
	 * href="#">NewTradeOrderRequestDTO</a> to the uri specified below.
	 * </p>
	 * <p>
	 * Do not set any order id fields when requesting a new trade, the platform will generate them.
	 * </p>
	 */
	@Override
	public Future<Object> TradeAsync(NewTradeOrderRequestDTO trade, AsyncJsonApi api, CallBack... callBacks)
			throws ApiException {
		// Collect variables from method
		String target = "order";
		String uriTemplate = "/newtradeorder";
		String transport = "POST";
		String envelope = "JSON";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL.
		if (transport.equals("GET")) {
			// Concatenating the empty string is a hackey way of converting all params to a String

			filledUri = filledUri.replace("{trade}", trade + "");
		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		AsyncApiCall call = api.createNewCall();
		for (CallBack cb : callBacks) {
			call.addCallCompleteListener(cb);
		}
		Future<Object> result = null;
		Class<?> retClazz = ApiTradeOrderResponseDTO.class;
		if (transport.equals("GET")) {
			result = call.callGetMethod(fullUrl, retClazz);
		} else if (transport.equals("POST")) {

			result = call.callPostMethod(fullUrl, g.toJson(trade), retClazz);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}

	/**
	 * !This is an auto generated method!
	 * 
	 * Update a trade (for adding a stop/limit etc). Post an <a
	 * onclick="dojo.hash('#type.UpdateTradeOrderRequestDTO'); return false;" class="json-link"
	 * href="#">UpdateTradeOrderRequestDTO</a> to the uri specified below</p>
	 */
	@Override
	public ApiTradeOrderResponseDTO UpdateTrade(UpdateTradeOrderRequestDTO update, JsonApi api) throws ApiException {
		// Collect variables from method
		String target = "order";
		String uriTemplate = "/updatetradeorder";
		String transport = "POST";
		String envelope = "JSON";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL if it is GET.
		if (transport.equals("GET")) {
			// Concatenating the empty string is a hackey way of converting all params to a String

			filledUri = filledUri.replace("{update}", update + "");
		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		Object result = null;
		Class<?> retClazz = ApiTradeOrderResponseDTO.class;
		if (transport.equals("GET")) {
			result = (ApiTradeOrderResponseDTO) api.callGetMethod(fullUrl, ApiTradeOrderResponseDTO.class);
		} else if (transport.equals("POST")) {

			result = api.callPostMethod(fullUrl, g.toJson(update), retClazz);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return (ApiTradeOrderResponseDTO) result;
	}

	/**
	 * !This is an auto generated method!
	 * 
	 * Update a trade (for adding a stop/limit etc). Post an <a
	 * onclick="dojo.hash('#type.UpdateTradeOrderRequestDTO'); return false;" class="json-link"
	 * href="#">UpdateTradeOrderRequestDTO</a> to the uri specified below</p>
	 */
	@Override
	public Future<Object> UpdateTradeAsync(UpdateTradeOrderRequestDTO update, AsyncJsonApi api, CallBack... callBacks)
			throws ApiException {
		// Collect variables from method
		String target = "order";
		String uriTemplate = "/updatetradeorder";
		String transport = "POST";
		String envelope = "JSON";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL.
		if (transport.equals("GET")) {
			// Concatenating the empty string is a hackey way of converting all params to a String

			filledUri = filledUri.replace("{update}", update + "");
		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		AsyncApiCall call = api.createNewCall();
		for (CallBack cb : callBacks) {
			call.addCallCompleteListener(cb);
		}
		Future<Object> result = null;
		Class<?> retClazz = ApiTradeOrderResponseDTO.class;
		if (transport.equals("GET")) {
			result = call.callGetMethod(fullUrl, retClazz);
		} else if (transport.equals("POST")) {

			result = call.callPostMethod(fullUrl, g.toJson(update), retClazz);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}

	/**
	 * !This is an auto generated method!
	 * 
	 * Returns the Users ClientAccountId and a list of their TradingAccounts. There are no parameters for this call.
	 */
	@Override
	public AccountInformationResponseDTO GetClientAndTradingAccount(JsonApi api) throws ApiException {
		// Collect variables from method
		String target = "useraccount";
		String uriTemplate = "/UserAccount/ClientAndTradingAccount";
		String transport = "GET";
		String envelope = "URL";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL if it is GET.
		if (transport.equals("GET")) {
			// Concatenating the empty string is a hackey way of converting all params to a String

		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		Object result = null;
		Class<?> retClazz = AccountInformationResponseDTO.class;
		if (transport.equals("GET")) {
			result = (AccountInformationResponseDTO) api.callGetMethod(fullUrl, AccountInformationResponseDTO.class);
		} else if (transport.equals("POST")) {

		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return (AccountInformationResponseDTO) result;
	}

	/**
	 * !This is an auto generated method!
	 * 
	 * Returns the Users ClientAccountId and a list of their TradingAccounts. There are no parameters for this call.
	 */
	@Override
	public Future<Object> GetClientAndTradingAccountAsync(AsyncJsonApi api, CallBack... callBacks) throws ApiException {
		// Collect variables from method
		String target = "useraccount";
		String uriTemplate = "/UserAccount/ClientAndTradingAccount";
		String transport = "GET";
		String envelope = "URL";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL.
		if (transport.equals("GET")) {
			// Concatenating the empty string is a hackey way of converting all params to a String

		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		AsyncApiCall call = api.createNewCall();
		for (CallBack cb : callBacks) {
			call.addCallCompleteListener(cb);
		}
		Future<Object> result = null;
		Class<?> retClazz = AccountInformationResponseDTO.class;
		if (transport.equals("GET")) {
			result = call.callGetMethod(fullUrl, retClazz);
		} else if (transport.equals("POST")) {

		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}

	/**
	 * !This is an auto generated method!
	 * 
	 * Simulates an error condition.
	 */
	@Override
	public ApiErrorResponseDTO GenerateException(int errorCode, JsonApi api) throws ApiException {
		// Collect variables from method
		String target = "errors";
		String uriTemplate = "?errorCode={errorCode}";
		String transport = "GET";
		String envelope = "URL";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL if it is GET.
		if (transport.equals("GET")) {
			// Concatenating the empty string is a hackey way of converting all params to a String

			filledUri = filledUri.replace("{errorCode}", errorCode + "");
		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		Object result = null;
		Class<?> retClazz = ApiErrorResponseDTO.class;
		if (transport.equals("GET")) {
			result = (ApiErrorResponseDTO) api.callGetMethod(fullUrl, ApiErrorResponseDTO.class);
		} else if (transport.equals("POST")) {

			result = api.callPostMethod(fullUrl, g.toJson(errorCode), retClazz);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return (ApiErrorResponseDTO) result;
	}

	/**
	 * !This is an auto generated method!
	 * 
	 * Simulates an error condition.
	 */
	@Override
	public Future<Object> GenerateExceptionAsync(int errorCode, AsyncJsonApi api, CallBack... callBacks)
			throws ApiException {
		// Collect variables from method
		String target = "errors";
		String uriTemplate = "?errorCode={errorCode}";
		String transport = "GET";
		String envelope = "URL";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL.
		if (transport.equals("GET")) {
			// Concatenating the empty string is a hackey way of converting all params to a String

			filledUri = filledUri.replace("{errorCode}", errorCode + "");
		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		AsyncApiCall call = api.createNewCall();
		for (CallBack cb : callBacks) {
			call.addCallCompleteListener(cb);
		}
		Future<Object> result = null;
		Class<?> retClazz = ApiErrorResponseDTO.class;
		if (transport.equals("GET")) {
			result = call.callGetMethod(fullUrl, retClazz);
		} else if (transport.equals("POST")) {

			result = call.callPostMethod(fullUrl, g.toJson(errorCode), retClazz);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}
}
