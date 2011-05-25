package CIAPI.Java.dto;

/**
 * !This is an auto generated model object!
 *
 * Generic look up data.
 */
public class ApiLookupDTO {

	/**
	 * No argument constructor 
	 */
	public ApiLookupDTO() {
	}
	
	private int Id;
	
	/**
	 * lookups id.
	 */
	public int getId() {
		return Id;
	}
	
	public void setId(int Id) {
		this.Id = Id;
	}
	private String Description;
	
	/**
	 * lookup items description.
	 */
	public String getDescription() {
		return Description;
	}
	
	public void setDescription(String Description) {
		this.Description = Description;
	}
	private int DisplayOrder;
	
	/**
	 * order the items should be displayed on a user interface.
	 */
	public int getDisplayOrder() {
		return DisplayOrder;
	}
	
	public void setDisplayOrder(int DisplayOrder) {
		this.DisplayOrder = DisplayOrder;
	}
	private String TranslationTextId;
	
	/**
	 * translation text id.
	 */
	public String getTranslationTextId() {
		return TranslationTextId;
	}
	
	public void setTranslationTextId(String TranslationTextId) {
		this.TranslationTextId = TranslationTextId;
	}
	private String TranslationText;
	
	/**
	 * translated text.
	 */
	public String getTranslationText() {
		return TranslationText;
	}
	
	public void setTranslationText(String TranslationText) {
		this.TranslationText = TranslationText;
	}
	private boolean IsActive;
	
	/**
	 * is active.
	 */
	public boolean getIsActive() {
		return IsActive;
	}
	
	public void setIsActive(boolean IsActive) {
		this.IsActive = IsActive;
	}
	private boolean IsAllowed;
	
	/**
	 * is allowed.
	 */
	public boolean getIsAllowed() {
		return IsAllowed;
	}
	
	public void setIsAllowed(boolean IsAllowed) {
		this.IsAllowed = IsAllowed;
	}
}

