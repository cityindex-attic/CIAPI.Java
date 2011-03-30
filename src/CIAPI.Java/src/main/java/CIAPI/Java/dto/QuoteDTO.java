package CIAPI.Java.dto;

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
	 * The uniqueId of the Quote
	 */
	public int getQuoteId() {
		return QuoteId;
	}
	
	public void setQuoteId(int QuoteId) {
		this.QuoteId = QuoteId;
	}

	private int OrderId;
	
	/**
	 * The Order the Quote is related to
	 */
	public int getOrderId() {
		return OrderId;
	}
	
	public void setOrderId(int OrderId) {
		this.OrderId = OrderId;
	}

	private int MarketId;
	
	/**
	 * The Market the Quote is related to
	 */
	public int getMarketId() {
		return MarketId;
	}
	
	public void setMarketId(int MarketId) {
		this.MarketId = MarketId;
	}

	private double BidPrice;
	
	/**
	 * The Price of the original Order request for a Buy
	 */
	public double getBidPrice() {
		return BidPrice;
	}
	
	public void setBidPrice(double BidPrice) {
		this.BidPrice = BidPrice;
	}

	private double BidAdjust;
	
	/**
	 * The amount the bid price will be adjusted to become an order when the customer is buying (BidPrice + BidAdjust = BuyPrice)
	 */
	public double getBidAdjust() {
		return BidAdjust;
	}
	
	public void setBidAdjust(double BidAdjust) {
		this.BidAdjust = BidAdjust;
	}

	private double OfferPrice;
	
	/**
	 * The Price of the original Order request for a Sell
	 */
	public double getOfferPrice() {
		return OfferPrice;
	}
	
	public void setOfferPrice(double OfferPrice) {
		this.OfferPrice = OfferPrice;
	}

	private double OfferAdjust;
	
	/**
	 * The amount the offer price will be adjusted to become an order when the customer is selling (OfferPrice + OfferAdjust = OfferPrice)
	 */
	public double getOfferAdjust() {
		return OfferAdjust;
	}
	
	public void setOfferAdjust(double OfferAdjust) {
		this.OfferAdjust = OfferAdjust;
	}

	private double Quantity;
	
	/**
	 * The Quantity is the number of units for the trade i.e CFD Quantity = Number of CFD's to Buy or Sell , FX Quantity = Number of Currency points TODO Clarify
	 */
	public double getQuantity() {
		return Quantity;
	}
	
	public void setQuantity(double Quantity) {
		this.Quantity = Quantity;
	}

	private int CurrencyId;
	
	/**
	 * The system internal Id for the ISO Currency the equivalent ISO Code can be found using the API Call TODO Fill when the API call is available
	 */
	public int getCurrencyId() {
		return CurrencyId;
	}
	
	public void setCurrencyId(int CurrencyId) {
		this.CurrencyId = CurrencyId;
	}

	private int StatusId;
	
	/**
	 * The Status of the Quote. The list of different Status values can be found using the API call TODO Fill when call avaliable
	 */
	public int getStatusId() {
		return StatusId;
	}
	
	public void setStatusId(int StatusId) {
		this.StatusId = StatusId;
	}

	private int TypeId;
	
	/**
	 * The reason for the Quote i.e you asked for a quote , a order was requested over a size limit
	 */
	public int getTypeId() {
		return TypeId;
	}
	
	public void setTypeId(int TypeId) {
		this.TypeId = TypeId;
	}

	private String RequestDateTime;
	
	/**
	 * The timestamp the quote was requested. Always expressed in UTC
	 */
	public String getRequestDateTime() {
		return RequestDateTime;
	}
	
	public void setRequestDateTime(String RequestDateTime) {
		this.RequestDateTime = RequestDateTime;
	}

}

