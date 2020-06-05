<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">

<title>添加用户</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="js/layui/css/layui.css" />

</head>

<body>
	<%-- 添加用户信息 --%>
	<div id="roleAdd">
		<form class="layui-form" action="" style="margin:40px;">
			<div class="layui-form-item">
				<label class="layui-form-label"><span class="layui-badge-dot"></span>登陆账号</label>
				<div class="layui-input-block">
					<input type="text" name="login_name" required lay-verify="username"
						placeholder="请输入登陆账号" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label"><span class="layui-badge-dot"></span>用户密码</label>
				<div class="layui-input-block">
					<input id="passOne" type="password" name="login_pwd" required
						lay-verify="passOne" placeholder="请输入登陆密码" autocomplete="off"
						class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label"><span class="layui-badge-dot"></span>确认密码</label>
				<div class="layui-input-block">
					<input type="password" name="login_pwd1" required 
						lay-verify="passTwo" placeholder="请输入登陆密码" autocomplete="off"
						class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label"><span class="layui-badge-dot"></span>姓名</label>
				<div class="layui-input-block">
					<input type="text" name="user_name" required lay-verify="name"
						placeholder="请输入用户姓名" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label"><span class="layui-badge-dot"></span>用户电话</label>
				<div class="layui-input-block">
					<input type="text" name="user_phone" required lay-verify="phone"
						placeholder="请输入用户电话" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label"><span class="layui-badge-dot"></span>职位</label>
				<div class="layui-input-block">
					<input type="text" name="position_e" maxlength="10"
						placeholder="请输入用户职位" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">邮箱</label>
				<div class="layui-input-block">
					<input type="text" name="e_mail" lay-verify="myEmail" maxlength="50"
						placeholder="请输入用户邮箱" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
			    <label class="layui-form-label">性别</label>
			    <div class="layui-input-block">
			      <input type="radio" name="gender" value="1" title="男" checked>
			      <input type="radio" name="gender" value="2" title="女">
			    </div>
			</div>
			<div class="layui-form-item">
			    <label class="layui-form-label">用户状态</label>
			    <div class="layui-input-block">
			      <input type="radio" name="user_status" value="1" title="正常" checked>
			      <input type="radio" name="user_status" value="0" title="禁用">
			    </div>
			</div>
			<!-- <div class="layui-form-item">
				<label class="layui-form-label">用户状态</label>
				<div class="layui-input-block">
					<select name="user_status" lay-verify="required">
						<option value="1">正常</option>
						<option value="0">禁用</option>
					</select>
				</div>
			</div>		 -->	
			<hr class="layui-bg-gray">
			<div class="layui-form-item">
				<div class="layui-input-block">
					<button class="layui-btn" lay-submit lay-filter="AddSysUser">立即提交</button>
					<button type="reset" class="layui-btn layui-btn-primary">重置</button>
				</div>
			</div>
		</form>
	</div>
	<script type="text/javascript" src="js/layui/layui.js"></script>
	<script type="text/javascript">
		layui.config({
	        base: "<%=basePath%>/js/common/"
		}).use([ "common", "element", "layer", "form", "table", "jquery" ], function() {
				var elem = layui.element;
				var layer = layui.layer;
				var form = layui.form;
				var table = layui.table;
				var $ = layui.jquery;

				 layui.common.init();
				 
				//监听提交  添加
				form.on('submit(AddSysUser)', function(data) {
					// layer.msg(JSON.stringify(data.field));
					$.ajax({
						type : "post",
						url : 'xtgl040/saveSysUser.do',
						data : data.field,
						dataType : "json",
						success : function(json) {
							if (json.statusCode == 200) {
								var index = parent.layer.getFrameIndex(window.name);
								parent.layer.close(index);
								parent.layer.msg(json.message,{icon : 6, time : 2000});
							} else {
								layer.msg(json.message,{icon : 5, time : 2000});
							}
						}
					});
					return false;
				});

				form.verify({
					username : function(value, item) { //value：表单的值、item：表单的DOM对象
						if(value.length > 20){
							return '用户名长度不能超过20个字符';
						}
						if (!new RegExp(
								"^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$")
								.test(value)) {
							return '用户名不能有特殊字符';
						}
						if (/(^\_)|(\__)|(\_+$)/
								.test(value)) {
							return '用户名首尾不能出现下划线\'_\'';
						}
						if (/^\d+\d+\d$/.test(value)) {
							return '用户名不能全为数字';
						}
					},
					name: function(value, item){
						if(value.length > 20){
							return '姓名长度不能超过20个字符';
						}
					},

					passOne : [ /^[\S]{6,12}$/,
							'密码必须6到12位，且不能出现空格' ],

					passTwo : function(value, item) {
						if ($("#passOne").val() != value) {
							return "两次输入的密码不匹配";
						}
					},
					phone : [ /^1[3|4|5|8][0-9]\d{4,8}$/,
							'请输入正确的手机号' ]
				});

			});
	</script>
</body>
</html>
