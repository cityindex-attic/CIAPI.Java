package codegen.codetemplates.templatecompletion.replacementrule;

import java.util.List;

public class ReplacementSet implements Replacement {

	private String templateValue;
	private String objectValue;
	private String subObjName;
	private List<Replacement> subPlacemnets;

	public ReplacementSet(String templateValue, String objectValue, String subObjName,
			List<Replacement> subPlacements) {
		this.templateValue = templateValue;
		this.objectValue = objectValue;
		this.subObjName = subObjName;
		this.subPlacemnets = subPlacements;
	}

	@Override
	public String getTemplateName() {
		return templateValue;
	}

	@Override
	public Object getObjectValue(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}
}
