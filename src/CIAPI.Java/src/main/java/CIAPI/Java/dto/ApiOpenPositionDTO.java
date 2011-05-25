package CIAPI.Java.dto;

/**
 * !This is an auto generated model object!
 *
 * A Trade, or order that is currently open.
 */
public class ApiOpenPositionDTO {

	/**
	 * No argument constructor 
	 */
	public ApiOpenPositionDTO() {
	}
	
	private int OrderId;
	
	/**
	 * The order's unique identifier.
	 */
	public int getOrderId() {
		return OrderId;
	}
	
	public void setOrderId(int OrderId) {
		this.OrderId = OrderId;
	}
	private int MarketId;
	
	/**
	 * The markets unique identifier.
	 */
	public int getMarketId() {
		return MarketId;
	}
	
	public void setMarketId(int MarketId) {
		this.MarketId = MarketId;
	}
	private String MarketName;
	
	/**
	 * The market's name.
	 */
	public String getMarketName() {
		return MarketName;
	}
	
	public void setMarketName(String MarketName) {
		this.MarketName = MarketName;
	}
	private String Direction;
	
	/**
	 * The direction, buy or sell.
	 */
	public String getDirection() {
		return Direction;
	}
	
	public void setDirection(String Direction) {
		this.Direction = Direction;
	}
	private double Quantity;
	
	/**
	 * The quantity of the order.
	 */
	public double getQuantity() {
		return Quantity;
	}
	
	public void setQuantity(double Quantity) {
		this.Quantity = Quantity;
	}
	private double Price;
	
	/**
	 * The price / rate that the trade was opened at.
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
	private int Status;
	
	/**
	 * The order status.
	 */
	public int getStatus() {
		return Status;
	}
	
	public void setStatus(int Status) {
		this.Status = Status;
	}
	private CIAPI.Java.dto.ApiBasicStopLimitOrderDTO StopOrder;
	
	/**
	 * The stop order attached to this order.
	 */
	public CIAPI.Java.dto.ApiBasicStopLimitOrderDTO getStopOrder() {
		return StopOrder;
	}
	
	public void setStopOrder(CIAPI.Java.dto.ApiBasicStopLimitOrderDTO StopOrder) {
		this.StopOrder = StopOrder;
	}
	private CIAPI.Java.dto.ApiBasicStopLimitOrderDTO LimitOrder;
	
	/**
	 * The limit order attached to this order.
	 */
	public CIAPI.Java.dto.ApiBasicStopLimitOrderDTO getLimitOrder() {
		return LimitOrder;
	}
	
	public void setLimitOrder(CIAPI.Java.dto.ApiBasicStopLimitOrderDTO LimitOrder) {
		this.LimitOrder = LimitOrder;
	}
	private String LastChangedDateTimeUTC;
	
	/**
	 * The last time that the order changed. Note - Does not include things such as the current market price.
	 */
	public String getLastChangedDateTimeUTC() {
		return LastChangedDateTimeUTC;
	}
	
	public void setLastChangedDateTimeUTC(String LastChangedDateTimeUTC) {
		this.LastChangedDateTimeUTC = LastChangedDateTimeUTC;
	}
}

