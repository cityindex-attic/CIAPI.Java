package codegen.modelobjects;

public class Property extends TypedSchemaItem {

	private String description;
	private long minLength;
	private long maxLength;



	public String getRawType() {
		return type;
	}

	public long getMinLength() {
		return minLength;
	}

	public long getMaxLength() {
		return maxLength;
	}

}
