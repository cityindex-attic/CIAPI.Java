package CIAPI.Java.examples;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.http.client.ClientProtocolException;

import com.google.gson.Gson;

import CIAPI.Java.examples.urlshortener.GoogleGetResponse;
import CIAPI.Java.examples.urlshortener.GooglePostRequest;
import CIAPI.Java.examples.urlshortener.GooglePostResponse;
import CIAPI.Java.httpstuff.SimpleHttpClient;
import CIAPI.Java.urlstuff.UrlHelper;

/**
 * Client that uses generated files to make requests.
 * 
 * @author Justin Nelson
 * 
 */
public class FakeGoogleShortener implements SimpleHttpClient {

	private String shortUrlBase = "http://jst.in/";

	@Override
	public InputStream makeGetRequest(String url) throws ClientProtocolException, IOException {
		UrlHelper helper = UrlHelper.parseUrl(url);
		String shortUrl = helper.getParams().get("shortUrl");
		/*
		 * { "kind": "urlshortener#url", "id": "http://goo.gl/fbsS", "longUrl":
		 * "http://www.google.com/", "status": "OK" }
		 */
		GoogleGetResponse resp = new GoogleGetResponse("url#urlshortener", shortUrl, shortUrl, "OK");
		return null;
	}

	@Override
	public InputStream makePostRequest(String url, String content) throws ClientProtocolException, IOException {
		Gson g = new Gson();
		GooglePostRequest request = g.fromJson(content, GooglePostRequest.class);
		GooglePostResponse resp = new GooglePostResponse("url#longurl", longUrlToShort(request.getLongUrl()),
				request.getLongUrl());
		return new ByteArrayInputStream(resp.getId().getBytes());
	}

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
}
