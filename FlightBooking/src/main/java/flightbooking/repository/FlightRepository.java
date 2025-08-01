package flightbooking.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import flightbooking.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long>{
	
	List<Flight> findBySourceAndDestinationAndDepartureDate(String source, String destination, LocalDate date);

}
