package CIAPI.Java.examples.ciapi.dto;

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

	
	private CIAPI.Java.examples.ciapi.dto.ApiTradeHistoryDTO[] TradeHistory;
	
	/**
	 * A list of historical trades.
	 */
	public CIAPI.Java.examples.ciapi.dto.ApiTradeHistoryDTO[] getTradeHistory() {
		return TradeHistory;
	}
	
	public void setTradeHistory(CIAPI.Java.examples.ciapi.dto.ApiTradeHistoryDTO[] TradeHistory) {
		this.TradeHistory = TradeHistory;
	}

}

