package com.clickncash.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Queries {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String problem;
	private String email;
	private String contact;
	private Long courseId;
	private Long queryType;
	private String status;
	private Timestamp createdAt;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	public Long getQueryType() {
		return queryType;
	}
	public void setQueryType(Long queryType) {
		this.queryType = queryType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public Queries(Long id, String problem, String email, String contact, Long courseId, Long queryType,
			String status, Timestamp createdAt) {
		super();
		this.id = id;
		this.problem = problem;
		this.email = email;
		this.contact = contact;
		this.courseId = courseId;
		this.queryType = queryType;
		this.status = status;
		this.createdAt = createdAt;
	}
	public Queries() {
		super();
	}
	
	
}
