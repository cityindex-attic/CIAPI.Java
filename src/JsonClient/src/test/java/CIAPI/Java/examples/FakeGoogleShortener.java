package CIAPI.Java.examples;

import java.io.ByteArrayInputStream;
import java.net.MalformedURLException;

import CIAPI.Java.RequestTranslator;
import CIAPI.Java.examples.urlshortener.GoogleGetResponse;
import CIAPI.Java.examples.urlshortener.GooglePostRequest;
import CIAPI.Java.examples.urlshortener.GooglePostResponse;
import CIAPI.Java.urlstuff.UrlHelper;

import com.google.gson.Gson;

/**
 * Client that uses generated files to make requests.
 * 
 * @author Justin Nelson
 * 
 */
public class FakeGoogleShortener implements RequestTranslator {

	private String shortUrlBase = "http://jst.in/";

	/**
	 * Takes a long url and creates a short one *not really*
	 * 
	 * @param longUrl
	 *            the long url to shorten
	 * @return a new short url
	 */
	public String longUrlToShort(String longUrl) {
		return shortUrlBase + longUrl.hashCode();
	}

	@Override
	public Object translateGetRequest(String url, Class<?> clazz) {
		UrlHelper helper = null;
		try {
			helper = UrlHelper.parseUrl(url);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		String shortUrl = helper.getParams().get("shortUrl");
		/*
		 * { "kind": "urlshortener#url", "id": "http://goo.gl/fbsS", "longUrl":
		 * "http://www.google.com/", "status": "OK" }
		 */
		GoogleGetResponse resp = new GoogleGetResponse("url#urlshortener", shortUrl, shortUrl, "OK");
		return resp;
	}

	@Override
	public Object translatePostRequest(String url, Object content, Class<?> clazz) {
		Gson g = new Gson();
		GooglePostRequest request = g.fromJson((String)content, GooglePostRequest.class);
		GooglePostResponse resp = new GooglePostResponse("url#longurl", longUrlToShort(request.getLongUrl()),
				request.getLongUrl());
		return new ByteArrayInputStream(resp.getId().getBytes());
	}
}
