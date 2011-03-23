package CIAPI.Java.examples.ciapi.dto;

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

	
	private int MarketId;
	
	public int getMarketId() {
		return MarketId;
	}
	

	private String Direction;
	
	public String getDirection() {
		return Direction;
	}
	

	private double Quantity;
	
	public double getQuantity() {
		return Quantity;
	}
	

	private double BidPrice;
	
	public double getBidPrice() {
		return BidPrice;
	}
	

	private double OfferPrice;
	
	public double getOfferPrice() {
		return OfferPrice;
	}
	

	private String AuditId;
	
	public String getAuditId() {
		return AuditId;
	}
	

	private int TradingAccountId;
	
	public int getTradingAccountId() {
		return TradingAccountId;
	}
	

	private String Applicability;
	
	public String getApplicability() {
		return Applicability;
	}
	

	private String ExpiryDateTimeUTC;
	
	public String getExpiryDateTimeUTC() {
		return ExpiryDateTimeUTC;
	}
	

}

