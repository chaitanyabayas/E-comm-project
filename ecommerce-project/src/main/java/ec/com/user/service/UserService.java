package ec.com.user.service;

import java.util.List;

import ec.com.user.entity.User;

public interface UserService {
	User createUser(User user);

	User updateUser(User user);

	List<User> getAllUser();

	User findUserByMobileNumber(String mobileNumber);

	User findUserById(int id);

	List<User> findUserByName(String name);

	void deleteUserById(int id);
}
