package codegen.modelobjects;

public class Items {
	private String $ref;
	private String type;

	public String getType(String packageName) {
		if ($ref == null) {
			return DTO.convertJsonTypeToJavaType(type);
		} else {
			String result = $ref.replaceAll("#", packageName);
			return result.startsWith(".")? result.substring(1): result;
		}
	}
}
