package MovieBooking.Request;

import java.sql.Date;

import lombok.Data;
@Data
public class ShowTimingrRequest {
	private Date date;
	private Integer theaterId;
	private Integer movieId;
}
