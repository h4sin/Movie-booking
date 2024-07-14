package MovieBooking.Request;

import java.sql.Date;

import MovieBooking.Enum.Genre;
import MovieBooking.Enum.Language;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class MovieRequest {
	private String movieName;
	private int duration;
	private Double rating;
	private Date releaseDate;
	private Genre genre;
	private Language language;
}
