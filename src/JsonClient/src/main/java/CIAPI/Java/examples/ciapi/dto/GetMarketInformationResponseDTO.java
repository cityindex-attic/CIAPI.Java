package CIAPI.Java.examples.ciapi.dto;

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

	
	private CIAPI.Java.examples.ciapi.dto.MarketInformationDTO MarketInformation;
	
	/**
	 * The requested market information.
	 */
	public CIAPI.Java.examples.ciapi.dto.MarketInformationDTO getMarketInformation() {
		return MarketInformation;
	}
	
	public void setMarketInformation(CIAPI.Java.examples.ciapi.dto.MarketInformationDTO MarketInformation) {
		this.MarketInformation = MarketInformation;
	}

}

