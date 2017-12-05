package com.lafite.page;

import java.util.ArrayList;

import com.lafite.util.StringUtils;

public class QueryOrderSets  extends QueryObject {
	private String USER_NAME;
	private String USER_TEL;
	private String WINE_NAME;
	private ArrayList<Object> params = new ArrayList<Object>();
	
	public ArrayList<Object> getParams() {
		return params;
	}
	
	public void customQuery() {
		if (StringUtils.hasLength(USER_NAME)) {
			super.addQuery(" USER_NAME = ?",  USER_NAME );
		}

		if (StringUtils.hasLength(USER_TEL)) {
			super.addQuery(" USER_TEL = ?",  USER_TEL );
		}
		if (StringUtils.hasLength(WINE_NAME)) {
			super.addQuery(" WINE_NAME LIKE ?", "%" + WINE_NAME + "%");
		}

		
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
	public String getWINE_NAME() {
		return WINE_NAME;
	}
	public void setWINE_NAME(String wINE_NAME) {
		WINE_NAME = wINE_NAME;
	}
	public QueryOrderSets(String uSER_NAME, String uSER_TEL, String wINE_NAME) {
		super();
		USER_NAME = uSER_NAME;
		USER_TEL = uSER_TEL;
		WINE_NAME = wINE_NAME;
	}
	public QueryOrderSets() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "QueryOrderSets [USER_NAME=" + USER_NAME + ", USER_TEL="
				+ USER_TEL + ", WINE_NAME=" + WINE_NAME + "]";
	}
	
	
}
