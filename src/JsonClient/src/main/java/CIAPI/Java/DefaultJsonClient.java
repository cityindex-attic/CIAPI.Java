package CIAPI.Java;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.zip.GZIPInputStream;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.HttpEntityWrapper;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HttpContext;

import com.google.gson.Gson;

public class DefaultJsonClient implements JsonClient {

	/**
	 * Makes a generic GET request to the specified URL. Returns an object of
	 * type clazz.
	 */
	@Override
	public Object makeGetRequest(String url, Class<?> clazz) throws ApiException {
		DefaultHttpClient client = new DefaultHttpClient();
		prepareClient(client);
		HttpGet get = new HttpGet(url);
		get.addHeader("Content-Type", "application/json");
		try {
			HttpResponse response = client.execute(get);
			HttpEntity entity = response.getEntity();
			Gson g = new Gson();
			Object result = g.fromJson(new InputStreamReader(entity.getContent()), clazz);
			get.abort();
			return result;
		} catch (Exception e) {
			throw new ApiException(e);
		}
	}

	/**
	 * @param content
	 *            The content can be any object. It will get serialized into a
	 *            json string. Or you can pass a json string directly into the
	 *            content.
	 */
	@Override
	public Object makePostRequest(String url, Object content, Class<?> clazz) throws ApiException {
		Gson g = new Gson();
		DefaultHttpClient client = new DefaultHttpClient();
		prepareClient(client);
		HttpPost post = new HttpPost(url);
		post.addHeader("Content-Type", "application/json");
		HttpEntity postEntity;
		try {
			String strContent = (content instanceof String) ? (String) content : g.toJson(content);
			postEntity = new StringEntity(strContent);
			post.setEntity(postEntity);
		} catch (UnsupportedEncodingException e1) {
			throw new ApiException(e1);
		}
		try {
			HttpResponse response = client.execute(post);
			HttpEntity respEntity = response.getEntity();
			Object result = g.fromJson(new InputStreamReader(respEntity.getContent()), clazz);
			post.abort();
			return result;
		} catch (Exception e) {
			throw new ApiException(e);
		}
	}

	private static void prepareClient(DefaultHttpClient client) {
		client.addRequestInterceptor(new HttpRequestInterceptor() {
			public void process(final HttpRequest request, final HttpContext context)
					throws HttpException, IOException {
				if (!request.containsHeader("Accept-Encoding")) {
					request.addHeader("Accept-Encoding", "gzip");
				}
			}
		});
		client.addResponseInterceptor(new HttpResponseInterceptor() {
			@Override
			public void process(HttpResponse response, HttpContext context) throws HttpException,
					IOException {
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
