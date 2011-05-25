package CIAPI.Java.dto;

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
	
	private CIAPI.Java.dto.ApiStopLimitOrderHistoryDTO[] StopLimitOrderHistory;
	
	/**
	 * A list of historical stop / limit orders.
	 */
	public CIAPI.Java.dto.ApiStopLimitOrderHistoryDTO[] getStopLimitOrderHistory() {
		return StopLimitOrderHistory;
	}
	
	public void setStopLimitOrderHistory(CIAPI.Java.dto.ApiStopLimitOrderHistoryDTO[] StopLimitOrderHistory) {
		this.StopLimitOrderHistory = StopLimitOrderHistory;
	}
}

