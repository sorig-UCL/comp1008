package com.comp1008.observatory;

import android.os.Bundle;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.support.v4.app.NavUtils;
import android.os.Build;

public class TelescopesActivity extends Activity {

	@Override
	@TargetApi(11)
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_telescopes);
		this.initialiseButtons();
		// Show the Up button in the action bar.
		
		if (Build.VERSION.SDK_INT >= 11) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_telescopes, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	private void initialiseButtons() {
		Button telescope1Button = (Button) findViewById(R.id.telescope1Button);
		telescope1Button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	Intent intent = new Intent(TelescopesActivity.this, Telescope1Activity.class);
       	     	startActivity(intent);
            }
        });
		
		Button telescope2Button = (Button) findViewById(R.id.telescope2Button);
		telescope2Button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	Intent intent = new Intent(TelescopesActivity.this, Telescope2Activity.class);
       	     	startActivity(intent);
            }
        });
		
		Button telescope34Button = (Button) findViewById(R.id.telescope34Button);
		telescope34Button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	Intent intent = new Intent(TelescopesActivity.this, Telescope34Activity.class);
       	     	startActivity(intent);
            }
        });

		Button telescope5Button = (Button) findViewById(R.id.telescope5Button);
		telescope5Button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	Intent intent = new Intent(TelescopesActivity.this, Telescope5Activity.class);
       	     	startActivity(intent);
            }
        });
	}
}

