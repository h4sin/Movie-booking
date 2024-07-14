package MovieBooking.Repository;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import MovieBooking.Models.Show;
@Repository
public interface ShowRepository extends JpaRepository<Show, Integer> {
	@Query(value = "select time from show where date = :date and movieid = :movieId and theaterid = :theaterId" , nativeQuery = true)
    public List<Time> getShowTimingsOnDate(@Param("date")Date date, @Param("theaterId")Integer theaterId, @Param("movieId")Integer movieId);

    @Query(value = "select movieid from show group by movieid order by count(*) desc limit 1" , nativeQuery = true)
    public Integer getMostShowsMovie();

    @Query(value = "select * from show where movieid = :movieId" , nativeQuery = true)
    public List<Show> getAllShowsOfMovie(@Param("movieId")Integer movieId);
}
