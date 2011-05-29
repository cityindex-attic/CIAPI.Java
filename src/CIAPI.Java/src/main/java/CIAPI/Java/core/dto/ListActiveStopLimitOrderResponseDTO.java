package CIAPI.Java.core.dto;

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
	
	private ApiActiveStopLimitOrderDTO[] ActiveStopLimitOrders;
	
	/**
	 * The requested list of active stop / limit orders.
	 */
	public ApiActiveStopLimitOrderDTO[] getActiveStopLimitOrders() {
		return ActiveStopLimitOrders;
	}
	
	public void setActiveStopLimitOrders(ApiActiveStopLimitOrderDTO[] ActiveStopLimitOrders) {
		this.ActiveStopLimitOrders = ActiveStopLimitOrders;
	}
}

