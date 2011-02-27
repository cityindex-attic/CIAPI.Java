package modelobjects;

public class Service {

	private String description;
	private String target;
	private String uriTemplate;
	private String contentType;
	private String responseContentType;
	private String transport;
	private String envelope;
	private Return returns;
	private String group;
	private String throttleScope;
	private Parameter[] parameters;
	
	
	/*
      "envelope": "JSON",
      "returns": {
        "$ref": "#.CreateSessionResponseDTO"
      },
      "group": "Authentication",
      "throttleScope": "data",
      "parameters": [
        {
          "type": "string",
          "name": "UserName",
          "description": "Username is case sensitive",
          "minLength": 6,
          "maxLength": 20
        },
        {
          "type": "string",
          "name": "Password",
          "description": "Password is case sensitive",
          "minLength": 6,
          "maxLength": 20
        }
      ]
	 */
	
}
