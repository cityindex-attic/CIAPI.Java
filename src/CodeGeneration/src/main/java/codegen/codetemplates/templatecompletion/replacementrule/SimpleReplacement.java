package codegen.codetemplates.templatecompletion.replacementrule;

public class SimpleReplacement implements Replacement {
	private String templateValue;
	private String objectValue;
	private String objectName;
	
	public SimpleReplacement(String templateValue, String objectValue, String objectName) {
		this.templateValue = templateValue;
		this.objectValue = objectValue;
		this.objectName = objectName;
	}

	@Override
	public String getTemplateName() {
		return templateValue;
	}

	@Override
	public Object getObjectValue(Object obj) {
		String regex = objectName + "(\\.[^)]+\\(([^)]*)\\))";
		// TODO Auto-generated method stub
		return null;
	}
}
