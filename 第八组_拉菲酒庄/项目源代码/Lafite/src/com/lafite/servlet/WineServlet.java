package com.lafite.servlet;

import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
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

import com.alibaba.fastjson.JSON;
import com.lafite.dao.VarietyDao;
import com.lafite.dao.WineDao;
import com.lafite.entity.Variety;
import com.lafite.entity.Wine;
import com.lafite.page.PageData;
import com.lafite.page.QueryWineConditionSets;
import com.lafite.util.StringUtils;

@WebServlet("/WineServlet")
public class WineServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private WineDao dao = new WineDao();
	Wine wine;
	String imgname;
	/**
	 * (非 Javadoc)
	 * <p>
	 * Description(描述):doget方法
	 * </p>
	 * <p>
	 * Title: doGet
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		
		
		PrintWriter out = resp.getWriter();
		List<Wine> showWine = new ArrayList<Wine>();
		
		//index.jsp
		String parameter = req.getParameter("cmd");
		System.out.println("cmd="+parameter);
		
		if(StringUtils.hasLength(parameter)){
			if(Long.valueOf(parameter) == 0){  //all
				showWine = dao.showAllWine();
				System.out.println("showWine="+showWine);
			}else if(Long.valueOf(parameter) == 1){  //传奇
				showWine = dao.showWine(Long.valueOf(parameter));
				System.out.println(Long.valueOf(parameter)+"1");
			}else if(Long.valueOf(parameter) == 2){  //传说
				showWine = dao.showWine(Long.valueOf(parameter));
				System.out.println(Long.valueOf(parameter)+"2");
			}else if(Long.valueOf(parameter) == 3){  //珍藏
				showWine = dao.showWine(Long.valueOf(parameter));
				System.out.println(Long.valueOf(parameter)+"3");
			}else if(Long.valueOf(parameter) == 4){  //珍酿
				showWine = dao.showWine(Long.valueOf(parameter));
				System.out.println(Long.valueOf(parameter)+"4");
			}
			Object json = com.alibaba.fastjson.JSON.toJSON(showWine);
			System.out.println("json="+json);
			out.print(json);
		}
		
		
		//wine-detail.jsp
		String detail = req.getParameter("detail");
		System.out.println("detail="+detail);
		if(StringUtils.hasLength(detail)){
			String WineId = detail;
			System.out.println("wineId="+WineId);
			
			List<Wine> Wine = dao.SeleteWineId(Long.valueOf(WineId));
			
			req.setAttribute("Wine", Wine);
			
			req.getRequestDispatcher("/wine-detail.jsp").forward(req, resp);
			
		}
		
		//cart.jsp click wine_name return to wine-datail.jsp
//		String wineName = req.getParameter("wineName");
//		System.out.println("wine_name="+wineName);
//		if(StringUtils.hasLength(wineName)){
//			
//		}
		
		
		
		
		//backend  wine-manage.jsp
		
		
		String tag = req.getParameter("tag");
		System.out.println("tag="+tag);
		if (StringUtils.hasLength(tag)) {
			if (tag.equals("add")) {
				// 添加商品
				addWineInfo(req, resp);
			} else if (tag.equals("delete")) {
				deleteWineInfo(req, resp);
			} else if (tag.equals("one")) {
				findOneWineInfo(req, resp);
			} else if (tag.equals("update")) {
				updateWineInfo(req, resp);
			} else if (tag.equals("list")) {
				try {
					listWineInfo(req, resp);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		
		
	}


	
	/**
	 * 
	 * @Title: addWineInfo
	 * @Description: 添加酒的信息
	 * @param request
	 * @param response
	 * @param @throws IOException 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	private void addWineInfo(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();

		request.setCharacterEncoding("utf-8");
		String wName = ""; // 商品名称
		String wDetails = ""; // 商品详情
		Double wPrice = null; // 价格
		String wImg = ""; // 图片地址
		String wDescribe = null; // 叙述
		Integer wYield = null; // 年产量
		String wAdvice = null; // 饮酒建议
		String wBorn = null; // 生产日期
		Integer wHot = null; // 热度
		Integer wVarieties = null; // 酒类
		Integer wStock = null; // 库存

		String fileName = ""; // 表单字段元素的name属性值
		// 请求信息中的内容是否是multipart类型
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart) {
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			try {
				// 解析from表单中所有文件
				@SuppressWarnings("unchecked")
				List<FileItem> items = upload.parseRequest(request);
				Iterator<FileItem> iter = items.iterator();
				while (iter.hasNext()) {
					FileItem item = (FileItem) iter.next();
					if (item.isFormField()) {
						// 判断，是普通表单
						fileName = item.getFieldName();
						// 表单字段的name属性
						if (fileName.equals("wName")) {
							wName = item.getString("utf-8");
						} else if (fileName.equals("wDetails")) {
							wDetails = item.getString("utf-8");
						} else if (fileName.equals("wPrice")) {
							wPrice = Double
									.parseDouble(item.getString("utf-8"));
						} else if (fileName.equals("wDescribe")) {
							wDescribe = item.getString("utf-8");
						} else if (fileName.equals("wYield")) {
							wYield = Integer.parseInt(item.getString("utf-8"));
						} else if (fileName.equals("wAdvice")) {
							wAdvice = item.getString("utf-8");
						} else if (fileName.equals("wBorn")) {
							wBorn = item.getString("utf-8");
						} else if (fileName.equals("wHot")) {
							wHot = Integer.parseInt(item.getString("utf-8"));
						} else if (fileName.equals("wStock")) {
							wStock = Integer.parseInt(item.getString("utf-8"));
						} else if (fileName.equals("wVarieties")) {
							if (item.getString("utf-8").equals("传奇")) {
								wVarieties = 1;
							} else if(item.getString("utf-8").equals("传说")){
								wVarieties = 2;
							} else if(item.getString("utf-8").equals("珍藏")){
								wVarieties = 3;
							} else if(item.getString("utf-8").equals("珍酿")){
								wVarieties = 4;
							}
						}

					} else {
						// 文件表单字段
						String uuidStr = UUID.randomUUID().toString();

						String extension = FilenameUtils.getExtension(item
								.getName());
						System.out.println(extension);

						// //获取文件名字
						// String filename = fileItem.getName();
						// tomcat服务器的路径
						String realPath = request.getServletContext()
								.getRealPath("/upload");
						System.out.println(realPath);
						wImg = "/pic/" + uuidStr + "." + extension;
						// //把文件保存到磁盘中
						File file = new File("E:/data/java/tomcat/apache-tomcat-7.0.57/webapps/Lafite/upload",
								uuidStr + "." + extension);

						item.write(file);

					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			Wine wine = new Wine();

			wine.setWINE_NAME(wName);
			wine.setWINE_PRICE(wPrice);
			wine.setWINE_DETAIL(wDetails);
			wine.setWINE_IMG(wImg);
			wine.setWINE_DESCRIBE(wDescribe);
			wine.setWINE_YIELD(wYield);
			wine.setWINE_ADVICE(wAdvice);
			wine.setWINE_HOT(wHot);
			wine.setWINE_VARIETIES_ID(wVarieties);
			wine.setWINE_STOCK(wStock);

			System.out.println(wine.toString());

			dao = new WineDao();
			int rel = dao.addWineInfo(wine, wBorn);
			if (rel > 0) {
				// 添加商品成功之后转发到查询所有的商品界面
				out.print("<script>alert('恭喜您，添加商品成功！');location.href='WineServlet?tag=list';</script>");
			} else {
				out.print("<script>alert('很抱歉，添加商品失败！日期格式错误！');location.href='WineServlet?tag=list';</script>");

			}
		}
	}

	//find
	private void findOneWineInfo(HttpServletRequest req,
			HttpServletResponse resp) throws IOException, ServletException {
		// TODO Auto-generated method stub

		PrintWriter out = resp.getWriter();
		String wineId = req.getParameter("wineId");
		dao = new WineDao();
		System.out.println(Integer.valueOf(wineId));
		List<Wine> list = dao.findOneWineInfo(Integer.valueOf(wineId));
		wine = list.get(0);
		Object jsonStr = JSON.toJSON(wine);
		out.print(jsonStr);
		System.out.println(jsonStr);
	}

	
	//	delete
	private void deleteWineInfo(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		// TODO Auto-generated method stub
		String windId = req.getParameter("windId");
		System.out.println("windId="+windId);
		dao = new WineDao();
		PrintWriter out = resp.getWriter();
		int rel = dao.deleteWineInfo(Integer.valueOf(windId));
		if (rel > 0) {
			out.print("<script>alert('删除成功！');location.href='WineServlet?tag=list';</script>");
		} else {
			out.print("<script>alert('很抱歉，删除失败！');location.href='WineServlet?tag=list';</script>");
		}
	}

	
	//update
	private void updateWineInfo(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = resp.getWriter();
		req.setCharacterEncoding("utf-8");
		Long wId = null;
		String wName = ""; // 商品名称
		String wDetails = ""; // 商品详情
		Double wPrice = null; // 价格
		String wImg = ""; // 图片地址
		String wDescribe = null; // 叙述
		Integer wYield = null; // 年产量
		String wAdvice = null; // 饮酒建议
		String wBorn = null; // 生产日期
		Integer wHot = null; // 热度
		Integer wVarieties = null; // 酒类
		Integer wStock = null; // 库存

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
				Iterator<FileItem> iter = items.iterator();
				imgname = items.get(8).getName();
				System.out.println("imgname"+imgname);
				while (iter.hasNext()) {
					FileItem item = (FileItem) iter.next();
					if (item.isFormField()) {
						// 判断，是普通表单
						fileName = item.getFieldName();
						// 表单字段的name属性
						
					
					 if (fileName.equals("wId")) {
							wId = Long.valueOf(item.getString("utf-8"));
						} else if (fileName.equals("wName")) {
							wName = item.getString("utf-8");
						} else if (fileName.equals("wDetails")) {
							wDetails = item.getString("utf-8");
						} else if (fileName.equals("wPrice")) {
							wPrice = Double
									.parseDouble(item.getString("utf-8"));
						} else if (fileName.equals("wDescribe")) {
							wDescribe = item.getString("utf-8");
						} else if (fileName.equals("wYield")) {
							wYield = Integer.parseInt(item.getString("utf-8"));
						} else if (fileName.equals("wAdvice")) {
							wAdvice = item.getString("utf-8");
						} else if (fileName.equals("wBorn")) {
							wBorn = item.getString("utf-8");
						} else if (fileName.equals("wHot")) {
							wHot = Integer.parseInt(item.getString("utf-8"));
						} else if (fileName.equals("wStock")) {
							wStock = Integer.parseInt(item.getString("utf-8"));
						} else if (fileName.equals("wVarieties")) {
							if (item.getString("utf-8").equals("传奇")) {
								wVarieties = 1;
							} else if(item.getString("utf-8").equals("传说")){
								wVarieties = 2;
							} else if(item.getString("utf-8").equals("珍藏")){
								wVarieties = 3;
							} else if(item.getString("utf-8").equals("珍酿")){
								wVarieties = 4;
							}
						}

					} else {
						// 文件表单字段
						String uuidStr = UUID.randomUUID().toString();

						String extension = FilenameUtils.getExtension(item
								.getName());
						System.out.println("extension="+extension);

						// //获取文件名字
						// String filename = fileItem.getName();
						// tomcat服务器的路径
						String realPath = req.getServletContext().getRealPath(
								"/upload");
						System.out.println(realPath);
						wImg = "/pic/" + uuidStr + "." + extension;
						// //把文件保存到磁盘中
						File file = new File("E:/data/java/tomcat/apache-tomcat-7.0.57/webapps/Lafite/upload",
								uuidStr + "." + extension);

						item.write(file);
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			Wine wine = new Wine();

			wine.setWINE_ID(wId);
			wine.setWINE_NAME(wName);
			wine.setWINE_PRICE(wPrice);
			wine.setWINE_DETAIL(wDetails);
			// System.out.println("----------"+wImg.substring(wImg.length()-1));
			// if(wImg.substring(wImg.length()-1).equals(".")){
			// wine.setWINE_IMG(wineInfo.getWINE_IMG());
			// }else{

			String suibian = req.getParameter("suibaina");
			System.out.println("originImg="+suibian);
			if(StringUtils.hasLength(imgname)){
				wine.setWINE_IMG(wImg);
			}else{
				wine.setWINE_IMG(suibian);
			}
			// }
			wine.setWINE_DESCRIBE(wDescribe);
			wine.setWINE_YIELD(wYield);
			wine.setWINE_ADVICE(wAdvice);
			wine.setWINE_HOT(wHot);
			wine.setWINE_VARIETIES_ID(wVarieties);
			wine.setWINE_STOCK(wStock);

			System.out.println("wine_obj="+wine.toString());

			dao = new WineDao();
			int rel = dao.updateOneWineInfo(wine, wBorn);
			if (rel > 0) {
				// 添加成功后转发
				out.print("<script>alert('恭喜您，修改成功！');location.href='WineServlet?tag=list';</script>");
			} else {
				out.print("<script>alert('很抱歉，添加商品失败！日期格式出错！');location.href='WineServlet?tag=list';</script>");

			}
		}
	}

	private void listWineInfo(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		// TODO Auto-generated method stub

		
		VarietyDao varDao = new VarietyDao();
		List<Variety> varietiesInfoList = varDao.getVarietiesInfo();

		QueryWineConditionSets qps = new QueryWineConditionSets();

		// 获取查询参数
		String wName = req.getParameter("selectName");
		if (StringUtils.hasLength(wName)) {
			qps.setWINE_NAME(wName);
		}
		
		String minPrice = req.getParameter("minPrice");
		if (StringUtils.hasLength(minPrice)) {
			qps.setMinPrice(Double.valueOf(minPrice));
		}
		
		String maxPrice = req.getParameter("maxPrice");
		if (StringUtils.hasLength(maxPrice)) {
			qps.setMaxPrice(Double.valueOf(maxPrice));
		}
		
		String W_Var = req.getParameter("wVarieties");
		if (StringUtils.hasLength(W_Var)) {
			qps.setWINE_VARIETIES_ID(Integer.valueOf(W_Var));
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

		dao = new WineDao();
		PageData pageData = dao.selectPage(qps);

		req.setAttribute("varietiesInfoList", varietiesInfoList);
		req.setAttribute("pageData", pageData);
		System.out.println("getPageIndex:"+pageData.getPageIndex().getBeginIndex());
		System.out.println("getPageIndex:"+pageData.getPageIndex().getEndIndex());
		
		req.setAttribute("qps", qps);

		req.getRequestDispatcher("/admin/lafite-manage.jsp").forward(req, resp);
	
	}
	
	
	
	
}

	
	
	
	
	
	
	
	
	
	
	

