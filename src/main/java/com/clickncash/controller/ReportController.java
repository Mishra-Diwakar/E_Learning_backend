package com.clickncash.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clickncash.entity.Course;
import com.clickncash.entity.PaymentDetails;
import com.clickncash.entity.Queries;
import com.clickncash.entity.User;
import com.clickncash.repository.PaymentDetailsRepository;
import com.clickncash.repository.PurchasedCourseRepository;
import com.clickncash.repository.QueriesRepository;
import com.clickncash.repository.UserRepository;

@RestController
@RequestMapping("/rest/auth/report")
public class ReportController {
	
	@Autowired
	private PaymentDetailsRepository paymentDetailsRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private QueriesRepository queriesRepository;
	
	@GetMapping("/payments/{page}/{record}")
	private Page<PaymentDetails> getAllPayments(@PathVariable("page") Integer page, @PathVariable("record") Integer record,
			HttpServletRequest request) {
		try {
			Long userId = null;
			if (request.getAttribute("userId") != null) {
				userId = Long.valueOf(request.getAttribute("userId").toString());
			} else {
				System.out.println(" @@@ user not found of this userId @@@");
				return null;
			}
			Pageable pageable = PageRequest.of(page, record);
			User user = userRepository.findById(userId).get();
			if (user.getUserType() == 1) {
				return this.paymentDetailsRepository.getAllPayments(pageable);
			}
			return null;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	@PostMapping("/searchPayment")
	private List<PaymentDetails> searchPayment(@RequestBody PaymentDetails paymentDetails,
			HttpServletRequest request) {
		try {
			Long userId = null;
			if (request.getAttribute("userId") != null) {
				userId = Long.valueOf(request.getAttribute("userId").toString());
			} else {
				System.out.println(" @@@ user not found of this userId @@@");
				return null;
			}
			return paymentDetailsRepository.findByPaymentId(paymentDetails.getPaymentId());
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	@GetMapping("/purchasedCourse/{page}/{record}")
	private Page<PaymentDetails> getPurchasedCourse(@PathVariable("page") Integer page, @PathVariable("record") Integer record,
			HttpServletRequest request) {
		try {
			Long userId = null;
			if (request.getAttribute("userId") != null) {
				userId = Long.valueOf(request.getAttribute("userId").toString());
			} else {
				System.out.println(" @@@ user not found of this userId @@@");
				return null;
			}
			Pageable pageable = PageRequest.of(page, record);
			User user = userRepository.findById(userId).get();
			if (user.getUserType() == 1) {
				return this.paymentDetailsRepository.getAllPayments(pageable);
			}
			return null;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	@GetMapping("/queries/{page}/{record}")
	private Page<Queries> getAllQueries(@PathVariable("page") Integer page, @PathVariable("record") Integer record,
			HttpServletRequest request) {
		try {
			Long userId = null;
			if (request.getAttribute("userId") != null) {
				userId = Long.valueOf(request.getAttribute("userId").toString());
			} else {
				System.out.println(" @@@ user not found of this userId @@@");
				return null;
			}
			Pageable pageable = PageRequest.of(page, record);
			User user = userRepository.findById(userId).get();
			if (user.getUserType() == 1) {
				return this.queriesRepository.getAllQueries(pageable);
			}
			return null;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
}
