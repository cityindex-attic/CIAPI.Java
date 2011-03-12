package codegen.codetemplates;

public class TemplateParser {
	private String template;

	private TemplateParser(String template) {
		this.template = template;
	}

	/**
	 * I'm gonna make magic happen here. Gonna parse the template character by
	 * character.
	 * 
	 * @return the template model representing the code template string
	 */
	private CodeTemplate parse() {
		int pos = 0;
		return null;
	}

	public static CodeTemplate parse(String template) {
		return new TemplateParser(template).parse();
	}
}
