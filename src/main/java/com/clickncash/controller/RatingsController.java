package com.clickncash.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clickncash.dto.RatingDto;
import com.clickncash.entity.Course;
import com.clickncash.entity.Ratings;
import com.clickncash.repository.RatingRepository;

@RestController
@RequestMapping("/rest/auth/ratings")
public class RatingsController {
	@Autowired
	private RatingRepository ratingRepository;
	
	@PostMapping("/count")
	private HashMap<String, Object> getRatingsOfCourse(@RequestBody Course course){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		try {
			Long total=0l;
			Long totalRating = 0l;
			Long rate = 0l;
			Map<String, Object> countRating = ratingRepository.countRating(course.getId());
			System.out.println(countRating.get("totalRating"));
			List<RatingDto> ratingDetails = ratingRepository.findLatedRatingDetails(course.getId());
			if (countRating.get("totalRating")!=null) {
				totalRating = Long.valueOf(countRating.get("totalRating").toString());
			}
			if (countRating.get("total")!=null) {
				total = Long.valueOf(countRating.get("total").toString());
			}
			returnMap.put("isError", false);
			returnMap.put("totalRating",(totalRating>0 && total>0)? totalRating/total:0);
			returnMap.put("details",ratingDetails);
			return returnMap;
		}catch (Exception e) {
			e.printStackTrace();
			returnMap.put("isError", true);
			returnMap.put("msg", "error on rating calculation");
			return returnMap;
		}
	}
	
	@PostMapping("/create")
	private HashMap<String, Object> createRating(@RequestBody Ratings ratings, HttpServletRequest request){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		try {
			Long userId = null;
			if (request.getAttribute("userId") != null) {
				userId = Long.valueOf(request.getAttribute("userId").toString());
			} else {
				System.out.println("User not found for this id..");
				return null;
			}
			Ratings rating = ratingRepository.findByUserIdAndCourseId(ratings.getUserId(),ratings.getCourseId());
			if (rating==null) {
				System.out.println("create new rating");
				ratings.setUserId(userId);
				ratings.setCreatedAt(new Timestamp(System.currentTimeMillis()));
				ratingRepository.save(ratings);
			}else {
				System.out.println("upate existing rating");
				rating.setDescription(ratings.getDescription());
				rating.setRate(ratings.getRate());
				rating.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
				ratingRepository.save(rating);
			}
			returnMap.put("isError", false);
			returnMap.put("msg", "Thank you for review");
			return returnMap;
		}catch (Exception e) {
			e.printStackTrace();
			returnMap.put("isError", true);
			returnMap.put("msg", "error on rating creation");
			return returnMap;
		}
	}
	
	@GetMapping("/testimonial")
	private List<RatingDto> getRecentRating(){
		try {
			return ratingRepository.getRecentRating();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
