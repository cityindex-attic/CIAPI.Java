package CIAPI.Java.pricewidget.activities;

import static CIAPI.Java.android.Constants.TAG;
import CIAPI.Java.pricewidget.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ViewStocks extends Activity {

	/**
	 * Called when the activity is first created.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i(TAG, "Creating main activity");
		setContentView(R.layout.stock_view);
		final Button addStockButton = (Button) findViewById(R.id.add_stock_button);
		addStockButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent newInt = new Intent(ViewStocks.this, SearchStocks.class);
				ViewStocks.this.startActivity(newInt);
			}
		});
	}
}
