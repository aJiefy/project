package com.lafite.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lafite.dao.OrderDao;
import com.lafite.entity.User;

//显示支付结果的页面
@WebServlet("/backServlet")
public class BackServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String r1_Code = request.getParameter("r1_Code");
		PrintWriter pw = response.getWriter();
		//pay_success
		if ("1".equals(r1_Code)) {
			String p1_MerId = request.getParameter("p1_MerId");
			String r3_Amt = request.getParameter("r3_Amt");
			String r6_Order = request.getParameter("r6_Order");
			String rp_PayDate = request.getParameter("rp_PayDate");
			pw.println("支付成功！<br/>" + "商户编号：" + p1_MerId + "<br/>" + "支付金额："
					+ r3_Amt + "<br/>" + "商户订单号：" + r6_Order + "<br/>"
					+ "支付成功时间：" + rp_PayDate +"<br/><a href='/Lafite/index.jsp'>返回主页</a>");
			
			

//			try {
//				Thread.sleep(5000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			//request.getRequestDispatcher("/index.jsp").forward(request, response);
			
			
			//add by ethan
			//User user = (User)request.getSession().getAttribute("USER_IN_SESSION");
			//System.out.println(user.toString());
			
			
			
			//支付成功操作   update pay_statu  , 删除购物车 ,等待发货
			//OrderDao dao = new OrderDao();
			//int status = dao.updatePayStatus(user.getUSER_NAME());
			//System.out.println("pay_statu="+status);
			
//			if(status==1){
//				response.sendRedirect("/Lafite/orderServlet?cmd=myorder");
//			}
			
			
			
			
			
			
		} else {
			pw.println("支付失败！");
		}
	}

}
