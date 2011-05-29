package CIAPI.Java.core.dto;

/**
 * !This is an auto generated model object!
 *
 * Response from am market information request.
 */
public class GetMarketInformationResponseDTO {

	/**
	 * No argument constructor 
	 */
	public GetMarketInformationResponseDTO() {
	}
	
	private ApiMarketInformationDTO MarketInformation;
	
	/**
	 * The requested market information.
	 */
	public ApiMarketInformationDTO getMarketInformation() {
		return MarketInformation;
	}
	
	public void setMarketInformation(ApiMarketInformationDTO MarketInformation) {
		this.MarketInformation = MarketInformation;
	}
}

