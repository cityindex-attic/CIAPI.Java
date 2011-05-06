package codegen.codetemplates.templatecompletion;

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
	 * @param toFill
	 * @param replacementTemplate
	 */
	public TemplateFiller(CodeTemplate toFill, ReplacementRoot replacementTemplate){
		this.toFill = toFill;
		this.replacemnetTemplate = replacementTemplate;
	}
	
	/**
	 * Returns a filled template. (Ideally code that compiles)
	 * @param rootModelObject
	 * @param args
	 * @return
	 */
	public String fillTemplate(Object rootModelObject, String... args) {
		for (Replacement r : replacemnetTemplate) {
			r.fillTemplateHole(rootModelObject, toFill, args);
		}
		return toFill.codeReplacement();
	}
}
