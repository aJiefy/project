package com.lafite.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//购物车对象
public class ShoppingCart {

	private List<CartItem> items = new ArrayList<CartItem>();

	private Double CART_TOTALPRICE = 0.0;

	// 购物车添加商品
	public void addItems(CartItem item) {

		// 如果商品已经存在，只要修改数量就可以
		for (CartItem item1 : items) {
			// Long object
			if (item.getCART_ID().equals(item1.getCART_ID())) {
				item1.setCART_COUNT(item1.getCART_COUNT() + item.getCART_COUNT());
				return;
			}
		}
		items.add(item);
	}

	//删除商品
	public void delete(Long id) {
        Iterator<CartItem> iterator = items.iterator();
        while (iterator.hasNext()) {
		    CartItem cartItem = iterator.next();
			if(cartItem.getCART_ID().equals(id)){
				iterator.remove();
			}
		}
	}
	
	
	//购物车结算总价格
	public Double getTotalPrice(){
	    CART_TOTALPRICE = 0.0;
	    for (CartItem item : items) {
			CART_TOTALPRICE += item.getWINE_PRICE()*item.getCART_COUNT();
			System.out.println(CART_TOTALPRICE);
	    }
		return CART_TOTALPRICE;
	}
	
	

	public List<CartItem> getItems() {
		return items;
	}

	public void setItems(List<CartItem> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "ShoppingCart [items=" + items + ", totalPrice=" + CART_TOTALPRICE
				+ "]";
	}
	
	

}
