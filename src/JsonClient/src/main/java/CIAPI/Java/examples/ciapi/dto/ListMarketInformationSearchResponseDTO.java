package CIAPI.Java.examples.ciapi.dto;

/**
 * !This is an auto generated model object!
 *
 * Response from am market information search request.
 */
public class ListMarketInformationSearchResponseDTO {

	/**
	 * No argument constructor
	 */
	public ListMarketInformationSearchResponseDTO() {
	}

	
	private CIAPI.Java.examples.ciapi.dto.MarketInformationDTO[] MarketInformation;
	
	/**
	 * The requested list of market information.
	 */
	public CIAPI.Java.examples.ciapi.dto.MarketInformationDTO[] getMarketInformation() {
		return MarketInformation;
	}
	
	public void setMarketInformation(CIAPI.Java.examples.ciapi.dto.MarketInformationDTO[] MarketInformation) {
		this.MarketInformation = MarketInformation;
	}

}

