package codegen.CIAPI;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

import codegen.SchemaReader;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

public class CIAPICodeGen {
	private String schemaLocation = "http://ciapipreprod.cityindextest9.co.uk/TradingApi/schema";
	private String smdLocation = "http://ciapipreprod.cityindextest9.co.uk/TradingApi/smd";

	private SchemaReader desc;

	public CIAPICodeGen() {
		desc = new SchemaReader(schemaLocation, smdLocation);
	}

	public void createLibrary() throws JsonIOException, JsonSyntaxException, MalformedURLException, IOException {
		String saveLocation = "/home/justin/workspace/CIAPI.Java/src/JsonClient/src/main/java/autogenciapi";
		desc.createPackage("autogenciapi", saveLocation);
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		compiler.run(null, null, null, saveLocation + "/*.java");
	}
}
