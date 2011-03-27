package <@packageName@>.impl;

import java.util.concurrent.Future;
import CIAPI.Java.ApiException;
import CIAPI.Java.JsonApi;
import <@packageName@>.ServiceMethods;

public class ServiceMethodsImpl implements ServiceMethods {

	<@@methods@@>
	/**
	 * !This is an auto generated method!
	 *
	 * <@description@>
	 */
	@Override
	public Future<Object> <@name@>Async(<@parameters@>, AsyncJsonApi api, CalBack... callBacks) throws ApiException {
		// Collect variables from method
		String target = "<@target@>";
		String uriTemplate = "<@uriTemplate@>";
		String transport = "<@transport@>";
		String envelope = "<@envelope@>";
		String contentType = "<@contentType@>";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL.
		// Concatenating the empty string is a hackey way of converting all params to a String
		<@@fillParameters@@>
		filledUri = filledUri.replace("{<@parameterName@>}", <@parameterName@> + "");<@@@@>
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		AsyncApiCall call = api.createNewCall();
		for (CallBack cb : callBacks) {
			call.addCallCompleteListener(cb);
		}
		Future<Object> result = call.callGetMethod(fullUrl, <@return@>);
		return result;
	}<@@@@>
}
