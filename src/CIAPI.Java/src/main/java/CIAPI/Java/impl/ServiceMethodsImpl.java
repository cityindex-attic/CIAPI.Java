package CIAPI.Java.impl;

import java.util.concurrent.Future;
import JsonClient.Java.ApiException;
import JsonClient.Java.JsonApi;
import JsonClient.Java.async.AsyncJsonApi;
import JsonClient.Java.async.CallBack;
import JsonClient.Java.async.AsyncApiCall;
import CIAPI.Java.ServiceMethods;

public class ServiceMethodsImpl implements ServiceMethods {

	
	/**
	 * !This is an auto generated method!
	 *
	 * <p>Create a new session. This is how you "log on" to the CIAPI. Post a <a onclick="dojo.hash('#type.ApiLogOnRequestDTO'); return false;" class="json-link" href="#">ApiLogOnRequestDTO</a> to the uri specified below</p>
	 */
	@Override
	public CIAPI.Java.dto.ApiLogOnResponseDTO LogOn(String UserName,String Password, JsonApi api) 
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
		CIAPI.Java.dto.ApiLogOnResponseDTO result;
		if (transport.equals("GET")) {
			result = (CIAPI.Java.dto.ApiLogOnResponseDTO) api.callGetMethod(fullUrl, CIAPI.Java.dto.ApiLogOnResponseDTO.class);
		} else if (transport.equals("POST")) {
			result = (CIAPI.Java.dto.ApiLogOnResponseDTO) api.callPostMethod(fullUrl, UserName, CIAPI.Java.dto.ApiLogOnResponseDTO.class);
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
			result = call.callGetMethod(fullUrl, CIAPI.Java.dto.ApiLogOnResponseDTO.class);
		} else if (transport.equals("POST")) {
			result = call.callPostMethod(fullUrl, UserName, CIAPI.Java.dto.ApiLogOnResponseDTO.class);
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
	public CIAPI.Java.dto.ApiLogOffResponseDTO DeleteSession(String userName,String session, JsonApi api) 
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
		CIAPI.Java.dto.ApiLogOffResponseDTO result;
		if (transport.equals("GET")) {
			result = (CIAPI.Java.dto.ApiLogOffResponseDTO) api.callGetMethod(fullUrl, CIAPI.Java.dto.ApiLogOffResponseDTO.class);
		} else if (transport.equals("POST")) {
			result = (CIAPI.Java.dto.ApiLogOffResponseDTO) api.callPostMethod(fullUrl, userName, CIAPI.Java.dto.ApiLogOffResponseDTO.class);
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
			result = call.callGetMethod(fullUrl, CIAPI.Java.dto.ApiLogOffResponseDTO.class);
		} else if (transport.equals("POST")) {
			result = call.callPostMethod(fullUrl, userName, CIAPI.Java.dto.ApiLogOffResponseDTO.class);
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
	public CIAPI.Java.dto.GetPriceBarResponseDTO GetPriceBars(String marketId,String interval,int span,String priceBars, JsonApi api) 
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
		CIAPI.Java.dto.GetPriceBarResponseDTO result;
		if (transport.equals("GET")) {
			result = (CIAPI.Java.dto.GetPriceBarResponseDTO) api.callGetMethod(fullUrl, CIAPI.Java.dto.GetPriceBarResponseDTO.class);
		} else if (transport.equals("POST")) {
			result = (CIAPI.Java.dto.GetPriceBarResponseDTO) api.callPostMethod(fullUrl, marketId, CIAPI.Java.dto.GetPriceBarResponseDTO.class);
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
			result = call.callGetMethod(fullUrl, CIAPI.Java.dto.GetPriceBarResponseDTO.class);
		} else if (transport.equals("POST")) {
			result = call.callPostMethod(fullUrl, marketId, CIAPI.Java.dto.GetPriceBarResponseDTO.class);
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
	public CIAPI.Java.dto.GetPriceTickResponseDTO GetPriceTicks(String marketId,String priceTicks, JsonApi api) 
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
		CIAPI.Java.dto.GetPriceTickResponseDTO result;
		if (transport.equals("GET")) {
			result = (CIAPI.Java.dto.GetPriceTickResponseDTO) api.callGetMethod(fullUrl, CIAPI.Java.dto.GetPriceTickResponseDTO.class);
		} else if (transport.equals("POST")) {
			result = (CIAPI.Java.dto.GetPriceTickResponseDTO) api.callPostMethod(fullUrl, marketId, CIAPI.Java.dto.GetPriceTickResponseDTO.class);
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
			result = call.callGetMethod(fullUrl, CIAPI.Java.dto.GetPriceTickResponseDTO.class);
		} else if (transport.equals("POST")) {
			result = call.callPostMethod(fullUrl, marketId, CIAPI.Java.dto.GetPriceTickResponseDTO.class);
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
	public CIAPI.Java.dto.GetMarketInformationResponseDTO GetMarketInformation(String marketId, JsonApi api) 
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
		CIAPI.Java.dto.GetMarketInformationResponseDTO result;
		if (transport.equals("GET")) {
			result = (CIAPI.Java.dto.GetMarketInformationResponseDTO) api.callGetMethod(fullUrl, CIAPI.Java.dto.GetMarketInformationResponseDTO.class);
		} else if (transport.equals("POST")) {
			result = (CIAPI.Java.dto.GetMarketInformationResponseDTO) api.callPostMethod(fullUrl, marketId, CIAPI.Java.dto.GetMarketInformationResponseDTO.class);
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
			result = call.callGetMethod(fullUrl, CIAPI.Java.dto.GetMarketInformationResponseDTO.class);
		} else if (transport.equals("POST")) {
			result = call.callPostMethod(fullUrl, marketId, CIAPI.Java.dto.GetMarketInformationResponseDTO.class);
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
	public CIAPI.Java.dto.ListMarketInformationSearchResponseDTO ListMarketInformationSearch(boolean searchByMarketCode,boolean searchByMarketName,boolean spreadProductType,boolean cfdProductType,boolean binaryProductType,String query,int maxResults, JsonApi api) 
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
		CIAPI.Java.dto.ListMarketInformationSearchResponseDTO result;
		if (transport.equals("GET")) {
			result = (CIAPI.Java.dto.ListMarketInformationSearchResponseDTO) api.callGetMethod(fullUrl, CIAPI.Java.dto.ListMarketInformationSearchResponseDTO.class);
		} else if (transport.equals("POST")) {
			result = (CIAPI.Java.dto.ListMarketInformationSearchResponseDTO) api.callPostMethod(fullUrl, searchByMarketCode, CIAPI.Java.dto.ListMarketInformationSearchResponseDTO.class);
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
			result = call.callGetMethod(fullUrl, CIAPI.Java.dto.ListMarketInformationSearchResponseDTO.class);
		} else if (transport.equals("POST")) {
			result = call.callPostMethod(fullUrl, searchByMarketCode, CIAPI.Java.dto.ListMarketInformationSearchResponseDTO.class);
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
	public CIAPI.Java.dto.ListMarketInformationResponseDTO ListMarketInformation(int[] MarketIds, JsonApi api) 
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
		CIAPI.Java.dto.ListMarketInformationResponseDTO result;
		if (transport.equals("GET")) {
			result = (CIAPI.Java.dto.ListMarketInformationResponseDTO) api.callGetMethod(fullUrl, CIAPI.Java.dto.ListMarketInformationResponseDTO.class);
		} else if (transport.equals("POST")) {
			result = (CIAPI.Java.dto.ListMarketInformationResponseDTO) api.callPostMethod(fullUrl, MarketIds, CIAPI.Java.dto.ListMarketInformationResponseDTO.class);
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
			result = call.callGetMethod(fullUrl, CIAPI.Java.dto.ListMarketInformationResponseDTO.class);
		} else if (transport.equals("POST")) {
			result = call.callPostMethod(fullUrl, MarketIds, CIAPI.Java.dto.ListMarketInformationResponseDTO.class);
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
	public CIAPI.Java.dto.ListNewsHeadlinesResponseDTO ListNewsHeadlines(String category,int maxResults, JsonApi api) 
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
		CIAPI.Java.dto.ListNewsHeadlinesResponseDTO result;
		if (transport.equals("GET")) {
			result = (CIAPI.Java.dto.ListNewsHeadlinesResponseDTO) api.callGetMethod(fullUrl, CIAPI.Java.dto.ListNewsHeadlinesResponseDTO.class);
		} else if (transport.equals("POST")) {
			result = (CIAPI.Java.dto.ListNewsHeadlinesResponseDTO) api.callPostMethod(fullUrl, category, CIAPI.Java.dto.ListNewsHeadlinesResponseDTO.class);
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
			result = call.callGetMethod(fullUrl, CIAPI.Java.dto.ListNewsHeadlinesResponseDTO.class);
		} else if (transport.equals("POST")) {
			result = call.callPostMethod(fullUrl, category, CIAPI.Java.dto.ListNewsHeadlinesResponseDTO.class);
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
	public CIAPI.Java.dto.GetNewsDetailResponseDTO GetNewsDetail(String storyId, JsonApi api) 
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
		CIAPI.Java.dto.GetNewsDetailResponseDTO result;
		if (transport.equals("GET")) {
			result = (CIAPI.Java.dto.GetNewsDetailResponseDTO) api.callGetMethod(fullUrl, CIAPI.Java.dto.GetNewsDetailResponseDTO.class);
		} else if (transport.equals("POST")) {
			result = (CIAPI.Java.dto.GetNewsDetailResponseDTO) api.callPostMethod(fullUrl, storyId, CIAPI.Java.dto.GetNewsDetailResponseDTO.class);
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
			result = call.callGetMethod(fullUrl, CIAPI.Java.dto.GetNewsDetailResponseDTO.class);
		} else if (transport.equals("POST")) {
			result = call.callPostMethod(fullUrl, storyId, CIAPI.Java.dto.GetNewsDetailResponseDTO.class);
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
	public CIAPI.Java.dto.ListCfdMarketsResponseDTO ListCfdMarkets(String searchByMarketName,String searchByMarketCode,int clientAccountId,int maxResults, JsonApi api) 
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
		CIAPI.Java.dto.ListCfdMarketsResponseDTO result;
		if (transport.equals("GET")) {
			result = (CIAPI.Java.dto.ListCfdMarketsResponseDTO) api.callGetMethod(fullUrl, CIAPI.Java.dto.ListCfdMarketsResponseDTO.class);
		} else if (transport.equals("POST")) {
			result = (CIAPI.Java.dto.ListCfdMarketsResponseDTO) api.callPostMethod(fullUrl, searchByMarketName, CIAPI.Java.dto.ListCfdMarketsResponseDTO.class);
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
			result = call.callGetMethod(fullUrl, CIAPI.Java.dto.ListCfdMarketsResponseDTO.class);
		} else if (transport.equals("POST")) {
			result = call.callPostMethod(fullUrl, searchByMarketName, CIAPI.Java.dto.ListCfdMarketsResponseDTO.class);
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
	public CIAPI.Java.dto.ListSpreadMarketsResponseDTO ListSpreadMarkets(String searchByMarketName,String searchByMarketCode,int clientAccountId,int maxResults, JsonApi api) 
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
		CIAPI.Java.dto.ListSpreadMarketsResponseDTO result;
		if (transport.equals("GET")) {
			result = (CIAPI.Java.dto.ListSpreadMarketsResponseDTO) api.callGetMethod(fullUrl, CIAPI.Java.dto.ListSpreadMarketsResponseDTO.class);
		} else if (transport.equals("POST")) {
			result = (CIAPI.Java.dto.ListSpreadMarketsResponseDTO) api.callPostMethod(fullUrl, searchByMarketName, CIAPI.Java.dto.ListSpreadMarketsResponseDTO.class);
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
			result = call.callGetMethod(fullUrl, CIAPI.Java.dto.ListSpreadMarketsResponseDTO.class);
		} else if (transport.equals("POST")) {
			result = call.callPostMethod(fullUrl, searchByMarketName, CIAPI.Java.dto.ListSpreadMarketsResponseDTO.class);
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
	public CIAPI.Java.dto.ApiTradeOrderResponseDTO Order(int OrderId,int MarketId,String Currency,boolean AutoRollover,String Direction,double Quantity,double BidPrice,double OfferPrice,String AuditId,int TradingAccountId,CIAPI.Java.dto.ApiIfDoneDTO[] IfDone,CIAPI.Java.dto.NewStopLimitOrderRequestDTO OcoOrder,String Applicability,String ExpiryDateTimeUTC,boolean Guaranteed,double TriggerPrice, JsonApi api) 
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
		CIAPI.Java.dto.ApiTradeOrderResponseDTO result;
		if (transport.equals("GET")) {
			result = (CIAPI.Java.dto.ApiTradeOrderResponseDTO) api.callGetMethod(fullUrl, CIAPI.Java.dto.ApiTradeOrderResponseDTO.class);
		} else if (transport.equals("POST")) {
			result = (CIAPI.Java.dto.ApiTradeOrderResponseDTO) api.callPostMethod(fullUrl, OrderId, CIAPI.Java.dto.ApiTradeOrderResponseDTO.class);
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
	public Future<Object> OrderAsync(int OrderId,int MarketId,String Currency,boolean AutoRollover,String Direction,double Quantity,double BidPrice,double OfferPrice,String AuditId,int TradingAccountId,CIAPI.Java.dto.ApiIfDoneDTO[] IfDone,CIAPI.Java.dto.NewStopLimitOrderRequestDTO OcoOrder,String Applicability,String ExpiryDateTimeUTC,boolean Guaranteed,double TriggerPrice, AsyncJsonApi api, CallBack... callBacks) throws ApiException {
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
			result = call.callGetMethod(fullUrl, CIAPI.Java.dto.ApiTradeOrderResponseDTO.class);
		} else if (transport.equals("POST")) {
			result = call.callPostMethod(fullUrl, OrderId, CIAPI.Java.dto.ApiTradeOrderResponseDTO.class);
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
	public CIAPI.Java.dto.ApiTradeOrderResponseDTO CancelOrder(int OrderId,int TradingAccountId, JsonApi api) 
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
		CIAPI.Java.dto.ApiTradeOrderResponseDTO result;
		if (transport.equals("GET")) {
			result = (CIAPI.Java.dto.ApiTradeOrderResponseDTO) api.callGetMethod(fullUrl, CIAPI.Java.dto.ApiTradeOrderResponseDTO.class);
		} else if (transport.equals("POST")) {
			result = (CIAPI.Java.dto.ApiTradeOrderResponseDTO) api.callPostMethod(fullUrl, OrderId, CIAPI.Java.dto.ApiTradeOrderResponseDTO.class);
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
			result = call.callGetMethod(fullUrl, CIAPI.Java.dto.ApiTradeOrderResponseDTO.class);
		} else if (transport.equals("POST")) {
			result = call.callPostMethod(fullUrl, OrderId, CIAPI.Java.dto.ApiTradeOrderResponseDTO.class);
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
	public CIAPI.Java.dto.ApiTradeOrderResponseDTO UpdateOrder( JsonApi api) 
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
		CIAPI.Java.dto.ApiTradeOrderResponseDTO result;
		if (transport.equals("GET")) {
			result = (CIAPI.Java.dto.ApiTradeOrderResponseDTO) api.callGetMethod(fullUrl, CIAPI.Java.dto.ApiTradeOrderResponseDTO.class);
		} else if (transport.equals("POST")) {
			result = (CIAPI.Java.dto.ApiTradeOrderResponseDTO) api.callPostMethod(fullUrl, null, CIAPI.Java.dto.ApiTradeOrderResponseDTO.class);
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
	public Future<Object> UpdateOrderAsync(AsyncJsonApi api, CallBack... callBacks) throws ApiException {
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
			result = call.callGetMethod(fullUrl, CIAPI.Java.dto.ApiTradeOrderResponseDTO.class);
		} else if (transport.equals("POST")) {
			result = call.callPostMethod(fullUrl, null , CIAPI.Java.dto.ApiTradeOrderResponseDTO.class);
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
	public CIAPI.Java.dto.ListOpenPositionsResponseDTO ListOpenPositions(int tradingAccountId, JsonApi api) 
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
		CIAPI.Java.dto.ListOpenPositionsResponseDTO result;
		if (transport.equals("GET")) {
			result = (CIAPI.Java.dto.ListOpenPositionsResponseDTO) api.callGetMethod(fullUrl, CIAPI.Java.dto.ListOpenPositionsResponseDTO.class);
		} else if (transport.equals("POST")) {
			result = (CIAPI.Java.dto.ListOpenPositionsResponseDTO) api.callPostMethod(fullUrl, tradingAccountId, CIAPI.Java.dto.ListOpenPositionsResponseDTO.class);
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
			result = call.callGetMethod(fullUrl, CIAPI.Java.dto.ListOpenPositionsResponseDTO.class);
		} else if (transport.equals("POST")) {
			result = call.callPostMethod(fullUrl, tradingAccountId, CIAPI.Java.dto.ListOpenPositionsResponseDTO.class);
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
	public CIAPI.Java.dto.ListActiveStopLimitOrderResponseDTO ListActiveStopLimitOrders(int tradingAccountId, JsonApi api) 
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
		CIAPI.Java.dto.ListActiveStopLimitOrderResponseDTO result;
		if (transport.equals("GET")) {
			result = (CIAPI.Java.dto.ListActiveStopLimitOrderResponseDTO) api.callGetMethod(fullUrl, CIAPI.Java.dto.ListActiveStopLimitOrderResponseDTO.class);
		} else if (transport.equals("POST")) {
			result = (CIAPI.Java.dto.ListActiveStopLimitOrderResponseDTO) api.callPostMethod(fullUrl, tradingAccountId, CIAPI.Java.dto.ListActiveStopLimitOrderResponseDTO.class);
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
			result = call.callGetMethod(fullUrl, CIAPI.Java.dto.ListActiveStopLimitOrderResponseDTO.class);
		} else if (transport.equals("POST")) {
			result = call.callPostMethod(fullUrl, tradingAccountId, CIAPI.Java.dto.ListActiveStopLimitOrderResponseDTO.class);
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
	public CIAPI.Java.dto.GetActiveStopLimitOrderResponseDTO GetActiveStopLimitOrder(String orderId, JsonApi api) 
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
		CIAPI.Java.dto.GetActiveStopLimitOrderResponseDTO result;
		if (transport.equals("GET")) {
			result = (CIAPI.Java.dto.GetActiveStopLimitOrderResponseDTO) api.callGetMethod(fullUrl, CIAPI.Java.dto.GetActiveStopLimitOrderResponseDTO.class);
		} else if (transport.equals("POST")) {
			result = (CIAPI.Java.dto.GetActiveStopLimitOrderResponseDTO) api.callPostMethod(fullUrl, orderId, CIAPI.Java.dto.GetActiveStopLimitOrderResponseDTO.class);
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
			result = call.callGetMethod(fullUrl, CIAPI.Java.dto.GetActiveStopLimitOrderResponseDTO.class);
		} else if (transport.equals("POST")) {
			result = call.callPostMethod(fullUrl, orderId, CIAPI.Java.dto.GetActiveStopLimitOrderResponseDTO.class);
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
	public CIAPI.Java.dto.GetOpenPositionResponseDTO GetOpenPosition(String orderId, JsonApi api) 
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
		CIAPI.Java.dto.GetOpenPositionResponseDTO result;
		if (transport.equals("GET")) {
			result = (CIAPI.Java.dto.GetOpenPositionResponseDTO) api.callGetMethod(fullUrl, CIAPI.Java.dto.GetOpenPositionResponseDTO.class);
		} else if (transport.equals("POST")) {
			result = (CIAPI.Java.dto.GetOpenPositionResponseDTO) api.callPostMethod(fullUrl, orderId, CIAPI.Java.dto.GetOpenPositionResponseDTO.class);
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
			result = call.callGetMethod(fullUrl, CIAPI.Java.dto.GetOpenPositionResponseDTO.class);
		} else if (transport.equals("POST")) {
			result = call.callPostMethod(fullUrl, orderId, CIAPI.Java.dto.GetOpenPositionResponseDTO.class);
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
	public CIAPI.Java.dto.ListTradeHistoryResponseDTO ListTradeHistory(int tradingAccountId,int maxResults, JsonApi api) 
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
		CIAPI.Java.dto.ListTradeHistoryResponseDTO result;
		if (transport.equals("GET")) {
			result = (CIAPI.Java.dto.ListTradeHistoryResponseDTO) api.callGetMethod(fullUrl, CIAPI.Java.dto.ListTradeHistoryResponseDTO.class);
		} else if (transport.equals("POST")) {
			result = (CIAPI.Java.dto.ListTradeHistoryResponseDTO) api.callPostMethod(fullUrl, tradingAccountId, CIAPI.Java.dto.ListTradeHistoryResponseDTO.class);
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
			result = call.callGetMethod(fullUrl, CIAPI.Java.dto.ListTradeHistoryResponseDTO.class);
		} else if (transport.equals("POST")) {
			result = call.callPostMethod(fullUrl, tradingAccountId, CIAPI.Java.dto.ListTradeHistoryResponseDTO.class);
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
	public CIAPI.Java.dto.ListStopLimitOrderHistoryResponseDTO ListStopLimitOrderHistory(int tradingAccountId,int maxResults, JsonApi api) 
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
		CIAPI.Java.dto.ListStopLimitOrderHistoryResponseDTO result;
		if (transport.equals("GET")) {
			result = (CIAPI.Java.dto.ListStopLimitOrderHistoryResponseDTO) api.callGetMethod(fullUrl, CIAPI.Java.dto.ListStopLimitOrderHistoryResponseDTO.class);
		} else if (transport.equals("POST")) {
			result = (CIAPI.Java.dto.ListStopLimitOrderHistoryResponseDTO) api.callPostMethod(fullUrl, tradingAccountId, CIAPI.Java.dto.ListStopLimitOrderHistoryResponseDTO.class);
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
			result = call.callGetMethod(fullUrl, CIAPI.Java.dto.ListStopLimitOrderHistoryResponseDTO.class);
		} else if (transport.equals("POST")) {
			result = call.callPostMethod(fullUrl, tradingAccountId, CIAPI.Java.dto.ListStopLimitOrderHistoryResponseDTO.class);
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
	public CIAPI.Java.dto.GetOrderResponseDTO GetOrder(String orderId, JsonApi api) 
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
		CIAPI.Java.dto.GetOrderResponseDTO result;
		if (transport.equals("GET")) {
			result = (CIAPI.Java.dto.GetOrderResponseDTO) api.callGetMethod(fullUrl, CIAPI.Java.dto.GetOrderResponseDTO.class);
		} else if (transport.equals("POST")) {
			result = (CIAPI.Java.dto.GetOrderResponseDTO) api.callPostMethod(fullUrl, orderId, CIAPI.Java.dto.GetOrderResponseDTO.class);
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
			result = call.callGetMethod(fullUrl, CIAPI.Java.dto.GetOrderResponseDTO.class);
		} else if (transport.equals("POST")) {
			result = call.callPostMethod(fullUrl, orderId, CIAPI.Java.dto.GetOrderResponseDTO.class);
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
	public CIAPI.Java.dto.ApiTradeOrderResponseDTO Trade(int MarketId,String Currency,boolean AutoRollover,String Direction,double Quantity,String QuoteId,double BidPrice,double OfferPrice,String AuditId,int TradingAccountId,CIAPI.Java.dto.ApiIfDoneDTO[] IfDone,int[] Close, JsonApi api) 
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
		CIAPI.Java.dto.ApiTradeOrderResponseDTO result;
		if (transport.equals("GET")) {
			result = (CIAPI.Java.dto.ApiTradeOrderResponseDTO) api.callGetMethod(fullUrl, CIAPI.Java.dto.ApiTradeOrderResponseDTO.class);
		} else if (transport.equals("POST")) {
			result = (CIAPI.Java.dto.ApiTradeOrderResponseDTO) api.callPostMethod(fullUrl, MarketId, CIAPI.Java.dto.ApiTradeOrderResponseDTO.class);
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
	public Future<Object> TradeAsync(int MarketId,String Currency,boolean AutoRollover,String Direction,double Quantity,String QuoteId,double BidPrice,double OfferPrice,String AuditId,int TradingAccountId,CIAPI.Java.dto.ApiIfDoneDTO[] IfDone,int[] Close, AsyncJsonApi api, CallBack... callBacks) throws ApiException {
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
			result = call.callGetMethod(fullUrl, CIAPI.Java.dto.ApiTradeOrderResponseDTO.class);
		} else if (transport.equals("POST")) {
			result = call.callPostMethod(fullUrl, MarketId, CIAPI.Java.dto.ApiTradeOrderResponseDTO.class);
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
	public CIAPI.Java.dto.ApiTradeOrderResponseDTO UpdateTrade(int OrderId, JsonApi api) 
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
		CIAPI.Java.dto.ApiTradeOrderResponseDTO result;
		if (transport.equals("GET")) {
			result = (CIAPI.Java.dto.ApiTradeOrderResponseDTO) api.callGetMethod(fullUrl, CIAPI.Java.dto.ApiTradeOrderResponseDTO.class);
		} else if (transport.equals("POST")) {
			result = (CIAPI.Java.dto.ApiTradeOrderResponseDTO) api.callPostMethod(fullUrl, OrderId, CIAPI.Java.dto.ApiTradeOrderResponseDTO.class);
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
			result = call.callGetMethod(fullUrl, CIAPI.Java.dto.ApiTradeOrderResponseDTO.class);
		} else if (transport.equals("POST")) {
			result = call.callPostMethod(fullUrl, OrderId, CIAPI.Java.dto.ApiTradeOrderResponseDTO.class);
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
			result = (Boolean) api.callPostMethod(fullUrl, id, Boolean.class);
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
			result = call.callPostMethod(fullUrl, id, Boolean.class);
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
			result = (String) api.callPostMethod(fullUrl, clientaccount, String.class);
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
			result = call.callPostMethod(fullUrl, clientaccount, String.class);
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
	public CIAPI.Java.dto.AccountInformationResponseDTO GetClientAndTradingAccount(JsonApi api) 
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
		CIAPI.Java.dto.AccountInformationResponseDTO result;
		if (transport.equals("GET")) {
			result = (CIAPI.Java.dto.AccountInformationResponseDTO) api.callGetMethod(fullUrl, CIAPI.Java.dto.AccountInformationResponseDTO.class);
		} else if (transport.equals("POST")) {
			result = (CIAPI.Java.dto.AccountInformationResponseDTO) api.callPostMethod(fullUrl,null , CIAPI.Java.dto.AccountInformationResponseDTO.class);
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
		Future<Object> result;
		if (transport.equals("GET")) {
			result = call.callGetMethod(fullUrl, CIAPI.Java.dto.AccountInformationResponseDTO.class);
		} else if (transport.equals("POST")) {
			result = call.callPostMethod(fullUrl, null, CIAPI.Java.dto.AccountInformationResponseDTO.class);
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
	public CIAPI.Java.dto.ApiErrorResponseDTO GenerateException(int errorCode, JsonApi api) 
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
		CIAPI.Java.dto.ApiErrorResponseDTO result;
		if (transport.equals("GET")) {
			result = (CIAPI.Java.dto.ApiErrorResponseDTO) api.callGetMethod(fullUrl, CIAPI.Java.dto.ApiErrorResponseDTO.class);
		} else if (transport.equals("POST")) {
			result = (CIAPI.Java.dto.ApiErrorResponseDTO) api.callPostMethod(fullUrl, errorCode, CIAPI.Java.dto.ApiErrorResponseDTO.class);
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
			result = call.callGetMethod(fullUrl, CIAPI.Java.dto.ApiErrorResponseDTO.class);
		} else if (transport.equals("POST")) {
			result = call.callPostMethod(fullUrl, errorCode, CIAPI.Java.dto.ApiErrorResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}
}

