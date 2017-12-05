<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Register Form</title>

        <!-- CSS -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link rel="stylesheet" href="style/assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="style/assets/font-awesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="style/assets/css/form-elements.css">
        <link rel="stylesheet" href="style/assets/css/style.css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

        <!-- Favicon and touch icons -->
        <link rel="shortcut icon" href="assets/ico/favicon.png">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="assets/ico/apple-touch-icon-57-precomposed.png">

    </head>

    <body>

        <!-- Top content -->
        <div class="top-content">
        	
            <div class="inner-bg">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-8 col-sm-offset-2 text">
                            <h1>Register</h1>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3 form-box">
                        	<div class="form-top">
                        		<div class="form-top-left">
                        			<h3>Sign up for our site</h3>
                            		<p>Enter your personal information to Sign up:</p>
                        		</div>
                        		<div class="form-top-right">
                        			<i class="fa fa-info"></i>
                        		</div>
                            </div>
                            <div class="form-bottom">
			                    <form role="form" action="${pageContext.request.contextPath}/userServlet?cmd=reg"
			                     	method="post" class="login-form" enctype="multipart/form-data" >
			                        
			                    	<div class="form-group">
			                    		Realname
			                    		<label class="sr-only" >Realname</label>
			                        	<input type="text" name="form-realname" required="required" placeholder="Realname..." class="form-realname form-control" id="form-realname" >
			                        </div>
			                        <div class="form-group">
			                    		HeadImg
			                        	<input type="file" name="form-headimg" required="required" class="form-headimg form-control" id="form-headimg" >
			                        </div>
			                        
			                        <div class="form-group">
			                        	Sex  <br>
			                        	<input type="radio" name="sex" value="male" checked="checked"> male  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			                        	<input type="radio" name="sex" value="female"> female
			                        
			                        </div>
			                        
			                    	<div class="form-group">
			                    		Username 
			                    		<label class="sr-only" for="form-username">Username</label>
			                        	<input type="text" name="form-username" required="required" onblur="checkUsername();"
			                        	placeholder="Username..." class="form-username form-control" id="form-username">
			                        	 <span id="tip" style="color:red;text-align: center;" ></span>
			                        </div>
			                        <div class="form-group">
			                        	Password
			                        	<label class="sr-only" for="form-password">Password</label>
			                        	<input type="password" name="form-password" required="required" placeholder="Password..." class="form-password form-control" id="form-password">
			                        </div>
									<div class="form-group">
			                        	Telephone
			                        	<label class="sr-only" for="form-tel">tel</label>
			                        	<input type="text" name="form-tel" required="required"  onblur="checkUserTel();"
			                        	 placeholder="Telephone..." class="form-tel form-control" id="form-tel">
			                        	 
			                        	 <!-- <span id="tipTel" style="color:red;text-align: center;" ></span> -->
			                        </div>
			                        <div class="form-group">
			                        	Location
			                        	<input type="text" name="form-loc" required="required" "
			                        	 placeholder="Location.." class="form-loc form-control" id="form-loc">
			                        </div>
			                        
			                        <div class="form-group">
			                        	Birthday
			                        	<input type="date" name="form-birth" required="required" "title="yyyy-MM-dd"
			                        	 placeholder="yyyy-MM-dd" class="form-birth form-control" id="form-birth">
			                        </div>
			                        
									<br>			                        			                        
			                        <button type="submit" class="btn">Sign up</button>
			                    </form>
		                    </div>
                        </div>
                    </div>
                   
                </div>
            </div>
            
        </div>


        <!-- Javascript -->
        <script src="style/assets/js/jquery-1.11.1.min.js"></script>
        <script src="style/assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="style/assets/js/jquery.backstretch.min.js"></script>
        <script src="style/assets/js/scripts.js"></script>
        <script src="style/js/function.js"></script>
        
        <!--[if lt IE 10]>
            <script src="assets/js/placeholder.js"></script>
        <![endif]-->

    </body>

</html>	