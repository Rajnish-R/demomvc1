package flightbooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import flightbooking.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long>{

	public List<Booking> getByEmail(String email);

	public List<Booking> findByEmail(String email);
}
