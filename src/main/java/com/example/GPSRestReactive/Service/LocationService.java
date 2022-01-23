package com.example.GPSRestReactive.Service;



import com.example.GPSRestReactive.model.Location;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface LocationService {
	
	public Mono<Location> saveLocationToDatabase(Location location);
	
	public Flux<Location> getLocations();
	
	public Mono<Long> getCount();
}
