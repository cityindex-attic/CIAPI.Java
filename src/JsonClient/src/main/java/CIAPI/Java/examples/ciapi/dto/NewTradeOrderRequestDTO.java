package CIAPI.Java.examples.ciapi.dto;

/**
 * !This is an auto generated model object!
 *
 * A request for a trade order
 */
public class NewTradeOrderRequestDTO {
	
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
	

	private CIAPI.Java.examples.ciapi.dto.GatewayIfDoneDTO[] IfDone;
	
	public CIAPI.Java.examples.ciapi.dto.GatewayIfDoneDTO[] getIfDone() {
		return IfDone;
	}
	

	private int[] Close;
	
	public int[] getClose() {
		return Close;
	}
	

}

