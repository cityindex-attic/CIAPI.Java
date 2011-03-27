package codegen;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.Future;

import CIAPI.Java.ApiException;
import CIAPI.Java.async.AsyncApiCall;
import CIAPI.Java.async.CallBack;
import CIAPI.Java.examples.ciapi.AsyncApi;
import CIAPI.Java.examples.ciapi.SyncApi;
import CIAPI.Java.examples.ciapi.ApiFActory;
import CIAPI.Java.examples.ciapi.dto.CreateSessionResponseDTO;

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
			IOException, ApiException {
		SchemaReader rdr = new SchemaReader(new FileInputStream(schemaLocation), new FileInputStream(smdLocation));
		rdr.createPackage("CIAPI.Java.examples.ciapi",
				"/home/justin/workspace/CIAPI.Java/src/JsonClient/src/main/java/CIAPI/Java/examples/ciapi/");
	}
}
