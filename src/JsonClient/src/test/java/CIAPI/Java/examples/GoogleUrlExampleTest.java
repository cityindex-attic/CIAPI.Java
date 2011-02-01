package CIAPI.Java.examples;


import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import CIAPI.Java.ApiException;
import CIAPI.Java.DefaultJsonClient;
import CIAPI.Java.JsonApi;
import CIAPI.Java.examples.urlshortener.GooglePostRequest;
import CIAPI.Java.examples.urlshortener.GoogleResponse;

public class GoogleUrlExampleTest {

	private JsonApi api;
	
	private GooglePostRequest stackoverflowReq;
	private GooglePostRequest facebookReq;
	
	private final String stackoverflow = "http://stackoverflow.com/";
	private final String facebook = "http://facebook.com/";
	
	@Before
	public void setUp() throws Exception {
		stackoverflowReq = new GooglePostRequest(stackoverflow);
		facebookReq = new GooglePostRequest(facebook);
		api = new JsonApi("https://www.googleapis.com/urlshortener/v1/url", new DefaultJsonClient());
	}

	@After
	public void tearDown() throws Exception {
		stackoverflowReq = null;
		facebookReq = null;
	}

	@Test
	public void testSyncPost() throws ApiException{
		Map<String, String> params = new HashMap<String, String>();
		params.put("key", "AIzaSyCYMdrcIDWDf6YFFzyFjA2HCEbfazSkf_M");
		GoogleResponse response = (GoogleResponse) api.callPostMethod("", params, stackoverflowReq, GoogleResponse.class);
		assertEquals("The id of the response did not match the request.", stackoverflow, response.getLongUrl());
		assertEquals("The kind of response was not expected.", "urlshortener#url", response.getKind());
	}
	
}
