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

	<@@methods@@>
	/**
	 * !This is an auto generated method!
	 *
	 * <@description@>
	 */
	@Override
	public <@return@> <@name@>(<@@parameters:,@@><@pType@> <@pName@><@@@@>, JsonApi api) 
												throws ApiException {
		// Collect variables from method
		String target = "<@target@>";
		String uriTemplate = "<@uriTemplate@>";
		String transport = "<@transport@>";
		String envelope = "<@envelope@>";
		String contentType = "<@contentType@>";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL if it is GET.
		if (transport.equals("GET")) {
			// Concatenating the empty string is a hackey way of converting all params to a String 
			<@@fillParameters@@>
			filledUri = filledUri.replace("{<@parameterName@>}", <@parameterName@> + "");<@@@@>
		}
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		<@return@> result;
		if (transport.equals("GET")) {
			result = (<@return@>) api.callGetMethod(fullUrl, <@return@>.class);
		} else if (transport.equals("POST")) {
			JsonObject obj = new JsonObject();
			<@@fillPostParams@@>
			obj.addProperty("<@name@>", g.toJson(<@name@>) + "");<@@@@>
			result = (<@return@>) api.callPostMethod(fullUrl, g.toJson(obj), <@return@>.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}
	
	/**
	 * !This is an auto generated method!
	 *
	 * <@description@>
	 */
	@Override
	public Future<Object> <@name@>Async(<@@parameters:,@@><@pType@> <@pName@><@@@@>, AsyncJsonApi api, CallBack... callBacks) throws ApiException {
		// Collect variables from method
		String target = "<@target@>";
		String uriTemplate = "<@uriTemplate@>";
		String transport = "<@transport@>";
		String envelope = "<@envelope@>";
		String contentType = "<@contentType@>";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL.
		if (transport.equals("GET")) {
			// Concatenating the empty string is a hackey way of converting all params to a String
			<@@fillParameters@@>
			filledUri = filledUri.replace("{<@parameterName@>}", <@parameterName@> + "");<@@@@>
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
			result = call.callGetMethod(fullUrl, <@return@>.class);
		} else if (transport.equals("POST")) {
			JsonObject obj = new JsonObject();
			<@@fillPostParams@@>
			obj.addProperty("<@name@>", g.toJson(<@name@>)  + "");<@@@@>
			result = call.callPostMethod(fullUrl, g.toJson(obj), <@return@>.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}<@@@@>
}
