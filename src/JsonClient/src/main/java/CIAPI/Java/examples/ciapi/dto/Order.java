package CIAPI.Java.examples.ciapi.dto;

public class Order {

	private int OrderId;
	private int MarketId;
	private int ClientAccountId;
	private int TradingAccountId;
	private int CurrencyId;
	private String CurrencyISO;
	private int Direction;
	private boolean AutoRollover;
	private double ExecutionPrice;
	private String LastChangedTime;
	private double OpenPrice;
	private String OriginalLastChangedDateTime;
	private double OriginalQuantity;
	private double Quantity;
	private String Type;
	private String Status;
	private int ReasonId;

	public int getOrderId() {
		return OrderId;
	}

	public int getMarketId() {
		return MarketId;
	}

	public int getClientAccountId() {
		return ClientAccountId;
	}

	public int getTradingAccountId() {
		return TradingAccountId;
	}

	public int getCurrencyId() {
		return CurrencyId;
	}

	public String getCurrencyISO() {
		return CurrencyISO;
	}

	public int getDirection() {
		return Direction;
	}

	public boolean isAutoRollover() {
		return AutoRollover;
	}

	public double getExecutionPrice() {
		return ExecutionPrice;
	}

	public String getLastChangedTime() {
		return LastChangedTime;
	}

	public double getOpenPrice() {
		return OpenPrice;
	}

	public String getOriginalLastChangedDateTime() {
		return OriginalLastChangedDateTime;
	}

	public double getOriginalQuantity() {
		return OriginalQuantity;
	}

	public double getQuantity() {
		return Quantity;
	}

	public String getType() {
		return Type;
	}

	public String getStatus() {
		return Status;
	}

	public int getReasonId() {
		return ReasonId;
	}
}
