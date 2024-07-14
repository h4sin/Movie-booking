package MovieBooking.Exception;

public class TheaterDoesNotExists extends RuntimeException {
	public TheaterDoesNotExists() {
		super("Theater dose not Exists");	
	}
}
