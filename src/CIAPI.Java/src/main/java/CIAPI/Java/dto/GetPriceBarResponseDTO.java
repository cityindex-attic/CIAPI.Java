package CIAPI.Java.dto;

/**
 * !This is an auto generated model object!
 *
 * The response from a GET price bar history request. Contains both an array of finalized price bars, and a partial (not finalized) bar for the current period
 */
public class GetPriceBarResponseDTO {

	/**
	 * No argument constructor 
	 */
	public GetPriceBarResponseDTO() {
	}
	
	private CIAPI.Java.dto.PriceBarDTO[] PriceBars;
	
	/**
	 * An array of finalized price bars, sorted in ascending order based on PriceBar.BarDate
	 */
	public CIAPI.Java.dto.PriceBarDTO[] getPriceBars() {
		return PriceBars;
	}
	
	public void setPriceBars(CIAPI.Java.dto.PriceBarDTO[] PriceBars) {
		this.PriceBars = PriceBars;
	}
	private CIAPI.Java.dto.PriceBarDTO PartialPriceBar;
	
	/**
	 * The (non-finalized) price bar data for the current period (i.e, the period that hasn't yet completed)
	 */
	public CIAPI.Java.dto.PriceBarDTO getPartialPriceBar() {
		return PartialPriceBar;
	}
	
	public void setPartialPriceBar(CIAPI.Java.dto.PriceBarDTO PartialPriceBar) {
		this.PartialPriceBar = PartialPriceBar;
	}
}

