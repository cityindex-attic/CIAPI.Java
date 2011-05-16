package codegen.codetemplates;

/**
 * Represents one entry in a template
 * 
 * @author Justin Nelson
 */
public interface TemplateEntry {
	/**
	 * Turns this template into it's code representation.
	 * 
	 * @return the code version of this element
	 */
	public String codeReplacement();

	/**
	 * Copies a template and returns an an unfilled version.
	 * 
	 * @return an unfilled copy of this template
	 */
	public TemplateEntry copyEmptyTemplate();
}
