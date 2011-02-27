package CIAPI.Java.cachestuff;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.joda.time.DateTime;
import org.joda.time.Period;

/**
 * Default implementation of a Cache. Backed by a hashmap
 * 
 * @author justin nelson
 * 
 * @param <TKey>
 * @param <TValue>
 */
public class DefaultCache<TKey, TValue> implements Cache<TKey, TValue> {

	private long defaultMaxAge;

	private int maxSize = 10000;

	private Map<TKey, CacheItem> storage;

	/**
	 * Creates an empty cache
	 * 
	 * @param defaultMaxAgeL
	 */
	public DefaultCache(long defaultMaxAgeL) {
		if (defaultMaxAgeL < 1)
			throw new IllegalArgumentException("The max age must be greater than 0");
		storage = new HashMap<TKey, CacheItem>();
		defaultMaxAge = defaultMaxAgeL;
	}

	@Override
	public TValue get(TKey key) {
		if (key == null)
			throw new NullPointerException("The key must not be null");
		CacheItem obj = storage.get(key);
		if (obj == null)
			return null;
		if (obj.isExpired()) {
			delete(key);
			return null;
		}
		return obj.data;
	}

	@Override
	public TValue put(TKey key, TValue value) {
		return put(key, value, defaultMaxAge);
	}

	@Override
	public TValue put(TKey key, TValue value, long durration) {
		if (key == null)
			throw new NullPointerException("The key must not be null");
		CacheItem oldItem = storage.put(key, new CacheItem(value, System.currentTimeMillis(), durration));
		if (entryCount() > maxSize)
			clean();
		return oldItem == null ? null : oldItem.data;
	}

	@Override
	public void clean() {
		Iterator<Entry<TKey, CacheItem>> iter = storage.entrySet().iterator();
		while (iter.hasNext()) {
			Entry<TKey, CacheItem> entry = iter.next();
			if (entry.getValue().isExpired())
				iter.remove();
		}
		// Should I make sure that size is below max size?
		// Deciding against it.
	}

	@Override
	public int entryCount() {
		return storage.size();
	}

	@Override
	public TValue delete(TKey key) {
		if (key == null)
			throw new NullPointerException("The key must not be null");
		return storage.remove(key).data;
	}

	/**
	 * Sets the maximum size of the cache
	 * 
	 * @param size
	 *            the new size of the cache
	 * @param cleanNow
	 *            whether or not to clean the cache now
	 */
	public void setMaxSize(int size, boolean cleanNow) {
		if (size < 1)
			throw new IllegalArgumentException("Size most be greater than 0");
		maxSize = size;
		if (cleanNow)
			clean();
	}

	class CacheItem {
		private TValue data;
		private long timeEntered;
		private long maxAge;

		private CacheItem(TValue data, long timeCreated, long maxAge) {
			this.data = data;
			this.timeEntered = timeCreated;
		}

		private boolean isExpired() {
			return timeEntered + maxAge < System.currentTimeMillis();
		}
	}
}
