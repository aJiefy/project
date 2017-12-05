<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html lang="en">
<head>
	<title>Home</title>
	<meta charset="UTF-8">
	<meta name="description" content="">
	<meta name="keywords" content="">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- Favicon --> 
	<link rel="stylesheet" type="text/css" href="style/css/origin.css"/>
	<link href="images/favicon.ico" rel="shortcut icon">

	<!-- Stylesheets -->
	<link rel="stylesheet" href="style/css/bootstrap.min.css">
	<link rel="stylesheet" href="style/css/font-awesome.min.css">
	<link rel="stylesheet" href="style/css/owl.carousel.css">
	<link rel="stylesheet" href="style/css/magnific-popup.css">
	<link rel="stylesheet" href="style/css/reset.css">
	<link rel="stylesheet" href="style/css/style.css">
	


	<!--[if lt IE 9]>
	  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->

	<!-- ==== MODERNIZR ==== -->
    <script src="style/js/modernizr.js"></script>
    
</head>
<body>

	<!-- ==== Preloader Section Start ==== -->
	<div id="preloader">
        <div class="pre-container">
            <div class="spinner">
                <div class="double-bounce1"></div>
                <div class="double-bounce2"></div>
            </div>
        </div>
    </div>
	<!-- ==== Preloader Section End ==== -->
	
	<!-- ==== Navigation Start ==== -->
	<nav style="height: 70px">
        <div class="row">
            <div class="container">
                
                
                <div class="basic-wrapper">
	         	<a class="btn responsive-menu pull-right" data-toggle="collapse" data-target=".navbar-collapse">
	        	<i class='icon-menu-1'></i></a> 
	        	<a class="navbar-brand" href="index.jsp">
	        	<img src="style/images/lafite.png" style="height: 105px; margin-top: -25px;" /></a> 
                </div>
                
                
                <ul class="nav-menu">
                    <li style="font-size: 21px; padding-right: 9px;"><a href="index.jsp">Home</a></li>
                    <li style="font-size: 21px; padding-right: 9px;"><a href="index.jsp#about">About</a></li>
                    <li style="font-size: 21px; padding-right: 9px;"><a href="index.jsp#contact">Contact</a></li>
                    <c:if test="${sessionScope.USER_IN_SESSION.USER_NAME != null}">
                    <li style="font-size: 21px; padding-right: 9px;" class="dropdown">
                    	<a href="#" class="dropdown-toggle js-activated" id="username">${sessionScope.USER_IN_SESSION.USER_NAME}</a>
                    	<ul class="dropdown-menu">
	              		<li><a href="userServlet?cmd=usermsg"><i class="lnr lnr-user"></i> <span>Profile</span></a></li>
	              		<li><a id="mycart" href="cartServlet?cmd=mycart">Cart</a></li>
	              		<li><a id="order" href="orderServlet?cmd=myorder">Order</a>
	              		<li><a href="${pageContext.request.contextPath}/userServlet?cmd=logout">log out</a></li>
	              </ul>
	            	</li>
                    </c:if>
                    <c:if test="${sessionScope.USER_IN_SESSION.USER_NAME == null}">
	            		<li style="font-size: 21px; padding-right: 9px;"><a href="javascript:login();">Login in</a></li>
	            		<li style="font-size: 21px; padding-right: 9px;"><a href="javascript:location.href='register.jsp';">Sign up</a></li>
           			</c:if>
                </ul>
                
          
        
                <!--<div class="logo">

                    <img src="img/lafite.png" style="height: 70px;"/>

                   

                </div>

                <div class="mobile-bar"><span></span></div>

                <ul class="nav-menu">

                    <li style="font-size: 50px;"><a href="#home">Home</a></li>

                    <li><a href="#about">About</a></li>

                    <li><a href="#portfolio">Portfolio</a></li>

                    <li><a href="#blog">Blog</a></li>

                    <li><a href="#contact">Contact</a></li>

                </ul>-->
            </div>
        </div>
    </nav>
    <!-- ==== Navigation End ==== -->


	<!-- ==== Intro Section Start ==== -->
	<section class="intro-section" id="home">
		<div class="intro-content">
			
			
			
			
			<div class="container">
			<!--头部-->
			<div id="Head" class="row clearfix">
				
				<div class="col-md-12 column">
					<div class="row clearfix">
						
						<!--左侧信息-->
						<div id="MessageLeft" class="col-md-4 column">
							<div id="MessageLeftHead" class="row clearfix">
								<div class="col-md-12 column">
									<!--<p id="PHead" style="padding: 20px; height: 100px;">-->
										<!-- <font color="#b89d63" size="41px"><i><b>拉菲罗斯柴尔德传奇波尔多红</b></i></font> -->
										<font color="#b89d63" size="41px"><i><b><span id="name">${Wine.get(0).WINE_NAME }</span></b></i></font>
								</div>
							</div>
							<div class="row clearfix">
								<div class="col-md-12 column">
									<p id="PBody">
										${Wine.get(0).WINE_DESCRIBE}
									</p>
									<p id="PBody">
										
									</p>
								</div>
							</div>
						</div>
						
						<!--图片信息-->
						<div id="MessageImage" class="col-md-4 column">
							<img src="${Wine.get(0).WINE_IMG}"/>
						</div>
						
						<!--右侧信息-->
						<div id="MessageRight" class="col-md-4 column">
							<div class="row clearfix">
								<div class="col-md-12 column">
									<h4>
										<font color="#b89d63">酒中葡萄品种：</font>
									</h4>
									<p>
										卡本妮苏维翁、梅洛和卡本妮弗朗克
									</p>
									<h4>
										<font color="#b89d63">价格：</font>
									</h4>
									<p>
										￥<span id="money">${Wine.get(0).WINE_PRICE}</span>
									</p>
									<h4>
										<font color="#b89d63">平均年产量：</font>
									</h4>
									<p>
										${Wine.get(0).WINE_YIELD}万箱(6瓶/箱)
									</p>
								</div>
							</div>
							<div id="MessageRightBody" class="row clearfix">
								<div class="col-md-12 column">
									<h4>
										<font color="#b89d63">品酒建议</font>
									</h4>
									<p>
										${Wine.get(0).WINE_ADVICE}
									</p>
								</div>
								<div id="buy">
									<!-- <button id="a1">-</button> -->
									
									
									<input id="img" type="hidden" value="${Wine.get(0).WINE_IMG}">
									<!-- <button id="a2">+</button> -->
									<a id="a4">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
									<c:if test="${sessionScope.USER_IN_SESSION.USER_NAME != null}">
										<input type="number" min="1" id="inputcss" value="1">
										<button id="a3">加入购物车</button>
									</c:if>
									
								</div>
							</div>
						</div>
					</div>
					
					<!--左右翻页-->
					<!-- <div id="PageChange" class="row clearfix">
						<div class="col-md-12 column">
							<a id="a1">返回葡萄酒</a>
							
							<a id="a2">下一页</a>
							<a id="a2">上一页</a>
							
								
						</div>
					</div> -->
				</div>
			</div>
			
			</div>
			
			
			
		</div>
		<a href="#about" class="down">
			<i class="fa fa-angle-down"></i>
		</a>
	</section>
	<!-- ==== Intro Section End ==== -->


	<!-- ==== About Section Start ==== -->
	<section class="about-section spad" id="about" style="margin-bottom: 100px;">
		<div class="container">
			<div class="row clearfix">
				<div id="Year" class="col-md-12 column">
					<span>
						<font color="#b89d63" size="7"><i><b>年份</b></i></font>
					</span>
					<div id="YearChange">
					<p>
						<font size="5"><b><i>${Wine.get(0).WINE_BORN}</i></b></font>
					</p>
					</div>
				</div>
			</div>
			<div class="row clearfix">
				<div class="col-md-12 column">
					<p id="informatP1">
						50%白苏维翁 - 40%谢蜜雍 - 10%灰苏维翁 
					</p>
					<div class="row clearfix">
						<!-- <div class="col-md-4 column"> -->
							<p id="informatP2">
								${Wine.get(0).WINE_DETAIL}
							</p>
						<!-- </div>
						<div class="col-md-8 column">
							<p id="informatP3">
								萄酒丰美、可口、果香浓郁，蕴含的单宁拥有极少见的成熟度，颜色极其深浓。8月后两周的高温夜晚对白葡萄品种来说并不理想，不过，在两海间这片出产我们所需的白葡萄的地区，酒度和酸度之间的平衡堪称完美，香气奔放四射。
							</p>-->
							<div id="informatDiv"> 
								<p id="informatP4">品酒笔记（灌瓶时）</p><br />
								颜色：淡淡的麦秆黄色，晶莹璀璨。
								香气：细腻、芬芳，柑橘（柚子、青柠檬）与热带水果的香气（热情果）水乳交融。
								口感：本款酒清新、爽利、魅力非凡，香气盈溢，以热带果香收尾。
							</div >
						<!-- </div> -->
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- ==== About Section End ==== -->


	


	<!-- ==== Footer Start ==== -->
	<footer>
		<div class="container">
			<div class="social">
				<a href=""><i class="fa fa-facebook"></i></a>
				<a href=""><i class="fa fa-twitter"></i></a>
				<a href="#"><i class="fa fa-behance"></i></a>
                <a href="#"><i class="fa fa-dribbble"></i></a>
			</div>
			<p>Copyright &copy; 2017.Company name All rights reserved.</p>
		</div>
	</footer>
	<!-- ==== Footer End ==== -->


	<!-- ==== Jquery and other scripts ==== -->
	<script src="style/js/jquery-2.1.4.min.js"></script>
	<script src="style/js/jquery.nav.js"></script>
	<script src="style/js/imagesloaded.pkgd.min.js"></script>
	<script src="style/js/isotope.pkgd.min.js"></script>
	<script src="style/js/owl.carousel.min.js"></script>
	<script src="style/js/magnific-popup.min.js"></script>
	<script src="style/js/main.js"></script>
	
	<script src="style/js/twitter-bootstrap-hover-dropdown.min.js"></script> 
	<script src="style/js/jquery.fitvids.js"></script> 
	<script src="style/js/scripts.js"></script> 
	<script src="style/js/function.js"></script>
	
	<script type="text/javascript" src="style/js/Wine/wineDetail.js"></script>
</body>
</html>

