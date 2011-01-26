package CIAPI.Java.cachestuff;

import CIAPI.Java.ApiException;
import CIAPI.Java.DefaultJsonClient;
import CIAPI.Java.httpstuff.DefaultSimpleHttpClient;
import CIAPI.Java.httpstuff.SimpleHttpClient;

/**
 * An implementation of JsonClient that caches results of GET requests.
 * 
 * @author justin nelson
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

	public CachedJsonClient(Cache<Pair<String, Class<?>>, Object> cache, SimpleHttpClient client) {
		super(client);
		this.cache = cache;
	}

	@Override
	public Object makeGetRequest(String url, Class<?> clazz) throws ApiException {
		Object cacheResult = cache.get(new Pair<String, Class<?>>(url, clazz));
		if (cacheResult == null) {
			Object getResult = super.makeGetRequest(url, clazz);
			cache.put(new Pair<String, Class<?>>(url, clazz), getResult);
			return getResult;
		} else {
			return cacheResult;
		}
	}

	/**
	 * Simple pair class
	 * 
	 * @author justin nelson
	 * 
	 * @param <T>
	 * @param <S>
	 */
	public static class Pair<T, S> {
		/**
		 * Item 1
		 */
		public final T one;
		/**
		 * Item 2
		 */
		public final S two;

		/**
		 * Creates a new pair with the given data
		 * 
		 * @param t
		 *            item 1
		 * @param s
		 *            item 2
		 */
		public Pair(T t, S s) {
			one = t;
			two = s;
		}
	}
}
