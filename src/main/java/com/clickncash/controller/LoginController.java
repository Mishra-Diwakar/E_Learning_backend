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
import com.clickncash.service.UserService;
import com.clickncash.utils.AuthTokenUtil;

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
}
