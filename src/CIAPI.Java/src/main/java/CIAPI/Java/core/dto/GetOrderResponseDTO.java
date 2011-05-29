package CIAPI.Java.core.dto;

/**
 * !This is an auto generated model object!
 *
 * Response containing the order. Only one of the two fields will be populated; this depends upon the type of order (Trade or Stop / Limit).
 */
public class GetOrderResponseDTO {

	/**
	 * No argument constructor 
	 */
	public GetOrderResponseDTO() {
	}
	
	private ApiTradeOrderDTO TradeOrder;
	
	/**
	 * The details of the order if it's a trade / open position.
	 */
	public ApiTradeOrderDTO getTradeOrder() {
		return TradeOrder;
	}
	
	public void setTradeOrder(ApiTradeOrderDTO TradeOrder) {
		this.TradeOrder = TradeOrder;
	}
	private ApiStopLimitOrderDTO StopLimitOrder;
	
	/**
	 * The details of the order if it's a stop limit order.
	 */
	public ApiStopLimitOrderDTO getStopLimitOrder() {
		return StopLimitOrder;
	}
	
	public void setStopLimitOrder(ApiStopLimitOrderDTO StopLimitOrder) {
		this.StopLimitOrder = StopLimitOrder;
	}
}

