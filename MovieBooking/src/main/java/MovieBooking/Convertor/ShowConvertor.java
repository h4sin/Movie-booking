package MovieBooking.Convertor;

import MovieBooking.Models.Show;
import MovieBooking.Request.ShowRequest;

public class ShowConvertor {
	public static Show showDtoToShow(ShowRequest showReq) {
		Show show = Show.builder()
				.time(showReq.getShowStartTime())
				.date(showReq.getShowDate())
				.build();
		return show;
	}
}
