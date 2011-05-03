package codegen.codetemplates.templatecompletion.replacementrule;

import java.util.List;

import codegen.codetemplates.CodeTemplate;
import codegen.codetemplates.CompoundCodeTemplate;

public class ReplacementSet extends Replacement {

	private String subObjName;
	private List<Replacement> subPlacemnets;

	public ReplacementSet(String templateValue, String objectValue, String objName,
			String subObjName, List<Replacement> subPlacements) {
		super(templateValue, objectValue, objName);
		this.subObjName = subObjName;
		this.subPlacemnets = subPlacements;
	}

	@Override
	public String getTemplateName() {
		return templateValue;
	}

	@Override
	public void fillTemplateHole(Object obj, CodeTemplate template, String... args) {
		Iterable<?> result = (Iterable<?>) resolveValue(obj, args);
		CompoundCodeTemplate comp = (CompoundCodeTemplate) template.getTemplateEntry(templateValue);
		CodeTemplate toFill = comp.getEmptyTemplate();
		for (Object o : result) {
			CodeTemplate clone = toFill.copyEmptyTemplate();
			for (Replacement r : subPlacemnets) {
				r.fillTemplateHole(o, clone, args);
			}
			comp.addMappingSet(clone);
		}
	}
}
