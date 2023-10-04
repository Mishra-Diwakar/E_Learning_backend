package com.clickncash.controller;

import java.io.Console;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cashfree.lib.json.Json;
import com.cashfree.lib.json.JsonValue;
import com.clickncash.ImageUploader.Images;
import com.clickncash.dto.CourseDto;
import com.clickncash.dto.PurchasedDto;
import com.clickncash.entity.Course;
import com.clickncash.entity.CourseFeature;
import com.clickncash.entity.CourseTopics;
import com.clickncash.entity.Queries;
import com.clickncash.entity.Videos;
import com.clickncash.model.Data;
import com.clickncash.model.Feature;
import com.clickncash.model.PurchasedCourseStudent;
import com.clickncash.model.RatingModal;
import com.clickncash.model.Topic;
import com.clickncash.repository.CourseRepository;
import com.clickncash.repository.PurchasedCourseRepository;
import com.clickncash.repository.QueriesRepository;
import com.clickncash.repository.RatingRepository;
import com.clickncash.repository.VideosRepository;
import com.clickncash.service.CourseService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.internal.LinkedTreeMap;

import liquibase.pro.packaged.iF;

@RestController
@RequestMapping("/rest/auth/course")
public class CourseController {

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	Images imageUploader;
	
	@Autowired
	private VideosRepository videosRepository;
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private PurchasedCourseRepository purchasedCourseRepository;
	
	@Autowired
	private RatingRepository ratingRepository;
	
	@Autowired
	private QueriesRepository queriesRepository;

