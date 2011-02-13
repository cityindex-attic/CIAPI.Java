package CIAPI.Java.throttle;

import org.apache.http.client.methods.HttpRequestBase;
import org.junit.After;
import org.junit.Before;

import CIAPI.Java.httpstuff.AbstractHttpRequestItem;

public class TestRequestQueue {

	private RequestQueue queue;

	@Before
	public void setUp() throws Exception {
		queue = new RequestQueue(new FixedWidthThrottleTimer(0));
	}

	@After
	public void tearDown() throws Exception {
		queue = null;
	}

	public void testAddItemToQueue() {
		
	}

}
