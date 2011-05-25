package CIAPI.Java.dto;

/**
 * !This is an auto generated model object!
 *
 * Contains the result of a ListSpreadMarkets query
 */
public class ListSpreadMarketsResponseDTO {

	/**
	 * No argument constructor 
	 */
	public ListSpreadMarketsResponseDTO() {
	}
	
	private CIAPI.Java.dto.ApiMarketDTO[] Markets;
	
	/**
	 * A list of Spread Betting markets
	 */
	public CIAPI.Java.dto.ApiMarketDTO[] getMarkets() {
		return Markets;
	}
	
	public void setMarkets(CIAPI.Java.dto.ApiMarketDTO[] Markets) {
		this.Markets = Markets;
	}
}

