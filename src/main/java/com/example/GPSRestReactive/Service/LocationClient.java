package com.example.GPSRestReactive.Service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.GPSRestReactive.Repo.ReactiveLocalizationRepo;
import com.example.GPSRestReactive.model.Location;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class LocationClient implements LocationService{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private ReactiveLocalizationRepo locatiobRepo;
	
	public LocationClient(ReactiveLocalizationRepo locatiobRepo) {
		this.locatiobRepo=locatiobRepo;
	}
	
	public Mono<Location> saveLocationToDatabase(Location location) {
		
		logger.info("Start " + Thread.currentThread().getName());

		Mono<Location> locationMono = locatiobRepo.save(location);
		logger.info("End " + Thread.currentThread().getName());
		return locationMono;
	
	}
	
	public Flux<Location> getLocations() {
		
	return locatiobRepo.findAll();
	}
	
	public Mono<Long> getCount() {
		
		return locatiobRepo.count();
	}
	
}
