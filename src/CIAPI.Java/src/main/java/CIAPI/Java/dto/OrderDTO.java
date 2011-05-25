package CIAPI.Java.dto;

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
	 * Order id
	 */
	public int getOrderId() {
		return OrderId;
	}
	
	public void setOrderId(int OrderId) {
		this.OrderId = OrderId;
	}
	private int MarketId;
	
	/**
	 * Market id.
	 */
	public int getMarketId() {
		return MarketId;
	}
	
	public void setMarketId(int MarketId) {
		this.MarketId = MarketId;
	}
	private int ClientAccountId;
	
	/**
	 * Client account id.
	 */
	public int getClientAccountId() {
		return ClientAccountId;
	}
	
	public void setClientAccountId(int ClientAccountId) {
		this.ClientAccountId = ClientAccountId;
	}
	private int TradingAccountId;
	
	/**
	 * Trading account id.
	 */
	public int getTradingAccountId() {
		return TradingAccountId;
	}
	
	public void setTradingAccountId(int TradingAccountId) {
		this.TradingAccountId = TradingAccountId;
	}
	private int CurrencyId;
	
	/**
	 * Trade currency id.
	 */
	public int getCurrencyId() {
		return CurrencyId;
	}
	
	public void setCurrencyId(int CurrencyId) {
		this.CurrencyId = CurrencyId;
	}
	private String CurrencyISO;
	
	/**
	 * Trade currency ISO code.
	 */
	public String getCurrencyISO() {
		return CurrencyISO;
	}
	
	public void setCurrencyISO(String CurrencyISO) {
		this.CurrencyISO = CurrencyISO;
	}
	private int Direction;
	
	/**
	 * direction of the order.
	 */
	public int getDirection() {
		return Direction;
	}
	
	public void setDirection(int Direction) {
		this.Direction = Direction;
	}
	private boolean AutoRollover;
	
	/**
	 * Does the order automatically roll over.
	 */
	public boolean getAutoRollover() {
		return AutoRollover;
	}
	
	public void setAutoRollover(boolean AutoRollover) {
		this.AutoRollover = AutoRollover;
	}
	private double ExecutionPrice;
	
	/**
	 * the price the order was executed at.
	 */
	public double getExecutionPrice() {
		return ExecutionPrice;
	}
	
	public void setExecutionPrice(double ExecutionPrice) {
		this.ExecutionPrice = ExecutionPrice;
	}
	private String LastChangedTime;
	
	/**
	 * The date time that the order was last changed. Always expressed in UTC.
	 */
	public String getLastChangedTime() {
		return LastChangedTime;
	}
	
	public void setLastChangedTime(String LastChangedTime) {
		this.LastChangedTime = LastChangedTime;
	}
	private double OpenPrice;
	
	/**
	 * the open price of the order.
	 */
	public double getOpenPrice() {
		return OpenPrice;
	}
	
	public void setOpenPrice(double OpenPrice) {
		this.OpenPrice = OpenPrice;
	}
	private String OriginalLastChangedDateTime;
	
	/**
	 * The date of the Order. Always expressed in UTC
	 */
	public String getOriginalLastChangedDateTime() {
		return OriginalLastChangedDateTime;
	}
	
	public void setOriginalLastChangedDateTime(String OriginalLastChangedDateTime) {
		this.OriginalLastChangedDateTime = OriginalLastChangedDateTime;
	}
	private double OriginalQuantity;
	
	/**
	 * The orders original quantity, before any part / full closures.
	 */
	public double getOriginalQuantity() {
		return OriginalQuantity;
	}
	
	public void setOriginalQuantity(double OriginalQuantity) {
		this.OriginalQuantity = OriginalQuantity;
	}
	private int PositionMethodId;
	
	/**
	 * The position method of the order.
	 */
	public int getPositionMethodId() {
		return PositionMethodId;
	}
	
	public void setPositionMethodId(int PositionMethodId) {
		this.PositionMethodId = PositionMethodId;
	}
	private double Quantity;
	
	/**
	 * The current quantity of the order.
	 */
	public double getQuantity() {
		return Quantity;
	}
	
	public void setQuantity(double Quantity) {
		this.Quantity = Quantity;
	}
	private String Type;
	
	/**
	 * the type of the order (1 = Trade / 2 = Stop / 3 = Limit)
	 */
	public String getType() {
		return Type;
	}
	
	public void setType(String Type) {
		this.Type = Type;
	}
	private String Status;
	
	/**
	 * The order status id.
	 */
	public String getStatus() {
		return Status;
	}
	
	public void setStatus(String Status) {
		this.Status = Status;
	}
	private int ReasonId;
	
	/**
	 * the order status reason is.
	 */
	public int getReasonId() {
		return ReasonId;
	}
	
	public void setReasonId(int ReasonId) {
		this.ReasonId = ReasonId;
	}
}

