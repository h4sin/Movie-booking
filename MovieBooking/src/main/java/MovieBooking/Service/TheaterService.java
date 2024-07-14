package MovieBooking.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import MovieBooking.Convertor.TheaterConvertor;
import MovieBooking.Enum.SeatType;
import MovieBooking.Exception.TheaterDoesNotExists;
import MovieBooking.Exception.TheaterIsExists;
import MovieBooking.Models.Theater;
import MovieBooking.Models.TheaterSeats;
import MovieBooking.Repository.TheaterRepository;
import MovieBooking.Request.TheaterRequest;
import MovieBooking.Request.TheaterSeatRequest;

@Service
public class TheaterService {
	@Autowired
	private TheaterRepository theaterRepo;
	
	public String addTheater(TheaterRequest theaterReq) throws TheaterIsExists{
		if (theaterRepo.findByAddress(theaterReq.getAddress())!=null) {
			throw new TheaterIsExists();	
		}
		Theater theater = TheaterConvertor.theaterDtoToTheater(theaterReq);
		theaterRepo.save(theater);
		return "Rap phim them thanh cong";
	}
	
	public String addTheaterSeat (TheaterSeatRequest theaterSeatReq) throws TheaterDoesNotExists{
		if (theaterRepo.findByAddress(theaterSeatReq.getAddress())==null) {
			throw new TheaterDoesNotExists();
		}
		int numberOfSeatInRow = theaterSeatReq.getNumberOfSeatInRow();
		int numberOfClassicSeat = theaterSeatReq.getNumberOfClassicSeat();
		int numberOfPreniumSeat = theaterSeatReq.getNumberOfPremiumSeat();
		String address = theaterSeatReq.getAddress();
		Theater theater = theaterRepo.findByAddress(address);
		List<TheaterSeats>theaterSeatList=theater.getTheaterSeatList();
		int counter = 1;
		int fill = 0;
		char chClassic = 'A';
		for (int i = 1; i <= numberOfClassicSeat; i++) {
		    String seatNumber = chClassic + Integer.toString(counter);
		    counter++;
		    if (counter > numberOfSeatInRow) {
		        counter = 1;
		        chClassic++;
		    }
			TheaterSeats theaterSeat = new TheaterSeats();
			theaterSeat.setSeatNumber(seatNumber);
			theaterSeat.setSeatType(SeatType.CLASSIC);
			theaterSeat.setTheater(theater);
			theaterSeatList.add(theaterSeat);
		}
		
		char chPremium = chClassic;
		for (int i = 1; i <= numberOfPreniumSeat; i++) {
		    String seatNumber = chPremium + Integer.toString(counter);
		    counter++;
		    if (counter > numberOfSeatInRow) {
		        counter = 1;
		        chPremium++;
		    }
			TheaterSeats theaterSeat = new TheaterSeats();
			theaterSeat.setSeatNumber(seatNumber);
			theaterSeat.setSeatType(SeatType.PREMIUM);
			theaterSeat.setTheater(theater);
			theaterSeatList.add(theaterSeat);
		}
		theaterRepo.save(theater);
		return "Số ghế rạp đã được thêm vào thành công";
	}
}
