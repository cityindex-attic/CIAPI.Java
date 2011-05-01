package codegen.codetemplates.templatecompletion.replacementrule;

public interface Replacement {

	/**
	 * @return the value from the template that you will be replacing.
	 */
	public String getTemplateName();

	/**
	 * 
	 * @param template
	 *            the text of the template to perform the replacement on
	 * @return the template with the replacement performed
	 */
	public String performReplacement(String template);

}
