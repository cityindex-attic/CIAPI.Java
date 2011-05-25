package CIAPI.Java.dto;

/**
 * !This is an auto generated model object!
 *
 * request to create a session (log on).
 */
public class ApiLogOnRequestDTO {

	/**
	 * No argument constructor 
	 */
	public ApiLogOnRequestDTO() {
	}
	
	private String UserName;
	
	/**
	 * Username is case sensitive
	 */
	public String getUserName() {
		return UserName;
	}
	
	public void setUserName(String UserName) {
		this.UserName = UserName;
	}
	private String Password;
	
	/**
	 * Password is case sensitive
	 */
	public String getPassword() {
		return Password;
	}
	
	public void setPassword(String Password) {
		this.Password = Password;
	}
}

