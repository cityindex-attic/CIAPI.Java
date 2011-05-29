package CIAPI.Java.core.dto;

/**
 * !This is an auto generated model object!
 *
 * Get market information for a list of markets.
 */
public class ListMarketInformationRequestDTO {

	/**
	 * No argument constructor 
	 */
	public ListMarketInformationRequestDTO() {
	}
	
	private int[] MarketIds;
	
	/**
	 * The list of market ids
	 */
	public int[] getMarketIds() {
		return MarketIds;
	}
	
	public void setMarketIds(int[] MarketIds) {
		this.MarketIds = MarketIds;
	}
}

