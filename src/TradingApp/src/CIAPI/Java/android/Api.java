package CIAPI.Java.android;

import CIAPI.Java.ApiFActory;
import CIAPI.Java.SyncApi;

public class Api {

	private static SyncApi api;
	
	static {
		api = new ApiFActory().getSyncApi();
	}
	
	public static SyncApi getInstance(){
		return api;
	}
}
