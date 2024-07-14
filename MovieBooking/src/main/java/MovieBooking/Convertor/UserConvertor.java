package MovieBooking.Convertor;

import MovieBooking.Models.User;
import MovieBooking.Reponse.UserResponse;
import MovieBooking.Request.UserRequest;

public class UserConvertor {
	public static User userDtoToUser(UserRequest userRequest) {
		User user = User.builder().name(userRequest.getName()).age(userRequest.getAge())
				.address(userRequest.getAddress()).gender(userRequest.getGender()).mobileNumber(userRequest.getMobileNo())
				.emailId(userRequest.getEmailId()).build();

		return user;
	}

	public static UserResponse userToUserDto(User user) {
		UserResponse userDto = UserResponse.builder().name(user.getName()).age(user.getAge()).address(user.getAddress())
				.gender(user.getGender()).build();

		return userDto;
	}
}
