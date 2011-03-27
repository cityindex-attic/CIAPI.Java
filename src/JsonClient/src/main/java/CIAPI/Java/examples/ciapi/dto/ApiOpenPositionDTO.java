package CIAPI.Java.examples.ciapi.dto;

/**
 * !This is an auto generated model object!
 *
 * TODO
 */
public class ApiOpenPositionDTO {

	/**
	 * No argument constructor
	 */
	public ApiOpenPositionDTO() {
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
	 * The quantity of the order.
	 */
	public double getQuantity() {
		return Quantity;
	}

	private double Price;
	
	/**
	 * 
	 * The price / rate that the trade was opened at.
	 */
	public double getPrice() {
		return Price;
	}

	private int TradingAccountId;
	
	/**
	 * 
	 * The trading account that the order is on.
	 */
	public int getTradingAccountId() {
		return TradingAccountId;
	}

	private String Currency;
	
	/**
	 * 
	 * The trade currency.
	 */
	public String getCurrency() {
		return Currency;
	}

	private String Status;
	
	/**
	 * 
	 * The order status.
	 */
	public String getStatus() {
		return Status;
	}

	private CIAPI.Java.examples.ciapi.dto.ApiBasicStopLimitOrderDTO StopOrder;
	
	/**
	 * 
	 * The stop order attached to this order.
	 */
	public CIAPI.Java.examples.ciapi.dto.ApiBasicStopLimitOrderDTO getStopOrder() {
		return StopOrder;
	}

	private CIAPI.Java.examples.ciapi.dto.ApiBasicStopLimitOrderDTO LimitOrder;
	
	/**
	 * 
	 * The limit order attached to this order.
	 */
	public CIAPI.Java.examples.ciapi.dto.ApiBasicStopLimitOrderDTO getLimitOrder() {
		return LimitOrder;
	}

	private String LastChangedDateTimeUTC;
	
	/**
	 * 
	 * The date time the order was last changed.
	 */
	public String getLastChangedDateTimeUTC() {
		return LastChangedDateTimeUTC;
	}

}

