package flightbooking.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import flightbooking.binding.BookingRequest;
import flightbooking.entity.Booking;
import flightbooking.entity.Flight;
import flightbooking.repository.BookingRepository;
import flightbooking.repository.FlightRepository;
import jakarta.transaction.Transactional;

@Service
public class BookingService {

  @Autowired
  private BookingRepository bookingRepository;

  @Autowired
  private FlightRepository flightRepository;

  @Transactional
  public Booking bookFlight(BookingRequest request) {
      Flight flight = flightRepository.findById(request.getFlightId())
          .orElseThrow(() -> new RuntimeException("Flight not found with ID: " + request.getFlightId()));

      if (flight.getAvailableSeats() < request.getNoOfSeats()) {
          throw new IllegalArgumentException("Not enough seats available");
      }

      flight.setAvailableSeats(flight.getAvailableSeats() - request.getNoOfSeats());
      flightRepository.save(flight);

      Booking booking = new Booking();
      booking.setPassengerName(request.getPassengerName());
      booking.setEmail(request.getEmail());
      booking.setFlight(flight);
      booking.setNoOfSeats(request.getNoOfSeats());
      booking.setAge(request.getAge());
      booking.setGender(request.getGender());
      booking.setBookingDate(LocalDate.now());

      return bookingRepository.save(booking);
  }

  public List<Booking> getBookingsByEmail(String email) {
      return bookingRepository.findByEmail(email);
  }
}