package CIAPI.Java.dto;

/**
 * !This is an auto generated model object!
 *
 * Contains details of a specific news story
 */
public class MarketInformationDTO {

	/**
	 * No argument constructor
	 */
	public MarketInformationDTO() {
	}

	
	private int MarketId;
	
	/**
	 * TODO
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
	 * TODO
	 */
	public String getMarginFactor() {
		return MarginFactor;
	}
	
	public void setMarginFactor(String MarginFactor) {
		this.MarginFactor = MarginFactor;
	}

	private String MinDistance;
	
	/**
	 * TODO
	 */
	public String getMinDistance() {
		return MinDistance;
	}
	
	public void setMinDistance(String MinDistance) {
		this.MinDistance = MinDistance;
	}

	private String WebMinSize;
	
	/**
	 * TODO
	 */
	public String getWebMinSize() {
		return WebMinSize;
	}
	
	public void setWebMinSize(String WebMinSize) {
		this.WebMinSize = WebMinSize;
	}

	private String MaxSize;
	
	/**
	 * TODO
	 */
	public String getMaxSize() {
		return MaxSize;
	}
	
	public void setMaxSize(String MaxSize) {
		this.MaxSize = MaxSize;
	}

	private boolean Market24H;
	
	/**
	 * TODO
	 */
	public boolean getMarket24H() {
		return Market24H;
	}
	
	public void setMarket24H(boolean Market24H) {
		this.Market24H = Market24H;
	}

	private String PriceDecimalPlaces;
	
	/**
	 * TODO
	 */
	public String getPriceDecimalPlaces() {
		return PriceDecimalPlaces;
	}
	
	public void setPriceDecimalPlaces(String PriceDecimalPlaces) {
		this.PriceDecimalPlaces = PriceDecimalPlaces;
	}

	private String DefaultQuoteLength;
	
	/**
	 * TODO
	 */
	public String getDefaultQuoteLength() {
		return DefaultQuoteLength;
	}
	
	public void setDefaultQuoteLength(String DefaultQuoteLength) {
		this.DefaultQuoteLength = DefaultQuoteLength;
	}

	private boolean TradeOnWeb;
	
	/**
	 * TODO
	 */
	public boolean getTradeOnWeb() {
		return TradeOnWeb;
	}
	
	public void setTradeOnWeb(boolean TradeOnWeb) {
		this.TradeOnWeb = TradeOnWeb;
	}

	private boolean LimitUp;
	
	/**
	 * TODO
	 */
	public boolean getLimitUp() {
		return LimitUp;
	}
	
	public void setLimitUp(boolean LimitUp) {
		this.LimitUp = LimitUp;
	}

	private boolean LimitDown;
	
	/**
	 * TODO
	 */
	public boolean getLimitDown() {
		return LimitDown;
	}
	
	public void setLimitDown(boolean LimitDown) {
		this.LimitDown = LimitDown;
	}

	private boolean LongPositionOnly;
	
	/**
	 * TODO
	 */
	public boolean getLongPositionOnly() {
		return LongPositionOnly;
	}
	
	public void setLongPositionOnly(boolean LongPositionOnly) {
		this.LongPositionOnly = LongPositionOnly;
	}

	private boolean CloseOnly;
	
	/**
	 * TODO
	 */
	public boolean getCloseOnly() {
		return CloseOnly;
	}
	
	public void setCloseOnly(boolean CloseOnly) {
		this.CloseOnly = CloseOnly;
	}

	private CIAPI.Java.dto.MarketEodDTO[] MarketEod;
	
	/**
	 * TODO
	 */
	public CIAPI.Java.dto.MarketEodDTO[] getMarketEod() {
		return MarketEod;
	}
	
	public void setMarketEod(CIAPI.Java.dto.MarketEodDTO[] MarketEod) {
		this.MarketEod = MarketEod;
	}

}

