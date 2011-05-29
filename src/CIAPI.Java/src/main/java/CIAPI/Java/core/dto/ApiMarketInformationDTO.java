package CIAPI.Java.core.dto;

/**
 * !This is an auto generated model object!
 *
 * Contains market information.
 */
public class ApiMarketInformationDTO {

	/**
	 * No argument constructor 
	 */
	public ApiMarketInformationDTO() {
	}
	
	private int MarketId;
	
	/**
	 * market id.
	 */
	public int getMarketId() {
		return MarketId;
	}
	
	public void setMarketId(int MarketId) {
		this.MarketId = MarketId;
	}
	private String Name;
	
	/**
	 * The market name
	 */
	public String getName() {
		return Name;
	}
	
	public void setName(String Name) {
		this.Name = Name;
	}
	private String MarginFactor;
	
	/**
	 * Margin factor, expressed as points or a percentage.
	 */
	public String getMarginFactor() {
		return MarginFactor;
	}
	
	public void setMarginFactor(String MarginFactor) {
		this.MarginFactor = MarginFactor;
	}
	private String MinDistance;
	
	/**
	 * The minimum distance from the current price you can place an order.
	 */
	public String getMinDistance() {
		return MinDistance;
	}
	
	public void setMinDistance(String MinDistance) {
		this.MinDistance = MinDistance;
	}
	private String WebMinSize;
	
	/**
	 * The minimum quantity that can be traded over the web.
	 */
	public String getWebMinSize() {
		return WebMinSize;
	}
	
	public void setWebMinSize(String WebMinSize) {
		this.WebMinSize = WebMinSize;
	}
	private String MaxSize;
	
	/**
	 * The max size of an order.
	 */
	public String getMaxSize() {
		return MaxSize;
	}
	
	public void setMaxSize(String MaxSize) {
		this.MaxSize = MaxSize;
	}
	private boolean Market24H;
	
	/**
	 * Is the market a 24 hour market.
	 */
	public boolean getMarket24H() {
		return Market24H;
	}
	
	public void setMarket24H(boolean Market24H) {
		this.Market24H = Market24H;
	}
	private String PriceDecimalPlaces;
	
	/**
	 * the number of decimal places in the market's price.
	 */
	public String getPriceDecimalPlaces() {
		return PriceDecimalPlaces;
	}
	
	public void setPriceDecimalPlaces(String PriceDecimalPlaces) {
		this.PriceDecimalPlaces = PriceDecimalPlaces;
	}
	private String DefaultQuoteLength;
	
	/**
	 * default quote length.
	 */
	public String getDefaultQuoteLength() {
		return DefaultQuoteLength;
	}
	
	public void setDefaultQuoteLength(String DefaultQuoteLength) {
		this.DefaultQuoteLength = DefaultQuoteLength;
	}
	private boolean TradeOnWeb;
	
	/**
	 * Can you trade this market on the web.
	 */
	public boolean getTradeOnWeb() {
		return TradeOnWeb;
	}
	
	public void setTradeOnWeb(boolean TradeOnWeb) {
		this.TradeOnWeb = TradeOnWeb;
	}
	private boolean LimitUp;
	
	/**
	 * New sell orders will be rejected. Orders resulting in a short open position will be red carded.
	 */
	public boolean getLimitUp() {
		return LimitUp;
	}
	
	public void setLimitUp(boolean LimitUp) {
		this.LimitUp = LimitUp;
	}
	private boolean LimitDown;
	
	/**
	 * New buy orders will be rejected. Orders resulting in a long open position will be red carded.
	 */
	public boolean getLimitDown() {
		return LimitDown;
	}
	
	public void setLimitDown(boolean LimitDown) {
		this.LimitDown = LimitDown;
	}
	private boolean LongPositionOnly;
	
	/**
	 * Cannot open a short position. Equivalent to limit up.
	 */
	public boolean getLongPositionOnly() {
		return LongPositionOnly;
	}
	
	public void setLongPositionOnly(boolean LongPositionOnly) {
		this.LongPositionOnly = LongPositionOnly;
	}
	private boolean CloseOnly;
	
	/**
	 * Can only close open positions. Equivalent to both Limit up and Limit down.
	 */
	public boolean getCloseOnly() {
		return CloseOnly;
	}
	
	public void setCloseOnly(boolean CloseOnly) {
		this.CloseOnly = CloseOnly;
	}
	private ApiMarketEodDTO[] MarketEod;
	
	/**
	 * list of market end of day dtos.
	 */
	public ApiMarketEodDTO[] getMarketEod() {
		return MarketEod;
	}
	
	public void setMarketEod(ApiMarketEodDTO[] MarketEod) {
		this.MarketEod = MarketEod;
	}
}

