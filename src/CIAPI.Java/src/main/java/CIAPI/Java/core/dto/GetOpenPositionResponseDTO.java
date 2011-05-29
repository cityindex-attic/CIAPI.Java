package CIAPI.Java.core.dto;

/**
 * !This is an auto generated model object!
 *
 * Response containing the open position.
 */
public class GetOpenPositionResponseDTO {

	/**
	 * No argument constructor 
	 */
	public GetOpenPositionResponseDTO() {
	}
	
	private ApiOpenPositionDTO OpenPosition;
	
	/**
	 * The open position. If it is null then the open position does not exist.
	 */
	public ApiOpenPositionDTO getOpenPosition() {
		return OpenPosition;
	}
	
	public void setOpenPosition(ApiOpenPositionDTO OpenPosition) {
		this.OpenPosition = OpenPosition;
	}
}

