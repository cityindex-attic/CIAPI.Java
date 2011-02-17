package CIAPI.Java.examples.ciapi.dto;

/**
 * The DTO for representing a LogOn response
 * 
 * @author justin nelson
 * 
 */
public class CreateSessionResponse {
	private String Session;

	/**
	 * The string that represents a user's session
	 * @return a session string
	 */
	public String getSession() {
		return Session;
	}
}
