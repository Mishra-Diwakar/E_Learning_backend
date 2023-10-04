package com.clickncash.controller;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clickncash.entity.User;
import com.clickncash.exception.FieldException;
import com.clickncash.model.AuthRequest;
import com.clickncash.model.AuthResponse;
import com.clickncash.model.Response;
import com.clickncash.repository.UserRepository;
import com.clickncash.service.EmailService;
import com.clickncash.service.UserService;
import com.clickncash.utils.AuthTokenUtil;

import net.bytebuddy.asm.Advice.This;

@RestController
@RequestMapping("/rest/auth")
public class LoginController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired UserService userService;
	
	@Autowired
	private AuthTokenUtil tokenProvider;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@RequestBody AuthRequest authRequest) throws FieldException {
		System.out.println("comes for login");
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		User user = userRepository
				.getUserByUserName2(authRequest.getUsername()).get();
		boolean status = user.isStatus();
		if (!status) {
			Response<AuthResponse> response = new Response<>();
			response.setErrors(Arrays.asList("User not active"));
			return ResponseEntity.ok().body(response);
		}
		String jwt = tokenProvider.generateToken(authentication);
		//String permission = this.mergeUserPerissions(user.getRoles());
		Response<AuthResponse> response = new Response<>();
		response.setMessages(Arrays.asList("Token Generated Successfully.")); //Arrays.asList(environment.getProperty("token.generated"))
		response.setPayload(new AuthResponse(jwt, user, null));
		user.setLoginAt(new Timestamp(System.currentTimeMillis()));
		userRepository.save(user);
		return ResponseEntity.ok().body(response);
	}

	@PostMapping("/generateToken")
	public ResponseEntity<?> generateToken(@RequestBody AuthRequest authRequest) throws FieldException {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		String jwt = tokenProvider.generateToken(authentication);
		//String permission = this.mergeUserPerissions(user.getRoles());
		Response<AuthResponse> response = new Response<>();
		response.setMessages(Arrays.asList("Token Generated Successfully.")); //Arrays.asList(environment.getProperty("token.generated"))
		response.setPayload(new AuthResponse(jwt, null, null));
		return ResponseEntity.ok().body(response);
	}
	
	@PostMapping("/signup")
	public HashMap<String, Object> signupUser(@RequestBody User u){
		
		HashMap<String, Object> returnMap = new HashMap<>();
		try {
			u.setCreatedBy(0l);
			u.setUserType(4l);
			HashMap<String, Object> resultMap = userService.saveUser(u,false);	
			Boolean hasError = Boolean.valueOf(resultMap.get("isError").toString());
			if(hasError) {
				return resultMap;
			}
			returnMap.put("isError", false);
			returnMap.put("msg", "You have registered successfully");
			return returnMap;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			returnMap.put("msg", "Try again...");
			returnMap.put("isError", true);
			return returnMap;
		}
		
	}
	
	@PostMapping("/send-otp")
	private HashMap<String, Object> sendOtp(@RequestBody User user) {
		HashMap<String, Object> map = new HashMap<>();
		System.out.println("@@@@@@@@@@@@@@@@@@");
		try {
			User userData = userRepository.findByEmail(user.getEmail());
			if (userData == null) {
				map.put("isError", true);
				map.put("msg", "Credentials not found");
				return map;
			} 
				System.out.println(user.getEmail());
				int min = 1000;
				int max = 9999;
				int b = (int) (Math.random() * (max - min + 1) + min);
				System.out.println("OTP" + b);

				String to = user.getEmail();
				String subject = "Verify OTP";
				String message = "Your One-Time Password (OTP) is : <b>" + b
						+ " </b> Do not share this OTP with anyone for security reasons ";
				this.emailService.sendMail(to, subject, message);
				System.out.println(userData.getEmail());
				userData.setOtpNum(b);
				userData.setOtpSentAt(new Timestamp(System.currentTimeMillis()));
				userRepository.save(userData);
				map.put("isError", false);
				map.put("msg", "Otp sent Successfully");
				map.put("email", user.getEmail());
				return map;
			
		} catch (Exception e) {
			e.printStackTrace();
			map.put("isError", true);
			map.put("msg", "Error on OTP operation");
			return map;
		}
	}
	
	@PostMapping("/verify-otp")
	private HashMap<String, Object> verifyOtp(@RequestBody User u) {
		HashMap<String, Object> map = new HashMap<>();
		try {
			User user = userRepository.findByEmail(u.getEmail());
			System.out.println("userOtp: "+user.getOtpNum());
			System.out.println("uOtpNum: "+u.getOtpNum());
			if (user.getOtpNum().equals(u.getOtpNum())) {
				map.put("isError", false);
				map.put("msg", "OTP is Valid");
				return map;
			}else {
				map.put("isError", true);
				map.put("msg", "Invalid OTP");
				return map;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			map.put("isError", true);
			map.put("msg", "Error on verify OTP");
			return map;
		}
	
	}
	
	@PostMapping("/resetPassword")
	private HashMap<String, Object> resetPass(@RequestBody User u) {
		HashMap<String, Object> map = new HashMap<>();
		User user = userRepository.findByEmail(u.getEmail());
		System.out.println("password  : "+u.getPassword());
		user.setPassword(passwordEncoder.encode(u.getPassword()));
		userRepository.save(user);
		
		System.out.println("password  : "+user.getPassword());
		
		
		map.put("isError", false);
		map.put("msg", "Password reseted successfully");
		return map;

	}
}
