package CIAPI.Java.core.dto;

/**
 * !This is an auto generated model object!
 *
 * Response containing the active stop limit order.
 */
public class GetActiveStopLimitOrderResponseDTO {

	/**
	 * No argument constructor 
	 */
	public GetActiveStopLimitOrderResponseDTO() {
	}
	
	private ApiActiveStopLimitOrderDTO ActiveStopLimitOrder;
	
	/**
	 * The active stop limit order. If it is null then the active stop limit order does not exist.
	 */
	public ApiActiveStopLimitOrderDTO getActiveStopLimitOrder() {
		return ActiveStopLimitOrder;
	}
	
	public void setActiveStopLimitOrder(ApiActiveStopLimitOrderDTO ActiveStopLimitOrder) {
		this.ActiveStopLimitOrder = ActiveStopLimitOrder;
	}
}

