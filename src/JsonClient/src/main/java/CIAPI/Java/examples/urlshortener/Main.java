package CIAPI.Java.examples.urlshortener;

import CIAPI.Java.ApiException;
import CIAPI.Java.DefaultJsonClient;
import CIAPI.Java.JsonClient;

public class Main {
	public static void main(String[] args) throws ApiException {
		String shortUrl = "http://goo.gl/z3NcI";
		JsonClient client = new DefaultJsonClient();
		GoogleResponse postResp = (GoogleResponse) client.makePostRequest(
				"https://www.googleapis.com/urlshortener/v1/url", new GooglePostRequest(
						"http://www.facebook.com/"), GoogleResponse.class);
		System.out.println(postResp);
		GoogleResponse response = (GoogleResponse) client.makeGetRequest(
				"https://www.googleapis.com/urlshortener/v1/url?shortUrl=" + shortUrl, GoogleResponse.class);
		System.out.println(response);
	}
}
