package CIAPI.Java.async;

/**
 * Interface for specifying code that will be run after an Api call returns.
 * 
 * @author Justin Nelson
 * 
 */
public abstract class CallBack {
	/**
	 * This method is called after a AsyncApi request successfully returns.
	 * 
	 * @param result
	 *            The result computed from the method. The type is guaranteed to
	 *            be the type of the specified return type when the API was
	 *            called. You can safely cast it to type you specified.
	 * @param methodName
	 *            the name of the api method that was called.
	 * @param baseUrl
	 *            the base url of the REST Api.
	 */
	public abstract void doCallBack(Object result, String baseUrl, String methodName);

	/**
	 * This methods gets called if any exceptions are thrown while executing the
	 * async request. The default implementation does nothing. Subclasses can
	 * override this method if other functionality is desired.
	 * 
	 * @param e
	 *            the exception.
	 */
	public void handleException(Exception e) {
		// Intentionally blank. Subclasses can implement the behavior that they
		// want.
	}
}
