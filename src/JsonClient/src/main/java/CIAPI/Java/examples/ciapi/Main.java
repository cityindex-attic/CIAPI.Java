package CIAPI.Java.examples.ciapi;

import CIAPI.Java.ApiException;

public class Main {
	public static void main(String[] args) throws ApiException {
		SyncApi api = new ApiFActory().getSyncApi();
		api.logIn("DM078963", "password", true);
	}
}
