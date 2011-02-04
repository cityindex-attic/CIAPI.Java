package CIAPI.Java.httpstuff;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.http.client.ClientProtocolException;

/**
 * HttpRequest implementation for testing.
 * 
 * @author justin nelson
 * 
 */
public class FakeHttpRequestItem implements HttpRequestItem {

	private String dataLocation;
	private InputStream result;
	
	public FakeHttpRequestItem(String responseDataLocation){
		dataLocation = responseDataLocation;
	}
	
	public FakeHttpRequestItem(String responseDataLocation, String data){
		this(responseDataLocation);
	}
	
	@Override
	public InputStream makeRequest() throws ClientProtocolException, IOException {
		result = new FileInputStream(new File(dataLocation));
		return result;
	}

	@Override
	public boolean isComplete() {
		return result != null;
	}

	@Override
	public InputStream getResult() {
		return result;
	}
}
