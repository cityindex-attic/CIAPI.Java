package CIAPI.Java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import CIAPI.Java.httpstuff.FakeSimpleHttpClient;
import JsonClient.Java.ApiException;
import JsonClient.Java.DefaultJsonClient;
import JsonClient.Java.JsonApi;
import JsonClient.Java.JsonClient;
import examples.stackexchange.Site;
import examples.stackexchange.SitesWrapper;
import examples.stackexchange.StackExchangeStats;
import examples.stackexchange.StatsWrapper;

public class TestJsonClient {

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
	public void testSimpleRequest() throws ApiException {
		StatsWrapper result = (StatsWrapper) client.makeGetRequest("files/test/testStatsResponse.json",
				StatsWrapper.class);
		assertNotNull(result);
		StackExchangeStats stats = result.getStatistics()[0];
		Site site = stats.getSite();
		assertEquals("Stack Overflow", site.getName());
		assertEquals(1288773, stats.getTotal_questions());
	}

	@Test
	public void testJsonApi() throws ApiException {
		JsonApi api = new JsonApi("files/test", client);
		//api.callGetMethod("testStatsResponse.json", null, SitesWrapper.class);
		//api.callPostMethod("testStatsResponse.json", null, null, SitesWrapper.class);
	}

	@Test
	public void testApiExceptionMessage() {
		try {
			int i = (new int[10])[10];
			fail("Exception should have been thrown.");
		} catch (Exception e) {
			ApiException ex = new ApiException(e);
			assertNotNull(ex.getMessage());
			assertTrue(!ex.getMessage().equals(""));
		}
	}
}
