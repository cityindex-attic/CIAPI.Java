package CIAPI.Java.core.dto;

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
	
	private ApiStopLimitOrderHistoryDTO[] StopLimitOrderHistory;
	
	/**
	 * A list of historical stop / limit orders.
	 */
	public ApiStopLimitOrderHistoryDTO[] getStopLimitOrderHistory() {
		return StopLimitOrderHistory;
	}
	
	public void setStopLimitOrderHistory(ApiStopLimitOrderHistoryDTO[] StopLimitOrderHistory) {
		this.StopLimitOrderHistory = StopLimitOrderHistory;
	}
}

