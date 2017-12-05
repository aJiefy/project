package com.lafite.entity;

import java.sql.Date;

public class Wine {
	private Long WINE_ID;
	private String WINE_NAME;
	private String WINE_DESCRIBE;
	private String WINE_IMG;
	private Integer WINE_VARIETIES_ID; //variety id
	private Integer WINE_YIELD;
	private Double WINE_PRICE;
	private String WINE_ADVICE;
	private String WINE_BORN;
	private String WINE_DETAIL;
	private Integer WINE_HOT;
	private Integer WINE_STOCK;
	private Date WINE_MODIFYTIME;
	public Long getWINE_ID() {
		return WINE_ID;
	}
	public void setWINE_ID(Long wINE_ID) {
		WINE_ID = wINE_ID;
	}
	public String getWINE_NAME() {
		return WINE_NAME;
	}
	public void setWINE_NAME(String wINE_NAME) {
		WINE_NAME = wINE_NAME;
	}
	public String getWINE_DESCRIBE() {
		return WINE_DESCRIBE;
	}
	public void setWINE_DESCRIBE(String wINE_DESCRIBE) {
		WINE_DESCRIBE = wINE_DESCRIBE;
	}
	public String getWINE_IMG() {
		return WINE_IMG;
	}
	public void setWINE_IMG(String wINE_IMG) {
		WINE_IMG = wINE_IMG;
	}
	public Integer getWINE_VARIETIES_ID() {
		return WINE_VARIETIES_ID;
	}
	public void setWINE_VARIETIES_ID(Integer wINE_VARIETIES_ID) {
		WINE_VARIETIES_ID = wINE_VARIETIES_ID;
	}
	public Integer getWINE_YIELD() {
		return WINE_YIELD;
	}
	public void setWINE_YIELD(Integer wINE_YIELD) {
		WINE_YIELD = wINE_YIELD;
	}
	public Double getWINE_PRICE() {
		return WINE_PRICE;
	}
	public void setWINE_PRICE(Double wINE_PRICE) {
		WINE_PRICE = wINE_PRICE;
	}
	public String getWINE_ADVICE() {
		return WINE_ADVICE;
	}
	public void setWINE_ADVICE(String wINE_ADVICE) {
		WINE_ADVICE = wINE_ADVICE;
	}
	public String getWINE_BORN() {
		return WINE_BORN;
	}
	public void setWINE_BORN(String wINE_BORN) {
		WINE_BORN = wINE_BORN;
	}
	public String getWINE_DETAIL() {
		return WINE_DETAIL;
	}
	public void setWINE_DETAIL(String wINE_DETAIL) {
		WINE_DETAIL = wINE_DETAIL;
	}
	public Integer getWINE_HOT() {
		return WINE_HOT;
	}
	public void setWINE_HOT(Integer wINE_HOT) {
		WINE_HOT = wINE_HOT;
	}
	public Integer getWINE_STOCK() {
		return WINE_STOCK;
	}
	public void setWINE_STOCK(Integer wINE_STOCK) {
		WINE_STOCK = wINE_STOCK;
	}
	public Date getWINE_MODIFYTIME() {
		return WINE_MODIFYTIME;
	}
	public void setWINE_MODIFYTIME(Date wINE_MODIFYTIME) {
		WINE_MODIFYTIME = wINE_MODIFYTIME;
	}
	public Wine(Long wINE_ID, String wINE_NAME, String wINE_DESCRIBE,
			String wINE_IMG, Integer wINE_VARIETIES_ID, Integer wINE_YIELD,
			Double wINE_PRICE, String wINE_ADVICE, String wINE_BORN,
			String wINE_DETAIL, Integer wINE_HOT, Integer wINE_STOCK,
			Date wINE_MODIFYTIME) {
		super();
		WINE_ID = wINE_ID;
		WINE_NAME = wINE_NAME;
		WINE_DESCRIBE = wINE_DESCRIBE;
		WINE_IMG = wINE_IMG;
		WINE_VARIETIES_ID = wINE_VARIETIES_ID;
		WINE_YIELD = wINE_YIELD;
		WINE_PRICE = wINE_PRICE;
		WINE_ADVICE = wINE_ADVICE;
		WINE_BORN = wINE_BORN;
		WINE_DETAIL = wINE_DETAIL;
		WINE_HOT = wINE_HOT;
		WINE_STOCK = wINE_STOCK;
		WINE_MODIFYTIME = wINE_MODIFYTIME;
	}
	public Wine() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Wine [WINE_ID=" + WINE_ID + ", WINE_NAME=" + WINE_NAME
				+ ", WINE_DESCRIBE=" + WINE_DESCRIBE + ", WINE_IMG=" + WINE_IMG
				+ ", WINE_VARIETIES_ID=" + WINE_VARIETIES_ID + ", WINE_YIELD="
				+ WINE_YIELD + ", WINE_PRICE=" + WINE_PRICE + ", WINE_ADVICE="
				+ WINE_ADVICE + ", WINE_BORN=" + WINE_BORN + ", WINE_DETAIL="
				+ WINE_DETAIL + ", WINE_HOT=" + WINE_HOT + ", WINE_STOCK="
				+ WINE_STOCK + ", WINE_MODIFYTIME=" + WINE_MODIFYTIME + "]";
	}
	
	

}
