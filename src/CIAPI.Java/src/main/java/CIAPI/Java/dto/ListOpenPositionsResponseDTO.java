package CIAPI.Java.dto;

/**
 * !This is an auto generated model object!
 *
 * Contains the result of a ListOpenPositions query
 */
public class ListOpenPositionsResponseDTO {

	/**
	 * No argument constructor 
	 */
	public ListOpenPositionsResponseDTO() {
	}
	
	private CIAPI.Java.dto.ApiOpenPositionDTO[] OpenPositions;
	
	/**
	 * A list of trades / open positions.
	 */
	public CIAPI.Java.dto.ApiOpenPositionDTO[] getOpenPositions() {
		return OpenPositions;
	}
	
	public void setOpenPositions(CIAPI.Java.dto.ApiOpenPositionDTO[] OpenPositions) {
		this.OpenPositions = OpenPositions;
	}
}

