package CIAPI.Java;

import org.joda.time.Period;

public interface Cache<TKey, TValue> {

	public TValue get(TKey key);
	public TValue put(TKey key, TValue value);
	public int entryCount();
	public TValue delete(TKey key);
	public void clean();
	public Period maxAge();
}
