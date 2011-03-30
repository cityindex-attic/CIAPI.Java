package CIAPI.Java;

import CIAPI.Java.ApiException;

public class Main {
	public static void main(String[] args) throws ApiException {
		SyncApi api = new ApiFActory().getSyncApi();
		System.out.println(api.getSessionId());
		api.logIn("DM904310", "password", true);
		System.out.println(api.getSessionId());
	}
}
