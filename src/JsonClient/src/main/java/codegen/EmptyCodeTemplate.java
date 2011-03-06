package codegen;

public class EmptyCodeTemplate implements TemplateEntry {
	@Override
	public String codeReplacement() {
		return "{missing template replacement}";
	}
}
