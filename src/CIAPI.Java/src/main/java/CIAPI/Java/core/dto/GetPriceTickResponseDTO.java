package CIAPI.Java.core.dto;

/**
 * !This is an auto generated model object!
 *
 * The response from a request for Price Ticks
 */
public class GetPriceTickResponseDTO {

	/**
	 * No argument constructor 
	 */
	public GetPriceTickResponseDTO() {
	}
	
	private PriceTickDTO[] PriceTicks;
	
	/**
	 * An array of price ticks, sorted in ascending order by PriceTick.TickDate
	 */
	public PriceTickDTO[] getPriceTicks() {
		return PriceTicks;
	}
	
	public void setPriceTicks(PriceTickDTO[] PriceTicks) {
		this.PriceTicks = PriceTicks;
	}
}

