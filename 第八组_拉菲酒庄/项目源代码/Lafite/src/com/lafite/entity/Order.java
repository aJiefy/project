package com.lafite.entity;

import java.sql.Date;

public class Order {
	private Long ID;
	private Long CART_ID;
	private String USER_NAME;
	private String USER_TEL;
	private String WINE_IMG;
	private String WINE_NAME;
	private Integer ORDER_COUNT;
	private String USER_LOC;
	private String PAY_STATUS;
	private String ORDER_STATUS;
	private String ORDER_CREATETIME; //date
	private String ORDER_PAYTIME; 	//date
	private Double ORDER_TOTALPRICE;
	public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
		ID = iD;
	}
	public Long getCART_ID() {
		return CART_ID;
	}
	public void setCART_ID(Long cART_ID) {
		CART_ID = cART_ID;
	}
	public String getUSER_NAME() {
		return USER_NAME;
	}
	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}
	public String getUSER_TEL() {
		return USER_TEL;
	}
	public void setUSER_TEL(String uSER_TEL) {
		USER_TEL = uSER_TEL;
	}
	public String getWINE_IMG() {
		return WINE_IMG;
	}
	public void setWINE_IMG(String wINE_IMG) {
		WINE_IMG = wINE_IMG;
	}
	public String getWINE_NAME() {
		return WINE_NAME;
	}
	public void setWINE_NAME(String wINE_NAME) {
		WINE_NAME = wINE_NAME;
	}
	public Integer getORDER_COUNT() {
		return ORDER_COUNT;
	}
	public void setORDER_COUNT(Integer oRDER_COUNT) {
		ORDER_COUNT = oRDER_COUNT;
	}
	public String getUSER_LOC() {
		return USER_LOC;
	}
	public void setUSER_LOC(String uSER_LOC) {
		USER_LOC = uSER_LOC;
	}
	public String getPAY_STATUS() {
		return PAY_STATUS;
	}
	public void setPAY_STATUS(String pAY_STATUS) {
		PAY_STATUS = pAY_STATUS;
	}
	public String getORDER_STATUS() {
		return ORDER_STATUS;
	}
	public void setORDER_STATUS(String oRDER_STATUS) {
		ORDER_STATUS = oRDER_STATUS;
	}
	public String getORDER_CREATETIME() {
		return ORDER_CREATETIME;
	}
	public void setORDER_CREATETIME(String oRDER_CREATETIME) {
		ORDER_CREATETIME = oRDER_CREATETIME;
	}
	public String getORDER_PAYTIME() {
		return ORDER_PAYTIME;
	}
	public void setORDER_PAYTIME(String oRDER_PAYTIME) {
		ORDER_PAYTIME = oRDER_PAYTIME;
	}
	public Double getORDER_TOTALPRICE() {
		return ORDER_TOTALPRICE;
	}
	public void setORDER_TOTALPRICE(Double oRDER_TOTALPRICE) {
		ORDER_TOTALPRICE = oRDER_TOTALPRICE;
	}
	public Order(Long iD, Long cART_ID, String uSER_NAME, String uSER_TEL,
			String wINE_IMG, String wINE_NAME, Integer oRDER_COUNT,
			String uSER_LOC, String pAY_STATUS, String oRDER_STATUS,
			String oRDER_CREATETIME, String oRDER_PAYTIME,
			Double oRDER_TOTALPRICE) {
		super();
		ID = iD;
		CART_ID = cART_ID;
		USER_NAME = uSER_NAME;
		USER_TEL = uSER_TEL;
		WINE_IMG = wINE_IMG;
		WINE_NAME = wINE_NAME;
		ORDER_COUNT = oRDER_COUNT;
		USER_LOC = uSER_LOC;
		PAY_STATUS = pAY_STATUS;
		ORDER_STATUS = oRDER_STATUS;
		ORDER_CREATETIME = oRDER_CREATETIME;
		ORDER_PAYTIME = oRDER_PAYTIME;
		ORDER_TOTALPRICE = oRDER_TOTALPRICE;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Order [ID=" + ID + ", CART_ID=" + CART_ID + ", USER_NAME="
				+ USER_NAME + ", USER_TEL=" + USER_TEL + ", WINE_IMG="
				+ WINE_IMG + ", WINE_NAME=" + WINE_NAME + ", ORDER_COUNT="
				+ ORDER_COUNT + ", USER_LOC=" + USER_LOC + ", PAY_STATUS="
				+ PAY_STATUS + ", ORDER_STATUS=" + ORDER_STATUS
				+ ", ORDER_CREATETIME=" + ORDER_CREATETIME + ", ORDER_PAYTIME="
				+ ORDER_PAYTIME + ", ORDER_TOTALPRICE=" + ORDER_TOTALPRICE
				+ "]";
	}
	
	
	
	
	
	
	
}
