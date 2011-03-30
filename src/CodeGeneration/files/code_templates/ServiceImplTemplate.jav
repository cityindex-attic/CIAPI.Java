package <@packageName@>.impl;

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
	public <@return@> <@name@>(<@parameters@>, JsonApi api) throws ApiException {
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
		// return type result type get/post url params return type.class
		<@return@> result = (<@return@>) api.callGetMethod(fullUrl, <@return@>.class);
		return result;
	}<@@@@>
}
