package CIAPI.Java;

public interface JsonClient {

	public Object makeGetRequest(String url, Class<?> clazz) throws ApiException;
	public Object makePostRequest(String url, Object content, Class<?> clazz) throws ApiException;
	
}
