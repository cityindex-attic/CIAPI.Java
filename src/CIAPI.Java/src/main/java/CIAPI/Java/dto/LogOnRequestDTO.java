package CIAPI.Java.dto;

/**
 * !This is an auto generated model object!
 *
 * 
 */
public class LogOnRequestDTO {

	/**
	 * No argument constructor
	 */
	public LogOnRequestDTO() {
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

