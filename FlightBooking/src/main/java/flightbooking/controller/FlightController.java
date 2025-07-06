package flightbooking.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import flightbooking.entity.Flight;
import flightbooking.service.FlightService;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

	@Autowired
	private FlightService flightService;

	@PostMapping
	public ResponseEntity<Flight> addFlight(@RequestBody Flight flight) {
	    return ResponseEntity.ok(flightService.addFlight(flight));
	}

	@GetMapping("/search")
	public ResponseEntity<List<Flight>> searchFlights(
	        @RequestParam String source,
	        @RequestParam String destination,
	        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
	    return ResponseEntity.ok(flightService.searchFlights(source, destination, date));
	}  
}