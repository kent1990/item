<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
<head>
        <base href="<%=basePath %>" />
        <title>电视商城后台管理系统</title>
		<meta name="keywords" content="电视商城后台管理系统" />
		<meta name="description" content="电视商城后台管理系统" />
		<meta http-equiv="pragma" content="no-cache"/>
		<meta http-equiv="cache-control" content="no-cache"/>
		<meta http-equiv="expires" content="0"/>  
        <!-- <meta name="viewport" content="width=device-width, initial-scale=1.0">  -->
        <meta name="description" content=""/>
        <meta name="author" content=""/>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		
  <script type="text/javascript" src="js/common/jquery-1.8.3.min.js"></script>
   <style type="text/css">
	*{margin:0;padding: 0; border:none;font-family: 微软雅黑;}
	.flt{float: left;} .frt{float: right;}  .clear{clear: both;}
	input::-webkit-input-placeholder { color: #fff;}
    input:-moz-placeholder {color: #fff;opacity: 1;}
    input::-moz-placeholder {color: #fff;opacity: 1;}
    input:-ms-input-placeholder {color: #fff;}
	.backstage_login_top{width: 100%;height: 129px;padding-top:148px;background-color: #1f5b97;}
	.backstage_logo{width: 391px;height: 129px;margin:1px auto 0;}
	.backstage_login_mid{width: 100%;height: auto;padding-top:110px;background-color: #fff;*margin-top: -1px;}
	.backstage_mid{width: 576px;height: auto;margin:0 auto;}
	.login_num,.login_password{width: 298px;height:48px;border: 1px solid #1f5b97;}
	.login_password{margin-top: 20px;}
	.login_num input{width: 240px;height: 48px;line-height:48px;padding-left:58px;background:#4698d7 url(<%=basePath%>images/backstage_photo.png) no-repeat 0 0;font-size: 14px;color: #fff;*margin-top: -1px;}
	.login_password input{width: 240px;height: 48px;line-height:48px;padding-left:58px;background:#4698d7 url(<%=basePath%>images/backstage_password.png) no-repeat 0 0;font-size: 14px;color: #fff;*margin-top: -1px;}
	.backstage_mid_right{display:inline;margin-left: 10px;}
	.backstage_mid_right input{width: 120px;height: 120px;margin-left:10px;background-color: #1f5b97;border-radius: 5px;-webkit-border-radius:5px;-moz-border-radius:5px;font-size: 26px;color: #fff;cursor: pointer;}
	.backstage_mid_right input:hover{background-color: #5fb9ff;}
	.backstage_login_state{font-size: 16px;color: #f60d29;margin-top: 10px;}
	.backstage_login_bottom{position:fixed;width: 100%;height: 150px;background-color: #1f5b97;left: 0;bottom:0;}
	.verify{    margin-left: 320px;  margin-top: -49px; height: 50px;}
</style>
<script type="text/javascript">
	$(function(){
	  	$("#username, #password, #imgObj").keyup(function(){
		       $("#errorMsg").fadeOut("fast");
		});		
	});

	function check() {
		var adminCode =$("#username").val();
		var adminPass = $("#password").val();
		if (adminCode == null || adminCode == "") {
		 	$("#errorMsg").show();
			$("#errorMsg").html("请输入用户名!");
			return false;
		}
		if (adminPass == null || adminPass == "") {
			$("#errorMsg").show();
			$("#errorMsg").html("请输入密码!");
			return false;
		}		
	}
</script>
</head>
<body>
	<div class="backstage_login">
		<div class="backstage_login_top">
			<div class="backstage_logo">
				<img src="<%=basePath%>images/backstage_logo.png" width="391px" height="129px"/>
			</div>
		</div>
		<div class="backstage_login_mid">
			<div class="backstage_mid">
			  <form action="<%=basePath%>login/login.do" method="post" onsubmit="return check();">
				<div class="backstage_mid_left flt">
					<!-- 输入手机号或账号 -->
					<div class="login_num">
						<label></label>
						<input type="text" name="loginName" id="username" value="${loginName}" placeholder="请输入用户名" autocomplete="off"/>
					</div>
					<!-- 输入密码 -->
					<div class="login_password">
						<label></label>
						<input type="password" name="loginPwd" id="password" value="${loginPwd }" placeholder="请输入密码" autocomplete="new-password"/>
					</div>
					<div class="login_password">
						<label></label>
						<input type="password" name="verifyCode" id="verifyCode" placeholder="请输入图片验证码" value="" />
						<img id="imgObj"  class="verify"
						alt="验证码" src="<%=basePath%>login/verify.do"  onclick="changeImg()"/>  
					</div>			
					<div id="errorMsg" class="backstage_login_state">${errorMsg}</div>
				</div>
				<div class="backstage_mid_right flt">
					<input type="submit" name="button1" value="登录"/>
					<input type="reset" name="button2" value="重置"/>
				</div>
				<div class="clear"></div>
				</form>
			</div>
		</div>
		<div class="backstage_login_bottom"></div>
</div>
</body>
</html>
<script type="text/javascript"> 
    var changeImg =function(){
        $("#imgObj").attr("src","<%=basePath%>login/verify.do?"+new Date());
     }; 

</script>