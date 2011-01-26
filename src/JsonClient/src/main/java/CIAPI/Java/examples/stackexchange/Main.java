package CIAPI.Java.examples.stackexchange;

import CIAPI.Java.ApiException;
import CIAPI.Java.DefaultJsonClient;
import CIAPI.Java.JsonApi;
import CIAPI.Java.throttle.ThrottledHttpClient;

public class Main {
	public static void main(String[] args) throws ApiException {
		JsonApi api = new JsonApi("http://api.stackoverflow.com/1.0/", 
				new DefaultJsonClient(new ThrottledHttpClient()));
		StatsWrapper stats = (StatsWrapper) api.callGetMethod("stats", null, StatsWrapper.class);
		System.out.println(stats.statistics[0].getSite().getApi_endpoint());
	}
}
