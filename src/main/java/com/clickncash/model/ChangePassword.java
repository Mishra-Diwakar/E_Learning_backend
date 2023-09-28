package com.clickncash.model;

public class ChangePassword {
	private String newPassword;
	private String oldPassword;
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public ChangePassword(String newPassword, String oldPassword) {
		super();
		this.newPassword = newPassword;
		this.oldPassword = oldPassword;
	}
	public ChangePassword() {
		super();
		// TODO Auto-generated constructor stub
	}
	 

}
