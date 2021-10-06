package com.project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.Dao.UserDAO;
import com.project.Dao.UserSessionDAO;
import com.project.Exception.SellerServiceExpection;
import com.project.Model.User;
import com.project.Model.UserSession;
import com.project.Request.LoginRequest;
import com.project.Request.UserRequest;
import com.project.Response.LoginResponse;
import com.project.Response.Response;
import com.project.Service.UserService;

@RestController
@RequestMapping("/seller/")
//@CrossOrigin(origins = "http://localhost:8762")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserSessionDAO userSessionDAO;

	@Autowired
	private UserDAO userDAO;

	@RequestMapping(value = "userRegister", method = RequestMethod.POST, produces = "application/json")
	public Response userRegister(@RequestBody UserRequest request) throws SellerServiceExpection {

		Response response = userService.userRegister(request);
		return response;
	}

	@RequestMapping(value = "userLogin", method = RequestMethod.POST, produces = "application/json")
	public LoginResponse userLogin(@RequestBody LoginRequest request) throws SellerServiceExpection {

		LoginResponse response = userService.userLogin(request);
		return response;
	}

	@RequestMapping(value = "/confirmAccount", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json")
	public Response confirmUserAccount(@RequestParam("token") String token) {

		Response response = new Response();

		UserSession uToken = userSessionDAO.findByToken(token);

		if (token != null) {
			User user = userDAO.findUserById(uToken.getUserId());
			user.setVerified(true);
			userDAO.save(user);
			response.setMessage("Account Verified");
		} else {
			response.setMessage("Error while account verification");
		}

		response.setMessage("Account Verified Successfully!");
		return response;
	}

//	public static byte[] compressBytes(byte[] data) {
//		Deflater deflater = new Deflater();
//		deflater.setInput(data);
//		deflater.finish();
//		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
//		byte[] buffer = new byte[1024];
//		while (!deflater.finished()) {
//			int count = deflater.deflate(buffer);
//			outputStream.write(buffer, 0, count);
//		}
//		try {
//			outputStream.close();
//		} catch (IOException e) {
//		}
//		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
//		return outputStream.toByteArray();
//	}
//
//	// uncompress the image bytes before returning it to the angular application
//	public static byte[] decompressBytes(byte[] data) {
//		Inflater inflater = new Inflater();
//		inflater.setInput(data);
//		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
//		byte[] buffer = new byte[1024];
//		try {
//			while (!inflater.finished()) {
//				int count = inflater.inflate(buffer);
//				outputStream.write(buffer, 0, count);
//			}
//			outputStream.close();
//		} catch (IOException ioe) {
//		} catch (DataFormatException e) {
//		}
//		return outputStream.toByteArray();
//	}
}
