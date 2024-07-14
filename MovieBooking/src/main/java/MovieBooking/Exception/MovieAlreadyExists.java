package MovieBooking.Exception;

public class MovieAlreadyExists extends RuntimeException {
	
	public MovieAlreadyExists() {
		super("Movie is already exists with same name and language");
	}
}
