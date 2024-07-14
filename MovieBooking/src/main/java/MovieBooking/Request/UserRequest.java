package MovieBooking.Request;

import MovieBooking.Enum.Gender;
import lombok.Data;
@Data
public class UserRequest {
	private String name;
    private Integer age;
    private String address;
    private String mobileNo;
    private String emailId;
    private Gender gender;
    private String roles;
}
