package com.example.GPSRestReactive.Repo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.example.GPSRestReactive.model.Location;

public interface ReactiveLocalizationRepo extends ReactiveCrudRepository<Location, Integer>{

}
