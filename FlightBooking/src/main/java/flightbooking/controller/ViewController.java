package flightbooking.controller;

import flightbooking.binding.BookingRequest;
import flightbooking.entity.Booking;
import flightbooking.entity.Flight;
import flightbooking.service.BookingService;
import flightbooking.service.FlightService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
public class ViewController {

    @Autowired
    private FlightService flightService;

    @Autowired
    private BookingService bookingService;

    @GetMapping("/search-flights")
    public String showFlights(@RequestParam(required = false) String source,
                              @RequestParam(required = false) String destination,
                              @RequestParam(required = false) LocalDate departureDate,
                              Model model) {
        if (source != null && destination != null && departureDate != null) {
            List<Flight> flights = flightService.searchFlights(source, destination, departureDate);
            model.addAttribute("flights", flights);
        }
        return "flight-search";
    }

    @GetMapping("/book-flight")
    public String showBookingForm() {
        return "booking-form";
    }

    @PostMapping("/book")
    public String processBooking(@ModelAttribute BookingRequest request, Model model) {
        try {
            Booking booking = bookingService.bookFlight(request);
            model.addAttribute("message", "Booking successful! ID: " + booking.getId());
        } catch (Exception e) {
            model.addAttribute("message", "Booking failed: " + e.getMessage());
        }
        return "booking-form";
    }

    @GetMapping("/my-bookings")
    public String getBookings(@RequestParam(required = false) String email, Model model) {
        if (email != null) {
            List<Booking> bookings = bookingService.getBookingsByEmail(email);
            model.addAttribute("bookings", bookings);
        }
        return "my-bookings";
    }
}
