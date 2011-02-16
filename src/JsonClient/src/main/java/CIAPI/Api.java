package CIAPI;

import CIAPI.Java.JsonApi;
import CIAPI.Java.cachestuff.CachedJsonClient;
import CIAPI.Java.cachestuff.DefaultCache;
import CIAPI.Java.throttle.RequestsPerTimespanTimer;
import CIAPI.Java.throttle.ThrottledHttpClient;

public class Api {
	private final String Api_Base_Url = "http://some.url";

	private JsonApi api;

	public Api(String username, String password) {
		ThrottledHttpClient client = new ThrottledHttpClient(new RequestsPerTimespanTimer(10, 1000),
				new UsernamePasswordHttpRequestItemFactory(username, password));
		api = new JsonApi(Api_Base_Url, new CachedJsonClient(
				new DefaultCache<CachedJsonClient.Pair<String, Class<?>>, Object>(1000 * 60), client));
	}

	public void logon(String username, String password) {

	}
}
