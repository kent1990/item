<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>tips</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  	<div class="container">
    	 <div class="orders_window" style="height: 220px;">
  			<div class="orders_title">
				<div>提示</div>
				<div class="orders_line">
					<img src="images/detail/orders_line.png" height="1" width="800">
				</div>
			</div>
			<div class="orders_detail">
				<div class="orders_desc">
					<div class="orders_sel">
    					您的订单已生成！
    				</div>
    			</div>
    		</div>
    		<div class="orders_operate">
					<div id='div_6_0'>确认</div>			
			</div>
    	 </div>
  	 </div>
  </body>
</html>
