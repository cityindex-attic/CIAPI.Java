package <@packageName@>;

public class ServiceMethods {

	<@@methods@@>
	/**
	 * !This is an auto generated method!
	 *
	 * <@description@>
	 */
	public <@return@> <@name@>(<@parameters@>) {
		String url = "";
		Object postContents = "";
		Map<String, String> params = new HashMap<String, String>();
		return api.call<@methodType@>Method(url, params, returnType);
	}
	<@@@@>
}
