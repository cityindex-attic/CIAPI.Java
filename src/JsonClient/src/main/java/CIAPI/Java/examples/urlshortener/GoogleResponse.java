package CIAPI.Java.examples.urlshortener;

public class GoogleResponse {
	/*
	 * { "kind": "urlshortener#url", "id": "http://goo.gl/fbsS", "longUrl":
	 * "http://www.google.com/" }
	 */

	private String kind;
	private String id;
	private String longUrl;

	public String getKind() {
		return kind;
	}

	public String getId() {
		return id;
	}

	public String getLongUrl() {
		return longUrl;
	}
}
