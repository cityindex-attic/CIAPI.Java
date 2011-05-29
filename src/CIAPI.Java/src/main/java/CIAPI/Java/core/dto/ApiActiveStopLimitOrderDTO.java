package CIAPI.Java.core.dto;

/**
 * !This is an auto generated model object!
 *
 * A stop or limit order that is currently active.
 */
public class ApiActiveStopLimitOrderDTO {

	/**
	 * No argument constructor 
	 */
	public ApiActiveStopLimitOrderDTO() {
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
	private String ParentOrderId;
	
	/**
	 * The order's parent OrderId.
	 */
	public String getParentOrderId() {
		return ParentOrderId;
	}
	
	public void setParentOrderId(String ParentOrderId) {
		this.ParentOrderId = ParentOrderId;
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
	 * The quantity of the product.
	 */
	public double getQuantity() {
		return Quantity;
	}
	
	public void setQuantity(double Quantity) {
		this.Quantity = Quantity;
	}
	private double TriggerPrice;
	
	/**
	 * The marked to market price at which the order will trigger at.
	 */
	public double getTriggerPrice() {
		return TriggerPrice;
	}
	
	public void setTriggerPrice(double TriggerPrice) {
		this.TriggerPrice = TriggerPrice;
	}
	private double TradingAccountId;
	
	/**
	 * The trading account that the order is on.
	 */
	public double getTradingAccountId() {
		return TradingAccountId;
	}
	
	public void setTradingAccountId(double TradingAccountId) {
		this.TradingAccountId = TradingAccountId;
	}
	private int Type;
	
	/**
	 * The type of order, i.e. stop or limit.
	 */
	public int getType() {
		return Type;
	}
	
	public void setType(int Type) {
		this.Type = Type;
	}
	private int Applicability;
	
	/**
	 * When the order applies until. i.e. good till cancelled (GTC) good for day (GFD) or good till time (GTT).
	 */
	public int getApplicability() {
		return Applicability;
	}
	
	public void setApplicability(int Applicability) {
		this.Applicability = Applicability;
	}
	private String ExpiryDateTimeUTC;
	
	/**
	 * The associated expiry DateTime.
	 */
	public String getExpiryDateTimeUTC() {
		return ExpiryDateTimeUTC;
	}
	
	public void setExpiryDateTimeUTC(String ExpiryDateTimeUTC) {
		this.ExpiryDateTimeUTC = ExpiryDateTimeUTC;
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
	private ApiBasicStopLimitOrderDTO StopOrder;
	
	/**
	 * The if done stop order.
	 */
	public ApiBasicStopLimitOrderDTO getStopOrder() {
		return StopOrder;
	}
	
	public void setStopOrder(ApiBasicStopLimitOrderDTO StopOrder) {
		this.StopOrder = StopOrder;
	}
	private ApiBasicStopLimitOrderDTO LimitOrder;
	
	/**
	 * The if done limit order
	 */
	public ApiBasicStopLimitOrderDTO getLimitOrder() {
		return LimitOrder;
	}
	
	public void setLimitOrder(ApiBasicStopLimitOrderDTO LimitOrder) {
		this.LimitOrder = LimitOrder;
	}
	private ApiBasicStopLimitOrderDTO OcoOrder;
	
	/**
	 * The order on the other side of a one Cancels the other relationship.
	 */
	public ApiBasicStopLimitOrderDTO getOcoOrder() {
		return OcoOrder;
	}
	
	public void setOcoOrder(ApiBasicStopLimitOrderDTO OcoOrder) {
		this.OcoOrder = OcoOrder;
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

