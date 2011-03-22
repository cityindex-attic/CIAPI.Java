package codegen.modelobjects;

import codegen.codecreation.DTOCreator;

public class Items {
	private String $ref;
	private String type;

	public String getType(String packageName) {
		if ($ref == null) {
			return DTOCreator.convertJsonTypeToJavaType(type);
		} else {
			return $ref.replaceAll("#", packageName);
		}
	}
}
