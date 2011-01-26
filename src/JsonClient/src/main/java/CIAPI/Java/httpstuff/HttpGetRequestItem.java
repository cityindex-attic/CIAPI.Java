package CIAPI.Java.httpstuff;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;


public class HttpGetRequestItem extends HttpRequestItem {

	public HttpGetRequestItem(String url) {
		super(url);
	}

	@Override
	protected HttpRequestBase getRequestItem(String url) {
		return new HttpGet(url);
	}
}
