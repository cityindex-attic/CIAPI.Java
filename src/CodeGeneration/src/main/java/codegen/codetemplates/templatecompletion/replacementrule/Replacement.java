package codegen.codetemplates.templatecompletion.replacementrule;

import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import codegen.codetemplates.CodeTemplate;

/**
 * Class that handles parsing a string and using reflection to create actual method calls and
 * resulting return values.
 * 
 * @author Justin Nelson
 * 
 */
public abstract class Replacement {

	protected String templateValue;
	protected String objectValue;
	protected String objectName;

	/**
	 * Creates a new Replacement with the given values.
	 * 
	 * @param templateValue
	 *            the name of the value in the template to replace
	 * @param objectValue
	 *            the methods to call on the object to retrieve the desired result
	 * @param objectName
	 *            the name of the variable we are calling methods on
	 */
	public Replacement(String templateValue, String objectValue, String objectName) {
		this.templateValue = templateValue;
		this.objectValue = objectValue;
		this.objectName = objectName;
	}

	/**
	 * The name of the template value we are replacing
	 * 
	 * @return
	 */
	public String getTemplateName() {
		return templateValue;
	}

	/**
	 * Given some object, call the method chain and create a result.
	 * 
	 * @param obj
	 *            the object to mutate
	 * @param args
	 *            extra arguments passed into the template
	 * @return the resulting object
	 */
	protected Object resolveValue(Object obj, String... args) {
		Object result = obj;
		// simple args access
		if (objectValue.startsWith("$args")) {
			result = indexArray(args, objectValue);
		} else if (objectValue.startsWith("@")) {
			// Here a string literal was given to us
			return objectValue.substring(1);
		} else {
			// otherwise we are using reflection to call the specified method
			// break the statement into the different method calls
			String[] methods = objectValue.split("\\.");
			for (String method : methods) {
				if (!method.contains("(")) {
					// this is the case for the name of the variable the methods are being called on
					// we just ignore it
					continue;
				}
				String name = method.substring(0, method.indexOf('('));
				String methodArgs = method.substring(method.indexOf("(") + 1, method.indexOf(')'));
				try {
					if (methodArgs.trim().length() == 0) {
						Method method2 = result.getClass().getMethod(name);
						method2.setAccessible(true);
						result = method2.invoke(result);
					} else {
						Class<?> argType = inferType(methodArgs);
						Object value = getValue(methodArgs, args);
						Method method2 = result.getClass().getMethod(name, argType);
						method2.setAccessible(true);
						result = method2.invoke(result, value);
					}
					if (result == null) {
						System.out.println("Whoops!!");
					}
				} catch (Exception e) {
					// Whoops, let's just keep going and see if we can partially recover later
					return null;
				}
			}
		}
		return result;
	}

	private Object getValue(String methodArgs, String... args) {
		if (methodArgs.startsWith("$")) {
			return indexArray(args, methodArgs);
		} else if (methodArgs.startsWith("#")) {
			return Integer.parseInt(methodArgs.substring(1));
		}
		return null;
	}

	/**
	 * Used to parse the type of an incoming value. Right now we only support strings and ints.
	 * 
	 * @param methodArgs
	 * @return
	 */
	private Class<?> inferType(String methodArgs) {
		if (methodArgs.startsWith("$")) {
			return String.class;
		} else if (methodArgs.startsWith("#")) {
			return int.class;
		}
		return null;
	}

	/**
	 * Fills a template given the rules of this replacement object
	 * 
	 * @param obj
	 * @param template
	 * @param args
	 */
	public abstract void fillTemplateHole(Object obj, CodeTemplate template, String... args);

	/**
	 * Takes an index that looks like "$args[n]" and returns item from arr at position 'n'
	 * 
	 * @param arr
	 * @param index
	 * @return
	 */
	private static String indexArray(String[] arr, String index) {
		String regex = "\\$args\\[(\\d)\\]";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(index);
		m.find();
		int idx = Integer.parseInt(m.group(1));
		return arr[idx];
	}
}
