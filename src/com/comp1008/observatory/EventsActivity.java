package com.comp1008.observatory;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class EventsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_events);
		
		this.initialiseButtons();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_events, menu);
		return true;
	}
	
	private void initialiseButtons() {
		Button aboutButton = (Button) findViewById(R.id.eventButton1);
		aboutButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	Intent intent = new Intent(EventsActivity.this, Event1.class);
       	     	startActivity(intent);
            }
        });
		
		Button researchButton = (Button) findViewById(R.id.eventButton2);
		researchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	Intent intent = new Intent(EventsActivity.this, Event2.class);
       	     	startActivity(intent);
            }
        });
		
		Button gameButton = (Button) findViewById(R.id.eventButton3);
		gameButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	Intent intent = new Intent(EventsActivity.this, Event3.class);
       	     	startActivity(intent);
            }
        });
	}
}