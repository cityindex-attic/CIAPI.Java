package CIAPI.Java.core.dto;

/**
 * !This is an auto generated model object!
 *
 * request to delete a session (log off)
 */
public class ApiLogOffRequestDTO {

	/**
	 * No argument constructor 
	 */
	public ApiLogOffRequestDTO() {
	}
	
	private String UserName;
	
	/**
	 * user name of the session to delete (log off).
	 */
	public String getUserName() {
		return UserName;
	}
	
	public void setUserName(String UserName) {
		this.UserName = UserName;
	}
	private String Session;
	
	/**
	 * session identifier of the session to delete (log off).
	 */
	public String getSession() {
		return Session;
	}
	
	public void setSession(String Session) {
		this.Session = Session;
	}
}

