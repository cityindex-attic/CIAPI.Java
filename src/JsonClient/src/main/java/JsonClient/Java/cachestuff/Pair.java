package JsonClient.Java.cachestuff;

/**
 * Simple pair class
 * 
 * @author justin nelson
 * 
 * @param <T>
 * @param <S>
 */
public class Pair<T, S> {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((one == null) ? 0 : one.hashCode());
		result = prime * result + ((two == null) ? 0 : two.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pair<?, ?> other = (Pair<?, ?>) obj;
		if (one == null) {
			if (other.one != null)
				return false;
		} else if (!one.equals(other.one))
			return false;
		if (two == null) {
			if (other.two != null)
				return false;
		} else if (!two.equals(other.two))
			return false;
		return true;
	}
}
