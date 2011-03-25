package CIAPI.Java.examples.ciapi;

import CIAPI.Java.cachestuff.Cache;
import CIAPI.Java.cachestuff.CachedJsonClient;
import CIAPI.Java.cachestuff.DefaultCache;
import CIAPI.Java.throttle.FixedWidthThrottleTimer;
import CIAPI.Java.throttle.RequestQueue;

public class SyncApiFActory {

	public static final long DEFAULT_CACHE_TIME = 1000L;
	public static final long DEFAULT_REQUEST_WAIT_TIME = 10L;

	private String baseUrl = "http://ciapipreprod.cityindextest9.co.uk/TradingApi";
	private Cache<CachedJsonClient.Pair<String, Class<?>>, Object> cache = new DefaultCache<CachedJsonClient.Pair<String, Class<?>>, Object>(
			DEFAULT_CACHE_TIME);
	private RequestQueue queue = new RequestQueue(new FixedWidthThrottleTimer(DEFAULT_REQUEST_WAIT_TIME));

	public SyncApiFActory() {

	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public Cache<CachedJsonClient.Pair<String, Class<?>>, Object> getCache() {
		return cache;
	}

	public void setCache(Cache<CachedJsonClient.Pair<String, Class<?>>, Object> cache) {
		this.cache = cache;
	}

	public RequestQueue getQueue() {
		return queue;
	}

	public void setQueue(RequestQueue queue) {
		this.queue = queue;
	}

	public SyncApi getApi() {
		return new SyncApi(baseUrl, cache, queue);
	}
}
