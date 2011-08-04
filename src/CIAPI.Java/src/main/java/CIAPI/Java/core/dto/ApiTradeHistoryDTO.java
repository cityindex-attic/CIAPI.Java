package CIAPI.Java.core.dto;

/**
 * !This is an auto generated model object!
 *
 * A Trade from a historical perspective.
 */
public class ApiTradeHistoryDTO {

	/**
	 * No argument constructor 
	 */
	public ApiTradeHistoryDTO() {
	}
	
	private int OrderId;
	
	/**
	 * The order id.
	 */
	public int getOrderId() {
		return OrderId;
	}
	
	public void setOrderId(int OrderId) {
		this.OrderId = OrderId;
	}
	private int MarketId;
	
	/**
	 * The market id.
	 */
	public int getMarketId() {
		return MarketId;
	}
	
	public void setMarketId(int MarketId) {
		this.MarketId = MarketId;
	}
	private String MarketName;
	
	/**
	 * The name of the market.
	 */
	public String getMarketName() {
		return MarketName;
	}
	
	public void setMarketName(String MarketName) {
		this.MarketName = MarketName;
	}
	private String Direction;
	
	/**
	 * The direction of the trade.
	 */
	public String getDirection() {
		return Direction;
	}
	
	public void setDirection(String Direction) {
		this.Direction = Direction;
	}
	private double OriginalQuantity;
	
	/**
	 * The original quantity of the trade, before part closures.
	 */
	public double getOriginalQuantity() {
		return OriginalQuantity;
	}
	
	public void setOriginalQuantity(double OriginalQuantity) {
		this.OriginalQuantity = OriginalQuantity;
	}
	private double Price;
	
	/**
	 * The open price of the trade.
	 */
	public double getPrice() {
		return Price;
	}
	
	public void setPrice(double Price) {
		this.Price = Price;
	}
	private int TradingAccountId;
	
	/**
	 * The trading account that the order is on.
	 */
	public int getTradingAccountId() {
		return TradingAccountId;
	}
	
	public void setTradingAccountId(int TradingAccountId) {
		this.TradingAccountId = TradingAccountId;
	}
	private String Currency;
	
	/**
	 * The trade currency.
	 */
	public String getCurrency() {
		return Currency;
	}
	
	public void setCurrency(String Currency) {
		this.Currency = Currency;
	}
	private String LastChangedDateTimeUtc;
	
	/**
	 * The last time that the order changed. Note - Does not include things such as the current market price.
	 */
	public String getLastChangedDateTimeUtc() {
		return LastChangedDateTimeUtc;
	}
	
	public void setLastChangedDateTimeUtc(String LastChangedDateTimeUtc) {
		this.LastChangedDateTimeUtc = LastChangedDateTimeUtc;
	}
}

