package CIAPI.Java.httpstuff;

import java.io.UnsupportedEncodingException;

public class DefaultHttpRequestItemFactory implements HttpRequestItemFactory {

	@Override
	public HttpPostRequestItem getHttpPostRequestItem(String url, String content) 
		throws UnsupportedEncodingException {
		return new HttpPostRequestItem(url, content);
	}

	@Override
	public HttpGetRequestItem getHttpGetRequestItem(String url) {
		return new HttpGetRequestItem(url);
	}
}
