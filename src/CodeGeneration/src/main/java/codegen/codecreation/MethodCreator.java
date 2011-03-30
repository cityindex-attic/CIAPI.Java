package codegen.codecreation;

import java.io.FileNotFoundException;
import java.util.Map.Entry;

import codegen.codetemplates.CodeTemplate;
import codegen.codetemplates.CompoundCodeTemplate;
import codegen.modelobjects.Parameter;
import codegen.modelobjects.SMDDescriptor;
import codegen.modelobjects.Service;

/**
 * Class for taking a Service model object and creating code.
 * 
 * @author Justin Nelson
 * 
 */
public class MethodCreator {

	private SMDDescriptor model;
	private String packageName;

	/**
	 * Creates a new MethodCreator out of the given model object.
	 * 
	 * @param model
	 * @param packageName
	 */
	public MethodCreator(SMDDescriptor model, String packageName) {
		this.model = model;
		this.packageName = packageName;
	}

	/**
	 * Replaces all of the template holes with data from the SMD descriptor that
	 * this MethodCreator represents.
	 * 
	 * @return a String representing an implementation of the service methods in
	 *         Java.
	 * @throws FileNotFoundException
	 *             if the template cannot be found.
	 */
	public String toCode() throws FileNotFoundException {
		// Top level template. Responsible for all methods
		CodeTemplate template = CodeTemplate.loadTemplate("files/code_templates/CombinedTemplateImpl.jav");
		template.putNewTemplateDefinition("packageName", packageName);
		CompoundCodeTemplate methods = (CompoundCodeTemplate) template.getTemplateEntry("methods");
		CodeTemplate emptyPropTemplate = methods.getEmptyTemplate();
		for (Entry<String, Service> entry : model.getServices().entrySet()) {
			// Template responsible only for 1 method
			CodeTemplate propTemplate = emptyPropTemplate.copyEmptyTemplate();
			propTemplate.putNewTemplateDefinition("name", entry.getKey());
			Service s = entry.getValue();
			propTemplate.putNewTemplateDefinition("description", s.getDescription());
			propTemplate.putNewTemplateDefinition("target", s.getTarget());
			propTemplate.putNewTemplateDefinition("uriTemplate", s.getUriTemplate());
			propTemplate.putNewTemplateDefinition("transport", s.getTransport());
			propTemplate.putNewTemplateDefinition("envelope", s.getEnvelope());
			propTemplate.putNewTemplateDefinition("contentType", s.getContentType());
			if (s.getTransport().equals("POST")) {
				propTemplate.putNewTemplateDefinition("postParam", s.getParameters()[0].getName());
			} else if (s.getTransport().equals("GET")) {
				propTemplate.putNewTemplateDefinition("postParam", "null");
			} else {
				throw new IllegalArgumentException("Unexpected transport type");
			}
			propTemplate.putNewTemplateDefinition("return", s.getReturns().get$ref(packageName + ".dto"));
			{
				// Build up parameters String
				String paramString = "";
				for (Parameter p : s.getParameters()) {
					paramString += (p.getType(packageName+".dto") + " " + p.getName() + ", ");
				}
				propTemplate.putNewTemplateDefinition("parameters",
						paramString.substring(0, Math.max(paramString.length() - 2, 0)));
				// The Math.max() above accounts for cases when there are no
				// parameters.
			}
			CompoundCodeTemplate fillParams = (CompoundCodeTemplate) propTemplate.getTemplateEntry("fillParameters");
			CodeTemplate emptyFillParamsTemplate = fillParams.getEmptyTemplate();
			for (Parameter p : s.getParameters()) {
				// Template responsible for replacing parameters in the URL
				CodeTemplate fillTemplate = emptyFillParamsTemplate.copyEmptyTemplate();
				fillTemplate.putNewTemplateDefinition("parameterName", p.getName());
				fillParams.addMappingSet(fillTemplate);
			}
			methods.addMappingSet(propTemplate);
		}
		return template.codeReplacement();
	}

	/**
	 * Creates the interface describing the code that was generated
	 * 
	 * @return a String of Java code
	 * @throws FileNotFoundException
	 */
	public String toInterface() throws FileNotFoundException {
		// Top level template. Responsible for all methods
		CodeTemplate template = CodeTemplate.loadTemplate("files/code_templates/CombinedTemplate.jav");
		template.putNewTemplateDefinition("packageName", packageName);
		CompoundCodeTemplate methods = (CompoundCodeTemplate) template.getTemplateEntry("methods");
		CodeTemplate emptyPropTemplate = methods.getEmptyTemplate();
		for (Entry<String, Service> entry : model.getServices().entrySet()) {
			// Template responsible only for 1 method
			CodeTemplate propTemplate = emptyPropTemplate.copyEmptyTemplate();
			propTemplate.putNewTemplateDefinition("name", entry.getKey());
			Service s = entry.getValue();
			propTemplate.putNewTemplateDefinition("description", s.getDescription());
			propTemplate.putNewTemplateDefinition("return", s.getReturns().get$ref(packageName + ".dto"));
			{
				// Build up parameters String
				String paramString = "";
				for (Parameter p : s.getParameters()) {
					paramString += (p.getType(packageName+".dto") + " " + p.getName() + ", ");
				}
				propTemplate.putNewTemplateDefinition("parameters",
						paramString.substring(0, Math.max(paramString.length() - 2, 0)));
			}
			CompoundCodeTemplate fillParams = (CompoundCodeTemplate) propTemplate
					.getTemplateEntry("parameterDescriptions");
			CodeTemplate emptyFillParamsTemplate = fillParams.getEmptyTemplate();
			for (Parameter p : s.getParameters()) {
				// Template responsible for replacing parameters in the URL
				CodeTemplate fillTemplate = emptyFillParamsTemplate.copyEmptyTemplate();
				fillTemplate.putNewTemplateDefinition("paramName", p.getName());
				fillTemplate.putNewTemplateDefinition("paramDesc", p.getDescription());
				fillParams.addMappingSet(fillTemplate);
			}
			methods.addMappingSet(propTemplate);
		}
		return template.codeReplacement();
	}
}
