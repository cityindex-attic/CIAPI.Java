package CIAPI.Java.examples.ciapi;

import CIAPI.Java.ApiException;
import CIAPI.Java.JsonApi;
import CIAPI.Java.cachestuff.Cache;
import CIAPI.Java.cachestuff.CachedJsonClient;
import CIAPI.Java.examples.ciapi.dto.CreateSessionResponseDTO;
import CIAPI.Java.examples.ciapi.dto.SessionDeletionResponseDTO;
import CIAPI.Java.examples.ciapi.impl.ServiceMethodsImpl;
import CIAPI.Java.httpstuff.DefaultHttpRequestItemFactory;
import CIAPI.Java.throttle.RequestQueue;
import CIAPI.Java.throttle.ThrottledHttpClient;

/**
 * API for connecting to the City Index Trading RESTful API. All requests are
 * made synchronously.
 * 
 * @author Justin Nelson
 */
public class SyncApi {
	private JsonApi api;

	private String username;
	private String password;
	private String sessionId;
	public String getSessionId() {
		return sessionId;
	}

	private boolean keepAlive;
	private ServiceMethods methods;

	protected SyncApi(String baseUrl, Cache<CachedJsonClient.Pair<String, Class<?>>, Object> cache, RequestQueue queue) {
		methods = new ServiceMethodsImpl();
		api = new JsonApi(baseUrl, new CachedJsonClient(cache, new ThrottledHttpClient(
				new DefaultHttpRequestItemFactory(), queue)));
	}

	public void logIn(String username, String password, boolean keepAlive) throws ApiException {
		CreateSessionResponseDTO response = methods.CreateSession(username, password);
		sessionId = response.getSession();
		this.keepAlive = keepAlive;
		this.username = username;
		if (keepAlive) {
			this.password = password;
		}
		api.addConstantParameter("UserName", username);
		api.addConstantParameter("Session", sessionId);
	}

	public boolean logOff() throws ApiException {
		SessionDeletionResponseDTO response = methods.DeleteSession(username, sessionId);
		if (response.getLoggedOut()) {
			api.clearConstantParams();
			return true;
		}
		{
			return false;
		}
	}

	private void keepAlive() throws ApiException {
		if (keepAlive) {
			logIn(username, password, keepAlive);
		}
	}
}
