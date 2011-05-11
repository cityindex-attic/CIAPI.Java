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
	 * @param toFill
	 * @param replacementTemplate
	 * @throws FileNotFoundException 
	 */
	public TemplateFiller(ReplacementRoot replacementTemplate) throws FileNotFoundException{
		this.toFill = replacementTemplate.getTemplate();
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
