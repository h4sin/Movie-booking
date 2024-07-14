package MovieBooking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import MovieBooking.Models.Movie;
@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
	Movie findByMovieName(String name);
}
