package com.clickncash.controller;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clickncash.dto.TotalDto;
import com.clickncash.entity.Course;
import com.clickncash.entity.PaymentDetails;
import com.clickncash.entity.PurchasedCourse;
import com.clickncash.entity.Queries;
import com.clickncash.entity.User;
import com.clickncash.model.ChangePassword;
import com.clickncash.repository.CourseRepository;
import com.clickncash.repository.PaymentDetailsRepository;
import com.clickncash.repository.PurchasedCourseRepository;
import com.clickncash.repository.QueriesRepository;
import com.clickncash.repository.UserRepository;
import com.clickncash.service.CourseService;
import com.clickncash.service.UserService;

@RestController
@RequestMapping("/rest/auth/user")
public class UserController {

	@Autowired
	private CourseService courseService;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private PaymentDetailsRepository paymentDetailsRepository;
	
	@Autowired
	private PurchasedCourseRepository purchasedCourseRepository;
	
	@Autowired
	private QueriesRepository queriesRepository;

	@Autowired
	PasswordEncoder passwordEncoder;
	
	@PostMapping("/createUser")
	private HashMap<String, Object> createUser(@RequestBody User user, HttpServletRequest request){
		HashMap<String, Object> returnMap = new HashMap<>();
		try {
			Long userId = null;
			if (request.getAttribute("userId") != null) {
				userId = Long.valueOf(request.getAttribute("userId").toString());
			} else {
				System.out.println(" @@@ user not found of this userId @@@");
				returnMap.put("isError", false);
				returnMap.put("msg", "User not found for this id");
				return returnMap;
			}
			user.setCreatedBy(userId);
			user.setUserType(user.getUserType());
			HashMap<String, Object> resultMap = userService.saveUser(user,false);	
			Boolean hasError = Boolean.valueOf(resultMap.get("isError").toString());
			if(hasError) {
				return resultMap;
			}
			returnMap.put("isError", false);
			returnMap.put("msg", "User created successfully");
			return returnMap;
			
		} catch (Exception e) {
			e.printStackTrace();
			returnMap.put("msg", "Try again...");
			returnMap.put("isError", true);
			return returnMap;
		}
	}
	
	@PostMapping("/editUser")
	private HashMap<String, Object> editUser(@RequestBody User user, HttpServletRequest request){
		HashMap<String, Object> returnMap = new HashMap<>();
		try {
			Long userId = null;
			if (request.getAttribute("userId") != null) {
				userId = Long.valueOf(request.getAttribute("userId").toString());
			} else {
				System.out.println(" @@@ user not found of this userId @@@");
				returnMap.put("isError", true);
				returnMap.put("msg", "User not found for this id");
				return returnMap;
			}
			user.setUpdatedBy(userId);
			HashMap<String, Object> resultMap = userService.saveUser(user,true);	
			Boolean hasError = Boolean.valueOf(resultMap.get("isError").toString());
			if(hasError) {
				return resultMap;
			}
			returnMap.put("isError", false);
			returnMap.put("msg", "User updated successfully");
			return returnMap;
			
		} catch (Exception e) {
			e.printStackTrace();
			returnMap.put("msg", "Try again...");
			returnMap.put("isError", true);
			return returnMap;
		}
	}
	
	@PostMapping("/get")
	private User getOneUser(@RequestBody(required = false) User user, HttpServletRequest request){
		try {
			Long userId = null;
			if (request.getAttribute("userId") != null) {
				userId = Long.valueOf(request.getAttribute("userId").toString());
			} else {
				System.out.println(" @@@ user not found of this userId @@@");
				return null;
			}
			if (user==null) {
				return userRepository.findById(userId).get();
			}
			return userRepository.findById(user.getId()).get();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	@PostMapping("/delete")
	private HashMap<String, Object> deleteUser(@RequestBody User user, HttpServletRequest request) {
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		try {
			Long userId = null;
			if (request.getAttribute("userId") != null) {
				userId = Long.valueOf(request.getAttribute("userId").toString());
			} else {
				System.out.println(" @@@ user not found of this userId @@@");
				returnMap.put("isError", true);
				returnMap.put("msg", "User not found");
				return returnMap;
			}
			User user2 = userRepository.findById(user.getId()).get();
			user2.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
			user2.setStatus(false);
			user2.setUpdatedBy(userId);
			userRepository.save(user2);
			returnMap.put("isError", false);
			returnMap.put("msg", "User deleted");
			return returnMap;
		} catch (Exception e) {
			e.getMessage();
			returnMap.put("isError", true);
			returnMap.put("msg", "User not deleted");
			return returnMap;
		}
		
	}
	
	@GetMapping("/users/{page}/{record}/{userType}")
	private Page<User> getAllUsers(@PathVariable("page") Integer page, @PathVariable("record") Integer record,
			@PathVariable("userType") Long userType ,HttpServletRequest request) {
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
				return this.userRepository.getAllUsers(userType,pageable);
			}
			return null;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}

	}

