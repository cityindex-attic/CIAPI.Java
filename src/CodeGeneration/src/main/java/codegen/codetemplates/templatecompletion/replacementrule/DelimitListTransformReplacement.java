package codegen.codetemplates.templatecompletion.replacementrule;

import java.util.List;

import codegen.codetemplates.CodeTemplate;
import codegen.codetemplates.CompoundCodeTemplate;

public class DelimitListTransformReplacement extends ReplacementSet {

	public DelimitListTransformReplacement(String templateValue, String objectValue,
			String objName, String subObjName, List<Replacement> subPlacements,
			boolean trailingChar, boolean addSpace, String delim) {
		super(templateValue, objectValue, objName, subObjName, subPlacements, delim);
		this.addSpace = addSpace;
		this.trailingChar = trailingChar;
		this.delimiter = delim;
	}

	private boolean trailingChar;
	private boolean addSpace;
	private String delimiter;

	@Override
	protected void fillSubTemplate(Object subObj, CodeTemplate subTemplateToFill,
			CompoundCodeTemplate masterTemplate, String... args) {
		String result = subObj.toString();
		super.fillSubTemplate(subObj, subTemplateToFill, masterTemplate, args);
	}

}
