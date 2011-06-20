package CIAPI.Java.pricewidget.activities;

import CIAPI.Java.pricewidget.CIAPIPriceHelper;
import CIAPI.Java.pricewidget.R;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import static CIAPI.Java.android.Constants.*;

public class TradingApp extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i(TAG, "Creating main activity");
		setContentView(R.layout.login);
		Button buttonTCounter = (Button) findViewById(R.id.loginButton);
		buttonTCounter.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				EditText userBox = (EditText) findViewById(R.id.usernameField);
				EditText passwordBox = (EditText) findViewById(R.id.passwordField);
				String username = userBox.getText().toString();
				String password = passwordBox.getText().toString();
				CIAPIPriceHelper.logOn(username, password, TradingApp.this);
			}
		});
	}
}
