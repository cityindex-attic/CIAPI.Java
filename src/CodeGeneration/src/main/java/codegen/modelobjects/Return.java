package codegen.modelobjects;

public class Return {

	private String $ref;

	public String get$ref(String packageName) {
		return $ref.replaceAll("#", packageName);
	}

}
