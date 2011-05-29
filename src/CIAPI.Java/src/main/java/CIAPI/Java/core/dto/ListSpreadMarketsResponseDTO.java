package CIAPI.Java.core.dto;

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
	
	private ApiMarketDTO[] Markets;
	
	/**
	 * A list of Spread Betting markets
	 */
	public ApiMarketDTO[] getMarkets() {
		return Markets;
	}
	
	public void setMarkets(ApiMarketDTO[] Markets) {
		this.Markets = Markets;
	}
}

