package CIAPI.Java.examples.ciapi.dto;

/**
 * !This is an auto generated model object!
 *
 * TODO
 */
public class ApiStopLimitOrderHistoryDTO {

	/**
	 * No argument constructor
	 */
	public ApiStopLimitOrderHistoryDTO() {
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

	private double OriginalQuantity;
	
	/**
	 * 
	 * The quantity of the order when it became a trade / was cancelled etc.
	 */
	public double getOriginalQuantity() {
		return OriginalQuantity;
	}

	private String Price;
	
	/**
	 * 
	 * The price / rate that the order was filled at.
	 */
	public String getPrice() {
		return Price;
	}

	private double TriggerPrice;
	
	/**
	 * 
	 * The price / rate that the the order was set to trigger at.
	 */
	public double getTriggerPrice() {
		return TriggerPrice;
	}

	private int TradingAccountId;
	
	/**
	 * 
	 * The trading account that the order is on.
	 */
	public int getTradingAccountId() {
		return TradingAccountId;
	}

	private int TypeId;
	
	/**
	 * 
	 * The type of the order stop, limit or trade
	 */
	public int getTypeId() {
		return TypeId;
	}

	private int OrderApplicabilityId;
	
	/**
	 * 
	 * When the order applies until. ie good till cancelled (GTC) good for day (GFD) or good till time (GTT).
	 */
	public int getOrderApplicabilityId() {
		return OrderApplicabilityId;
	}

	private String Currency;
	
	/**
	 * 
	 * The trade currency
	 */
	public String getCurrency() {
		return Currency;
	}

	private int StatusId;
	
	/**
	 * 
	 * the order status.
	 */
	public int getStatusId() {
		return StatusId;
	}

	private String LastChangedDateTimeUtc;
	
	/**
	 * 
	 * The date time the order was last changed.
	 */
	public String getLastChangedDateTimeUtc() {
		return LastChangedDateTimeUtc;
	}

}

