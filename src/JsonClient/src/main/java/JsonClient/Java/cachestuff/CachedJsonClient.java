package JsonClient.Java.cachestuff;

import CIAPI.Java.logging.Log;
import JsonClient.Java.ApiException;
import JsonClient.Java.DefaultJsonClient;
import JsonClient.Java.httpstuff.DefaultSimpleHttpClient;
import JsonClient.Java.httpstuff.SimpleHttpClient;

/**
 * An implementation of JsonClient that caches results of GET requests.
 * 
 * @author Justin Nelson
 * 
 */
public class CachedJsonClient extends DefaultJsonClient {

	private Cache<Pair<String, Class<?>>, Object> cache;

	/**
	 * Creates a new JsonClient with the given cache
	 * 
	 * @param cache
	 *            the cache to use
	 */
	public CachedJsonClient(Cache<Pair<String, Class<?>>, Object> cache) {
		this(cache, new DefaultSimpleHttpClient());
	}

	/**
	 * Creates a Cached Json Client with the given cache and the given Simple
	 * Http client for making requests
	 * 
	 * @param cache
	 *            the cache to use
	 * @param client
	 *            the http client to use
	 */
	public CachedJsonClient(Cache<Pair<String, Class<?>>, Object> cache, SimpleHttpClient client) {
		super(client);
		if (cache == null)
			throw new NullPointerException("The cache must not be null");
		this.cache = cache;
	}

	@Override
	public Object makeGetRequest(String url, Class<?> clazz) throws ApiException {
		return makeGetRequest(url, clazz, false);
	}

	/**
	 * Will make a get request and only use the cache entry for the item. If
	 * there is no cache entry, this method will return null.
	 * 
	 * @param url
	 * @param clazz
	 * @param onlyUseCache
	 * @return An item out of the cache.
	 * @throws ApiException
	 */
	public Object makeGetRequest(String url, Class<?> clazz, boolean onlyUseCache) throws ApiException {
		Object cacheResult = cache.get(new Pair<String, Class<?>>(url, clazz));
		if (onlyUseCache) {
			Log.debug("Forcing cache result.");
			return cacheResult;
		}
		if (cacheResult == null) {
			Object getResult = super.makeGetRequest(url, clazz);
			cache.put(new Pair<String, Class<?>>(url, clazz), getResult);
			return getResult;
		} else {
			Log.debug("Cache hit for url: " + url);
			return cacheResult;
		}
	}
}
