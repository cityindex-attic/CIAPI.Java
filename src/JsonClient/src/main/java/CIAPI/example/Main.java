package CIAPI.example;

import CIAPI.Java.ApiException;
import CIAPI.Java.examples.ciapi.SyncApi;
import CIAPI.Java.logging.Log;

public class Main {
	public static void main(String[] args) throws ApiException {
		SyncApi api = new SyncApi("DM904310", "password");
		api.logon();
	}
}
