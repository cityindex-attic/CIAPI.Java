package CIAPI.Java.core.dto;

/**
 * !This is an auto generated model object!
 *
 * Get market information for a list of markets.
 */
public class UpdateWatchlistDisplayOrderRequestDTO {

	/**
	 * No argument constructor 
	 */
	public UpdateWatchlistDisplayOrderRequestDTO() {
	}
	
	private int[] NewDisplayOrderIdSequence;
	
	/**
	 * Represents the new client watchlist displayOrderId list sequence
	 */
	public int[] getNewDisplayOrderIdSequence() {
		return NewDisplayOrderIdSequence;
	}
	
	public void setNewDisplayOrderIdSequence(int[] NewDisplayOrderIdSequence) {
		this.NewDisplayOrderIdSequence = NewDisplayOrderIdSequence;
	}
}

