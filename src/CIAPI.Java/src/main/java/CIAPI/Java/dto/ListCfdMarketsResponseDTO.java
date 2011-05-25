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
	
	private CIAPI.Java.dto.ApiMarketDTO[] Markets;
	
	/**
	 * A list of CFD markets
	 */
	public CIAPI.Java.dto.ApiMarketDTO[] getMarkets() {
		return Markets;
	}
	
	public void setMarkets(CIAPI.Java.dto.ApiMarketDTO[] Markets) {
		this.Markets = Markets;
	}
}

