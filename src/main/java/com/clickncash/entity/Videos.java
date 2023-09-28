package com.clickncash.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Videos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long playList; 	//courseId
	private String title;
	private String banner;
	private Timestamp uploadedAt;
	private Long uploadedBy;
	private String duration;
	private String videoExtension;
	private String bannerExtension;
	private String video;
	private String teacher;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getPlayList() {
		return playList;
	}
	public void setPlayList(Long playList) {
		this.playList = playList;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBanner() {
		return banner;
	}
	public void setBanner(String banner) {
		this.banner = banner;
	}
	public Timestamp getUploadedAt() {
		return uploadedAt;
	}
	public void setUploadedAt(Timestamp uploadedAt) {
		this.uploadedAt = uploadedAt;
	}
	public Long getUploadedBy() {
		return uploadedBy;
	}
	public void setUploadedBy(Long uploadedBy) {
		this.uploadedBy = uploadedBy;
	}
	
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	public String getVideoExtension() {
		return videoExtension;
	}
	public void setVideoExtension(String videoExtension) {
		this.videoExtension = videoExtension;
	}
	public String getBannerExtension() {
		return bannerExtension;
	}
	public void setBannerExtension(String bannerExtension) {
		this.bannerExtension = bannerExtension;
	}
	
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public Videos(Long id, Long playList, String title, String banner, Timestamp uploadedAt, Long uploadedBy,
			String duration, String videoExtension, String bannerExtension, String video, String teacher) {
		super();
		this.id = id;
		this.playList = playList;
		this.title = title;
		this.banner = banner;
		this.uploadedAt = uploadedAt;
		this.uploadedBy = uploadedBy;
		this.duration = duration;
		this.videoExtension = videoExtension;
		this.bannerExtension = bannerExtension;
		this.video = video;
		this.teacher = teacher;
	}
	public Videos() {
		super();
	}
	@Override
	public String toString() {
		return "Videos [id=" + id + ", playList=" + playList + ", title=" + title + ", uploadedAt=" + uploadedAt
				+ ", uploadedBy=" + uploadedBy + ", duration=" + duration + "]";
	}

	
}
