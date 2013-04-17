package com.comp1008.observatory;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Event1 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_event1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.event1, menu);
		return true;
	}

}
