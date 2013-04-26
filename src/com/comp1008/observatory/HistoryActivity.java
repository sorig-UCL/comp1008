package com.comp1008.observatory;

import android.os.Build;
import android.os.Bundle;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class HistoryActivity extends Activity {

	@Override
	@TargetApi(11)
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_history);
		
		this.initialiseButtons();
		// Show the Up button in the action bar.
		if (Build.VERSION.SDK_INT >= 11) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_history, menu);
		return true;
	}
	
	private void initialiseButtons() {
		Button foundationButton = (Button) findViewById(R.id.foundationButton);
		foundationButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	Intent intent = new Intent(HistoryActivity.this, FoundationActivity.class);
       	     	startActivity(intent);
            }
        });
		
		Button prewarexpansionButton = (Button) findViewById(R.id.prewarexpansionButton);
		prewarexpansionButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	Intent intent = new Intent(HistoryActivity.this, PrewarexpansionActivity.class);
       	     	startActivity(intent);
            }
        });
		
		Button thewaryearsButton = (Button) findViewById(R.id.thewaryearsButton);
		thewaryearsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	Intent intent = new Intent(HistoryActivity.this, ThewaryearsActivity.class);
       	     	startActivity(intent);
            }
        });
		
		Button postwarexpansionButton = (Button) findViewById(R.id.postwarexpansionButton);
		postwarexpansionButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	Intent intent = new Intent(HistoryActivity.this, PostwarexpansionActivity.class);
       	     	startActivity(intent);
            }
        });
		
		Button ulotodayButton = (Button) findViewById(R.id.ulotodayButton);
		ulotodayButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	Intent intent = new Intent(HistoryActivity.this, UlotodayActivity.class);
       	     	startActivity(intent);
            }
        });
	}
}
