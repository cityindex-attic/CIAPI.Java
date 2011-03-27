package CIAPI.Java.examples.ciapi.dto;

/**
 * !This is an auto generated model object!
 *
 * A quote for a specific order request
 */
public class QuoteDTO {

	/**
	 * No argument constructor
	 */
	public QuoteDTO() {
	}

	
	private int QuoteId;
	
	/**
	 * 
	 * The uniqueId of the Quote
	 */
	public int getQuoteId() {
		return QuoteId;
	}

	private int OrderId;
	
	/**
	 * 
	 * The Order the Quote is related to
	 */
	public int getOrderId() {
		return OrderId;
	}

	private int MarketId;
	
	/**
	 * 
	 * The Market the Quote is related to
	 */
	public int getMarketId() {
		return MarketId;
	}

	private double BidPrice;
	
	/**
	 * 
	 * ????
	 */
	public double getBidPrice() {
		return BidPrice;
	}

	private double BidAdjust;
	
	/**
	 * 
	 * ????
	 */
	public double getBidAdjust() {
		return BidAdjust;
	}

	private double OfferPrice;
	
	/**
	 * 
	 * ???
	 */
	public double getOfferPrice() {
		return OfferPrice;
	}

	private double OfferAdjust;
	
	/**
	 * 
	 * ???
	 */
	public double getOfferAdjust() {
		return OfferAdjust;
	}

	private double Quantity;
	
	/**
	 * 
	 * ???
	 */
	public double getQuantity() {
		return Quantity;
	}

	private int CurrencyId;
	
	/**
	 * 
	 * ???
	 */
	public int getCurrencyId() {
		return CurrencyId;
	}

	private int StatusId;
	
	/**
	 * 
	 * ???
	 */
	public int getStatusId() {
		return StatusId;
	}

	private int TypeId;
	
	/**
	 * 
	 * ???
	 */
	public int getTypeId() {
		return TypeId;
	}

	private String RequestDateTime;
	
	/**
	 * 
	 * The timestamp the quote was requested. Always expressed in UTC
	 */
	public String getRequestDateTime() {
		return RequestDateTime;
	}

}

