package CIAPI.Java.dto;

/**
 * !This is an auto generated model object!
 *
 * 
 */
public class G2SessionValidationResponseDTO {

	/**
	 * No argument constructor
	 */
	public G2SessionValidationResponseDTO() {
	}

	
	private int[] ClientAccountIds;
	
	/**
	 * ClientAccountIds that this session is authorized to work with
	 */
	public int[] getClientAccountIds() {
		return ClientAccountIds;
	}
	
	public void setClientAccountIds(int[] ClientAccountIds) {
		this.ClientAccountIds = ClientAccountIds;
	}

	private int[] TradingAccountIds;
	
	/**
	 * TradingAccountIds that this session is authorized to work with
	 */
	public int[] getTradingAccountIds() {
		return TradingAccountIds;
	}
	
	public void setTradingAccountIds(int[] TradingAccountIds) {
		this.TradingAccountIds = TradingAccountIds;
	}

	private boolean IsValid;
	
	/**
	 * Whether this session token is still valid
	 */
	public boolean getIsValid() {
		return IsValid;
	}
	
	public void setIsValid(boolean IsValid) {
		this.IsValid = IsValid;
	}

}

