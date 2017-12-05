<%@ page language="java" import="java.util.*" pageEncoding="utf-8" 
	contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title>yeepay</title>
  </head>
  
  <body>
  	<%
        String sum = request.getParameter("sum");  
        StringBuilder str=new StringBuilder();//定义变长字符串
		Random random=new Random();
		//随机生成数字，并添加到字符串
		for(int i=0;i<8;i++){
		    str.append(random.nextInt(10));
		}
		//将字符串转换为数字并输出
		int id=Integer.parseInt(str.toString());
  	 %>
	<!-- 进行支付的页面 -->
	<form action="<c:url value='/payServlet'/>">
		欢迎${USER_IN_SESSION.USER_NAME } <br>
		商品订单号：<input type="text" name="p2_Order" value="<%=id%>"><br/>
		支付金额：<input type="text" name="p3_Amt" value="<%=sum%>"><br/>
		选择银行：<br/>
		中国农业银行<input type="radio" name="pd_FrpId" value="ABC-NET-B2C">
		建设银行<input type="radio" name="pd_FrpId" value="CCB-NET-B2C"><br/>
		<input type="submit" value="支付">
	</form>
  </body>
</html>
