package MovieBooking.Service;

import org.springframework.beans.factory.annotation.Autowired;

import MovieBooking.Convertor.MovieConvertor;
import MovieBooking.Exception.MovieAlreadyExists;
import MovieBooking.Models.Movie;
import MovieBooking.Repository.MovieRepository;
import MovieBooking.Request.MovieRequest;

public class MovieService {
	@Autowired
	private MovieRepository movieRepo;
	
	public String addMovie(MovieRequest movieRequest) {
		Movie movieByName = movieRepo.findByMovieName(movieRequest.getMovieName());
		if (movieByName!= null && movieByName.getLanguage().equals(movieRequest.getLanguage())) {
			throw new MovieAlreadyExists();
		}
		Movie movie = MovieConvertor.movieConvertor(movieRequest);
		movieRepo.save(movie);
		return "Them phim thanh cong";
	}
}
