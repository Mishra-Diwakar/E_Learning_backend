package com.clickncash.service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clickncash.entity.CourseFeature;
import com.clickncash.entity.CourseTopics;
import com.clickncash.entity.MyOrders;
import com.clickncash.entity.PaymentDetails;
import com.clickncash.repository.CourseFeatureRepository;
import com.clickncash.repository.CourseTopicRepository;
import com.clickncash.repository.MyOrdersRepository;
import com.clickncash.repository.PaymentDetailsRepository;
import com.clickncash.utils.ClicknCashUtils;
import com.google.gson.internal.LinkedTreeMap;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

import liquibase.pro.packaged.iF;

@Service
public class CourseService {
	@Autowired
	private CourseFeatureRepository courseFeatureRepository;
	@Autowired
	private CourseTopicRepository courseTopicRepository;

	@Autowired
	private MyOrdersRepository myOrdersRepository;
	
	@Autowired
	private PaymentDetailsRepository paymentDetailsRepository;

	public HashMap<String, Object> saveTopics(String topics, Long userId, Long courseId, boolean isEdit) {
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		try {
			// Use regular expressions to extract key-value pairs
			Pattern pattern = Pattern.compile("\\{([^\\}]+)\\}");
			Matcher matcher = pattern.matcher(topics);

			List<Map<String, String>> hashMapList = new ArrayList<>();

			while (matcher.find()) {
				String keyValuePairs = matcher.group(1);
				String[] pairs = keyValuePairs.split(", ");

				Map<String, String> hashMap = new HashMap<>();

				for (String pair : pairs) {
					String[] keyValue = pair.split("=");
					if (keyValue.length == 2) {
						String key = keyValue[0].trim();
						String value = keyValue[1].trim();
						hashMap.put(key, value);
					}
				}

				hashMapList.add(hashMap);
			}

			// Print the list of HashMaps
			for (Map<String, String> hashMap : hashMapList) {
				CourseTopics topic = new CourseTopics();
				topic.setCourseId(courseId);
				topic.setCreatedAt(new Timestamp(System.currentTimeMillis()));
				topic.setCreatedBy(userId);
				topic.setTopic(hashMap.get("name").toString());
				courseTopicRepository.save(topic);
			}
			returnMap.put("isError", false);
			returnMap.put("msg", "Topic saved");
			return returnMap;
		} catch (Exception e) {
			e.printStackTrace();
			returnMap.put("isError", true);
			returnMap.put("msg", "topic not saved");
			return returnMap;
		}
	}

	public HashMap<String, Object> saveFeatures(String features, Long userId, Long courseId, boolean isEdit) {
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		try {
			// Use regular expressions to extract key-value pairs
			Pattern pattern = Pattern.compile("\\{([^\\}]+)\\}");
			Matcher matcher = pattern.matcher(features);

			List<Map<String, String>> hashMapList = new ArrayList<>();

			while (matcher.find()) {
				String keyValuePairs = matcher.group(1);
				String[] pairs = keyValuePairs.split(", ");

				Map<String, String> hashMap = new HashMap<>();

				for (String pair : pairs) {
					String[] keyValue = pair.split("=");
					if (keyValue.length == 2) {
						String key = keyValue[0].trim();
						String value = keyValue[1].trim();
						hashMap.put(key, value);
					}
				}

				hashMapList.add(hashMap);
			}
			for (Map<String, String> hashMap : hashMapList) {
				CourseFeature feature = new CourseFeature();
				feature.setCourseId(courseId);
				feature.setCreatedAt(new Timestamp(System.currentTimeMillis()));
				feature.setCreatedBy(userId);
				feature.setFeature(hashMap.get("name").toString());
				courseFeatureRepository.save(feature);
			}
			returnMap.put("isError", false);
			returnMap.put("msg", "Features saved");
			return returnMap;
		} catch (Exception e) {
			e.printStackTrace();
			returnMap.put("isError", true);
			returnMap.put("msg", "topic not saved");
			return returnMap;
		}
	}

//	edit topics
	public HashMap<String, Object> editTopics(String topics, Long userId, Long courseId, boolean isEdit) {
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		try {
			// Use regular expressions to extract key-value pairs
			Pattern pattern = Pattern.compile("\\{([^\\}]+)\\}");
			Matcher matcher = pattern.matcher(topics);

			List<Map<String, String>> hashMapList = new ArrayList<>();

			while (matcher.find()) {
				String keyValuePairs = matcher.group(1);
				String[] pairs = keyValuePairs.split(", ");

				Map<String, String> hashMap = new HashMap<>();

				for (String pair : pairs) {
					String[] keyValue = pair.split("=");
					if (keyValue.length == 2) {
						String key = keyValue[0].trim();
						String value = keyValue[1].trim();
						hashMap.put(key, value);
					}
				}

				hashMapList.add(hashMap);
			}
			System.out.println("editTopics: " + hashMapList);

			// Print the list of HashMaps
			for (Map<String, String> hashMap : hashMapList) {
				if (hashMap.containsKey("id")) {
					String getId = String.valueOf(hashMap.get("id"));
					String cId = getId.substring(0, getId.indexOf('.'));
					Long id = Long.parseLong(cId);
					CourseTopics courseTopic = courseTopicRepository.findById(id).get();
					courseTopic.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
					courseTopic.setUpdatedBy(userId);
					courseTopic.setTopic(hashMap.get("topic"));
					courseTopicRepository.save(courseTopic);
				} else {
					CourseTopics topic = new CourseTopics();
					topic.setCourseId(courseId);
					topic.setCreatedAt(new Timestamp(System.currentTimeMillis()));
					topic.setCreatedBy(userId);
					topic.setTopic(hashMap.get("topic").toString());
					courseTopicRepository.save(topic);
				}

			}
			returnMap.put("isError", false);
			returnMap.put("msg", "Topic saved");
			return returnMap;
		} catch (Exception e) {
			e.printStackTrace();
			returnMap.put("isError", true);
			returnMap.put("msg", "topic not saved");
			return returnMap;
		}
	}

