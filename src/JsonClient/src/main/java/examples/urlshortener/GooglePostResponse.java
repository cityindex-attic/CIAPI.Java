package examples.urlshortener;

/**
 * Class to encapsulate the response of a Url POST
 * 
 * @author justin nelson
 * 
 */
public class GooglePostResponse {

	private String kind;
	private String id;
	private String longUrl;

	public GooglePostResponse(String kind, String id, String longUrl) {
		this.kind = kind;
		this.id = id;
		this.longUrl = longUrl;
	}
	
	public GooglePostResponse() {
	}

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
