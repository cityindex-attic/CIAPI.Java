package CIAPI.Java.core.dto;

/**
 * !This is an auto generated model object!
 *
 * Client account watchlist
 */
public class ApiClientAccountWatchlistDTO {

	/**
	 * No argument constructor 
	 */
	public ApiClientAccountWatchlistDTO() {
	}
	
	private int WatchlistId;
	
	/**
	 * Watchlist item id
	 */
	public int getWatchlistId() {
		return WatchlistId;
	}
	
	public void setWatchlistId(int WatchlistId) {
		this.WatchlistId = WatchlistId;
	}
	private String WatchlistDescription;
	
	/**
	 * Watchlist description
	 */
	public String getWatchlistDescription() {
		return WatchlistDescription;
	}
	
	public void setWatchlistDescription(String WatchlistDescription) {
		this.WatchlistDescription = WatchlistDescription;
	}
	private int DisplayOrder;
	
	/**
	 * Watchlist display order
	 */
	public int getDisplayOrder() {
		return DisplayOrder;
	}
	
	public void setDisplayOrder(int DisplayOrder) {
		this.DisplayOrder = DisplayOrder;
	}
	private ApiClientAccountWatchlistItemDTO[] Items;
	
	/**
	 * Watchlist items
	 */
	public ApiClientAccountWatchlistItemDTO[] getItems() {
		return Items;
	}
	
	public void setItems(ApiClientAccountWatchlistItemDTO[] Items) {
		this.Items = Items;
	}
}

