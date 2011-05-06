package codegen.codetemplates.templatecompletion.replacementrule;

import codegen.codetemplates.CodeTemplate;

/**
 * Represents one replacement rule. Will replace one template entry with one calculated object
 * value.
 * 
 * @author Justin
 * 
 */
public class SimpleReplacement extends Replacement {

	/**
	 * Creates a new simple replacement with
	 * 
	 * @param templateValue
	 *            the name of the template entry to replace
	 * @param objectValue
	 *            the methods to call to transform the given object.
	 * @param objectName
	 */
	public SimpleReplacement(String templateValue, String objectValue, String objectName) {
		super(templateValue, objectValue, objectName);
	}

	@Override
	public void fillTemplateHole(Object obj, CodeTemplate template, String... args) {
		template.putNewTemplateDefinition(templateValue, resolveValue(obj, args).toString());
	}
}
