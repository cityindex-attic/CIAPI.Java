package CIAPI.Java.core.dto;

/**
 * !This is an auto generated model object!
 *
 * Represents an order
 */
public class ApiOrderDTO {

	/**
	 * No argument constructor 
	 */
	public ApiOrderDTO() {
	}
	
	private int OrderId;
	
	/**
	 * The order identifier
	 */
	public int getOrderId() {
		return OrderId;
	}
	
	public void setOrderId(int OrderId) {
		this.OrderId = OrderId;
	}
	private int MarketId;
	
	/**
	 * A market's unique identifier
	 */
	public int getMarketId() {
		return MarketId;
	}
	
	public void setMarketId(int MarketId) {
		this.MarketId = MarketId;
	}
	private String Direction;
	
	/**
	 * Direction identifier for trade, values supported are buy or sell
	 */
	public String getDirection() {
		return Direction;
	}
	
	public void setDirection(String Direction) {
		this.Direction = Direction;
	}
	private double Quantity;
	
	/**
	 * Size of the order
	 */
	public double getQuantity() {
		return Quantity;
	}
	
	public void setQuantity(double Quantity) {
		this.Quantity = Quantity;
	}
	private double Price;
	
	/**
	 * The price at which the order is to be filled
	 */
	public double getPrice() {
		return Price;
	}
	
	public void setPrice(double Price) {
		this.Price = Price;
	}
	private double TradingAccountId;
	
	/**
	 * TradingAccount associated with the order
	 */
	public double getTradingAccountId() {
		return TradingAccountId;
	}
	
	public void setTradingAccountId(double TradingAccountId) {
		this.TradingAccountId = TradingAccountId;
	}
	private int CurrencyId;
	
	/**
	 * Currency id for order (as represented in the trading system)
	 */
	public int getCurrencyId() {
		return CurrencyId;
	}
	
	public void setCurrencyId(int CurrencyId) {
		this.CurrencyId = CurrencyId;
	}
	private int StatusId;
	
	/**
	 * Status id of order (as represented in the trading system)
	 */
	public int getStatusId() {
		return StatusId;
	}
	
	public void setStatusId(int StatusId) {
		this.StatusId = StatusId;
	}
	private int TypeId;
	
	/**
	 * The type of the order, Trade, stop or limit.
	 */
	public int getTypeId() {
		return TypeId;
	}
	
	public void setTypeId(int TypeId) {
		this.TypeId = TypeId;
	}
	private ApiIfDoneDTO[] IfDone;
	
	/**
	 * List of IfDone Orders which will be filled when the initial order is triggered
	 */
	public ApiIfDoneDTO[] getIfDone() {
		return IfDone;
	}
	
	public void setIfDone(ApiIfDoneDTO[] IfDone) {
		this.IfDone = IfDone;
	}
	private ApiStopLimitOrderDTO OcoOrder;
	
	/**
	 * Corresponding OcoOrder (One Cancels the Other)
	 */
	public ApiStopLimitOrderDTO getOcoOrder() {
		return OcoOrder;
	}
	
	public void setOcoOrder(ApiStopLimitOrderDTO OcoOrder) {
		this.OcoOrder = OcoOrder;
	}
}

