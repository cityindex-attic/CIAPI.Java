package CIAPI.Java.core.dto;

/**
 * !This is an auto generated model object!
 *
 * Update watchlist with item
 */
public class InsertWatchlistItemRequestDTO {

	/**
	 * No argument constructor 
	 */
	public InsertWatchlistItemRequestDTO() {
	}
	
	private int WatchlistDisplayOrderId;
	
	/**
	 * The watchlist display order id to add the item
	 */
	public int getWatchlistDisplayOrderId() {
		return WatchlistDisplayOrderId;
	}
	
	public void setWatchlistDisplayOrderId(int WatchlistDisplayOrderId) {
		this.WatchlistDisplayOrderId = WatchlistDisplayOrderId;
	}
	private int MarketId;
	
	/**
	 * The market item to add
	 */
	public int getMarketId() {
		return MarketId;
	}
	
	public void setMarketId(int MarketId) {
		this.MarketId = MarketId;
	}
}

