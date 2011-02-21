package CIAPI.example;

import CIAPI.Java.ApiException;
import CIAPI.Java.examples.ciapi.SyncApi;
import CIAPI.Java.examples.ciapi.dto.AccountInformationResponse;

public class Main {
	public static void main(String[] args) throws ApiException {
		SyncApi api = new SyncApi("DM078963", "password");
		api.logon();
		api.getClientAndTradingAccount();
		try{
			api.logoff();
		} catch (Exception e) {
		}
		AccountInformationResponse resp = api.getClientAndTradingAccount();
		System.out.println("Done");
	}
}
