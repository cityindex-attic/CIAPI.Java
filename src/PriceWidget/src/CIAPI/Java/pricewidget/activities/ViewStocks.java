package CIAPI.Java.pricewidget.activities;

import static CIAPI.Java.android.Constants.TAG;
import CIAPI.Java.pricewidget.model.stock.IStock;
import CIAPI.Java.pricewidget.model.stock.IStockListTracker;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class ViewStocks extends Activity {

	/**
	 * Called when the activity is first created.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i(TAG, "Creating main activity");
		//setContentView(R.layout.stock_view);
		final Button addStockButton = null; //(Button) findViewById(R.id.add_stock_button);
		addStockButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent newInt = new Intent(ViewStocks.this, SearchStocks.class);
				ViewStocks.this.startActivity(newInt);
			}
		});
		LinearLayout stockList = null; //(LinearLayout) findViewById(R.id.stock_list);
		IStockListTracker stocks = null;
		for (IStock s : stocks) {
			LinearLayout newStock = new LinearLayout(this);
			newStock.setOrientation(LinearLayout.HORIZONTAL);
			newStock.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, 60));
			TextView stockName = new TextView(this);
			stockName.setText(s.getName());
			stockName.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					showDialog(000012);
				}
			});
			newStock.addView(stockName);
			stockList.addView(newStock);
		}
	}
	
	@Override
	protected Dialog onCreateDialog(int id) {
		Dialog d = new Dialog(this);
		d.setTitle("Edit Stock");
		return d;
	}
}
