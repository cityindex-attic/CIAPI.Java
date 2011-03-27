package CIAPI.Java.examples.ciapi.dto;

/**
 * !This is an auto generated model object!
 *
 * TODO
 */
public class ApiActiveStopLimitOrderDTO {

	/**
	 * No argument constructor
	 */
	public ApiActiveStopLimitOrderDTO() {
	}

	
	private int OrderId;
	
	/**
	 * 
	 * The order's unique identifier.
	 */
	public int getOrderId() {
		return OrderId;
	}

	private int MarketId;
	
	/**
	 * 
	 * The markets unique identifier.
	 */
	public int getMarketId() {
		return MarketId;
	}

	private String MarketName;
	
	/**
	 * 
	 * The market's name.
	 */
	public String getMarketName() {
		return MarketName;
	}

	private String Direction;
	
	/**
	 * 
	 * The direction, buy or sell.
	 */
	public String getDirection() {
		return Direction;
	}

	private double Quantity;
	
	/**
	 * 
	 * TODO
	 */
	public double getQuantity() {
		return Quantity;
	}

	private double TriggerPrice;
	
	/**
	 * 
	 * TODO
	 */
	public double getTriggerPrice() {
		return TriggerPrice;
	}

	private double TradingAccountId;
	
	/**
	 * 
	 * TODO
	 */
	public double getTradingAccountId() {
		return TradingAccountId;
	}

	private String Type;
	
	/**
	 * 
	 * TODO
	 */
	public String getType() {
		return Type;
	}

	private String Applicability;
	
	/**
	 * 
	 * TODO
	 */
	public String getApplicability() {
		return Applicability;
	}

	private String Currency;
	
	/**
	 * 
	 * TODO
	 */
	public String getCurrency() {
		return Currency;
	}

	private String Status;
	
	/**
	 * 
	 * TODO
	 */
	public String getStatus() {
		return Status;
	}

	private CIAPI.Java.examples.ciapi.dto.ApiBasicStopLimitOrderDTO StopOrder;
	
	/**
	 * 
	 * TODO
	 */
	public CIAPI.Java.examples.ciapi.dto.ApiBasicStopLimitOrderDTO getStopOrder() {
		return StopOrder;
	}

	private CIAPI.Java.examples.ciapi.dto.ApiBasicStopLimitOrderDTO LimitOrder;
	
	/**
	 * 
	 * TODO
	 */
	public CIAPI.Java.examples.ciapi.dto.ApiBasicStopLimitOrderDTO getLimitOrder() {
		return LimitOrder;
	}

	private CIAPI.Java.examples.ciapi.dto.ApiBasicStopLimitOrderDTO OcoOrder;
	
	/**
	 * 
	 * TODO
	 */
	public CIAPI.Java.examples.ciapi.dto.ApiBasicStopLimitOrderDTO getOcoOrder() {
		return OcoOrder;
	}

	private String LastChangedDateTimeUTC;
	
	/**
	 * 
	 * TODO
	 */
	public String getLastChangedDateTimeUTC() {
		return LastChangedDateTimeUTC;
	}

}

