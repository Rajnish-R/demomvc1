package flightbooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import flightbooking.entity.Flight;
import flightbooking.repository.FlightRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public Flight addFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public List<Flight> searchFlights(String source, String destination, LocalDate date) {
        return flightRepository.findBySourceAndDestinationAndDepartureDate(source, destination, date);
    }
}
