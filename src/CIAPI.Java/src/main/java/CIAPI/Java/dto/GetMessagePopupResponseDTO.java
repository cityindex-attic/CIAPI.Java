package CIAPI.Java.dto;

/**
 * !This is an auto generated model object!
 *
 * Message popup response denoting whether the client application should display a popup notification at startup.
 */
public class GetMessagePopupResponseDTO {

	/**
	 * No argument constructor 
	 */
	public GetMessagePopupResponseDTO() {
	}
	
	private boolean AskForClientApproval;
	
	/**
	 * Should the client application ask for client approval.
	 */
	public boolean getAskForClientApproval() {
		return AskForClientApproval;
	}
	
	public void setAskForClientApproval(boolean AskForClientApproval) {
		this.AskForClientApproval = AskForClientApproval;
	}
	private String Message;
	
	/**
	 * The message to display to the client.
	 */
	public String getMessage() {
		return Message;
	}
	
	public void setMessage(String Message) {
		this.Message = Message;
	}
}

