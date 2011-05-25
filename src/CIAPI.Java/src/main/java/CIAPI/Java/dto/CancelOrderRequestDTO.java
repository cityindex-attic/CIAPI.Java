package CIAPI.Java.dto;

/**
 * !This is an auto generated model object!
 *
 * A cancel order request.
 */
public class CancelOrderRequestDTO {

	/**
	 * No argument constructor 
	 */
	public CancelOrderRequestDTO() {
	}
	
	private int OrderId;
	
	/**
	 * The order identifier.
	 */
	public int getOrderId() {
		return OrderId;
	}
	
	public void setOrderId(int OrderId) {
		this.OrderId = OrderId;
	}
	private int TradingAccountId;
	
	/**
	 * TradingAccount associated with the cancel order request.
	 */
	public int getTradingAccountId() {
		return TradingAccountId;
	}
	
	public void setTradingAccountId(int TradingAccountId) {
		this.TradingAccountId = TradingAccountId;
	}
}

