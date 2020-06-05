<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
<head>  
<base href="<%=basePath%>">

<title>修改信息页面</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="js/layui/css/layui.css"/>

</head>

<body>
	<%-- 添加菜单信息 --%>
	<div id="menuUpdate">
		<form class="layui-form" action="" style="margin:40px;">
			<input id="upd_pope_id" name="pope_id" type="hidden" value=""/>
			<div class="layui-form-item">
				<label class="layui-form-label">菜单名称</label>
				<div class="layui-input-block">
					<select id="upd_menu_id" name="menu_id" lay-verify="required" disabled>
						<option value="">顶级菜单</option>
						<c:forEach var="obj" items="${data}">
							<option  value="${obj.menu_id}" <c:if test="${obj.menu_id eq tempMenuId}">selected=true</c:if>>
								${obj.item_name}
							</option>
						</c:forEach>
					</select>
				</div>
			</div>
			
			<div class="layui-form-item">
				<label class="layui-form-label">权限项名称</label>
				<div class="layui-input-block">
					<input type="text" id="upd_item_name" name="item_name" required lay-verify="required"
						placeholder="请输入权限项名称" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item" >
				<label class="layui-form-label">权限项代码</label>
				<div class="layui-input-block">
					<input type="text" id="upd_item_code" name="item_code" required lay-verify="required"
						placeholder="请输入权限项代码" autocomplete="off" class="layui-input">
				</div>
			</div>
			
			<hr class="layui-bg-gray" style="margin-top:40px;margin-bottom:30px">
			<div class="layui-form-item">
				<div class="layui-input-block">
					<button class="layui-btn" lay-submit lay-filter="UpdateMenu">立即提交</button>
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
            form.on('submit(UpdateMenu)', function(data){
                // layer.msg(JSON.stringify(data.field));
                $.ajax({
                    type:"post",
                    url:'xtgl020/updPopedom.do',
                    data:data.field,
                    dataType:"json",
                    success:function(json){
                        console.log(json);
                        if(json.statusCode == 200){
                        	var index = parent.layer.getFrameIndex(window.name);
                            parent.layer.close(index);
                            parent.layer.msg("权限项修改成功", {icon: 6,time: 2000});
                        } else{
                        	layer.msg("权限项修改失败", {icon: 5,time: 2000});
                        }
                    }
                });
                return false;
            });
	
		});
	</script>
	
</body>
</html>
