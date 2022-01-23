package com.example.GPSRestReactive.model;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Location {

	@Id
	private int id;

	private String deviceid;
	private int latitude;
	private int longitude;

	public Location() {

	}

	@JsonCreator
	public Location(@JsonProperty("deviceId") String deviceid, @JsonProperty("latitude") int latitude,
			@JsonProperty("longitude") int longitude) {
		this.deviceid = deviceid;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getDeviceId() {
		return deviceid;
	}

	public void setDeviceId(String deviceId) {
		this.deviceid = deviceId;
	}

	public int getLatitude() {
		return latitude;
	}

	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}

	public int getLongitude() {
		return longitude;
	}

	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}

}
