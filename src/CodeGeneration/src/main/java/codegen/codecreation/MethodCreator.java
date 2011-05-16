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
 * @deprecated
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
		CodeTemplate template = CodeTemplate.loadTemplate("C:/Users/Justin/workspace/CIAPI.Java/src/CodeGeneration/files/code_templates/CombinedTemplateImpl.jav");
		template.putNewTemplateDefinition("packageName", packageName);
		CompoundCodeTemplate methods = (CompoundCodeTemplate) template.getTemplateEntry("methods");
		CodeTemplate emptyMethodTemplate = methods.getEmptyTemplate();
		for (Entry<String, Service> entry : model.getServices().entrySet()) {
			// Template responsible only for 1 method
			CodeTemplate methodTemplate = emptyMethodTemplate.copyEmptyTemplate();
			methodTemplate.putNewTemplateDefinition("name", entry.getKey());
			Service s = entry.getValue();
			methodTemplate.putNewTemplateDefinition("description", s.getDescription());
			methodTemplate.putNewTemplateDefinition("target", s.getTarget());
			methodTemplate.putNewTemplateDefinition("uriTemplate", s.getUriTemplate());
			methodTemplate.putNewTemplateDefinition("transport", s.getTransport());
			methodTemplate.putNewTemplateDefinition("envelope", s.getEnvelope());
			methodTemplate.putNewTemplateDefinition("contentType", s.getContentType());
			methodTemplate.putNewTemplateDefinition("postParam", s.getParameters().get(0).getName());
			methodTemplate.putNewTemplateDefinition("return", s.getReturns().get$ref(packageName + ".dto"));
			CompoundCodeTemplate params = (CompoundCodeTemplate) methodTemplate.getTemplateEntry("parameters");
			CodeTemplate emptyParamsTemplate = params.getEmptyTemplate();
			for (Parameter p : s.getParameters()) {
				CodeTemplate paramTemplate = emptyParamsTemplate.copyEmptyTemplate();
				paramTemplate.putNewTemplateDefinition("pName", p.getName());
				paramTemplate.putNewTemplateDefinition("pType", p.getType(packageName+".dto"));
				params.addMappingSet(paramTemplate);
			}
			CompoundCodeTemplate fillParams = (CompoundCodeTemplate) methodTemplate.getTemplateEntry("fillParameters");
			CodeTemplate emptyFillParamsTemplate = fillParams.getEmptyTemplate();
			for (Parameter p : s.getParameters()) {
				// Template responsible for replacing parameters in the URL
				CodeTemplate fillTemplate = emptyFillParamsTemplate.copyEmptyTemplate();
				fillTemplate.putNewTemplateDefinition("parameterName", p.getName());
				fillParams.addMappingSet(fillTemplate);
			}
			methods.addMappingSet(methodTemplate);
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
		CodeTemplate template = CodeTemplate.loadTemplate("C:/Users/Justin/workspace/CIAPI.Java/src/CodeGeneration/files/code_templates/CombinedTemplate.jav");
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
			CompoundCodeTemplate params = (CompoundCodeTemplate) propTemplate.getTemplateEntry("parameters");
			CodeTemplate emptyParamsTemplate = params.getEmptyTemplate();
			for (Parameter p : s.getParameters()) {
				CodeTemplate paramTemplate = emptyParamsTemplate.copyEmptyTemplate();
				paramTemplate.putNewTemplateDefinition("pName", p.getName());
				paramTemplate.putNewTemplateDefinition("pType", p.getType(packageName+".dto"));
				params.addMappingSet(paramTemplate);
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
