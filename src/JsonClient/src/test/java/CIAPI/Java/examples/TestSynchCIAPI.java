package CIAPI.Java.examples;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import CIAPI.Java.ApiException;
import CIAPI.Java.examples.ciapi.SyncApi;
import CIAPI.Java.examples.ciapi.dto.AccountInformationResponse;

public class TestSynchCIAPI {

	private SyncApi api;

	@Before
	public void setUp() throws Exception {
		api = new SyncApi("DM904310", "password");
	}

	@After
	public void tearDown() throws Exception {
		try {
			api.logoff();
		} catch (Exception e) {
			// ignore if the logoff fails
			// TODO stop ignoring this
		}
		api = null;
	}

	@Test
	public void testLogOn() throws ApiException {
		api.logon();
		assertTrue(api.isLoggedOn());
	}

	@Test
	public void testLogOnAndOff() throws ApiException {
		api.logon();
		assertTrue(api.isLoggedOn());
		api.logoff();
		assertTrue(!api.isLoggedOn());
	}

	@Test
	public void testGetClientAndTradingAccount() throws ApiException {
		api.logon();
		AccountInformationResponse result = api.getClientAndTradingAccount();
		assertNotNull(result);
	}
}
