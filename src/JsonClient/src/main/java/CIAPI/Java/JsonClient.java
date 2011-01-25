package CIAPI.Java;

/**
 * Most basic JSON interface.<br />
 * Allows users to make a GET or POST request to a URL.
 * 
 * @author justin nelson
 * 
 */
public interface JsonClient {

	/**
	 * Makes a GET request to a given URL
	 * 
	 * @param url
	 *            the URL to call
	 * @param clazz
	 *            the return type of this method
	 * @return An Object of type <code>clazz</code>. Can safely be cast to the
	 *         proper return type.
	 * @throws ApiException
	 *             This can happen if any error happens between the creation of
	 *             the request to the parsing of the response.
	 */
	public Object makeGetRequest(String url, Class<?> clazz) throws ApiException;

	/**
	 * Makes a POST request to a given URL
	 * 
	 * @param url
	 *            the URL to call
	 * @param content
	 *            The object to pass to the request.
	 * @param clazz
	 *            the return type of this method
	 * @return An Object of type <code>clazz</code>. Can safely be cast to the
	 *         proper return type.
	 * @throws ApiException
	 *             This can happen if any error happens between the creation of
	 *             the request to the parsing of the response.
	 */
	public Object makePostRequest(String url, Object content, Class<?> clazz) throws ApiException;

}
