package com.lafite.entity;

import java.util.Date;

public class User {
	private Long USER_ID;
	private String USER_REALNAME;
	private String USER_HEADIMG;
	private String USER_SEX;
	private String USER_NAME;
	private String USER_PASSWORD;
	private String USER_TEL;
	private String USER_LOC;
	private String USER_BIRTHDAY;
	public Long getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(Long uSER_ID) {
		USER_ID = uSER_ID;
	}
	public String getUSER_REALNAME() {
		return USER_REALNAME;
	}
	public void setUSER_REALNAME(String uSER_REALNAME) {
		USER_REALNAME = uSER_REALNAME;
	}
	public String getUSER_HEADIMG() {
		return USER_HEADIMG;
	}
	public void setUSER_HEADIMG(String uSER_HEADIMG) {
		USER_HEADIMG = uSER_HEADIMG;
	}
	public String getUSER_SEX() {
		return USER_SEX;
	}
	public void setUSER_SEX(String uSER_SEX) {
		USER_SEX = uSER_SEX;
	}
	public String getUSER_NAME() {
		return USER_NAME;
	}
	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}
	public String getUSER_PASSWORD() {
		return USER_PASSWORD;
	}
	public void setUSER_PASSWORD(String uSER_PASSWORD) {
		USER_PASSWORD = uSER_PASSWORD;
	}
	public String getUSER_TEL() {
		return USER_TEL;
	}
	public void setUSER_TEL(String uSER_TEL) {
		USER_TEL = uSER_TEL;
	}
	public String getUSER_LOC() {
		return USER_LOC;
	}
	public void setUSER_LOC(String uSER_LOC) {
		USER_LOC = uSER_LOC;
	}
	public String getUSER_BIRTHDAY() {
		return USER_BIRTHDAY;
	}
	public void setUSER_BIRTHDAY(String uSER_BIRTHDAY) {
		USER_BIRTHDAY = uSER_BIRTHDAY;
	}
	public User(Long uSER_ID, String uSER_REALNAME, String uSER_HEADIMG,
			String uSER_SEX, String uSER_NAME, String uSER_PASSWORD,
			String uSER_TEL, String uSER_LOC, String uSER_BIRTHDAY) {
		super();
		USER_ID = uSER_ID;
		USER_REALNAME = uSER_REALNAME;
		USER_HEADIMG = uSER_HEADIMG;
		USER_SEX = uSER_SEX;
		USER_NAME = uSER_NAME;
		USER_PASSWORD = uSER_PASSWORD;
		USER_TEL = uSER_TEL;
		USER_LOC = uSER_LOC;
		USER_BIRTHDAY = uSER_BIRTHDAY;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [USER_ID=" + USER_ID + ", USER_REALNAME=" + USER_REALNAME
				+ ", USER_HEADIMG=" + USER_HEADIMG + ", USER_SEX=" + USER_SEX
				+ ", USER_NAME=" + USER_NAME + ", USER_PASSWORD="
				+ USER_PASSWORD + ", USER_TEL=" + USER_TEL + ", USER_LOC="
				+ USER_LOC + ", USER_BIRTHDAY=" + USER_BIRTHDAY + "]";
	}
	
	

}
