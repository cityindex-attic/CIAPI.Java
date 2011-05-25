package CIAPI.Java.dto;

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
	
	private int ParentWatchlistDisplayOrderId;
	
	/**
	 * The watchlist display order id to add the item
	 */
	public int getParentWatchlistDisplayOrderId() {
		return ParentWatchlistDisplayOrderId;
	}
	
	public void setParentWatchlistDisplayOrderId(int ParentWatchlistDisplayOrderId) {
		this.ParentWatchlistDisplayOrderId = ParentWatchlistDisplayOrderId;
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

