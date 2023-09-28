package com.clickncash.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.datical.liquibase.ext.checks.config.cli.StringGetter;

@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private Long fee;
	private Long createdBy;
	private Long updatedBy;
	private String startDate;
	private String startTime;
	private Timestamp createdAt;
	private String duration;
	private String header;
	private String banner;
	private Timestamp updatedAt;
	private Long teacher;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getFee() {
		return fee;
	}
	public void setFee(Long fee) {
		this.fee = fee;
	}
	public Long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	public Long getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	
	public String getBanner() {
		return banner;
	}
	public void setBanner(String banner) {
		this.banner = banner;
	}
	
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	public Long getTeacher() {
		return teacher;
	}
	public void setTeacher(Long teacher) {
		this.teacher = teacher;
	}
	public Course(Long id, String name, String description, Long fee, Long createdBy, Long updatedBy, String startDate,
			String startTime, Timestamp createdAt, String duration,String header, String banner, Timestamp updatedAt,
			Long teacher) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.fee = fee;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.startDate = startDate;
		this.startTime = startTime;
		this.createdAt = createdAt;
		this.duration = duration;
		this.header = header;
		this.banner = banner;
		this.updatedAt = updatedAt;
		this.teacher = teacher;
	}
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", description=" + description + ", fee=" + fee + ", createdBy="
				+ createdBy + ", updatedBy=" + updatedBy + ", startDate=" + startDate + ", startTime=" + startTime
				+ ", createdAt=" + createdAt + ", duration=" + duration + "]";
	}
	
	
	
}
