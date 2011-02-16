package CIAPI;

public class CILogOnRequest {
	private String UserName;
	private String Password;

	public CILogOnRequest(String username, String password) {
		this.UserName = username;
		this.Password = password;
	}
}
