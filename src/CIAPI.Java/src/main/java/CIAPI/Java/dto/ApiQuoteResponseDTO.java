package CIAPI.Java.dto;

/**
 * !This is an auto generated model object!
 *
 * quote response.
 */
public class ApiQuoteResponseDTO {

	/**
	 * No argument constructor 
	 */
	public ApiQuoteResponseDTO() {
	}
	
	private int QuoteId;
	
	/**
	 * quote id.
	 */
	public int getQuoteId() {
		return QuoteId;
	}
	
	public void setQuoteId(int QuoteId) {
		this.QuoteId = QuoteId;
	}
	private int Status;
	
	/**
	 * quote status.
	 */
	public int getStatus() {
		return Status;
	}
	
	public void setStatus(int Status) {
		this.Status = Status;
	}
	private int StatusReason;
	
	/**
	 * quote status reason.
	 */
	public int getStatusReason() {
		return StatusReason;
	}
	
	public void setStatusReason(int StatusReason) {
		this.StatusReason = StatusReason;
	}
}

