package CIAPI.Java.examples.ciapi.dto;

/**
 * !This is an auto generated model object!
 *
 * TODO
 */
public class ApiTradeHistoryDTO {

	/**
	 * No argument constructor
	 */
	public ApiTradeHistoryDTO() {
	}

	
	private int OrderId;
	
	/**
	 * 
	 * TODO
	 */
	public int getOrderId() {
		return OrderId;
	}

	private int MarketId;
	
	/**
	 * 
	 * TODO
	 */
	public int getMarketId() {
		return MarketId;
	}

	private String MarketName;
	
	/**
	 * 
	 * TODO
	 */
	public String getMarketName() {
		return MarketName;
	}

	private String Direction;
	
	/**
	 * 
	 * TODO
	 */
	public String getDirection() {
		return Direction;
	}

	private double OriginalQuantity;
	
	/**
	 * 
	 * TODO
	 */
	public double getOriginalQuantity() {
		return OriginalQuantity;
	}

	private double Price;
	
	/**
	 * 
	 * TODO
	 */
	public double getPrice() {
		return Price;
	}

	private int TradingAccountId;
	
	/**
	 * 
	 * TODO
	 */
	public int getTradingAccountId() {
		return TradingAccountId;
	}

	private String Currency;
	
	/**
	 * 
	 * The trade currency
	 */
	public String getCurrency() {
		return Currency;
	}

	private String LastChangedDateTimeUtc;
	
	/**
	 * 
	 * TODO
	 */
	public String getLastChangedDateTimeUtc() {
		return LastChangedDateTimeUtc;
	}

}

