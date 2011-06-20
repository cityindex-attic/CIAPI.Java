package CIAPI.Java.android.activities;

import CIAPI.Java.android.Api;
import CIAPI.Java.android.R;
import CIAPI.Java.android.activities.ControlPanel;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class TradingApp extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// fixClassLoaderIssue();
		setContentView(R.layout.main);
		Button buttonTCounter = (Button) findViewById(R.id.loginButton);
		buttonTCounter.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
					EditText userBox = (EditText) findViewById(R.id.usernameField);
					EditText passwordBox = (EditText) findViewById(R.id.passwordField);
					SyncApi api = Api.getInstance();
					String username = userBox.getText().toString();
					String password = passwordBox.getText().toString();
					api.logIn(username, password, true);
					startActivity(new Intent(TradingApp.this, ControlPanel.class));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private static void fixClassLoaderIssue() {
		ClassLoader myClassLoader = TradingApp.class.getClassLoader();
		Thread.currentThread().setContextClassLoader(myClassLoader);
	}
}
