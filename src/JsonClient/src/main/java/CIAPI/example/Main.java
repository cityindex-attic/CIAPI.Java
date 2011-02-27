package CIAPI.example;

import CIAPI.Java.ApiException;
import CIAPI.Java.examples.ciapi.SyncApi;
import CIAPI.Java.examples.ciapi.dto.AccountInformationResponse;
import CIAPI.Java.examples.ciapi.dto.ListTradeHistoryResponse;
import CIAPI.Java.examples.ciapi.dto.TradingAccount;

public class Main {
	public static void main(String[] args) throws ApiException {
		SyncApi api = new SyncApi("DM078963", "password");
		api.logon();
		api.order();
	}
}
