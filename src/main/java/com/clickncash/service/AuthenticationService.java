package com.clickncash.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clickncash.entity.User;
import com.clickncash.model.UserPrincipal;
import com.clickncash.repository.UserRepository;

@Service
public class AuthenticationService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
//		User user = null;
//		try {
//			System.out.println("coming loginId: "+loginId);
//			user = userRepository.getUserByUserName(Long.parseLong(loginId)).orElseThrow(
//					() -> new UsernameNotFoundException("User not found with Email/Network Id/Employee Id : " + loginId));
//		System.out.println("comes here @@@@@@@@@@@2");
//			if (!user.isStatus()) {
//			System.out.println("User deactive ");
//			return null;
//		}
//		}catch (Exception e) {
//			user = userRepository.getUserByUserName2(loginId).orElseThrow(
//					() -> new UsernameNotFoundException("User not found with Email/Network Id/Employee Id : " + loginId));
//		}
//		return UserPrincipal.create(user);
		
//		we have change in two files commented on requestFilter of userId='diwakar' and commented first query of userRepo
		User user = null;
		try {
			System.out.println("coming loginId: "+loginId);
			user = userRepository.getUserByUserName(loginId).orElseThrow(
					() -> new UsernameNotFoundException("User not found with Email/Network Id/Employee Id : " + loginId));
			if (!user.isStatus()) {
			System.out.println("User deactive ");
			return null;
		}
		}catch (Exception e) {
			user = userRepository.getUserByUserName2(loginId).orElseThrow(
					() -> new UsernameNotFoundException("User not found with Email/Network Id/Employee Id : " + loginId));
		}
		return UserPrincipal.create(user);
	}
}