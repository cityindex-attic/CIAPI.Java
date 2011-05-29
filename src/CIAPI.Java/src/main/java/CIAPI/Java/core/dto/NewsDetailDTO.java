package CIAPI.Java.core.dto;

/**
 * !This is an auto generated model object!
 *
 * Contains details of a specific news story
 */
public class NewsDetailDTO {

	/**
	 * No argument constructor 
	 */
	public NewsDetailDTO() {
	}
	
	private String Story;
	
	/**
	 * The detail of the story. This can contain HTML characters.
	 */
	public String getStory() {
		return Story;
	}
	
	public void setStory(String Story) {
		this.Story = Story;
	}
}

