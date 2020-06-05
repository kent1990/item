<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>电视商城首页</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="广电,电视,商城,电视商城">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="css/common/common.css" type="text/css" rel="stylesheet" />
	<!--引用自己的css，命名规则和所写的静态html页面同名，如index页面的css为index.css-->
	<link href="css/business/index/index.css" type="text/css" rel="stylesheet" />
  </head>
<body>
	<div class="container">
		<!--详细-->
		<div class="content_detail">
			<!--名称、时间-->
			<div>
				<div class="detail_name">
					<img src="images/index/name.png" height="88" width="259">
				</div>
				<div class="detail_time">
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
			<!--名称、时间结束-->
			<!--列表-->
			<div class="detail_list">
				<div class="list_left">
					<div id="div_list0_0"></div>
				</div>
				<div class="list_right">
					<div class="list_right_detail">
						<div id="div_list1_0"></div>
						<div id="div_list1_1"></div>
						<div id="div_list1_2"></div>
                        <div id="div_list1_3"></div>
                        <div id="div_list1_4"></div>
						<div id="div_list1_5"></div>
					</div>
				</div>
				<div class="clear"></div>
			</div>
			<!--列表结束-->
			<!--提示、帮助-->
			<div class="list_operate">
				<div class="operate_left">
					<img src="images/index/hint.png" height="30" width="30">
					<span id="indexMsg">您尚未开通电视商城业务</span>
				</div>
				<div class="operate_right">
                	<div id="div_list2_0"></div>
				</div>
				<div class="clear"></div>
			</div>
			<!--提示、帮助结束-->
		</div>
		<!--详细结束-->
	</div>
<script type="text/javascript" src="js/common/jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="js/common/tvcommon/keyValueDefine.js"></script>
<script type="text/javascript" src="js/common/tvcommon/lib_shb_date.js"></script>
<%-- <script type="text/javascript" src="news.do?r=${rem}"></script> --%>
<script type="text/javascript" src="queryPics.do?r=${rem}"></script>
<script type="text/javascript" src="js/business/index/index_ScrollList.min.js"></script> 
<script type="text/javascript" src="js/business/index/info.js"></script>
</body>
</html>
