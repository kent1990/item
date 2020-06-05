<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>Android机顶盒入口</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="广电,电视,商城,电视商城">
	<meta http-equiv="description" content="电视商城">
<!-- 	<meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0"/> -->
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="css/common/common.css" type="text/css" rel="stylesheet" />	
	<link href="css/business/masuk/masuk.css?r=${rem }" type="text/css" rel="stylesheet" />
  </head>
<body>
	<div class="container">
		<!--详细-->
		<div class="content_detail">
			<!--名称、时间-->
			<div>
				<div class="detail_name">
					<img src="images/adv/name2.png" height="88" width="259">
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
					</div>
				</div>
				<div class="operate_right">
                	<div id="div_list2_0"></div>
				</div>
				<div class="clear"></div>
			</div>
			<!--列表结束-->
			<!--提示、帮助-->
			<div class="list_operate">
				<div class="operate_left">
					<img src="images/index/hint.png" height="30" width="30">
					<span id="indexMsg"></span>
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
<script type="text/javascript" src="news.do?r=${rem}"></script>
<script type="text/javascript" src="queryMasuk.do?r=${rem}"></script>
<script type="text/javascript" src="js/business/index/index_ScrollList.min.js?r=${rem}"></script> 
<script type="text/javascript" src="js/business/masuk/masuk.js?r=${rem}"></script>
</body>
</html>