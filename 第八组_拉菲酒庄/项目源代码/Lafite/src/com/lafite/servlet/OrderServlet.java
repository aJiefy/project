package com.lafite.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.applet.Main;

import com.lafite.dao.OrderDao;
import com.lafite.dao.UserDao;
import com.lafite.dao.WineDao;
import com.lafite.entity.CartItem;
import com.lafite.entity.Order;
import com.lafite.entity.User;
import com.lafite.page.PageData;
import com.lafite.page.QueryObject;
import com.lafite.page.QueryOrderSets;
import com.lafite.page.QueryWineConditionSets;
import com.lafite.util.StringUtils;

@WebServlet("/orderServlet")
public class OrderServlet extends HttpServlet{
	
	private OrderDao dao = new OrderDao();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		try{
			String parameter = req.getParameter("cmd");
			System.out.println("cmd="+parameter);
			if(StringUtils.hasLength(parameter)){
				if(parameter.equals("placeorder")){
					placeOrder(req,resp);
				} else if(parameter.equals("myorder")){
					queryOrder(req,resp);
				} else if(parameter.equals("pay")){
					paySuccess(req,resp);
				} else if(parameter.equals("list")){
					showOrder(req,resp);
				} else if(parameter.equals("del")){
					deleteOrder(req,resp);
				}
			}
			
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		
	}
	
	//delete order
	protected void deleteOrder(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String id = req.getParameter("orderId");
		System.out.println("orderId="+id);
		dao = new OrderDao();
		PrintWriter out = resp.getWriter();
		int ret = dao.deleteOrder(Integer.valueOf(id));
		if (ret > 0) {
			out.print("<script>alert('删除成功！');location.href='orderServlet?cmd=list';</script>");
		} else {
			out.print("<script>alert('很抱歉，删除失败！');location.href='orderServlet?cmd=list';</script>");
		}
		
	}

	//show order
	protected void showOrder(HttpServletRequest req, HttpServletResponse resp) {
		
		QueryOrderSets qps = new QueryOrderSets();

		// 获取查询参数
		String selectUsername = req.getParameter("selectUsername");
		if (StringUtils.hasLength(selectUsername)) {
			qps.setUSER_NAME(selectUsername);
		}
		
		String usertel = req.getParameter("usertel");
		if (StringUtils.hasLength(usertel)) {
			qps.setUSER_TEL(usertel);
		}
		
		String winename = req.getParameter("winename");
		if (StringUtils.hasLength(winename)) {
			qps.setWINE_NAME(winename);
		}
		
		
		
		String pageSize = req.getParameter("pageSize");
		if (StringUtils.hasLength(pageSize)) {
			qps.setPageSize(Integer.valueOf(pageSize));
		}
		System.out.println(pageSize);
		
		String currentPage = req.getParameter("currentPage");
		if (StringUtils.hasLength(currentPage)) {
			qps.setCurrentPage(Integer.valueOf(currentPage));
		}

		dao = new OrderDao();
		PageData pageData;
		try {
			pageData = dao.selectPage(qps);
			
			req.setAttribute("pageData", pageData);
			System.out.println("getPageIndex:"+pageData.getPageIndex().getBeginIndex());
			System.out.println("getPageIndex:"+pageData.getPageIndex().getEndIndex());
			
			req.setAttribute("qps", qps);

			req.getRequestDispatcher("/admin/order-manage.jsp").forward(req, resp);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
	}

	//pay successfully
	protected void paySuccess(HttpServletRequest req, HttpServletResponse resp) {
		
//		User user = (User)req.getAttribute("USER_IN_SESSION");
//		System.out.println(user.toString());
		//支付成功操作   update pay_statu  , 删除购物车 ,等待发货
		OrderDao dao = new OrderDao();
//		int status = dao.updatePayStatus(user.getUSER_NAME());
//		System.out.println("pay_statu="+status);
		
//		if(status==1){
//			try {
//				resp.sendRedirect("/Lafite/orderServlet?cmd=myorder");
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
		
		//resp.sendRedirect("/Lafite/orderServlet?cmd=myorder");
		
	}

	//query order
	protected void queryOrder(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		User user = (User)req.getSession().getAttribute("USER_IN_SESSION");
		System.out.println(user);
		if(user!=null){  //
			List<Order> queryOrder = dao.queryOrder(user.getUSER_NAME());
			System.out.println("queryOrder="+queryOrder);
			
			req.getSession().setAttribute("ORDER_IN_SESSION", queryOrder);
			
			req.getRequestDispatcher("/order.jsp").forward(req, resp);	
			
		} else { //user log out?
			resp.sendRedirect("/Lafite/login.jsp");
			
		}
		
		
	}

	//place orders
	protected void placeOrder(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		User user = (User)req.getSession().getAttribute("USER_IN_SESSION");
		System.out.println(user);
		if(user!=null){  //
			List<CartItem> cartList = (List<CartItem>) req.getSession().getAttribute("CART_IN_SESSION");
			//cartList.add(user);
			System.out.println("cartList="+cartList);
			
			List<Order> orderList = new ArrayList<Order>();
			int addRet = 0;
			
			for (int i=0;i<cartList.size();i++) {
				Order order = new Order(user.getUSER_ID(),cartList.get(i).getCART_ID(),
						user.getUSER_NAME(),user.getUSER_TEL(),cartList.get(i).getWINE_IMG(),
						cartList.get(i).getWINE_NAME(),cartList.get(i).getCART_COUNT(),
						user.getUSER_LOC(),null,null,null,null,cartList.get(i).getCART_TOTALPRICE());
				orderList.clear();
				orderList.add(order);
				System.out.println(orderList);
				
				addRet = dao.addOrder(orderList);
				System.out.println("addRet="+addRet);
				
			}
			
			
			req.getSession().setAttribute("ORDER_IN_SESSION", orderList);
			
			
			if(addRet>0){
				req.getRequestDispatcher("/orderServlet?cmd=myorder").forward(req, resp);	
			} else { //add order failed
				
			}
			
			
		}else { //user log out?
			resp.sendRedirect("/Lafite/login.jsp");
			
		}	
		
	}
	
	
	
	public static void main(String[] args) {
			OrderDao dao = new OrderDao();
			List<Order> queryOrder = dao.queryOrder("test");
			System.out.println(queryOrder);
		
		
		
		
	}
	
	
	

}
