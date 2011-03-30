package codegen.codecreation;

import java.io.FileNotFoundException;
import java.util.Map.Entry;

import codegen.codetemplates.CodeTemplate;
import codegen.codetemplates.CompoundCodeTemplate;
import codegen.modelobjects.DTO;
import codegen.modelobjects.Option;
import codegen.modelobjects.Property;

/**
 * Class for turning a DTO object into a block of code.
 * 
 * @author Justin Nelson
 */
public class DTOCreator {
	private DTO dto;
	private String name;
	private String packageName;

	/**
	 * Creates a new DTOCreator out of the given DTO model object.
	 * 
	 * @param name
	 *            the name of this DTO class
	 * @param dto
	 *            the dto representing the class
	 * @param packageName
	 *            the name of the package this code belongs to.
	 */
	public DTOCreator(String name, DTO dto, String packageName) {
		this.dto = dto;
		this.name = name;
		// we generate DTOs in the dto package
		this.packageName = packageName + ".dto";
	}

	/**
	 * 
	 * @return Java code
	 * @throws FileNotFoundException
	 */
	public String toCode() throws FileNotFoundException {
		if (dto.getEnum_() != null || dto.getOptions() != null) {
			return enumToCode();
		}
		CodeTemplate template = CodeTemplate.loadTemplate("files/code_templates/DTOTemplate.jav");
		template.putNewTemplateDefinition("name", name);
		template.putNewTemplateDefinition("description", dto.getDescription());
		template.putNewTemplateDefinition("packageName", packageName);
		CompoundCodeTemplate propertyList = (CompoundCodeTemplate) template.getTemplateEntry("properties");
		CodeTemplate emptyPropTemplate = propertyList.getEmptyTemplate();
		for (Entry<String, Property> p : dto.getProperties().entrySet()) {
			CodeTemplate propTemplate = emptyPropTemplate.copyEmptyTemplate();
			propTemplate.putNewTemplateDefinition("propDesc", p.getValue().getDescription());
			propTemplate.putNewTemplateDefinition("propertyName", p.getKey());
			propTemplate.putNewTemplateDefinition("propertyType", p.getValue().getType(packageName));
			propertyList.addMappingSet(propTemplate);
		}
		return template.codeReplacement();
	}

	private String enumToCode() {
		if (dto.getEnum_() == null || dto.getOptions() == null) {
			throw new IllegalStateException("Enums must have both the 'enum' and 'options' property.");
		}
		if (dto.getOptions().length != dto.getEnum_().length) {
			throw new IllegalStateException("The 'enum' and 'options' property must have the same length.");
		}
		String packageDeclaration = "package " + packageName + ";\n\n";
		String javadocComment = String.format("/**\n" + " * %s\n" + " * Auto generated Enum\n" + " */\n",
				dto.getDescription());
		String enumDescriptor = String.format("public enum %s {\n", name);
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
	 * @return a Java type
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
