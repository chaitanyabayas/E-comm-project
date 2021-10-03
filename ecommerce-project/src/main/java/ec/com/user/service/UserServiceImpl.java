package ec.com.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.resource.HttpResource;

import ec.com.exceptionhandling.UserAllreadyExists;
import ec.com.exceptionhandling.UserNotFoundException;
import ec.com.user.entity.User;
import ec.com.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User createUser(User user) {
		User us =userRepository.findByMobileNumber(user.getMobileNumber());
		if (us != null) {
			throw new UserAllreadyExists("User Allready exist");
		}
		return userRepository.save(user);
	}

	@Override
	public User updateUser(User user) {
		User us = this.findUserById(user.getId());
		us.setUserName(user.getUserName());
		us.setEmail(user.getEmail());
		us.setFirstName(user.getFirstName());
		us.setMobileNumber(user.getMobileNumber());
		us.setUserPassword(user.getUserPassword());
		us.setAddress(user.getAddress());
		userRepository.save(us);
		return us;

	}

	@Override
	public List<User> getAllUser() {
		List<User> user = userRepository.findAll();
		if (user.isEmpty()) {
			throw new UserNotFoundException("No User Found");
		}
		return user;
	}

	@Override
	public User findUserById(int id) {
		User user = null;
		try {
			user = userRepository.findById(id).get();
		} catch (Exception ex) {
			throw new UserNotFoundException("User Does Not Exist :" + id);
		}

		return user;
	}

	@Override
	public List<User> findUserByName(String name) {
		List<User> user = userRepository.findByUserName(name.trim());
		if (user.isEmpty()) {
			throw new UserNotFoundException("User Does Not Exist");
		}

		return user;
	}

	@Override
	public void deleteUserById(int id) {

		User user = this.findUserById(id);
		if (user != null) {
			userRepository.deleteById(id);
		}

	}

	@Override
	public User findUserByMobileNumber(String mobileNumber) {

		User user = userRepository.findByMobileNumber(mobileNumber);
		if (user == null) {

			throw new UserNotFoundException("User Does Not Exist :" + mobileNumber);
		}

		return user;
	}

}
