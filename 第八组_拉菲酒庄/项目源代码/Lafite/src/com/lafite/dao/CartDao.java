package com.lafite.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lafite.entity.Cart;
import com.lafite.entity.CartItem;
import com.lafite.entity.User;
import com.lafite.entity.Wine;
import com.lafite.util.BaseDao;
import com.lafite.util.StringUtils;


public class CartDao {
	//query Cart by username
	public List<CartItem> queryCarts(String username){
		BaseDao.getConn();
		List<Object> param = new ArrayList<Object>();
		String sql = "select * from t_cart where user_name=?";
		param.add(username);
		
		
		List<CartItem> list = 
				(List<CartItem>) BaseDao.select(sql, CartItem.class, param.toArray());
		
		System.out.println("dao_list="+list);
		return list;
		
	}
	
	//query by username and wineName
	public List<CartItem> queryCartIfExist(String username,String wineName){
		BaseDao.getConn();
		List<Object> param = new ArrayList<Object>();
		String sql = "select * from t_cart where user_name=? and wine_name=?";
		param.add(username);
		param.add(wineName);
		
		List<CartItem> list = 
				(List<CartItem>) BaseDao.select(sql, CartItem.class, param.toArray());
		
		System.out.println("dao_list="+list);
		return list;
		
	}
	
	//add Items to Cart
	public int addItems(List<CartItem> cartItem){
		
		String sql = "insert into t_cart values(cart_id.nextval,?,?,?,?,?,?)";
			 List<Object> params = new ArrayList<Object>();
			 params.add(cartItem.get(0).getUSER_NAME());
			 params.add(cartItem.get(0).getWINE_NAME());
			 params.add(cartItem.get(0).getWINE_IMG());
			 params.add(cartItem.get(0).getWINE_PRICE());
			 params.add(cartItem.get(0).getCART_COUNT());
			 params.add(cartItem.get(0).getCART_TOTALPRICE());
			
			 int rel = 0;
			 rel = BaseDao.execute(sql, params.toArray());
			 return rel;
	} 
	
	//update cart's Items 
	public int updateCartItems(CartItem cartItem) {
		// TODO Auto-generated method stub
		List<Object> param = new ArrayList<Object>();
//		StringBuilder sql = new StringBuilder("update t_cart set cart_count=?,cart_totalprice=?");
//		sql.append("where cart_id = ?");
		String sql = "update t_cart set cart_count=?,cart_totalprice=? where cart_id = ?";
		param.add(cartItem.getCART_COUNT());
		param.add(cartItem.getCART_TOTALPRICE());
		param.add(cartItem.getCART_ID());
		System.out.println(cartItem.getCART_COUNT()+","+cartItem.getCART_TOTALPRICE()+","+cartItem.getCART_ID());
		int rel = 0;
		rel = BaseDao.execute(sql, param.toArray());
	 
		System.out.println("dao_rel="+rel);
		return rel;
		
	}
	
	
	//delete cart
	public int deleteCartItem(int cartId) {
		String sql = "delete from t_cart where cart_id = ?";
		List<Object> param = new ArrayList<Object>();
		param.add(cartId);
		int i = BaseDao.execute(sql, param.toArray());
		return i;
	}
	
	
	
	
	public static void main(String[] args) {
//		CartItem c = new CartItem(null,"test","abc","../",40d,20,800d);
//		CartDao dao = new CartDao();
//		int addItems = dao.addItems(c);
//		System.out.println(addItems);
		
//		CartDao dao = new CartDao();
//		int rel = dao.deleteCartItem(9);
//		System.out.println("rel="+rel);
		
		
	}
	
	
	
}	


		

	


