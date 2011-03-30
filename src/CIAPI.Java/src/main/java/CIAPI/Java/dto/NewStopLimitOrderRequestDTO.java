package CIAPI.Java.dto;

/**
 * !This is an auto generated model object!
 *
 * A request for a stop/limit order
 */
public class NewStopLimitOrderRequestDTO {

	/**
	 * No argument constructor
	 */
	public NewStopLimitOrderRequestDTO() {
	}

	
	private int OrderId;
	
	/**
	 * Order identifier of the order to update
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

	private String Currency;
	
	/**
	 * Currency to place order in
	 */
	public String getCurrency() {
		return Currency;
	}
	
	public void setCurrency(String Currency) {
		this.Currency = Currency;
	}

	private boolean AutoRollover;
	
	/**
	 * Flag to indicate whether the trade will automatically roll into the next market when the current market expires
	 */
	public boolean getAutoRollover() {
		return AutoRollover;
	}
	
	public void setAutoRollover(boolean AutoRollover) {
		this.AutoRollover = AutoRollover;
	}

	private String Direction;
	
	/**
	 * Direction identifier for order/trade, values supported are buy or sell
	 */
	public String getDirection() {
		return Direction;
	}
	
	public void setDirection(String Direction) {
		this.Direction = Direction;
	}

	private double Quantity;
	
	/**
	 * Size of the order/trade
	 */
	public double getQuantity() {
		return Quantity;
	}
	
	public void setQuantity(double Quantity) {
		this.Quantity = Quantity;
	}

	private double BidPrice;
	
	/**
	 * Market prices are quoted as a pair (buy/sell or bid/offer), the BidPrice is the lower of the two
	 */
	public double getBidPrice() {
		return BidPrice;
	}
	
	public void setBidPrice(double BidPrice) {
		this.BidPrice = BidPrice;
	}

	private double OfferPrice;
	
	/**
	 * Market prices are quote as a pair (buy/sell or bid/offer), the OfferPrice is the higher of the market price pair
	 */
	public double getOfferPrice() {
		return OfferPrice;
	}
	
	public void setOfferPrice(double OfferPrice) {
		this.OfferPrice = OfferPrice;
	}

	private String AuditId;
	
	/**
	 * Unique identifier for a price tick
	 */
	public String getAuditId() {
		return AuditId;
	}
	
	public void setAuditId(String AuditId) {
		this.AuditId = AuditId;
	}

	private int TradingAccountId;
	
	/**
	 * TradingAccount associated with the trade/order request
	 */
	public int getTradingAccountId() {
		return TradingAccountId;
	}
	
	public void setTradingAccountId(int TradingAccountId) {
		this.TradingAccountId = TradingAccountId;
	}

	private CIAPI.Java.dto.GatewayIfDoneDTO[] IfDone;
	
	/**
	 * List of IfDone Orders which will be filled when the initial trade/order is triggered
	 */
	public CIAPI.Java.dto.GatewayIfDoneDTO[] getIfDone() {
		return IfDone;
	}
	
	public void setIfDone(CIAPI.Java.dto.GatewayIfDoneDTO[] IfDone) {
		this.IfDone = IfDone;
	}

	private CIAPI.Java.dto.NewStopLimitOrderRequestDTO OcoOrder;
	
	/**
	 * Corresponding OcoOrder (One Cancels the Other)
	 */
	public CIAPI.Java.dto.NewStopLimitOrderRequestDTO getOcoOrder() {
		return OcoOrder;
	}
	
	public void setOcoOrder(CIAPI.Java.dto.NewStopLimitOrderRequestDTO OcoOrder) {
		this.OcoOrder = OcoOrder;
	}

	private String Applicability;
	
	/**
	 * Identifier which relates to the expiry of the order/trade, i.e. GoodTillDate (GTD), GoodTillCancelled (GTC) or GoodForDay (GFD)
	 */
	public String getApplicability() {
		return Applicability;
	}
	
	public void setApplicability(String Applicability) {
		this.Applicability = Applicability;
	}

	private String ExpiryDateTimeUTC;
	
	/**
	 * The associated expiry DateTime for a pair of GoodTillDate IfDone orders
	 */
	public String getExpiryDateTimeUTC() {
		return ExpiryDateTimeUTC;
	}
	
	public void setExpiryDateTimeUTC(String ExpiryDateTimeUTC) {
		this.ExpiryDateTimeUTC = ExpiryDateTimeUTC;
	}

	private boolean Guaranteed;
	
	/**
	 * Flag to determine whether an order is guaranteed to trigger and fill at the associated trigger price
	 */
	public boolean getGuaranteed() {
		return Guaranteed;
	}
	
	public void setGuaranteed(boolean Guaranteed) {
		this.Guaranteed = Guaranteed;
	}

	private double TriggerPrice;
	
	/**
	 * Price at which the order is intended to be triggered
	 */
	public double getTriggerPrice() {
		return TriggerPrice;
	}
	
	public void setTriggerPrice(double TriggerPrice) {
		this.TriggerPrice = TriggerPrice;
	}

}

