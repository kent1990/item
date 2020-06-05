<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>商品列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="css/common/common.css" type="text/css" rel="stylesheet" />
    <link href="css/business/list/product_list.css" type="text/css" rel="stylesheet" />
  </head>
  
  <body style="background:url(images/common/bg3.png) center #264677 no-repeat;width:100%;height:720px;">

	<div class="container_head">
        <div id="div_3_0">
        	<img src="images/common/arrow.png">
        </div>
        <div id="title">电视商圈 | 分类列表</div>
        <div class="head_time">
            <div class="time_minutes">
                <div id="minutes"></div>
            </div>
            <div class="time_across">
                <img src="images/common/across_line.png" width="2" height="50">
            </div>
            <div class="time_date">
                <div id="week"></div>
                <div id="date"></div>
            </div>
            <div class="clear"></div>
        </div>
        <div class="clear"></div>
    </div>	
    <div id="container">
        <div id="div_0_0"></div>
        <div id="div_0_1"></div>
        <div id="div_0_2"></div>
        <div id="div_0_3"></div>
        <div id="div_0_4"></div>
        <div id="div_0_5"></div>
        <div id="div_0_6"></div>
        <div id="div_0_7"></div>
    </div>
    <div id="page_wrap"><div id="page"><span id="pageIndex"></span>/<span id="pageNum"></span></div></div>
  </body>
	<script type="text/javascript" src="js/common/jquery-1.3.2.min.js"></script>
	<script type="text/javascript" src="js/common/tvcommon/keyValueDefine.js"></script>
	<script type="text/javascript" src="js/common/tvcommon/lib_shb_date.js"></script>
	<script type="text/javascript" src="typeData.do?r=${tmp}"></script> 
	<script type="text/javascript" src="js/common/tvcommon/wb_ScrollList.min.js"></script>
	<script type="text/javascript" src="js/business/list/typeList.js"></script>
</html>
