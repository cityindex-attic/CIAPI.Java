package CIAPI.Java.dto;

/**
 * !This is an auto generated model object!
 *
 * This is a description of ErrorResponseDTO
 */
public class ErrorResponseDTO {

	/**
	 * No argument constructor
	 */
	public ErrorResponseDTO() {
	}

	
	private String ErrorMessage;
	
	/**
	 * This is a description of the ErrorMessage property
	 */
	public String getErrorMessage() {
		return ErrorMessage;
	}
	
	public void setErrorMessage(String ErrorMessage) {
		this.ErrorMessage = ErrorMessage;
	}

	private CIAPI.Java.dto.ErrorCode ErrorCode;
	
	/**
	 * The error code
	 */
	public CIAPI.Java.dto.ErrorCode getErrorCode() {
		return ErrorCode;
	}
	
	public void setErrorCode(CIAPI.Java.dto.ErrorCode ErrorCode) {
		this.ErrorCode = ErrorCode;
	}

	private int HttpStatusCode;
	
	/**
	 * HTTP status code
	 */
	public int getHttpStatusCode() {
		return HttpStatusCode;
	}
	
	public void setHttpStatusCode(int HttpStatusCode) {
		this.HttpStatusCode = HttpStatusCode;
	}

}

