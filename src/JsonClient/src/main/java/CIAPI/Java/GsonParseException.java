package CIAPI.Java;

import com.google.gson.JsonSyntaxException;

public class GsonParseException extends ApiException {

	public GsonParseException(JsonSyntaxException jsonEx, String data) {
		super(data);
		System.out.println(getMessage());
	}
}
