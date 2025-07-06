package flightbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import flightbooking.binding.BookingRequest;
import flightbooking.entity.Booking;
import flightbooking.payload.ApiResponse;
import flightbooking.service.BookingService;

//@RestController
//@RequestMapping("/api/bookings")
//public class BookingController {
//
//    @Autowired
//    private BookingRepository bookingRepository;
//
//    @Autowired
//    private FlightRepository flightRepository;
//
//    @PostMapping
//    public ResponseEntity<?> bookFlight(@RequestBody Booking booking) {
//        Flight flight = flightRepository.findById(booking.getFlight().getId()).orElseThrow();
//        if (flight.getAvailableSeats() < booking.getNoOfSeats()) {
//            return ResponseEntity.badRequest().body("Not enough seats available.");
//        }
//
//        flight.setAvailableSeats(flight.getAvailableSeats() - booking.getNoOfSeats());
//        flightRepository.save(flight);
//
//        booking.setBookingDate(LocalDate.now());
//        return ResponseEntity.ok(bookingRepository.save(booking));
//    }
//
//    @GetMapping("/{email}")
//    public ResponseEntity<List<Booking>> getUserBookings(@PathVariable String email) {
//        return ResponseEntity.ok(bookingRepository.findByEmail(email));
//    }
//}

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public ResponseEntity<ApiResponse<Booking>> bookFlight(@RequestBody BookingRequest request) {
        try {
            Booking booking = bookingService.bookFlight(request);
            return ResponseEntity.ok(new ApiResponse<>(true, "Booking successful", booking));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(new ApiResponse<>(false, e.getMessage(), null));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponse<>(false, "Booking failed", null));
        }
    }

    @GetMapping("/{email}")
    public ResponseEntity<ApiResponse<List<Booking>>> getUserBookings(@PathVariable String email) {
        List<Booking> bookings = bookingService.getBookingsByEmail(email);
        return ResponseEntity.ok(new ApiResponse<>(true, "Bookings retrieved", bookings));
    }
}

