package com.clickncash.service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.clickncash.entity.User;
import com.clickncash.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	public HashMap<String, Object> saveUser(User u, Boolean isEdit){
		HashMap<String, Object> returnMap = new HashMap<> ();
		try {
			List<User> exist = userRepository.isExist(u.getAadhar(),u.getEmail(),u.getMobile(),u.getUsername());
			if (exist.size()==0 && !isEdit) {	
				u.setPassword(passwordEncoder.encode(u.getPassword()));
				u.setStatus(true);
				u.setCreatedAt(new Timestamp(System.currentTimeMillis()));
				u.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
				userRepository.save(u);
				returnMap.put("isError", false);
				returnMap.put("msg", "User created");
				return returnMap;
			}
			if (exist.size()>=1 && isEdit) {
				List<User> exist2 = userRepository.isExist2(u.getUsername(),u.getAadhar(),u.getEmail(),u.getMobile(),u.getId());				
				if (exist2.size()==0) {
					User user = userRepository.findById(u.getId()).get();
					User usr = setUser(u);
					usr.setPassword(user.getPassword());
					usr.setCreatedAt(user.getCreatedAt());
					usr.setCreatedBy(user.getCreatedBy());
					usr.setLoginAt(user.getCreatedAt());
					usr.setUpdatedBy(u.getUpdatedBy());
					userRepository.save(usr);
					returnMap.put("isError", false);
					returnMap.put("msg", "User updated");
					return returnMap;
				}else {
					return checkDublicateDetails(u,isEdit);
				}
			}
			if (exist.size()>=1 && !isEdit) {
				
				System.out.println("comes here");
				return checkDublicateDetails(u,true);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			returnMap.put("isError", true);
			returnMap.put("msg", "User not saved");
			return returnMap;
		}
		return returnMap;
	}
	
	HashMap<String, Object> checkDublicateDetails(User u, boolean isEdit){
		HashMap<String, Object> returnMap = new HashMap<>();
		try {
			if (isEdit) {
				List<User> findByUsername = userRepository.findByUsername(u.getUsername());
				if (findByUsername.size()>=1) {
					returnMap.put("isError", true);
					returnMap.put("msg", "username already exists");
					return returnMap;
				}
				List<User> findByAadhar = userRepository.findByAadhar(u.getAadhar());
				if (findByAadhar.size()>=1) {
					returnMap.put("isError", true);
					returnMap.put("msg", "aadhar already exists");
					return returnMap;
				}
				List<User> findByEmail = userRepository.findByEmailList(u.getEmail());
				if (findByEmail.size()>=1) {
					returnMap.put("isError", true);
					returnMap.put("msg", "email already exists");
					return returnMap;
				}
				List<User> findByMobile = userRepository.findByMobile(u.getMobile());
				if (findByMobile.size()>=1) {
					returnMap.put("isError", true);
					returnMap.put("msg", "mobile already exists");
					return returnMap;
				}
			}
			if (!isEdit) {				
				List<User> findByUsername = userRepository.findByUsername2(u.getUsername(),u.getId());
				if (findByUsername.size()>=1) {
					returnMap.put("isError", true);
					returnMap.put("msg", "aadhar already exists");
					return returnMap;
				}
				List<User> findByAadhar = userRepository.findByAadhar2(u.getAadhar(),u.getId());
				if (findByAadhar.size()>=1) {
					returnMap.put("isError", true);
					returnMap.put("msg", "aadhar already exists");
					return returnMap;
				}
				List<User> findByEmail = userRepository.findByEmailList2(u.getEmail(),u.getId());
				if (findByEmail.size()>=1) {
					returnMap.put("isError", true);
					returnMap.put("msg", "email already exists");
					return returnMap;
				}
				List<User> findByMobile = userRepository.findByMobile2(u.getMobile(),u.getId());
				if (findByMobile.size()>=1) {
					returnMap.put("isError", true);
					returnMap.put("msg", "mobile already exists");
					return returnMap;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			returnMap.put("isError", true);
			returnMap.put("msg", "User not updated..");
			return returnMap;
		}
		returnMap.put("isError", true);
		returnMap.put("msg", "User not updated....");
		return returnMap;
		
	}
	
	User setUser(User u) {
		User user = new User();
		user.setId(u.getId());
		user.setUsername(u.getUsername());
		user.setFirstName(u.getFirstName());
		user.setLastName(u.getLastName());
		user.setGender(u.getGender());
		user.setEmail(u.getEmail());
		user.setAadhar(u.getAadhar());
		user.setDob(u.getDob());
		user.setPincode(u.getPincode());
		user.setDistrict(u.getDistrict());
		user.setState(u.getState());
		user.setStatus(u.isStatus());
		user.setUserType(u.getUserType());
		user.setMobile(u.getMobile());
		user.setPoliceStation(u.getPoliceStation());
		user.setPostOffice(u.getPostOffice());
		user.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
		return user;
	}
}
