package CIAPI.Java.dto;

/**
 * !This is an auto generated model object!
 *
 * Contains the result of a ListActiveStopLimitOrder query
 */
public class ListActiveStopLimitOrderResponseDTO {

	/**
	 * No argument constructor
	 */
	public ListActiveStopLimitOrderResponseDTO() {
	}

	
	private CIAPI.Java.dto.ApiActiveStopLimitOrderDTO[] ActiveStopLimitOrders;
	
	/**
	 * The requested list of active stop / limit orders.
	 */
	public CIAPI.Java.dto.ApiActiveStopLimitOrderDTO[] getActiveStopLimitOrders() {
		return ActiveStopLimitOrders;
	}
	
	public void setActiveStopLimitOrders(CIAPI.Java.dto.ApiActiveStopLimitOrderDTO[] ActiveStopLimitOrders) {
		this.ActiveStopLimitOrders = ActiveStopLimitOrders;
	}

}

