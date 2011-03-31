package CIAPI.Java.throttle;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import JsonClient.Java.throttle.RequestsPerTimespanTimer;

public class TestRequestsPerTimespanTimer {
	private long distance = 100;

	@Test
	public void testTimeLeft() throws InterruptedException {
		RequestsPerTimespanTimer timer = new RequestsPerTimespanTimer(100, 1000);
		for (int i = 0; i < 100; i++) {
			assertEquals(0, timer.timeLeft());
			timer.madeRequest();
		}
		assertTrue(1000 - timer.timeLeft() < 2);
		Thread.sleep(500);
		assertTrue(500 - timer.timeLeft() < 2);
	}

	@Test(expected = IllegalStateException.class)
	public void testCannotMakeRequest() {
		RequestsPerTimespanTimer timer = new RequestsPerTimespanTimer(10, 1000);
		for (int i = 0; i < 100; i++) {
			timer.madeRequest();
		}
		fail("Should have thrown Illegal State Exception");
	}

	/**
	 * Tests that the throttle works...
	 */
	@Test
	public void testThrottleReqPerSecond() {
		// 2 requests per second, for 2 seconds
		runRequests(2, 1000, 2000, 4);
		// 100 requests per second, for 1 second
		runRequests(100, 1000, 1000, 100);
		// 1 request per 100 milliseconds, for 1 second
		runRequests(1, 100, 1000, 10);
		// 13 requests per second, for half a second.
		// should get all 13 done in the half second
		runRequests(13, 1000, 500, 13);
	}

	private void runRequests(int numRequests, long timespan, long timeToRun, int expected) {
		RequestsPerTimespanTimer timer = new RequestsPerTimespanTimer(numRequests, timespan);
		int requestsMade = 0;
		int checksMade = 0;
		long startTime = System.currentTimeMillis();
		// loop for 1 second
		while (System.currentTimeMillis() - startTime < timeToRun) {
			checksMade++;
			if (timer.canMakeRequest()) {
				timer.madeRequest();
				requestsMade++;
			}
		}
		assertEquals("Did not make the expected number of requests.", expected, requestsMade);
	}
}
