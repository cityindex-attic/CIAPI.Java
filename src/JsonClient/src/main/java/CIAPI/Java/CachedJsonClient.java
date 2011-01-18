package CIAPI.Java;

public class CachedJsonClient extends DefaultJsonClient {

	private Cache<Pair<String, Class<?>>, Object> cache;

	public CachedJsonClient(Cache<Pair<String, Class<?>>, Object> cache) {
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

	public static class Pair<T, S> {
		public final T one;
		public final S two;

		public Pair(T t, S s) {
			one = t;
			two = s;
		}
	}
}
