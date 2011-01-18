package CIAPI.Java;

public class ApiException extends Exception {

	private Exception cause;
	
	public ApiException(Exception cause){
		this.cause = cause;
	}
	
	@Override
	public String getMessage() {
		return "ApiException caused by:" + cause.getMessage();
	}
	
}
