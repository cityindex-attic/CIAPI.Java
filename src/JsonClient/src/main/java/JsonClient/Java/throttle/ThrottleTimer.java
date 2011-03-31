package JsonClient.Java.throttle;

/**
 * Interface for specifying if a new can request can be made based on some
 * throttle criteria.
 * 
 * @author justin nelson
 * 
 */
public interface ThrottleTimer {

	/**
	 * @return Whether or not another request can be made based on the timer
	 *         criteria.
	 */
	public boolean canMakeRequest();

	/**
	 * @return the amount of milliseconds left this timer must wait
	 */
	public long timeLeft();

	/**
	 * Register that a request has been made with this object. (Doesn't actually
	 * make any kind of request.)
	 */
	public void madeRequest();

}
