package CIAPI.Java.dto;

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
	
	private CIAPI.Java.dto.ApiMarketInformationDTO MarketInformation;
	
	/**
	 * The requested market information.
	 */
	public CIAPI.Java.dto.ApiMarketInformationDTO getMarketInformation() {
		return MarketInformation;
	}
	
	public void setMarketInformation(CIAPI.Java.dto.ApiMarketInformationDTO MarketInformation) {
		this.MarketInformation = MarketInformation;
	}
}

