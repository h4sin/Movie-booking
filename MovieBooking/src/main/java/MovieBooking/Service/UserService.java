package MovieBooking.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import MovieBooking.Convertor.UserConvertor;
import MovieBooking.Exception.UserAlreadyExists;
import MovieBooking.Models.User;
import MovieBooking.Repository.UserRepository;
import MovieBooking.Request.UserRequest;

public class UserService {
	@Autowired
	UserRepository userRepository;

	public String addUser(UserRequest userRequest) {
		Optional<User> users = userRepository.findByEmailId(userRequest.getEmailId());

		if (users.isPresent()) {
			throw new UserAlreadyExists();
		}

		User user = UserConvertor.userDtoToUser(userRequest);

		userRepository.save(user);
		return "User Saved Successfully";
	}

}