	@PostMapping("/create_order")
	private String createOrder(@RequestBody Map<String, Object> data, HttpServletRequest request) {
		try {
			Long userId = null;
			if (request.getAttribute("userId") != null) {
				userId = Long.valueOf(request.getAttribute("userId").toString());
			} else {
				System.out.println(" @@@ user not found of this userId @@@");
				return null;
			}
			return courseService.createOrder(data, userId);
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

	@PostMapping("/create_payment")
	private HashMap<String, Object> createPayment(@RequestBody PaymentDetails paymentDetails,
			HttpServletRequest request) {
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		try {
			Long userId = null;
			if (request.getAttribute("userId") != null) {
				userId = Long.valueOf(request.getAttribute("userId").toString());
			} else {
				System.out.println(" @@@ user not found of this userId @@@");
				return null;
			}
			
			System.out.println("%%%%%%%%%%%%%% userId : "+userId);
			
			String createPayment = courseService.createPayment(paymentDetails, userId);
			Calendar cal = Calendar.getInstance();
	        cal.add(Calendar.YEAR, 1);
	        List<PurchasedCourse> findByCourseIdAndUserId = purchasedCourseRepository.findByCourseIdAndUserId(paymentDetails.getCourseId(),userId);
			if (findByCourseIdAndUserId.size()==0) {
				PurchasedCourse purchasedCourse = new PurchasedCourse();
				purchasedCourse.setCourseId(paymentDetails.getCourseId());
				purchasedCourse.setUserId(userId);
				purchasedCourse.setEnrolledAt(new Timestamp(System.currentTimeMillis()));
				purchasedCourse.setValidTill(new Timestamp(cal.getTimeInMillis()));
				purchasedCourseRepository.save(purchasedCourse);
			}else {
				PurchasedCourse purchasedCourse = findByCourseIdAndUserId.get(0);
				purchasedCourse.setEnrolledAt(new Timestamp(System.currentTimeMillis()));
				purchasedCourse.setValidTill(new Timestamp(cal.getTimeInMillis()));
				purchasedCourseRepository.save(purchasedCourse);
			}
	        
			returnMap.put("isError", false);
			returnMap.put("msg", createPayment);
			return returnMap;
		} catch (Exception e) {
			e.getMessage();
		}
		returnMap.put("isError", true);
		returnMap.put("msg", "failed");
		return returnMap;
	}

	@PostMapping("/search")
	private List<User> searchUser(@RequestBody User user, HttpServletRequest request) {
		try {
			Long userId = null;
			if (request.getAttribute("userId") != null) {
				userId = Long.valueOf(request.getAttribute("userId").toString());
			} else {
				System.out.println(" @@@ user not found of this userId @@@");
				return null;
			}
			return userRepository.searchUser(user.getEmail());
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

	@GetMapping("/refresh/{keywords}")
	private HashMap<String, Object> refreshCountDetails(@PathVariable("keywords") String keywords,
			HttpServletRequest request) {
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		try {
			Long userId = null;
			Long totalStudent = 0l;
			Long newStudent = 0l;
			Long totalCourse = 0l;
			Long totalFee = 0l;
			Long totalTeacher = 0l;
			Long totalAvlTeacher = 0l;
			if (request.getAttribute("userId") != null) {
				userId = Long.valueOf(request.getAttribute("userId").toString());
			} else {
				System.out.println(" @@@ user not found of this userId @@@");
				returnMap.put("isError", true);
				returnMap.put("msg", "User not found");
				return returnMap;
			}
			if (keywords.equalsIgnoreCase("student")) {
				Long countEmployee = userRepository.countEmployee(4L);
				returnMap.put("msg", countEmployee);
				returnMap.put("isError", false);
				return returnMap;
			}
			if (keywords.equalsIgnoreCase("newStudent")) {
				Long countNewStudent = userRepository.countNewStudent(4L);
				returnMap.put("msg", countNewStudent);
				returnMap.put("isError", false);
				return returnMap;
			}
			if (keywords.equalsIgnoreCase("course")) {
				Long countCourse = courseRepository.countCourse();
				returnMap.put("msg", countCourse);
				returnMap.put("isError", false);
				return returnMap;
			}
			if (keywords.equalsIgnoreCase("fee")) {
				String findSumOfPayment = paymentDetailsRepository.findSumOfPayment();
				returnMap.put("msg", findSumOfPayment);
				returnMap.put("isError", false);
				return returnMap;
			}
			if (keywords.equalsIgnoreCase("teacher")) {
				Long countEmployee = userRepository.countEmployee(3L);
				returnMap.put("msg", countEmployee);
				returnMap.put("isError", false);
				return returnMap;
			}
			if (keywords.equalsIgnoreCase("avlTeacher")) {
				Long countAvlTeacher = userRepository.countAvlTeacher(3L);
				returnMap.put("msg", countAvlTeacher);
				returnMap.put("isError", false);
				return returnMap;
			}
		} catch (Exception e) {
			e.getMessage();
			returnMap.put("msg", "Getting error");
			returnMap.put("isError", false);
			return returnMap;
		}
		return null;
	}
	
	@GetMapping("/getRecentStudents")
	private List<User> getRecentStudents(HttpServletRequest request){
		try {
			Long userId;
			if (request.getAttribute("userId") != null) {
				userId = Long.valueOf(request.getAttribute("userId").toString());
			} else {
				System.out.println(" @@@ user not found of this userId @@@");
				return null;
			}
			return userRepository.getRecentStudents(4L);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@GetMapping("/getProfessors")
	private List<User> getProfessorList(HttpServletRequest request){
		try {
			Long userId;
			if (request.getAttribute("userId") != null) {
				userId = Long.valueOf(request.getAttribute("userId").toString());
			} else {
				System.out.println(" @@@ user not found of this userId @@@");
				return null;
			}
			return userRepository.getProfessorsList(3L);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@GetMapping("/all")
	private List<User> getAllUsers(HttpServletRequest request){
		try {
			Long userId;
			if (request.getAttribute("userId") != null) {
				userId = Long.valueOf(request.getAttribute("userId").toString());
			} else {
				System.out.println(" @@@ user not found of this userId @@@");
				return null;
			}
			return userRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@GetMapping("/allTeacher")
	private List<User> getAllTeacher(HttpServletRequest request){
		try {
			Long userId;
			if (request.getAttribute("userId") != null) {
				userId = Long.valueOf(request.getAttribute("userId").toString());
			} else {
				System.out.println(" @@@ user not found of this userId @@@");
				return null;
			}
			return userRepository.findAllUserByUserType(3L);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@PostMapping("/teacherByCourse")
	private User getTeacherOfCourse(@RequestBody Course c){
		try {
			Long userId;
			Course course = courseRepository.findById(c.getId()).get();
			return userRepository.findById(course.getTeacher()).get();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@GetMapping("/totalStdTechr")
	private HashMap<String, Object> getTotalStudentAndTeacher(){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		try {
			TotalDto totalData = userRepository.totalStudentAndTeacher();
			Long totalCourse = courseRepository.countAllCourse();
			Long totalStudent = totalData.getTotalStudent();
			Long totalTeacher = totalData.getTotalTeacher();
			if (totalCourse==null) { totalCourse=0l; }
			if (totalStudent==null) { totalStudent=0l;	}
			if (totalTeacher==null) { totalTeacher=0l;	}
			returnMap.put("isError", false);
			returnMap.put("totalStudent", totalStudent);
			returnMap.put("totalTeacher", totalTeacher);
			returnMap.put("totalCourse", totalCourse);
			return returnMap;

		} catch (Exception e) {
			e.printStackTrace();
			returnMap.put("isError", true);
			returnMap.put("msg", "Something went wrong on count total data");
			return returnMap;
		}	
	}
	
	@PostMapping("/changePassword")
	private HashMap<String, Object> changePassword(@RequestBody ChangePassword changePassword, HttpServletRequest request){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		try {
			Long userId;
			if (request.getAttribute("userId") != null) {
				userId = Long.valueOf(request.getAttribute("userId").toString());
			} else {
				System.out.println(" @@@ user not found of this userId @@@");
				return null;
			}
			User user = userRepository.findById(userId).get();
			if (!passwordEncoder.matches(changePassword.getOldPassword(), user.getPassword())) {
				returnMap.put("isError", true);
				returnMap.put("msg", "Old password did not matched");
				return returnMap;
			}else {
				user.setPassword(passwordEncoder.encode(changePassword.getNewPassword()));
				userRepository.save(user);
			}
			returnMap.put("isError", false);
			returnMap.put("msg", "Your password has been changed successfully");
			return returnMap;
		} catch (Exception e) {
			e.printStackTrace();
			returnMap.put("isError", true);
			returnMap.put("msg", "Problem in password change operation...");
			return returnMap;
		}
	}
	
	
}
