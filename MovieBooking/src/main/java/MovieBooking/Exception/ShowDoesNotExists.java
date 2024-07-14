package MovieBooking.Exception;

public class ShowDoesNotExists extends RuntimeException {
	public ShowDoesNotExists() {
		super("Show does not Exists");
	}
}
