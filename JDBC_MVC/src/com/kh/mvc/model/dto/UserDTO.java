package com.kh.mvc.model.dto;

import java.sql.Date;

public class UserDTO {
	private int userNo;
	private String userId;
	private String userPw;
	private String userName;
	private Date enrollDate;
	private String newUserPw;
	
	public UserDTO() {
		super();
	}
	
	public UserDTO(int userNo, String userId, String userPw, String userName, Date enrollDate, String newUserPw) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.enrollDate = enrollDate;
		this.newUserPw = newUserPw;
	}
	
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getNewUserPw() {
		return newUserPw;
	}

	public void setNewUserPw(String newUserPw) {
		this.newUserPw = newUserPw;
	}
	
	@Override
	public String toString() {
		return "UserDTO [userNo=" + userNo + ", userId=" + userId + ", userPw=" + userPw + ", userName=" + userName
				+ ", enrollDate=" + enrollDate + ", newUserPw=" + newUserPw + "]";
	}

	

	
	
	
	
	
}
