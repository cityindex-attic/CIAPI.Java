package CIAPI.Java.core.dto;

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
	
	private ApiMarketDTO[] Markets;
	
	/**
	 * A list of CFD markets
	 */
	public ApiMarketDTO[] getMarkets() {
		return Markets;
	}
	
	public void setMarkets(ApiMarketDTO[] Markets) {
		this.Markets = Markets;
	}
}

