package CIAPI.Java.pricewidget;

import static CIAPI.Java.android.Constants.TAG;

import java.text.SimpleDateFormat;
import java.util.Date;

import CIAPI.Java.pricewidget.activities.TradingApp;
import CIAPI.Java.pricewidget.model.auth.LogOnStatus;
import CIAPI.Java.pricewidget.model.stock.IStock;
import CIAPI.Java.pricewidget.model.stock.IStockSearch;
import CIAPI.Java.pricewidget.model.stock.IStock.PriceStatus;
import CIAPI.Java.pricewidget.model.stock.impl.RealStock;
import CIAPI.Java.pricewidget.model.stock.impl.StockSearch;
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
			alarmManager.setRepeating(AlarmManager.ELAPSED_REALTIME, SystemClock.elapsedRealtime(), 1000 * 10,
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
				LogOnStatus.refreshLogOn();
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
			stocks = new StockSearch();
		}

		@Override
		public void onStart(Intent intent, int startId) {
			// TODO giant try/catch...ug
			try {
				Log.i(TAG, "Updating City Index trading app in service method");
				RemoteViews view = new RemoteViews(getPackageName(), R.layout.widg_layout_3);
				Log.d(TAG, "Whitelist: " + RealStock.WHITE_LIST[10]);
				IStock s1 = stocks.getById(Integer.parseInt(RealStock.WHITE_LIST[10]));
				Log.d(TAG, "Whitelist: " + RealStock.WHITE_LIST[20]);
				IStock s2 = stocks.getById(Integer.parseInt(RealStock.WHITE_LIST[11]));
				Log.d(TAG, "Whitelist: " + RealStock.WHITE_LIST[30]);
				IStock s3 = stocks.getById(Integer.parseInt(RealStock.WHITE_LIST[12]));
				setText(view, s1, R.id.price1, R.id.change1);
				setText(view, s2, R.id.price2, R.id.change2);
				setText(view, s3, R.id.price3, R.id.change3);

				SimpleDateFormat fmt = new SimpleDateFormat("hh:mm.ss");
				String date = fmt.format(new Date(System.currentTimeMillis()));
				view.setTextViewText(R.id.lastValue, date);

				AppWidgetManager mgr = AppWidgetManager.getInstance(this);
				mgr.updateAppWidget(new ComponentName(this, PriceWidget.class), view);
			} catch (Exception e) {
				Log.w(TAG, "Whoops, error pulling prices:" + e.getMessage());
			}
		}

		private static void setText(RemoteViews view, IStock stock, int priceid, int changeid) {
			double price = stock.currentPrice();
			double lastPrice = stock.lastPrice();
			boolean isRising = stock.getStatus() == PriceStatus.RISING;
			int color = isRising ? Color.GREEN : Color.RED;
			view.setTextColor(priceid, color);
			view.setTextViewText(priceid, stock.getRICCode() + " " + price);
			view.setTextColor(changeid, color);
			view.setTextViewText(changeid, String.format("%.2f     ", price - lastPrice));
		}

		@Override
		public IBinder onBind(Intent intent) {
			return null;
		}
	}
}
