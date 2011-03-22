package CIAPI.Java.examples;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import CIAPI.Java.ApiException;
import CIAPI.Java.examples.ciapi.SyncApi;

public class TestSynchCIAPI {

	private SyncApi api;

	@Before
	public void setUp() throws Exception {
		api = new SyncApi("DM904310", "password");
	}

	public void tearDown() throws Exception {
		api = null;
	}

	public void testLogOn() throws ApiException {
		// assertTrue(api.isLoggedOn());
	}

	public void testLogOnAndOff() throws ApiException {
		// assertTrue(api.isLoggedOn());
		// assertTrue(!api.isLoggedOn());
	}

	@Test
	public void testGetClientAndTradingAccount() throws ApiException {
	}
}
