package CIAPI.Java.examples.ciapi.dto;

/**
 * !This is an auto generated model object!
 *
 * An order for a specific Trading Account
 */
public class OrderDTO {

	/**
	 * No argument constructor
	 */
	public OrderDTO() {
	}

	
	private int OrderId;
	
	/**
	 * 
	 * ???
	 */
	public int getOrderId() {
		return OrderId;
	}

	private int MarketId;
	
	/**
	 * 
	 * ???
	 */
	public int getMarketId() {
		return MarketId;
	}

	private int ClientAccountId;
	
	/**
	 * 
	 * ???
	 */
	public int getClientAccountId() {
		return ClientAccountId;
	}

	private int TradingAccountId;
	
	/**
	 * 
	 * ???
	 */
	public int getTradingAccountId() {
		return TradingAccountId;
	}

	private int CurrencyId;
	
	/**
	 * 
	 * ???
	 */
	public int getCurrencyId() {
		return CurrencyId;
	}

	private String CurrencyISO;
	
	/**
	 * 
	 * ???
	 */
	public String getCurrencyISO() {
		return CurrencyISO;
	}

	private int Direction;
	
	/**
	 * 
	 * ???
	 */
	public int getDirection() {
		return Direction;
	}

	private boolean AutoRollover;
	
	/**
	 * 
	 * ???
	 */
	public boolean getAutoRollover() {
		return AutoRollover;
	}

	private double ExecutionPrice;
	
	/**
	 * 
	 * ???
	 */
	public double getExecutionPrice() {
		return ExecutionPrice;
	}

	private String LastChangedTime;
	
	/**
	 * 
	 * The date of the Order. Always expressed in UTC
	 */
	public String getLastChangedTime() {
		return LastChangedTime;
	}

	private double OpenPrice;
	
	/**
	 * 
	 * ???
	 */
	public double getOpenPrice() {
		return OpenPrice;
	}

	private String OriginalLastChangedDateTime;
	
	/**
	 * 
	 * The date of the Order. Always expressed in UTC
	 */
	public String getOriginalLastChangedDateTime() {
		return OriginalLastChangedDateTime;
	}

	private double OriginalQuantity;
	
	/**
	 * 
	 * ???
	 */
	public double getOriginalQuantity() {
		return OriginalQuantity;
	}

	private double Quantity;
	
	/**
	 * 
	 * ???
	 */
	public double getQuantity() {
		return Quantity;
	}

	private String Type;
	
	/**
	 * 
	 * ???
	 */
	public String getType() {
		return Type;
	}

	private String Status;
	
	/**
	 * 
	 * ???
	 */
	public String getStatus() {
		return Status;
	}

	private int ReasonId;
	
	/**
	 * 
	 * ???
	 */
	public int getReasonId() {
		return ReasonId;
	}

}

