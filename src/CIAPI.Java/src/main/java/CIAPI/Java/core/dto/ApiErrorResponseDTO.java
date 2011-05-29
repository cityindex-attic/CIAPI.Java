package CIAPI.Java.core.dto;

/**
 * !This is an auto generated model object!
 *
 * This is a description of ErrorResponseDTO
 */
public class ApiErrorResponseDTO {

	/**
	 * No argument constructor 
	 */
	public ApiErrorResponseDTO() {
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
	private ErrorCode ErrorCode;
	
	/**
	 * The error code
	 */
	public ErrorCode getErrorCode() {
		return ErrorCode;
	}
	
	public void setErrorCode(ErrorCode ErrorCode) {
		this.ErrorCode = ErrorCode;
	}
}

