package ec.com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.com.exceptionhandling.UserErrorResponse;
import ec.com.user.entity.User;
import ec.com.user.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/seller")
public class UserConroller {
	@Autowired
	private UserService userService;
	@Autowired
	private UserErrorResponse userErrorResponse;

	@PostMapping("/users")
	public ResponseEntity<User> createNewUser(@Validated @RequestBody User user) {
		userService.createUser(user);
		userErrorResponse.setMessage("User Saved");
		userErrorResponse.setStatus(HttpStatus.OK.value());
		userErrorResponse.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity(userErrorResponse, HttpStatus.OK);
	}

	@GetMapping("/users")
	public List<User> getAllUser() {
		List<User> user = userService.getAllUser();
		return user;
	}

	@GetMapping("/{id}")
	public User findUserById(@PathVariable("id") int id) {
		User user = userService.findUserById(id);
		return user;
	}

	@GetMapping("name/{name}")
	public List<User> findUserByName(@PathVariable("name") String name) {
		List<User> user = userService.findUserByName(name);
		return user;
	}

	@GetMapping(path = "mobile/{mobileNumber}")
	public User findUserByMobileNumber(@PathVariable("mobileNumber") String mobileNumber) {
		User user = userService.findUserByMobileNumber(mobileNumber);
		return user;
	}

	@PutMapping("/update")
	public ResponseEntity<User> updateUser(@Validated @RequestBody User user) {
		userService.updateUser(user);
		userErrorResponse.setMessage("User Updated");
		userErrorResponse.setStatus(HttpStatus.OK.value());
		userErrorResponse.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity(userErrorResponse, HttpStatus.OK);
	}

}
