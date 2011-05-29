package codegen.modelobjects;

public class Return {

	private String $ref;

	public String get$ref(String packageName) {
		String result = $ref.replaceAll("#", packageName);
		return result.startsWith(".")? result.substring(1): result;
	}
	public String get$ref() {
		return get$ref("");
	}
}
