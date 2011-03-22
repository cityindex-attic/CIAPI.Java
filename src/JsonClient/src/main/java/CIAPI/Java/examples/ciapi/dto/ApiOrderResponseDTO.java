package CIAPI.Java.examples.ciapi.dto;

/**
 * !This is an auto generated model object!
 *
 */
public class ApiOrderResponseDTO {
	
	private int OrderId;
	
	public int getOrderId() {
		return OrderId;
	}
	

	private int StatusReason;
	
	public int getStatusReason() {
		return StatusReason;
	}
	

	private int Status;
	
	public int getStatus() {
		return Status;
	}
	

	private double Price;
	
	public double getPrice() {
		return Price;
	}
	

	private double CommissionCharge;
	
	public double getCommissionCharge() {
		return CommissionCharge;
	}
	

	private CIAPI.Java.examples.ciapi.dto.ApiIfDoneResponseDTO[] IfDone;
	
	public CIAPI.Java.examples.ciapi.dto.ApiIfDoneResponseDTO[] getIfDone() {
		return IfDone;
	}
	

	private double GuaranteedPremium;
	
	public double getGuaranteedPremium() {
		return GuaranteedPremium;
	}
	

	private CIAPI.Java.examples.ciapi.dto.ApiOrderResponseDTO OCO;
	
	public CIAPI.Java.examples.ciapi.dto.ApiOrderResponseDTO getOCO() {
		return OCO;
	}
	

}

