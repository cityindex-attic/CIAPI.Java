package CIAPI.Java;

import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;

public class HttpPostRequestItem extends HttpRequestItem {

	public HttpPostRequestItem(String url, String content) throws UnsupportedEncodingException {
		super(url);
		HttpEntity postEntity;
		postEntity = new StringEntity(content);
		((HttpPost) method).setEntity(postEntity);
	}

	@Override
	protected HttpRequestBase getRequestItem(String url) {
		return new HttpPost(url);
	}
}
