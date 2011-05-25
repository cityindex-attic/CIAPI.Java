package CIAPI.Java.dto;

/**
 * !This is an auto generated model object!
 *
 * Gets the lookup entities from trading database given the lookup name and culture id
 */
public class ApiLookupResponseDTO {

	/**
	 * No argument constructor 
	 */
	public ApiLookupResponseDTO() {
	}
	
	private int CultureId;
	
	/**
	 * The culture id requested
	 */
	public int getCultureId() {
		return CultureId;
	}
	
	public void setCultureId(int CultureId) {
		this.CultureId = CultureId;
	}
	private String LookupEntityName;
	
	/**
	 * The lookup name requested
	 */
	public String getLookupEntityName() {
		return LookupEntityName;
	}
	
	public void setLookupEntityName(String LookupEntityName) {
		this.LookupEntityName = LookupEntityName;
	}
	private CIAPI.Java.dto.ApiLookupDTO[] ApiLookupDTOList;
	
	/**
	 * List of lookup entities from the database
	 */
	public CIAPI.Java.dto.ApiLookupDTO[] getApiLookupDTOList() {
		return ApiLookupDTOList;
	}
	
	public void setApiLookupDTOList(CIAPI.Java.dto.ApiLookupDTO[] ApiLookupDTOList) {
		this.ApiLookupDTOList = ApiLookupDTOList;
	}
}

