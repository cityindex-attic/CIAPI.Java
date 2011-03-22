package CIAPI.Java.examples.ciapi.dto;

/**
 * !This is an auto generated model object!
 *
 */
public class ApiActiveStopLimitOrderDTO {
	
	private int OrderId;
	
	public int getOrderId() {
		return OrderId;
	}
	

	private String ParentOrderId;
	
	public String getParentOrderId() {
		return ParentOrderId;
	}
	

	private int MarketId;
	
	public int getMarketId() {
		return MarketId;
	}
	

	private String MarketName;
	
	public String getMarketName() {
		return MarketName;
	}
	

	private String Direction;
	
	public String getDirection() {
		return Direction;
	}
	

	private double Quantity;
	
	public double getQuantity() {
		return Quantity;
	}
	

	private double TriggerPrice;
	
	public double getTriggerPrice() {
		return TriggerPrice;
	}
	

	private double TradingAccountId;
	
	public double getTradingAccountId() {
		return TradingAccountId;
	}
	

	private int Type;
	
	public int getType() {
		return Type;
	}
	

	private int Applicability;
	
	public int getApplicability() {
		return Applicability;
	}
	

	private String Currency;
	
	public String getCurrency() {
		return Currency;
	}
	

	private int Status;
	
	public int getStatus() {
		return Status;
	}
	

	private CIAPI.Java.examples.ciapi.dto.ApiBasicStopLimitOrderDTO StopOrder;
	
	public CIAPI.Java.examples.ciapi.dto.ApiBasicStopLimitOrderDTO getStopOrder() {
		return StopOrder;
	}
	

	private CIAPI.Java.examples.ciapi.dto.ApiBasicStopLimitOrderDTO LimitOrder;
	
	public CIAPI.Java.examples.ciapi.dto.ApiBasicStopLimitOrderDTO getLimitOrder() {
		return LimitOrder;
	}
	

	private CIAPI.Java.examples.ciapi.dto.ApiBasicStopLimitOrderDTO OcoOrder;
	
	public CIAPI.Java.examples.ciapi.dto.ApiBasicStopLimitOrderDTO getOcoOrder() {
		return OcoOrder;
	}
	

	private String LastChangedDateTimeUTC;
	
	public String getLastChangedDateTimeUTC() {
		return LastChangedDateTimeUTC;
	}
	

}

