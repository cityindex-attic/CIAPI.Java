package codegen;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import JsonClient.Java.ApiException;

import codegen.codetemplates.CodeTemplate;
import codegen.codetemplates.templatecompletion.TemplateFiller;
import codegen.codetemplates.templatecompletion.replacementrule.ReplacementRoot;
import codegen.modelobjects.DTO;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

/**
 * Main class for running stuff
 * 
 * @author justin nelson
 */
public class CodeGenMain {
	private static String schemaLocation = "files/smdFiles/schema.js";
	private static String smdLocation = "files/smdFiles/smd.js";

	/**
	 * Stuff...It's a main...what do you expect?
	 * 
	 * @param args
	 * @throws JsonIOException
	 * @throws JsonSyntaxException
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public static void main(String[] args) throws JsonIOException, JsonSyntaxException,
			MalformedURLException, IOException, ApiException, ParserConfigurationException,
			SAXException {
		String test = "prop.getValue().getType($args[1])";
		ReplacementRoot root = new ReplacementRoot(
				"files/code_replacement_rules/dto_replacement_rule.xml");
		CodeTemplate template = CodeTemplate.loadTemplate("files/code_templates/DTOTemplate.jav");
		TemplateFiller filler = new TemplateFiller();
		SchemaReader rdr = new SchemaReader(new FileInputStream(schemaLocation),
				new FileInputStream(smdLocation));
		
		for(Entry<String, DTO>e: rdr.getAllModelItems().entrySet()){
			System.out.println(filler.fillTemplate(e.getValue(), template, root, e.getKey(), "CIAPI.Java"));
		}
		//rdr.createPackage("CIAPI.Java",
		//		"/home/justin/workspace/CIAPI.Java/src/CIAPI.Java/src/main/java/CIAPI/Java/");
	}
}
