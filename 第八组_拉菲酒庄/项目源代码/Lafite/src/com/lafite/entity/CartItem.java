package com.lafite.entity;

//对象
public class CartItem {
   
	private Long CART_ID;//cart id
	private String USER_NAME;//user_name
	
	private String WINE_NAME;
	private String WINE_IMG;
	private Double WINE_PRICE;
	private Integer CART_COUNT;
	private Double CART_TOTALPRICE;
	
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
	public Integer getCART_COUNT() {
		return CART_COUNT;
	}
	public void setCART_COUNT(Integer cART_COUNT) {
		CART_COUNT = cART_COUNT;
	}
	public Double getCART_TOTALPRICE() {
		return CART_TOTALPRICE;
	}
	public void setCART_TOTALPRICE(Double cART_TOTALPRICE) {
		CART_TOTALPRICE = cART_TOTALPRICE;
	}
	public CartItem(Long cART_ID, String uSER_NAME, String wINE_NAME,
			String wINE_IMG, Double wINE_PRICE, Integer cART_COUNT,
			Double cART_TOTALPRICE) {
		super();
		CART_ID = cART_ID;
		USER_NAME = uSER_NAME;
		WINE_NAME = wINE_NAME;
		WINE_IMG = wINE_IMG;
		WINE_PRICE = wINE_PRICE;
		CART_COUNT = cART_COUNT;
		CART_TOTALPRICE = cART_TOTALPRICE;
	}
	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CartItem [CART_ID=" + CART_ID + ", USER_NAME=" + USER_NAME
				+ ", WINE_NAME=" + WINE_NAME + ", WINE_IMG=" + WINE_IMG
				+ ", WINE_PRICE=" + WINE_PRICE + ", CART_COUNT=" + CART_COUNT
				+ ", CART_TOTALPRICE=" + CART_TOTALPRICE + "]";
	}
	
	
	

	
	
	
	
	
	
	
}
