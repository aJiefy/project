<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" href="style/images/favicon.png">
<title>Lafite</title>
<!-- Bootstrap core CSS -->
<link href="style/css/indexImages.css" rel="stylesheet">
<link href="style/css/bootstrap.css" rel="stylesheet">
<link href="style/css/settings.css" rel="stylesheet">
<link href="style/css/owl.carousel.css" rel="stylesheet">
<link href="style/js/google-code-prettify/prettify.css" rel="stylesheet">
<link href="style/js/fancybox/jquery.fancybox.css" rel="stylesheet" type="text/css" media="all" />
<link href="style/js/fancybox/helpers/jquery.fancybox-thumbs.css?v=1.0.2" rel="stylesheet" type="text/css" />
<link href="style.css" rel="stylesheet">
<link href="style/css/color/blue.css" rel="stylesheet">

<!-- <link href='http://fonts.useso.com/css?family=Josefin+Sans:400,600,700,400italic,600italic,700italic' rel='stylesheet' type='text/css'>
<link href='http://fonts.useso.com/css?family=Raleway:400,300,500,600,700,800,900' rel='stylesheet' type='text/css'>
<link href='http://fonts.useso.com/css?family=Dosis:200,300,400,500,600,700,800' rel='stylesheet' type='text/css'> -->

<link href="style/type/fontello.css" rel="stylesheet">
<link href="style/type/budicons.css" rel="stylesheet">

<!-- .body-wrapper --> 
<script src="style/js/jquery.min.js"></script> 
<script src="style/js/bootstrap.min.js"></script> 

<script type="text/javascript" src="style/js/function.js"></script>

<script src="style/js/twitter-bootstrap-hover-dropdown.min.js"></script> 
<script src="style/js/jquery.themepunch.plugins.min.js"></script> 
<script src="style/js/jquery.themepunch.revolution.min.js"></script> 
<script src="style/js/jquery.easytabs.min.js"></script> 
<script src="style/js/owl.carousel.min.js"></script> 
<script src="style/js/jquery.isotope.min.js"></script> 
<script src="style/js/jquery.fitvids.js"></script> 
<script src="style/js/jquery.fancybox.pack.js"></script> 
<script src="style/js/fancybox/helpers/jquery.fancybox-thumbs.js?v=1.0.2"></script> 
<script src="style/js/fancybox/helpers/jquery.fancybox-media.js?v=1.0.0"></script> 
<script src="style/js/jquery.slickforms.js"></script> 
<script src="style/js/instafeed.min.js"></script> 
<script src="style/js/retina.js"></script> 
<script src="style/js/google-code-prettify/prettify.js"></script> 
<script src="style/js/scripts.js"></script> 
<script type="text/javascript" src="style/js/Wine/Wine.js" charset="UTF-8"></script>


<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="style/js/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
      <![endif]-->
