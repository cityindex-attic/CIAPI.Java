package examples.urlshortener;

/**
 * Class to encapsulate a call to create a new short URL
 * @author justin nelson
 *
 */
public class GooglePostRequest {

	final private String longUrl;

	/**
	 * Creates a new url request
	 * @param toShorten the url to shorten
	 */
	public GooglePostRequest(String toShorten) {
		longUrl = toShorten;
	}

	/**
	 * @return the long url that will be shortened
	 */
	public String getLongUrl() {
		return longUrl;
	}

}
