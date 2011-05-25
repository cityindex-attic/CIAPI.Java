package CIAPI.Java.dto;

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

