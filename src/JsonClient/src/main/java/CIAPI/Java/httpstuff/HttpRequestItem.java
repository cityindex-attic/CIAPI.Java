package CIAPI.Java.httpstuff;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.client.ClientProtocolException;

public interface HttpRequestItem {

	/**
	 * Synchronously makes a request to a url
	 * 
	 * @return returns the resulting response entity
	 * 
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public InputStream makeRequest() throws ClientProtocolException, IOException;

	/**
	 * @return Whether or not this request has been completed
	 */
	public boolean isComplete();

	/**
	 * @return the resulting entity content
	 */
	public InputStream getResult();

}