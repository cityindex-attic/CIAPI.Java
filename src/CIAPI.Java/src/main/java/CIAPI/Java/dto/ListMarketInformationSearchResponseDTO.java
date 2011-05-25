package CIAPI.Java.dto;

/**
 * !This is an auto generated model object!
 *
 * Response from a market information search request.
 */
public class ListMarketInformationSearchResponseDTO {

	/**
	 * No argument constructor 
	 */
	public ListMarketInformationSearchResponseDTO() {
	}
	
	private CIAPI.Java.dto.ApiMarketInformationDTO[] MarketInformation;
	
	/**
	 * The requested list of market information.
	 */
	public CIAPI.Java.dto.ApiMarketInformationDTO[] getMarketInformation() {
		return MarketInformation;
	}
	
	public void setMarketInformation(CIAPI.Java.dto.ApiMarketInformationDTO[] MarketInformation) {
		this.MarketInformation = MarketInformation;
	}
}

