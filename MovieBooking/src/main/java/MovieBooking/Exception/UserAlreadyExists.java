package MovieBooking.Exception;

public class UserAlreadyExists extends RuntimeException {

	public UserAlreadyExists() {
	        super("User Already Exists with this EmailId");
	    }
}
