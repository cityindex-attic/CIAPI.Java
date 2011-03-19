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

	public String toCode() throws FileNotFoundException {
		CodeTemplate template = CodeTemplate.loadTemplate("files/code_templates/ServiceTemplate.jav");
		template.putNewTemplateDefinition("packageName", packageName);
		CompoundCodeTemplate methods = (CompoundCodeTemplate) template.getTemplateEntry("methods");
		CodeTemplate emptyPropTemplate = methods.getEmptyTemplate();
		for (Entry<String, Service> entry : model.getServices().entrySet()) {
			CodeTemplate propTemplate = emptyPropTemplate.copyEmptyTemplate();
			propTemplate.putNewTemplateDefinition("name", entry.getKey());
			Service s = entry.getValue();
			propTemplate.putNewTemplateDefinition("description", s.getDescription());
			propTemplate.putNewTemplateDefinition("target", s.getTarget());
			propTemplate.putNewTemplateDefinition("uriTemplate", s.getUriTemplate());
			propTemplate.putNewTemplateDefinition("transport", s.getTransport());
			propTemplate.putNewTemplateDefinition("envelope", s.getEnvelope());
			propTemplate.putNewTemplateDefinition("contentType", s.getContentType());
			propTemplate.putNewTemplateDefinition("return", s.getReturns().get$ref(packageName));
			// Build up parameters String
			{
				String paramString = "";
				for (Parameter p : s.getParameters()) {
					paramString += (p.getType(packageName) + " " + p.getName() + ", ");
				}
				propTemplate.putNewTemplateDefinition("parameters",
						paramString.substring(0, Math.max(paramString.length() - 2, 0)));
			}
			CompoundCodeTemplate fillParams = (CompoundCodeTemplate) propTemplate.getTemplateEntry("fillParameters");
			CodeTemplate emptyFillParamsTemplate = fillParams.getEmptyTemplate();
			for (Parameter p : s.getParameters()) {
				CodeTemplate fillTemplate = emptyFillParamsTemplate.copyEmptyTemplate();
				fillTemplate.putNewTemplateDefinition("parameterName", p.getName());
				fillParams.addMappingSet(fillTemplate);
			}
			methods.addMappingSet(propTemplate);
		}
		return template.codeReplacement();
	}
}
