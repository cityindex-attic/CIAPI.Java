package CIAPI.Java.examples.ciapi.dto;

/**
 * !This is an auto generated model object!
 *
 * TODO
 */
public class ApiActiveStopLimitOrderDTO {

	/**
	 * No argument constructor
	 */
	public ApiActiveStopLimitOrderDTO() {
	}

	
	private int OrderId;
	
	public int getOrderId() {
		return OrderId;
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
	

	private String Type;
	
	public String getType() {
		return Type;
	}
	

	private String Applicability;
	
	public String getApplicability() {
		return Applicability;
	}
	

	private String Currency;
	
	public String getCurrency() {
		return Currency;
	}
	

	private String Status;
	
	public String getStatus() {
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

