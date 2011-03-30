package CIAPI.Java.dto;

/**
 * !This is an auto generated model object!
 *
 * Information about a Market
 */
public class MarketDTO {

	/**
	 * No argument constructor
	 */
	public MarketDTO() {
	}

	
	private int MarketId;
	
	/**
	 * A market's unique identifier
	 */
	public int getMarketId() {
		return MarketId;
	}
	
	public void setMarketId(int MarketId) {
		this.MarketId = MarketId;
	}

	private String Name;
	
	/**
	 * The market name
	 */
	public String getName() {
		return Name;
	}
	
	public void setName(String Name) {
		this.Name = Name;
	}

}

