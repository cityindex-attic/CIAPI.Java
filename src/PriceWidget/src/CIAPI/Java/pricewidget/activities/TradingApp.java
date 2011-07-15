package CIAPI.Java.pricewidget.activities;

import static CIAPI.Java.android.Constants.TAG;
import CIAPI.Java.pricewidget.R;
import CIAPI.Java.pricewidget.model.auth.LogOnStatus;
import JsonClient.Java.ApiException;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class TradingApp extends Activity {

	private static Context ctxt;

	public static Context ctxt() {
		return ctxt;
	}

	/**
	 * Called when the activity is first created.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i(TAG, "Creating main activity");
		setContentView(R.layout.login);
		Button changeStocksButton = (Button) findViewById(R.id.change_stock);
		changeStocksButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent startViewStocks = new Intent(TradingApp.this, ViewStocks.class);
				TradingApp.this.startActivity(startViewStocks);
			}
		});
		Button buttonTCounter = (Button) findViewById(R.id.saveButton);
		buttonTCounter.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				EditText userBox = (EditText) findViewById(R.id.usernameField);
				EditText passwordBox = (EditText) findViewById(R.id.passwordField);
				String username = userBox.getText().toString();
				String password = passwordBox.getText().toString();
				try {
					LogOnStatus.logOn(username, password);
					Log.i(TAG, "Sucessfully logged on to the API");
					TradingApp.this.finish();
				} catch (ApiException e) {
					Log.e(TAG, "Could not log on...username: " + username + ", password: " + password, e);
				}
			}
		});
		ctxt = getApplicationContext();
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.i(TAG, "Stopped!");
	}
}
