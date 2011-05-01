package codegen.codetemplates.templatecompletion.replacementrule;

public class SimpleReplacement implements Replacement {
	private String templateValue;
	private String objectValue;
	
	public SimpleReplacement(String templateValue, String objectValue) {
		this.templateValue = templateValue;
		this.objectValue = objectValue;
	}

	@Override
	public String getTemplateName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String performReplacement(String template) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
