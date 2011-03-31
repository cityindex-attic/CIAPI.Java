package JsonClient.Java.httpstuff;

import java.io.UnsupportedEncodingException;

public interface HttpRequestItemFactory {
	public HttpPostRequestItem getHttpPostRequestItem(String url, String content) throws UnsupportedEncodingException;

	public HttpGetRequestItem getHttpGetRequestItem(String url);
}
