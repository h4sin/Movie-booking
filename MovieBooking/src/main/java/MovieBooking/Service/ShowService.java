package MovieBooking.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import MovieBooking.Convertor.ShowConvertor;
import MovieBooking.Enum.SeatType;
import MovieBooking.Exception.MovieDoesNotExists;
import MovieBooking.Exception.ShowDoesNotExists;
import MovieBooking.Exception.TheaterDoesNotExists;
import MovieBooking.Models.Movie;
import MovieBooking.Models.Show;
import MovieBooking.Models.ShowSeats;
import MovieBooking.Models.Theater;
import MovieBooking.Models.TheaterSeats;
import MovieBooking.Repository.MovieRepository;
import MovieBooking.Repository.ShowRepository;
import MovieBooking.Repository.TheaterRepository;
import MovieBooking.Request.ShowRequest;
import MovieBooking.Request.ShowSeatRequest;

@Service
public class ShowService {
	@Autowired
	private MovieRepository movieRepo;

	@Autowired
	private TheaterRepository theaterRepo;

	@Autowired
	private ShowRepository showRepo;

	public String addShow(ShowRequest showReq) {
		Show show = ShowConvertor.showDtoToShow(showReq);
		Optional<Movie> movieOpt = movieRepo.findById(showReq.getMovieId());
		if (movieOpt.isEmpty()) {
			throw new MovieDoesNotExists();
		}
		Optional<Theater> theaterOpt = theaterRepo.findById(showReq.getTheaterId());
		if (theaterOpt.isEmpty()) {
			throw new TheaterDoesNotExists();
		}

		show.setMovie(movieOpt.get());
		show.setTheater(theaterOpt.get());
		show = showRepo.save(show);
		movieOpt.get().getShow().add(show);
		theaterOpt.get().getShowList().add(show);
		movieRepo.save(movieOpt.get());
		theaterRepo.save(theaterOpt.get());

		return "them thanh cong";
	}

	public String associateShowSeats(ShowSeatRequest showSeatRequest) throws ShowDoesNotExists {
		Optional<Show> showOpt = showRepo.findById(showSeatRequest.getShowId());

		if (showOpt.isEmpty()) {
			throw new ShowDoesNotExists();
		}

		Show show = showOpt.get();
		Theater theater = show.getTheater();

		List<TheaterSeats> theaterSeatList = theater.getTheaterSeatList();

		List<ShowSeats> showSeatList = show.getShowSeat();

		for (TheaterSeats theaterSeat : theaterSeatList) {
			ShowSeats showSeat = new ShowSeats();
			showSeat.setSeatNumber(theaterSeat.getSeatNumber());
			showSeat.setSeatType(theaterSeat.getSeatType());

			if (showSeat.getSeatType().equals(SeatType.CLASSIC)) {
				showSeat.setPrice((showSeatRequest.getPriceOfClassicSeat()));
			} else {
				showSeat.setPrice(showSeatRequest.getPriceOfPremiumSeat());
			}

			showSeat.setShow(show);
			showSeat.setIsAvailable(Boolean.TRUE);
			showSeat.setIsFoodContains(Boolean.FALSE);

			showSeatList.add(showSeat);
		}
		showRepo.save(show);
		return "Them vao thanh cong";
	}
}
