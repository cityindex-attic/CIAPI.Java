package CIAPI.Java.async;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import CIAPI.Java.DefaultJsonClient;
import CIAPI.Java.JsonClient;
import CIAPI.Java.examples.stackexchange.SitesWrapper;
import CIAPI.Java.httpstuff.FakeSimpleHttpClient;

public class TestAsyncApiCall {
	private JsonClient client;

	@Before
	public void setUp() throws Exception {
		client = new DefaultJsonClient(new FakeSimpleHttpClient());
	}

	@After
	public void tearDown() throws Exception {
		client = null;
	}

	@Test
	public void testSimpleRequest() {
		AsyncJsonApi api = new AsyncJsonApi("files/test/testStatsResponse.json", client);
		api.addUniversalCallBack(new CallBack() {
			@Override
			public void handleException(Exception e) {
			}
			@Override
			public void doCallBack(Object result) {
			}
		});
		AsyncApiCall call = api.createNewCall("");
		call.addCallCompleteListener(new CallBack() {
			@Override
			public void handleException(Exception e) {
				fail("No exception should have been thrown.");
			}

			@Override
			public void doCallBack(Object result) {
				assertTrue("Callback was called", true);
			}
		});
		try {
			call.beginCallGetMethod(null, SitesWrapper.class).get();
		} catch (InterruptedException e1) {
			fail("InterruptedException was thrown during the get method.");
		} catch (ExecutionException e1) {
			fail("ExecutionException was thrown during the get method: " + e1.getMessage());
		}
	}
}
