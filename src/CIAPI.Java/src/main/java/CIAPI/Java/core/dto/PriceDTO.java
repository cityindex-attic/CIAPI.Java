package CIAPI.Java.core.dto;

/**
 * !This is an auto generated model object!
 *
 * A Price for a specific Market.
 */
public class PriceDTO {

	/**
	 * No argument constructor 
	 */
	public PriceDTO() {
	}
	
	private int MarketId;
	
	/**
	 * The Market that the Price is related to.
	 */
	public int getMarketId() {
		return MarketId;
	}
	
	public void setMarketId(int MarketId) {
		this.MarketId = MarketId;
	}
	private String TickDate;
	
	/**
	 * The date of the Price. Always expressed in UTC.
	 */
	public String getTickDate() {
		return TickDate;
	}
	
	public void setTickDate(String TickDate) {
		this.TickDate = TickDate;
	}
	private double Bid;
	
	/**
	 * The current Bid price (price at which the customer can sell).
	 */
	public double getBid() {
		return Bid;
	}
	
	public void setBid(double Bid) {
		this.Bid = Bid;
	}
	private double Offer;
	
	/**
	 * The current Offer price (price at which the customer can buy, some times referred to as Ask price).
	 */
	public double getOffer() {
		return Offer;
	}
	
	public void setOffer(double Offer) {
		this.Offer = Offer;
	}
	private double Price;
	
	/**
	 * The current mid price.
	 */
	public double getPrice() {
		return Price;
	}
	
	public void setPrice(double Price) {
		this.Price = Price;
	}
	private double High;
	
	/**
	 * The highest price reached for the day.
	 */
	public double getHigh() {
		return High;
	}
	
	public void setHigh(double High) {
		this.High = High;
	}
	private double Low;
	
	/**
	 * The lowest price reached for the day
	 */
	public double getLow() {
		return Low;
	}
	
	public void setLow(double Low) {
		this.Low = Low;
	}
	private double Change;
	
	/**
	 * The change since the last price (always positive. See Direction for direction)
	 */
	public double getChange() {
		return Change;
	}
	
	public void setChange(double Change) {
		this.Change = Change;
	}
	private int Direction;
	
	/**
	 * The direction of movement since the last price. 1 == up, 0 == down
	 */
	public int getDirection() {
		return Direction;
	}
	
	public void setDirection(int Direction) {
		this.Direction = Direction;
	}
	private String AuditId;
	
	/**
	 * A unique id for this price. Treat as a unique, but random string
	 */
	public String getAuditId() {
		return AuditId;
	}
	
	public void setAuditId(String AuditId) {
		this.AuditId = AuditId;
	}
}

