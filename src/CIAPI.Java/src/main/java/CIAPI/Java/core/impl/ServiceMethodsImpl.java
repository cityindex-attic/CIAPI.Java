package CIAPI.Java.core.impl;

import java.util.concurrent.Future;

import com.google.gson.JsonObject;

import JsonClient.Java.ApiException;
import JsonClient.Java.JsonApi;
import JsonClient.Java.async.AsyncJsonApi;
import JsonClient.Java.async.CallBack;
import JsonClient.Java.async.AsyncApiCall;

import CIAPI.Java.core.ServiceMethods;
import CIAPI.Java.core.dto.*;

public class ServiceMethodsImpl implements ServiceMethods {

	
	/**
	 * !This is an auto generated method!
	 *
	 * <p>Create a new session. This is how you "log on" to the CIAPI. Post a <a onclick="dojo.hash('#type.ApiLogOnRequestDTO'); return false;" class="json-link" href="#">ApiLogOnRequestDTO</a> to the uri specified below</p>
	 */
	@Override
	public ApiLogOnResponseDTO LogOn(String UserName,String Password, JsonApi api) 
												throws ApiException {
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
			
			filledUri = filledUri.replace("{UserName}", UserName + "");
			filledUri = filledUri.replace("{Password}", Password + "");
		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		ApiLogOnResponseDTO result;
		if (transport.equals("GET")) {
			result = (ApiLogOnResponseDTO) api.callGetMethod(fullUrl, ApiLogOnResponseDTO.class);
		} else if (transport.equals("POST")) {
			JsonObject obj = new JsonObject();
			
			obj.addProperty("UserName", UserName  + "");
			obj.addProperty("Password", Password  + "");
			result = (ApiLogOnResponseDTO) api.callPostMethod(fullUrl, obj.toString(), ApiLogOnResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}
	
	/**
	 * !This is an auto generated method!
	 *
	 * <p>Create a new session. This is how you "log on" to the CIAPI. Post a <a onclick="dojo.hash('#type.ApiLogOnRequestDTO'); return false;" class="json-link" href="#">ApiLogOnRequestDTO</a> to the uri specified below</p>
	 */
	@Override
	public Future<Object> LogOnAsync(String UserName,String Password, AsyncJsonApi api, CallBack... callBacks) throws ApiException {
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
			
			filledUri = filledUri.replace("{UserName}", UserName + "");
			filledUri = filledUri.replace("{Password}", Password + "");
		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		AsyncApiCall call = api.createNewCall();
		for (CallBack cb : callBacks) {
			call.addCallCompleteListener(cb);
		}
		Future<Object> result;
		if (transport.equals("GET")) {
			result = call.callGetMethod(fullUrl, ApiLogOnResponseDTO.class);
		} else if (transport.equals("POST")) {
			JsonObject obj = new JsonObject();
			
			obj.addProperty("UserName", UserName  + "");
			obj.addProperty("Password", Password  + "");
			result = call.callPostMethod(fullUrl, obj.toString(), ApiLogOnResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}
	/**
	 * !This is an auto generated method!
	 *
	 * <p>Delete a session. This is how you "log off" from the CIAPI.</p>
	 */
	@Override
	public ApiLogOffResponseDTO DeleteSession(String userName,String session, JsonApi api) 
												throws ApiException {
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
		ApiLogOffResponseDTO result;
		if (transport.equals("GET")) {
			result = (ApiLogOffResponseDTO) api.callGetMethod(fullUrl, ApiLogOffResponseDTO.class);
		} else if (transport.equals("POST")) {
			JsonObject obj = new JsonObject();
			
			obj.addProperty("userName", userName  + "");
			obj.addProperty("session", session  + "");
			result = (ApiLogOffResponseDTO) api.callPostMethod(fullUrl, obj.toString(), ApiLogOffResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}
	
	/**
	 * !This is an auto generated method!
	 *
	 * <p>Delete a session. This is how you "log off" from the CIAPI.</p>
	 */
	@Override
	public Future<Object> DeleteSessionAsync(String userName,String session, AsyncJsonApi api, CallBack... callBacks) throws ApiException {
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
		Future<Object> result;
		if (transport.equals("GET")) {
			result = call.callGetMethod(fullUrl, ApiLogOffResponseDTO.class);
		} else if (transport.equals("POST")) {
			JsonObject obj = new JsonObject();
			
			obj.addProperty("userName", userName  + "");
			obj.addProperty("session", session  + "");
			result = call.callPostMethod(fullUrl, obj.toString(), ApiLogOffResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}
	/**
	 * !This is an auto generated method!
	 *
	 * Get historic price bars in OHLC (open, high, low, close) format, suitable for plotting candlestick chartsReturns price bars in ascending order up to the current time.When there are no prices per a particular time period, no price bar is returned. Thus, it can appear that the array of price bars has "gaps", i.e. the gap between the datetime of each price bar might not be equal to interval x spanSample Urls: /market/1234/history?interval=MINUTE&span=15&pricebars=180/market/735/history?interval=HOUR&span=1&pricebars=240/market/1577/history?interval=DAY&span=1&pricebars=10
	 */
	@Override
	public GetPriceBarResponseDTO GetPriceBars(String marketId,String interval,int span,String priceBars, JsonApi api) 
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
		GetPriceBarResponseDTO result;
		if (transport.equals("GET")) {
			result = (GetPriceBarResponseDTO) api.callGetMethod(fullUrl, GetPriceBarResponseDTO.class);
		} else if (transport.equals("POST")) {
			JsonObject obj = new JsonObject();
			
			obj.addProperty("marketId", marketId  + "");
			obj.addProperty("interval", interval  + "");
			obj.addProperty("span", span  + "");
			obj.addProperty("priceBars", priceBars  + "");
			result = (GetPriceBarResponseDTO) api.callPostMethod(fullUrl, obj.toString(), GetPriceBarResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}
	
	/**
	 * !This is an auto generated method!
	 *
	 * Get historic price bars in OHLC (open, high, low, close) format, suitable for plotting candlestick chartsReturns price bars in ascending order up to the current time.When there are no prices per a particular time period, no price bar is returned. Thus, it can appear that the array of price bars has "gaps", i.e. the gap between the datetime of each price bar might not be equal to interval x spanSample Urls: /market/1234/history?interval=MINUTE&span=15&pricebars=180/market/735/history?interval=HOUR&span=1&pricebars=240/market/1577/history?interval=DAY&span=1&pricebars=10
	 */
	@Override
	public Future<Object> GetPriceBarsAsync(String marketId,String interval,int span,String priceBars, AsyncJsonApi api, CallBack... callBacks) throws ApiException {
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
		Future<Object> result;
		if (transport.equals("GET")) {
			result = call.callGetMethod(fullUrl, GetPriceBarResponseDTO.class);
		} else if (transport.equals("POST")) {
			JsonObject obj = new JsonObject();
			
			obj.addProperty("marketId", marketId  + "");
			obj.addProperty("interval", interval  + "");
			obj.addProperty("span", span  + "");
			obj.addProperty("priceBars", priceBars  + "");
			result = call.callPostMethod(fullUrl, obj.toString(), GetPriceBarResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}
	/**
	 * !This is an auto generated method!
	 *
	 * Get historic price ticks. Returns price ticks in ascending order up to the current time. The length of time between each tick will be different.
	 */
	@Override
	public GetPriceTickResponseDTO GetPriceTicks(String marketId,String priceTicks, JsonApi api) 
												throws ApiException {
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
		GetPriceTickResponseDTO result;
		if (transport.equals("GET")) {
			result = (GetPriceTickResponseDTO) api.callGetMethod(fullUrl, GetPriceTickResponseDTO.class);
		} else if (transport.equals("POST")) {
			JsonObject obj = new JsonObject();
			
			obj.addProperty("marketId", marketId  + "");
			obj.addProperty("priceTicks", priceTicks  + "");
			result = (GetPriceTickResponseDTO) api.callPostMethod(fullUrl, obj.toString(), GetPriceTickResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}
	
	/**
	 * !This is an auto generated method!
	 *
	 * Get historic price ticks. Returns price ticks in ascending order up to the current time. The length of time between each tick will be different.
	 */
	@Override
	public Future<Object> GetPriceTicksAsync(String marketId,String priceTicks, AsyncJsonApi api, CallBack... callBacks) throws ApiException {
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
		Future<Object> result;
		if (transport.equals("GET")) {
			result = call.callGetMethod(fullUrl, GetPriceTickResponseDTO.class);
		} else if (transport.equals("POST")) {
			JsonObject obj = new JsonObject();
			
			obj.addProperty("marketId", marketId  + "");
			obj.addProperty("priceTicks", priceTicks  + "");
			result = call.callPostMethod(fullUrl, obj.toString(), GetPriceTickResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}
	/**
	 * !This is an auto generated method!
	 *
	 * <p>Get Market Information for the specified market.</p>
	 */
	@Override
	public GetMarketInformationResponseDTO GetMarketInformation(String marketId, JsonApi api) 
												throws ApiException {
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
		GetMarketInformationResponseDTO result;
		if (transport.equals("GET")) {
			result = (GetMarketInformationResponseDTO) api.callGetMethod(fullUrl, GetMarketInformationResponseDTO.class);
		} else if (transport.equals("POST")) {
			JsonObject obj = new JsonObject();
			
			obj.addProperty("marketId", marketId  + "");
			result = (GetMarketInformationResponseDTO) api.callPostMethod(fullUrl, obj.toString(), GetMarketInformationResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}
	
	/**
	 * !This is an auto generated method!
	 *
	 * <p>Get Market Information for the specified market.</p>
	 */
	@Override
	public Future<Object> GetMarketInformationAsync(String marketId, AsyncJsonApi api, CallBack... callBacks) throws ApiException {
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
		Future<Object> result;
		if (transport.equals("GET")) {
			result = call.callGetMethod(fullUrl, GetMarketInformationResponseDTO.class);
		} else if (transport.equals("POST")) {
			JsonObject obj = new JsonObject();
			
			obj.addProperty("marketId", marketId  + "");
			result = call.callPostMethod(fullUrl, obj.toString(), GetMarketInformationResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}
	/**
	 * !This is an auto generated method!
	 *
	 * <p>Queries for market information.</p>
	 */
	@Override
	public ListMarketInformationSearchResponseDTO ListMarketInformationSearch(boolean searchByMarketCode,boolean searchByMarketName,boolean spreadProductType,boolean cfdProductType,boolean binaryProductType,String query,int maxResults, JsonApi api) 
												throws ApiException {
		// Collect variables from method
		String target = "market";
		String uriTemplate = "/market/informationsearch?SearchByMarketCode={searchByMarketCode}&SearchByMarketName={searchByMarketName}&SpreadProductType={spreadProductType}&CfdProductType={cfdProductType}&BinaryProductType={binaryProductType}&Query={query}&MaxResults={maxResults}";
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
		ListMarketInformationSearchResponseDTO result;
		if (transport.equals("GET")) {
			result = (ListMarketInformationSearchResponseDTO) api.callGetMethod(fullUrl, ListMarketInformationSearchResponseDTO.class);
		} else if (transport.equals("POST")) {
			JsonObject obj = new JsonObject();
			
			obj.addProperty("searchByMarketCode", searchByMarketCode  + "");
			obj.addProperty("searchByMarketName", searchByMarketName  + "");
			obj.addProperty("spreadProductType", spreadProductType  + "");
			obj.addProperty("cfdProductType", cfdProductType  + "");
			obj.addProperty("binaryProductType", binaryProductType  + "");
			obj.addProperty("query", query  + "");
			obj.addProperty("maxResults", maxResults  + "");
			result = (ListMarketInformationSearchResponseDTO) api.callPostMethod(fullUrl, obj.toString(), ListMarketInformationSearchResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}
	
	/**
	 * !This is an auto generated method!
	 *
	 * <p>Queries for market information.</p>
	 */
	@Override
	public Future<Object> ListMarketInformationSearchAsync(boolean searchByMarketCode,boolean searchByMarketName,boolean spreadProductType,boolean cfdProductType,boolean binaryProductType,String query,int maxResults, AsyncJsonApi api, CallBack... callBacks) throws ApiException {
		// Collect variables from method
		String target = "market";
		String uriTemplate = "/market/informationsearch?SearchByMarketCode={searchByMarketCode}&SearchByMarketName={searchByMarketName}&SpreadProductType={spreadProductType}&CfdProductType={cfdProductType}&BinaryProductType={binaryProductType}&Query={query}&MaxResults={maxResults}";
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
		Future<Object> result;
		if (transport.equals("GET")) {
			result = call.callGetMethod(fullUrl, ListMarketInformationSearchResponseDTO.class);
		} else if (transport.equals("POST")) {
			JsonObject obj = new JsonObject();
			
			obj.addProperty("searchByMarketCode", searchByMarketCode  + "");
			obj.addProperty("searchByMarketName", searchByMarketName  + "");
			obj.addProperty("spreadProductType", spreadProductType  + "");
			obj.addProperty("cfdProductType", cfdProductType  + "");
			obj.addProperty("binaryProductType", binaryProductType  + "");
			obj.addProperty("query", query  + "");
			obj.addProperty("maxResults", maxResults  + "");
			result = call.callPostMethod(fullUrl, obj.toString(), ListMarketInformationSearchResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}
	/**
	 * !This is an auto generated method!
	 *
	 * <p>Queries for market information.</p>
	 */
	@Override
	public ListMarketInformationResponseDTO ListMarketInformation(int[] MarketIds, JsonApi api) 
												throws ApiException {
		// Collect variables from method
		String target = "market";
		String uriTemplate = "/market/information";
		String transport = "POST";
		String envelope = "JSON";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL if it is GET.
		if (transport.equals("GET")) {
			// Concatenating the empty string is a hackey way of converting all params to a String 
			
			filledUri = filledUri.replace("{MarketIds}", MarketIds + "");
		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		ListMarketInformationResponseDTO result;
		if (transport.equals("GET")) {
			result = (ListMarketInformationResponseDTO) api.callGetMethod(fullUrl, ListMarketInformationResponseDTO.class);
		} else if (transport.equals("POST")) {
			JsonObject obj = new JsonObject();
			
			obj.addProperty("MarketIds", MarketIds  + "");
			result = (ListMarketInformationResponseDTO) api.callPostMethod(fullUrl, obj.toString(), ListMarketInformationResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}
	
	/**
	 * !This is an auto generated method!
	 *
	 * <p>Queries for market information.</p>
	 */
	@Override
	public Future<Object> ListMarketInformationAsync(int[] MarketIds, AsyncJsonApi api, CallBack... callBacks) throws ApiException {
		// Collect variables from method
		String target = "market";
		String uriTemplate = "/market/information";
		String transport = "POST";
		String envelope = "JSON";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL.
		if (transport.equals("GET")) {
			// Concatenating the empty string is a hackey way of converting all params to a String
			
			filledUri = filledUri.replace("{MarketIds}", MarketIds + "");
		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		AsyncApiCall call = api.createNewCall();
		for (CallBack cb : callBacks) {
			call.addCallCompleteListener(cb);
		}
		Future<Object> result;
		if (transport.equals("GET")) {
			result = call.callGetMethod(fullUrl, ListMarketInformationResponseDTO.class);
		} else if (transport.equals("POST")) {
			JsonObject obj = new JsonObject();
			
			obj.addProperty("MarketIds", MarketIds  + "");
			result = call.callPostMethod(fullUrl, obj.toString(), ListMarketInformationResponseDTO.class);
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
	public ListNewsHeadlinesResponseDTO ListNewsHeadlines(String category,int maxResults, JsonApi api) 
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
		ListNewsHeadlinesResponseDTO result;
		if (transport.equals("GET")) {
			result = (ListNewsHeadlinesResponseDTO) api.callGetMethod(fullUrl, ListNewsHeadlinesResponseDTO.class);
		} else if (transport.equals("POST")) {
			JsonObject obj = new JsonObject();
			
			obj.addProperty("category", category  + "");
			obj.addProperty("maxResults", maxResults  + "");
			result = (ListNewsHeadlinesResponseDTO) api.callPostMethod(fullUrl, obj.toString(), ListNewsHeadlinesResponseDTO.class);
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
	public Future<Object> ListNewsHeadlinesAsync(String category,int maxResults, AsyncJsonApi api, CallBack... callBacks) throws ApiException {
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
		Future<Object> result;
		if (transport.equals("GET")) {
			result = call.callGetMethod(fullUrl, ListNewsHeadlinesResponseDTO.class);
		} else if (transport.equals("POST")) {
			JsonObject obj = new JsonObject();
			
			obj.addProperty("category", category  + "");
			obj.addProperty("maxResults", maxResults  + "");
			result = call.callPostMethod(fullUrl, obj.toString(), ListNewsHeadlinesResponseDTO.class);
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
	public GetNewsDetailResponseDTO GetNewsDetail(String storyId, JsonApi api) 
												throws ApiException {
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
		GetNewsDetailResponseDTO result;
		if (transport.equals("GET")) {
			result = (GetNewsDetailResponseDTO) api.callGetMethod(fullUrl, GetNewsDetailResponseDTO.class);
		} else if (transport.equals("POST")) {
			JsonObject obj = new JsonObject();
			
			obj.addProperty("storyId", storyId  + "");
			result = (GetNewsDetailResponseDTO) api.callPostMethod(fullUrl, obj.toString(), GetNewsDetailResponseDTO.class);
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
	public Future<Object> GetNewsDetailAsync(String storyId, AsyncJsonApi api, CallBack... callBacks) throws ApiException {
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
		Future<Object> result;
		if (transport.equals("GET")) {
			result = call.callGetMethod(fullUrl, GetNewsDetailResponseDTO.class);
		} else if (transport.equals("POST")) {
			JsonObject obj = new JsonObject();
			
			obj.addProperty("storyId", storyId  + "");
			result = call.callPostMethod(fullUrl, obj.toString(), GetNewsDetailResponseDTO.class);
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
	public ListCfdMarketsResponseDTO ListCfdMarkets(String searchByMarketName,String searchByMarketCode,int clientAccountId,int maxResults, JsonApi api) 
												throws ApiException {
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
		ListCfdMarketsResponseDTO result;
		if (transport.equals("GET")) {
			result = (ListCfdMarketsResponseDTO) api.callGetMethod(fullUrl, ListCfdMarketsResponseDTO.class);
		} else if (transport.equals("POST")) {
			JsonObject obj = new JsonObject();
			
			obj.addProperty("searchByMarketName", searchByMarketName  + "");
			obj.addProperty("searchByMarketCode", searchByMarketCode  + "");
			obj.addProperty("clientAccountId", clientAccountId  + "");
			obj.addProperty("maxResults", maxResults  + "");
			result = (ListCfdMarketsResponseDTO) api.callPostMethod(fullUrl, obj.toString(), ListCfdMarketsResponseDTO.class);
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
	public Future<Object> ListCfdMarketsAsync(String searchByMarketName,String searchByMarketCode,int clientAccountId,int maxResults, AsyncJsonApi api, CallBack... callBacks) throws ApiException {
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
		Future<Object> result;
		if (transport.equals("GET")) {
			result = call.callGetMethod(fullUrl, ListCfdMarketsResponseDTO.class);
		} else if (transport.equals("POST")) {
			JsonObject obj = new JsonObject();
			
			obj.addProperty("searchByMarketName", searchByMarketName  + "");
			obj.addProperty("searchByMarketCode", searchByMarketCode  + "");
			obj.addProperty("clientAccountId", clientAccountId  + "");
			obj.addProperty("maxResults", maxResults  + "");
			result = call.callPostMethod(fullUrl, obj.toString(), ListCfdMarketsResponseDTO.class);
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
	public ListSpreadMarketsResponseDTO ListSpreadMarkets(String searchByMarketName,String searchByMarketCode,int clientAccountId,int maxResults, JsonApi api) 
												throws ApiException {
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
		ListSpreadMarketsResponseDTO result;
		if (transport.equals("GET")) {
			result = (ListSpreadMarketsResponseDTO) api.callGetMethod(fullUrl, ListSpreadMarketsResponseDTO.class);
		} else if (transport.equals("POST")) {
			JsonObject obj = new JsonObject();
			
			obj.addProperty("searchByMarketName", searchByMarketName  + "");
			obj.addProperty("searchByMarketCode", searchByMarketCode  + "");
			obj.addProperty("clientAccountId", clientAccountId  + "");
			obj.addProperty("maxResults", maxResults  + "");
			result = (ListSpreadMarketsResponseDTO) api.callPostMethod(fullUrl, obj.toString(), ListSpreadMarketsResponseDTO.class);
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
	public Future<Object> ListSpreadMarketsAsync(String searchByMarketName,String searchByMarketCode,int clientAccountId,int maxResults, AsyncJsonApi api, CallBack... callBacks) throws ApiException {
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
		Future<Object> result;
		if (transport.equals("GET")) {
			result = call.callGetMethod(fullUrl, ListSpreadMarketsResponseDTO.class);
		} else if (transport.equals("POST")) {
			JsonObject obj = new JsonObject();
			
			obj.addProperty("searchByMarketName", searchByMarketName  + "");
			obj.addProperty("searchByMarketCode", searchByMarketCode  + "");
			obj.addProperty("clientAccountId", clientAccountId  + "");
			obj.addProperty("maxResults", maxResults  + "");
			result = call.callPostMethod(fullUrl, obj.toString(), ListSpreadMarketsResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}
	/**
	 * !This is an auto generated method!
	 *
	 * <p>Place an order on a particular market. Post a <a onclick="dojo.hash('#type.NewStopLimitOrderRequestDTO'); return false;" class="json-link" href="#">NewStopLimitOrderRequestDTO</a> to the uri specified below.</p> <p>Do not set any order id fields when requesting a new order, the platform will generate them.</p>
	 */
	@Override
	public ApiTradeOrderResponseDTO Order(int OrderId,int MarketId,String Currency,boolean AutoRollover,String Direction,double Quantity,double BidPrice,double OfferPrice,String AuditId,int TradingAccountId,ApiIfDoneDTO[] IfDone,NewStopLimitOrderRequestDTO OcoOrder,String Applicability,String ExpiryDateTimeUTC,boolean Guaranteed,double TriggerPrice, JsonApi api) 
												throws ApiException {
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
			
			filledUri = filledUri.replace("{OrderId}", OrderId + "");
			filledUri = filledUri.replace("{MarketId}", MarketId + "");
			filledUri = filledUri.replace("{Currency}", Currency + "");
			filledUri = filledUri.replace("{AutoRollover}", AutoRollover + "");
			filledUri = filledUri.replace("{Direction}", Direction + "");
			filledUri = filledUri.replace("{Quantity}", Quantity + "");
			filledUri = filledUri.replace("{BidPrice}", BidPrice + "");
			filledUri = filledUri.replace("{OfferPrice}", OfferPrice + "");
			filledUri = filledUri.replace("{AuditId}", AuditId + "");
			filledUri = filledUri.replace("{TradingAccountId}", TradingAccountId + "");
			filledUri = filledUri.replace("{IfDone}", IfDone + "");
			filledUri = filledUri.replace("{OcoOrder}", OcoOrder + "");
			filledUri = filledUri.replace("{Applicability}", Applicability + "");
			filledUri = filledUri.replace("{ExpiryDateTimeUTC}", ExpiryDateTimeUTC + "");
			filledUri = filledUri.replace("{Guaranteed}", Guaranteed + "");
			filledUri = filledUri.replace("{TriggerPrice}", TriggerPrice + "");
		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		ApiTradeOrderResponseDTO result;
		if (transport.equals("GET")) {
			result = (ApiTradeOrderResponseDTO) api.callGetMethod(fullUrl, ApiTradeOrderResponseDTO.class);
		} else if (transport.equals("POST")) {
			JsonObject obj = new JsonObject();
			
			obj.addProperty("OrderId", OrderId  + "");
			obj.addProperty("MarketId", MarketId  + "");
			obj.addProperty("Currency", Currency  + "");
			obj.addProperty("AutoRollover", AutoRollover  + "");
			obj.addProperty("Direction", Direction  + "");
			obj.addProperty("Quantity", Quantity  + "");
			obj.addProperty("BidPrice", BidPrice  + "");
			obj.addProperty("OfferPrice", OfferPrice  + "");
			obj.addProperty("AuditId", AuditId  + "");
			obj.addProperty("TradingAccountId", TradingAccountId  + "");
			obj.addProperty("IfDone", IfDone  + "");
			obj.addProperty("OcoOrder", OcoOrder  + "");
			obj.addProperty("Applicability", Applicability  + "");
			obj.addProperty("ExpiryDateTimeUTC", ExpiryDateTimeUTC  + "");
			obj.addProperty("Guaranteed", Guaranteed  + "");
			obj.addProperty("TriggerPrice", TriggerPrice  + "");
			result = (ApiTradeOrderResponseDTO) api.callPostMethod(fullUrl, obj.toString(), ApiTradeOrderResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}
	
	/**
	 * !This is an auto generated method!
	 *
	 * <p>Place an order on a particular market. Post a <a onclick="dojo.hash('#type.NewStopLimitOrderRequestDTO'); return false;" class="json-link" href="#">NewStopLimitOrderRequestDTO</a> to the uri specified below.</p> <p>Do not set any order id fields when requesting a new order, the platform will generate them.</p>
	 */
	@Override
	public Future<Object> OrderAsync(int OrderId,int MarketId,String Currency,boolean AutoRollover,String Direction,double Quantity,double BidPrice,double OfferPrice,String AuditId,int TradingAccountId,ApiIfDoneDTO[] IfDone,NewStopLimitOrderRequestDTO OcoOrder,String Applicability,String ExpiryDateTimeUTC,boolean Guaranteed,double TriggerPrice, AsyncJsonApi api, CallBack... callBacks) throws ApiException {
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
			
			filledUri = filledUri.replace("{OrderId}", OrderId + "");
			filledUri = filledUri.replace("{MarketId}", MarketId + "");
			filledUri = filledUri.replace("{Currency}", Currency + "");
			filledUri = filledUri.replace("{AutoRollover}", AutoRollover + "");
			filledUri = filledUri.replace("{Direction}", Direction + "");
			filledUri = filledUri.replace("{Quantity}", Quantity + "");
			filledUri = filledUri.replace("{BidPrice}", BidPrice + "");
			filledUri = filledUri.replace("{OfferPrice}", OfferPrice + "");
			filledUri = filledUri.replace("{AuditId}", AuditId + "");
			filledUri = filledUri.replace("{TradingAccountId}", TradingAccountId + "");
			filledUri = filledUri.replace("{IfDone}", IfDone + "");
			filledUri = filledUri.replace("{OcoOrder}", OcoOrder + "");
			filledUri = filledUri.replace("{Applicability}", Applicability + "");
			filledUri = filledUri.replace("{ExpiryDateTimeUTC}", ExpiryDateTimeUTC + "");
			filledUri = filledUri.replace("{Guaranteed}", Guaranteed + "");
			filledUri = filledUri.replace("{TriggerPrice}", TriggerPrice + "");
		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		AsyncApiCall call = api.createNewCall();
		for (CallBack cb : callBacks) {
			call.addCallCompleteListener(cb);
		}
		Future<Object> result;
		if (transport.equals("GET")) {
			result = call.callGetMethod(fullUrl, ApiTradeOrderResponseDTO.class);
		} else if (transport.equals("POST")) {
			JsonObject obj = new JsonObject();
			
			obj.addProperty("OrderId", OrderId  + "");
			obj.addProperty("MarketId", MarketId  + "");
			obj.addProperty("Currency", Currency  + "");
			obj.addProperty("AutoRollover", AutoRollover  + "");
			obj.addProperty("Direction", Direction  + "");
			obj.addProperty("Quantity", Quantity  + "");
			obj.addProperty("BidPrice", BidPrice  + "");
			obj.addProperty("OfferPrice", OfferPrice  + "");
			obj.addProperty("AuditId", AuditId  + "");
			obj.addProperty("TradingAccountId", TradingAccountId  + "");
			obj.addProperty("IfDone", IfDone  + "");
			obj.addProperty("OcoOrder", OcoOrder  + "");
			obj.addProperty("Applicability", Applicability  + "");
			obj.addProperty("ExpiryDateTimeUTC", ExpiryDateTimeUTC  + "");
			obj.addProperty("Guaranteed", Guaranteed  + "");
			obj.addProperty("TriggerPrice", TriggerPrice  + "");
			result = call.callPostMethod(fullUrl, obj.toString(), ApiTradeOrderResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}
	/**
	 * !This is an auto generated method!
	 *
	 * <p>Cancel an order. Post a <a onclick="dojo.hash('#type.CancelOrderRequestDTO'); return false;" class="json-link" href="#">CancelOrderRequestDTO</a> to the uri specified below</p>
	 */
	@Override
	public ApiTradeOrderResponseDTO CancelOrder(int OrderId,int TradingAccountId, JsonApi api) 
												throws ApiException {
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
			
			filledUri = filledUri.replace("{OrderId}", OrderId + "");
			filledUri = filledUri.replace("{TradingAccountId}", TradingAccountId + "");
		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		ApiTradeOrderResponseDTO result;
		if (transport.equals("GET")) {
			result = (ApiTradeOrderResponseDTO) api.callGetMethod(fullUrl, ApiTradeOrderResponseDTO.class);
		} else if (transport.equals("POST")) {
			JsonObject obj = new JsonObject();
			
			obj.addProperty("OrderId", OrderId  + "");
			obj.addProperty("TradingAccountId", TradingAccountId  + "");
			result = (ApiTradeOrderResponseDTO) api.callPostMethod(fullUrl, obj.toString(), ApiTradeOrderResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}
	
	/**
	 * !This is an auto generated method!
	 *
	 * <p>Cancel an order. Post a <a onclick="dojo.hash('#type.CancelOrderRequestDTO'); return false;" class="json-link" href="#">CancelOrderRequestDTO</a> to the uri specified below</p>
	 */
	@Override
	public Future<Object> CancelOrderAsync(int OrderId,int TradingAccountId, AsyncJsonApi api, CallBack... callBacks) throws ApiException {
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
			
			filledUri = filledUri.replace("{OrderId}", OrderId + "");
			filledUri = filledUri.replace("{TradingAccountId}", TradingAccountId + "");
		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		AsyncApiCall call = api.createNewCall();
		for (CallBack cb : callBacks) {
			call.addCallCompleteListener(cb);
		}
		Future<Object> result;
		if (transport.equals("GET")) {
			result = call.callGetMethod(fullUrl, ApiTradeOrderResponseDTO.class);
		} else if (transport.equals("POST")) {
			JsonObject obj = new JsonObject();
			
			obj.addProperty("OrderId", OrderId  + "");
			obj.addProperty("TradingAccountId", TradingAccountId  + "");
			result = call.callPostMethod(fullUrl, obj.toString(), ApiTradeOrderResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}
	/**
	 * !This is an auto generated method!
	 *
	 * <p>Update an order (for adding a stop/limit or attaching an OCO relationship). Post an <a onclick="dojo.hash('#type.UpdateStopLimitOrderRequestDTO'); return false;" class="json-link" href="#">UpdateStopLimitOrderRequestDTO</a> to the uri specified below</p>
	 */
	@Override
	public ApiTradeOrderResponseDTO UpdateOrder( JsonApi api) 
												throws ApiException {
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
			
		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		ApiTradeOrderResponseDTO result;
		if (transport.equals("GET")) {
			result = (ApiTradeOrderResponseDTO) api.callGetMethod(fullUrl, ApiTradeOrderResponseDTO.class);
		} else if (transport.equals("POST")) {
			JsonObject obj = new JsonObject();
			
			result = (ApiTradeOrderResponseDTO) api.callPostMethod(fullUrl, obj.toString(), ApiTradeOrderResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}
	
	/**
	 * !This is an auto generated method!
	 *
	 * <p>Update an order (for adding a stop/limit or attaching an OCO relationship). Post an <a onclick="dojo.hash('#type.UpdateStopLimitOrderRequestDTO'); return false;" class="json-link" href="#">UpdateStopLimitOrderRequestDTO</a> to the uri specified below</p>
	 */
	@Override
	public Future<Object> UpdateOrderAsync( AsyncJsonApi api, CallBack... callBacks) throws ApiException {
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
			
		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		AsyncApiCall call = api.createNewCall();
		for (CallBack cb : callBacks) {
			call.addCallCompleteListener(cb);
		}
		Future<Object> result;
		if (transport.equals("GET")) {
			result = call.callGetMethod(fullUrl, ApiTradeOrderResponseDTO.class);
		} else if (transport.equals("POST")) {
			JsonObject obj = new JsonObject();
			
			result = call.callPostMethod(fullUrl, obj.toString(), ApiTradeOrderResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}
	/**
	 * !This is an auto generated method!
	 *
	 * <p>Queries for a specified trading account's trades / open positions.</p> <p>This uri is intended to be used to support a grid in a UI. One usage pattern is to subscribe to streaming orders, call this for the initial data to display in the grid, and call <a onclick="dojo.hash('#service.GetOpenPosition'); return false;" class="json-link" href="#">GetOpenPosition</a> when you get updates on the order stream to get the updated data in this format.</p>
	 */
	@Override
	public ListOpenPositionsResponseDTO ListOpenPositions(int tradingAccountId, JsonApi api) 
												throws ApiException {
		// Collect variables from method
		String target = "order";
		String uriTemplate = "/order/openpositions?TradingAccountId={tradingAccountId}";
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
		ListOpenPositionsResponseDTO result;
		if (transport.equals("GET")) {
			result = (ListOpenPositionsResponseDTO) api.callGetMethod(fullUrl, ListOpenPositionsResponseDTO.class);
		} else if (transport.equals("POST")) {
			JsonObject obj = new JsonObject();
			
			obj.addProperty("tradingAccountId", tradingAccountId  + "");
			result = (ListOpenPositionsResponseDTO) api.callPostMethod(fullUrl, obj.toString(), ListOpenPositionsResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}
	
	/**
	 * !This is an auto generated method!
	 *
	 * <p>Queries for a specified trading account's trades / open positions.</p> <p>This uri is intended to be used to support a grid in a UI. One usage pattern is to subscribe to streaming orders, call this for the initial data to display in the grid, and call <a onclick="dojo.hash('#service.GetOpenPosition'); return false;" class="json-link" href="#">GetOpenPosition</a> when you get updates on the order stream to get the updated data in this format.</p>
	 */
	@Override
	public Future<Object> ListOpenPositionsAsync(int tradingAccountId, AsyncJsonApi api, CallBack... callBacks) throws ApiException {
		// Collect variables from method
		String target = "order";
		String uriTemplate = "/order/openpositions?TradingAccountId={tradingAccountId}";
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
		Future<Object> result;
		if (transport.equals("GET")) {
			result = call.callGetMethod(fullUrl, ListOpenPositionsResponseDTO.class);
		} else if (transport.equals("POST")) {
			JsonObject obj = new JsonObject();
			
			obj.addProperty("tradingAccountId", tradingAccountId  + "");
			result = call.callPostMethod(fullUrl, obj.toString(), ListOpenPositionsResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}
	/**
	 * !This is an auto generated method!
	 *
	 * <p>Queries for a specified trading account's active stop / limit orders.</p> <p>This uri is intended to be used to support a grid in a UI. One usage pattern is to subscribe to streaming orders, call this for the initial data to display in the grid, and call <a onclick="dojo.hash('#service.GetActiveStopLimitOrder'); return false;" class="json-link" href="#">GetActiveStopLimitOrder</a> when you get updates on the order stream to get the updated data in this format.</p>
	 */
	@Override
	public ListActiveStopLimitOrderResponseDTO ListActiveStopLimitOrders(int tradingAccountId, JsonApi api) 
												throws ApiException {
		// Collect variables from method
		String target = "order";
		String uriTemplate = "/order/activestoplimitorders?TradingAccountId={tradingAccountId}";
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
		ListActiveStopLimitOrderResponseDTO result;
		if (transport.equals("GET")) {
			result = (ListActiveStopLimitOrderResponseDTO) api.callGetMethod(fullUrl, ListActiveStopLimitOrderResponseDTO.class);
		} else if (transport.equals("POST")) {
			JsonObject obj = new JsonObject();
			
			obj.addProperty("tradingAccountId", tradingAccountId  + "");
			result = (ListActiveStopLimitOrderResponseDTO) api.callPostMethod(fullUrl, obj.toString(), ListActiveStopLimitOrderResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}
	
	/**
	 * !This is an auto generated method!
	 *
	 * <p>Queries for a specified trading account's active stop / limit orders.</p> <p>This uri is intended to be used to support a grid in a UI. One usage pattern is to subscribe to streaming orders, call this for the initial data to display in the grid, and call <a onclick="dojo.hash('#service.GetActiveStopLimitOrder'); return false;" class="json-link" href="#">GetActiveStopLimitOrder</a> when you get updates on the order stream to get the updated data in this format.</p>
	 */
	@Override
	public Future<Object> ListActiveStopLimitOrdersAsync(int tradingAccountId, AsyncJsonApi api, CallBack... callBacks) throws ApiException {
		// Collect variables from method
		String target = "order";
		String uriTemplate = "/order/activestoplimitorders?TradingAccountId={tradingAccountId}";
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
		Future<Object> result;
		if (transport.equals("GET")) {
			result = call.callGetMethod(fullUrl, ListActiveStopLimitOrderResponseDTO.class);
		} else if (transport.equals("POST")) {
			JsonObject obj = new JsonObject();
			
			obj.addProperty("tradingAccountId", tradingAccountId  + "");
			result = call.callPostMethod(fullUrl, obj.toString(), ListActiveStopLimitOrderResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}
	/**
	 * !This is an auto generated method!
	 *
	 * <p>Queries for a active stop limit order with a specified order id. It will return a null value if the order doesn't exist, or is not an active stop limit order.<p> <p>This uri is intended to be used to support a grid in a UI. One usage pattern is to subscribe to streaming orders, call <a onclick="dojo.hash('#service.ListActiveStopLimitOrders'); return false;" class="json-link" href="#">ListActiveStopLimitOrders</a> for the initial data to display in the grid, and call this uri when you get updates on the order stream to get the updated data in this format.</p> <p>For a more comprehensive order response, see <a onclick="dojo.hash('#service.GetOrder'); return false;" class="json-link" href="#">GetOrder</a><p>
	 */
	@Override
	public GetActiveStopLimitOrderResponseDTO GetActiveStopLimitOrder(String orderId, JsonApi api) 
												throws ApiException {
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
		GetActiveStopLimitOrderResponseDTO result;
		if (transport.equals("GET")) {
			result = (GetActiveStopLimitOrderResponseDTO) api.callGetMethod(fullUrl, GetActiveStopLimitOrderResponseDTO.class);
		} else if (transport.equals("POST")) {
			JsonObject obj = new JsonObject();
			
			obj.addProperty("orderId", orderId  + "");
			result = (GetActiveStopLimitOrderResponseDTO) api.callPostMethod(fullUrl, obj.toString(), GetActiveStopLimitOrderResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}
	
	/**
	 * !This is an auto generated method!
	 *
	 * <p>Queries for a active stop limit order with a specified order id. It will return a null value if the order doesn't exist, or is not an active stop limit order.<p> <p>This uri is intended to be used to support a grid in a UI. One usage pattern is to subscribe to streaming orders, call <a onclick="dojo.hash('#service.ListActiveStopLimitOrders'); return false;" class="json-link" href="#">ListActiveStopLimitOrders</a> for the initial data to display in the grid, and call this uri when you get updates on the order stream to get the updated data in this format.</p> <p>For a more comprehensive order response, see <a onclick="dojo.hash('#service.GetOrder'); return false;" class="json-link" href="#">GetOrder</a><p>
	 */
	@Override
	public Future<Object> GetActiveStopLimitOrderAsync(String orderId, AsyncJsonApi api, CallBack... callBacks) throws ApiException {
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
		Future<Object> result;
		if (transport.equals("GET")) {
			result = call.callGetMethod(fullUrl, GetActiveStopLimitOrderResponseDTO.class);
		} else if (transport.equals("POST")) {
			JsonObject obj = new JsonObject();
			
			obj.addProperty("orderId", orderId  + "");
			result = call.callPostMethod(fullUrl, obj.toString(), GetActiveStopLimitOrderResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}
	/**
	 * !This is an auto generated method!
	 *
	 * <p>Queries for a trade / open position with a specified order id. It will return a null value if the order doesn't exist, or is not a trade / open position.</p> <p>This uri is intended to be used to support a grid in a UI. One usage pattern is to subscribe to streaming orders, call <a onclick="dojo.hash('#service.ListOpenPositions'); return false;" class="json-link" href="#">ListOpenPositions</a> for the initial data to display in the grid, and call this uri when you get updates on the order stream to get the updated data in this format.</p> <p>For a more comprehensive order response, see <a onclick="dojo.hash('#service.GetOrder'); return false;" class="json-link" href="#">GetOrder</a><p>
	 */
	@Override
	public GetOpenPositionResponseDTO GetOpenPosition(String orderId, JsonApi api) 
												throws ApiException {
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
		GetOpenPositionResponseDTO result;
		if (transport.equals("GET")) {
			result = (GetOpenPositionResponseDTO) api.callGetMethod(fullUrl, GetOpenPositionResponseDTO.class);
		} else if (transport.equals("POST")) {
			JsonObject obj = new JsonObject();
			
			obj.addProperty("orderId", orderId  + "");
			result = (GetOpenPositionResponseDTO) api.callPostMethod(fullUrl, obj.toString(), GetOpenPositionResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}
	
	/**
	 * !This is an auto generated method!
	 *
	 * <p>Queries for a trade / open position with a specified order id. It will return a null value if the order doesn't exist, or is not a trade / open position.</p> <p>This uri is intended to be used to support a grid in a UI. One usage pattern is to subscribe to streaming orders, call <a onclick="dojo.hash('#service.ListOpenPositions'); return false;" class="json-link" href="#">ListOpenPositions</a> for the initial data to display in the grid, and call this uri when you get updates on the order stream to get the updated data in this format.</p> <p>For a more comprehensive order response, see <a onclick="dojo.hash('#service.GetOrder'); return false;" class="json-link" href="#">GetOrder</a><p>
	 */
	@Override
	public Future<Object> GetOpenPositionAsync(String orderId, AsyncJsonApi api, CallBack... callBacks) throws ApiException {
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
		Future<Object> result;
		if (transport.equals("GET")) {
			result = call.callGetMethod(fullUrl, GetOpenPositionResponseDTO.class);
		} else if (transport.equals("POST")) {
			JsonObject obj = new JsonObject();
			
			obj.addProperty("orderId", orderId  + "");
			result = call.callPostMethod(fullUrl, obj.toString(), GetOpenPositionResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}
	/**
	 * !This is an auto generated method!
	 *
	 * <p>Queries for a specified trading account's trade history. The result set will contain orders with a status of <b>(3 - Open, 9 - Closed)</b>, and includes <b>orders that were a trade / stop / limit order</b>.</p> <p>There's currently no corresponding GetTradeHistory (as with ListOpenPositions).</p>
	 */
	@Override
	public ListTradeHistoryResponseDTO ListTradeHistory(int tradingAccountId,int maxResults, JsonApi api) 
												throws ApiException {
		// Collect variables from method
		String target = "order";
		String uriTemplate = "/order/tradehistory?TradingAccountId={tradingAccountId}&MaxResults={maxResults}";
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
		ListTradeHistoryResponseDTO result;
		if (transport.equals("GET")) {
			result = (ListTradeHistoryResponseDTO) api.callGetMethod(fullUrl, ListTradeHistoryResponseDTO.class);
		} else if (transport.equals("POST")) {
			JsonObject obj = new JsonObject();
			
			obj.addProperty("tradingAccountId", tradingAccountId  + "");
			obj.addProperty("maxResults", maxResults  + "");
			result = (ListTradeHistoryResponseDTO) api.callPostMethod(fullUrl, obj.toString(), ListTradeHistoryResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}
	
	/**
	 * !This is an auto generated method!
	 *
	 * <p>Queries for a specified trading account's trade history. The result set will contain orders with a status of <b>(3 - Open, 9 - Closed)</b>, and includes <b>orders that were a trade / stop / limit order</b>.</p> <p>There's currently no corresponding GetTradeHistory (as with ListOpenPositions).</p>
	 */
	@Override
	public Future<Object> ListTradeHistoryAsync(int tradingAccountId,int maxResults, AsyncJsonApi api, CallBack... callBacks) throws ApiException {
		// Collect variables from method
		String target = "order";
		String uriTemplate = "/order/tradehistory?TradingAccountId={tradingAccountId}&MaxResults={maxResults}";
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
		Future<Object> result;
		if (transport.equals("GET")) {
			result = call.callGetMethod(fullUrl, ListTradeHistoryResponseDTO.class);
		} else if (transport.equals("POST")) {
			JsonObject obj = new JsonObject();
			
			obj.addProperty("tradingAccountId", tradingAccountId  + "");
			obj.addProperty("maxResults", maxResults  + "");
			result = call.callPostMethod(fullUrl, obj.toString(), ListTradeHistoryResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}
	/**
	 * !This is an auto generated method!
	 *
	 * <p>Queries for a specified trading account's stop / limit order history. The result set will include <b>only orders that were originally stop / limit orders</b> that currently have one of the following statuses <b>(3 - Open, 4 - Cancelled, 5 - Rejected, 9 - Closed, 10 - Red Card)</b> </p> <p>There's currently no corresponding GetStopLimitOrderHistory (as with ListActiveStopLimitOrders).</p>
	 */
	@Override
	public ListStopLimitOrderHistoryResponseDTO ListStopLimitOrderHistory(int tradingAccountId,int maxResults, JsonApi api) 
												throws ApiException {
		// Collect variables from method
		String target = "order";
		String uriTemplate = "/order/stoplimitorderhistory?TradingAccountId={tradingAccountId}&MaxResults={maxResults}";
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
		ListStopLimitOrderHistoryResponseDTO result;
		if (transport.equals("GET")) {
			result = (ListStopLimitOrderHistoryResponseDTO) api.callGetMethod(fullUrl, ListStopLimitOrderHistoryResponseDTO.class);
		} else if (transport.equals("POST")) {
			JsonObject obj = new JsonObject();
			
			obj.addProperty("tradingAccountId", tradingAccountId  + "");
			obj.addProperty("maxResults", maxResults  + "");
			result = (ListStopLimitOrderHistoryResponseDTO) api.callPostMethod(fullUrl, obj.toString(), ListStopLimitOrderHistoryResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}
	
	/**
	 * !This is an auto generated method!
	 *
	 * <p>Queries for a specified trading account's stop / limit order history. The result set will include <b>only orders that were originally stop / limit orders</b> that currently have one of the following statuses <b>(3 - Open, 4 - Cancelled, 5 - Rejected, 9 - Closed, 10 - Red Card)</b> </p> <p>There's currently no corresponding GetStopLimitOrderHistory (as with ListActiveStopLimitOrders).</p>
	 */
	@Override
	public Future<Object> ListStopLimitOrderHistoryAsync(int tradingAccountId,int maxResults, AsyncJsonApi api, CallBack... callBacks) throws ApiException {
		// Collect variables from method
		String target = "order";
		String uriTemplate = "/order/stoplimitorderhistory?TradingAccountId={tradingAccountId}&MaxResults={maxResults}";
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
		Future<Object> result;
		if (transport.equals("GET")) {
			result = call.callGetMethod(fullUrl, ListStopLimitOrderHistoryResponseDTO.class);
		} else if (transport.equals("POST")) {
			JsonObject obj = new JsonObject();
			
			obj.addProperty("tradingAccountId", tradingAccountId  + "");
			obj.addProperty("maxResults", maxResults  + "");
			result = call.callPostMethod(fullUrl, obj.toString(), ListStopLimitOrderHistoryResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}
	/**
	 * !This is an auto generated method!
	 *
	 * <p>Queries for an order by a specific order id.</p> <p>The current implementation only returns active orders (i.e. those with a status of <b>1 - Pending, 2 - Accepted, 3 - Open, 6 - Suspended, 8 - Yellow Card, 11 - Triggered)</b>.</p>
	 */
	@Override
	public GetOrderResponseDTO GetOrder(String orderId, JsonApi api) 
												throws ApiException {
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
		GetOrderResponseDTO result;
		if (transport.equals("GET")) {
			result = (GetOrderResponseDTO) api.callGetMethod(fullUrl, GetOrderResponseDTO.class);
		} else if (transport.equals("POST")) {
			JsonObject obj = new JsonObject();
			
			obj.addProperty("orderId", orderId  + "");
			result = (GetOrderResponseDTO) api.callPostMethod(fullUrl, obj.toString(), GetOrderResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}
	
	/**
	 * !This is an auto generated method!
	 *
	 * <p>Queries for an order by a specific order id.</p> <p>The current implementation only returns active orders (i.e. those with a status of <b>1 - Pending, 2 - Accepted, 3 - Open, 6 - Suspended, 8 - Yellow Card, 11 - Triggered)</b>.</p>
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
		Future<Object> result;
		if (transport.equals("GET")) {
			result = call.callGetMethod(fullUrl, GetOrderResponseDTO.class);
		} else if (transport.equals("POST")) {
			JsonObject obj = new JsonObject();
			
			obj.addProperty("orderId", orderId  + "");
			result = call.callPostMethod(fullUrl, obj.toString(), GetOrderResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}
	/**
	 * !This is an auto generated method!
	 *
	 * <p>Place a trade on a particular market. Post a <a onclick="dojo.hash('#type.NewTradeOrderRequestDTO'); return false;" class="json-link" href="#">NewTradeOrderRequestDTO</a> to the uri specified below.</p> <p>Do not set any order id fields when requesting a new trade, the platform will generate them.</p>
	 */
	@Override
	public ApiTradeOrderResponseDTO Trade(int MarketId,String Currency,boolean AutoRollover,String Direction,double Quantity,String QuoteId,double BidPrice,double OfferPrice,String AuditId,int TradingAccountId,ApiIfDoneDTO[] IfDone,int[] Close, JsonApi api) 
												throws ApiException {
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
			
			filledUri = filledUri.replace("{MarketId}", MarketId + "");
			filledUri = filledUri.replace("{Currency}", Currency + "");
			filledUri = filledUri.replace("{AutoRollover}", AutoRollover + "");
			filledUri = filledUri.replace("{Direction}", Direction + "");
			filledUri = filledUri.replace("{Quantity}", Quantity + "");
			filledUri = filledUri.replace("{QuoteId}", QuoteId + "");
			filledUri = filledUri.replace("{BidPrice}", BidPrice + "");
			filledUri = filledUri.replace("{OfferPrice}", OfferPrice + "");
			filledUri = filledUri.replace("{AuditId}", AuditId + "");
			filledUri = filledUri.replace("{TradingAccountId}", TradingAccountId + "");
			filledUri = filledUri.replace("{IfDone}", IfDone + "");
			filledUri = filledUri.replace("{Close}", Close + "");
		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		ApiTradeOrderResponseDTO result;
		if (transport.equals("GET")) {
			result = (ApiTradeOrderResponseDTO) api.callGetMethod(fullUrl, ApiTradeOrderResponseDTO.class);
		} else if (transport.equals("POST")) {
			JsonObject obj = new JsonObject();
			
			obj.addProperty("MarketId", MarketId  + "");
			obj.addProperty("Currency", Currency  + "");
			obj.addProperty("AutoRollover", AutoRollover  + "");
			obj.addProperty("Direction", Direction  + "");
			obj.addProperty("Quantity", Quantity  + "");
			obj.addProperty("QuoteId", QuoteId  + "");
			obj.addProperty("BidPrice", BidPrice  + "");
			obj.addProperty("OfferPrice", OfferPrice  + "");
			obj.addProperty("AuditId", AuditId  + "");
			obj.addProperty("TradingAccountId", TradingAccountId  + "");
			obj.addProperty("IfDone", IfDone  + "");
			obj.addProperty("Close", Close  + "");
			result = (ApiTradeOrderResponseDTO) api.callPostMethod(fullUrl, obj.toString(), ApiTradeOrderResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}
	
	/**
	 * !This is an auto generated method!
	 *
	 * <p>Place a trade on a particular market. Post a <a onclick="dojo.hash('#type.NewTradeOrderRequestDTO'); return false;" class="json-link" href="#">NewTradeOrderRequestDTO</a> to the uri specified below.</p> <p>Do not set any order id fields when requesting a new trade, the platform will generate them.</p>
	 */
	@Override
	public Future<Object> TradeAsync(int MarketId,String Currency,boolean AutoRollover,String Direction,double Quantity,String QuoteId,double BidPrice,double OfferPrice,String AuditId,int TradingAccountId,ApiIfDoneDTO[] IfDone,int[] Close, AsyncJsonApi api, CallBack... callBacks) throws ApiException {
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
			
			filledUri = filledUri.replace("{MarketId}", MarketId + "");
			filledUri = filledUri.replace("{Currency}", Currency + "");
			filledUri = filledUri.replace("{AutoRollover}", AutoRollover + "");
			filledUri = filledUri.replace("{Direction}", Direction + "");
			filledUri = filledUri.replace("{Quantity}", Quantity + "");
			filledUri = filledUri.replace("{QuoteId}", QuoteId + "");
			filledUri = filledUri.replace("{BidPrice}", BidPrice + "");
			filledUri = filledUri.replace("{OfferPrice}", OfferPrice + "");
			filledUri = filledUri.replace("{AuditId}", AuditId + "");
			filledUri = filledUri.replace("{TradingAccountId}", TradingAccountId + "");
			filledUri = filledUri.replace("{IfDone}", IfDone + "");
			filledUri = filledUri.replace("{Close}", Close + "");
		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		AsyncApiCall call = api.createNewCall();
		for (CallBack cb : callBacks) {
			call.addCallCompleteListener(cb);
		}
		Future<Object> result;
		if (transport.equals("GET")) {
			result = call.callGetMethod(fullUrl, ApiTradeOrderResponseDTO.class);
		} else if (transport.equals("POST")) {
			JsonObject obj = new JsonObject();
			
			obj.addProperty("MarketId", MarketId  + "");
			obj.addProperty("Currency", Currency  + "");
			obj.addProperty("AutoRollover", AutoRollover  + "");
			obj.addProperty("Direction", Direction  + "");
			obj.addProperty("Quantity", Quantity  + "");
			obj.addProperty("QuoteId", QuoteId  + "");
			obj.addProperty("BidPrice", BidPrice  + "");
			obj.addProperty("OfferPrice", OfferPrice  + "");
			obj.addProperty("AuditId", AuditId  + "");
			obj.addProperty("TradingAccountId", TradingAccountId  + "");
			obj.addProperty("IfDone", IfDone  + "");
			obj.addProperty("Close", Close  + "");
			result = call.callPostMethod(fullUrl, obj.toString(), ApiTradeOrderResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}
	/**
	 * !This is an auto generated method!
	 *
	 * Update a trade (for adding a stop/limit etc). Post an <a onclick="dojo.hash('#type.UpdateTradeOrderRequestDTO'); return false;" class="json-link" href="#">UpdateTradeOrderRequestDTO</a> to the uri specified below</p>
	 */
	@Override
	public ApiTradeOrderResponseDTO UpdateTrade(int OrderId, JsonApi api) 
												throws ApiException {
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
			
			filledUri = filledUri.replace("{OrderId}", OrderId + "");
		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		ApiTradeOrderResponseDTO result;
		if (transport.equals("GET")) {
			result = (ApiTradeOrderResponseDTO) api.callGetMethod(fullUrl, ApiTradeOrderResponseDTO.class);
		} else if (transport.equals("POST")) {
			JsonObject obj = new JsonObject();
			
			obj.addProperty("OrderId", OrderId  + "");
			result = (ApiTradeOrderResponseDTO) api.callPostMethod(fullUrl, obj.toString(), ApiTradeOrderResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}
	
	/**
	 * !This is an auto generated method!
	 *
	 * Update a trade (for adding a stop/limit etc). Post an <a onclick="dojo.hash('#type.UpdateTradeOrderRequestDTO'); return false;" class="json-link" href="#">UpdateTradeOrderRequestDTO</a> to the uri specified below</p>
	 */
	@Override
	public Future<Object> UpdateTradeAsync(int OrderId, AsyncJsonApi api, CallBack... callBacks) throws ApiException {
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
			
			filledUri = filledUri.replace("{OrderId}", OrderId + "");
		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		AsyncApiCall call = api.createNewCall();
		for (CallBack cb : callBacks) {
			call.addCallCompleteListener(cb);
		}
		Future<Object> result;
		if (transport.equals("GET")) {
			result = call.callGetMethod(fullUrl, ApiTradeOrderResponseDTO.class);
		} else if (transport.equals("POST")) {
			JsonObject obj = new JsonObject();
			
			obj.addProperty("OrderId", OrderId  + "");
			result = call.callPostMethod(fullUrl, obj.toString(), ApiTradeOrderResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}
	/**
	 * !This is an auto generated method!
	 *
	 * Whether a User is allowed to see Charting Data.
	 */
	@Override
	public Boolean GetChartingEnabled(String id, JsonApi api) 
												throws ApiException {
		// Collect variables from method
		String target = "useraccount";
		String uriTemplate = "/UserAccount/{id}/ChartingEnabled";
		String transport = "GET";
		String envelope = "URL";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL if it is GET.
		if (transport.equals("GET")) {
			// Concatenating the empty string is a hackey way of converting all params to a String 
			
			filledUri = filledUri.replace("{id}", id + "");
		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		Boolean result;
		if (transport.equals("GET")) {
			result = (Boolean) api.callGetMethod(fullUrl, Boolean.class);
		} else if (transport.equals("POST")) {
			JsonObject obj = new JsonObject();
			
			obj.addProperty("id", id  + "");
			result = (Boolean) api.callPostMethod(fullUrl, obj.toString(), Boolean.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}
	
	/**
	 * !This is an auto generated method!
	 *
	 * Whether a User is allowed to see Charting Data.
	 */
	@Override
	public Future<Object> GetChartingEnabledAsync(String id, AsyncJsonApi api, CallBack... callBacks) throws ApiException {
		// Collect variables from method
		String target = "useraccount";
		String uriTemplate = "/UserAccount/{id}/ChartingEnabled";
		String transport = "GET";
		String envelope = "URL";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL.
		if (transport.equals("GET")) {
			// Concatenating the empty string is a hackey way of converting all params to a String
			
			filledUri = filledUri.replace("{id}", id + "");
		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		AsyncApiCall call = api.createNewCall();
		for (CallBack cb : callBacks) {
			call.addCallCompleteListener(cb);
		}
		Future<Object> result;
		if (transport.equals("GET")) {
			result = call.callGetMethod(fullUrl, Boolean.class);
		} else if (transport.equals("POST")) {
			JsonObject obj = new JsonObject();
			
			obj.addProperty("id", id  + "");
			result = call.callPostMethod(fullUrl, obj.toString(), Boolean.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}
	/**
	 * !This is an auto generated method!
	 *
	 * What are the Users Terms and Conditions.
	 */
	@Override
	public String GetTermsAndConditions(String clientaccount, JsonApi api) 
												throws ApiException {
		// Collect variables from method
		String target = "useraccount";
		String uriTemplate = "/UserAccount/{clientaccount}/TermsAndConditions";
		String transport = "GET";
		String envelope = "URL";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL if it is GET.
		if (transport.equals("GET")) {
			// Concatenating the empty string is a hackey way of converting all params to a String 
			
			filledUri = filledUri.replace("{clientaccount}", clientaccount + "");
		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		String result;
		if (transport.equals("GET")) {
			result = (String) api.callGetMethod(fullUrl, String.class);
		} else if (transport.equals("POST")) {
			JsonObject obj = new JsonObject();
			
			obj.addProperty("clientaccount", clientaccount  + "");
			result = (String) api.callPostMethod(fullUrl, obj.toString(), String.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}
	
	/**
	 * !This is an auto generated method!
	 *
	 * What are the Users Terms and Conditions.
	 */
	@Override
	public Future<Object> GetTermsAndConditionsAsync(String clientaccount, AsyncJsonApi api, CallBack... callBacks) throws ApiException {
		// Collect variables from method
		String target = "useraccount";
		String uriTemplate = "/UserAccount/{clientaccount}/TermsAndConditions";
		String transport = "GET";
		String envelope = "URL";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL.
		if (transport.equals("GET")) {
			// Concatenating the empty string is a hackey way of converting all params to a String
			
			filledUri = filledUri.replace("{clientaccount}", clientaccount + "");
		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		AsyncApiCall call = api.createNewCall();
		for (CallBack cb : callBacks) {
			call.addCallCompleteListener(cb);
		}
		Future<Object> result;
		if (transport.equals("GET")) {
			result = call.callGetMethod(fullUrl, String.class);
		} else if (transport.equals("POST")) {
			JsonObject obj = new JsonObject();
			
			obj.addProperty("clientaccount", clientaccount  + "");
			result = call.callPostMethod(fullUrl, obj.toString(), String.class);
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
	public AccountInformationResponseDTO GetClientAndTradingAccount( JsonApi api) 
												throws ApiException {
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
		AccountInformationResponseDTO result;
		if (transport.equals("GET")) {
			result = (AccountInformationResponseDTO) api.callGetMethod(fullUrl, AccountInformationResponseDTO.class);
		} else if (transport.equals("POST")) {
			JsonObject obj = new JsonObject();
			
			result = (AccountInformationResponseDTO) api.callPostMethod(fullUrl, obj.toString(), AccountInformationResponseDTO.class);
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
	public Future<Object> GetClientAndTradingAccountAsync( AsyncJsonApi api, CallBack... callBacks) throws ApiException {
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
		Future<Object> result;
		if (transport.equals("GET")) {
			result = call.callGetMethod(fullUrl, AccountInformationResponseDTO.class);
		} else if (transport.equals("POST")) {
			JsonObject obj = new JsonObject();
			
			result = call.callPostMethod(fullUrl, obj.toString(), AccountInformationResponseDTO.class);
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
	public ApiErrorResponseDTO GenerateException(int errorCode, JsonApi api) 
												throws ApiException {
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
		ApiErrorResponseDTO result;
		if (transport.equals("GET")) {
			result = (ApiErrorResponseDTO) api.callGetMethod(fullUrl, ApiErrorResponseDTO.class);
		} else if (transport.equals("POST")) {
			JsonObject obj = new JsonObject();
			
			obj.addProperty("errorCode", errorCode  + "");
			result = (ApiErrorResponseDTO) api.callPostMethod(fullUrl, obj.toString(), ApiErrorResponseDTO.class);
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
	public Future<Object> GenerateExceptionAsync(int errorCode, AsyncJsonApi api, CallBack... callBacks) throws ApiException {
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
		Future<Object> result;
		if (transport.equals("GET")) {
			result = call.callGetMethod(fullUrl, ApiErrorResponseDTO.class);
		} else if (transport.equals("POST")) {
			JsonObject obj = new JsonObject();
			
			obj.addProperty("errorCode", errorCode  + "");
			result = call.callPostMethod(fullUrl, obj.toString(), ApiErrorResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}
}

