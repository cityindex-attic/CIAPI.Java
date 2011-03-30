package CIAPI.Java.examples.ciapi.dto;

/**
 * !This is an auto generated model object!
 *
 * Contains the result of a ListStopLimitOrderHistory query
 */
public class ListStopLimitOrderHistoryResponseDTO {

	/**
	 * No argument constructor
	 */
	public ListStopLimitOrderHistoryResponseDTO() {
	}

	
	private CIAPI.Java.examples.ciapi.dto.ApiStopLimitOrderHistoryDTO[] StopLimitOrderHistory;
	
	/**
	 * A list of historical stop / limit orders.
	 */
	public CIAPI.Java.examples.ciapi.dto.ApiStopLimitOrderHistoryDTO[] getStopLimitOrderHistory() {
		return StopLimitOrderHistory;
	}
	
	public void setStopLimitOrderHistory(CIAPI.Java.examples.ciapi.dto.ApiStopLimitOrderHistoryDTO[] StopLimitOrderHistory) {
		this.StopLimitOrderHistory = StopLimitOrderHistory;
	}

}

