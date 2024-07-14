package MovieBooking.Exception;

public class UserDoesNotExists extends RuntimeException {
	public UserDoesNotExists() {
		super("User does not exists");
	}
}
