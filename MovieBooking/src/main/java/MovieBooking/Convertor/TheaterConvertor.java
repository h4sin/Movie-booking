package MovieBooking.Convertor;

import MovieBooking.Models.Theater;
import MovieBooking.Request.TheaterRequest;

public class TheaterConvertor {
	public static Theater theaterDtoToTheater(TheaterRequest theaterRequest) {
        Theater theater = Theater.builder()
                .name(theaterRequest.getName())
                .address(theaterRequest.getAddress())
                .build();
        return theater;
    }
}

