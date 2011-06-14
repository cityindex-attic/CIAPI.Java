package CIAPI.Java.pricewidget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.widget.RemoteViews;

public class PriceWidget extends AppWidgetProvider {
	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
		RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.main);
		ComponentName priceWidget = new ComponentName(context, PriceWidget.class);
		remoteViews.setTextViewText(R.id.text, "Hello Widget, Again");
		appWidgetManager.updateAppWidget(priceWidget, remoteViews);
	}
}
