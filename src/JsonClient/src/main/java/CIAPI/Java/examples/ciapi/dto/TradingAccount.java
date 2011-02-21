package CIAPI.Java.examples.ciapi.dto;

/**
 * Class representing a trading account
 * 
 * @author Justin Nelson
 * 
 */
public class TradingAccount {

	private String TradingAccountCode;
	private int TradingAccountId;
	private String TradingAccountStatus;
	private String TradingAccountType;

	/**
	 * @return the Trading Account Code for this trading account
	 */
	public String getTradingAccountCode() {
		return TradingAccountCode;
	}

	/**
	 * @return the Trading Account Id for this account
	 */
	public int getTradingAccountId() {
		return TradingAccountId;
	}

	/**
	 * @return The status of this trading account
	 */
	public String getTradingAccountStatus() {
		return TradingAccountStatus;
	}

	/**
	 * @return the type of this trading account
	 */
	public String getTradingAccountType() {
		return TradingAccountType;
	}
}
