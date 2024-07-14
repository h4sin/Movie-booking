package MovieBooking.Exception;

public class TheaterIsExists extends RuntimeException {
	public TheaterIsExists() {
		super("Theater is Exists");
	}
}
