package CIAPI.Java;


public class Api {
	private final String Api_Base_Url = "http://some.url";
	
	private JsonApi api;
	
	public Api(){
		api = new JsonApi(Api_Base_Url, new ThrottledCachedJsonClient());
	}
	
	public void logon(String username, String password) {
		
	}
}
