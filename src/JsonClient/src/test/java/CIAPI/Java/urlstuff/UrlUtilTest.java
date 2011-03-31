package CIAPI.Java.urlstuff;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import JsonClient.Java.urlstuff.UrlHelper;

/**
 * Tests for the URL parsing of the API.
 * 
 * @author justin nelson
 * 
 */
public class UrlUtilTest {

	/**
	 * Tests parsing a poorly formatted URL
	 * 
	 * @throws MalformedURLException
	 */
	@Test(expected = MalformedURLException.class)
	public void testParseMalFormedUrl() throws MalformedURLException {
		String url = "http://somePl ainUrl.com";
		UrlHelper hlpr = UrlHelper.parseUrl(url);
		fail("Hmm, should have thrown an exception.");
	}

	/**
	 * Tests parsing a simple url with no extended directory part and no URL
	 * params.
	 * 
	 * @throws MalformedURLException
	 */
	@Test
	public void testParseSimpleUrl() throws MalformedURLException {
		String url = "http://somePlainUrl.com";
		UrlHelper hlpr = UrlHelper.parseUrl(url);
		assertEquals("Base url did not match the given base", url, hlpr.getBaseUrl());
		assertEquals("Extended url should have been empty", "", hlpr.getExtendedUrl());
		assertTrue("The params should have been empty", hlpr.getParams().isEmpty());
	}

	/**
	 * Tests parsing a simple url with a simple directory extension
	 * 
	 * @throws MalformedURLException
	 */
	@Test
	public void testSimpleExtendedUrl() throws MalformedURLException {
		String url = "http://somePlainUrl.com/extended/part";
		UrlHelper hlpr = UrlHelper.parseUrl(url);
		assertEquals("Base url did not match the given base", "http://somePlainUrl.com", hlpr.getBaseUrl());
		assertEquals("/extended/part", hlpr.getExtendedUrl());
		assertTrue("The params should have been empty", hlpr.getParams().isEmpty());
	}

	/**
	 * Tests parsing a url with parameters and no directory part
	 * 
	 * @throws MalformedURLException
	 */
	@Test
	public void testUrlWithParamsAndWithoutExtendedPart() throws MalformedURLException {
		String url = "http://somePlainUrl.com?parm1=1&parm2=2&parm3=3";
		UrlHelper hlpr = UrlHelper.parseUrl(url);
		assertEquals("Base url did not match the given base", "http://somePlainUrl.com", hlpr.getBaseUrl());
		assertEquals("", hlpr.getExtendedUrl());
		assertEquals("There should have been 3 params.", 3, hlpr.getParams().keySet().size());
		assertEquals("The first param should have been 1", "1", hlpr.getParams().get("parm1"));
		assertEquals("The 2nd param should have been 2", "2", hlpr.getParams().get("parm2"));
		assertEquals("The third param should have been 3", "3", hlpr.getParams().get("parm3"));
	}

	/**
	 * Tests parsing a url with an extended directory part, and url parameters
	 * 
	 * @throws MalformedURLException
	 */
	@Test
	public void testUrlWithParamsAndExtendedPart() throws MalformedURLException {
		String url = "http://somePlainUrl.com/extended/part?parm1=1&parm2=2&parm3=3";
		UrlHelper hlpr = UrlHelper.parseUrl(url);
		assertEquals("Base url did not match the given base", "http://somePlainUrl.com", hlpr.getBaseUrl());
		assertEquals("/extended/part", hlpr.getExtendedUrl());
		assertEquals("There should have been 3 params.", 3, hlpr.getParams().keySet().size());
		assertEquals("The first param should have been 1", "1", hlpr.getParams().get("parm1"));
		assertEquals("The 2nd param should have been 2", "2", hlpr.getParams().get("parm2"));
		assertEquals("The third param should have been 3", "3", hlpr.getParams().get("parm3"));
	}

	/**
	 * Tests creating URL strings from url helpers.
	 */
	@Test
	public void testTurnUrlHelpersINtoUrls() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("parms1", "1");
		params.put("parms2", "2");
		params.put("parms3", "3");
		String paramStringPart = "parms3=3&parms1=1&parms2=2&";
		UrlHelper hlpr1 = new UrlHelper("http://stackoverflow.com", null, null);
		String expected1 = "http://stackoverflow.com";
		UrlHelper hlpr2 = new UrlHelper("http://stackoverflow.com", "/users", null);
		String expected2 = "http://stackoverflow.com/users";
		UrlHelper hlpr3 = new UrlHelper("http://stackoverflow.com", null, params);
		String expected3 = "http://stackoverflow.com?" + paramStringPart;
		UrlHelper hlpr4 = new UrlHelper("http://stackoverflow.com", "/users", params);
		String expected4 = "http://stackoverflow.com/users?" + paramStringPart;
		assertEquals(expected1, hlpr1.toUrl());
		assertEquals(expected2, hlpr2.toUrl());
		assertEquals(expected3, hlpr3.toUrl());
		assertEquals(expected4, hlpr4.toUrl());
	}
}
