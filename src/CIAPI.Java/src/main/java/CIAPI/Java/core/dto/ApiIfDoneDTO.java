package CIAPI.Java.core.dto;

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
	
	private ApiStopLimitOrderDTO Stop;
	
	/**
	 * The price at which the stop order will be filled
	 */
	public ApiStopLimitOrderDTO getStop() {
		return Stop;
	}
	
	public void setStop(ApiStopLimitOrderDTO Stop) {
		this.Stop = Stop;
	}
	private ApiStopLimitOrderDTO Limit;
	
	/**
	 * The price at which the limit order will be filled
	 */
	public ApiStopLimitOrderDTO getLimit() {
		return Limit;
	}
	
	public void setLimit(ApiStopLimitOrderDTO Limit) {
		this.Limit = Limit;
	}
}

