package MovieBooking.Convertor;

import MovieBooking.Models.Movie;
import MovieBooking.Request.MovieRequest;

public class MovieConvertor {
	public static Movie movieConvertor(MovieRequest movieReq) {
		Movie movie = Movie.builder()
				.movieName(movieReq.getMovieName())
				.duration(movieReq.getDuration())
				.genre(movieReq.getGenre())
				.language(movieReq.getLanguage())
				.releaseDate(movieReq.getReleaseDate())
				.rating(movieReq.getRating())
				.build();
		return movie;
				
	}
}
