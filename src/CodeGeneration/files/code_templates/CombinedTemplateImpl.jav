package <@packageName@>.impl;

import java.util.concurrent.Future;
import CIAPI.Java.ApiException;
import CIAPI.Java.JsonApi;
import CIAPI.Java.async.AsyncJsonApi;
import CIAPI.Java.async.CallBack;
import CIAPI.Java.async.AsyncApiCall;
import <@packageName@>.ServiceMethods;

public class ServiceMethodsImpl implements ServiceMethods {

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
			result = (<@return@>) api.callPostMethod(fullUrl, <@postParam@>, <@return@>.class);
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
			result = call.callPostMethod(fullUrl, <@postParam@>, <@return@>.class);
		} else {
			throw new IllegalArgumentException("Unexpected transport type: " + transport);
		}
		return result;
	}<@@@@>
}
