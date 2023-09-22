package com.clickncash.model;

public class UserRequest {

	private String fullName;
	private String userName;
	private String mobile;
	private String email;
	private String shop;
	private String aadhar;
	private String pancard;
	private String password;
	private String address;
	private String state;
	private String pincode;
	private String city;
	private Long userType;
	private Long parentId;
	private String dob;
	
	
	
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		parentId = parentId;
	}
	public UserRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserRequest(String fullName, String userName, String mobile, String email, String shop, String aadhar,
			String pancard, String password, String address, String state, String pincode, String city, Long userType) {
		super();
		this.fullName = fullName;
		this.userName = userName;
		this.mobile = mobile;
		this.email = email;
		this.shop = shop;
		this.aadhar = aadhar;
		this.pancard = pancard;
		this.password = password;
		this.address = address;
		this.state = state;
		this.pincode = pincode;
		this.city = city;
		this.userType = userType;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getShop() {
		return shop;
	}
	public void setShop(String shop) {
		this.shop = shop;
	}
	public String getAadhar() {
		return aadhar;
	}
	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}
	public String getPancard() {
		return pancard;
	}
	public void setPancard(String pancard) {
		this.pancard = pancard;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Long getUserType() {
		return userType;
	}
	public void setUserType(Long userType) {
		this.userType = userType;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	@Override
	public String toString() {
		return "UserRequest [fullName=" + fullName + ", userName=" + userName + ", mobile=" + mobile + ", email="
				+ email + ", shop=" + shop + ", aadhar=" + aadhar + ", pancard=" + pancard + ", password=" + password
				+ ", address=" + address + ", state=" + state + ", pincode=" + pincode + ", city=" + city
				+ ", userType=" + userType + ", parentId=" + parentId + "]";
	}
	
	
		
	
}
