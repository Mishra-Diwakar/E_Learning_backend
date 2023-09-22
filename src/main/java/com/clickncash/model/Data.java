package com.clickncash.model;

import java.util.List;

public class Data {
	private List<Topic> TOPICS;
	private int courseId;
	private List<Feature> FEATURES;
	public List<Topic> getTOPICS() {
		return TOPICS;
	}
	public void setTOPICS(List<Topic> tOPICS) {
		TOPICS = tOPICS;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public List<Feature> getFEATURES() {
		return FEATURES;
	}
	public void setFEATURES(List<Feature> fEATURES) {
		FEATURES = fEATURES;
	}
	public Data(List<Topic> tOPICS, int courseId, List<Feature> fEATURES) {
		super();
		TOPICS = tOPICS;
		this.courseId = courseId;
		FEATURES = fEATURES;
	}
	public Data() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
