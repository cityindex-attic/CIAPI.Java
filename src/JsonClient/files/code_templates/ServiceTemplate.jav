package <@packageName@>;

import CIAPI.Java.ApiException;
import CIAPI.Java.JsonApi;

public interface ServiceMethods {

	<@@methods@@>
	/**
	 * !This is an auto generated method signature!
	 *
	 * <@description@>
	 *
	 * <@@parameterDescriptions@@>
	 * @param <@paramName@> <@paramDesc@><@@@@>
	 * @param api The JsonApi implementation that you would like.
	 */
	public <@return@> <@name@>(<@parameters@>, JsonApi api) throws ApiException; <@@@@>
}
