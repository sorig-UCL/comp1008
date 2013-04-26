package com.comp1008.observatory;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.loopj.android.http.*;

public class WeatherAPIClient {
	private static AsyncHttpClient client = new AsyncHttpClient();
	private static final String APIUrl = "http://www.7timer.com/bin/astro.php";
	private JSONObject JSONData;
	private ArrayList<WeatherDataEntry> data;
	private WeatherAPIClientDelegate delegate = null;
	
	public WeatherAPIClient()
	{
		// Should load in previously stored data
		this.JSONData = null;
		this.data = new ArrayList<WeatherDataEntry>();
	}
	
	public void updateData() 
	{
		// Parameters for the weather service		
		RequestParams params = new RequestParams();
		params.put("lon", "-0.242");
		params.put("lat", "51.613");
		params.put("unit", "metric");
		params.put("output", "json");
		params.put("tzshift", "0");
		
		// Asynchronous client request
		// Library used here: android-async-http
		client.get(APIUrl, params, new AsyncHttpResponseHandler() {			
		    @Override
		    public void onSuccess(String response) {
		    	try {
					JSONData = new JSONObject(response);
					convertJSONToDataModel();
					notifyDelegateAboutNewData();
				} catch (JSONException e) {
					System.out.println("Couldn't parse response!");
					e.printStackTrace();
				}
		    }
		});
	}
	
	public void setDelegate(WeatherAPIClientDelegate delegate)
	{
		this.delegate = delegate;
	}
	
	public WeatherAPIClientDelegate getDelegate()
	{
		return this.delegate;
	}
	
	private void notifyDelegateAboutNewData()
	{
		if (delegate != null) {
    		delegate.clientDidReceiveNewData(this);
    	}
	}
	
	private void convertJSONToDataModel()
	{		
		try {
			// JSON list of data points
			JSONArray dataseries = this.JSONData.getJSONArray("dataseries");
			ArrayList<WeatherDataEntry> tempArray = new ArrayList<WeatherDataEntry>();
			
			// String that tells the point in time which each entry's timepoint is relative to
			String initString = this.JSONData.getString("init");
			Calendar startDate = parseDateTimeString(initString);
			
			for (int i = 0; i < dataseries.length(); i++) 
			{
				// Convert the JSON Object to WeatherDataEntry objects
				JSONObject JSONEntry = dataseries.getJSONObject(i);
				WeatherDataEntry entry = new WeatherDataEntry();
				
				Calendar currentCalendar = (Calendar) startDate.clone();
				currentCalendar.add(Calendar.HOUR, JSONEntry.getInt("timepoint"));
				
				entry.setTimepoint(currentCalendar);
				entry.setCloudcover(JSONEntry.getInt("cloudcover"));
				entry.setSeeing(JSONEntry.getInt("seeing"));
				entry.setTransparency(JSONEntry.getInt("transparency"));
				entry.setLiftedIndex(JSONEntry.getInt("lifted_index"));
				entry.setRelativeHumidity(JSONEntry.getInt("rh2m"));
				entry.setWindSpeed(JSONEntry.getJSONObject("wind10m").getInt("speed"));
				entry.setWindDirection(JSONEntry.getJSONObject("wind10m").getString("direction"));
				entry.setTemperature(JSONEntry.getInt("temp2m"));
				entry.setPrecipitationType(JSONEntry.getString("prec_type"));
				
				tempArray.add(entry);
			}
			
			this.data = tempArray;
		} catch (JSONException e) {
			System.out.println("Failed converting json to data model representation");
		}
	}
	
	// Takes a string of the format 2013042508 and converts it to the correct date representation
	private Calendar parseDateTimeString(String dateTimeString)
	{
		int year = Integer.parseInt(dateTimeString.substring(0, 4));
		int month = Integer.parseInt(dateTimeString.substring(4, 6));
		int day = Integer.parseInt(dateTimeString.substring(6, 8));
		int hour = Integer.parseInt(dateTimeString.substring(8, 10));
		
		return new GregorianCalendar(year, month, day, hour, 0);
	}

	public ArrayList<WeatherDataEntry> getData() {
		return data;
	}
}
