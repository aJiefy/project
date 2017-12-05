package com.lafite.entity;

public class Variety {
	
	private Long VARIETIES_ID;
	private String VARIETIES_NAME;
	public Long getVARIETIES_ID() {
		return VARIETIES_ID;
	}
	public void setVARIETIES_ID(Long vARIETIES_ID) {
		VARIETIES_ID = vARIETIES_ID;
	}
	public String getVARIETIES_NAME() {
		return VARIETIES_NAME;
	}
	public void setVARIETIES_NAME(String vARIETIES_NAME) {
		VARIETIES_NAME = vARIETIES_NAME;
	}
	public Variety(Long vARIETIES_ID, String vARIETIES_NAME) {
		super();
		VARIETIES_ID = vARIETIES_ID;
		VARIETIES_NAME = vARIETIES_NAME;
	}
	public Variety() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Variety [VARIETIES_ID=" + VARIETIES_ID + ", VARIETIES_NAME="
				+ VARIETIES_NAME + "]";
	}
	
	
	
}
