package codegen.codetemplates.templatecompletion;

import java.io.FileNotFoundException;

import codegen.codetemplates.CodeTemplate;
import codegen.codetemplates.templatecompletion.replacementrule.Replacement;
import codegen.codetemplates.templatecompletion.replacementrule.ReplacementRoot;

/**
 * Simple class for filling a code template with the given replacements
 * 
 * @author Justin Nelson
 * 
 */
public class TemplateFiller {

	private CodeTemplate toFill;
	private ReplacementRoot replacemnetTemplate;

	/**
	 * Creates a new template filler that will use the supplied template and replacement set
	 * 
	 * @param replacementTemplate
	 *            the replacement template to fill
	 * @throws FileNotFoundException
	 *             if the replacement file or code template can't be found
	 */
	public TemplateFiller(ReplacementRoot replacementTemplate) throws FileNotFoundException {
		this.toFill = replacementTemplate.getTemplate();
		this.replacemnetTemplate = replacementTemplate;
	}

	/**
	 * Returns a filled template. (Ideally code that compiles)
	 * 
	 * @param rootModelObject
	 *            the object to feed the code template and replacement file for replacements
	 * @param args
	 *            any additional arguments that the template or replacement file may require
	 * @return the template that was replaced by the given replacement rules and model object
	 */
	public String fillTemplate(Object rootModelObject, String... args) {
		for (Replacement r : replacemnetTemplate) {
			r.fillTemplateHole(rootModelObject, toFill, args);
		}
		return toFill.codeReplacement();
	}
}
