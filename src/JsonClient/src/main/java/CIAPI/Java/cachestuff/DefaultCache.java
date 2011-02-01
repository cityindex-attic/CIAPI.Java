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

	private Period maxAge;

	private int maxSize = 10000;

	private Map<TKey, CacheItem> storage;

	/**
	 * Creates an empty cache
	 * 
	 * @param maxAgeL
	 */
	public DefaultCache(long maxAgeL) {
		if (maxAgeL < 1)
			throw new IllegalArgumentException("The max age must be greater than 0");
		storage = new HashMap<TKey, CacheItem>();
		maxAge = new Period(maxAgeL);
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
		if (key == null)
			throw new NullPointerException("The key must not be null");
		CacheItem oldItem = storage.put(key, new CacheItem(value, new DateTime()));
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

	@Override
	public Period maxAge() {
		return maxAge;
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
		if (size < 1)throw new IllegalArgumentException("Size most be greater than 0");
		maxSize = size;
		if (cleanNow)
			clean();
	}

	class CacheItem {
		private TValue data;
		private DateTime timeEntered;

		private CacheItem(TValue data, DateTime timeCreated) {
			this.data = data;
			this.timeEntered = timeCreated;
		}

		private boolean isExpired() {
			return timeEntered.plus(maxAge).isBeforeNow();
		}
	}
}
