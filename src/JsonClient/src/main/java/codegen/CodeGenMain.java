package codegen;

import java.io.IOException;
import java.net.MalformedURLException;

import codegen.codetemplates.CodeTemplate;
import codegen.codetemplates.CompoundCodeTemplate;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

/**
 * Main class for running stuff
 * 
 * @author justin nelson
 */
public class CodeGenMain {
	/**
	 * Stuff...It's a main...what do you expect?
	 * 
	 * @param args
	 * @throws JsonIOException
	 * @throws JsonSyntaxException
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public static void main(String[] args) throws JsonIOException, JsonSyntaxException, MalformedURLException,
			IOException {
		CodeTemplate template = CodeTemplate.loadTemplate("files/code_templates/DTOTemplate.jav");
		CompoundCodeTemplate props = (CompoundCodeTemplate) template.getTemplateEntry("properties");
		props.addMappingSet(props.getEmptyTemplate());
		props.addMappingSet(props.getEmptyTemplate());
		props.addMappingSet(props.getEmptyTemplate());
		props.addMappingSet(props.getEmptyTemplate());
		props.addMappingSet(props.getEmptyTemplate());
		props.addMappingSet(props.getEmptyTemplate());
		System.out.println(template.codeReplacement());
	}
}
