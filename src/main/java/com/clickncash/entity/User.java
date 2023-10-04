package com.clickncash.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.datical.liquibase.ext.storedlogic.trigger.postgres.PostgresTriggerSnapshotGenerator;

@Entity
@Table(name = "User")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String lastName;
	private String username;
	private String gender;
	private String email;
	private String password;
	private String mobile;
	private String dob;
	private String pincode;
	private Long userType;
	private String district;
	private String state;
	private boolean status;
	private String aadhar;
	private String postOffice;
	private String policeStation;
	private Timestamp createdAt;
	private Long createdBy;
	private Timestamp updatedAt;
	private Long updatedBy;
	private Timestamp loginAt;
	private String qualification;
	private Integer otpNum;
	private Timestamp otpSentAt;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public Long getUserType() {
		return userType;
	}
	public void setUserType(Long userType) {
		this.userType = userType;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getAadhar() {
		return aadhar;
	}
	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}
	public String getPostOffice() {
		return postOffice;
	}
	public void setPostOffice(String postOffice) {
		this.postOffice = postOffice;
	}
	public String getPoliceStation() {
		return policeStation;
	}
	public void setPoliceStation(String policeStation) {
		this.policeStation = policeStation;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public Long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Long getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Timestamp getLoginAt() {
		return loginAt;
	}
	public void setLoginAt(Timestamp loginAt) {
		this.loginAt = loginAt;
	}
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}

	
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public Integer getOtpNum() {
		return otpNum;
	}
	public void setOtpNum(Integer otpNum) {
		this.otpNum = otpNum;
	}
	
	public Timestamp getOtpSentAt() {
		return otpSentAt;
	}
	public void setOtpSentAt(Timestamp otpSentAt) {
		this.otpSentAt = otpSentAt;
	}
	public User(Long id, String firstName, String lastName, String username, String gender, String email,
			String password, String mobile, String dob, String pincode, Long userType, String district, String state,
			boolean status, String aadhar, String postOffice, String policeStation, Timestamp createdAt, Long createdBy,
			Timestamp updatedAt, Long updatedBy, Timestamp loginAt, String qualification, Integer otpNum,
			Timestamp otpSentAt) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.dob = dob;
		this.pincode = pincode;
		this.userType = userType;
		this.district = district;
		this.state = state;
		this.status = status;
		this.aadhar = aadhar;
		this.postOffice = postOffice;
		this.policeStation = policeStation;
		this.createdAt = createdAt;
		this.createdBy = createdBy;
		this.updatedAt = updatedAt;
		this.updatedBy = updatedBy;
		this.loginAt = loginAt;
		this.qualification = qualification;
		this.otpNum = otpNum;
		this.otpSentAt = otpSentAt;
	}
	public User() {
		super();
	}
	
	
}
