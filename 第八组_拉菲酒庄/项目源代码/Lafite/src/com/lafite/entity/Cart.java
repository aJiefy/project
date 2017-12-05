package com.lafite.entity;

public class Cart {
	private Long CART_ID;  //cart_id
	private String USER_NAME; //user_name
	private String WINE_NAME;    // w_name
	private String WINE_IMG;    //w_img
	private Double WINE_PRICE;    //w_price
	private Long CART_COUNT; //cart_count
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
	public String getWINE_NAME() {
		return WINE_NAME;
	}
	public void setWINE_NAME(String wINE_NAME) {
		WINE_NAME = wINE_NAME;
	}
	public String getWINE_IMG() {
		return WINE_IMG;
	}
	public void setWINE_IMG(String wINE_IMG) {
		WINE_IMG = wINE_IMG;
	}
	public Double getWINE_PRICE() {
		return WINE_PRICE;
	}
	public void setWINE_PRICE(Double wINE_PRICE) {
		WINE_PRICE = wINE_PRICE;
	}
	public Long getCART_COUNT() {
		return CART_COUNT;
	}
	public void setCART_COUNT(Long cART_COUNT) {
		CART_COUNT = cART_COUNT;
	}
	public Cart(Long cART_ID, String uSER_NAME, String wINE_NAME,
			String wINE_IMG, Double wINE_PRICE, Long cART_COUNT) {
		super();
		CART_ID = cART_ID;
		USER_NAME = uSER_NAME;
		WINE_NAME = wINE_NAME;
		WINE_IMG = wINE_IMG;
		WINE_PRICE = wINE_PRICE;
		CART_COUNT = cART_COUNT;
	}
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Cart [CART_ID=" + CART_ID + ", USER_NAME=" + USER_NAME
				+ ", WINE_NAME=" + WINE_NAME + ", WINE_IMG=" + WINE_IMG
				+ ", WINE_PRICE=" + WINE_PRICE + ", CART_COUNT=" + CART_COUNT
				+ "]";
	}

	
	

}
