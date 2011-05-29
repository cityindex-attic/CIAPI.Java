package CIAPI.Java.core.dto;

/**
 * !This is an auto generated model object!
 *
 * Api watchlist item
 */
public class ApiClientAccountWatchlistItemDTO {

	/**
	 * No argument constructor 
	 */
	public ApiClientAccountWatchlistItemDTO() {
	}
	
	private int WatchlistId;
	
	/**
	 * Parent watchlist id
	 */
	public int getWatchlistId() {
		return WatchlistId;
	}
	
	public void setWatchlistId(int WatchlistId) {
		this.WatchlistId = WatchlistId;
	}
	private int MarketId;
	
	/**
	 * Watchlist item market id
	 */
	public int getMarketId() {
		return MarketId;
	}
	
	public void setMarketId(int MarketId) {
		this.MarketId = MarketId;
	}
	private int DisplayOrder;
	
	/**
	 * Watchlist item display order
	 */
	public int getDisplayOrder() {
		return DisplayOrder;
	}
	
	public void setDisplayOrder(int DisplayOrder) {
		this.DisplayOrder = DisplayOrder;
	}
}