	@PostMapping(path = "/create", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public HashMap<String, Object> uploadCourse(@RequestParam MultipartFile file, @RequestParam String name,
			@RequestParam("header") String header, @RequestParam("startDate") String startDate,
			@RequestParam("startTime") String startTime, @RequestParam("fee") Long fee,
			@RequestParam("duration") String duration, @RequestParam("description") String description,
			@RequestParam("teacher") Long teacher, HttpServletRequest request) {
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		try {
			Long userId = null;
			if (request.getAttribute("userId") != null) {
				userId = Long.valueOf(request.getAttribute("userId").toString());
			} else {
				returnMap.put("isError", false);
				returnMap.put("msg", "User not found : " + userId);
				System.out.println(" @@@ user not found of this userId @@@");
				return returnMap;
			}

			String uploadFile = imageUploader.uploadCourseBanner(file);
			if (uploadFile.equalsIgnoreCase("uploaded")) {
				Course course = new Course();
				course.setName(name);
				course.setHeader(header);
				course.setDescription(description);
				course.setFee(fee);
				course.setStartDate(startDate);
				course.setDuration(duration);
				course.setBanner(file.getOriginalFilename());
				course.setCreatedBy(userId);
				course.setCreatedAt(new Timestamp(System.currentTimeMillis()));
				course.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
				course.setUpdatedBy(userId);
				course.setStartTime(startTime);
				course.setTeacher(teacher);
				courseRepository.save(course);
				returnMap.put("isError", false);
				returnMap.put("msg", "Course created..");
				return returnMap;
			} else if (uploadFile.equalsIgnoreCase("not image")) {
				returnMap.put("isError", true);
				returnMap.put("msg", "File is not image");
				return returnMap;
			} else if (uploadFile.equalsIgnoreCase("not uploaded")) {
				returnMap.put("isError", true);
				returnMap.put("msg", "card image not uploaded ");
				return returnMap;
			} else {
				returnMap.put("isError", true);
				returnMap.put("msg", "Error on file uplaoding.. ");
				return returnMap;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			returnMap.put("isError", true);
			returnMap.put("msg", "Error on file uplaoding ");
			return returnMap;
		}
	}

	@GetMapping("/all")
	public List<Course> coureList(HttpServletRequest request) {
		try {
			Long userId = null;
			if (request.getAttribute("userId") != null) {
				userId = Long.valueOf(request.getAttribute("userId").toString());
			} else {
				System.out.println(" @@@ user not found of this userId @@@");
				return null;
			}
			return courseRepository.findAll();
		} catch (Exception e) {
			System.out.println("Getting error for fetching all course list..");
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping("/list")
	private List<CourseDto> getCourses() {
		return courseRepository.findList();
	}
	@GetMapping("/live")
	private List<CourseDto> getLiveCourses() {
//		List<CourseDto> findLiveCourses = courseRepository.findLiveCourses();
//		findLiveCourses.forEach(e->{
//			System.out.println("banner: "+e.getBanner()+", "+e.getTeacher()+", "+e.getId()+", "+e.getName()+", "+e.getFee());
//		});
		try {
			return courseRepository.findLiveCourses();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@GetMapping("/upcoming")
	private List<CourseDto> getUpcomingCourses() {
		return courseRepository.findUpcomingCourses();
	}

	@PostMapping("/getOne")
	private Course getOneCourse(@RequestBody Course course) {
		return courseRepository.findById(course.getId()).get();
	}

	@PostMapping("/delete")
	private HashMap<String, Object> deleteCourse(@RequestBody Course course, HttpServletRequest request) {
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		try {
			Long userId = null;
			if (request.getAttribute("userId") != null) {
				userId = Long.valueOf(request.getAttribute("userId").toString());

			} else {
				System.out.println(" @@@ user not found of this userId @@@");
				returnMap.put("isError", true);
				returnMap.put("msg", "User not found for this is: " + userId);
				return returnMap;
			}
			courseRepository.deleteById(course.getId());
			System.out.println("comes for course delete");
			returnMap.put("isError", false);
			returnMap.put("msg", "Course deleted");
			return returnMap;
		} catch (Exception e) {
			// TODO: handle exception
			returnMap.put("isError", true);
			returnMap.put("msg", "Error on delte course.");
			return returnMap;
		}
	}

	@PostMapping("/get")
	private Course getCourse(@RequestBody Course course, HttpServletRequest request) {
		try {
			Long userId = null;
			if (request.getAttribute("userId") != null) {
				userId = Long.valueOf(request.getAttribute("userId").toString());
			} else {
				System.out.println(" @@@ user not found of this userId @@@");
				return null;
			}
			return courseRepository.findById(course.getId()).get();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Error on getting one course");
			return null;
		}
	}

	@PostMapping(path = "/updateWithFile", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	private HashMap<String, Object> updateCourse(@RequestParam MultipartFile file, @RequestParam String name,
			@RequestParam("header") String header, @RequestParam("startDate") String startDate,
			@RequestParam("startTime") String startTime, @RequestParam("fee") Long fee,
			@RequestParam("duration") String duration, @RequestParam("description") String description,
			@RequestParam("id") Long id,@RequestParam("prevFileName") String prevFileName ,HttpServletRequest request) {
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		try {
			Long userId = null;
			if (request.getAttribute("userId") != null) {
				userId = Long.valueOf(request.getAttribute("userId").toString());
			} else {
				System.out.println(" @@@ user not found of this userId @@@");
				return null;
			}
			
			String upload = imageUploader.uploadCourseBanner(file);
			if (upload.equalsIgnoreCase("uploaded")) {
				String deleted = imageUploader.deleteCourseBanner(prevFileName);
				if (deleted.equalsIgnoreCase("deleted")) {
					Course course = courseRepository.findById(id).get();
					course.setName(name);
					course.setHeader(header);
					course.setDescription(description);
					course.setFee(fee);
					course.setStartDate(startDate);
					course.setStartTime(startTime);
					course.setDuration(duration);
					course.setBanner(file.getOriginalFilename());
					course.setUpdatedBy(userId);
					course.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
					courseRepository.save(course);
					returnMap.put("isError", false);
					returnMap.put("msg", "Course has been updated");
					return returnMap;
				}else if (deleted.equalsIgnoreCase("not deleted")) {
					returnMap.put("isError", true);
					returnMap.put("msg", "previous file not deleted");
					return returnMap;
				}else if (deleted.equalsIgnoreCase("not found")) {
					returnMap.put("isError", true);
					returnMap.put("msg", "given file not found");
					return returnMap;
				}
			}
			returnMap.put("isError", true);
			returnMap.put("msg", "file not uplaoded");
			return returnMap;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			returnMap.put("isError", true);
			returnMap.put("msg", "file not uplaoded : error");
			return returnMap;
		}
	}

	@PostMapping(path = "/updateWithoutFile", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	private HashMap<String, Object> updateCourseWithoutFile(@RequestParam String name,
			@RequestParam("header") String header, @RequestParam("startDate") String startDate,
			@RequestParam("startTime") String startTime, @RequestParam("fee") Long fee,
			@RequestParam("duration") String duration, @RequestParam("description") String description,
			@RequestParam("id") Long id, HttpServletRequest request) {
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		try {
			Long userId = null;
			if (request.getAttribute("userId") != null) {
				userId = Long.valueOf(request.getAttribute("userId").toString());
			} else {
				System.out.println(" @@@ user not found of this userId @@@");
				return null;
			}
			Course course = courseRepository.findById(id).get();
			course.setName(name);
			course.setHeader(header);
			course.setDescription(description);
			course.setFee(fee);
			course.setStartDate(startDate);
			course.setStartTime(startTime);
			course.setDuration(duration);
			course.setUpdatedBy(userId);
			course.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
			courseRepository.save(course);
			returnMap.put("isError", false);
			returnMap.put("msg", "Course has been updated");
			return returnMap;
		} catch (Exception e) {
			// TODO: handle exception
			returnMap.put("isError", false);
			returnMap.put("msg", "Course not updated");
			return returnMap;
		}
	}
	
	@PostMapping("/saveDetails")
	private HashMap<String, Object> addCourseDetails(@RequestBody String details, HttpServletRequest request){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		try {
			Long userId = null;
			if (request.getAttribute("userId") != null) {
				userId = Long.valueOf(request.getAttribute("userId").toString());
			} else {
				System.out.println(" @@@ user not found of this userId @@@");
				returnMap.put("isError", true);
				returnMap.put("msg", "User not found of this Id:"+userId);
				return returnMap;
			}
			HashMap<String, Object> requestMap = new Gson().fromJson(details, HashMap.class);
			System.out.println(requestMap);
			
			String getId = String.valueOf(requestMap.get("courseId"));
			String cId = getId.substring(0, getId.indexOf('.'));
			Long courseId = Long.parseLong(cId);
			
			String topics = requestMap.get("TOPICS").toString();
			String features = requestMap.get("FEATURES").toString();
			System.out.println("topics: "+topics);
			courseService.saveTopics(topics, userId,courseId ,false);
			courseService.saveFeatures(features, userId,courseId ,false);

			returnMap.put("isError", false);
			returnMap.put("msg", "details added");
			return returnMap;
		} catch (Exception e) {
			// TODO: handle exception
			returnMap.put("isError", true);
			returnMap.put("msg", "details not added....");
			return returnMap;
		}

	}
	
	@PostMapping("/topicsAdmin")
	List<CourseTopics> getTopicList(@RequestBody CourseTopics topics,HttpServletRequest request){
		try {
			Long userId = null;
			if (request.getAttribute("userId") != null) {
				userId = Long.valueOf(request.getAttribute("userId").toString());
			} else {
				System.out.println(" @@@ user not found of this userId @@@");
				return null;
			}
			return courseService.getTopicsForAdmin(topics.getCourseId());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("getting exception on topics list for admin");
			return null;
		}
	}
	
	@PostMapping("/featuresAdmin")
	List<CourseFeature> getFeatureList(@RequestBody CourseFeature features ,HttpServletRequest request){
		try {
			Long userId = null;
			if (request.getAttribute("userId") != null) {
				userId = Long.valueOf(request.getAttribute("userId").toString());
			} else {
				System.out.println(" @@@ user not found of this userId @@@");
				return null;
			}
			return courseService.getFeaturesForAdmin(features.getCourseId());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("getting exception on feature list for admin");
			return null;
		}
	}
	
	@PostMapping("/editDetails")
	private HashMap<String, Object> editCourseDetails(@RequestBody String details, HttpServletRequest request){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		try {
			Gson gson = new Gson();
			Long userId = null;
			if (request.getAttribute("userId") != null) {
				userId = Long.valueOf(request.getAttribute("userId").toString());
			} else {
				System.out.println(" @@@ user not found of this userId @@@");
				returnMap.put("isError", true);
				returnMap.put("msg", "User not found of this Id:"+userId);
				return returnMap;
			}
			HashMap<String, Object> requestMap = new Gson().fromJson(details, HashMap.class);
			System.out.println(requestMap);
			
			String getId = String.valueOf(requestMap.get("courseId"));
			String cId = getId.substring(0, getId.indexOf('.'));
			Long courseId = Long.parseLong(cId);
	       
			String topics = requestMap.get("TOPICS").toString();			
			String features = requestMap.get("FEATURES").toString();
			courseService.editTopics(topics, userId,courseId ,true);
			courseService.editFeatures(features, userId,courseId ,true);
	
			
			System.out.println("comes for edit course details");
			returnMap.put("isError", false);
			returnMap.put("msg", "details updated");
			return returnMap;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			returnMap.put("isError", true);
			returnMap.put("msg", "details not updated....");
			return returnMap;
		}

	}
	
	@PostMapping("/getTopics")
	private List<CourseTopics> getTopics(@RequestBody CourseTopics topics){
		return courseService.getTopicsForAdmin(topics.getCourseId());
	}
	
	@PostMapping("/getFeatures")
	private List<CourseFeature> getFeatures(@RequestBody CourseFeature features){
		return courseService.getFeaturesForAdmin(features.getCourseId());
	}
	
	@PostMapping("/uploadVideo")
	private HashMap<String, Object> uploadVideo(@RequestParam MultipartFile file, @RequestParam MultipartFile bannerImage ,@RequestParam("playList") Long playlist,
			@RequestParam("title") String title,@RequestParam("duration") int duration,
			@RequestParam String teacher, HttpServletRequest request ){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		try {
			Long userId = null;
			if (request.getAttribute("userId") != null) {
				userId = Long.valueOf(request.getAttribute("userId").toString());
			} else {
				System.out.println(" @@@ user not found of this userId @@@");
				returnMap.put("isError", true);
				returnMap.put("msg", "user not found for this id");
				return returnMap;
			}
			System.out.println("comes for uploadVideo");
			String contentType = bannerImage.getContentType();
			String videoExtension = StringUtils.getFilenameExtension(file.getOriginalFilename());
			String bannerExtension = StringUtils.getFilenameExtension(bannerImage.getOriginalFilename());

			String uploadVideo = imageUploader.uploadFile(file);
			String uploadBanner = imageUploader.uploadFile(bannerImage);
			Date d = new Date(duration * 1000L);
			SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss"); // HH for 0-23
			df.setTimeZone(TimeZone.getTimeZone("GMT"));
			String time = df.format(d);
			if (uploadVideo.equalsIgnoreCase("uploaded") && uploadBanner.equalsIgnoreCase("uploaded")) {
				Videos videos = new Videos();
				videos.setPlayList(playlist);
				videos.setTitle(title);
				videos.setBanner(bannerImage.getOriginalFilename());
				videos.setUploadedAt(new Timestamp(System.currentTimeMillis()));
				videos.setUploadedBy(userId);
				videos.setDuration(time);
				videos.setBannerExtension(bannerExtension);
				videos.setVideoExtension(videoExtension);
				videos.setVideo(file.getOriginalFilename());
				videos.setTeacher(teacher);
				videosRepository.save(videos);
				returnMap.put("isError", false);
				returnMap.put("msg", "video uploaded");
				return returnMap;
			}else {
				returnMap.put("isError", true);
				returnMap.put("msg", "video not uploaded");
				return returnMap;
			}	
			
		} catch (Exception e) {
			e.printStackTrace();
			returnMap.put("isError", true);
			returnMap.put("msg", "error on video uploading");
			return returnMap;
		}
	}
	
	@GetMapping("allPlaylist")
	private List<CourseDto> getPlayList(HttpServletRequest request){
		try {
			Long userId = null;
			if (request.getAttribute("userId") != null) {
				userId = Long.valueOf(request.getAttribute("userId").toString());
			} else {
				System.out.println(" @@@ user not found of this userId @@@");
				return null;
			}
			return videosRepository.findAllPlayList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	@PostMapping("allVideos")
	private List<Videos> getAllVideosByPlayList(@RequestBody Videos video ,HttpServletRequest request){
		try {
			Long userId = null;
			if (request.getAttribute("userId") != null) {
				userId = Long.valueOf(request.getAttribute("userId").toString());
			} else {
				System.out.println(" @@@ user not found of this userId @@@");
				return null;
			}
			return videosRepository.findAllByPlayList(video.getPlayList());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	@PostMapping("/updateVideoCard")
	private HashMap<String, Object> updateVideoCard(@RequestParam MultipartFile file, @RequestParam Long id, HttpServletRequest request){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		try {
			Long userId = null;
			if (request.getAttribute("userId") != null) {
				userId = Long.valueOf(request.getAttribute("userId").toString());
			} else {
				returnMap.put("msg", "User not found for this userId");
				returnMap.put("isError", true);
				return returnMap;
			}
			Videos videos = videosRepository.findById(id).get();
			if(imageUploader.deleteFile(videos.getBanner())) {
				String uploadFile = imageUploader.uploadFile(file);
				if (uploadFile.equalsIgnoreCase("uploaded")) {
					String bannerExtension = StringUtils.getFilenameExtension(file.getOriginalFilename());
					videos.setBanner(file.getOriginalFilename());
					videos.setBannerExtension(bannerExtension);
					videosRepository.save(videos);
				}
			}
			returnMap.put("msg", "Video card upadated");
			returnMap.put("isError", false);
			return returnMap;
		} catch (Exception e) {
			e.printStackTrace();
			returnMap.put("msg", "Video Card not updated");
			returnMap.put("isError", true);
			return returnMap;
		}
	}
	@PostMapping("/updateVideo")
	private HashMap<String, Object> updateVideo(@RequestParam MultipartFile file, @RequestParam Long id, HttpServletRequest request){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		try {
			Long userId = null;
			if (request.getAttribute("userId") != null) {
				userId = Long.valueOf(request.getAttribute("userId").toString());
			} else {
				returnMap.put("msg", "User not found for this userId");
				returnMap.put("isError", true);
				return returnMap;
			}
			Videos videos = videosRepository.findById(id).get();
			if(imageUploader.deleteFile(videos.getTitle())) {
				String uploadFile = imageUploader.uploadFile(file);
				if (uploadFile.equalsIgnoreCase("uploaded")) {
					String videoExtension = StringUtils.getFilenameExtension(file.getOriginalFilename());
					videos.setTitle(file.getOriginalFilename());
					videos.setVideoExtension(videoExtension);
					videosRepository.save(videos);
				}
			}
			returnMap.put("msg", "Video upadated");
			returnMap.put("isError", false);
			return returnMap;
		} catch (Exception e) {
			e.printStackTrace();
			returnMap.put("msg", "Video not updated");
			returnMap.put("isError", true);
			return returnMap;
		}
	}
	@PostMapping("/deleteVideo")
	private HashMap<String, Object> deleteVideo(@RequestBody Videos videos, HttpServletRequest request){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		try {
			Long userId = null;
			if (request.getAttribute("userId") != null) {
				userId = Long.valueOf(request.getAttribute("userId").toString());
			} else {
				returnMap.put("msg", "User not found for this userId");
				returnMap.put("isError", true);
				return returnMap;
			}
//			deleting card and video file
			if (imageUploader.deleteFile(videos.getBanner())) {
				if(imageUploader.deleteFile(videos.getVideo())) {
					videosRepository.deleteById(videos.getId());
					returnMap.put("msg", "Video has been deleted");
					returnMap.put("isError", false);
					return returnMap;
				}
				returnMap.put("msg", "Video card has been not deleted");
				returnMap.put("isError", true);
				return returnMap;
			}
			
			returnMap.put("msg", "Video not deleted");
			returnMap.put("isError", true);
			return returnMap;
		} catch (Exception e) {
			e.printStackTrace();
			returnMap.put("msg", "Error in video deletion");
			returnMap.put("isError", true);
			return returnMap;
		}
	}
	
	@GetMapping("/purchased")
	private List<PurchasedDto> getPurchasedCourseListByStudent(HttpServletRequest request){
		try {
			Long userId = null;
			if (request.getAttribute("userId") != null) {
				userId = Long.valueOf(request.getAttribute("userId").toString());
			} else {
				System.out.println("User not found for this id..");
				return null;
			}	
			return courseRepository.findPurchasedCourseByUserId(userId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@PostMapping("/myVideos")
	private List<Videos> getMyVideos(@RequestBody Videos videos, HttpServletRequest request){
		try {
			Long userId = null;
			if (request.getAttribute("userId") != null) {
				userId = Long.valueOf(request.getAttribute("userId").toString());
			} else {
				System.out.println("User not found for this id..");
				return null;
			}	
			return videosRepository.findAllByPlayList(videos.getPlayList());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	

	@PostMapping("/totalEnroll")
	private HashMap<String, Object> totalEnrollStudent(@RequestBody Course course) {
		Long countTotalEnrolled = purchasedCourseRepository.countTotalEnrolled(course.getId());
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("total", countTotalEnrolled);		
		return returnMap;
	}
	
	@PostMapping("/search")
	private List<RatingModal> searchCourse(@RequestBody Course course) {
		try {
			List<RatingModal> ratingModals = new ArrayList<RatingModal>();
			List<CourseDto> searchCourse = courseRepository.searchCourse(course.getName());
			searchCourse.forEach(e->{
				Long rate = ratingRepository.countByCourseId(e.getId());
				if (rate==null) {
					rate = 0L;
				}
			 	ratingModals.add(new RatingModal(e.getId(), e.getName(), e.getTeacher(), e.getHeader(),e.getBanner(), e.getFee(),rate));
			 	});
			return ratingModals;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}	
	}
	
	@PostMapping("/addQuery")
	private HashMap<String, Object> getInTouch(@RequestBody Queries queries){
		HashMap<String, Object> returnMap= new HashMap<String, Object>();
		try {
			Long count = queriesRepository.countTodayQueryByEmail(queries.getEmail());
			if(count>=3) {
				returnMap.put("isError", true);
				returnMap.put("msg", "Only 3 query allowed in a single day");
				return returnMap;
			}
			queries.setStatus("created");
			queries.setCreatedAt(new Timestamp(System.currentTimeMillis()));
			queriesRepository.save(queries);
			returnMap.put("isError", false);
			returnMap.put("msg", "Your query has been accepted \nTeam will contact you soon");
			return returnMap;
		} catch (Exception e) {
			e.printStackTrace();
			returnMap.put("isError", true);
			returnMap.put("msg", "Query not added");
			return returnMap;
		}
		
	}
	
	@PostMapping("/solveQuery")
	private HashMap<String,Object> solveQuery(@RequestBody Queries q, HttpServletRequest request){
		HashMap<String,Object> returnMap = new HashMap<String,Object>();
		try {
			Long userId = null;
			if (request.getAttribute("userId") != null) {
				userId = Long.valueOf(request.getAttribute("userId").toString());
			} else {
				System.out.println("User not found for this id..");
				return null;
			}	
			Queries queries = queriesRepository.findById(q.getId()).get();
			queries.setStatus("solved");
			queriesRepository.save(queries);
			returnMap.put("isError", false);
			returnMap.put("msg", "Query resolved");
			return returnMap;
		} catch (Exception e) {
			e.printStackTrace();
			returnMap.put("isError", true);
			returnMap.put("msg", "Query not resolved");
			return returnMap;
		}
	}
}
