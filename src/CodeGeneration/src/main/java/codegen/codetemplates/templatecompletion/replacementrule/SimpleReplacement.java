package codegen.codetemplates.templatecompletion.replacementrule;

import codegen.codetemplates.CodeTemplate;

public class SimpleReplacement extends Replacement {

	public SimpleReplacement(String templateValue, String objectValue, String objectName) {
		super(templateValue, objectValue, objectName);
	}

	@Override
	public void fillTemplateHole(Object obj, CodeTemplate template, String... args) {
		template.putNewTemplateDefinition(templateValue, resolveValue(obj, args).toString());
	}
}
