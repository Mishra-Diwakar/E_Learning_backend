package com.clickncash.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PurchasedCourse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long userId;
	private Long courseId;
	private Timestamp enrolledAt;
	private Timestamp validTill;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	public Timestamp getEnrolledAt() {
		return enrolledAt;
	}
	public void setEnrolledAt(Timestamp enrolledAt) {
		this.enrolledAt = enrolledAt;
	}
	public Timestamp getValidTill() {
		return validTill;
	}
	public void setValidTill(Timestamp validTill) {
		this.validTill = validTill;
	}
	public PurchasedCourse(Long id, Long userId, Long courseId, Timestamp enrolledAt, Timestamp validTill) {
		super();
		this.id = id;
		this.userId = userId;
		this.courseId = courseId;
		this.enrolledAt = enrolledAt;
		this.validTill = validTill;
	}
	public PurchasedCourse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
