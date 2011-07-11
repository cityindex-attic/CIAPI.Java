package codegen.modelobjects;

public class Property {
	protected Type type;
	private String description;
	private long minValue;
	private long maxValue;
	private String format;

	public String getRawType() {
		return type.toString();
	}

	public long getMinLength() {
		return minValue;
	}

	public long getMaxLength() {
		return maxValue;
	}

}
