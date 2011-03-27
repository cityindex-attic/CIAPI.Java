package CIAPI.Java.examples.ciapi.dto;

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
	 * 
	 * ClientAccountIds that this session is authorized to work with
	 */
	public int[] getClientAccountIds() {
		return ClientAccountIds;
	}

	private int[] TradingAccountIds;
	
	/**
	 * 
	 * TradingAccountIds that this session is authorized to work with
	 */
	public int[] getTradingAccountIds() {
		return TradingAccountIds;
	}

	private boolean IsValid;
	
	/**
	 * 
	 * Whether this session token is still valid
	 */
	public boolean getIsValid() {
		return IsValid;
	}

}

