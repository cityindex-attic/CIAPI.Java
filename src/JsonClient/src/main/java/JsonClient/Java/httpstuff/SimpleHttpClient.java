package JsonClient.Java.httpstuff;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.client.ClientProtocolException;

/**
 * Interface for making http calls
 * 
 * @author justin nelson
 * 
 */
public interface SimpleHttpClient {
	/**
	 * Makes an Http GET call to the given Url
	 * 
	 * @param url
	 *            the url to make the call to
	 * @return the entity from the response
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public InputStream makeGetRequest(String url) throws ClientProtocolException, IOException;

	/**
	 * Makes an Http POST call to the given Url. Uses <code>content</code> as
	 * the request entity.
	 * 
	 * @param url
	 *            the url to make hte call to
	 * @param content
	 *            the content to give to the request entity.
	 * @return the entity of the response
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public InputStream makePostRequest(String url, String content) throws ClientProtocolException, IOException;
	
}
