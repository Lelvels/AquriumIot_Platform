package com.luv2code.mvc.Model;

public class SensorData {
	private Float temperature;
	private Float humidity;
	
	public SensorData() {
		super();
	}

	public SensorData(Float temperature, Float humidity) {
		this.temperature = temperature;
		this.humidity = humidity;
	}
	
	public Float getTemperature() {
		return temperature;
	}
	public void setTemperature(Float temperature) {
		this.temperature = temperature;
	}
	public Float getHumidity() {
		return humidity;
	}
	public void setHumidity(Float humidity) {
		this.humidity = humidity;
	}
}