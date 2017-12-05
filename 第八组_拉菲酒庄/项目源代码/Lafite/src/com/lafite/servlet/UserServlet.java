package com.lafite.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;


import com.lafite.dao.OrderDao;
import com.lafite.dao.UserDao;
import com.lafite.dao.WineDao;
import com.lafite.entity.Order;
import com.lafite.entity.User;
import com.lafite.entity.Wine;
import com.lafite.page.PageData;
import com.lafite.page.QueryOrderSets;
import com.lafite.page.QueryUserSets;
import com.lafite.util.StringUtils;

@WebServlet("/userServlet")
public class UserServlet extends HttpServlet{
	
	private UserDao dao = new UserDao();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		try{
			
			String parameter = req.getParameter("cmd");
			if(StringUtils.hasLength(parameter)){
				if(parameter.equals("login")){
					login(req,resp);
				} else if(parameter.equals("logout")){
					logout(req,resp);
				} else if(parameter.equals("reg")){
					register(req,resp);
				} else if(parameter.equals("ifExistUser")){
					ifExistUser(req,resp);
				} else if(parameter.equals("checkTel")){
					checkTel(req,resp);
				} else if(parameter.equals("list")){
					showUser(req,resp);
				}else if(parameter.equals("usermsg")){
					usermsg(req,resp);
				}else if(parameter.equals("updatemsg")){
					updatemsg(req,resp);
				} else if(parameter.equals("changePwd")){
					changePassword(req,resp);
				} else if(parameter.equals("del")){
					deleteUser(req,resp);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
	}
	



//usermsg.jsp
	

	//change user_pwd
	protected void changePassword(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		PrintWriter out = resp.getWriter();
		User user = (User) req.getSession().getAttribute("USER_IN_SESSION");
		String pwd = req.getParameter("password");
		String newPwd = req.getParameter("newPassword");
		System.out.println("pwd="+pwd+",new="+newPwd);
		
		if(StringUtils.hasLength(pwd) && StringUtils.hasLength(newPwd)){
			user.setUSER_PASSWORD(pwd);
			List<User> checkRet = dao.checkUserPwd(user);
			System.out.println(checkRet.size());
			if(checkRet.size()>0){   //pwd correct
				user.setUSER_PASSWORD(newPwd);
				int updateRet = dao.updatePwd(user);
				if(updateRet>0){
					out.print("<script>alert('恭喜您，修改成功！');location.href='userServlet?cmd=usermsg';</script>");
				} else {
					out.print("<script>alert('修改失败！');location.href='userServlet?cmd=usermsg';</script>");

				}
				
			}else {
				out.print("<script>alert('密码错误！');location.href='userServlet?cmd=usermsg';</script>");
				
			}
		}
		
	}
	
	//update user msg
	protected void updatemsg(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		PrintWriter out = resp.getWriter();
		User user = (User) req.getSession().getAttribute("USER_IN_SESSION");
		System.out.println("update User....+"+user.toString());
		
		
		String headimg = ""; 
		String sex = ""; 
		String birth = ""; 
		String loc = ""; 
		String fileName = ""; // 表单字段元素的name属性值
		// 请求信息中的内容是否是multipart类型
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		if (isMultipart) {
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			try {
				// 解析from表单中所有文件
				@SuppressWarnings("unchecked")
				List<FileItem> items = upload.parseRequest(req);
				System.out.println("upload_items="+items);
				Iterator<FileItem> iter = items.iterator();
				while (iter.hasNext()) {
					FileItem item = (FileItem) iter.next();
					if (item.isFormField()) {
						// 判断，是普通表单
						fileName = item.getFieldName();
						// 表单字段的name属性
						if (fileName.equals("sex")) {
							sex = item.getString("utf-8");
						} else if (fileName.equals("upd-birth")) {
							birth = item.getString("utf-8");
						} else if (fileName.equals("upd-address")) {
							loc = item.getString("utf-8");
						} 

					} else {
						
						// 文件表单字段
						String uuidStr = UUID.randomUUID().toString();

						String extension = FilenameUtils.getExtension(item
								.getName());
						System.out.println("extension="+extension);

						
						// tomcat服务器的路径
						String realPath = req.getServletContext()
								.getRealPath("/upload");
						System.out.println(realPath);
						
						//把文件保存到磁盘中
						File file = new File("E:/data/java/tomcat/apache-tomcat-7.0.57/webapps/Lafite/upload",
								uuidStr + "." + extension);
						if(StringUtils.hasLength(extension)){
							headimg = "/pic/" + uuidStr + "." + extension;
							item.write(file);
						}

					}
				}
				System.out.println("img="+headimg+",sex="+sex+",birth="+birth+",loc="+loc);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
			
			user.setUSER_HEADIMG(headimg);
			user.setUSER_SEX(sex);
			user.setUSER_BIRTHDAY(birth);
			user.setUSER_LOC(loc);
		
			System.out.println("data after update user:"+user.toString());
			
			int ret = dao.updateUser(user);
			
			if (ret > 0) {
				//update successfully
				out.print("<script>alert('恭喜您，修改成功！');location.href='userServlet?cmd=usermsg';</script>");
			} else {
				out.print("<script>alert('修改失败！');location.href='userServlet?cmd=usermsg';</script>");

			}
		}
		
	}

	//show user msg
	protected void usermsg(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// usermsg.jsp   /usermsg
		User user = (User) req.getSession().getAttribute("USER_IN_SESSION");
		System.out.println("user="+user.toString());
		
		List<User> list = dao.queryUserByName(user.getUSER_NAME());
		System.out.println("queryUserByName_usermsg="+list);
		
		List<Order> list2 = dao.queryUserOrder(user.getUSER_NAME());
		
		req.setAttribute("auser", list);
		req.setAttribute("orders", list2);
		req.getRequestDispatcher("/usermsg.jsp").forward(req, resp);
		
	}


//user-manage.jsp  showUser
	protected void showUser(HttpServletRequest req, HttpServletResponse resp) {
		QueryUserSets set = new QueryUserSets();

		// 获取查询参数
		String selectUsername = req.getParameter("selectUsername");
		if (StringUtils.hasLength(selectUsername)) {
			set.setUSER_NAME(selectUsername);
		}
		
		String sex = req.getParameter("sex");
		System.out.println("sex="+sex);
		if (StringUtils.hasLength(sex)) {
			if(sex.equals("-1")){
				
			} else {
				set.setUSER_SEX(sex);
			}
			
		}
		
		String pageSize = req.getParameter("pageSize");
		if (StringUtils.hasLength(pageSize)) {
			set.setPageSize(Integer.valueOf(pageSize));
		}
		System.out.println(pageSize);
		
		String currentPage = req.getParameter("currentPage");
		if (StringUtils.hasLength(currentPage)) {
			set.setCurrentPage(Integer.valueOf(currentPage));
		}

		dao = new UserDao();
		PageData pageData;
		try {
			pageData = dao.selectPage(set);
			
			req.setAttribute("pageData", pageData);
			System.out.println("getPageIndex:"+pageData.getPageIndex().getBeginIndex());
			System.out.println("getPageIndex:"+pageData.getPageIndex().getEndIndex());
			
			req.setAttribute("set", set);

			req.getRequestDispatcher("/admin/user-manage.jsp").forward(req, resp);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	//delete user
	protected void deleteUser(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String userId = req.getParameter("userId");
		System.out.println("userId="+userId);
		dao = new UserDao();
		PrintWriter out = resp.getWriter();
		int ret = dao.deleteUser(Integer.valueOf(userId));
		if (ret > 0) {
			out.print("<script>alert('删除成功！');location.href='userServlet?cmd=list';</script>");
		} else {
			out.print("<script>alert('很抱歉，删除失败！');location.href='userServlet?cmd=list';</script>");
		}
	}
	
	

	//check if exist user
	protected void ifExistUser(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		PrintWriter out = resp.getWriter();
		
		String username = req.getParameter("username");
		System.out.println("username="+username);
		List<User> queryUserByName = dao.queryUserByName(username);
		System.out.println(queryUserByName);
		
		
		// Username
		if (queryUserByName.size()>0) {
			// System.out.println("亲，用户名已经存在");
			out.print("Username already exist!");
		} else {
			// System.out.println("恭喜你，用户名可以使用");
			out.print("Username can be used");

		}
		
	}

	//check tel
	protected void checkTel(HttpServletRequest req, HttpServletResponse resp) throws Exception {
//		PrintWriter out = resp.getWriter();
//		
//		String tel = req.getParameter("form-tel");
//		List<User> queryUserByTel = dao.queryUserByTel(tel);
//		System.out.println(queryUserByTel);
//		
//		
//		// tel
//		if (queryUserByTel.size()>0) {
//			out.print("telephone already exist!");
//		} else {
//			out.print("telephone can be used");
//
//		}
	}
	
	
	//user register
	protected void register(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		System.out.println("start reg....");
		
		PrintWriter out = resp.getWriter();

		String realname = "";
		String headimg = "";
		String sex = "";
		String username = "";
		String password = "";
		String tel = "";
		String location = "";
		String birthday = "";
		String fileName = ""; // 表单字段元素的name属性值

		// 请求信息中的内容是否是multipart类型
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		if (!isMultipart) {
			return;
		} else {
			System.out.println("isMultipart="+isMultipart);
			//创建FileItemFactory对象
			FileItemFactory factory = new DiskFileItemFactory();
			//创建文件上传处理器
			ServletFileUpload upload = new ServletFileUpload(factory);
			
				// 解析form表单中所有文件   Parse the request
				List<FileItem> items = upload.parseRequest(req);
				//FileItem表单上的元素
//				Iterator<FileItem> iter = items.iterator();
//				while (iter.hasNext()) {
				for (FileItem fileItem : items) { 
//					FileItem item = (FileItem) iter.next();
					if (fileItem.isFormField()) {//普通控件
						fileName = fileItem.getFieldName();
						// 表单字段的name属性
						if (fileName.equals("form-realname")) {
							realname = fileItem.getString("utf-8");
						} else if (fileName.equals("form-headimg")) {
							headimg = fileItem.getString("utf-8");
						} else if (fileName.equals("sex")) {
							sex = fileItem.getString("utf-8");
						} else if (fileName.equals("form-username")) {
							username = fileItem.getString("utf-8");
						} else if (fileName.equals("form-password")) {
							password = fileItem.getString("utf-8");
						} else if (fileName.equals("form-tel")) {
							tel = fileItem.getString("utf-8");
						} else if (fileName.equals("form-loc")) {
							location = fileItem.getString("utf-8");
						} else if (fileName.equals("form-birth")) {
							
							birthday = fileItem.getString("utf-8");
							System.out.println("req-birth="+birthday.trim());
						} 
					} else {   //上传控件
							String uuidStr = UUID.randomUUID().toString();
	
							String extension = FilenameUtils.getExtension(fileItem.getName());
							System.out.println(extension);
	
							// tomcat服务器的路径
							String realPath = req.getServletContext().getRealPath("/upload");
							System.out.println("realPath="+realPath);
							headimg = "/pic/" + uuidStr + "." + extension;
							// //把文件保存到磁盘中
							File file = new File("E:/data/java/tomcat/apache-tomcat-7.0.57/webapps/Lafite/upload",
									uuidStr + "." + extension);
							fileItem.write(file);
						}
					}
					System.out.println("birthday="+birthday);
					
					
					//String dateStr = "Wed Sep 16 11:26:23 CST 2009"; 
					//SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);

					//java.util.Date对象
					//Date date = (Date) sdf.parse(dateStr);
					
					
//					Date birth = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
//					System.out.println(birth.getYear()+1900);
					
					
					User user = new User(null,realname,headimg,sex,username,password,tel,location,birthday  );
					System.out.println(user.toString());

					
					int isadd = dao.addUser(user);
					System.out.println("isadd=="+isadd);
					
					if(isadd==1){
						out.write("<script>alert('Register successfully,Please Sign in!');location.href='login.jsp';</script>");
						//Thread.sleep(3000);
						//resp.sendRedirect("/Lafite/login.jsp");
						//req.getRequestDispatcher("/login.jsp").forward(req, resp);
						
					} else { //register fail?
						
						out.print("<script>alert('Register Failed！');location.href='register.jsp';</script>");
					}

				}
		
		
			}   
		
		

		
		

	//user logout
	protected void logout(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		 //1.logout Session
        req.getSession().invalidate();
        //2.return to index.jsp
        resp.sendRedirect(req.getContextPath()+"/index.jsp");

		
		
		
	}

	//login
	protected void login(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String username = req.getParameter("form-username");
		String password = req.getParameter("form-password");
		System.out.println("username="+username+",password="+password);
		
		
		
		//验证码校验
        //获取用户填写的验证码
        String randomCode = req.getParameter("form-code");
        //Session的验证码
        String sessionRandomCode = (String)req.getSession().getAttribute("RANDOMCODE_IN_SESSION");
        

        if(!StringUtils.hasLength(randomCode) || !StringUtils.hasLength(sessionRandomCode)){
            req.setAttribute("errorMsg", "验证码不能为空或验证码过时!");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
            return;
        }
        if(!randomCode.equals(sessionRandomCode)){
            req.setAttribute("errorMsg", "验证码错误，请重新输入!");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
            return;
        }
        
        
		try{
			List<User> checkLogin = dao.checkLogin(username, password);  //login successfully
			
			
			req.getSession().setAttribute("USER_IN_SESSION", checkLogin.get(0)); //session store user obj
			
			System.out.println("checkLogin="+checkLogin);
			
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
			
			
			
			
		}catch (Exception e) {
	        
			 req.setAttribute("errorMsg", "用户名或密码错误!");
	         req.getRequestDispatcher("/login.jsp").forward(req, resp);
	       
	            

	    }
		
		
	}
		
	
	
	
	

}
