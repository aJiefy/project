package com.lafite.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lafite.dao.CartDao;
import com.lafite.entity.CartItem;
import com.lafite.entity.ShoppingCart;
import com.lafite.entity.User;
import com.lafite.util.StringUtils;


@WebServlet("/cartServlet")
public class CartServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CartDao dao = new CartDao();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String parameter = req.getParameter("cmd");
		System.out.println("cart_cmd="+parameter);
		
		if(StringUtils.hasLength(parameter)){
			
			if(parameter.equals("addItems")){
				try {
					addToCart(req,resp);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if(parameter.equals("mycart")){
				try {
					showCart(req,resp);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if(parameter.equals("del")){
				try {
					deleteCartItem(req,resp);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		
	}
	
	//delete cart
	protected void deleteCartItem(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		System.out.println("im in");
		PrintWriter out = resp.getWriter();
		String id = req.getParameter("id");
		System.out.println("del_id="+id);
		int rel = dao.deleteCartItem(Integer.valueOf(id));
		System.out.println("rel="+rel);
		if(rel==1){
			out.print("<script>alert('删除成功！');location.href='cartServlet?cmd=mycart';</script>");
		} else {
			out.print("<script>alert('很抱歉，删除失败！');location.href='cartServlet?cmd=mycart';</script>");
			
		}
		
	}


	//query My cart
	protected void showCart(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// 获取参数
		User user = (User) req.getSession().getAttribute("USER_IN_SESSION");
		//System.out.println("cart_username="+user.getUSER_NAME());
		if(user!=null){

			//query my cart
			System.out.println("in_username="+user.getUSER_NAME());
			//sql
			List<CartItem> item = dao.queryCarts(user.getUSER_NAME());
			System.out.println(item);
			req.getSession().setAttribute("CART_IN_SESSION",item);
			
			try {
				req.getRequestDispatcher("/cart.jsp").forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			
			resp.sendRedirect("/Lafite/login.jsp");
			
		}
	}



	//add items to cart
	protected void addToCart(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		PrintWriter out = resp.getWriter();
		User user = (User) req.getSession().getAttribute("USER_IN_SESSION");
		System.out.println("addcart_username="+user.getUSER_NAME());
		if(user!=null){
			Integer  winenumber = Integer.valueOf(req.getParameter("winenumber"));
			Double  money = Double.valueOf(req.getParameter("money"));
			String  img = req.getParameter("img");
			String  name = req.getParameter("name");
			System.out.println("wineAccount="+winenumber+",money="+money+",img="+img+",name="+name);
			
			List<CartItem> cartlist = new ArrayList<CartItem>();
			if(winenumber!=0 && money!=0
					&& StringUtils.hasLength(img) && StringUtils.hasLength(name)){
				CartItem ct = new CartItem(null,user.getUSER_NAME(),name,img,money,winenumber,money*winenumber);
				cartlist.add(ct);
				System.out.println("cartList="+cartlist);
				//sql  query first, if no exist , add to t_cart
				List<CartItem> queryRel = dao.queryCartIfExist(user.getUSER_NAME(), name);
				System.out.println("queryRel="+queryRel+",size="+queryRel.size()+",empty?"+queryRel.isEmpty());
				if(!queryRel.isEmpty()){ //cart not null, update
					ct.setCART_COUNT(queryRel.get(0).getCART_COUNT()+winenumber); // origin count + new count
					ct.setCART_TOTALPRICE(queryRel.get(0).getCART_TOTALPRICE() + money*winenumber );
					ct.setCART_ID(queryRel.get(0).getCART_ID());
					int updateRel = dao.updateCartItems(ct);
					System.out.println("updateRel="+updateRel);
					if(updateRel==1){
						System.out.println("account+1");
						//out.print("<script>alert('add to cart successfully！');window.location.href='cartServlet?cmd=mycart';</script>");
						resp.sendRedirect("/Lafite/cartServlet?cmd=mycart");
						//req.getRequestDispatcher("/Lafite/cartServlet?cmd=mycart").forward(req, resp);
					}
					
				}else if(queryRel.isEmpty() ){ //cart null
					
					System.out.println("add to cart");
					
					int addRel = dao.addItems(cartlist);
					System.out.println("addRel="+addRel);
					if(addRel==1){
						//out.print("<script>alert('add to cart successfully！');window.location.href='cartServlet?cmd=mycart';</script>");
//						resp.sendRedirect("/Lafite/cartServlet?cmd=mycart");
						req.getRequestDispatcher("cartServlet?cmd=mycart").forward(req, resp);
					}
				}
			
			}
			
		}
		
		
	}

}
