package CIAPI.Java.examples.ciapi.dto;

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

	
	private CIAPI.Java.examples.ciapi.dto.ApiOpenPositionDTO OpenPosition;
	
	/**
	 * The open position. If it is null then the open position does not exist.
	 */
	public CIAPI.Java.examples.ciapi.dto.ApiOpenPositionDTO getOpenPosition() {
		return OpenPosition;
	}
	
	public void setOpenPosition(CIAPI.Java.examples.ciapi.dto.ApiOpenPositionDTO OpenPosition) {
		this.OpenPosition = OpenPosition;
	}

}

