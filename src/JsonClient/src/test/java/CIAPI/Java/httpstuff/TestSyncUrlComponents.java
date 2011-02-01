package CIAPI.Java.httpstuff;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestSyncUrlComponents {

	private HttpRequestItem postTestItem;
	private HttpRequestItem getTestItem;

	@Before
	public void setUp() throws Exception {
		postTestItem = new HttpPostRequestItem("https://www.googleapis.com/urlshortener/v1/url",
				"{\"longUrl\": \"http://www.google.com/\"}");
		getTestItem = new HttpGetRequestItem("http://stackoverflow.com");
	}

	@After
	public void tearDown() throws Exception {
		postTestItem = null;
		getTestItem = null;
	}

	@Test
	public void testMakePassingRequests() throws ClientProtocolException, IOException {
		getTestItem.makeRequest();
		assertNotNull(getTestItem.getResult());
		postTestItem.makeRequest();
		assertNotNull(postTestItem.getResult());
	}

	@Test(expected = IOException.class)
	public void testMakeFailingGetRequests() throws ClientProtocolException, IOException {
		HttpRequestItem failGet = new HttpGetRequestItem("http://100.123.123.12");
		failGet.makeRequest();
	}

	@Test(expected = IOException.class)
	public void testMakeFailingPostRequest() throws ClientProtocolException, IOException {
		HttpRequestItem failPost = new HttpPostRequestItem("http://100.123.123.12", "fake content");
		failPost.makeRequest();
	}
}
