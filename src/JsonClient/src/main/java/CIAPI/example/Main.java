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
		AccountInformationResponse accountInfo = api.getClientAndTradingAccount();
		TradingAccount one = accountInfo.getTradingAccounts().get(0);
		ListTradeHistoryResponse resp = api.listTradeHistory(one.getTradingAccountId(), 10);
		System.out.println("Done");
	}
}
