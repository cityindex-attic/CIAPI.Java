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
		Object result = null;
		Class<?> retClazz = <@return@>.class;
		if (transport.equals("GET")) {
			result = (<@return@>) api.callGetMethod(fullUrl, <@return@>.class);
		} else if (transport.equals("POST")) {
			<@@fillPostParams1@@>
			result =  api.callPostMethod(fullUrl, g.toJson(<@name@>), retClazz);<@@@@>
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return (<@return@>) result;
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
		Future<Object> result = null;
		Class<?> retClazz = <@return@>.class;
		if (transport.equals("GET")) {
			result = call.callGetMethod(fullUrl, retClazz);
		} else if (transport.equals("POST")) {
			<@@fillPostParams2@@>
			result = call.callPostMethod(fullUrl, g.toJson(<@name@>), retClazz);<@@@@>
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}<@@@@>
}
