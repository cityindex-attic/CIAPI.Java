package CIAPI.Java.pricewidget.model.auth;

import static CIAPI.Java.android.Constants.TAG;
import CIAPI.Java.core.ServiceMethods;
import CIAPI.Java.core.dto.ApiLogOffResponseDTO;
import CIAPI.Java.core.dto.ApiLogOnResponseDTO;
import CIAPI.Java.core.impl.ServiceMethodsImpl;
import CIAPI.Java.pricewidget.activities.TradingApp;
import JsonClient.Java.ApiException;
import JsonClient.Java.DefaultJsonClient;
import JsonClient.Java.JsonApi;
import JsonClient.Java.async.AsyncJsonApi;
import JsonClient.Java.async.CallBack;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class LogOnStatus {
	private static final String USERNAME_KEY = "username_@@";
	private static final String PASSWORD_KEY = "password_@@";
	private static final String SESSION__KEY = "session__@@";

	private static final ServiceMethods methods = new ServiceMethodsImpl();

	public static void logOn(final String username, final String password) throws ApiException {
		Log.w(TAG, "Logging in: " + username);
		methods.LogOnAsync(username, password, apiAsync(), new CallBack() {
			@Override
			public void doCallBack(Object result, String baseUrl, String methodName) {
				Log.d(TAG, "Logged on async!!!");
				ApiLogOnResponseDTO resp = (ApiLogOnResponseDTO) result;
				saveString(SESSION__KEY, resp.getSession());
				saveString(USERNAME_KEY, username);
				saveString(PASSWORD_KEY, password);
				saveString(SESSION__KEY, resp.getSession());
				api.addConstantParameter("session", session());
				api.addConstantParameter("username", username());
			}
		});
	}

	public static void refreshLogOn() throws ApiException {
		Log.w(TAG, "Refreshing in: " + username());
		methods.LogOnAsync(username(), password(), apiAsync(), new CallBack() {
			@Override
			public void doCallBack(Object result, String baseUrl, String methodName) {
				Log.d(TAG, "Logged on async!!!");
				saveString(SESSION__KEY, ((ApiLogOnResponseDTO) result).getSession());
				api.addConstantParameter("session", session());
			}
		});
	}

	public static void logOut() throws ApiException {
		Log.w(TAG, "Logging out!!: " + username());
		ApiLogOffResponseDTO resp = methods.DeleteSession(username(), session(), api());
		if (!resp.getLoggedOut()) {
			throw new ApiException("Failed to log off....cuz!");
		} else {
			eraseAll();
		}
	}

	public static String username() {
		return getString(USERNAME_KEY);
	}

	public static void eraseUsername() {
		eraseString(USERNAME_KEY);
	}

	public static String session() {
		return getString(SESSION__KEY);
	}

	public static void eraseSession() {
		eraseString(SESSION__KEY);
	}

	private static String password() {
		return getString(PASSWORD_KEY);
	}

	public static void erasePassword() {
		eraseString(PASSWORD_KEY);
	}

	public static void eraseAll() {
		erasePassword();
		eraseSession();
		eraseUsername();
	}

	private static JsonApi api = new JsonApi("http://ciapipreprod.cityindextest9.co.uk/TradingApi",
			new DefaultJsonClient());
	private static AsyncJsonApi apiAsync = new AsyncJsonApi("http://ciapipreprod.cityindextest9.co.uk/TradingApi",
			new DefaultJsonClient());

	public static JsonApi api() {
		return api;
	}

	public static AsyncJsonApi apiAsync() {
		return apiAsync;
	}

	public static boolean isLoggedOn() {
		if (username() == null || username().equals("")) {
			return false;
		} else if (password() == null || password().equals("")) {
			return false;
		} else if (session() == null || session().equals("")) {
			return false;
		} else {
			return true;
		}
	}

	// ///
	// //Generic stuff follows
	// /

	private static SharedPreferences shrdPref() {
		SharedPreferences prefs = TradingApp.ctxt().getSharedPreferences(TAG, Context.MODE_PRIVATE);
		Log.d(TAG, "Getting prefs: " + prefs.toString());
		return prefs;
	}

	private static SharedPreferences.Editor editor() {
		return shrdPref().edit();
	}

	private static void saveString(String key, String string) {
		editor().putString(key, string).commit();
	}

	private static void eraseString(String key) {
		editor().putString(key, null);
	}

	private static String getString(String key) {
		return shrdPref().getString(key, null);
	}
}
