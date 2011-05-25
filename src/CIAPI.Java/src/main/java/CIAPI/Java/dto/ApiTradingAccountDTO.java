package CIAPI.Java.dto;

/**
 * !This is an auto generated model object!
 *
 * Information about a TradingAccount
 */
public class ApiTradingAccountDTO {

	/**
	 * No argument constructor 
	 */
	public ApiTradingAccountDTO() {
	}
	
	private int TradingAccountId;
	
	/**
	 * Trading Account Id
	 */
	public int getTradingAccountId() {
		return TradingAccountId;
	}
	
	public void setTradingAccountId(int TradingAccountId) {
		this.TradingAccountId = TradingAccountId;
	}
	private String TradingAccountCode;
	
	/**
	 * Trading Account Code
	 */
	public String getTradingAccountCode() {
		return TradingAccountCode;
	}
	
	public void setTradingAccountCode(String TradingAccountCode) {
		this.TradingAccountCode = TradingAccountCode;
	}
	private String TradingAccountStatus;
	
	/**
	 * Trading Account Status
	 */
	public String getTradingAccountStatus() {
		return TradingAccountStatus;
	}
	
	public void setTradingAccountStatus(String TradingAccountStatus) {
		this.TradingAccountStatus = TradingAccountStatus;
	}
	private String TradingAccountType;
	
	/**
	 * Trading Account Type
	 */
	public String getTradingAccountType() {
		return TradingAccountType;
	}
	
	public void setTradingAccountType(String TradingAccountType) {
		this.TradingAccountType = TradingAccountType;
	}
}

