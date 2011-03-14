package codegen.codecreation;

import java.io.FileNotFoundException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import codegen.codetemplates.CodeTemplate;
import codegen.modelobjects.Parameter;
import codegen.modelobjects.Service;

/**
 * Class for taking a Service model object and creating code.
 * 
 * @author Justin Nelson
 * 
 */
public class MethodCreator {

	private Service model;

	/**
	 * Creates a new MethodCreator out of the given model object.
	 * 
	 * @param model
	 */
	public MethodCreator(Service model) {
		this.model = model;
	}

	/**
	 * 
	 * @return whether or not this method's transport is GET or not. (If it's
	 *         not GET, it's POST)
	 */
	public boolean isGet() {
		return model.getTransport().equals("GET");
	}

	private static final String urlPattern = "\\{[^}]*\\}";

	/**
	 * Some URLs have parameters in the URL, before the actually URL param part.
	 * We handle those differently
	 * 
	 * @return the number of params in the URL
	 */
	public int numberParamsInUrl() {
		Pattern p = Pattern.compile(urlPattern);
		Matcher m = p.matcher(model.getUriTemplate());
		int i = 0;
		while (m.find()) {
			i++;
		}
		return i;
	}

	public String toCode2() throws FileNotFoundException{
		CodeTemplate template = CodeTemplate.loadTemplate("files/code_templates/ServiceTemplate.jav");
		return template.codeReplacement();
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
		// Build up the list of parameters into a String
		for (int i = numberParamsInUrl(); i < model.getParameters().length; i++) {
			Parameter parm = model.getParameters()[i];
			parametersStr += parm.toCode(packageName) + ", ";
		}
		// trim off a trailing comma if necessary
		if (parametersStr.length() != 0) {
			parametersStr = parametersStr.substring(0, parametersStr.length() - 2);
		}
		methodSignature += parametersStr + ") { \n";
		String methodBody = createBody(packageName);
		String methodEnd = "\t}\n";
		return methodSignature + methodBody + methodEnd;
	}

	/**
	 * Creates the implementation of the method.
	 * 
	 * @param packageName
	 *            the package this method belongs to
	 * @return a String representing the body of the method.
	 */
	private String createBody(String packageName) {
		// String api = "api";
		// String methodToCall = isGet() ? ".callGetMethod" : ".callPostMethod";
		// we need to see if one of our parameters is actually in the URL
		if (numberParamsInUrl() > 0) {
			// in here we have a url with params built in
			// String tempUriTemplate =
			// "String.format(uriTemplate.replaceAll(\"{[^}]*}\"))";
		}
		return "\t\treturn null;\n";
	}
}
