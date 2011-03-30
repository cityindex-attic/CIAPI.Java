package CIAPI.Java.examples.ciapi.dto;

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

	
	private CIAPI.Java.examples.ciapi.dto.MarketDTO[] Markets;
	
	/**
	 * A list of Spread Betting markets
	 */
	public CIAPI.Java.examples.ciapi.dto.MarketDTO[] getMarkets() {
		return Markets;
	}
	
	public void setMarkets(CIAPI.Java.examples.ciapi.dto.MarketDTO[] Markets) {
		this.Markets = Markets;
	}

}