	public HashMap<String, Object> editFeatures(String features, Long userId, Long courseId, boolean isEdit) {
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		try {
			// Use regular expressions to extract key-value pairs
			Pattern pattern = Pattern.compile("\\{([^\\}]+)\\}");
			Matcher matcher = pattern.matcher(features);

			List<Map<String, String>> hashMapList = new ArrayList<>();

			while (matcher.find()) {
				String keyValuePairs = matcher.group(1);
				String[] pairs = keyValuePairs.split(", ");

				Map<String, String> hashMap = new HashMap<>();

				for (String pair : pairs) {
					String[] keyValue = pair.split("=");
					if (keyValue.length == 2) {
						String key = keyValue[0].trim();
						String value = keyValue[1].trim();
						hashMap.put(key, value);
					}
				}

				hashMapList.add(hashMap);
			}
			System.out.println(hashMapList);
			for (Map<String, String> hashMap : hashMapList) {
				if (hashMap.containsKey("id")) {
					String getId = String.valueOf(hashMap.get("id"));
					String cId = getId.substring(0, getId.indexOf('.'));
					Long id = Long.parseLong(cId);
					CourseFeature courseFeature = courseFeatureRepository.findById(id).get();
					courseFeature.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
					courseFeature.setUpdatedBy(userId);
					courseFeature.setFeature(hashMap.get("feature"));
					courseFeatureRepository.save(courseFeature);
				} else {
					CourseFeature feature = new CourseFeature();
					feature.setCourseId(courseId);
					feature.setCreatedAt(new Timestamp(System.currentTimeMillis()));
					feature.setCreatedBy(userId);
					feature.setFeature(hashMap.get("feature").toString());
					courseFeatureRepository.save(feature);
				}
			}
			returnMap.put("isError", false);
			returnMap.put("msg", "Features saved");
			return returnMap;
		} catch (Exception e) {
			e.printStackTrace();
			returnMap.put("isError", true);
			returnMap.put("msg", "topic not saved");
			return returnMap;
		}
	}

	public List<CourseTopics> getTopicsForAdmin(Long courseId) {
		try {
			return courseTopicRepository.findByCourseId(courseId);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	public List<CourseFeature> getFeaturesForAdmin(Long courseId) {
		try {
			return courseFeatureRepository.findByCourseId(courseId);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	public String createOrder(Map<String, Object> data, Long userId) {
		try {
			int fee = Integer.parseInt(data.get("fee").toString());
			JSONObject obj = new JSONObject();
			obj.put("amount", fee * 100);
			obj.put("currency", "INR");
			obj.put("receipt", "receipt" + ClicknCashUtils.getRandomString(10));
			RazorpayClient razorpayClient = new RazorpayClient("rzp_test_tkIy3xeU6ndlnP", "wcZ3ataq62PMBqfup2iErIto");
			Order order = razorpayClient.orders.create(obj);
			System.out.println(order.toString());
			String dateString = order.get("created_at").toString();
			SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
			dateFormat.setTimeZone(TimeZone.getTimeZone("IST"));
			Date date;
			long timestamp = 0l;
			try {
				date = dateFormat.parse(dateString);
				timestamp = date.getTime();
			} catch (ParseException e) {
				e.printStackTrace();
			}
			MyOrders myOrders = new MyOrders();
			myOrders.setAmount(Integer.parseInt(order.get("amount").toString()) / 100);
			myOrders.setOrderId(order.get("id"));
			myOrders.setReceiptId(order.get("receipt"));
			myOrders.setStatus("created");
			myOrders.setUserId(userId);
			myOrders.setCreatedAt(new Timestamp(timestamp));
			myOrdersRepository.save(myOrders);
			return order.toString();
		} catch (RazorpayException e) {
			e.getMessage();
		}

		return null;
	}

	public String createPayment(PaymentDetails paymentDetails, Long userId) {
		try {
			paymentDetails.setCreatedAt(new Timestamp(System.currentTimeMillis()));
			paymentDetails.setUserId(userId);
			paymentDetailsRepository.save(paymentDetails);
			return "done";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "failed";
	}
}
