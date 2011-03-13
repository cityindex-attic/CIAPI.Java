package codegen;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;
import java.util.Map.Entry;

import codegen.CIAPI.CIAPICodeGen;
import codegen.codecreation.DTOCreator;
import codegen.codetemplates.CodeTemplate;
import codegen.codetemplates.CompoundCodeTemplate;
import codegen.modelobjects.DTO;

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
		Map<String, DTO> dtos = rdr.getAllModelItems();
		for(Entry<String, DTO> entry: dtos.entrySet()){
			DTOCreator creator = new DTOCreator(entry.getKey(), entry.getValue(), "coolpkg.pkg");
			System.out.println(creator.toCode());
		}
	}
}
