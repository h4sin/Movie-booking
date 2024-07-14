package MovieBooking.Request;

import lombok.Data;

@Data
public class ShowSeatRequest {
	private Integer showId;
    private Integer priceOfPremiumSeat;
    private Integer priceOfClassicSeat;
}
