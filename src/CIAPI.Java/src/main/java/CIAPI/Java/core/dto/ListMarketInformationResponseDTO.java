package CIAPI.Java.core.dto;

/**
 * !This is an auto generated model object!
 *
 * Response from am market information request.
 */
public class ListMarketInformationResponseDTO {

	/**
	 * No argument constructor 
	 */
	public ListMarketInformationResponseDTO() {
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

