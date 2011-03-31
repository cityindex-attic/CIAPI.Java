package JsonClient.Java.httpstuff;

import java.io.UnsupportedEncodingException;

/**
 * Returns basic request items that does no manipulation of the request or
 * response.
 * 
 * @author Justin Nelson
 * 
 */
public class DefaultHttpRequestItemFactory implements HttpRequestItemFactory {

	@Override
	public HttpPostRequestItem getHttpPostRequestItem(String url, String content) throws UnsupportedEncodingException {
		return new HttpPostRequestItem(url, content);
	}

	@Override
	public HttpGetRequestItem getHttpGetRequestItem(String url) {
		return new HttpGetRequestItem(url);
	}
}
