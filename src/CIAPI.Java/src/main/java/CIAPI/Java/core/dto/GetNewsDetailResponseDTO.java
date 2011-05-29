package CIAPI.Java.core.dto;

/**
 * !This is an auto generated model object!
 *
 * JSON returned from News Detail GET request
 */
public class GetNewsDetailResponseDTO {

	/**
	 * No argument constructor 
	 */
	public GetNewsDetailResponseDTO() {
	}
	
	private NewsDetailDTO NewsDetail;
	
	/**
	 * The details of the news item
	 */
	public NewsDetailDTO getNewsDetail() {
		return NewsDetail;
	}
	
	public void setNewsDetail(NewsDetailDTO NewsDetail) {
		this.NewsDetail = NewsDetail;
	}
}

