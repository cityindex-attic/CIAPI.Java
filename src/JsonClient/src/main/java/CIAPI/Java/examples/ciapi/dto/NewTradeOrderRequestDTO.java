package CIAPI.Java.examples.ciapi.dto;

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
	 * 
	 * A market's unique identifier
	 */
	public int getMarketId() {
		return MarketId;
	}

	private String Direction;
	
	/**
	 * 
	 * Direction identifier for order/trade, values supported are buy or sell
	 */
	public String getDirection() {
		return Direction;
	}

	private double Quantity;
	
	/**
	 * 
	 * Size of the order/trade
	 */
	public double getQuantity() {
		return Quantity;
	}

	private double BidPrice;
	
	/**
	 * 
	 * Market prices are quoted as a pair (buy/sell or bid/offer), the BidPrice is the lower of the two
	 */
	public double getBidPrice() {
		return BidPrice;
	}

	private double OfferPrice;
	
	/**
	 * 
	 * Market prices are quote as a pair (buy/sell or bid/offer), the OfferPrice is the higher of the market price pair
	 */
	public double getOfferPrice() {
		return OfferPrice;
	}

	private String AuditId;
	
	/**
	 * 
	 * Unique identifier for a price tick
	 */
	public String getAuditId() {
		return AuditId;
	}

	private int TradingAccountId;
	
	/**
	 * 
	 * TradingAccount associated with the trade/order request
	 */
	public int getTradingAccountId() {
		return TradingAccountId;
	}

}

