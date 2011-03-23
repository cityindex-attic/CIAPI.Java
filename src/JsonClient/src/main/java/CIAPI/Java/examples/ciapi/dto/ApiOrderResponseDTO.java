package CIAPI.Java.examples.ciapi.dto;

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
	

	private int Price;
	
	public int getPrice() {
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
	

}

