package CIAPI.Java.pricewidget.model;

import static CIAPI.Java.android.Constants.TAG;
import CIAPI.Java.core.ServiceMethods;
import CIAPI.Java.core.dto.ApiLogOffResponseDTO;
import CIAPI.Java.core.dto.ApiLogOnResponseDTO;
import CIAPI.Java.core.impl.ServiceMethodsImpl;
import JsonClient.Java.ApiException;
import JsonClient.Java.DefaultJsonClient;
import JsonClient.Java.JsonApi;
import android.content.Context;
import android.content.SharedPreferences;

public class LogOnStatus {
	private static final String USERNAME_KEY = "username_@@";
	private static final String PASSWORD_KEY = "password_@@";
	private static final String SESSION__KEY = "session__@@";

	private static final ServiceMethods methods = new ServiceMethodsImpl();

	private Context ctx;

	public LogOnStatus(Context context) {
		ctx = context;
	}

	public String logOn(String username, String password) throws ApiException {
		ApiLogOnResponseDTO resp = methods.LogOn(username, password, api());
		saveString(USERNAME_KEY, username);
		saveString(PASSWORD_KEY, password);
		saveString(SESSION__KEY, resp.getSession());
		return resp.getSession();
	}

	public String refreshLogOn() throws ApiException {
		ApiLogOnResponseDTO resp = methods.LogOn(username(), password(), api());
		saveString(SESSION__KEY, resp.getSession());
		return resp.getSession();
	}

	public void logOut() throws ApiException {
		ApiLogOffResponseDTO resp = methods.DeleteSession(username(), session(), api());
		if (!resp.getLoggedOut()) {
			throw new ApiException("Failed to log off....cuz!");
		}
	}

	public String username() {
		return getString(USERNAME_KEY);
	}

	public String session() {
		return getString(SESSION__KEY);
	}

	private String password() {
		return getString(PASSWORD_KEY);
	}

	public JsonApi api() {
		JsonApi api = new JsonApi("http://ciapipreprod.cityindextest9.co.uk/TradingApi", new DefaultJsonClient());
		api.addConstantParameter("session", session());
		api.addConstantParameter("username", username());
		return api;
	}

	private SharedPreferences shrdPref() {
		return ctx.getSharedPreferences(TAG, Context.MODE_WORLD_READABLE);
	}

	private SharedPreferences.Editor editor() {
		return shrdPref().edit();
	}

	private void saveString(String key, String string) {
		editor().putString(key, string).commit();
	}

	private String getString(String key) {
		return shrdPref().getString(key, null);
	}
}
