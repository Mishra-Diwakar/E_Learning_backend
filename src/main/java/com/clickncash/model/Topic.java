package com.clickncash.model;

import java.sql.Timestamp;

public class Topic {
	private Timestamp createdAt;
    private Long updatedBy;
    private Long createdBy;
    private String topic;
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
	public Long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
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
	public Topic(Timestamp createdAt, Long updatedBy, Long createdBy, String topic, Long id, Long courseId,
			Timestamp updatedAt) {
		super();
		this.createdAt = createdAt;
		this.updatedBy = updatedBy;
		this.createdBy = createdBy;
		this.topic = topic;
		this.id = id;
		this.courseId = courseId;
		this.updatedAt = updatedAt;
	}
	public Topic() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Topic [createdAt=" + createdAt + ", updatedBy=" + updatedBy + ", createdBy=" + createdBy + ", topic="
				+ topic + ", id=" + id + ", courseId=" + courseId + ", updatedAt=" + updatedAt + "]";
	}
    
    
}
