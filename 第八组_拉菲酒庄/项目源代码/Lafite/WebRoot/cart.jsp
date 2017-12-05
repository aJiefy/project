<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML >
<html>
  <head>
    <%-- <base href="<%=basePath%>"> --%>
    
    <title>cart</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<!-- <style type="text/css">
	body:after {
		position: absolute;
		content: "";
		width: 100%;
		height: 100%;
		left: 0;
		top: 0;
		background: #1E1E1E;
		opacity: 0.85;
		z-index: 1;
	}
	</style> -->
	
	<script src="style/js/jquery.min.js"></script> 
	<script src="style/js/bootstrap.min.js"></script> 
	
	
    <title>购物车</title>
  </head>
  
  <body style="text-align:center; background-image: url(style/images/art/parallax2.jpg);">
      <h2 style="color:white;">我的购物车</h2>
     
      
      <table border="1" width="60%" cellpadding="0" cellspacing="0" style="margin: 0 0 0 300px; text-align:left;">
         <tr style="background-color: orange">
            <th>购物车编号</th>
            <th>红酒</th>
            <th>价格</th>
            <th>数量</th>
            <th>总价</th>
            <th>操作</th>
         </tr>
         <c:set var="sum" value="0"></c:set>
         <c:forEach items="${sessionScope.CART_IN_SESSION}" var="item" varStatus="vs">
           <tr style="background-color: ${vs.count%1==0?'pink':''}">
            <td>${item.CART_ID}</td>
            <td><img src="${item.WINE_IMG}" style="height: 100px;" align="center">
            	<%-- <a href="/Lafite/WineServlet?wineName=${item.WINE_NAME}">${item.WINE_NAME}</a> --%>
            	<a href="#" style="margin: 0 0 0 10px;text-decoration: none; ">${item.WINE_NAME}</a>
            </td>
            <td>￥${item.WINE_PRICE}</td>
            <td>${item.CART_COUNT}</td>
            <td>￥${item.CART_TOTALPRICE }     </td>
             <c:set var="sum" value="${sum+item.CART_TOTALPRICE}"></c:set>
            <td><a href="javascript:del(${item.CART_ID});">删除</a></td>
            <script>
            	function del(id){
            		
            		if(confirm("确认删除?")==true){
            			window.location.href="./cartServlet?cmd=del&id="+id+"";
						return true;
					}else{
		 				return false;
					}
            		
            	}
            </script>
          </tr>
         
         </c:forEach>
         
         <c:if test="${empty CART_IN_SESSION}">
         <tr>
            <td colspan="6" style="text-align: center;">购物车空空的，赶紧去购物。。。</td>
         </tr>
         </c:if>
         
         <c:if test="${!empty CART_IN_SESSION}">
          <tr>
           <td colspan="6" style="text-align: right;background-color: pink;">商品总价格:￥${sum }</td>
         </tr>
         </c:if>
          
      
      
      
      </table>
      <a href="/Lafite/index.jsp" style="text-decoration: none;color:white;">继续购物</a>
      <a href="javascript:placeorder();" style="text-decoration: none;color:white;">下单</a>
      <script>
      	function placeorder(){
      		if(confirm("确认下单吗")==true){
      			location.href="/Lafite/orderServlet?cmd=placeorder";
      			return true;
      		}	
      	}
      </script>
   
  </body>
</html>
