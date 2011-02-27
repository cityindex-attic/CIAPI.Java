package modelobjects;

public class Property {

	private String $ref;
	private String type;
	private Items items;
	private String description;
	private long minLength;
	private long maxLength;

	public String getType() {
		if ($ref != null && items != null) {
			throw new IllegalStateException("Not sure if it's legal to have a @ref and items attribute.");
		}
		if ($ref != null) {
			return $ref;
		} else if (items != null) {
			if (!type.equals("array")) {
				throw new IllegalStateException(
						"Not sure if it is legal to have a type of 'array' and no 'items' attribute.");
			}
			return items.get$ref() + "[]";
		} else
			return DTO.convertJsonTypeToJavaType(type);
	}

	public String getRawType() {
		return type;
	}

	public String getDescription() {
		return description;
	}

	public long getMinLength() {
		return minLength;
	}

	public long getMaxLength() {
		return maxLength;
	}

}
