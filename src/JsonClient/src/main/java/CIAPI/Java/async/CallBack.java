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
	 */
	public void doCallBack(Object result) throws ApiException;
}
