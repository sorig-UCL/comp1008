package com.comp1008.observatory;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		
		this.initialiseButtons();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_menu, menu);
		return true;
	}
	
	private void initialiseButtons() {
		Button aboutButton = (Button) findViewById(R.id.aboutButton);
		aboutButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	Intent intent = new Intent(MenuActivity.this, AboutActivity.class);
       	     	startActivity(intent);
            }
        });
		
		Button researchButton = (Button) findViewById(R.id.researchButton);
		researchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	Intent intent = new Intent(MenuActivity.this, ResearchActivity.class);
       	     	startActivity(intent);
            }
        });
		
		Button historyButton = (Button) findViewById(R.id.historyButton);
		historyButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	Intent intent = new Intent(MenuActivity.this, HistoryActivity.class);
       	     	startActivity(intent);
            }
        });
		
		Button eventsButton = (Button) findViewById(R.id.eventsButton);
		eventsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	Intent intent = new Intent(MenuActivity.this, EventsActivity.class);
       	     	startActivity(intent);
            }
        });
		
		Button weatherButton = (Button) findViewById(R.id.weatherButton);
		weatherButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	Intent intent = new Intent(MenuActivity.this, WeatherActivity.class);
       	     	startActivity(intent);
            }
        });
		
		Button gameButton = (Button) findViewById(R.id.gameButton);
		gameButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	Intent intent = new Intent(MenuActivity.this, GameActivity.class);
       	     	startActivity(intent);
            }
        });
	}
}