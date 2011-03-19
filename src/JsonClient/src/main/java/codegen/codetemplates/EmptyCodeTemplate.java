package codegen.codetemplates;

/**
 * Represents a template entry that has not been set yet.
 * 
 * @author Justin Nelson
 * 
 */
public class EmptyCodeTemplate implements TemplateEntry {
	@Override
	public String codeReplacement() {
		throw new IllegalStateException("This code template was not correctly replaced.");
	}

	@Override
	public EmptyCodeTemplate copyEmptyTemplate() {
		return this;
	}
}
