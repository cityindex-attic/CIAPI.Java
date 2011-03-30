package <@packageName@>;

import java.util.concurrent.Future;
import CIAPI.Java.ApiException;
import CIAPI.Java.JsonApi;
import CIAPI.Java.async.AsyncJsonApi;
import CIAPI.Java.async.CallBack;

/**
 * Auto-generated interface for interacting with the REST CIAPI
 * 
 */
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
	public <@return@> <@name@>(<@parameters@>, JsonApi api) throws ApiException; 
	
	/**
	 * !This is an auto generated method signature!
	 *
	 * <@description@>
	 *
	 * <@@parameterDescriptions@@>
	 * @param <@paramName@> <@paramDesc@><@@@@>
	 * @param api The AsyncJsonApi implementation that you would like.
	 */
	public Future<Object> <@name@>Async(<@parameters@>, AsyncJsonApi api, CallBack... callBacks) throws ApiException; <@@@@>
}
