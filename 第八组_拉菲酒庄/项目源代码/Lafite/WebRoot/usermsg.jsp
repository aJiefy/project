<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="en">

<head>
<title>用户资料</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<!-- VENDOR CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/admin/assets/vendor/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/admin/assets/vendor/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/admin/assets/vendor/linearicons/style.css">
<!-- MAIN CSS -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/admin/assets/css/main.css">
<!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/admin/assets/css/demo.css">
<!-- GOOGLE FONTS -->
<link
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700"
	rel="stylesheet">
<!-- ICONS -->
<link rel="apple-touch-icon" sizes="76x76"
	href="${pageContext.request.contextPath}/admin/assets/img/apple-icon.png">
<link rel="icon" type="image/png" sizes="96x96"
	href="${pageContext.request.contextPath}/admin/assets/img/favicon.png">
<script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/file.js"></script>
</head>

<body>
	<!-- WRAPPER -->

	<div id="wrapper">
		<!-- NAVBAR -->
		<nav class="navbar navbar-default navbar-fixed-top">
			<div class="brand">
				<a href="index.jsp"><img src="/Lafite/admin/assets/img/logo-dark.png"
					alt="Klorofil Logo" class="img-responsive logo"> </a>
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
								class="btn btn-primary">Go</button> </span>
					</div>
				</form>
				<c:forEach items="${auser}" var="po" varStatus="vs">
					<div id="navbar-menu">
						<ul class="nav navbar-nav navbar-right">
							<li class="dropdown"></li>
							
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown"> <!--用户头像  --> 
								
								<c:if test="${po.USER_HEADIMG ==null }">
									<img src="/Lafite/admin/assets/img/user2.png" class="img-circle" alt="Avatar">
								</c:if>
								<c:if test="${po.USER_HEADIMG !=null }">
									<img src="${po.USER_HEADIMG}" class="img-circle" alt="Avatar">
								</c:if>
								<span>${po.USER_NAME}</span><i
									class="icon-submenu lnr lnr-chevron-down"></i> </a>
								<ul class="dropdown-menu">
									<li><!-- <a href="#jibenziliao"> --><a href="./userServlet?cmd=usermsg"><i class="lnr lnr-user"></i>
											<span>基本资料</span> </a></li>
									<li><a href="./userServlet?cmd=usermsg"><i class="lnr lnr-envelope"></i>
											<span>修改密码</span> </a></li>
									<li><a href="#wodedingdan"><i class="lnr lnr-cog"></i>
											<span>我的订单</span> </a></li>
									<li><a href="index.jsp"><i class="lnr lnr-exit"></i> <span>返回</span>
									</a></li>
								</ul>
							</li>

						</ul>
					</div>
			</div>
		</nav>
		<!-- END NAVBAR -->



		<!-- 左侧导航栏 -->
		<div id="sidebar-nav" class="sidebar">
			<div class="sidebar-scroll">

				<!--左侧的便签链接  -->
				<nav>
					<ul class="nav">
						<li><a href="./userServlet?cmd=usermsg" class="active"><i class="lnr lnr-user"></i> <span>修改信息</span>
						</a>
						<li><a href="./index.jsp"><i class="lnr lnr-home"></i> <span>Lafite</span>
						</a>
						</li>
						<li><a href="./index.jsp"><i class="lnr lnr-exit"></i> <span>返回</span>
						</a></li>
					</ul>
				</nav>
			</div>
		</div>
		<!-- END LEFT SIDEBAR -->

		<!-- 主题部分 -->
		<div class="main">
			<!-- MAIN CONTENT -->
			<div class="main-content">
				<div class="container-fluid">



					<div class="container">
						<div class="row clearfix">
							<div class="col-md-12 column"></div>

							<!-- 基本信息开始 -->
							<div id="jibenziliao" style="margin-left: 100px;">
								<span style="font-size: 15px;color: #00ccee;"><b>基本资料</b>
								</span>
								<div class="one_half first" style="margin-left: 50px;">
									<div style="height: 30px;width: 30px; display: inline;">
										<c:if test="${po.USER_HEADIMG ==null }">
										<img src="/Lafite/admin/assets/img/user2.png" style="height: 100px;width: 100px;" class="img-circle" alt="Avatar">
									</c:if>
									<c:if test="${po.USER_HEADIMG !=null }">
										<img src="${po.USER_HEADIMG}" style="height: 100px;width: 100px;" class="img-circle" alt="Avatar">
									</c:if>
										
									</div>

									<div class="column_content">
										<br /> <span style="font-size: 15px;">用&nbsp;&nbsp;户&nbsp;&nbsp;名</span>&nbsp;&emsp;
										<span style="font-size: 15px;" id="username">${po.USER_NAME}
										</span>
										<div class="one_half first">
											<div class="column_content">
												<br /> <span style="font-size: 15px;">联系方式</span>&emsp; <span
													style="font-size: 15px;" id="usertel">${po.USER_TEL}</span>

											</div>
										</div>
									</div>
								</div>
								</c:forEach>
								<!-- 基本信息结束 -->
								
								<!--模态框开始  -->
								<div class="container">
									<div class="row clearfix">
										<div class="col-md-12 column">
											<a id="modal-443731" href="#modal-container-443731"
												role="button" class="btn" data-toggle="modal"
												style="margin: 20px 0 20px 37px;">修改资料</a>

											<div class="modal fade" id="modal-container-443731"
												role="dialog" aria-labelledby="myModalLabel"
												aria-hidden="true">
												<div class="modal-dialog">
													<div class="modal-content">
														<div class="modal-header">
															<button type="button" class="close" data-dismiss="modal"
																aria-hidden="true">×</button>
															<h4 class="modal-title" id="myModalLabel">修改资料</h4>
														</div>
														<div class="modal-body">
															
															<!--基本资料开始  -->
															<form action="/Lafite/userServlet?cmd=updatemsg" method="post" enctype="multipart/form-data">
															<div id="jibenziliao" style="margin-left: 50px;">

																<div class="one_half first" style="margin-left: 50px;">
																	<div class="column_content">
																		<div id="preview">
																			<img id="imghead" border=0  src="${USER_IN_SESSION.USER_HEADIMG}"
																				style="height: 100px;width: 100px;" />
																			<%-- <input type="hidden" name="origin-headimg" value="${USER_IN_SESSION.USER_HEADIMG}"> --%>
																		</div>
																		<input type="file" onchange="previewImage(this)"name="upd-headimg" /> <br />
																		<span style="font-size: 15px;"> 性别</span>&emsp;&emsp;
																		<select name="sex" style="font-size: 15px;" id="sex">
																			<c:if test="${USER_IN_SESSION.USER_SEX =='male'}">
																			 <option selected="selected" value="${USER_IN_SESSION.USER_SEX}">${USER_IN_SESSION.USER_SEX}</option>
																			 <option value="female">female</option>
																			</c:if>
																			<c:if test="${USER_IN_SESSION.USER_SEX == 'female'}">
																			 <option selected="selected" value="${USER_IN_SESSION.USER_SEX}">${USER_IN_SESSION.USER_SEX}</option>
																			 <option value="male">male</option>
																			</c:if>
																		</select>
																	</div>
																</div>
																<div class="one_half first" style="margin-left: 50px;">
																	<div class="column_content">
																		<br /> <span style="font-size: 15px;">生日</span>&emsp;&emsp;
																		<input type="text" name="upd-birth" value="${USER_IN_SESSION.USER_BIRTHDAY }" placeholder="2000-02-02" required="required">
																	</div>
																</div>
																<div class="space"></div>

																<div class="one_half first" style="margin-left: 50px;">
																	<div class="column_content">
																		<br /> <span style="font-size: 15px;">详细住址</span>&emsp;&emsp;<br />
																		<br />
																		<textarea rows="3" placeholder="省份-城市-区..."
																			cols="50" maxlength="50"  onblur="checkLocIsNull();"
																			style="font-size: 15px; color: black;" id="address" name="upd-address">${USER_IN_SESSION.USER_LOC==null?null:USER_IN_SESSION.USER_LOC}</textarea>
																	</div>
																</div>
																<div class="one_half first">
																	<div class="column_content"></div>
																</div>
																<div style="margin-left: 50px;">
																	<br />
																</div>
															</div>
															<br />
														</div>
														<div class="modal-footer">
															<button type="button" class="btn btn-default"
																data-dismiss="modal">关闭</button>
															<button type="submit" class="btn btn-primary">保存</button>
														</div>
														</form>
														<!--基本资料结束  -->
													</div>

												</div>

											</div>

										</div>
									</div>
								</div>
								<!-- 模态框结束 -->
								

								<!--上传头像开始  -->

								<!--上传头像结束  -->

								<!--修改密码开始  -->
								<div id="xiugaimima">
									<span style="font-size: 15px;color: #00ccee"><b>修改密码</b>
									</span><br /> <br />
									<form action="/Lafite/userServlet?cmd=changePwd" method="post">
										<div style="margin-left: 50px;">
											<div style="font-size: 15px;display: inline;">密&emsp;&emsp;码&emsp;</div>
											<input type="password" required="required"  onblur="checkPwd();"
												style="width:300px ;color:black;font-size: 15px;"
											    name="password" id="password"><br /> <br />
											<div style="font-size: 15px;display: inline;">新&nbsp;&nbsp;密&nbsp;&nbsp;码&nbsp;&emsp;</div>
											<input type="password" required="required"
												style="width:300px ;color:black;font-size: 15px;"
											     name="newPassword" id="newpassword"><br /> <br />
											
										<input type="submit" value="确认修改"
											style=" width: 200px;margin-left: 128px;height: 33px;">
									</form>

								</div>
								<br /> <br />
								<!--修改密码结束  -->


								<!--订单列表开始  -->
								<div id="wodedingdan">
									<span style="font-size: 15px;color: #00ccee"><b>我的订单</b>
									</span><br /> <br /> <br />
									<table class="table table-striped table-hover">
										<thead>
											<tr>
												<th>编号</th>
												<th>产品</th>
												<th>数量</th>
												<th>状态</th>
											</tr>
										</thead>
										<tbody>

											<c:forEach items="${orders}" var="pp" varStatus="vs">
												<tr>
													<td>${pp.ID}</td>
													<td>${pp.WINE_NAME}</td>
													<td>${pp.ORDER_COUNT}件</td>
													<c:if test="${pp.PAY_STATUS == null}">
													<td>未支付</td>
													</c:if>
													<c:if test="${pp.PAY_STATUS != null}">
													<td>已支付</td>
													</c:if>
												</tr>

											</c:forEach>

											
										</tbody>
									</table>
								</div>
								<!--订单列表结束  -->
								


							</div>
						</div>
					</div>

				</div>
			</div>
			<!-- END MAIN CONTENT -->
		</div>
		<!-- END MAIN -->
		<div class="clearfix"></div>
		<footer>
			<div class="container-fluid">
				<p class="copyright">&copy; 2017.Lafite</p>
		</footer>
	</div>
	<!-- END WRAPPER -->
	<!-- Javascript -->
	<script src="${pageContext.request.contextPath}/admin/assets/vendor/jquery/jquery.min.js">
