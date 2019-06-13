package com.changepassword.model;

public class ChangePasswordModel {
	private int id;
	private String adminName;
	private String adminPassword;
	private String newPassword;
	private String type;
	
	
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	@Override
	public String toString() {
		return "ChangePasswordModel [id=" + id + ", adminName=" + adminName + ", adminPassword=" + adminPassword
				+ ", type=" + type + "]";
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
