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
import android.support.v4.app.NavUtils;

public class WeatherActivity extends Activity implements WeatherAPIClientDelegate {
	
	private WeatherAPIClient client;
	
	public WeatherActivity() 
	{
		this.client = new WeatherAPIClient();
		this.client.setDelegate(this);
	}
	
	@Override
	@TargetApi(11)
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_weather);
		
		// Show the Up button in the action bar.
		if (Build.VERSION.SDK_INT >= 11) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
		
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
	public void clientDidReceiveNewData(WeatherAPIClient client) {
		ArrayList<WeatherDataEntry> data = client.getData();
		System.out.println(data);
		
		for (WeatherDataEntry entry : data)
		{
			System.out.print(entry.getTimepoint().get(Calendar.YEAR));
			System.out.print(" ");
			System.out.print(entry.getTimepoint().get(Calendar.MONTH));
			System.out.print(" ");
			System.out.print(entry.getTimepoint().get(Calendar.DATE));
			System.out.print(" ");
			System.out.println(entry.getTimepoint().get(Calendar.HOUR_OF_DAY));
		}
	}

}
