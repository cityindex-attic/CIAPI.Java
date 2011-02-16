package CIAPI.Java.examples.urlshortener;

/**
 * 
 * @author Justin Nelson
 * 
 */
public class GoogleGetResponse {

	private String kind;
	private String id;
	private String longUrl;
	private String status;

	public GoogleGetResponse() {
	}

	public GoogleGetResponse(String kind, String id, String longUrl, String status) {
		this.kind = kind;
		this.id = id;
		this.longUrl = longUrl;
		this.status = status;
	}

	public String getKind() {
		return kind;
	}

	public String getId() {
		return id;
	}

	public String getLongUrl() {
		return longUrl;
	}

	public String getStatus() {
		return status;
	}
}
