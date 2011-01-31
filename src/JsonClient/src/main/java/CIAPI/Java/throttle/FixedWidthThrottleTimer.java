package CIAPI.Java.throttle;

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
		this.milliseconds = milliseconds;
		lastRequest = System.currentTimeMillis() - milliseconds;
	}

	@Override
	public boolean canMakeRequest() {
		return timeLeft() > milliseconds;
	}

	@Override
	public void madeRequest() {
		lastRequest = System.currentTimeMillis();
	}

	@Override
	public long timeLeft() {
		long diff = milliseconds - (System.currentTimeMillis() - lastRequest);
		return diff < 0 ? 0 : diff;
	}
}
