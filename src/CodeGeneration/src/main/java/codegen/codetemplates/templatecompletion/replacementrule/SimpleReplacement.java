package codegen.codetemplates.templatecompletion.replacementrule;

import codegen.codetemplates.CodeTemplate;

/**
 * Represents one replacement rule. Will replace one template entry with one calculated object
 * value.
 * 
 * @author Justin Nelson
 * 
 */
public class SimpleReplacement extends Replacement {
	private String defaultVal;

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
		this(templateValue, objectValue, objectName, null);
	}

	public SimpleReplacement(String templateValue, String objectValue, String objectName, String defaultValue) {
		super(templateValue, objectValue, objectName);
		this.defaultVal = defaultValue;
	}

	@Override
	public void fillTemplateHole(Object obj, CodeTemplate template) {
		Object value = resolveValue(obj);
		String valueS = null;
		if (value != null) {
			valueS = value.toString();
		}else {
			valueS = defaultVal;
		}
		template.putNewTemplateDefinition(templateValue, valueS);
	}

	@Override
	public String toString() {
		return templateValue + ": " + objectValue + ":" + objectName;
	}
}
