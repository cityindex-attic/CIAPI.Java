package CIAPI.Java.examples.ciapi.dto;

/**
 * !This is an auto generated model object!
 *
 * 
 */
public class LogOnRequestDTO {
	
	private String UserName;
	
	public LogOnRequestDTO(String username2, String password2) {
		UserName = username2;
		Password = password2;
	}

	public String getUserName() {
		return UserName;
	}
	

	private String Password;
	
	public String getPassword() {
		return Password;
	}
	

}

