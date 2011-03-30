package CIAPI.Java.examples.ciapi.dto;

/**
 * !This is an auto generated model object!
 *
 * The response from a GET request for News headlines
 */
public class ListNewsHeadlinesResponseDTO {

	/**
	 * No argument constructor
	 */
	public ListNewsHeadlinesResponseDTO() {
	}

	
	private CIAPI.Java.examples.ciapi.dto.NewsDTO[] Headlines;
	
	/**
	 * A list of News headlines
	 */
	public CIAPI.Java.examples.ciapi.dto.NewsDTO[] getHeadlines() {
		return Headlines;
	}
	
	public void setHeadlines(CIAPI.Java.examples.ciapi.dto.NewsDTO[] Headlines) {
		this.Headlines = Headlines;
	}

}

