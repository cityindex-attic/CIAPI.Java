package CIAPI.Java.httpstuff;

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
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.HttpEntityWrapper;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HttpContext;

import CIAPI.Java.logging.Log;

/**
 * Class representing a request to a given url
 * 
 * @author justin nelson
 * 
 */
public abstract class HttpRequestItem {

	protected DefaultHttpClient client;
	protected HttpRequestBase method;
	private String url;

	/**
	 * Creates a new Request item.
	 * 
	 * @param url
	 *            the url to request
	 */
	public HttpRequestItem(String url) {
		this.url = url;
		client = new DefaultHttpClient();
		prepareClient(client);
		method = getRequestItem(url);
		method.addHeader("Content-Type", "application/json");
	}

	protected abstract HttpRequestBase getRequestItem(String url);

	private InputStream result;
	private boolean complete = false;

	/**
	 * Synchronously makes a request to a url
	 * 
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public void makeRequest() throws ClientProtocolException, IOException {
		Log.trace("Executing request:" + url);
		HttpResponse response = client.execute(method);
		HttpEntity entity = response.getEntity();
		result = entity.getContent();
		complete = true;
	}

	/**
	 * @return Whether or not this request has been completed
	 */
	public boolean isComplete() {
		return complete;
	}

	/**
	 * @return the resulting entity content
	 */
	public InputStream getResult() {
		return result;
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
