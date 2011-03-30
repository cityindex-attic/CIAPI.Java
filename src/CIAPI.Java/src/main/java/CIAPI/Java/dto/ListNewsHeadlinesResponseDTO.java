package CIAPI.Java.dto;

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

	
	private CIAPI.Java.dto.NewsDTO[] Headlines;
	
	/**
	 * A list of News headlines
	 */
	public CIAPI.Java.dto.NewsDTO[] getHeadlines() {
		return Headlines;
	}
	
	public void setHeadlines(CIAPI.Java.dto.NewsDTO[] Headlines) {
		this.Headlines = Headlines;
	}

}

