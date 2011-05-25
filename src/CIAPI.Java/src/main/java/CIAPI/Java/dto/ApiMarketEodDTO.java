package CIAPI.Java.dto;

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
	private String MarketEodAmount;
	
	/**
	 * End of day amount.
	 */
	public String getMarketEodAmount() {
		return MarketEodAmount;
	}
	
	public void setMarketEodAmount(String MarketEodAmount) {
		this.MarketEodAmount = MarketEodAmount;
	}
}

