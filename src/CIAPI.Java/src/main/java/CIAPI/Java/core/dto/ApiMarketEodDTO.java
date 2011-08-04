package CIAPI.Java.core.dto;

/**
 * !This is an auto generated model object!
 *
 * market end of day information.
 */
public class ApiMarketEodDTO {

	/**
	 * No argument constructor 
	 */
	public ApiMarketEodDTO() {
	}
	
	private String MarketEodUnit;
	
	/**
	 * Unit
	 */
	public String getMarketEodUnit() {
		return MarketEodUnit;
	}
	
	public void setMarketEodUnit(String MarketEodUnit) {
		this.MarketEodUnit = MarketEodUnit;
	}
	private int MarketEodAmount;
	
	/**
	 * End of day amount.
	 */
	public int getMarketEodAmount() {
		return MarketEodAmount;
	}
	
	public void setMarketEodAmount(int MarketEodAmount) {
		this.MarketEodAmount = MarketEodAmount;
	}
}

