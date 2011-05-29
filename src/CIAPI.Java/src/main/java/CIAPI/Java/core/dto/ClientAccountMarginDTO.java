package CIAPI.Java.core.dto;

/**
 * !This is an auto generated model object!
 *
 * The current margin for a specific client account
 */
public class ClientAccountMarginDTO {

	/**
	 * No argument constructor 
	 */
	public ClientAccountMarginDTO() {
	}
	
	private double Cash;
	
	/**
	 * cash balance expressed in the clients base currency.
	 */
	public double getCash() {
		return Cash;
	}
	
	public void setCash(double Cash) {
		this.Cash = Cash;
	}
	private double Margin;
	
	/**
	 * The client account's total margin requirement expressed in base currency.
	 */
	public double getMargin() {
		return Margin;
	}
	
	public void setMargin(double Margin) {
		this.Margin = Margin;
	}
	private double MarginIndicator;
	
	/**
	 * Margin indicator expressed as a percentage.
	 */
	public double getMarginIndicator() {
		return MarginIndicator;
	}
	
	public void setMarginIndicator(double MarginIndicator) {
		this.MarginIndicator = MarginIndicator;
	}
	private double NetEquity;
	
	/**
	 * Net equity expressed in the clients base currency.
	 */
	public double getNetEquity() {
		return NetEquity;
	}
	
	public void setNetEquity(double NetEquity) {
		this.NetEquity = NetEquity;
	}
	private double OpenTradeEquity;
	
	/**
	 * open trade equity (open / unrealised PNL) expressed in the client's base currency.
	 */
	public double getOpenTradeEquity() {
		return OpenTradeEquity;
	}
	
	public void setOpenTradeEquity(double OpenTradeEquity) {
		this.OpenTradeEquity = OpenTradeEquity;
	}
	private double TradeableFunds;
	
	/**
	 * tradable funds expressed in the client's base currency.
	 */
	public double getTradeableFunds() {
		return TradeableFunds;
	}
	
	public void setTradeableFunds(double TradeableFunds) {
		this.TradeableFunds = TradeableFunds;
	}
	private double PendingFunds;
	
	/**
	 * N/A
	 */
	public double getPendingFunds() {
		return PendingFunds;
	}
	
	public void setPendingFunds(double PendingFunds) {
		this.PendingFunds = PendingFunds;
	}
	private double TradingResource;
	
	/**
	 * trading resource expressed in the client's base currency.
	 */
	public double getTradingResource() {
		return TradingResource;
	}
	
	public void setTradingResource(double TradingResource) {
		this.TradingResource = TradingResource;
	}
	private double TotalMarginRequirement;
	
	/**
	 * total margin requirement expressed in the client's base currency.
	 */
	public double getTotalMarginRequirement() {
		return TotalMarginRequirement;
	}
	
	public void setTotalMarginRequirement(double TotalMarginRequirement) {
		this.TotalMarginRequirement = TotalMarginRequirement;
	}
	private int CurrencyId;
	
	/**
	 * The clients base currency id.
	 */
	public int getCurrencyId() {
		return CurrencyId;
	}
	
	public void setCurrencyId(int CurrencyId) {
		this.CurrencyId = CurrencyId;
	}
	private String CurrencyISO;
	
	/**
	 * The clients base currency iso code.
	 */
	public String getCurrencyISO() {
		return CurrencyISO;
	}
	
	public void setCurrencyISO(String CurrencyISO) {
		this.CurrencyISO = CurrencyISO;
	}
}

