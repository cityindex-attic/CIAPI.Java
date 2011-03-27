package CIAPI.Java.examples.ciapi.dto;

/**
 * !This is an auto generated model object!
 *
 * Response to a CreateSessionRequest
 */
public class CreateSessionResponseDTO {

	/**
	 * No argument constructor
	 */
	public CreateSessionResponseDTO() {
	}

	
	private String Session;
	
	/**
	 * 
	 * Your session token (treat as a random string) <BR /> Session tokens are valid for a set period from the time of their creation. <BR /> The period is subject to change, and may vary depending on who you logon as.
	 */
	public String getSession() {
		return Session;
	}

}

