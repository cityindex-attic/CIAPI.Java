package codegen;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;
import java.util.Map.Entry;

import modelobjects.DTO;
import modelobjects.SMDDescriptor;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

public class CodeGenMain {
	public static void main(String[] args) throws JsonIOException, JsonSyntaxException, MalformedURLException,
			IOException {
		SchemaReader rdr = new SchemaReader();
		Map<String, DTO> allDTOs = rdr.getAllRoutesItems("http://ciapipreprod.cityindextest9.co.uk/TradingApi/schema");
		for(Entry<String, DTO> entry: allDTOs.entrySet()){
			System.out.println(entry.getValue().toCode(entry.getKey()));
		}
		SMDDescriptor smd = rdr.getServices("http://ciapipreprod.cityindextest9.co.uk/TradingApi/smd");
		System.out.println(smd);
	}
}