</script>
	<script src="${pageContext.request.contextPath}/admin/assets/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/admin/assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js"></script>
	<script src="${pageContext.request.contextPath}/admin/assets/scripts/klorofil-common.js"></script>

 	<!-- <script type="text/javascript">//生成日期
	function creatDate() {
		//生成1900年-2100年
		for ( var i = 2017; i >= 1950; i--) {
			//创建select项
			var option = document.createElement('option');
			option.setAttribute('value', i);
			option.innerHTML = i;
			sel1.appendChild(option);
		}
		//生成1月-12月
		for ( var i = 1; i <= 12; i++) {
			var option1 = document.createElement('option');
			option1.setAttribute('value', i);
			option1.innerHTML = i;
			sel2.appendChild(option1);
		}
		//生成1日—31日
		for ( var i = 1; i <= 31; i++) {
			var option2 = document.createElement('option');
			option2.setAttribute('value', i);
			option2.innerHTML = i;
			sel3.appendChild(option2);
		}
	}
	creatDate();
	//保存某年某月的天数
	var days;

	//年份点击 绑定函数
	sel1.onclick = function() {
		//月份显示默认值
		sel2.options[0].selected = true;
		//天数显示默认值
		sel3.options[0].selected = true;
	}
	//月份点击 绑定函数
	sel2.onclick = function() {
		//天数显示默认值
		sel3.options[0].selected = true;
		//计算天数的显示范围
		//如果是2月
		if (sel2.value == 2) {
			//判断闰年
			if ((sel1.value % 4 === 0 && sel1.value % 100 !== 0)
					|| sel1.value % 400 === 0) {
				days = 29;
			} else {
				days = 28;
			}
			//判断小月
		} else if (sel2.value == 4 || sel2.value == 6 || sel2.value == 9
				|| sel2.value == 11) {
			days = 30;
		} else {
			days = 31;
		}

		//增加或删除天数
		//如果是28天，则删除29、30、31天(即使他们不存在也不报错)
		if (days == 28) {
			sel3.remove(31);
			sel3.remove(30);
			sel3.remove(29);
		}
		//如果是29天
		if (days == 29) {
			sel3.remove(31);
			sel3.remove(30);
			//如果第29天不存在，则添加第29天
			if (!sel3.options[29]) {
				sel3.add(new Option('29', '29'), null)
			}
		}
		//如果是30天
		if (days == 30) {
			sel3.remove(31);
			//如果第29天不存在，则添加第29天
			if (!sel3.options[29]) {
				sel3.add(new Option('29', '29'), null)
			}
			//如果第30天不存在，则添加第30天
			if (!sel3.options[30]) {
				sel3.add(new Option('30', '30'), null)
			}
		}
		//如果是31天
		if (days == 31) {
			//如果第29天不存在，则添加第29天
			if (!sel3.options[29]) {
				sel3.add(new Option('29', '29'), null)
			}
			//如果第30天不存在，则添加第30天
			if (!sel3.options[30]) {
				sel3.add(new Option('30', '30'), null)
			}
			//如果第31天不存在，则添加第31天
			if (!sel3.options[31]) {
				sel3.add(new Option('31', '31'), null);
			}
		}
	}

	//结果显示 设置好日期时间后 弹窗通知
	box.onclick = function() {
		//当年、月、日都已经为设置值时
		if (sel1.value != 'year' && sel2.value != 'month'
				&& sel3.value != 'day') {
			alert("日期时间已经设定好");
		}
		
	}

	</script> -->
	
	<script type="text/javascript">
	//验证密码
	/* function checkPwd() {
		pwd=$("input[name='password']").val();
 	  
	} */
	
	//验证地址是否为空
	function checkLocIsNull(){
		if($("#address").val() == ""){
			alert("亲，请输入地址！");
		}
	
	}
	
	function previewImage(file) {
		var MAXWIDTH = 100;
		var MAXHEIGHT = 100;
		var div = document.getElementById('preview');
		if (file.files && file.files[0]) {
			div.innerHTML = '<img id=imghead>';
			var img = document.getElementById('imghead');
			img.onload = function() {
				var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT,
						img.offsetWidth, img.offsetHeight);
				img.width = rect.width;
				img.height = rect.height;
				img.style.marginLeft = rect.left + 'px';
				img.style.marginTop = rect.top + 'px';
			}
			var reader = new FileReader();
			reader.onload = function(evt) {
				img.src = evt.target.result;
			}
			reader.readAsDataURL(file.files[0]);
		} else { //兼容IE
			var sFilter = 'filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src="';
			file.select();
			var src = document.selection.createRange().text;
			div.innerHTML = '<img id=imghead>';
			var img = document.getElementById('imghead');
			img.filters.item('DXImageTransform.Microsoft.AlphaImageLoader').src = src;
			var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth,
					img.offsetHeight);
			status = ('rect:' + rect.top + ',' + rect.left + ',' + rect.width
					+ ',' + rect.height);
			div.innerHTML = "<div id=divhead style='width:"+rect.width+"px;height:"+rect.height+"px;margin-top:"+rect.top+"px;"+sFilter+src+"\"'></div>";
		}
	}

	function clacImgZoomParam(maxWidth, maxHeight, width, height) {
		var param = {
			top : 0,
			left : 0,
			width : width,
			height : height
		};
		if (width > maxWidth || height > maxHeight) {
			rateWidth = width / maxWidth;
			rateHeight = height / maxHeight;
			if (rateWidth > rateHeight) {
				param.width = maxWidth;
				param.height = Math.round(height / rateWidth);
			} else {
				param.width = Math.round(width / rateHeight);
				param.height = maxHeight;
			}
		}
		param.left = Math.round((maxWidth - param.width) / 2);
		param.top = Math.round((maxHeight - param.height) / 2);
		return param;
	}
</script>
</body>

</html>