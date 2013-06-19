package com.example.game1exp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.util.Log;
import android.widget.TextView;

public class LifeCycleTest extends Activity {
	StringBuilder builder = new StringBuilder();
	TextView textView;
	
	private void log(String text){
		Log.d("LifeCycleTest",text);
		builder.append(text);
		builder.append('\n');
		textView.setText(builder.toString());
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		textView = new TextView(this);
		textView.setText(builder.toString());
		setContentView(textView);
		log("created");
	}
	
	protected void onResume(){
		super.onResume();
		log("resumed");
	}
	
	protected void onPause(){
		super.onPause();
		log("paused");
		
		if(isFinishing()){
			log("Finishing");
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.life_cycle_test, menu);
		return true;
	}

}
