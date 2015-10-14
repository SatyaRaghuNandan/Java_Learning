package com.prakash.hibernate.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity (name="UserDetails")
public class UserDetails {
	@Id 	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name="User_Id")
	private int userId;
	
	@Column (name = "User_Name")
	private String userName;
	
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
