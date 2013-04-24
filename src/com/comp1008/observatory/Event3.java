package com.comp1008.observatory;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Event3 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_event3);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.event3, menu);
		return true;
	}

}
