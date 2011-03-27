package CIAPI.Java.examples.ciapi.dto;

/**
 * !This is an auto generated model object!
 *
 * A Price for a specific Market
 */
public class PriceDTO {

	/**
	 * No argument constructor
	 */
	public PriceDTO() {
	}

	
	private int MarketId;
	
	/**
	 * 
	 * The Market that the Price is related to
	 */
	public int getMarketId() {
		return MarketId;
	}

	private String TickDate;
	
	/**
	 * 
	 * The date of the Price. Always expressed in UTC
	 */
	public String getTickDate() {
		return TickDate;
	}

	private double Bid;
	
	/**
	 * 
	 * The current Bid price (price at which the customer can sell)
	 */
	public double getBid() {
		return Bid;
	}

	private double Offer;
	
	/**
	 * 
	 * The current Offer price (price at which the customer can buy)
	 */
	public double getOffer() {
		return Offer;
	}

	private double Price;
	
	/**
	 * 
	 * The current mid price
	 */
	public double getPrice() {
		return Price;
	}

	private double High;
	
	/**
	 * 
	 * The highest price reached for the day
	 */
	public double getHigh() {
		return High;
	}

	private double Low;
	
	/**
	 * 
	 * The lowest price reached for the day
	 */
	public double getLow() {
		return Low;
	}

	private double Change;
	
	/**
	 * 
	 * The change since the last price (always positive. See Direction for direction)
	 */
	public double getChange() {
		return Change;
	}

	private int Direction;
	
	/**
	 * 
	 * The direction of movement since the last price. 1 == up, 0 == down
	 */
	public int getDirection() {
		return Direction;
	}

	private String AuditId;
	
	/**
	 * 
	 * A unique id for this price. Treat as a unique, but random string
	 */
	public String getAuditId() {
		return AuditId;
	}

}

