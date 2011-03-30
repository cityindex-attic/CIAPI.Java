package CIAPI.Java.examples.ciapi.dto;

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

	
	private CIAPI.Java.examples.ciapi.dto.ApiActiveStopLimitOrderDTO ActiveStopLimitOrder;
	
	/**
	 * The active stop limit order. If it is null then the active stop limit order does not exist.
	 */
	public CIAPI.Java.examples.ciapi.dto.ApiActiveStopLimitOrderDTO getActiveStopLimitOrder() {
		return ActiveStopLimitOrder;
	}
	
	public void setActiveStopLimitOrder(CIAPI.Java.examples.ciapi.dto.ApiActiveStopLimitOrderDTO ActiveStopLimitOrder) {
		this.ActiveStopLimitOrder = ActiveStopLimitOrder;
	}

}

