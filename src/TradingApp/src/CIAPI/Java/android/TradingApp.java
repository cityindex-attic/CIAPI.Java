package CIAPI.Java.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class TradingApp extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Button buttonTCounter = (Button)findViewById(R.id.buttonToCounter);
		buttonTCounter.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				try{
				startActivity(new Intent(TradingApp.this, ButtonCounter.class));
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
	}
}
