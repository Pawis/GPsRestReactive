package com.example.GPSRestReactive;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.example.GPSRestReactive.Service.LocationClient;
import com.example.GPSRestReactive.controller.LocationController;
import com.example.GPSRestReactive.model.Location;

import reactor.core.publisher.Mono;

@WebFluxTest(LocationController.class)
public class ControllerTest {

	@MockBean
	private LocationClient locationClient;
	
    @Autowired
    private WebTestClient webClient;
	
	
	@Test
	public void testcreateLocation() {
		
		Location location = new Location("1",123,123);
		
		when(locationClient.saveLocationToDatabase(any(Location.class))).thenReturn(Mono.just(location));
        Mono<Location> loc = locationClient.saveLocationToDatabase(location);
        Location blockedLoc = loc.block();
		assertTrue(blockedLoc.equals(location));
	}
	
	@Test
	void testcreateLocationStatus() {
		
		Location location = new Location("1",123,123);
		
		webClient
        .post().uri("/post")
        .bodyValue(location)
        .exchange()
        .expectStatus()
        .isEqualTo(HttpStatus.OK)
        .expectBody();
		
	}
}
