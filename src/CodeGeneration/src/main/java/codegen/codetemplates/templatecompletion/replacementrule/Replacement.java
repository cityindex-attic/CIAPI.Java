package codegen.codetemplates.templatecompletion.replacementrule;

import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import codegen.codetemplates.CodeTemplate;

public abstract class Replacement {

	protected String templateValue;
	protected String objectValue;
	protected String objectName;

	public Replacement(String templateValue, String objectValue, String objectName) {
		this.templateValue = templateValue;
		this.objectValue = objectValue;
		this.objectName = objectName;
	}

	public String getTemplateName() {
		return templateValue;
	}

	protected Object resolveValue(Object obj, String... args) {
		Object result;
		if (objectValue.startsWith("$args")) {
			result = indexArray(args, objectValue);
		} else {
			String[] methods = objectValue.split("\\.");
			result = obj;
			for (String method : methods) {
				if (!method.contains("("))
					continue;
				String name = method.substring(0, method.indexOf('('));
				String methodArgs = method.substring(method.indexOf("(") + 1, method.indexOf(')'));
				try {
					if (methodArgs.trim().length() == 0) {
						Method method2 = result.getClass().getMethod(name);
						method2.setAccessible(true);
						result = method2.invoke(result);
					} else {
						Method method2 = result.getClass().getMethod(name, String.class);
						method2.setAccessible(true);
						result = method2.invoke(result, indexArray(args, methodArgs));
					}
				} catch (Exception e) {
					throw new RuntimeException("The given method (" + method
							+ ") isn't valid for object of type " + obj.getClass());
				}
			}
		}
		return result;
	}

	public abstract void fillTemplateHole(Object obj, CodeTemplate template, String... args);

	private static String indexArray(String[] arr, String index) {
		String regex = "\\$args\\[(\\d)\\]";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(index);
		m.find();
		int idx = Integer.parseInt(m.group(1));
		return arr[idx];
	}
}
