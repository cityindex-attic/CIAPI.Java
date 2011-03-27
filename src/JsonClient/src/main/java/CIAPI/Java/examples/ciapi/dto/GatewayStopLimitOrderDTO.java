package CIAPI.Java.examples.ciapi.dto;

/**
 * !This is an auto generated model object!
 *
 * Represents a stop/limit order
 */
public class GatewayStopLimitOrderDTO {

	/**
	 * No argument constructor
	 */
	public GatewayStopLimitOrderDTO() {
	}

	
	private String ExpiryDateTimeUTC;
	
	/**
	 * 
	 * The associated expiry DateTime for a pair of GoodTillDate IfDone orders
	 */
	public String getExpiryDateTimeUTC() {
		return ExpiryDateTimeUTC;
	}

	private String Applicability;
	
	/**
	 * 
	 * Identifier which relates to the expiry of the order/trade, i.e. GoodTillDate (GTD), GoodTillCancelled (GTC) or GoodForDay (GFD)
	 */
	public String getApplicability() {
		return Applicability;
	}

}

