package com.comp1008.observatory;

import java.util.Calendar;

public class WeatherDataEntry {
	private Calendar timepoint;
	private int cloudcover;
	private int seeing;
	private int transparency;
	private int liftedIndex;
	private int relativeHumidity;
	private int windSpeed;
	private String windDirection;
	private int temperature;
	private String precipitationType;
	
	// Human readable string representation
	@Override
	public String toString()
	{
		String result = String.format("%d/%d %02d:00\n", timepoint.get(Calendar.DATE), timepoint.get(Calendar.MONTH), timepoint.get(Calendar.HOUR_OF_DAY));
		result = result.concat(String.format("%d ¡C\n", temperature));
		result = result.concat(String.format("Cloudcover: %s\n", this.cloudCoverString()));
		result = result.concat(String.format("Astro seeing: %s\n", this.seeingString()));
		result = result.concat(String.format("Transparency: %s mag/air mass\n", this.transparencyString()));
		result = result.concat(String.format("Lifted index: %s\n", this.liftedIndexString()));
		result = result.concat(String.format("Humidity: %s\n", this.relativeHumidityString()));
		result = result.concat(String.format("Wind: %s", this.windString()));
		if (!precipitationType.equals("none")) {
			result = result.concat(String.format("\n%s", precipitationType));
		}
		result = result.concat("\n");
		return result;
	}
	
	private String transparencyString()
	{
		switch(transparency) {
		case 1:
			return "<0.3";
		case 2:
			return "0.3-0.4";
		case 3:
			return "0.4-0.5";
		case 4:
			return "0.5-0.6";
		case 5:
			return "0.6-0.7";
		case 6:
			return "0.7-0.85";
		case 7:
			return "0.85-1";
		case 8:
			return ">1";
		default:
			return "";
		}
	}
	
	private String cloudCoverString()
	{
		switch(cloudcover) {
		case 1:
			return "0%-6%";
		case 2:
			return "6%-19%";
		case 3:
			return "19%-31%";
		case 4:
			return "31%-44%";
		case 5:
			return "44%-56%";
		case 6:
			return "56%-69%";
		case 7:
			return "69%-81%";
		case 8:
			return "81%-94%";
		case 9:
			return "94%-100%";
		default:
			return "";
		}
	}
	
	private String seeingString()
	{
		switch(seeing) {
		case 1:
			return "<0.5\"";
		case 2:
			return "0.5\"-0.75\"";
		case 3:
			return "0.75\"-1\"";
		case 4:
			return "1\"-1.25\"";
		case 5:
			return "1.25\"-1.5\"";
		case 6:
			return "1.5\"-2\"";
		case 7:
			return "2\"-2.5\"";
		case 8:
			return ">2.5\"";
		default:
			return "";
		}
	}
	
	private String liftedIndexString()
	{
		switch(liftedIndex) {
		case -10:
			return "below -7";
		case -6:
			return "-7 to -5";
		case -4:
			return "-5 to -3";
		case -1:
			return "-3 to 0";
		case 2:
			return "0 to 4";
		case 6:
			return "4 to 8";
		case 10:
			return "8 to 11";
		case 15:
			return "over 11";
		default:
			return "";
		}
	}
	
	private String relativeHumidityString()
	{
		int startPercentage = (relativeHumidity+4)*5;
		
		if (startPercentage == 100)
			return "100%";
		
		return String.format("%d%%-%d%%", startPercentage, startPercentage+5);
	}
	
	private String windString()
	{
		
		switch(windSpeed) {
		case 1:
			return String.format("(%s) Below 0.3m/s (calm)", windDirection);
		case 2:
			return String.format("(%s) 0.3-3.4m/s (light)", windDirection);
		case 3:
			return String.format("(%s) 3.4-8.0m/s (moderate)", windDirection);
		case 4:
			return String.format("(%s) 8.0-10.8m/s (fresh)", windDirection);
		case 5:
			return String.format("(%s) 10.8-17.2m/s (strong)", windDirection);
		case 6:
			return String.format("(%s) 17.2-24.5m/s (gale)", windDirection);
		case 7:
			return String.format("(%s) 24.5-32.6m/s (storm)", windDirection);
		case 8:
			return String.format("(%s) Over 32.6m/s (hurricane)", windDirection);
		default:
			return "";
		}
	}
	
	public Calendar getTimepoint() {
		return timepoint;
	}
	public void setTimepoint(Calendar object) {
		this.timepoint = object;
	}
	public int getCloudcover() {
		return cloudcover;
	}
	public void setCloudcover(int cloudcover) {
		this.cloudcover = cloudcover;
	}
	public int getSeeing() {
		return seeing;
	}
	public void setSeeing(int seeing) {
		this.seeing = seeing;
	}
	public int getTransparency() {
		return transparency;
	}
	public void setTransparency(int transparency) {
		this.transparency = transparency;
	}
	public int getLiftedIndex() {
		return liftedIndex;
	}
	public void setLiftedIndex(int liftedIndex) {
		this.liftedIndex = liftedIndex;
	}
	public int getRelativeHumidity() {
		return relativeHumidity;
	}
	public void setRelativeHumidity(int relativeHumidity) {
		this.relativeHumidity = relativeHumidity;
	}
	public int getWindSpeed() {
		return windSpeed;
	}
	public void setWindSpeed(int windSpeed) {
		this.windSpeed = windSpeed;
	}
	public String getWindDirection() {
		return windDirection;
	}
	public void setWindDirection(String windDirection) {
		this.windDirection = windDirection;
	}
	public int getTemperature() {
		return temperature;
	}
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
	public String getPrecipitationType() {
		return precipitationType;
	}
	public void setPrecipitationType(String precipitationType) {
		this.precipitationType = precipitationType;
	}
}
