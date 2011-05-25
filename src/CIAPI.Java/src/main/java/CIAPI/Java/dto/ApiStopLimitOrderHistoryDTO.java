package CIAPI.Java.dto;

/**
 * !This is an auto generated model object!
 *
 * A stop or limit order from a historical perspective.
 */
public class ApiStopLimitOrderHistoryDTO {

	/**
	 * No argument constructor 
	 */
	public ApiStopLimitOrderHistoryDTO() {
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
	private double OriginalQuantity;
	
	/**
	 * The quantity of the order when it became a trade / was cancelled etc.
	 */
	public double getOriginalQuantity() {
		return OriginalQuantity;
	}
	
	public void setOriginalQuantity(double OriginalQuantity) {
		this.OriginalQuantity = OriginalQuantity;
	}
	private String Price;
	
	/**
	 * The price / rate that the order was filled at.
	 */
	public String getPrice() {
		return Price;
	}
	
	public void setPrice(String Price) {
		this.Price = Price;
	}
	private double TriggerPrice;
	
	/**
	 * The price / rate that the the order was set to trigger at.
	 */
	public double getTriggerPrice() {
		return TriggerPrice;
	}
	
	public void setTriggerPrice(double TriggerPrice) {
		this.TriggerPrice = TriggerPrice;
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
	private int TypeId;
	
	/**
	 * The type of the order stop, limit or trade.
	 */
	public int getTypeId() {
		return TypeId;
	}
	
	public void setTypeId(int TypeId) {
		this.TypeId = TypeId;
	}
	private int OrderApplicabilityId;
	
	/**
	 * When the order applies until. i.e. good till cancelled (GTC) good for day (GFD) or good till time (GTT).
	 */
	public int getOrderApplicabilityId() {
		return OrderApplicabilityId;
	}
	
	public void setOrderApplicabilityId(int OrderApplicabilityId) {
		this.OrderApplicabilityId = OrderApplicabilityId;
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
	private int StatusId;
	
	/**
	 * the order status.
	 */
	public int getStatusId() {
		return StatusId;
	}
	
	public void setStatusId(int StatusId) {
		this.StatusId = StatusId;
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

