package CIAPI.Java.examples.ciapi;

import CIAPI.Java.ApiException;
import CIAPI.Java.DefaultJsonClient;
import CIAPI.Java.JsonApi;
import CIAPI.Java.httpstuff.DefaultSimpleHttpClient;
import CIAPI.Java.logging.Log;

public class Main {
	public static void main(String[] args) throws ApiException {
		JsonApi api = new JsonApi("http://ec2-174-129-8-69.compute-1.amazonaws.com/RESTWebServices/",
				new DefaultJsonClient());
		LogOnResponse resp = (LogOnResponse) api.callPostMethod("", null, new LogOnRequest("jjnguy", "p455w0rd"), LogOnResponse.class);
		Log.info(resp);
	}
}
