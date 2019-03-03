package com.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

public class UserModel {
	
	private String username;
	
	private String userid;
	private String email;
	
	@JsonIgnore
	@JsonSetter
	private String password;
	
	
	public UserModel() {
		super();
	}

	public UserModel(String username, String password, String userid, String email) {
		super();
		this.username = username;
		this.password = password;
		this.userid = userid;
		this.email = email;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
