package codegen.modelobjects;

public abstract class TypedSchemaItem {
	protected String $ref;
	protected String type;
	protected Items items;
	protected String description;

	public String getType(String packageName) {
		if ($ref != null && items != null) {
			throw new IllegalStateException("Not sure if it's legal to have a @ref and items attribute.");
		}
		if ($ref != null) {
			return $ref.replaceAll("#", packageName);
		} else if (items != null) {
			if (!type.equals("array")) {
				throw new IllegalStateException(
						"Not sure if it is legal to have a type of 'array' and no 'items' attribute.");
			}
			return items.getType(packageName) + "[]";
		} else
			return DTO.convertJsonTypeToJavaType(type);
	}

	public String getDescription() {
		return description;
	}
}
