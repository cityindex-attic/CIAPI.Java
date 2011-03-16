package codegen;

import java.io.IOException;
import java.net.MalformedURLException;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

/**
 * Main class for running stuff
 * 
 * @author justin nelson
 */
public class CodeGenMain {
	private static String schemaLocation = "http://ciapipreprod.cityindextest9.co.uk/TradingApi/schema";
	private static String smdLocation = "http://ciapipreprod.cityindextest9.co.uk/TradingApi/smd";

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
		SchemaReader rdr = new SchemaReader(schemaLocation, smdLocation);
		rdr.createPackage("somePkg", "/home/justin");
	}
}
