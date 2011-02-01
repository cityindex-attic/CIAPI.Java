package CIAPI.Java.examples.stackexchange;

import CIAPI.Java.ApiException;
import CIAPI.Java.JsonApi;
import CIAPI.Java.cachestuff.CachedJsonClient;
import CIAPI.Java.cachestuff.DefaultCache;
import CIAPI.Java.logging.Log;
import CIAPI.Java.throttle.ThrottledHttpClient;

public class Main {
	public static void main(String[] args) throws ApiException {
		JsonApi api = new JsonApi("http://api.stackoverflow.com/1.0/", new CachedJsonClient(
				new DefaultCache<CachedJsonClient.Pair<String, Class<?>>, Object>(1000), new ThrottledHttpClient()));
		StatsWrapper stats = (StatsWrapper) api.callGetMethod("stats", null, StatsWrapper.class);
		System.out.println(stats.statistics[0].getSite().getApi_endpoint());
		System.out.println(((StatsWrapper) api.callGetMethod("stats", null, StatsWrapper.class)).statistics[0]
		                                                                                    				.getSite().getDescription());
		System.out.println(((StatsWrapper) api.callGetMethod("stats", null, StatsWrapper.class)).statistics[0]
		                                                                                    				.getSite().getDescription());
		System.out.println(((StatsWrapper) api.callGetMethod("stats", null, StatsWrapper.class)).statistics[0]
		                                                                                    				.getSite().getDescription());
		System.out.println(((StatsWrapper) api.callGetMethod("stats", null, StatsWrapper.class)).statistics[0]
		                                                                                    				.getSite().getDescription());
		System.out.println(((StatsWrapper) api.callGetMethod("stats", null, StatsWrapper.class)).statistics[0]
		                                                                                    				.getSite().getDescription());
		try {
			Thread.sleep(100*60);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(((StatsWrapper) api.callGetMethod("stats", null, StatsWrapper.class)).statistics[0]
		                                                                                    				.getSite().getDescription());
		System.out.println(((StatsWrapper) api.callGetMethod("stats", null, StatsWrapper.class)).statistics[0]
		                                                                                    				.getSite().getDescription());
		System.out.println(((StatsWrapper) api.callGetMethod("stats", null, StatsWrapper.class)).statistics[0]
		                                                                                    				.getSite().getDescription());
		System.out.println(((StatsWrapper) api.callGetMethod("stats", null, StatsWrapper.class)).statistics[0]
		                                                                                    				.getSite().getDescription());
		Log.info("Hi");
	}
}
