package CIAPI.Java.pricewidget;

import static CIAPI.Java.android.Constants.*;
import CIAPI.Java.core.ServiceMethods;
import CIAPI.Java.core.dto.ApiLogOnResponseDTO;
import CIAPI.Java.core.dto.GetPriceTickResponseDTO;
import CIAPI.Java.core.dto.PriceTickDTO;
import CIAPI.Java.core.impl.ServiceMethodsImpl;
import JsonClient.Java.ApiException;
import JsonClient.Java.DefaultJsonClient;
import JsonClient.Java.JsonApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class CIAPIPriceHelper {
	private static final String USERNAME_KEY = "username_@@";
	private static final String PASSWORD_KEY = "password_@@";
	private static final String SESSION__KEY = "session__@@";
	private static JsonApi api = new JsonApi("http://ciapipreprod.cityindextest9.co.uk/TradingApi",
			new DefaultJsonClient());
	private static final int stockId = 000;
	private static ServiceMethods methods = new ServiceMethodsImpl();

	public static String username(Context context) {
		SharedPreferences prefs = context.getSharedPreferences(TAG, Context.MODE_WORLD_READABLE);
		String username = prefs.getString(USERNAME_KEY, null);
		return username;
	}

	public static String session(Context context) {
		SharedPreferences prefs = context.getSharedPreferences(TAG, Context.MODE_WORLD_READABLE);
		String session = prefs.getString(SESSION__KEY, null);
		return session;
	}

	public static String session(Context context, String newSession) {
		context.getSharedPreferences(TAG, Context.MODE_WORLD_READABLE).edit().putString(SESSION__KEY, newSession)
				.commit();
		return newSession;
	}

	public static String password(Context context) {
		SharedPreferences prefs = context.getSharedPreferences(TAG, Context.MODE_WORLD_READABLE);
		String password = prefs.getString(PASSWORD_KEY, null);
		return password;
	}

	public static void logOn(String username, String password, Context context) {
		SharedPreferences prefs = context.getSharedPreferences(TAG, Context.MODE_WORLD_READABLE);
		prefs.edit().putString(USERNAME_KEY, username).putString(PASSWORD_KEY, password).commit();
		logOn(context);
	}

	public static void logOn(Context context) {
		String username = username(context);
		String password = password(context);
		Log.i(TAG, "Logging onto ciapi, username: " + username + ", password: " + password);
		if (username == null || password == null)
			return;
		try {
			ApiLogOnResponseDTO response = methods.LogOn(username, password, api);
			api.addConstantParameter("session", session(context, response.getSession()));
			api.addConstantParameter("username", username);
		} catch (ApiException e) {
			Log.e(TAG, "Error logging on to City Index", e);
		}
	}

	public static double getPrice(Context context) {
		Log.i(TAG, "Getting price ticks from api");
		api.addConstantParameter("session", session(context));
		api.addConstantParameter("username", username(context));
		GetPriceTickResponseDTO ticks_dto = null;
		try {
			ticks_dto = methods.GetPriceTicks(stockId + "", "10", api);
			PriceTickDTO[] ticks = ticks_dto.getPriceTicks();
			return ticks[ticks.length - 1].getPrice();
		} catch (Exception e) {
			Log.e(TAG, "Error getting ticks from the api", e);
			return Math.random() * 10;
		}
	}
}
