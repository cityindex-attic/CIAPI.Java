package CIAPI.Java.android;


public class Api {

	private static SyncApi api;
	
	static {
		api = new ApiFActory().getSyncApi();
	}
	
	public static SyncApi getInstance(){
		return api;
	}
}
