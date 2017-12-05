package com.lafite.page;

import java.util.ArrayList;

import com.lafite.util.StringUtils;

public class QueryUserSets extends QueryObject{
	private String USER_NAME;
	private String USER_SEX;
	
	private ArrayList<Object> params = new ArrayList<Object>();
	
	public ArrayList<Object> getParams() {
		return params;
	}
	
	public void customQuery() {
		if (StringUtils.hasLength(USER_NAME)) {
			super.addQuery(" USER_NAME LIKE ?", "%" + USER_NAME + "%");
		}

		if (StringUtils.hasLength(USER_SEX)) {
			super.addQuery(" USER_SEX = ?",  USER_SEX );
		}
		
		
	}

	public String getUSER_NAME() {
		return USER_NAME;
	}

	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}

	public String getUSER_SEX() {
		return USER_SEX;
	}

	public void setUSER_SEX(String uSER_SEX) {
		USER_SEX = uSER_SEX;
	}

	public void setParams(ArrayList<Object> params) {
		this.params = params;
	}

	public QueryUserSets(String uSER_NAME, String uSER_SEX,
			ArrayList<Object> params) {
		super();
		USER_NAME = uSER_NAME;
		USER_SEX = uSER_SEX;
		this.params = params;
	}

	public QueryUserSets() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "QueryUserSets [USER_NAME=" + USER_NAME + ", USER_SEX="
				+ USER_SEX + ", params=" + params + "]";
	}

	
	
}
