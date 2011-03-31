package JsonClient.Java;

import com.google.gson.JsonSyntaxException;

public class GsonParseException extends ApiException {

	private static final long serialVersionUID = -9088790377206707199L;

	public GsonParseException(JsonSyntaxException jsonEx, String data) {
		super(data);
		System.out.println(getMessage());
	}
}
