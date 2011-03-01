package codegen.modelobjects;

/**
 * Describes a method that the service described by the SMD provides.
 * 
 * @author Justin Nelson
 * 
 */
public class Service {

	private String description;
	private String target;
	private String uriTemplate;
	private String contentType;
	private String responseContentType;
	private String transport;
	private String envelope;
	private Return returns;
	private String group;
	private String throttleScope;
	private Parameter[] parameters;

	public String getDescription() {
		return description;
	}

	public String getTarget() {
		return target;
	}

	public String getUriTemplate() {
		return uriTemplate;
	}

	public String getContentType() {
		return contentType;
	}

	public String getResponseContentType() {
		return responseContentType;
	}

	public String getTransport() {
		return transport;
	}

	public String getEnvelope() {
		return envelope;
	}

	public Return getReturns() {
		return returns;
	}

	public String getGroup() {
		return group;
	}

	public String getThrottleScope() {
		return throttleScope;
	}

	public Parameter[] getParameters() {
		return parameters;
	}

	public String toCode(String packageName) {
		String methodName = target + uriTemplate;
		if (methodName.contains("?")){
			methodName = methodName.substring(0, methodName.indexOf("?"));
		}
		methodName = methodName.replaceAll("/", "_");
		methodName = methodName.replaceAll("\\{[^}]*\\}", "");
		methodName = methodName.replaceAll("__", "_");
		String methodSignature = "public " + returns.get$ref(packageName) + " " + methodName + "(";
		String parametersStr = "";
		for (Parameter parm : parameters) {
			parametersStr += parm.toCode(packageName) + ", ";
		}
		if (parametersStr.length() != 0) {
			parametersStr = parametersStr.substring(0, parametersStr.length() - 2);
		}
		methodSignature += parametersStr + ") { \n";
		String methodBody = "\treturn null;\n";
		String methodEnd = "}\n";
		return methodSignature + methodBody + methodEnd;
	}
}
