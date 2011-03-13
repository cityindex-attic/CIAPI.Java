package codegen.codetemplates;

public class SimpleTemplateEntry implements TemplateEntry {
	private String replacement;

	public SimpleTemplateEntry(String replacement) {
		this.replacement = replacement;
	}

	@Override
	public String codeReplacement() {
		return replacement;
	}
}
