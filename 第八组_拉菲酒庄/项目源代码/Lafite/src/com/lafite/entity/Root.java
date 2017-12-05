package com.lafite.entity;

public class Root {
	private Long ROOT_ID;
	private String ROOT_NAME;
	private String ROOT_PASSWORD;
	public Long getROOT_ID() {
		return ROOT_ID;
	}
	public void setROOT_ID(Long rOOT_ID) {
		ROOT_ID = rOOT_ID;
	}
	public String getROOT_NAME() {
		return ROOT_NAME;
	}
	public void setROOT_NAME(String rOOT_NAME) {
		ROOT_NAME = rOOT_NAME;
	}
	public String getROOT_PASSWORD() {
		return ROOT_PASSWORD;
	}
	public void setROOT_PASSWORD(String rOOT_PASSWORD) {
		ROOT_PASSWORD = rOOT_PASSWORD;
	}
	public Root(Long rOOT_ID, String rOOT_NAME, String rOOT_PASSWORD) {
		super();
		ROOT_ID = rOOT_ID;
		ROOT_NAME = rOOT_NAME;
		ROOT_PASSWORD = rOOT_PASSWORD;
	}
	public Root() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Root [ROOT_ID=" + ROOT_ID + ", ROOT_NAME=" + ROOT_NAME
				+ ", ROOT_PASSWORD=" + ROOT_PASSWORD + "]";
	}
	
	

}
