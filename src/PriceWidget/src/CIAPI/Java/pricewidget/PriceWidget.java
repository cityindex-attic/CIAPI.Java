package CIAPI.Java.pricewidget;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;
import android.widget.RemoteViews;

public class PriceWidget extends AppWidgetProvider {

	private int updateCount = 0;

	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
		Log.i("CityIndex", "Updating City Index trading app");
		RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.main);
		ComponentName priceWidget = new ComponentName(context, PriceWidget.class);
		remoteViews.setTextViewText(R.id.text, "Hello Widget, " + updateCount++);
		appWidgetManager.updateAppWidget(priceWidget, remoteViews);

		final Intent intent = new Intent(context, UpdatePricesService.class);
		final PendingIntent pending = PendingIntent.getService(context, 0, intent, 0);
		final AlarmManager alarm = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
		alarm.cancel(pending);
		long interval = 1000 * 60;
		alarm.setRepeating(AlarmManager.ELAPSED_REALTIME, SystemClock.elapsedRealtime(), interval, pending);
	}
}
