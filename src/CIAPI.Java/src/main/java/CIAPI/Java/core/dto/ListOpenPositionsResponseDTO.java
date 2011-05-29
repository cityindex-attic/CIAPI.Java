package CIAPI.Java.core.dto;

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
	
	private ApiOpenPositionDTO[] OpenPositions;
	
	/**
	 * A list of trades / open positions.
	 */
	public ApiOpenPositionDTO[] getOpenPositions() {
		return OpenPositions;
	}
	
	public void setOpenPositions(ApiOpenPositionDTO[] OpenPositions) {
		this.OpenPositions = OpenPositions;
	}
}

