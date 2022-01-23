package com.example.GPSRestReactive.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.GPSRestReactive.Service.LocationService;
import com.example.GPSRestReactive.model.Location;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class LocationController {

	private LocationService locationService;
	
	public LocationController(LocationService locationService) {
		this.locationService = locationService;
	}
	
	
	@PostMapping("/post")
	public Mono<Location >createLocation(@RequestBody Location location) {
		
		return locationService.saveLocationToDatabase(location);
	}
	
	@GetMapping("/get")
	public Flux<Location> getLocations() {
		return locationService.getLocations();
	}
	

	@GetMapping("/getCount")
	public Mono<Long> getCount() {
		return locationService.getCount();
	}
}
