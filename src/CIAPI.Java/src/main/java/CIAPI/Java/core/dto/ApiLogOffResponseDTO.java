package CIAPI.Java.core.dto;

/**
 * !This is an auto generated model object!
 *
 * Response from a session delete request.
 */
public class ApiLogOffResponseDTO {

	/**
	 * No argument constructor 
	 */
	public ApiLogOffResponseDTO() {
	}
	
	private boolean LoggedOut;
	
	/**
	 * LogOut status
	 */
	public boolean getLoggedOut() {
		return LoggedOut;
	}
	
	public void setLoggedOut(boolean LoggedOut) {
		this.LoggedOut = LoggedOut;
	}
}

