package com.lafite.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.lafite.dao.CartDao;
import com.lafite.entity.Cart;
import com.lafite.entity.CartItem;


public class CartTest {
	
	
	
	public static void main(String[] args) {
		
//		CartDao dao = new CartDao();
//		
//		List<CartItem> list = dao.queryCarts("test");
//		for (CartItem cartItem : list) {
//			
//			System.out.println(cartItem);
//			
//		}
//		System.out.println("------------------");
//		System.out.println(list.get(0));
		 Date date = new Date();
		  DateFormat format1 = new SimpleDateFormat("yyyy/MM/dd");  
		  System.out.println(format1.format(date));
		
		
		
		
		
		
//		System.out.println(list.get(1).getItems());
		
		
		
	}

}
