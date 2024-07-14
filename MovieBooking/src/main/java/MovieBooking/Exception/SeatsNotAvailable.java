package MovieBooking.Exception;

public class SeatsNotAvailable extends RuntimeException {
	public SeatsNotAvailable() {
		super("Seat does not Available");
	}
}
