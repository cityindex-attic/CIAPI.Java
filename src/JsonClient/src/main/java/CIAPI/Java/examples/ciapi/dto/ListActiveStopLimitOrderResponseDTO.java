package CIAPI.Java.examples.ciapi.dto;

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

	
	private CIAPI.Java.examples.ciapi.dto.ApiActiveStopLimitOrderDTO[] ActiveStopLimitOrders;
	
	/**
	 * The requested list of active stop / limit orders.
	 */
	public CIAPI.Java.examples.ciapi.dto.ApiActiveStopLimitOrderDTO[] getActiveStopLimitOrders() {
		return ActiveStopLimitOrders;
	}
	
	public void setActiveStopLimitOrders(CIAPI.Java.examples.ciapi.dto.ApiActiveStopLimitOrderDTO[] ActiveStopLimitOrders) {
		this.ActiveStopLimitOrders = ActiveStopLimitOrders;
	}

}

