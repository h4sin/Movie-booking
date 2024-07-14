package MovieBooking.Request;

import lombok.Data;

@Data
public class TheaterSeatRequest {
	private String address;
	private int numberOfSeatInRow;
	private int numberOfPremiumSeat;
	private int numberOfClassicSeat;
}
