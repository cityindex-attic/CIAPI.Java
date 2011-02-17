package CIAPI.Java.examples.ciapi.dto;

/**
 * Basic DTO for representing the result of an attempted log off.
 * 
 * @author Justin Nelson
 * 
 */
public class DeleteSessionResponse {
	private boolean LoggedOut;

	/**
	 * @return whether or not the log off was successful
	 */
	public boolean getLoggedOut() {
		return LoggedOut;
	}
}
