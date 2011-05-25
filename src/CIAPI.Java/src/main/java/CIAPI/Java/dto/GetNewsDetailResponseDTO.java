package CIAPI.Java.dto;

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
	
	private CIAPI.Java.dto.NewsDetailDTO NewsDetail;
	
	/**
	 * The details of the news item
	 */
	public CIAPI.Java.dto.NewsDetailDTO getNewsDetail() {
		return NewsDetail;
	}
	
	public void setNewsDetail(CIAPI.Java.dto.NewsDetailDTO NewsDetail) {
		this.NewsDetail = NewsDetail;
	}
}

