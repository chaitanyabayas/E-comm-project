package com.project.ServiceImpl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.project.BuyerService.ResponseStatus;
import com.project.Dao.MainCartDAO;
import com.project.Dao.UserAddressDAO;
import com.project.Dao.UserDAO;
import com.project.Exception.BuyerServiceExpection;
import com.project.Model.MainCart;
import com.project.Model.User;
import com.project.Model.UserAddress;
import com.project.Request.UserRequest;
import com.project.Response.Response;
import com.project.Service.UserService;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private UserAddressDAO userAddressDAO;

	@Autowired
	private MainCartDAO mainCartDAO;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Response userRegister(UserRequest request) throws BuyerServiceExpection {

		Response response = new Response();

		if (request.getFirstName() == null) {
			throw new BuyerServiceExpection(ResponseStatus.ERROR, "First Name is Required");
		} else if (request.getLastName() == null) {
			throw new BuyerServiceExpection(ResponseStatus.ERROR, "Last Name is Required");
		} else if (request.getMobileNo() == null) {
			throw new BuyerServiceExpection(ResponseStatus.ERROR, "Mobile Number is Required");
		} else if (request.getEmail() == null) {
			throw new BuyerServiceExpection(ResponseStatus.ERROR, "Email is Required");
		} else if (request.getPassword() == null) {
			throw new BuyerServiceExpection(ResponseStatus.ERROR, "Password is Required");
		} else if (request.getBuildingName() == null) {
			throw new BuyerServiceExpection(ResponseStatus.ERROR, "Home is Required");
		} else if (request.getArea() == null) {
			throw new BuyerServiceExpection(ResponseStatus.ERROR, "Area is Required");
		} else if (request.getCity() == null) {
			throw new BuyerServiceExpection(ResponseStatus.ERROR, "City is Required");
		} else if (request.getState() == null) {
			throw new BuyerServiceExpection(ResponseStatus.ERROR, "State is Required");
		} else if (request.getCountry() == null) {
			throw new BuyerServiceExpection(ResponseStatus.ERROR, "Country is Required");
		} else if (request.getPinCode() == null) {
			throw new BuyerServiceExpection(ResponseStatus.ERROR, "Pin Code is Required");
		}

		User userDetails = null;
		UserAddress userAddressDetails = null;
		MainCart mainCartDetails = null;

		if (request.getId() != null) {
			userDetails = userDAO.findUserById(request.getId());
			userAddressDetails = userAddressDAO.findUserAddressByUserId(request.getId());
			mainCartDetails = mainCartDAO.findMainCartByUserId(request.getId());
		}

		if (userDetails == null) {
			userDetails = new User();
			userDetails.setFirstName(request.getFirstName());
			userDetails.setLastName(request.getLastName());
			userDetails.setMobileNo(request.getMobileNo());
			userDetails.setContactNo(request.getContactNo());
			userDetails.setUserImage(request.getUserImage().getOriginalFilename());
			userDetails.setEmail(request.getEmail());

			userDetails.setPassword(passwordEncoder.encode(request.getPassword()));

			userDetails.setCreatedBy(1);
			userDetails.setCreatedDate(LocalDateTime.now());
			userDetails.setUpdatedBy(1);
			userDetails.setUpdatedDate(LocalDateTime.now());
			userDetails.setActive(true);

		} else {

			userDetails.setFirstName(request.getFirstName());
			userDetails.setLastName(request.getLastName());
			userDetails.setMobileNo(request.getMobileNo());
			userDetails.setContactNo(request.getContactNo());
			userDetails.setUserImage(request.getUserImage().getOriginalFilename());
			userDetails.setEmail(request.getEmail());

			userDetails.setPassword(passwordEncoder.encode(request.getPassword()));

			userDetails.setUpdatedBy(1);
			userDetails.setUpdatedDate(LocalDateTime.now());
			userDetails.setActive(true);

		}

		userDetails = userDAO.save(userDetails);

		if (userAddressDetails == null && userDetails != null) {
			userAddressDetails = new UserAddress();
			userAddressDetails.setUserId(userDetails.getId());
			userAddressDetails.setBuildingName(request.getBuildingName());
			userAddressDetails.setArea(request.getArea());
			userAddressDetails.setCity(request.getCity());
			userAddressDetails.setState(request.getState());
			userAddressDetails.setCountry(request.getCountry());
			userAddressDetails.setPinCode(request.getPinCode());

			userDetails.setCreatedBy(1);
			userDetails.setCreatedDate(LocalDateTime.now());
			userDetails.setUpdatedBy(1);
			userDetails.setUpdatedDate(LocalDateTime.now());
			userDetails.setActive(true);

		} else {

			userAddressDetails.setUserId(userDetails.getId());
			userAddressDetails.setBuildingName(request.getBuildingName());
			userAddressDetails.setArea(request.getArea());
			userAddressDetails.setCity(request.getCity());
			userAddressDetails.setState(request.getState());
			userAddressDetails.setCountry(request.getCountry());
			userAddressDetails.setPinCode(request.getPinCode());

			userDetails.setUpdatedBy(1);
			userDetails.setUpdatedDate(LocalDateTime.now());
			userDetails.setActive(true);
		}

		userAddressDAO.save(userAddressDetails);

		if (mainCartDetails == null) {
			mainCartDetails = new MainCart();
			mainCartDetails.setUserId(userDetails.getId());

			mainCartDetails.setCreatedBy(1);
			mainCartDetails.setCreatedDate(LocalDateTime.now());
			mainCartDetails.setUpdatedBy(1);
			mainCartDetails.setUpdatedDate(LocalDateTime.now());
			mainCartDetails.setActive(true);
		} else {

			mainCartDetails.setUserId(userDetails.getId());

			mainCartDetails.setUpdatedBy(1);
			mainCartDetails.setUpdatedDate(LocalDateTime.now());
			mainCartDetails.setActive(true);

		}

		mainCartDAO.save(mainCartDetails);

		response.setStatus(ResponseStatus.OK);
		if (request.getId() == null) {
			response.setMessage("User Registered Successfully.");
		} else {
			response.setMessage("User Updated Successfully.");
		}
		return response;
	}

}
