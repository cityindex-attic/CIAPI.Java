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
	
	public TemplateEntry copyEmptyTemplate();
}
