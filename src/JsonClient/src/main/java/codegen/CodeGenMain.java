package codegen;

import java.io.IOException;
import java.net.MalformedURLException;

import codegen.codetemplates.CodeTemplate;

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
	 */
	public static void main(String[] args) throws JsonIOException, JsonSyntaxException, MalformedURLException,
			IOException {
		CodeTemplate tplate= CodeTemplate.loadTemplate("files/code_templates/ServiceTemplate.jav");
		System.out.println(tplate);
		//SchemaReader rdr = new SchemaReader(new FileInputStream(schemaLocation), new FileInputStream(smdLocation));
		//rdr.getAllModelItems();
		//rdr.createPackage("somePkg", "/home/justin");
	}
}
