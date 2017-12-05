<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML >
<html>
  <head>
    <%-- <base href="<%=basePath%>"> --%>
    
    <title>order</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<script src="style/js/jquery.min.js"></script> 
	<script src="style/js/bootstrap.min.js"></script> 
	
	
    <title>订单</title>
  </head>
  
  <body style="text-align:center; background-image: url(style/images/art/slider-bg1.jpg);">
      <h2>我的订单</h2>
     
      
      <table border="1" width="90%" cellpadding="0" cellspacing="0"  style="font-size:18px;margin: 0 0 0 55px; text-align:left;">
         <tr style="background-color: orange">
            <th>订单编号</th>
            <th>购物车编号</th>
            <th>用户名</th>
            <th>联系电话</th>
            <th>img</th>
            <th>Lafite</th>
            <th>数量</th>
            <th>总价</th>
            <th>地址</th>
            <th>支付状态</th>
            <th>订单状态</th>
            <th>下单时间</th>
            <th>支付时间</th>
         </tr>
       
         <c:set var="sum" value="0"></c:set>
         <c:forEach items="${sessionScope.ORDER_IN_SESSION}" var="item" varStatus="vs">
           <tr style="background-color: ${vs.count%1==0?'pink':''}">
            <td>${item.ID}</td>
            <td>${item.CART_ID}</td>
            <td>${item.USER_NAME}</td>
            <td>${item.USER_TEL}</td>
            <td><img src="${item.WINE_IMG}" style="height: 100px;"></td>
            <td>${item.WINE_NAME}</td>
            <td>${item.ORDER_COUNT}</td>
            <td>${item.ORDER_TOTALPRICE }</td>
            <td>${item.USER_LOC}</td>
            <c:if test="${item.PAY_STATUS == null}">
            	<td>未支付</td>
            </c:if>
            <c:if test="${item.PAY_STATUS == 1}">
            	<td>已支付</td>
            </c:if>
            <c:if test="${item.ORDER_STATUS == null}">
            	<td>未发货</td>
            </c:if>
            <c:if test="${item.ORDER_STATUS == 1}">
            	<td>已发货</td>
            </c:if>
            
            <td>${item.ORDER_CREATETIME}</td>
            <c:if test="${item.ORDER_PAYTIME==null }">
            	<td> </td>
            </c:if>
            <c:set var="sum" value="${sum+item.ORDER_TOTALPRICE}"></c:set>
          </tr>
         
         </c:forEach>
         
         <c:if test="${empty ORDER_IN_SESSION}">
         <tr>
            <td colspan="13" style="text-align: center;">订单是空的，赶紧去下单。。。</td>
         </tr>
         </c:if>
         
         <c:if test="${!empty ORDER_IN_SESSION}">
          <tr>
           <td colspan="13" style="text-align: right;background-color: pink;">订单总价格:￥${sum }</td>
         </tr>
         </c:if>
          
      
      
      
      </table>
      <a href="/Lafite/index.jsp" style="text-decoration: none;color:white;">继续购物</a>
      <a href="yeepay.jsp?sum=${sum }" style="text-decoration: none;color:white;">付款</a>
   
  </body>
</html>
