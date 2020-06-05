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
<title>角色管理</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<%-- 引用layui.css --%>
<link rel="stylesheet" type="text/css" href="js/layui/css/layui.css"/>
<link rel="stylesheet" type="text/css"href="css/common.css" />
<link rel="stylesheet" type="text/css" href="css/ibox.css" />

</head>

<body>
	<div class="ibox">
		<!-- 搜索区 -->
		<!-- <div class="ibox-title">
			<div class="title">&nbsp;&nbsp;&nbsp;系统角色管理</div>
		</div> -->
		<div class="ibox-content bodycss">
				<div class="ibox-toolbar">
					<button id="addRoles" data-modal="" data-title="添加角色" class="layui-btn layui-btn-sm">
	                	<i class="layui-icon">&#xe61f;</i> 添加角色
	                </button>
				</div>
            <table class="layui-table" lay-data="{
                        id: 'roleTeble',
                        width:'auto',
                        url:'xtgl030/query.do',
                        page:true,
                        even:true,
                        skin:'line',
                        limits:[10,20,30,40,50],
                        limit:10}" lay-filter="rolesLay">
                <thead>
	                <tr>
	                    <th lay-data="{field:'rowno', width:50}"></th>
	                    <th lay-data="{field:'role_name', width:200}">角色名</th>
	                    <th lay-data="{field:'status', width:100, templet:'#status'}">状态</th>
	                    <th lay-data="{field:'create_time', width:180}">创建时间</th>
	                    <th lay-data="{field:'create_user', width:150}">创建人</th>
	                    <th lay-data="{field:'update_time', width:180}">修改时间</th>
	                    <th lay-data="{field:'update_user', width:150}">修改人</th>
	                    <th lay-data="{fixed: 'right', width:230, align:'center', toolbar: '#rolesBar'}">操作</th>
	                </tr>
                </thead>
            </table>
		</div>
	</div>
     
    <script type="text/html" id="status">
    	{{#  if(d.status == 1) {  }}
			<font color="#00ff00">正常</font>
		{{#  } else {  }}
			<font color="#ff0000">禁用</font>
		{{#  }  }}
    </script>
    
    <script type="text/html" id="rolesBar">
    		<a class="layui-btn layui-btn-xs" lay-event="right">授权</a>
    		<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
        	<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    </script>
	
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
		/* $(".layui-table-body").addClass("layui-anim-fadein");
		$(".layui-table-body").mouseenter(function(){
			// 进入
			$(this).css("overflow","auto"); 
		});
		
		$(".layui-table-body").mouseleave(function(){
           	// 退出
			$(this).css("overflow","hidden"); 
        }); */
		
		$("#addRoles").on("click", function(){
			layer.open({
                type: 2,	
                title: '添加角色',
                content: 'xtgl030/toXtgl03002.do',
                area: ['700px', '350px'],
                anim: 5,
                isOutAnim: true,
                maxmin: true,
                resize: false,
                moveOut: true,
                zIndex: 99999,
                end : function(){
                	table.reload("roleTeble");
                }
            });
		});
		
		
		table.on('tool(rolesLay)', function(obj){
            var data = obj.data;            //获得当前行数据
            var layEvent = obj.event;       //获得 lay-event 对应的值
            var tr = obj.tr;                //获得当前行 tr 的DOM对象

            if(layEvent === 'del'){  //删除
                layer.open({
                    icon:3,
                    title: "删除",
                    content : "确认删除？",
                    btn: ['确认', '取消'],
                    yes: function(index, layero){
                        $.ajax({
                            type:"post",
                            url:'xtgl030/delRelos.do',
                            data:{id : data.role_id},
                            dataType:"json",
                            success:function(json){
                                if(json.status == 200){
                                    table.reload("roleTeble", {});
                                    layer.msg("删除成功", {icon: 6,time: 2000});
                                }else{
                                    layer.msg("删除失败", {icon: 5,time: 2000});
                                }
                            }
                        });
                    },
                    btn2: function(index, layero){ }
                });

            } else if(layEvent === 'edit'){ //编辑
            	//console.log(data);
                layer.open({
                    type: 2,
                    title: '修改权限项',
                    content: 'xtgl030/toXtgl03003.do',
                    area: ['700px', '350px'],
                    anim: 5,
                    isOutAnim: true,
                    maxmin: true,
                    resize: false,
                    moveOut: true,
                    zIndex: 99999,
                    success: function(layero, index){
                    	var body = layer.getChildFrame('body', index);  //巧妙的地方在这里哦
                        body.contents().find("#upd_role_id").val(data.role_id);
                        body.contents().find("#upd_role_name").val(data.role_name);
                        body.contents().find("#upd_status").val(data.status);
                    },
                    end : function(){
                    	table.reload("roleTeble");
                    }
                });
            } else if(layEvent === 'right'){ // 授权
            	layer.open({
                    type: 2,
                    title: '授权',
                    content: 'xtgl030/toXtgl03004.do?id=' + data.role_id,
                    area: ['900px', '500px'],
                    anim: 5,
                    isOutAnim: true,
                    maxmin: true,
                    resize: false,
                    moveOut: true,
                    zIndex: 99999
                });
            }
            
        });

	});
</script>
</body>
</html>
