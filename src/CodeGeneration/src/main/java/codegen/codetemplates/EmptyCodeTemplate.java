package codegen.codetemplates;

import static CIAPI.Java.logging.Log.debug;
import static CIAPI.Java.logging.Log.trace;
import static CIAPI.Java.logging.Log.error;
import static CIAPI.Java.logging.Log.warn;

/**
 * Represents a template entry that has not been set yet.<br />
 * If attempts are made to replace this template, it will throw an exception.
 * 
 * @author Justin Nelson
 * 
 */
public class EmptyCodeTemplate implements TemplateEntry {
	@Override
	public String codeReplacement() {
		error(new IllegalStateException("This code template was not correctly replaced."));
		return null;
	}

	@Override
	public EmptyCodeTemplate copyEmptyTemplate() {
		return this;
	}
}
