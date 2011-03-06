package codegen.codecreation;

import java.util.Map.Entry;

import codegen.modelobjects.DTO;
import codegen.modelobjects.Option;
import codegen.modelobjects.Property;

public class DTOCreator {
	private DTO dto;

	public DTOCreator(DTO dto) {
		this.dto = dto;
	}

	public String toCode(String name, String packageName) {
		// Enums are parsed differently
		if (dto.getEnum_() != null || dto.getOptions() != null) {
			return enumToCode(name, packageName);
		}

		// TODO fix the package modifiers on the types. Currently '#.'
		String packageDeclaration = "package " + packageName + ";\n\n";
		String javadocComment = String.format("/**\n" + " * %s\n" + " * \n" + " * {auto generated from JSON schema}\n"
				+ " */\n", dto.getDescription());
		String classDescriptor = String.format("public class %s {\n", dto.getId());
		StringBuilder membersBuilder = new StringBuilder();
		if (dto.getProperties() != null) {
			for (Entry<String, Property> entry : dto.getProperties().entrySet()) {
				membersBuilder.append(String.format("\tpublic %s %s;\n", entry.getValue().getType(packageName),
						entry.getKey()));
			}
		} else {
			System.out.println("");
		}
		String members = membersBuilder.toString();
		String classEnd = "}";
		return packageDeclaration + javadocComment + classDescriptor + members + classEnd;
	}

	private String enumToCode(String key, String packageName) {
		if (dto.getEnum_() == null || dto.getOptions() == null) {
			throw new IllegalStateException("Enums must have both the 'enum' and 'options' property.");
		}
		if (dto.getOptions().length != dto.getEnum_().length) {
			throw new IllegalStateException("The 'enum' and 'options' property must have the same length.");
		}
		String packageDeclaration = "package " + packageName + ";\n\n";
		String javadocComment = String.format("/**\n" + " * %s\n" + " * Auto generated Enum\n" + " */\n",
				dto.getDescription());
		String enumDescriptor = String.format("public enum %s {\n", key);
		StringBuilder itemBuilder = new StringBuilder();
		for (Option o : dto.getOptions()) {
			itemBuilder.append("\t/**\n" + "\t * " + o.getDescription() + "\n" + "\t */\n");
			itemBuilder.append("\t" + o.getLabel() + ",\n");
		}
		String items = itemBuilder.substring(0, itemBuilder.length() - 2) + "\n";
		String enumEnd = "}";
		return packageDeclaration + javadocComment + enumDescriptor + items + enumEnd;
	}

	/**
	 * Converts a Json type into a Java type.
	 * 
	 * @param jsonType
	 * @return
	 */
	public static String convertJsonTypeToJavaType(String jsonType) {
		if (jsonType.equals("string"))
			return "String";
		else if (jsonType.equals("number")) {
			return "double";
		} else if (jsonType.equals("integer")) {
			return "int";
		} else if (jsonType.equals("boolean")) {
			return "boolean";
		} else {
			throw new IllegalArgumentException("Unexpected json type: " + jsonType);
		}
	}
}
