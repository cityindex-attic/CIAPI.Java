package CIAPI.Java.dto;

/**
 * !This is an auto generated model object!
 *
 * TODO
 */
public class ApiOrderResponseDTO {

	/**
	 * No argument constructor
	 */
	public ApiOrderResponseDTO() {
	}

	
	private int OrderId;
	
	/**
	 * TODO
	 */
	public int getOrderId() {
		return OrderId;
	}
	
	public void setOrderId(int OrderId) {
		this.OrderId = OrderId;
	}

	private int StatusReason;
	
	/**
	 * TODO
	 */
	public int getStatusReason() {
		return StatusReason;
	}
	
	public void setStatusReason(int StatusReason) {
		this.StatusReason = StatusReason;
	}

	private int Status;
	
	/**
	 * TODO
	 */
	public int getStatus() {
		return Status;
	}
	
	public void setStatus(int Status) {
		this.Status = Status;
	}

	private double Price;
	
	/**
	 * TODO
	 */
	public double getPrice() {
		return Price;
	}
	
	public void setPrice(double Price) {
		this.Price = Price;
	}

	private double CommissionCharge;
	
	/**
	 * TODO
	 */
	public double getCommissionCharge() {
		return CommissionCharge;
	}
	
	public void setCommissionCharge(double CommissionCharge) {
		this.CommissionCharge = CommissionCharge;
	}

	private CIAPI.Java.dto.ApiIfDoneResponseDTO[] IfDone;
	
	/**
	 * TODO
	 */
	public CIAPI.Java.dto.ApiIfDoneResponseDTO[] getIfDone() {
		return IfDone;
	}
	
	public void setIfDone(CIAPI.Java.dto.ApiIfDoneResponseDTO[] IfDone) {
		this.IfDone = IfDone;
	}

	private double GuaranteedPremium;
	
	/**
	 * TODO
	 */
	public double getGuaranteedPremium() {
		return GuaranteedPremium;
	}
	
	public void setGuaranteedPremium(double GuaranteedPremium) {
		this.GuaranteedPremium = GuaranteedPremium;
	}

	private CIAPI.Java.dto.ApiOrderResponseDTO OCO;
	
	/**
	 * TODO
	 */
	public CIAPI.Java.dto.ApiOrderResponseDTO getOCO() {
		return OCO;
	}
	
	public void setOCO(CIAPI.Java.dto.ApiOrderResponseDTO OCO) {
		this.OCO = OCO;
	}

}

