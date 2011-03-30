package CIAPI.Java.dto;

/**
 * !This is an auto generated model object!
 *
 * An order for a specific Trading Account
 */
public class OrderDTO {

	/**
	 * No argument constructor
	 */
	public OrderDTO() {
	}

	
	private int OrderId;
	
	/**
	 * ???
	 */
	public int getOrderId() {
		return OrderId;
	}
	
	public void setOrderId(int OrderId) {
		this.OrderId = OrderId;
	}

	private int MarketId;
	
	/**
	 * ???
	 */
	public int getMarketId() {
		return MarketId;
	}
	
	public void setMarketId(int MarketId) {
		this.MarketId = MarketId;
	}

	private int ClientAccountId;
	
	/**
	 * ???
	 */
	public int getClientAccountId() {
		return ClientAccountId;
	}
	
	public void setClientAccountId(int ClientAccountId) {
		this.ClientAccountId = ClientAccountId;
	}

	private int TradingAccountId;
	
	/**
	 * ???
	 */
	public int getTradingAccountId() {
		return TradingAccountId;
	}
	
	public void setTradingAccountId(int TradingAccountId) {
		this.TradingAccountId = TradingAccountId;
	}

	private int CurrencyId;
	
	/**
	 * ???
	 */
	public int getCurrencyId() {
		return CurrencyId;
	}
	
	public void setCurrencyId(int CurrencyId) {
		this.CurrencyId = CurrencyId;
	}

	private String CurrencyISO;
	
	/**
	 * ???
	 */
	public String getCurrencyISO() {
		return CurrencyISO;
	}
	
	public void setCurrencyISO(String CurrencyISO) {
		this.CurrencyISO = CurrencyISO;
	}

	private int Direction;
	
	/**
	 * ???
	 */
	public int getDirection() {
		return Direction;
	}
	
	public void setDirection(int Direction) {
		this.Direction = Direction;
	}

	private boolean AutoRollover;
	
	/**
	 * ???
	 */
	public boolean getAutoRollover() {
		return AutoRollover;
	}
	
	public void setAutoRollover(boolean AutoRollover) {
		this.AutoRollover = AutoRollover;
	}

	private double ExecutionPrice;
	
	/**
	 * ???
	 */
	public double getExecutionPrice() {
		return ExecutionPrice;
	}
	
	public void setExecutionPrice(double ExecutionPrice) {
		this.ExecutionPrice = ExecutionPrice;
	}

	private String LastChangedTime;
	
	/**
	 * The date of the Order. Always expressed in UTC
	 */
	public String getLastChangedTime() {
		return LastChangedTime;
	}
	
	public void setLastChangedTime(String LastChangedTime) {
		this.LastChangedTime = LastChangedTime;
	}

	private double OpenPrice;
	
	/**
	 * ???
	 */
	public double getOpenPrice() {
		return OpenPrice;
	}
	
	public void setOpenPrice(double OpenPrice) {
		this.OpenPrice = OpenPrice;
	}

	private String OriginalLastChangedDateTime;
	
	/**
	 * The date of the Order. Always expressed in UTC
	 */
	public String getOriginalLastChangedDateTime() {
		return OriginalLastChangedDateTime;
	}
	
	public void setOriginalLastChangedDateTime(String OriginalLastChangedDateTime) {
		this.OriginalLastChangedDateTime = OriginalLastChangedDateTime;
	}

	private double OriginalQuantity;
	
	/**
	 * ???
	 */
	public double getOriginalQuantity() {
		return OriginalQuantity;
	}
	
	public void setOriginalQuantity(double OriginalQuantity) {
		this.OriginalQuantity = OriginalQuantity;
	}

	private double Quantity;
	
	/**
	 * ???
	 */
	public double getQuantity() {
		return Quantity;
	}
	
	public void setQuantity(double Quantity) {
		this.Quantity = Quantity;
	}

	private String Type;
	
	/**
	 * ???
	 */
	public String getType() {
		return Type;
	}
	
	public void setType(String Type) {
		this.Type = Type;
	}

	private String Status;
	
	/**
	 * ???
	 */
	public String getStatus() {
		return Status;
	}
	
	public void setStatus(String Status) {
		this.Status = Status;
	}

	private int ReasonId;
	
	/**
	 * ???
	 */
	public int getReasonId() {
		return ReasonId;
	}
	
	public void setReasonId(int ReasonId) {
		this.ReasonId = ReasonId;
	}

}

