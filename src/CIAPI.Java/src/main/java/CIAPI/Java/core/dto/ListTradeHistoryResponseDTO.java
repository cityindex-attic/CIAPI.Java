package CIAPI.Java.core.dto;

/**
 * !This is an auto generated model object!
 *
 * Contains the result of a ListTradeHistory query
 */
public class ListTradeHistoryResponseDTO {

	/**
	 * No argument constructor 
	 */
	public ListTradeHistoryResponseDTO() {
	}
	
	private ApiTradeHistoryDTO[] TradeHistory;
	
	/**
	 * A list of historical trades.
	 */
	public ApiTradeHistoryDTO[] getTradeHistory() {
		return TradeHistory;
	}
	
	public void setTradeHistory(ApiTradeHistoryDTO[] TradeHistory) {
		this.TradeHistory = TradeHistory;
	}
}

