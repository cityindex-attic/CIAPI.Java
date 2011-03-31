package JsonClient.Java.throttle;

public class RequestsPerTimespanTimer implements ThrottleTimer {

	private int maxRequests;
	private long timespan;

	// Keeps track of the average requests per second
	private long intervalStartTime;
	private int requestsThisTimeSpan;

	public RequestsPerTimespanTimer(int requests, long timespan) {
		this.maxRequests = requests;
		this.timespan = timespan;
	}

	@Override
	public boolean canMakeRequest() {
		long currentTime = System.currentTimeMillis();
		long lengthSinceStartOfInterval = currentTime - intervalStartTime;
		if (lengthSinceStartOfInterval > timespan) {
			// start new timeSpan
			requestsThisTimeSpan = 0;
			intervalStartTime = currentTime;
		}
		return requestsThisTimeSpan < maxRequests;
	}

	@Override
	public long timeLeft() {
		if (canMakeRequest())
			return 0;
		else{
			// time until interval is over
			long currentTimePassed = System.currentTimeMillis() - intervalStartTime;
			long timeLeft = timespan - currentTimePassed;
			return timeLeft;
		}
	}

	@Override
	public void madeRequest() {
		if (!canMakeRequest())
			throw new IllegalStateException("You cannot currently make any more requests.");
		requestsThisTimeSpan++;
	}
}
