package CIAPI.Java;

/**
 * An exception to wrap any Exception that can happen while making an API call.
 * 
 * @author justin nelson
 * 
 */
public class ApiException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8553592640796987424L;

	/**
	 * Creates a new ApiException with the given Exception as the cause.
	 * 
	 * @param cause
	 */
	public ApiException(Exception cause) {
		super(cause);
	}

	@Override
	public String getMessage() {
		return "ApiException caused by:" + getCause().getMessage();
	}
}
