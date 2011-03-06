package codegen;

import java.io.IOException;
import java.net.MalformedURLException;

import codegen.CIAPI.CIAPICodeGen;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

public class CodeGenMain {
	public static void main(String[] args) throws JsonIOException, JsonSyntaxException, MalformedURLException,
			IOException {
		CodeTemplate template = new CodeTemplate("files/code_templates/ServiceTemplate.jav");
		System.out.println("done");
	}
}
