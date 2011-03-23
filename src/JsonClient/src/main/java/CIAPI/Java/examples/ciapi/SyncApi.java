package CIAPI.Java.examples.ciapi;

import CIAPI.Java.ApiException;
import CIAPI.Java.JsonApi;
import CIAPI.Java.examples.ciapi.dto.CreateSessionResponseDTO;
import CIAPI.Java.examples.ciapi.dto.SessionDeletionResponseDTO;
import CIAPI.Java.examples.ciapi.impl.ServiceMethodsImpl;

/**
 * API for connecting to the City Index Trading RESTful API. All requests are
 * made synchronously.
 * 
 * The body of this class will eventually be auto-generated. Right now it just
 * serves as an example of what we need the generated code to look like.
 * 
 * @author Justin Nelson
 * 
 */
public class SyncApi {
	private final String Api_Base_Url = "http://ciapipreprod.cityindextest9.co.uk/TradingApi";

	private JsonApi api;

	private String username;
	private String password;
	private String sessionId;
	private boolean keepAlive;
	private ServiceMethods methods;

	public SyncApi() {
		methods = new ServiceMethodsImpl();
	}

	public void logIn(String username, String password, boolean keepAlive) throws ApiException {
		CreateSessionResponseDTO response = methods.CreateSession(username, password);
		sessionId = response.getSession();
		this.keepAlive = keepAlive;
		this.username = username;
		if (keepAlive) {
			this.password = password;
		}
	}

	public boolean logOff() throws ApiException {
		SessionDeletionResponseDTO response = methods.DeleteSession(username, sessionId);
		return response.getLoggedOut();
	}

	private void keepAlive() throws ApiException {
		if (keepAlive) {
			logIn(username, password, keepAlive);
		}
	}
}
