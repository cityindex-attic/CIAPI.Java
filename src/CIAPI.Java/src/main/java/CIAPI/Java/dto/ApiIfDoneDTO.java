package CIAPI.Java.dto;

/**
 * !This is an auto generated model object!
 *
 * An IfDone order represents an order which is placed when the corresponding order is filled, e.g attaching a stop/limit to a trade or order
 */
public class ApiIfDoneDTO {

	/**
	 * No argument constructor 
	 */
	public ApiIfDoneDTO() {
	}
	
	private CIAPI.Java.dto.ApiStopLimitOrderDTO Stop;
	
	/**
	 * The price at which the stop order will be filled
	 */
	public CIAPI.Java.dto.ApiStopLimitOrderDTO getStop() {
		return Stop;
	}
	
	public void setStop(CIAPI.Java.dto.ApiStopLimitOrderDTO Stop) {
		this.Stop = Stop;
	}
	private CIAPI.Java.dto.ApiStopLimitOrderDTO Limit;
	
	/**
	 * The price at which the limit order will be filled
	 */
	public CIAPI.Java.dto.ApiStopLimitOrderDTO getLimit() {
		return Limit;
	}
	
	public void setLimit(CIAPI.Java.dto.ApiStopLimitOrderDTO Limit) {
		this.Limit = Limit;
	}
}