</head>
<body>
<div class="body-wrapper">
  <div class="navbar default">
    <div class="navbar-header">
      <div class="container">
        <div class="basic-wrapper">
         	<a class="btn responsive-menu pull-right" data-toggle="collapse" data-target=".navbar-collapse">
        	<i class='icon-menu-1'></i></a> 
        	<a class="navbar-brand" href="index.jsp">
        	<img src="style/images/lafite.png" style="height: 75px;" /></a> 
        </div>
        	
        <nav class="collapse navbar-collapse pull-right">
          <ul class="nav navbar-nav">
            <li><a href="index.jsp">Home</a></li>
            <li><a href="index.jsp#about">About</a></li>
            <li><a href="#container">Contact</a></li>
        
        	
        	<c:if test="${sessionScope.USER_IN_SESSION.USER_NAME != null}">
	        	<li class="dropdown"><a href="#" class="dropdown-toggle js-activated" id="username">${sessionScope.USER_IN_SESSION.USER_NAME}</a>
	             
	              <ul class="dropdown-menu">
	              	<li><a href="userServlet?cmd=usermsg"><i class="lnr lnr-user"></i> <span>Profile</span></a></li>
	              	<li><a id="mycart" href="cartServlet?cmd=mycart">Cart</a></li>
	              	<li><a id="order" href="orderServlet?cmd=myorder">Order</a>
	             	
	              	<li><a href="${pageContext.request.contextPath}/userServlet?cmd=logout">log out</a></li>
	              </ul>
	            </li>
	            
            </c:if>
            
            <c:if test="${sessionScope.USER_IN_SESSION.USER_NAME == null}">
	            <li><a href="javascript:login();">Login in</a></li>
	            <li><a href="javascript:location.href='register.jsp';">Sign up</a></li>
            </c:if>
            
            
          </ul>
        </nav>
      </div>
    </div>
    <!--/.nav-collapse --> 
  </div>
  
  <!--/.navbar -->
  <div id="home" class="section">
    <div class="light-wrapper">
      <div class="fullscreenbanner-container revolution">
        <div class="fullscreenbanner">
          <ul>
            <li data-transition="fade"> <img src="style/images/art/slider-bg1.jpg" alt="" style="height: 550px;"/>
              <div class="caption large lite sfb" data-x="center" data-y="245" data-speed="900" data-start="800" data-easing="Sine.easeOut">Welcome to Chateau Lafite Rothschild</div>
              <div class="caption small lite sfb" data-x="center" data-y="319" data-speed="900" data-start="1500" data-easing="Sine.easeOut">Château Lafite Rothschild is a wine estate in France, owned by members of the Rothschild family since the 19th century.</div>
              <div class="caption small sfb" data-x="center" data-y="362" data-speed="900" data-start="2200" data-easing="Sine.easeOut">
                <div class="smooth"><a href="#portfolio" class="btn btn-border-lite">See Our Products</a></div>
              </div>
            </li>
            
            <li data-transition="fade"> <img src="style/images/art/slider-bg2.jpg" alt="" style="height: 550px;"/>
              <div class="caption large lite sfb" data-x="center" data-y="245" data-speed="900" data-start="800" data-easing="Sine.easeOut">Here's the best wines in the world</div>
              <div class="caption small lite sfb" data-x="center" data-y="329" data-speed="900" data-start="1500" data-easing="Sine.easeOut" >Welcome to visit and purchase Chateau Lafite</div>
            </li>
            <li data-transition="fade"> <img src="style/images/art/slider-bg3.jpg" alt="" style="height: 550px;"/>
              <div class="caption large lite sfb" data-x="center" data-y="245" data-speed="900" data-start="800" data-easing="Sine.easeOut">Your needs are important</div>
              <div class="caption small lite sfb" data-x="center" data-y="319"  data-speed="900" data-start="1500" data-easing="Sine.easeOut">Because great design comes with understanding customer needs</div>
              <div class="caption small sfb" data-x="center" data-y="362" data-speed="900" data-start="2200" data-easing="Sine.easeOut">
                <div class="smooth"><a href="#contact" class="btn btn-border-lite">Get in Touch</a></div>
              </div>
            </li>
          </ul>
          <div class="tp-bannertimer tp-bottom"></div>
        </div>
        <!-- /.fullscreenbanner --> 
      </div>
      <!-- /.fullscreenbanner-container --> 
    </div>
  </div>

  </div>
  <!-- /.parallax -->
  
   <div id="portfolio" class="section anchor">
    <div class="dark-wrapper">
      <div class="container inner">
        <h2 class="section-title text-center">Our Awesome Products</h2>
        <div class="grid-portfolio fix-portfolio">
           <ul id="filterul" >
            <li ><a id="wineall" href="javascript:Wineall()"><i>全部&nbsp;&nbsp;/&nbsp;</i></a></li>
        	<!--
        	<li><a href="#" data-filter=".web">传奇系列</a></li>
            <li><a href="#" data-filter=".graphic">传说系列</a></li>
            <li><a href="#" data-filter=".photo">珍藏系列</a></li>
            <li><a href="#" data-filter=".motion">珍酿系列</a></li>
            -->
            <li><a id="winecq" href="javascript:Winecq()" ><i>传奇系列&nbsp;/&nbsp;</i></a></li>
            <li><a href="javascript:Winecs()" ><i>传说系列&nbsp;/&nbsp;</i></a></li>
            <li><a href="javascript:Winezc()" ><i>珍藏系列&nbsp;/&nbsp;</i></a></li>
            <li><a href="javascript:Winezn()" ><i>珍酿系列</i></a></li>
            
          </ul>
          
          <!-- /filter商品列表class="info" filterUL  class="content-slider items" class="item thumb web"-->
          
          <ul id="filterUL"  >
          	<!--  dynamic get the wine　information from oracle databases -->
          </ul>
          
          <!-- /filter商品分类 -->
          <!-- /.items --> 
        </div>
        <!-- /.portfolio --> 
      </div>
    </div>
  </div>
  <!-- /#portfolio -->
  
  <div class="parallax parallax2 work-together">
    <div class="container inner text-center">
      <h1>We Create Unique <span class="colored">&</span> Gorgeous Things</h1>
      <div class="divide10"></div>
      <div class="smooth"><a href="#contact" class="btn btn-border-lite">Let's Work Together</a></div>
    </div>
    <!-- /.container --> 
  </div>
  <!-- /.parallax -->
  
  <div id="about" class="section anchor">
    <div class="light-wrapper">
      <div class="container inner">
        <h2 class="section-title text-center">About the Chateau</h2>
        <p class="lead main text-center">A creative agency turning ideas into beautiful things</p>
        <div class="row">
          <div class="col-sm-8">
            <h2>Our Chateau</h2>
            <p class="lead">
				In the 18th century, the Rieussec estate belonged to the Carmelite monks in Langon. The confiscation of the estate during the revolution led to its public sale around 1790 as a “object of national heritage” to Mr. Marheilhac, owner at that time of Château La Louvière in Léognan.
			</p>
            <p>Château Rieussec was acquired by Domaines Barons de Rothschild (Lafite) in 1984. The estate then consisted of 110 hectares, 68 hectares of which were vines. To enhance Château Rieussec’s potential, rigorous measures were implemented, including meticulous sorting of the grapes and fermenting in barrels, which provides a much finer selection for the blending of the Grand Vin.</p>
            <p>The first attempts at selection were rewarded by a remarkable trio of vintages in 1988, 1989 and 1990. This was crowned by an entire decade of very good wines from 1995 to 2005. The weather proved to be no obstacle for the remarkable vintages of 1996, 1997, 1999, 2001, 2003 and 2005, among others! Furthermore, Château Rieussec 2001 was declared Wine of the Year in 2004 by Wine Spectator magazine. </p>
          </div>
          <div class="col-sm-3" style="margin:0 0 0 50px;">
            <figure><img src="style/images/lafite.png" alt="" /></figure>
          </div>
        </div>
        <div class="divide60"></div>
        <div class="row">
        	
          <div class="col-sm-4">
            <div class="section-title">
              <h3>Why Choose Us?</h3>
            </div>
            <div class="divide5"></div>
            <div class="panel-group" id="accordion">
              <div class="panel panel-default">
                <div class="panel-heading">
                  <h4 class="panel-title"> <a data-toggle="collapse" class="panel-toggle active" data-parent="#accordion" href="#collapseOne"> Celebrities said </a> </h4>
                </div>
                <div id="collapseOne" class="panel-collapse collapse in">
                  <div class="panel-body">“The wines of Sauternes are so wonderful that we wanted to have our own, and Rieussec’s vineyard is outstanding”
					Baron Eric de Rothschild
				  </div>
                </div>
              </div>
              <div class="panel panel-default">
                <div class="panel-heading">
                  <h4 class="panel-title"> <a data-toggle="collapse" class="panel-toggle" data-parent="#accordion" href="#collapseTwo"> The vineyard </a> </h4>
                </div>
                <div id="collapseTwo" class="panel-collapse collapse">
                  <div class="panel-body">One of the largest properties in Sauternes and Barsac.The Château Rieussec vineyard extends to the border of Fargues and Sauternes, and adjoins Château d’Yquem. Rieussec is one of the largest properties in Sauternes and Barsac, the vineyard covers 93 hectares of gravelly sandy-clay soil.</div>
                </div>
              </div>
              <div class="panel panel-default">
                <div class="panel-heading">
                  <h4 class="panel-title"> <a data-toggle="collapse" class="panel-toggle" data-parent="#accordion" href="#collapseThree">The cellar </a> </h4>
                </div>
                <div id="collapseThree" class="panel-collapse collapse">
                  <div class="panel-body"> Traditional winemaking and meticulous selection.The cellars are located in the heart of the Château Rieussec vineyard at Fargues. Each vintage ages in oak barrels produced mostly at DBR’s cooperage. </div>
                </div>
              </div>
            </div>
          </div>
          <div class="col-sm-4">
            <div class="section-title">
              <h3>Our Featured Services</h3>
            </div>
            <div class="services-2">
              <div class="row">
                <div class="col-sm-12">
                  <div class="bm20">
                    <div class="icon"> <i class="budicon-camera-1 icn"></i> </div>
                    <!-- /.icon -->
                    <div class="text">
                      <h4>Photography</h4>
                      <p>Nulla vitae libero, a pharetra augue. Integer posuere a ante venenatis condimentum. Donec id elit non.</p>
                    </div>
                    <!-- /.text --> 
                  </div>
                  <!-- /.div -->
                  <div class="bm20">
                    <div class="icon"> <i class="budicon-video-1 icn"></i> </div>
                    <!-- /.icon -->
                    <div class="text">
                      <h4>Motion Video</h4>
                      <p>Nulla vitae libero, a pharetra augue. Integer posuere a ante venenatis condimentum. Donec id elit non.</p>
                    </div>
                    <!-- /.text --> 
                  </div>
                  <!-- /.div -->
                  <div class="bm20">
                    <div class="icon"> <i class="budicon-radio icn"></i> </div>
                    <!-- /.icon -->
                    <div class="text">
                      <h4>Sound Design</h4>
                      <p>Nulla vitae libero, a pharetra augue. Integer posuere a ante venenatis condimentum. Donec id elit non.</p>
                    </div>
                    <!-- /.text --> 
                  </div>
                  <!-- /.div --> 
                </div>
                <!-- /.col-sm-12 --> 
              </div>
              <!-- /.row --> 
            </div>
            <!-- /.col-services --> 
          </div>
        </div>
        
      </div>
    </div>
  </div>
  <!-- /#about -->
  
  <div class="parallax parallax4 facts">
    <div class="container inner">
      <div class="row text-center services-3">
        <div class="col-sm-3">
          <div class="col-wrapper">
            <div class="icon-border bm10"> <i class="budicon-video-2"></i> </div>
            <h4>7518</h4>
            <p>Contact</p>
          </div>
        </div>
        <div class="col-sm-3">
          <div class="col-wrapper">
            <div class="icon-border bm10"> <i class="budicon-coffee"></i> </div>
            <h4>3472</h4>
            <p>Negotiate</p>
          </div>
        </div>
        <div class="col-sm-3">
          <div class="col-wrapper">
            <div class="icon-border bm10"> <i class="budicon-video"></i> </div>
            <h4>2184</h4>
            <p>Movies Watched</p>
          </div>
        </div>
        <div class="col-sm-3">
          <div class="col-wrapper">
            <div class="icon-border bm10"> <i class="budicon-award-1"></i> </div>
            <h4>4523</h4>
            <p>Collection</p>
          </div>
        </div>
      </div>
    </div>
    <!-- /.container --> 
  </div>
  <!-- /.parallax -->
  
  <div id="contact" class="section anchor">
    <div class="dark-wrapper">
      <div class="container inner">
        <div class="thin text-center">
          <h2 class="section-title text-center">Get in Touch</h2>
          <p class="lead main text-center">Feel Free to Drop Us a Line to contact us</p>
          <p>Alcohol can damage your health and should be consumed in moderation. <br>
			To view this site you must have reached the minimum legal age required for the consumption of alcohol in your country of residence.</p>
          <ul class="contact-info">
            <!-- <li><i class="icon-location"></i>No.2,GuanRi Road,Plan II of Sofeware Park,Huli District,Xiamen City,Fujian Province,China</li><br>
            <li><i class="icon-mobile"></i>11111</li>
            <li><i class="icon-mail"></i><a href="first.last@email.com">first.last@email.com</a> </li>
        	<li><i class="icon-qq"></i>3379906952</li> -->
        	<li><i class="icon-location"></i>33 rue de La Baume,75008 Paris,France</p>
        	<li><i class="icon-mobile"></i>+33 (0) 1 53 89 78 00</li>
        	<li><i class="icon-mail"></i><a >dbr@lafite.com</a> </li>
        	
          </ul>
         
          <!-- /.form-container -->
          <div class="clearfix"></div>
        </div>
      </div>
    </div>
     
  </div>
  <!-- /#contact -->
  <footer class="footer">
    <div class="container inner">
      <p class="pull-left">© 2017 Lafite. All rights reserved.</p>
      <ul class="social pull-right">
      
        <li><a id="container" name="container"><i class="icon-s-facebook"></i></a></li>
        <li><a ><i class="icon-s-instagram"></i></a></li>
        <!-- <li><a ><i class="icon-s-github"></i></a></li> -->

      </ul>
    </div>
    <!-- .container --> 
  </footer>
  <!-- /footer --> 
</div>

</body>
</html>
