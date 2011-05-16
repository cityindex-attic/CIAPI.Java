package codegen.modelobjects;

public class Items {
	private String $ref;
	private String type;

	public String getType(String packageName) {
		if ($ref == null) {
			return DTO.convertJsonTypeToJavaType(type);
		} else {
			return $ref.replaceAll("#", packageName);
		}
	}
}
