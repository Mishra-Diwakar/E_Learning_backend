package com.clickncash.model;

import java.sql.Timestamp;

public class Feature {
	private Timestamp createdAt;
    private Long updatedBy;
    private String feature;
    private Long createdBy;
    private Long id;
    private Long courseId;
    private Timestamp updatedAt;
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public Long getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getFeature() {
		return feature;
	}
	public void setFeature(String feature) {
		this.feature = feature;
	}
	public Long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Feature(Timestamp createdAt, Long updatedBy, String feature, Long createdBy, Long id, Long courseId,
			Timestamp updatedAt) {
		super();
		this.createdAt = createdAt;
		this.updatedBy = updatedBy;
		this.feature = feature;
		this.createdBy = createdBy;
		this.id = id;
		this.courseId = courseId;
		this.updatedAt = updatedAt;
	}
	public Feature() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
