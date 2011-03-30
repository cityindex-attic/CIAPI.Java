package CIAPI.Java.examples.ciapi;

import CIAPI.Java.cachestuff.Cache;
import CIAPI.Java.cachestuff.CachedJsonClient;
import CIAPI.Java.cachestuff.DefaultCache;
import CIAPI.Java.throttle.FixedWidthThrottleTimer;
import CIAPI.Java.throttle.RequestQueue;

/**
 * Interface for getting access to City Index trading API Java client.
 * 
 * @author Justin Nelson
 * 
 */
public class ApiFActory {

	public static final long DEFAULT_CACHE_TIME = 1000L;
	public static final long DEFAULT_REQUEST_WAIT_TIME = 10L;

	private String baseUrl = "http://ciapipreprod.cityindextest9.co.uk/TradingApi";
	private Cache<CachedJsonClient.Pair<String, Class<?>>, Object> cache = new DefaultCache<CachedJsonClient.Pair<String, Class<?>>, Object>(
			DEFAULT_CACHE_TIME);
	private RequestQueue queue = new RequestQueue(new FixedWidthThrottleTimer(DEFAULT_REQUEST_WAIT_TIME));

	/**
	 * Default constructor. All parameters are initialized to the defaults. What
	 * those are...nobody knows!
	 */
	public ApiFActory() {

	}

	/**
	 * The base URL is the site that this client will go to fetch data.
	 * 
	 * @return the currently configured base url
	 */
	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	/**
	 * The cache is used for holding data so that we don't have to fetch it from
	 * the remote server every time.
	 * 
	 * @return the current cache being used
	 */
	public Cache<CachedJsonClient.Pair<String, Class<?>>, Object> getCache() {
		return cache;
	}

	public void setCache(Cache<CachedJsonClient.Pair<String, Class<?>>, Object> cache) {
		this.cache = cache;
	}

	/**
	 * The request queue is the queue that all requests get placed on from this
	 * factory. This is how we determine throttling. If two requests are placed
	 * on separate queues they will be throttled independently
	 * 
	 * @return
	 */
	public RequestQueue getQueue() {
		return queue;
	}

	public void setQueue(RequestQueue queue) {
		this.queue = queue;
	}

	/**
	 * Uses current settings and creates a new sync api to use.
	 * 
	 * @return
	 */
	public SyncApi getSyncApi() {
		return new SyncApi(baseUrl, cache, queue);
	}

	/**
	 * Uses current settings and creates a new async api to use.
	 * 
	 * @return
	 */
	public AsyncApi getAsyncApi() {
		return new AsyncApi(baseUrl, cache, queue);
	}
}
