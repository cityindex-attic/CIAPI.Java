package CIAPI.Java.pricewidget;

import static CIAPI.Java.android.Constants.*;
import CIAPI.Java.pricewidget.activities.TradingApp;
import CIAPI.Java.pricewidget.model.FakeStockSearch;
import CIAPI.Java.pricewidget.model.IStock;
import CIAPI.Java.pricewidget.model.IStock.PriceStatus;
import CIAPI.Java.pricewidget.model.LogOnStatus;
import CIAPI.Java.pricewidget.model.IStockSearch;
import JsonClient.Java.ApiException;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;
import android.widget.RemoteViews;

public class PriceWidget extends AppWidgetProvider {

	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
		Log.i(TAG, "Updating City Index trading app in onUpdate method");
		for (int i = 0; i < appWidgetIds.length; i++) {
			RemoteViews widg = new RemoteViews(context.getPackageName(), R.layout.widg_layout_3);
			Intent clickIntent = new Intent(context, TradingApp.class);
			PendingIntent clickPI = PendingIntent.getActivity(context, 0, clickIntent,
					PendingIntent.FLAG_UPDATE_CURRENT);
			widg.setOnClickPendingIntent(R.id.price1, clickPI);

			Intent updatePriceService = new Intent(context, UpdatePricesService.class);
			Intent remainLoggedInService = new Intent(context, RemainLoggedIn.class);

			PendingIntent pendingUpdatePrice = PendingIntent.getService(context, 0, updatePriceService, 0);
			PendingIntent pendingLogIn = PendingIntent.getService(context, 0, remainLoggedInService, 0);
			AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
			alarmManager.setRepeating(AlarmManager.ELAPSED_REALTIME, SystemClock.elapsedRealtime(), 1000 * 1,
					pendingUpdatePrice);
			alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME, SystemClock.elapsedRealtime()
					+ AlarmManager.INTERVAL_FIFTEEN_MINUTES, AlarmManager.INTERVAL_FIFTEEN_MINUTES, pendingLogIn);
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
			try {
				new LogOnStatus(this).refreshLogOn();
			} catch (ApiException e) {
				Log.e(TAG, "Error refreshign logon", e);
			}
		}

		@Override
		public IBinder onBind(Intent intent) {
			return null;
		}
	}

	public static class UpdatePricesService extends Service {
		private IStockSearch stocks;

		public UpdatePricesService() {
			super();
			stocks = new FakeStockSearch();
		}

		@Override
		public void onStart(Intent intent, int startId) {
			Log.i(TAG, "Updating City Index trading app in service method");
			RemoteViews view = new RemoteViews(getPackageName(), R.layout.widg_layout_3);
			IStock s1 = stocks.getFromRICCode("SPY");
			IStock s2 = stocks.getFromRICCode("SNE");
			IStock s3 = stocks.getFromRICCode("OIL");
			view.setTextColor(R.id.price1, s1.getStatus() == PriceStatus.RISING ? Color.GREEN : Color.RED);
			view.setTextViewText(R.id.price1, s1.getName() + " " + s1.currentPrice());
			view.setTextColor(R.id.price2, s2.getStatus() == PriceStatus.RISING ? Color.GREEN : Color.RED);
			view.setTextViewText(R.id.price2, s2.getName() + " " + s2.currentPrice());
			view.setTextColor(R.id.price3, s3.getStatus() == PriceStatus.RISING ? Color.GREEN : Color.RED);
			view.setTextViewText(R.id.price3, s3.getName() + " " + s3.currentPrice());

			AppWidgetManager mgr = AppWidgetManager.getInstance(this);
			mgr.updateAppWidget(new ComponentName(this, PriceWidget.class), view);
		}

		@Override
		public IBinder onBind(Intent intent) {
			return null;
		}
	}
}
