<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">

<title>设置角色</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<%-- 引用layui.css --%>
<link rel="stylesheet" type="text/css" href="js/layui/css/layui.css" />

</head>

<body>
	<div class="layui-container">
		<form id="setRole" class="layui-form" action="">
			<input type="hidden" id="id" name="id" >
			<div class="layui-form-item">
				<c:forEach items="#{data}" var="obj">
		    		<input type="checkbox" name="like[]" lay-skin="primary"  value="${obj.role_id}" title="${obj.role_name}" ${obj.istrue ? 'checked' : ''}>
				</c:forEach>
				
			
		    	<!-- <input type="checkbox" name="like[]" value="2" title="阅读" checked>
		    	<input type="checkbox" name="like[]" value="3" title="发呆"> -->
			</div>
			<hr class="layui-bg-gray">
			<div class="layui-form-item" style="text-align:center;">
				<button class="layui-btn" lay-submit lay-filter="setRole">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
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
            form.on('submit(setRole)', function(data){
                // layer.msg(JSON.stringify(data.field));
                $.ajax({
                    type:"post",
                    url:'xtgl040/setRole.do',
                    data:$("#setRole").serialize(),
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
		});
	</script>
  </body>
</html>
