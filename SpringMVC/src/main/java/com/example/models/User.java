package com.example.models;

public class User {

	
	private String username;
	private String password;
	private static final String UPLOAD_DIRECTORY ="/images";
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
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


	public static String getUploadDirectory() {
		return UPLOAD_DIRECTORY;
	}


	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}


	
}
