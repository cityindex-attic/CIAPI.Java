package CIAPI.example;

import CIAPI.Java.ApiException;
import CIAPI.Java.examples.ciapi.SyncApi;

public class Main {
	public static void main(String[] args) throws ApiException {
		SyncApi api = new SyncApi("DM078963", "password");
		api.logon();
	}
}
