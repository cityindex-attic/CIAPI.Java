package codegen;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import JsonClient.Java.ApiException;

import codegen.codetemplates.templatecompletion.replacementrule.ReplacementRoot;

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
	public static void main(String[] args) throws JsonIOException, JsonSyntaxException, MalformedURLException,
			IOException, ApiException, ParserConfigurationException, SAXException {
		new ReplacementRoot("files/code_replacement_rules/dto_replacement_rule.xml");
		//SchemaReader rdr = new SchemaReader(new FileInputStream(schemaLocation), new FileInputStream(smdLocation));
		//rdr.createPackage("CIAPI.Java",
		//		"/home/justin/workspace/CIAPI.Java/src/CIAPI.Java/src/main/java/CIAPI/Java/");
	}
}
