package CIAPI.Java.examples.ciapi.dto;

/**
 * !This is an auto generated model object!
 *
 * A request for a stop/limit order
 */
public class NewStopLimitOrderRequestDTO {
	
	private int OrderId;
	
	public int getOrderId() {
		return OrderId;
	}
	

	private int MarketId;
	
	public int getMarketId() {
		return MarketId;
	}
	

	private String Currency;
	
	public String getCurrency() {
		return Currency;
	}
	

	private boolean AutoRollover;
	
	public boolean getAutoRollover() {
		return AutoRollover;
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
	

	private CIAPI.Java.examples.ciapi.dto.GatewayIfDoneDTO[] IfDone;
	
	public CIAPI.Java.examples.ciapi.dto.GatewayIfDoneDTO[] getIfDone() {
		return IfDone;
	}
	

	private CIAPI.Java.examples.ciapi.dto.NewStopLimitOrderRequestDTO OcoOrder;
	
	public CIAPI.Java.examples.ciapi.dto.NewStopLimitOrderRequestDTO getOcoOrder() {
		return OcoOrder;
	}
	

	private String Applicability;
	
	public String getApplicability() {
		return Applicability;
	}
	

	private String ExpiryDateTimeUTC;
	
	public String getExpiryDateTimeUTC() {
		return ExpiryDateTimeUTC;
	}
	

	private boolean Guaranteed;
	
	public boolean getGuaranteed() {
		return Guaranteed;
	}
	

	private double TriggerPrice;
	
	public double getTriggerPrice() {
		return TriggerPrice;
	}
	

}

