package CIAPI.Java.throttle;


import org.junit.After;
import org.junit.Before;

public class TestThrottleQueue {

	private ThrottledHttpClient client;
	
	@Before
	public void setUp() throws Exception {
		client = new ThrottledHttpClient();
	}

	@After
	public void tearDown() throws Exception {
	}

}
