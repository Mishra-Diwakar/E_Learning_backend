package com.clickncash.model;

public class RatingModal {
	
	private Long id;
	private String name;
	private String teacher;
	private String header;
	private String banner;
	private Long fee;
	private Long rate;
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
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
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
	public Long getFee() {
		return fee;
	}
	public void setFee(Long fee) {
		this.fee = fee;
	}
	public Long getRate() {
		return rate;
	}
	public void setRate(Long rate) {
		this.rate = rate;
	}
	public RatingModal(Long id, String name, String teacher, String header, String banner, Long fee, Long rate) {
		super();
		this.id = id;
		this.name = name;
		this.teacher = teacher;
		this.header = header;
		this.banner = banner;
		this.fee = fee;
		this.rate = rate;
	}
	public RatingModal() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
