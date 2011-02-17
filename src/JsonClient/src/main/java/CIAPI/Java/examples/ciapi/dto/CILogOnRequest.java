package CIAPI.Java.examples.ciapi.dto;

/**
 * DTO for representing a request to log on to the CIAPI
 * 
 * @author Justin Nelson
 * 
 */
public class CILogOnRequest {
	private String UserName;
	private String Password;

	/**
	 * Creates a basic LogOnRequest
	 * 
	 * @param username
	 *            the username to use
	 * @param password
	 *            the password to use
	 */
	public CILogOnRequest(String username, String password) {
		// null checks so GSON doesn't explode
		if (username == null)
			throw new NullPointerException("The username must not be null");
		if (password == null)
			throw new NullPointerException("The password must not be null");
		this.UserName = username;
		this.Password = password;
	}
}
