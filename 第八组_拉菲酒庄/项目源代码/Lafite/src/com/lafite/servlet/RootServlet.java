package com.lafite.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lafite.dao.RootDao;
import com.lafite.entity.Root;


@WebServlet("/rootServlet")
public class RootServlet extends HttpServlet{
	
	private RootDao dao = new RootDao();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String parameter = req.getParameter("cmd");
		if(parameter.equals("login")){
			try {
				login(req,resp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if(parameter.equals("logout")){
			try {
				logout(req,resp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}

	protected void logout(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		 
		req.getSession().invalidate();
        //2.return to index.jsp
        resp.sendRedirect(req.getContextPath()+"/admin/login.jsp");
		
	}

	protected void login(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String name = req.getParameter("rootname");
		String pwd = req.getParameter("rootpwd");
		System.out.println("username="+name+",password="+pwd);
		List<Root> checkLogin = dao.checkLogin(name, pwd);
		System.out.println("checkLogin="+checkLogin);
		
		req.getSession().setAttribute("ROOT_IN_SESSION", checkLogin.get(0)); //session store rootname
		
		//req.getRequestDispatcher("/admin/index.jsp").forward(req, resp);
		resp.sendRedirect("/Lafite/admin/index.jsp");
		
		
		
	}

}
