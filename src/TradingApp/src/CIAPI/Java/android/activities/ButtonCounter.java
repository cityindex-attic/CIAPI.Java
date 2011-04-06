package CIAPI.Java.android.activities;

import CIAPI.Java.android.R;
import CIAPI.Java.android.R.id;
import CIAPI.Java.android.R.layout;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
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
		SeekBar seek = (SeekBar) findViewById(R.id.seekBar1);
		TextView seekCOunt = (TextView)findViewById(R.id.seekAnmt);
		seekCOunt.setText(seek.getProgress()+"");
		seek.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
			}
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				TextView seekCOunt = (TextView)findViewById(R.id.seekAnmt);
				seekCOunt.setText(progress+"");
			}
		});
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		getPreferences(MODE_PRIVATE).edit().putInt("tradingApp.counter", count).apply();
	}
}
