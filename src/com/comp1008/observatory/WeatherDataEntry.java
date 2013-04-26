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
