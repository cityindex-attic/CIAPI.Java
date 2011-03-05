package codegen.codecreation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import codegen.modelobjects.Parameter;
import codegen.modelobjects.Service;

public class MethodCreator {

	private Service model;

	public MethodCreator(Service model) {
		this.model = model;
	}

	/**
	 * 
	 * @return whether or not this method's transport is GET or not.
	 */
	public boolean isGet() {
		return model.getTransport().equals("GET");
	}

	/**
	 * Turns the object representation of the method into a String that is a
	 * syntactically correct Java method
	 * 
	 * @param methodName
	 *            The name of the method this code represents
	 * @param packageName
	 *            the fully qualified package name that this method belongs to
	 * @return the string representation of this method
	 */
	public String toCode(String methodName, String packageName) {
		String methodSignature = "\tpublic " + model.getReturns().get$ref(packageName) + " " + methodName + "(";
		String parametersStr = "";
		for (Parameter parm : model.getParameters()) {
			parametersStr += parm.toCode(packageName) + ", ";
		}
		if (parametersStr.length() != 0) {
			parametersStr = parametersStr.substring(0, parametersStr.length() - 2);
		}
		methodSignature += parametersStr + ") { \n";
		String methodBody = createBody(packageName);
		String methodEnd = "\t}\n";
		return methodSignature + methodBody + methodEnd;
	}

	private String createBody(String packageName) {
		String api = "api";
		String methodToCall = isGet() ? ".callGetMethod" : ".callPostMethod";
		Pattern p = Pattern.compile("\\{[^}]*\\}");
		Matcher m = p.matcher(model.getUriTemplate());
		if (m.find()) {
			// in here we have a url with params built in
			String tempUriTemplate = "String.format(uriTemplate.replaceAll(\"{[^}]*}\"))";
		}
		return "\t\treturn null;\n";
	}
	
	private String methodBodyTemplate = "return api.-<>";
}
