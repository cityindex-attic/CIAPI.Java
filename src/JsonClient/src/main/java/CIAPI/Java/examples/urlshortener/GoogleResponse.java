package CIAPI.Java.examples.urlshortener;

/**
 * Class to encapsulate the response of a Url POST
 * @author justin nelson
 *
 */
public class GoogleResponse {

	private String kind;
	private String id;
	private String longUrl;

	/**
	 * @return the kind of url this is (long or short)
	 */
	public String getKind() {
		return kind;
	}

	/**
	 * @return the short url
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the long url
	 */
	public String getLongUrl() {
		return longUrl;
	}
}
