package CIAPI.Java.dto;

/**
 * !This is an auto generated model object!
 *
 * A stop or limit order with a limited number of data fields.
 */
public class ApiBasicStopLimitOrderDTO {

	/**
	 * No argument constructor
	 */
	public ApiBasicStopLimitOrderDTO() {
	}

	
	private int OrderId;
	
	/**
	 * The order's unique identifier.
	 */
	public int getOrderId() {
		return OrderId;
	}
	
	public void setOrderId(int OrderId) {
		this.OrderId = OrderId;
	}

	private double TriggerPrice;
	
	/**
	 * The order's trigger price.
	 */
	public double getTriggerPrice() {
		return TriggerPrice;
	}
	
	public void setTriggerPrice(double TriggerPrice) {
		this.TriggerPrice = TriggerPrice;
	}

	private double Quantity;
	
	/**
	 * The quantity of the product.
	 */
	public double getQuantity() {
		return Quantity;
	}
	
	public void setQuantity(double Quantity) {
		this.Quantity = Quantity;
	}

}

