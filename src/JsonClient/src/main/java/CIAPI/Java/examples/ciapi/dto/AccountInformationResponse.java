package CIAPI.Java.examples.ciapi.dto;

public class AccountInformationResponse {
	public String getClientAccountCurrency() {
		return ClientAccountCurrency;
	}

	public String getClientAccountId() {
		return ClientAccountId;
	}

	public String getLogonUserName() {
		return LogonUserName;
	}

	public TradingAccount[] getTradingAccounts() {
		return TradingAccounts;
	}

	private String ClientAccountCurrency;
	private String ClientAccountId;
	private String LogonUserName;
	private TradingAccount[] TradingAccounts;
	/*
	 * {
	 * 		"ClientAccountCurrency":"GBP",
	 * 		"ClientAccountId":400125401,
	 * 		"LogonUserName":"Mr David Laing - Test",
	 * 		"TradingAccounts":[
	 * 			{
	 * 				"TradingAccountCode":"DM904310",
	 * 				"TradingAccountId":400184832,
	 * 				"TradingAccountStatus":"Open",
	 * 				"TradingAccountType":"CFD"
	 * 			},
	 * 			{
	 * 				"TradingAccountCode":"DM653075",
	 * 				"TradingAccountId":400184833,
	 * 				"TradingAccountStatus":"Open",
	 * 				"TradingAccountType":"Spread Betting"
	 * 			}
	 * 		]
	 * }
	 */
}
