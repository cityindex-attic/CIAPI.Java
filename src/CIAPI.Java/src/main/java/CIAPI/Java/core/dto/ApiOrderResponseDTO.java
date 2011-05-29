package CIAPI.Java.core.dto;

/**
 * !This is an auto generated model object!
 *
 * order response
 */
public class ApiOrderResponseDTO {

	/**
	 * No argument constructor 
	 */
	public ApiOrderResponseDTO() {
	}
	
	private int OrderId;
	
	/**
	 * order id.
	 */
	public int getOrderId() {
		return OrderId;
	}
	
	public void setOrderId(int OrderId) {
		this.OrderId = OrderId;
	}
	private int StatusReason;
	
	/**
	 * order status reason id.
	 */
	public int getStatusReason() {
		return StatusReason;
	}
	
	public void setStatusReason(int StatusReason) {
		this.StatusReason = StatusReason;
	}
	private int Status;
	
	/**
	 * order status id.
	 */
	public int getStatus() {
		return Status;
	}
	
	public void setStatus(int Status) {
		this.Status = Status;
	}
	private double Price;
	
	/**
	 * price.
	 */
	public double getPrice() {
		return Price;
	}
	
	public void setPrice(double Price) {
		this.Price = Price;
	}
	private double CommissionCharge;
	
	/**
	 * commission charge.
	 */
	public double getCommissionCharge() {
		return CommissionCharge;
	}
	
	public void setCommissionCharge(double CommissionCharge) {
		this.CommissionCharge = CommissionCharge;
	}
	private ApiIfDoneResponseDTO[] IfDone;
	
	/**
	 * list of if done orders.
	 */
	public ApiIfDoneResponseDTO[] getIfDone() {
		return IfDone;
	}
	
	public void setIfDone(ApiIfDoneResponseDTO[] IfDone) {
		this.IfDone = IfDone;
	}
	private double GuaranteedPremium;
	
	/**
	 * premium for guaranteed orders.
	 */
	public double getGuaranteedPremium() {
		return GuaranteedPremium;
	}
	
	public void setGuaranteedPremium(double GuaranteedPremium) {
		this.GuaranteedPremium = GuaranteedPremium;
	}
	private ApiOrderResponseDTO OCO;
	
	/**
	 * an order in an OCO relationship with this order.
	 */
	public ApiOrderResponseDTO getOCO() {
		return OCO;
	}
	
	public void setOCO(ApiOrderResponseDTO OCO) {
		this.OCO = OCO;
	}
}

