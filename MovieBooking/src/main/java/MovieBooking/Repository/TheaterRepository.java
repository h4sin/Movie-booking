package MovieBooking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import MovieBooking.Models.Theater;
@Repository
public interface TheaterRepository extends JpaRepository<Theater, Integer> {
	Theater findByAddress(String address);
}
