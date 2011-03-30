package CIAPI.Java.impl;

import java.util.concurrent.Future;
import CIAPI.Java.ApiException;
import CIAPI.Java.JsonApi;
import CIAPI.Java.async.AsyncJsonApi;
import CIAPI.Java.async.CallBack;
import CIAPI.Java.async.AsyncApiCall;
import CIAPI.Java.ServiceMethods;

public class ServiceMethodsImpl implements ServiceMethods {

	
	/**
	 * !This is an auto generated method!
	 *
	 * Create a new session. The is how you "log on" to the CIAPI.
	 */
	@Override
	public CIAPI.Java.dto.CreateSessionResponseDTO CreateSession(CIAPI.Java.dto.LogOnRequestDTO logOnRequest, JsonApi api) throws ApiException {
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
			
			filledUri = filledUri.replace("{logOnRequest}", logOnRequest + "");

		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		CIAPI.Java.dto.CreateSessionResponseDTO result;
		if (transport.equals("GET")) {
			result = (CIAPI.Java.dto.CreateSessionResponseDTO) api.callGetMethod(fullUrl, CIAPI.Java.dto.CreateSessionResponseDTO.class);
		} else if (transport.equals("POST")) {
			result = (CIAPI.Java.dto.CreateSessionResponseDTO) api.callPostMethod(fullUrl, logOnRequest, CIAPI.Java.dto.CreateSessionResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}
	
	/**
	 * !This is an auto generated method!
	 *
	 * Create a new session. The is how you "log on" to the CIAPI.
	 */
	@Override
	public Future<Object> CreateSessionAsync(CIAPI.Java.dto.LogOnRequestDTO logOnRequest, AsyncJsonApi api, CallBack... callBacks) throws ApiException {
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
			
			filledUri = filledUri.replace("{logOnRequest}", logOnRequest + "");

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
			result = call.callGetMethod(fullUrl, CIAPI.Java.dto.CreateSessionResponseDTO.class);
		} else if (transport.equals("POST")) {
			result = call.callPostMethod(fullUrl, logOnRequest, CIAPI.Java.dto.CreateSessionResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}

	/**
	 * !This is an auto generated method!
	 *
	 * Delete a session. This is how you "log off" from the CIAPI.
	 */
	@Override
	public CIAPI.Java.dto.SessionDeletionResponseDTO DeleteSession(String userName, String session, JsonApi api) throws ApiException {
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
		CIAPI.Java.dto.SessionDeletionResponseDTO result;
		if (transport.equals("GET")) {
			result = (CIAPI.Java.dto.SessionDeletionResponseDTO) api.callGetMethod(fullUrl, CIAPI.Java.dto.SessionDeletionResponseDTO.class);
		} else if (transport.equals("POST")) {
			result = (CIAPI.Java.dto.SessionDeletionResponseDTO) api.callPostMethod(fullUrl, userName, CIAPI.Java.dto.SessionDeletionResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}
	
	/**
	 * !This is an auto generated method!
	 *
	 * Delete a session. This is how you "log off" from the CIAPI.
	 */
	@Override
	public Future<Object> DeleteSessionAsync(String userName, String session, AsyncJsonApi api, CallBack... callBacks) throws ApiException {
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
			result = call.callGetMethod(fullUrl, CIAPI.Java.dto.SessionDeletionResponseDTO.class);
		} else if (transport.equals("POST")) {
			result = call.callPostMethod(fullUrl, userName, CIAPI.Java.dto.SessionDeletionResponseDTO.class);
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
	public CIAPI.Java.dto.GetPriceBarResponseDTO GetPriceBars(String marketId, String interval, int span, String priceBars, JsonApi api) throws ApiException {
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
			result = (CIAPI.Java.dto.GetPriceBarResponseDTO) api.callPostMethod(fullUrl, null, CIAPI.Java.dto.GetPriceBarResponseDTO.class);
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
	public Future<Object> GetPriceBarsAsync(String marketId, String interval, int span, String priceBars, AsyncJsonApi api, CallBack... callBacks) throws ApiException {
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
			result = call.callPostMethod(fullUrl, null, CIAPI.Java.dto.GetPriceBarResponseDTO.class);
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
	public CIAPI.Java.dto.GetPriceTickResponseDTO GetPriceTicks(String marketId, String priceTicks, JsonApi api) throws ApiException {
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
			result = (CIAPI.Java.dto.GetPriceTickResponseDTO) api.callPostMethod(fullUrl, null, CIAPI.Java.dto.GetPriceTickResponseDTO.class);
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
	public Future<Object> GetPriceTicksAsync(String marketId, String priceTicks, AsyncJsonApi api, CallBack... callBacks) throws ApiException {
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
			result = call.callPostMethod(fullUrl, null, CIAPI.Java.dto.GetPriceTickResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}

	/**
	 * !This is an auto generated method!
	 *
	 * Get Market Information for the specified market. You must be authorised to view the market, or the query will fail.
	 */
	@Override
	public CIAPI.Java.dto.GetMarketInformationResponseDTO GetMarketInformation(String marketId, JsonApi api) throws ApiException {
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
			result = (CIAPI.Java.dto.GetMarketInformationResponseDTO) api.callPostMethod(fullUrl, null, CIAPI.Java.dto.GetMarketInformationResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}
	
	/**
	 * !This is an auto generated method!
	 *
	 * Get Market Information for the specified market. You must be authorised to view the market, or the query will fail.
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
			result = call.callPostMethod(fullUrl, null, CIAPI.Java.dto.GetMarketInformationResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}

	/**
	 * !This is an auto generated method!
	 *
	 * Get Market Information for markets that fit the query.
	 */
	@Override
	public CIAPI.Java.dto.ListMarketInformationSearchResponseDTO ListMarketInformationSearch(boolean searchByMarketCode, boolean searchByMarketName, boolean spreadProductType, boolean cfdProductType, boolean binaryProductType, String query, int maxResults, JsonApi api) throws ApiException {
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
			result = (CIAPI.Java.dto.ListMarketInformationSearchResponseDTO) api.callPostMethod(fullUrl, null, CIAPI.Java.dto.ListMarketInformationSearchResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}
	
	/**
	 * !This is an auto generated method!
	 *
	 * Get Market Information for markets that fit the query.
	 */
	@Override
	public Future<Object> ListMarketInformationSearchAsync(boolean searchByMarketCode, boolean searchByMarketName, boolean spreadProductType, boolean cfdProductType, boolean binaryProductType, String query, int maxResults, AsyncJsonApi api, CallBack... callBacks) throws ApiException {
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
			result = call.callPostMethod(fullUrl, null, CIAPI.Java.dto.ListMarketInformationSearchResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}

	/**
	 * !This is an auto generated method!
	 *
	 * Get Market Information for the specified list of markets. You must be authorised to view all the markets in the supplied list, or the query will fail.
	 */
	@Override
	public CIAPI.Java.dto.ListMarketInformationResponseDTO ListMarketInformation(CIAPI.Java.dto.ListMarketInformationRequestDTO[] listMarketInformationRequestDTO, JsonApi api) throws ApiException {
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
			
			filledUri = filledUri.replace("{listMarketInformationRequestDTO}", listMarketInformationRequestDTO + "");

		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		CIAPI.Java.dto.ListMarketInformationResponseDTO result;
		if (transport.equals("GET")) {
			result = (CIAPI.Java.dto.ListMarketInformationResponseDTO) api.callGetMethod(fullUrl, CIAPI.Java.dto.ListMarketInformationResponseDTO.class);
		} else if (transport.equals("POST")) {
			result = (CIAPI.Java.dto.ListMarketInformationResponseDTO) api.callPostMethod(fullUrl, listMarketInformationRequestDTO, CIAPI.Java.dto.ListMarketInformationResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}
	
	/**
	 * !This is an auto generated method!
	 *
	 * Get Market Information for the specified list of markets. You must be authorised to view all the markets in the supplied list, or the query will fail.
	 */
	@Override
	public Future<Object> ListMarketInformationAsync(CIAPI.Java.dto.ListMarketInformationRequestDTO[] listMarketInformationRequestDTO, AsyncJsonApi api, CallBack... callBacks) throws ApiException {
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
			
			filledUri = filledUri.replace("{listMarketInformationRequestDTO}", listMarketInformationRequestDTO + "");

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
			result = call.callPostMethod(fullUrl, listMarketInformationRequestDTO, CIAPI.Java.dto.ListMarketInformationResponseDTO.class);
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
	public CIAPI.Java.dto.ListNewsHeadlinesResponseDTO ListNewsHeadlines(String category, int maxResults, JsonApi api) throws ApiException {
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
			result = (CIAPI.Java.dto.ListNewsHeadlinesResponseDTO) api.callPostMethod(fullUrl, null, CIAPI.Java.dto.ListNewsHeadlinesResponseDTO.class);
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
	public Future<Object> ListNewsHeadlinesAsync(String category, int maxResults, AsyncJsonApi api, CallBack... callBacks) throws ApiException {
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
			result = call.callPostMethod(fullUrl, null, CIAPI.Java.dto.ListNewsHeadlinesResponseDTO.class);
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
	public CIAPI.Java.dto.GetNewsDetailResponseDTO GetNewsDetail(String storyId, JsonApi api) throws ApiException {
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
			result = (CIAPI.Java.dto.GetNewsDetailResponseDTO) api.callPostMethod(fullUrl, null, CIAPI.Java.dto.GetNewsDetailResponseDTO.class);
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
			result = call.callPostMethod(fullUrl, null, CIAPI.Java.dto.GetNewsDetailResponseDTO.class);
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
	public CIAPI.Java.dto.ListCfdMarketsResponseDTO ListCfdMarkets(String searchByMarketName, String searchByMarketCode, int clientAccountId, int maxResults, JsonApi api) throws ApiException {
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
			result = (CIAPI.Java.dto.ListCfdMarketsResponseDTO) api.callPostMethod(fullUrl, null, CIAPI.Java.dto.ListCfdMarketsResponseDTO.class);
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
	public Future<Object> ListCfdMarketsAsync(String searchByMarketName, String searchByMarketCode, int clientAccountId, int maxResults, AsyncJsonApi api, CallBack... callBacks) throws ApiException {
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
			result = call.callPostMethod(fullUrl, null, CIAPI.Java.dto.ListCfdMarketsResponseDTO.class);
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
	public CIAPI.Java.dto.ListSpreadMarketsResponseDTO ListSpreadMarkets(String searchByMarketName, String searchByMarketCode, int clientAccountId, int maxResults, JsonApi api) throws ApiException {
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
			result = (CIAPI.Java.dto.ListSpreadMarketsResponseDTO) api.callPostMethod(fullUrl, null, CIAPI.Java.dto.ListSpreadMarketsResponseDTO.class);
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
	public Future<Object> ListSpreadMarketsAsync(String searchByMarketName, String searchByMarketCode, int clientAccountId, int maxResults, AsyncJsonApi api, CallBack... callBacks) throws ApiException {
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
			result = call.callPostMethod(fullUrl, null, CIAPI.Java.dto.ListSpreadMarketsResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}

	/**
	 * !This is an auto generated method!
	 *
	 * Place an order on a particular market
	 */
	@Override
	public CIAPI.Java.dto.ApiTradeOrderResponseDTO Order(CIAPI.Java.dto.NewStopLimitOrderRequestDTO order, JsonApi api) throws ApiException {
		// Collect variables from method
		String target = "order";
		String uriTemplate = "/order";
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
		CIAPI.Java.dto.ApiTradeOrderResponseDTO result;
		if (transport.equals("GET")) {
			result = (CIAPI.Java.dto.ApiTradeOrderResponseDTO) api.callGetMethod(fullUrl, CIAPI.Java.dto.ApiTradeOrderResponseDTO.class);
		} else if (transport.equals("POST")) {
			result = (CIAPI.Java.dto.ApiTradeOrderResponseDTO) api.callPostMethod(fullUrl, order, CIAPI.Java.dto.ApiTradeOrderResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}
	
	/**
	 * !This is an auto generated method!
	 *
	 * Place an order on a particular market
	 */
	@Override
	public Future<Object> OrderAsync(CIAPI.Java.dto.NewStopLimitOrderRequestDTO order, AsyncJsonApi api, CallBack... callBacks) throws ApiException {
		// Collect variables from method
		String target = "order";
		String uriTemplate = "/order";
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
		Future<Object> result;
		if (transport.equals("GET")) {
			result = call.callGetMethod(fullUrl, CIAPI.Java.dto.ApiTradeOrderResponseDTO.class);
		} else if (transport.equals("POST")) {
			result = call.callPostMethod(fullUrl, order, CIAPI.Java.dto.ApiTradeOrderResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}

	/**
	 * !This is an auto generated method!
	 *
	 * Cancel an order
	 */
	@Override
	public CIAPI.Java.dto.ApiTradeOrderResponseDTO CancelOrder(CIAPI.Java.dto.CancelOrderRequestDTO cancelOrder, JsonApi api) throws ApiException {
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
		CIAPI.Java.dto.ApiTradeOrderResponseDTO result;
		if (transport.equals("GET")) {
			result = (CIAPI.Java.dto.ApiTradeOrderResponseDTO) api.callGetMethod(fullUrl, CIAPI.Java.dto.ApiTradeOrderResponseDTO.class);
		} else if (transport.equals("POST")) {
			result = (CIAPI.Java.dto.ApiTradeOrderResponseDTO) api.callPostMethod(fullUrl, cancelOrder, CIAPI.Java.dto.ApiTradeOrderResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}
	
	/**
	 * !This is an auto generated method!
	 *
	 * Cancel an order
	 */
	@Override
	public Future<Object> CancelOrderAsync(CIAPI.Java.dto.CancelOrderRequestDTO cancelOrder, AsyncJsonApi api, CallBack... callBacks) throws ApiException {
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
		Future<Object> result;
		if (transport.equals("GET")) {
			result = call.callGetMethod(fullUrl, CIAPI.Java.dto.ApiTradeOrderResponseDTO.class);
		} else if (transport.equals("POST")) {
			result = call.callPostMethod(fullUrl, cancelOrder, CIAPI.Java.dto.ApiTradeOrderResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}

	/**
	 * !This is an auto generated method!
	 *
	 * Not Implemented.
	 */
	@Override
	public CIAPI.Java.dto.ListOrdersResponseDTO ListOrders(int tradingAccountId, boolean openOrders, boolean acceptedOrders, JsonApi api) throws ApiException {
		// Collect variables from method
		String target = "order";
		String uriTemplate = "/orders?TradingAccountId={tradingAccountId}&OpenOrders={openOrders}&AcceptedOrders={acceptedOrders}";
		String transport = "GET";
		String envelope = "URL";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL if it is GET.
		if (transport.equals("GET")) {
			// Concatenating the empty string is a hackey way of converting all params to a String
			
			filledUri = filledUri.replace("{tradingAccountId}", tradingAccountId + "");

			filledUri = filledUri.replace("{openOrders}", openOrders + "");

			filledUri = filledUri.replace("{acceptedOrders}", acceptedOrders + "");

		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		CIAPI.Java.dto.ListOrdersResponseDTO result;
		if (transport.equals("GET")) {
			result = (CIAPI.Java.dto.ListOrdersResponseDTO) api.callGetMethod(fullUrl, CIAPI.Java.dto.ListOrdersResponseDTO.class);
		} else if (transport.equals("POST")) {
			result = (CIAPI.Java.dto.ListOrdersResponseDTO) api.callPostMethod(fullUrl, null, CIAPI.Java.dto.ListOrdersResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}
	
	/**
	 * !This is an auto generated method!
	 *
	 * Not Implemented.
	 */
	@Override
	public Future<Object> ListOrdersAsync(int tradingAccountId, boolean openOrders, boolean acceptedOrders, AsyncJsonApi api, CallBack... callBacks) throws ApiException {
		// Collect variables from method
		String target = "order";
		String uriTemplate = "/orders?TradingAccountId={tradingAccountId}&OpenOrders={openOrders}&AcceptedOrders={acceptedOrders}";
		String transport = "GET";
		String envelope = "URL";
		String contentType = "application/json";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL.
		if (transport.equals("GET")) {
			// Concatenating the empty string is a hackey way of converting all params to a String
			
			filledUri = filledUri.replace("{tradingAccountId}", tradingAccountId + "");

			filledUri = filledUri.replace("{openOrders}", openOrders + "");

			filledUri = filledUri.replace("{acceptedOrders}", acceptedOrders + "");

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
			result = call.callGetMethod(fullUrl, CIAPI.Java.dto.ListOrdersResponseDTO.class);
		} else if (transport.equals("POST")) {
			result = call.callPostMethod(fullUrl, null, CIAPI.Java.dto.ListOrdersResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}

	/**
	 * !This is an auto generated method!
	 *
	 * Queries for a specified trading account's trades / open positions.
	 */
	@Override
	public CIAPI.Java.dto.ListOpenPositionsResponseDTO ListOpenPositions(int tradingAccountId, JsonApi api) throws ApiException {
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
			result = (CIAPI.Java.dto.ListOpenPositionsResponseDTO) api.callPostMethod(fullUrl, null, CIAPI.Java.dto.ListOpenPositionsResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}
	
	/**
	 * !This is an auto generated method!
	 *
	 * Queries for a specified trading account's trades / open positions.
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
			result = call.callPostMethod(fullUrl, null, CIAPI.Java.dto.ListOpenPositionsResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}

	/**
	 * !This is an auto generated method!
	 *
	 * Queries for a specified trading account's active stop / limit orders.
	 */
	@Override
	public CIAPI.Java.dto.ListActiveStopLimitOrderResponseDTO ListActiveStopLimitOrders(int tradingAccountId, JsonApi api) throws ApiException {
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
			result = (CIAPI.Java.dto.ListActiveStopLimitOrderResponseDTO) api.callPostMethod(fullUrl, null, CIAPI.Java.dto.ListActiveStopLimitOrderResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}
	
	/**
	 * !This is an auto generated method!
	 *
	 * Queries for a specified trading account's active stop / limit orders.
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
			result = call.callPostMethod(fullUrl, null, CIAPI.Java.dto.ListActiveStopLimitOrderResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}

	/**
	 * !This is an auto generated method!
	 *
	 * Queries for a active stop limit order with a specified order id. It will return a null value if the order doesn't exist, or is not an active stop limit order.
	 */
	@Override
	public CIAPI.Java.dto.GetActiveStopLimitOrderResponseDTO GetActiveStopLimitOrder(String orderId, JsonApi api) throws ApiException {
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
			result = (CIAPI.Java.dto.GetActiveStopLimitOrderResponseDTO) api.callPostMethod(fullUrl, null, CIAPI.Java.dto.GetActiveStopLimitOrderResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}
	
	/**
	 * !This is an auto generated method!
	 *
	 * Queries for a active stop limit order with a specified order id. It will return a null value if the order doesn't exist, or is not an active stop limit order.
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
			result = call.callPostMethod(fullUrl, null, CIAPI.Java.dto.GetActiveStopLimitOrderResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}

	/**
	 * !This is an auto generated method!
	 *
	 * Queries for a trade / open position with a specified order id. It will return a null value if the order doesn't exist, or is not a trade / open position.
	 */
	@Override
	public CIAPI.Java.dto.GetOpenPositionResponseDTO GetOpenPosition(String orderId, JsonApi api) throws ApiException {
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
			result = (CIAPI.Java.dto.GetOpenPositionResponseDTO) api.callPostMethod(fullUrl, null, CIAPI.Java.dto.GetOpenPositionResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}
	
	/**
	 * !This is an auto generated method!
	 *
	 * Queries for a trade / open position with a specified order id. It will return a null value if the order doesn't exist, or is not a trade / open position.
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
			result = call.callPostMethod(fullUrl, null, CIAPI.Java.dto.GetOpenPositionResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}

	/**
	 * !This is an auto generated method!
	 *
	 * Queries for a specified trading account's trade history.
	 */
	@Override
	public CIAPI.Java.dto.ListTradeHistoryResponseDTO ListTradeHistory(int tradingAccountId, int maxResults, JsonApi api) throws ApiException {
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
			result = (CIAPI.Java.dto.ListTradeHistoryResponseDTO) api.callPostMethod(fullUrl, null, CIAPI.Java.dto.ListTradeHistoryResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}
	
	/**
	 * !This is an auto generated method!
	 *
	 * Queries for a specified trading account's trade history.
	 */
	@Override
	public Future<Object> ListTradeHistoryAsync(int tradingAccountId, int maxResults, AsyncJsonApi api, CallBack... callBacks) throws ApiException {
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
			result = call.callPostMethod(fullUrl, null, CIAPI.Java.dto.ListTradeHistoryResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}

	/**
	 * !This is an auto generated method!
	 *
	 * Queries for a specified trading account's stop / limit order history.
	 */
	@Override
	public CIAPI.Java.dto.ListStopLimitOrderHistoryResponseDTO ListStopLimitOrderHistory(int tradingAccountId, int maxResults, JsonApi api) throws ApiException {
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
			result = (CIAPI.Java.dto.ListStopLimitOrderHistoryResponseDTO) api.callPostMethod(fullUrl, null, CIAPI.Java.dto.ListStopLimitOrderHistoryResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}
	
	/**
	 * !This is an auto generated method!
	 *
	 * Queries for a specified trading account's stop / limit order history.
	 */
	@Override
	public Future<Object> ListStopLimitOrderHistoryAsync(int tradingAccountId, int maxResults, AsyncJsonApi api, CallBack... callBacks) throws ApiException {
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
			result = call.callPostMethod(fullUrl, null, CIAPI.Java.dto.ListStopLimitOrderHistoryResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}

	/**
	 * !This is an auto generated method!
	 *
	 * Queries for an order by a specific order id. The current implementation only returns active orders (i.e. those with a status of 1 - Pending, 2 - Accepted, 3 - Open, 6 - Suspended, 8 - Yellow Card, 11 - Triggered).
	 */
	@Override
	public CIAPI.Java.dto.GetOrderResponseDTO GetOrder(String orderId, JsonApi api) throws ApiException {
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
			result = (CIAPI.Java.dto.GetOrderResponseDTO) api.callPostMethod(fullUrl, null, CIAPI.Java.dto.GetOrderResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}
	
	/**
	 * !This is an auto generated method!
	 *
	 * Queries for an order by a specific order id. The current implementation only returns active orders (i.e. those with a status of 1 - Pending, 2 - Accepted, 3 - Open, 6 - Suspended, 8 - Yellow Card, 11 - Triggered).
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
			result = call.callPostMethod(fullUrl, null, CIAPI.Java.dto.GetOrderResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}

	/**
	 * !This is an auto generated method!
	 *
	 * Place a trade on a particular market
	 */
	@Override
	public CIAPI.Java.dto.ApiTradeOrderResponseDTO Trade(CIAPI.Java.dto.NewTradeOrderRequestDTO trade, JsonApi api) throws ApiException {
		// Collect variables from method
		String target = "order";
		String uriTemplate = "/trade";
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
		CIAPI.Java.dto.ApiTradeOrderResponseDTO result;
		if (transport.equals("GET")) {
			result = (CIAPI.Java.dto.ApiTradeOrderResponseDTO) api.callGetMethod(fullUrl, CIAPI.Java.dto.ApiTradeOrderResponseDTO.class);
		} else if (transport.equals("POST")) {
			result = (CIAPI.Java.dto.ApiTradeOrderResponseDTO) api.callPostMethod(fullUrl, trade, CIAPI.Java.dto.ApiTradeOrderResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}
	
	/**
	 * !This is an auto generated method!
	 *
	 * Place a trade on a particular market
	 */
	@Override
	public Future<Object> TradeAsync(CIAPI.Java.dto.NewTradeOrderRequestDTO trade, AsyncJsonApi api, CallBack... callBacks) throws ApiException {
		// Collect variables from method
		String target = "order";
		String uriTemplate = "/trade";
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
		Future<Object> result;
		if (transport.equals("GET")) {
			result = call.callGetMethod(fullUrl, CIAPI.Java.dto.ApiTradeOrderResponseDTO.class);
		} else if (transport.equals("POST")) {
			result = call.callPostMethod(fullUrl, trade, CIAPI.Java.dto.ApiTradeOrderResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}

	/**
	 * !This is an auto generated method!
	 *
	 * Update a trade
	 */
	@Override
	public CIAPI.Java.dto.ApiTradeOrderResponseDTO Update(CIAPI.Java.dto.UpdateTradeOrderRequestDTO update, JsonApi api) throws ApiException {
		// Collect variables from method
		String target = "order";
		String uriTemplate = "/update";
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
		CIAPI.Java.dto.ApiTradeOrderResponseDTO result;
		if (transport.equals("GET")) {
			result = (CIAPI.Java.dto.ApiTradeOrderResponseDTO) api.callGetMethod(fullUrl, CIAPI.Java.dto.ApiTradeOrderResponseDTO.class);
		} else if (transport.equals("POST")) {
			result = (CIAPI.Java.dto.ApiTradeOrderResponseDTO) api.callPostMethod(fullUrl, update, CIAPI.Java.dto.ApiTradeOrderResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}
	
	/**
	 * !This is an auto generated method!
	 *
	 * Update a trade
	 */
	@Override
	public Future<Object> UpdateAsync(CIAPI.Java.dto.UpdateTradeOrderRequestDTO update, AsyncJsonApi api, CallBack... callBacks) throws ApiException {
		// Collect variables from method
		String target = "order";
		String uriTemplate = "/update";
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
		Future<Object> result;
		if (transport.equals("GET")) {
			result = call.callGetMethod(fullUrl, CIAPI.Java.dto.ApiTradeOrderResponseDTO.class);
		} else if (transport.equals("POST")) {
			result = call.callPostMethod(fullUrl, update, CIAPI.Java.dto.ApiTradeOrderResponseDTO.class);
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
	public CIAPI.Java.dto.ErrorResponseDTO GenerateException(int errorCode, JsonApi api) throws ApiException {
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
		CIAPI.Java.dto.ErrorResponseDTO result;
		if (transport.equals("GET")) {
			result = (CIAPI.Java.dto.ErrorResponseDTO) api.callGetMethod(fullUrl, CIAPI.Java.dto.ErrorResponseDTO.class);
		} else if (transport.equals("POST")) {
			result = (CIAPI.Java.dto.ErrorResponseDTO) api.callPostMethod(fullUrl, null, CIAPI.Java.dto.ErrorResponseDTO.class);
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
			result = call.callGetMethod(fullUrl, CIAPI.Java.dto.ErrorResponseDTO.class);
		} else if (transport.equals("POST")) {
			result = call.callPostMethod(fullUrl, null, CIAPI.Java.dto.ErrorResponseDTO.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}

}

