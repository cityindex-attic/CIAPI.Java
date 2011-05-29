package CIAPI.Java.core.dto;

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
	
	private NewsDTO[] Headlines;
	
	/**
	 * A list of News headlines
	 */
	public NewsDTO[] getHeadlines() {
		return Headlines;
	}
	
	public void setHeadlines(NewsDTO[] Headlines) {
		this.Headlines = Headlines;
	}
}

