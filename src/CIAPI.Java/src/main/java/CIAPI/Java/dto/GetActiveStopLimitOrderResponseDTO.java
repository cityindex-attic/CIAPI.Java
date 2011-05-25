package CIAPI.Java.dto;

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
	
	private CIAPI.Java.dto.ApiActiveStopLimitOrderDTO ActiveStopLimitOrder;
	
	/**
	 * The active stop limit order. If it is null then the active stop limit order does not exist.
	 */
	public CIAPI.Java.dto.ApiActiveStopLimitOrderDTO getActiveStopLimitOrder() {
		return ActiveStopLimitOrder;
	}
	
	public void setActiveStopLimitOrder(CIAPI.Java.dto.ApiActiveStopLimitOrderDTO ActiveStopLimitOrder) {
		this.ActiveStopLimitOrder = ActiveStopLimitOrder;
	}
}

