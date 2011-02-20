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
}
