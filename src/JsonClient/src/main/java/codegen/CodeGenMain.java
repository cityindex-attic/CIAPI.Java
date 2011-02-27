package codegen;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;

import modelobjects.DTO;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

public class CodeGenMain {
	public static void main(String[] args) throws JsonIOException, JsonSyntaxException, MalformedURLException,
			IOException {
		SchemaReader rdr = new SchemaReader();
		Map<String, DTO> allDTOs = rdr.getAllRoutesItems("http://ciapipreprod.cityindextest9.co.uk/TradingApi/schema");
		System.out.println(allDTOs.size());
	}
}
