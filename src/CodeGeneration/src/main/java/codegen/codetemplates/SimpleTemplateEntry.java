package codegen.codetemplates;

import static CIAPI.Java.logging.Log.debug;
import static CIAPI.Java.logging.Log.trace;
import static CIAPI.Java.logging.Log.error;
import static CIAPI.Java.logging.Log.warn;

/**
 * Represents a template entry that is simply replaced by a single string
 * 
 * @author Justin Nelson
 * 
 */
public class SimpleTemplateEntry implements TemplateEntry {
	private String replacement;

	/**
	 * Creates a new simple template entry with the given string as a replacement for the template.
	 * 
	 * @param replacement
	 *            the string to replace the template with
	 */
	public SimpleTemplateEntry(String replacement) {
		if (replacement == null) {
			error( new NullPointerException("The desired replacement can't be null."));
		}
		this.replacement = replacement;
	}

	@Override
	public String codeReplacement() {
		return replacement;
	}

	@Override
	public EmptyCodeTemplate copyEmptyTemplate() {
		return new EmptyCodeTemplate();
	}

	@Override
	public String toString() {
		return replacement;
	}
}
