package CIAPI.Java.pricewidget;

import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.IBinder;
import android.widget.RemoteViews;

public class UpdatePricesService extends Service {
	private int updateCount = 0;

	@Override
	public void onStart(Intent intent, int startId) {
		RemoteViews remoteViews = new RemoteViews(this.getPackageName(), R.layout.main);
		ComponentName priceWidget = new ComponentName(this, PriceWidget.class);
		remoteViews.setTextViewText(R.id.text, "Hello Widget, " + updateCount++);
		AppWidgetManager manager = AppWidgetManager.getInstance(this);
		manager.updateAppWidget(priceWidget, remoteViews);
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

}
