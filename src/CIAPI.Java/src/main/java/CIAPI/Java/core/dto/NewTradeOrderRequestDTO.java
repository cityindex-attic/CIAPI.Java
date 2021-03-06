package CIAPI.Java.core.dto;

/**
 * !This is an auto generated model object!
 *
 * A request for a trade order
 */
public class NewTradeOrderRequestDTO {

	/**
	 * No argument constructor 
	 */
	public NewTradeOrderRequestDTO() {
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
	private int QuoteId;
	
	/**
	 * Quote Id
	 */
	public int getQuoteId() {
		return QuoteId;
	}
	
	public void setQuoteId(int QuoteId) {
		this.QuoteId = QuoteId;
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
	private ApiIfDoneDTO[] IfDone;
	
	/**
	 * List of IfDone Orders which will be filled when the initial trade/order is triggered
	 */
	public ApiIfDoneDTO[] getIfDone() {
		return IfDone;
	}
	
	public void setIfDone(ApiIfDoneDTO[] IfDone) {
		this.IfDone = IfDone;
	}
	private int[] Close;
	
	/**
	 * List of existing order id's that require part or full closure
	 */
	public int[] getClose() {
		return Close;
	}
	
	public void setClose(int[] Close) {
		this.Close = Close;
	}
}

