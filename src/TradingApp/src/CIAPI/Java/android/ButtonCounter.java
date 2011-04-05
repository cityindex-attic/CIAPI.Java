package CIAPI.Java.android;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ButtonCounter extends Activity {

	private int count;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		SharedPreferences prefs = getPreferences(MODE_PRIVATE);
		count = prefs.getInt("tradingApp.counter", 0);
		setContentView(R.layout.buttoncounter);
		Button b = (Button) findViewById(R.id.button1);
		TextView counter = (TextView) findViewById(R.id.countValue);
		counter.setText("" + count);
		b.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				count++;
				TextView counter = (TextView) findViewById(R.id.countValue);
				counter.setText("" + count);
			}
		});
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		getPreferences(MODE_PRIVATE).edit().putInt("tradingApp.counter", count).apply();
	}
}
