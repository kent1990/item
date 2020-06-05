<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="pragma" content="no-cache"> 
<meta http-equiv="cache-control" content="no-cache"> 
<meta http-equiv="expires" content="0">  
<title>帮助详情</title>
<link href="css/help/view.css" type="text/css" rel="stylesheet" />
</head>
<body id="bg">  
<div id="pre"><img src="images/common/pre.png" /></div>
<div id="next"><img src="images/common/next.png" /></div>

<div id="newsbg1"><img id="display" src="images/common/loading.jpg" /></div>

<div id="page" style="font-size: 25px;color:white"><span id="pageIndex"></span>/<span id="pageNum"></span></div>
</body>
<script type="text/javascript" src="js/common/jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="js/common/tvcommon/keyValueDefine.js"></script>
<script type="text/javascript" src="js/common/tvcommon/lib_shb_move.js"></script>
<script type="text/javascript" src="helpDetail.do?helpId=${helpId}&tmp=${tmp}"></script>
<script type="text/javascript" src="js/business/list/helpDetailList.js"></script>
</html>