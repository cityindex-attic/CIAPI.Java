package CIAPI.Java.dto;

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

	
	private CIAPI.Java.dto.PriceTickDTO[] PriceTicks;
	
	/**
	 * An array of price ticks, sorted in ascending order by PriceTick.TickDate
	 */
	public CIAPI.Java.dto.PriceTickDTO[] getPriceTicks() {
		return PriceTicks;
	}
	
	public void setPriceTicks(CIAPI.Java.dto.PriceTickDTO[] PriceTicks) {
		this.PriceTicks = PriceTicks;
	}

}

