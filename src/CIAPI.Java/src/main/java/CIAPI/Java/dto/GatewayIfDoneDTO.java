package CIAPI.Java.dto;

/**
 * !This is an auto generated model object!
 *
 * An IfDone order represents an order which is placed when the corresponding order is filled, e.g attaching a stop/limit to a trade or order
 */
public class GatewayIfDoneDTO {

	/**
	 * No argument constructor
	 */
	public GatewayIfDoneDTO() {
	}

	
	private CIAPI.Java.dto.GatewayStopLimitOrderDTO Stop;
	
	/**
	 * The price at which the stop order will be filled
	 */
	public CIAPI.Java.dto.GatewayStopLimitOrderDTO getStop() {
		return Stop;
	}
	
	public void setStop(CIAPI.Java.dto.GatewayStopLimitOrderDTO Stop) {
		this.Stop = Stop;
	}

	private CIAPI.Java.dto.GatewayStopLimitOrderDTO Limit;
	
	/**
	 * The price at which the limit order will be filled
	 */
	public CIAPI.Java.dto.GatewayStopLimitOrderDTO getLimit() {
		return Limit;
	}
	
	public void setLimit(CIAPI.Java.dto.GatewayStopLimitOrderDTO Limit) {
		this.Limit = Limit;
	}

}

