package com.comp1008.observatory;

import java.util.ArrayList;
import java.util.Calendar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Build;
import android.os.Bundle;
import android.annotation.TargetApi;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.support.v4.app.NavUtils;

public class WeatherActivity extends Activity implements WeatherAPIClientDelegate {
	
	private WeatherAPIClient client;
	private ArrayAdapter<WeatherDataEntry> adapter;
	
	public WeatherActivity() 
	{
		this.client = new WeatherAPIClient();
		this.client.setDelegate(this);		
	}
	
	@Override
	@TargetApi(11)
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// Show the Up button in the action bar.
		if (Build.VERSION.SDK_INT >= 11) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
		
		setTitle("Weather@ULO (-0.242, 51.613)");
		
		// Initialise listview and its adapter
		ListView listView = new ListView(this);
		
		this.adapter = new ArrayAdapter<WeatherDataEntry>(this, android.R.layout.simple_list_item_1, this.client.getData());
		listView.setAdapter(this.adapter);
		
		setContentView(listView);
		
		// Make API client fetch data from the internet
		this.client.updateData();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_weather, menu);
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

	@Override
	public void clientDidReceiveNewData(WeatherAPIClient client) 
	{
		// Clear the adapter array and add all the data entries
		this.adapter.clear();
		
		for (WeatherDataEntry entry : client.getData())
		{			
			this.adapter.add(entry);
		}
		
		this.adapter.notifyDataSetChanged();
	}

}
