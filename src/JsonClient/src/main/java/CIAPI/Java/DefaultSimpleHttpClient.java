package CIAPI.Java;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.HttpEntityWrapper;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HttpContext;

/**
 * A very simple Http client for making GET and POST requests to a URL.
 * 
 * @author justin nelson
 * 
 */
public class DefaultSimpleHttpClient implements SimpleHttpClient {

	@Override
	public InputStream makeGetRequest(String url) throws ClientProtocolException, IOException {
		DefaultHttpClient client = new DefaultHttpClient();
		prepareClient(client);
		HttpGet get = new HttpGet(url);
		get.addHeader("Content-Type", "application/json");
		beforeRequest(client, get);
		HttpResponse response = client.execute(get);
		HttpEntity entity = response.getEntity();
		InputStream result = entity.getContent();
		return result;
	}

	@Override
	public InputStream makePostRequest(String url, String content) throws ClientProtocolException, IOException {
		DefaultHttpClient client = new DefaultHttpClient();
		prepareClient(client);
		HttpPost post = new HttpPost(url);
		post.addHeader("Content-Type", "application/json");
		HttpEntity postEntity;
		postEntity = new StringEntity(content);
		post.setEntity(postEntity);
		beforeRequest(client, post);
		HttpResponse response = client.execute(post);
		HttpEntity respEntity = response.getEntity();
		InputStream result = respEntity.getContent();
		return result;
	}

	/**
	 * Called directly before the request is made to the server.The default
	 * implementation does nothing. Subclasses can implement their own
	 * functionality.
	 * 
	 * @param client
	 *            the client making the request
	 * @param request
	 *            the request
	 */
	public void beforeRequest(DefaultHttpClient client, HttpRequestBase request) {
	}

	/**
	 * Called directly after the response returns. The default implementation
	 * does nothing. Subclasses can implement their own functionality.
	 * 
	 * @param response
	 *            the HttpResponse
	 */
	public void afterRequest(HttpResponse response) {
	}

	private static void prepareClient(DefaultHttpClient client) {
		client.addRequestInterceptor(new HttpRequestInterceptor() {
			public void process(final HttpRequest request, final HttpContext context) throws HttpException, IOException {
				if (!request.containsHeader("Accept-Encoding")) {
					request.addHeader("Accept-Encoding", "gzip");
				}
			}
		});
		client.addResponseInterceptor(new HttpResponseInterceptor() {
			@Override
			public void process(HttpResponse response, HttpContext context) throws HttpException, IOException {
				HttpEntity entity = response.getEntity();
				Header ceheader = entity.getContentEncoding();
				if (ceheader != null) {
					HeaderElement[] codecs = ceheader.getElements();
					for (int i = 0; i < codecs.length; i++) {
						if (codecs[i].getName().equalsIgnoreCase("gzip")) {
							response.setEntity(new GzipDecompressingEntity(response.getEntity()));
							return;
						}
					}
				}
			}
		});
	}

	static class GzipDecompressingEntity extends HttpEntityWrapper {

		public GzipDecompressingEntity(final HttpEntity entity) {
			super(entity);
		}

		@Override
		public InputStream getContent() throws IOException, IllegalStateException {
			// the wrapped entity's getContent() decides about repeatability
			InputStream wrappedin = wrappedEntity.getContent();
			return new GZIPInputStream(wrappedin);
		}

		@Override
		public long getContentLength() {
			// length of ungzipped content is not known
			return -1;
		}
	}

}
