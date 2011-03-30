package CIAPI.Java.dto;

/**
 * !This is an auto generated model object!
 *
 * Contains the result of a ListCfdMarkets query
 */
public class ListCfdMarketsResponseDTO {

	/**
	 * No argument constructor
	 */
	public ListCfdMarketsResponseDTO() {
	}

	
	private CIAPI.Java.dto.MarketDTO[] Markets;
	
	/**
	 * A list of CFD markets
	 */
	public CIAPI.Java.dto.MarketDTO[] getMarkets() {
		return Markets;
	}
	
	public void setMarkets(CIAPI.Java.dto.MarketDTO[] Markets) {
		this.Markets = Markets;
	}

}

