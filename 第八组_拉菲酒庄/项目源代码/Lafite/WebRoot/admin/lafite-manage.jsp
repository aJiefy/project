<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="com.lafite.dao.*" %>
<%@ page import="com.lafite.entity.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">

<head>
	<base href="${pageContext.request.contextPath}/admin/assets">
	<title>Lafite管理</title>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<!-- VENDOR CSS -->
	<link rel="stylesheet" href="assets/vendor/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="assets/vendor/font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" href="assets/vendor/linearicons/style.css">
	<!-- MAIN CSS -->
	<link rel="stylesheet" href="assets/css/main.css">
	<!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
	<link rel="stylesheet" href="assets/css/demo.css">
	<!-- GOOGLE FONTS -->
	<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700" rel="stylesheet">
	<!-- ICONS -->
	<link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
	<link rel="icon" type="image/png" sizes="96x96" href="assets/img/favicon.png">
</head>

 <body>

	<!-- WRAPPER -->
	<div id="wrapper">
		<!-- NAVBAR -->
		<nav class="navbar navbar-default navbar-fixed-top">
			<div class="brand">
				<a href="index.jsp"> <img src="assets/img/logo-dark.png"
					alt="Klorofil Logo" class="img-responsive logo"> <!-- <img src="../style/images/lafite.png" style="height: 20px" > -->
				</a>
			</div>
			<div class="container-fluid">
				<div class="navbar-btn">
					<button type="button" class="btn-toggle-fullwidth">
						<i class="lnr lnr-arrow-left-circle"></i>
					</button>
				</div>
				<form class="navbar-form navbar-left">
					<div class="input-group">
						<input type="text" value="" class="form-control"
							placeholder="Search dashboard..."> <span
							class="input-group-btn"><button type="button"
								class="btn btn-primary">Go</button>
						</span>
					</div>
				</form>

				<div id="navbar-menu">
					<ul class="nav navbar-nav navbar-right">
						<!-- <li class="dropdown"><a href="#"
							class="dropdown-toggle icon-menu" data-toggle="dropdown"> <i
								class="lnr lnr-alarm"></i> <span class="badge bg-danger">5</span>
						</a>
							<ul class="dropdown-menu notifications">
								<li><a href="#" class="notification-item"><span
										class="dot bg-warning"></span>System space is almost full</a>
								</li>
								<li><a href="#" class="notification-item"><span
										class="dot bg-danger"></span>You have 9 unfinished tasks</a>
								</li>
								<li><a href="#" class="notification-item"><span
										class="dot bg-success"></span>Monthly report is available</a>
								</li>
								<li><a href="#" class="notification-item"><span
										class="dot bg-warning"></span>Weekly meeting in 1 hour</a>
								</li>
								<li><a href="#" class="notification-item"><span
										class="dot bg-success"></span>Your request has been approved</a>
								</li>
								<li><a href="#" class="more">See all notifications</a>
								</li>
							</ul></li> -->
						<!-- <li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"><i class="lnr lnr-question-circle"></i>
								<span>Help</span> <i class="icon-submenu lnr lnr-chevron-down"></i>
						</a>
							<ul class="dropdown-menu">
								<li><a href="#">Basic Use</a>
								</li>
								<li><a href="#">Working With Data</a>
								</li>
								<li><a href="#">Security</a>
								</li>
								<li><a href="#">Troubleshooting</a>
								</li>
							</ul></li> -->
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"><img src="assets/img/user.png"
								class="img-circle" alt="Avatar"> <span>
								<c:if test="${sessionScope.ROOT_IN_SESSION.ROOT_NAME == null}">
									Default
								</c:if>
								<c:if test="${sessionScope.ROOT_IN_SESSION.ROOT_NAME != null}">
									${sessionScope.ROOT_IN_SESSION.ROOT_NAME}
								</c:if></span> <i
								class="icon-submenu lnr lnr-chevron-down"></i>
						</a>
							<ul class="dropdown-menu">
								<!-- <li><a href="#"><i class="lnr lnr-user"></i> <span>Profile</span></a></li> -->
								<li><a href="../rootServlet?cmd=logout"><i class="lnr lnr-exit"></i> <span>Logout</span>
								</a>
								</li>
							</ul></li>

					</ul>
				</div>
			</div>
		</nav>
		<!-- END NAVBAR -->
		<!-- LEFT SIDEBAR -->
		<div id="sidebar-nav" class="sidebar">
			<div class="sidebar-scroll">
				<nav>
					<ul class="nav">
						<li><a href="index.jsp"><i class="lnr lnr-home"></i> <span>主页</span>
						</a>
						</li>

						<li><a href="../WineServlet?tag=list" class="active"><i
								class="fa fa-glass"></i> <span>Lafite管理</span>
						</a>
						</li>
						<li><a href="../orderServlet?cmd=list"><i class="fa fa-list-alt"></i>
								<span>订单管理</span>
						</a>
						</li>
						<li><a href="../userServlet?cmd=list"><i class="lnr lnr-users"></i>
								<span>客户管理</span>
						</a>
						</li>
						<!-- <li><a href="register.jsp"><i class="lnr lnr-pencil"></i>
								<span>管理员注册</span>
						</a>
						</li> -->

						<li><a href="../index.jsp"><i class="lnr lnr-exit"></i>
								<span>退出系统</span>
						</a>
						</li>


					</ul>
				</nav>
			</div>
		</div>
		<!-- END LEFT SIDEBAR -->
				<!-- MAIN -->
		<div class="main">
			<!-- MAIN CONTENT -->
			<div class="main-content">
				<div class="container-fluid">
					<h3 class="page-title">Lafite-Manage</h3>
						<div class="panel-body">
						<form action="/Lafite/WineServlet?tag=list"   id="listForm" method="post">						
						
						<input type="hidden"  name="currentPage" id="currentPageInput">
					     <input type="hidden"  name="pageSize" id="pageSizeInput">
						<label class="awayfrom" style="font-size: 20px;font-family: 'Simsun';margin-left: 25px;">WineName:</label>
						<input id="selectName" name = "selectName" type="text" class="form-control"  
						 style="width: 100px; display: inline-block;" value = "${qps.WINE_NAME}">	
						
						<label class="awayfrom" style="font-size: 20px;font-family: 'Simsun';margin-left:65px;">Price:</label>
						<input id="selectLow" name = "minPrice" type="number"  class="form-control"  
						  style="width: 100px;display: inline-block;" value = "${qps.minPrice}"> ---
						
						<input id="selectHigh"  name = "maxPrice" type="number"  class="form-control"  
						 style="width: 100px;display: inline-block;" value = "${qps.maxPrice}">
						
						<label class="awayfrom" style="font-size: 20px;font-family: 'Simsun';margin-left:65px;">Category:</label>
						<select id="wVarieties" name = "wVarieties" style="height: 34px;">
								<option value="-1">--请选择--</option>
								<c:forEach items="${varietiesInfoList}"  var="vari" varStatus="v">
									<option value="${vari.VARIETIES_ID}" ${qps.WINE_VARIETIES_ID==vari.VARIETIES_ID?"selected='selected'":""}>${vari.VARIETIES_NAME}</option>
						 		</c:forEach>
							</select>	
						<button type="submit" class="btn btn-primary" style="margin: -3px 0 0 65px;width: 75px;height: 34px;">查询</button>	
						
						</form><br><br>
	
				<table class="table">
				<thead>
					<tr style="font-size: 15px;">
						<th>img</th>
						<th width="230px;">Lafite</th>
						<th width="400px;">描述</th>
						<th>价格</th>
						<th>库存</th>
					    <th>系列</th> 
						<th>年份</th>
						<th>更新日期</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${pageData.data}"  var="wine" varStatus="v_wine">
					<tr>
						<td><img src="${wine.WINE_IMG}" style="height: 80px;"></td>
						<td>${wine.WINE_NAME}</td>
						<td>${wine.WINE_DESCRIBE}</td>
						<td>${wine.WINE_PRICE}</td>
						<td>${wine.WINE_STOCK}</td>
						<td>
						<c:choose>
								<c:when test="${wine.WINE_VARIETIES_ID==1}">传奇</c:when>
								<c:when test="${wine.WINE_VARIETIES_ID==2}">传说</c:when>
								<c:when test="${wine.WINE_VARIETIES_ID==3}">珍藏</c:when>
								<c:when test="${wine.WINE_VARIETIES_ID==4}">珍酿</c:when>
						</c:choose>
						</td>
						<td>${wine.WINE_BORN}</td>
						<td>${wine.WINE_MODIFYTIME}</td>
						<td>
						<button id = "${wine.WINE_ID}" onclick="WineId(this.id)" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal1" style="width: 50px; height: 24px; padding: 1px;font-size: 15px;" >
							修改
						</button>
						<a href = "javascript:del(${wine.WINE_ID});">
						<button id="confim-default" type="button" class="btn btn-danger" style="width: 50px; height: 24px; padding: 1px;font-size: 15px;"><i class="fa fa-trash-o"></i>
							删除
						</button>
						</a>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal" style="width: 80px; height: 36px; padding: 3px; margin-left:10px;">
			上架
				
			</button>
			<!-- 模态框（Modal） -->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog" style="width:1050px">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
								&times;
							</button>
							<h4 class="modal-title" id="myModalLabel">
								上架
							</h4>
						</div>
						<div class="modal-body">
							<form id="addForm" action="/Lafite/WineServlet?tag=add" method="post" enctype="multipart/form-data">
								酒名：<input id = "wname" type="text" required="required" name = "wName">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								价格：<input  id = "wprice" type="number" required="required" min=0.00  step=0.01 name = "wPrice">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								库存：<input id = "wstock" type="number" required="required" min=0 name = "wStock">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								生产日期：<input id = "wborn" type="text" required="required" name = "wBorn" data-toggle="tooltip"
       								 data-placement="bottom" title="format: 2000"><br><br>
								热度：<input  id = "whot" type="number" required="required"   min=0 name = "wHot">
								年产量：<input id = "wyield" type="number" required="required"  min=0 name = "wYield">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								酒类：<select id = "wvarieties" name = "wVarieties">
										<c:forEach items="${varietiesInfoList}"  var="it" varStatus="v">
										<option>${it.VARIETIES_NAME}</option>
				 						</c:forEach>
									</select><br><br>
								主图：<input id = "wimg" required="required"  type="file" style="display: inline-block;" name = "wImg"><br><br>
								饮酒建议：<div  style="float: right; margin-right:460px;">描述：</div><br>
								<textarea id = "wadvice"  name="wAdvice" contenteditable="true" rows="5" cols="40" style="margin-left: 50px" name="detailsText"></textarea>
								<textarea id = "wdescribe" name="wDescribe" contenteditable="true" rows="5" cols="40" style="margin-left: 115px" name="detailsText"></textarea><br>
								商品详情：<br>
								<textarea id = "wdetails" name="wDetails" contenteditable="true" rows="4" cols="102" style="margin-left: 50px" name="detailsText"></textarea>
							
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">关闭
							</button>
							<button type="submit" class="btn btn-primary">
								上架
							</button>
						</div>
						</form>
					</div><!-- /.modal-content -->
				</div><!-- /.modal -->
			</div>
			<!-- 模态框2（Modal） -->
			<div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog" style="width:1050px">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
								&times;
							</button>
							<h4 class="modal-title" id="myModalLabel">
								修改
							</h4>
						</div>
						<div class="modal-body">
							<form id="updateForm" action="/Lafite/WineServlet?tag=update" method="post" enctype="multipart/form-data">
								<input type="hidden" id = "wid2" name = "wId">
								酒名：<input id = "wname2" type="text" name = "wName"  >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								价格：<input  id = "wprice2" type="number" min=0.00  step=0.01 name = "wPrice">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								库存：<input id = "wstock2" type="number" min=0 name = "wStock" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								生产日期：<input id = "wborn2" type="text" name = "wBorn" data-toggle="tooltip"
       								 data-placement="bottom" title="format: 2000"> <br><br>
								
								热度：<input  id = "whot2" type="number" min=0 name = "wHot">
								年产量：<input id = "wyield2" type="number" min=0 name = "wYield" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								酒类：<select id = "wvarieties2" name = "wVarieties">
									
									</select><br><br>
									
								主图：<input id = "wimg2" type="file" style="display: inline-block;" name = "wImg"><br><br>
								饮酒建议：<div  style="float: right; margin-right:460px;">描述：</div><br>
								<textarea id = "wadvice2" name="wAdvice" contenteditable="true" rows="5" cols="40" style="margin-left: 50px" name="detailsText" ></textarea>
								<textarea id = "wdescribe2" name="wDescribe" contenteditable="true" rows="5" cols="40" style="margin-left: 115px" name="detailsText" ></textarea><br>
								商品详情：<br>
								<textarea id = "wdetails2" name="wDetails" contenteditable="true" rows="4" cols="102" style="margin-left: 50px" name="detailsText"></textarea>
								<input type="hidden" id = "suibain" name="suibaina" > 
							
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">关闭
							</button>
							<button type="button" class="btn btn-primary" id = "update">
								提交更改
							</button>
						</div>
						
						</form>
					</div><!-- /.modal-content -->
				</div><!-- /.modal -->
			</div>
		</div>
					
				</div>
			</div>
			<!-- END MAIN CONTENT -->
	<div id = "pages" style="margin: -70px 100px 0px 0;float: right;" >
		总共${pageData.total}条数据&nbsp;
		
	           当前页:${pageData.page>pageData.getTotalPage()?pageData.getTotalPage():pageData.page}/${pageData.getTotalPage()} &nbsp;
	    <a href="javascript:goPage(1,${pageData.pageSize})">首页</a>&nbsp;
	    <a href="javascript:goPage(${pageData.page-1==0?1:pageData.page-1},${pageData.pageSize})">上一页</a>&nbsp;
	  
	    <%-- <c:forEach begin="${pageDate.pageIndex.beginIndex}"
			end="${pageDate.pageIndex.endIndex}" var="index">

			<c:choose>
					<c:when test="${index!=pageData.page}">
						<span style="color:red;">${index}</span>
					</c:when>
			</c:choose>
			<c:choose>
					<c:when test="${index!=pageData.page}">
						<a href="javascript:goPage(${index},${pageDate.pageSize})">${index}</a>
					</c:when>
			</c:choose>
			
		</c:forEach> --%>
		<c:forEach begin="${pageData.pageIndex.beginIndex}"
			end="${pageData.pageIndex.endIndex}" step="1" var="index">

			
			<c:choose>
					<c:when test="${index==pageData.page}">
						<span style="color:red;">${index}</span>
					</c:when>
			</c:choose>
			<c:choose>
					<c:when test="${index!=pageData.page}">
						<a href="javascript:goPage(${index},${pageData.pageSize})">${index}</a>
					</c:when>
			</c:choose>
			
		</c:forEach>

		
	    <a href="javascript:goPage(${pageData.page+1==pageData.getTotalPage()?pageData.getTotalPage():pageData.page+1},${pageData.pageSize})">下一页</a>&nbsp;
	    <a href="javascript:goPage(${pageData.getTotalPage()},${pageData.pageSize})">尾页</a>
	    
	 <form action="/Lafite/WineServlet?tag=list" id="pageSizeForm"   method="post" style="display: inline;">
	    当前页
	 	<select name="pageSize" id="selectPageSize"  onchange="setPageSize(${pageData.page})">
			<option ${pageData.pageSize==3?"selected='selected'":"" }>3</option>
			<option ${pageData.pageSize==5?"selected='selected'":"" }>5</option>
			<option ${pageData.pageSize==8?"selected='selected'":"" }>8</option>
			<option ${pageData.pageSize==10?"selected='selected'":"" }>10</option>
		</select> 
	  条数据&nbsp;
	    跳到<input type="number" id="jumpPage"  name="current" min="1" max = "${pageData.getTotalPage()}" 
	    value= "${pageData.page>pageData.getTotalPage()?pageData.getTotalPage():pageData.page}" style="width: 50px;">页
	    <input type="button" value="GO" onclick="setCurrentPage(${pageData.pageSize});">
	 </form>   
	   
	</div>
			
		</div>
		<!-- END MAIN -->
		<footer>
			<div class="container-fluid">
			</div>
		</footer>
	</div>
	<!-- END WRAPPER -->
	<!-- Javascript -->
	<script src="assets/vendor/jquery/jquery.min.js"></script>
	<script src="assets/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js"></script>
	<script src="assets/vendor/toastr/toastr.min.js"></script>
	<script src="assets/scripts/klorofil-common.js"></script>
	<script type="text/javascript">
		//删除红酒(下架)
		function del(wineId){
				var msg="确认删除吗";
				if(confirm(msg)==true){
					location.href="../WineServlet?tag=delete&windId="+wineId+"";
					return true;
				}
		}
		
		//设置页面大小
	   function setPageSize(currentPage){
	     var pageSize =$("#selectPageSize").val();
	        //将当前页面的值 存放在高级查询表单隐藏域中
	     $("#pageSizeInput").val(pageSize);
	     $("#currentPageInput").val(currentPage);
	      //提交高级查询的表单
	     $("#listForm").submit();
	   } 
	   
	   function goPage(currentPage,pageSize){
	      
	      //将当前页面的值 存放在高级查询表单隐藏域中
	      $("#currentPageInput").val(currentPage);
	      $("#pageSizeInput").val(pageSize);
	      
	      //提交高级查询的表单
	      $("#listForm").submit();
	   }
	   
	   function setCurrentPage(pageSize){
	     var currentPage = $("#jumpPage").val();
	    //将当前页面的值 存放在高级查询表单隐藏域中
	      $("#currentPageInput").val(currentPage);
	      $("#pageSizeInput").val(pageSize);
	      //提交高级查询的表单
	      $("#listForm").submit();
	   }
	   $(function () { $("[data-toggle='tooltip']").tooltip(); });
	   
	   
	</script>
</body>

</html>
