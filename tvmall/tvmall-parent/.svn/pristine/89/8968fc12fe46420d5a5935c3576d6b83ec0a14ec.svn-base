<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">

<title>设置密码</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<%-- 引用自定义图标库 --%>
<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css" />
<%-- 引用layui.css --%>
<link rel="stylesheet" type="text/css"	href="js/layui/css/layui.css" />

</head>

<body>
	<%-- 添加菜单信息 --%>
	<div id="userUpd">
		<form class="layui-form" action="" style="margin:40px;">
			<input type="hidden" name="id" value=""/>
			<div class="layui-form-item">
				<label class="layui-form-label">密码</label>
				<div class="layui-input-block">
					<input id="passOne" type="password" name="loginPwd" required lay-verify="passOne"
						placeholder="请输入登陆密码" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">确认密码</label>
				<div class="layui-input-block">
					<input type="password" name="login_pwd1" required lay-verify="passTwo"
						placeholder="请输入登陆密码" autocomplete="off" class="layui-input">
				</div>
			</div>

			<hr class="layui-bg-gray">
			<div class="layui-form-item">
				<div class="layui-input-block">
					<button class="layui-btn" lay-submit lay-filter="updUserPass">立即提交</button>
					<button type="reset" class="layui-btn layui-btn-primary">重置</button>
				</div>
			</div>
		</form>
	</div>
	<script type="text/javascript" src="js/layui/layui.js"></script>
	<script type="text/javascript">
	layui.config({
        base: "<%=basePath%>/js/common/"
    }).use(["common", "element", "layer", "form", "table", "jquery"], function(){
			var elem = layui.element;
			var layer = layui.layer;
			var form = layui.form;
			var table = layui.table;
			var $ = layui.jquery;
			
			layui.common.init();
			
			//监听提交  添加
            form.on('submit(updUserPass)', function(data){
                // layer.msg(JSON.stringify(data.field));
                $.ajax({
                    type:"post",
                    url:'xtgl040/updUserPass.do',
                    data:data.field,
                    dataType:"json",
                    success:function(json){
                        if(json.statusCode == 200){
                        	var index = parent.layer.getFrameIndex(window.name);
                            parent.layer.close(index);
                            parent.layer.msg(json.message, {icon: 6,time: 2000});
                        } else{
                        	layer.msg(json.message, {icon: 5,time: 2000});
                        }
                    }
                });
                return false;
            });
			
			
            form.verify({
            	  passOne: [
            	         /^[\S]{6,12}$/
            	         ,'密码必须6到12位，且不能出现空格'
            	       ],
            	  
            	  passTwo: function(value, item){
            		  if($("#passOne").val() != value){
            			  return "两次输入的密码不匹配";
            		  }
            	  }
            });
	
		});
	</script>
</body>
</html>
