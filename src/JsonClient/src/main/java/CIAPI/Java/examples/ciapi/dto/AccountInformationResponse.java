package CIAPI.Java.examples.ciapi.dto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Class for representing the account information for a user.
 * 
 * @author Justin Nelson
 * 
 */
public class AccountInformationResponse {
	/**
	 * @return the type of currency that a user uses.  AN example of this would be 'GBP'
	 */
	public String getClientAccountCurrency() {
		return ClientAccountCurrency;
	}

	/**
	 * @return the users client account id
	 */
	public String getClientAccountId() {
		return ClientAccountId;
	}

	/**
	 * @return the full name of the currently logged on user
	 */
	public String getLogonUserName() {
		return LogonUserName;
	}

	/**
	 * @return an unmodifiable list of all of the trading accounts a user has
	 */
	public List<TradingAccount> getTradingAccounts() {
		return Collections.unmodifiableList(Arrays.asList(TradingAccounts));
	}

	private String ClientAccountCurrency;
	private String ClientAccountId;
	private String LogonUserName;
	private TradingAccount[] TradingAccounts;
}
