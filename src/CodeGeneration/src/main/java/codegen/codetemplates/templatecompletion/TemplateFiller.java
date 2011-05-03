package codegen.codetemplates.templatecompletion;

import codegen.codetemplates.CodeTemplate;
import codegen.codetemplates.templatecompletion.replacementrule.Replacement;
import codegen.codetemplates.templatecompletion.replacementrule.ReplacementRoot;

public class TemplateFiller {

	public String fillTemplate(Object rootModelObject, CodeTemplate toFill,
			ReplacementRoot replacementTemplate, String... args) {
		for (Replacement r : replacementTemplate) {
			r.fillTemplateHole(rootModelObject, toFill, args);
		}
		return toFill.codeReplacement();
	}
}
