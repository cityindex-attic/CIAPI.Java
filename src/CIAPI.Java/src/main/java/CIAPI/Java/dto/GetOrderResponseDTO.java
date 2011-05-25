package CIAPI.Java.dto;

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
	
	private CIAPI.Java.dto.ApiTradeOrderDTO TradeOrder;
	
	/**
	 * The details of the order if it's a trade / open position.
	 */
	public CIAPI.Java.dto.ApiTradeOrderDTO getTradeOrder() {
		return TradeOrder;
	}
	
	public void setTradeOrder(CIAPI.Java.dto.ApiTradeOrderDTO TradeOrder) {
		this.TradeOrder = TradeOrder;
	}
	private CIAPI.Java.dto.ApiStopLimitOrderDTO StopLimitOrder;
	
	/**
	 * The details of the order if it's a stop limit order.
	 */
	public CIAPI.Java.dto.ApiStopLimitOrderDTO getStopLimitOrder() {
		return StopLimitOrder;
	}
	
	public void setStopLimitOrder(CIAPI.Java.dto.ApiStopLimitOrderDTO StopLimitOrder) {
		this.StopLimitOrder = StopLimitOrder;
	}
}

