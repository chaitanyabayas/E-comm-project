package com.project.ServiceImpl;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.Dao.UserDAO;
import com.project.Dao.UserSessionDAO;
import com.project.Dto.UserDTO;
import com.project.Exception.SellerServiceExpection;
import com.project.Model.User;
import com.project.Model.UserSession;
import com.project.Request.LoginRequest;
import com.project.Request.UserRequest;
import com.project.Response.LoginResponse;
import com.project.Response.Response;
import com.project.SellerService.ResponseStatus;
import com.project.Service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserSessionDAO userSessionDAO;

	private JavaMailSender javaMailSender;

	@Override
	public Response userRegister(UserRequest request) throws SellerServiceExpection {

		Response response = new Response();

		if (request.getFirstName() == null) {
			throw new SellerServiceExpection(ResponseStatus.ERROR, "First Name is Required");
		} else if (request.getLastName() == null) {
			throw new SellerServiceExpection(ResponseStatus.ERROR, "Last Name is Required");
		} else if (request.getMobileNo() == null) {
			throw new SellerServiceExpection(ResponseStatus.ERROR, "Mobile Number is Required");
		} else if (request.getEmail() == null) {
			throw new SellerServiceExpection(ResponseStatus.ERROR, "Email is Required");
		} else if (request.getPassword() == null) {
			throw new SellerServiceExpection(ResponseStatus.ERROR, "Password is Required");
		}

		User userDetails = null;

		User email = userDAO.findActiveUserByEmail(request.getEmail());
		if (email != null) {
			throw new SellerServiceExpection(ResponseStatus.ERROR, "Email ID already Exists.");
		}

		User mobileNumber = userDAO.findActiveUserByMobileNo(request.getMobileNo());
		if (mobileNumber != null) {
			throw new SellerServiceExpection(ResponseStatus.ERROR, "Mobile Number already Exists.");
		}

		if (request.getId() != null) {
			userDetails = userDAO.findUserById(request.getId());
		}

		if (userDetails == null) {
			userDetails = new User();
			userDetails.setFirstName(request.getFirstName());
			userDetails.setLastName(request.getLastName());
			userDetails.setMobileNo(request.getMobileNo());
			if (request.getContactNo() != null) {
				userDetails.setContactNo(request.getContactNo());
			}
			if (request.getUserImage() != null) {
				userDetails.setUserImage(request.getUserImage().getName());
			}
			userDetails.setEmail(request.getEmail());

			userDetails.setPassword(passwordEncoder.encode(request.getPassword()));

			userDetails.setVerified(true);
			userDetails.setTokenValidity(LocalDateTime.now());

			userDetails.setCreatedBy(1);
			userDetails.setCreatedDate(LocalDateTime.now());
			userDetails.setUpdatedBy(1);
			userDetails.setUpdatedDate(LocalDateTime.now());
			userDetails.setActive(true);

		} else {

			userDetails.setFirstName(request.getFirstName());
			userDetails.setLastName(request.getLastName());
			userDetails.setMobileNo(request.getMobileNo());
			if (request.getContactNo() != null) {
				userDetails.setContactNo(request.getContactNo());
			}
			if (request.getUserImage() != null) {
				userDetails.setUserImage(request.getUserImage().getName());
			}
			userDetails.setEmail(request.getEmail());

			userDetails.setPassword(passwordEncoder.encode(request.getPassword()));

			userDetails.setUpdatedBy(1);
			userDetails.setUpdatedDate(LocalDateTime.now());
			userDetails.setActive(true);

		}

		userDetails = userDAO.save(userDetails);

		if (request.getId() == null) {

			ZonedDateTime zdtAtKT = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
			String uuid = UUID.randomUUID().toString();
			LocalDateTime loginTime = zdtAtKT.toLocalDateTime().plusHours(1);

			UserSession userSession = new UserSession();
			userSession.setUserId(userDetails.getId());
			userSession.setToken(uuid);
			userSession.setTokenValidity(loginTime);
			userSession.setLastCall(zdtAtKT.toLocalDateTime());
			userSessionDAO.save(userSession);

			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setTo(userDetails.getEmail());
			mailMessage.setSubject("Complete Registration!");
			mailMessage.setFrom("test.sms1018@gmail.com");
			mailMessage.setText("To confirm your account, please click here : "
					+ "http://localhost:8762/ecommerce/sellerService/seller/confirmAccount?token="
					+ userSession.getToken());

			this.sendEmail(mailMessage);
		}

		response.setStatus(ResponseStatus.OK);
		if (request.getId() == null) {
			response.setMessage("User Registered Successfully.");
		} else {
			response.setMessage("User Updated Successfully.");
		}
		return response;
	}

	@Override
	public LoginResponse userLogin(LoginRequest request) throws SellerServiceExpection {

		LoginResponse response = new LoginResponse();

		ZonedDateTime zdtAtKT = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));

		if (request.getUsername() == null || request.getUsername().isEmpty()) {
			throw new SellerServiceExpection(ResponseStatus.MESSAGE, "Email is required");
		} else if (request.getPassword() == null || request.getPassword().isEmpty()) {
			throw new SellerServiceExpection(ResponseStatus.MESSAGE, "Password is required");
		}

		String emailDetails = request.getUsername().trim();
		User user = userDAO.findActiveByUsername(emailDetails);

		if (user == null) {
			throw new SellerServiceExpection(ResponseStatus.MESSAGE, "Incorrect username or password!");
		}

		if (user.getActive()) {
			String pass = request.getPassword().trim();
			if (passwordEncoder.matches(pass, user.getPassword())) {
				if (user.getActive()) {
					if (user.getVerified()) {
						String uuid = UUID.randomUUID().toString();
						LocalDateTime loginTime = zdtAtKT.toLocalDateTime().plusHours(1);

						UserSession userSession = new UserSession();
						userSession.setUserId(user.getId());
						userSession.setToken(uuid);
						userSession.setTokenValidity(loginTime);
						userSession.setLastCall(zdtAtKT.toLocalDateTime());
						userSessionDAO.save(userSession);

						UserDTO dto = new UserDTO(user);
						dto.setToken(uuid);
						dto.setTokenValidity(loginTime);
						response.setUserDTO(dto);
					} else {
						throw new SellerServiceExpection(ResponseStatus.MESSAGE,
								"Account Not Verified. Please check email for verification!");
					}
				} else {
					throw new SellerServiceExpection(ResponseStatus.MESSAGE,
							"Account is deactivated. Please contact Site administrator!");
				}
			} else {
				throw new SellerServiceExpection(ResponseStatus.MESSAGE, "Incorrect username or password!");
			}
		} else {
			throw new SellerServiceExpection(ResponseStatus.MESSAGE, "Account is deactiveted by administration!");
		}
		response.setStatus(ResponseStatus.OK);
		response.setMessage("Login Successfully");
		return response;
	}

	@Autowired
	public void SimpleMailMessage(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	@Async
	public void sendEmail(SimpleMailMessage email) {
		javaMailSender.send(email);
	}

}
