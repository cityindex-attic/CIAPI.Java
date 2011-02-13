package CIAPI.Java.async;

import CIAPI.Java.ApiException;

/**
 * Interface for specifying code that will be run after an Api call returns.
 * 
 * @author justin nelson
 * 
 */
public interface CallBack {
	/**
	 * This method is called after a AsyncApi request returns
	 * 
	 * @param result
	 *            The result computed from the method. Is guaranteed to be the
	 *            type of the specified return type when the API was called
	 * @throws ApiException
	 */
	public void doCallBack(Object result) throws ApiException;

	/**
	 * This methods gets called if any exceptions are thrown while executing the
	 * async request.
	 * 
	 * @param e
	 *            the exception.
	 */
	public void handleException(Exception e);
}
