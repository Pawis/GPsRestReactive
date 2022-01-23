package com.example.GPSRestReactive.Repo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.example.GPSRestReactive.model.Location;


@Repository 
public interface ReactiveLocalizationRepo extends ReactiveCrudRepository<Location, Integer>{

}

