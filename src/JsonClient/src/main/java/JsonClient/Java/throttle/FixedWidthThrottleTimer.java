package JsonClient.Java.throttle;

/**
 * An implementation of a ThrottleTimer. This class specifies a fixed time
 * between requests.
 * 
 * @author justin nelson
 * 
 */
public class FixedWidthThrottleTimer implements ThrottleTimer {

	private long milliseconds;
	private long lastRequest;

	/**
	 * Creates a new ThrottleTimer that will wait milliseconds between calls.
	 * 
	 * @param milliseconds
	 *            the number of milliseconds to wait between calls.
	 */
	public FixedWidthThrottleTimer(long milliseconds) {
		if (milliseconds < 0)
			throw new IllegalArgumentException("Throttle time cannot be negative");
		this.milliseconds = milliseconds;
		lastRequest = System.currentTimeMillis() - milliseconds;
	}

	@Override
	public boolean canMakeRequest() {
		return timeLeft() == 0;
	}

	@Override
	public void madeRequest() {
		if (!canMakeRequest()) {
			throw new IllegalStateException("You cannot make a request yet.");
		}
		lastRequest = System.currentTimeMillis();
	}

	@Override
	public long timeLeft() {
		long diff = milliseconds - (System.currentTimeMillis() - lastRequest);
		return diff < 0 ? 0 : diff;
	}
}
