package CIAPI.Java;

import CIAPI.Java.cachestuff.Cache;
import CIAPI.Java.cachestuff.CachedJsonClient;
import CIAPI.Java.cachestuff.DefaultCache;
import CIAPI.Java.httpstuff.DefaultHttpRequestItemFactory;
import CIAPI.Java.throttle.RequestQueue;
import CIAPI.Java.throttle.RequestsPerTimespanTimer;
import CIAPI.Java.throttle.ThrottleTimer;
import CIAPI.Java.throttle.ThrottledHttpClient;

/**
 * Convenience class for combining the cached client and throttled client
 * 
 * @author justin nelson
 * 
 */
public class ThrottledCachedJsonClient extends CachedJsonClient {

	/**
	 * Creates a new ThrottledCachedJsonClient with the given cache and timer
	 * 
	 * @param cache
	 *            the cache to use
	 * @param timer
	 *            the timer to use
	 */
	public ThrottledCachedJsonClient(Cache<Pair<String, Class<?>>, Object> cache, ThrottleTimer timer) {
		super(cache, new ThrottledHttpClient(new DefaultHttpRequestItemFactory(), new RequestQueue(timer)));
	}

	/**
	 * Uses a DefaultCache that times out after 1 minute and a
	 * RequestsPerTimespanTimer that allows 10 requests per second.
	 */
	public ThrottledCachedJsonClient() {
		this(new DefaultCache<Pair<String, Class<?>>, Object>(1000 * 60), new RequestsPerTimespanTimer(10, 1000));
	}
}
