package CIAPI.Java.cachestuff;

import org.joda.time.Period;

/**
 * A basic cache interface
 * 
 * @author justin nelson
 * 
 * @param <TKey>
 *            the type of the key
 * @param <TValue>
 *            the type of the value
 */
public interface Cache<TKey, TValue> {

	/**
	 * Gets a value out of the Cache
	 * 
	 * @param key
	 *            the key to find
	 * @return the value with the given key
	 */
	public TValue get(TKey key);

	/**
	 * Puts a new entry into the Cache. Uses a default durration.
	 * 
	 * @param key
	 *            the new key
	 * @param value
	 *            the new value
	 * @return the value that was there before putting a new one. null if none.
	 */
	public TValue put(TKey key, TValue value);

	/**
	 * Puts a new entry into the cache
	 * 
	 * @param key
	 *            the new key
	 * @param value
	 *            the new value
	 * @param durration
	 *            the length of time to keep this item in the cache.
	 * @return the item previously bound to the key
	 */
	public TValue put(TKey key, TValue value, long durration);

	/**
	 * Gets the size of the cache
	 * 
	 * @return the number of key-value pairs in the cache
	 */
	public int entryCount();

	/**
	 * Removes a key from the cache
	 * 
	 * @param key
	 *            the key to remove
	 * @return the item that was saved at the key
	 */
	public TValue delete(TKey key);

	/**
	 * Removes all old entries from the cache
	 */
	public void clean();
}
