package CIAPI.Java.core.dto;

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
	
	private ApiMarketInformationDTO[] MarketInformation;
	
	/**
	 * The requested list of market information.
	 */
	public ApiMarketInformationDTO[] getMarketInformation() {
		return MarketInformation;
	}
	
	public void setMarketInformation(ApiMarketInformationDTO[] MarketInformation) {
		this.MarketInformation = MarketInformation;
	}
}

