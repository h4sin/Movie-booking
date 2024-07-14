package MovieBooking.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import MovieBooking.Convertor.TicketConvertor;
import MovieBooking.Exception.SeatsNotAvailable;
import MovieBooking.Exception.ShowDoesNotExists;
import MovieBooking.Exception.UserDoesNotExists;
import MovieBooking.Models.Show;
import MovieBooking.Models.ShowSeats;
import MovieBooking.Models.Ticket;
import MovieBooking.Models.User;
import MovieBooking.Reponse.TicketResponse;
import MovieBooking.Repository.ShowRepository;
import MovieBooking.Repository.TicketRepository;
import MovieBooking.Repository.UserRepository;
import MovieBooking.Request.TicketRequest;

@Service
public class TicketService {
	@Autowired
	private TicketRepository ticketRepo;

	@Autowired
	private ShowRepository showRepo;

	@Autowired
	private UserRepository userRepo;

	public TicketResponse ticketBooking(TicketRequest ticketReq) {
		Optional<Show> showOpt = showRepo.findById(ticketReq.getShowId());
		if (showOpt.isEmpty()) {
			throw new ShowDoesNotExists();
		}
		Optional<User> userOpt = userRepo.findById(ticketReq.getUserId());
		if (userOpt.isEmpty()) {
			throw new UserDoesNotExists();
		}
		User user = userOpt.get();
		Show show = showOpt.get();

		Boolean isSeatAvailable = isSeatAvailable(show.getShowSeat(), ticketReq.getRequestSeats());
		if (!isSeatAvailable) {
			throw new SeatsNotAvailable();
		}

		Integer getPriceAndAssignSeats = getPriceAndAssignSeats(show.getShowSeat(), ticketReq.getRequestSeats());

		String seats = listToString(ticketReq.getRequestSeats());

		Ticket ticket = new Ticket();
		ticket.setTotalTicketsPrice(getPriceAndAssignSeats);
		ticket.setBookedSeats(seats);
		ticket.setUser(user);
		ticket.setShow(show);

		ticket = ticketRepo.save(ticket);

		user.getTicketList().add(ticket);
		show.getTicket().add(ticket);
		userRepo.save(user);
		showRepo.save(show);

		return TicketConvertor.returnTicket(show, ticket);
	}

	private Boolean isSeatAvailable(List<ShowSeats> showSeatList, List<String> requestSeats) {
		for (ShowSeats showSeat : showSeatList) {
			String seatNumber = showSeat.getSeatNumber();

			if (requestSeats.contains(seatNumber) && !showSeat.getIsAvailable()) {
				return false;
			}
		}

		return true;
	}

	private Integer getPriceAndAssignSeats(List<ShowSeats> showSeatList, List<String> requestSeats) {
		Integer totalAmount = 0;

		for (ShowSeats showSeat : showSeatList) {
			if (requestSeats.contains(showSeat.getSeatNumber())) {
				totalAmount += showSeat.getPrice();
				showSeat.setIsAvailable(Boolean.FALSE);
			}
		}

		return totalAmount;
	}

	private String listToString(List<String> requestSeats) {
		StringBuilder sb = new StringBuilder();

		for (String s : requestSeats) {
			sb.append(s).append(",");
		}
		if (sb.length() > 0) {
			sb.setLength(sb.length() - 1);
		}

		return sb.toString();
	}
}
