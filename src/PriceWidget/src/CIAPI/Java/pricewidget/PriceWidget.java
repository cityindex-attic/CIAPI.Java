package CIAPI.Java.pricewidget;

import static CIAPI.Java.android.Constants.*;
import CIAPI.Java.pricewidget.activities.TradingApp;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;
import android.widget.RemoteViews;

public class PriceWidget extends AppWidgetProvider {

	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
		Log.i(TAG, "Updating City Index trading app in onUpdate method");
		for (int i = 0; i < appWidgetIds.length; i++) {
			RemoteViews widg = new RemoteViews(context.getPackageName(), R.layout.widg_layout);
			Intent clickIntent = new Intent(context, TradingApp.class);
			PendingIntent clickPI = PendingIntent.getActivity(context, 0, clickIntent,
					PendingIntent.FLAG_UPDATE_CURRENT);
			widg.setOnClickPendingIntent(R.id.text, clickPI);
			
			Intent updatePriceService = new Intent(context, UpdatePricesService.class);
			Intent remainLoggedInService = new Intent(context, RemainLoggedIn.class);
			
			PendingIntent pendingUpdatePrice = PendingIntent.getService(context, 0, updatePriceService, 0);
			PendingIntent pendingLogIn = PendingIntent.getService(context, 0, remainLoggedInService, 0);
			AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
			alarmManager.setRepeating(AlarmManager.ELAPSED_REALTIME, SystemClock.elapsedRealtime(), 1000 * 10,
					pendingUpdatePrice);
			alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME, SystemClock.elapsedRealtime()
					+ AlarmManager.INTERVAL_FIFTEEN_MINUTES, AlarmManager.INTERVAL_FIFTEEN_MINUTES, pendingLogIn);
			CIAPIPriceHelper.logOn(context);
		}
	}

	@Override
	public void onDeleted(Context context, int[] appWidgetIds) {
		super.onDeleted(context, appWidgetIds);
		Log.i(TAG, "Deleted widget");
		AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
		alarmManager.cancel(PendingIntent.getService(context, 0, new Intent(context, UpdatePricesService.class), 0));
	}

	public static class RemainLoggedIn extends Service {
		@Override
		public void onStart(Intent intent, int startId) {
			Log.i(TAG, "Running login task");
			CIAPIPriceHelper.logOn(this);
		}

		@Override
		public IBinder onBind(Intent intent) {
			return null;
		}
	}

	public static class UpdatePricesService extends Service {
		@Override
		public void onStart(Intent intent, int startId) {
			Log.i(TAG, "Updating City Index trading app in service method");
			RemoteViews view = new RemoteViews(getPackageName(), R.layout.widg_layout);
			view.setTextViewText(R.id.text, "Woah! " + CIAPIPriceHelper.getPrice(this));

			AppWidgetManager mgr = AppWidgetManager.getInstance(this);
			mgr.updateAppWidget(new ComponentName(this, PriceWidget.class), view);
		}

		@Override
		public IBinder onBind(Intent intent) {
			return null;
		}
	}
}
