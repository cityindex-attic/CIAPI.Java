package CIAPI.Java.core.dto;

/**
 * !This is an auto generated model object!
 *
 * A news headline
 */
public class NewsDTO {

	/**
	 * No argument constructor 
	 */
	public NewsDTO() {
	}
	
	private int StoryId;
	
	/**
	 * The unique identifier for a news story
	 */
	public int getStoryId() {
		return StoryId;
	}
	
	public void setStoryId(int StoryId) {
		this.StoryId = StoryId;
	}
	private String Headline;
	
	/**
	 * The News story headline
	 */
	public String getHeadline() {
		return Headline;
	}
	
	public void setHeadline(String Headline) {
		this.Headline = Headline;
	}
	private String PublishDate;
	
	/**
	 * The date on which the news story was published. Always in UTC
	 */
	public String getPublishDate() {
		return PublishDate;
	}
	
	public void setPublishDate(String PublishDate) {
		this.PublishDate = PublishDate;
	}
}

