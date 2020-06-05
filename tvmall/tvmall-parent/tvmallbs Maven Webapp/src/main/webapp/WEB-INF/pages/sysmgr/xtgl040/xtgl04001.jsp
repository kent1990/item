<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">

<title>用户管理</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<%-- 引用自定义图标库 --%>
<!-- <link rel="stylesheet" type="text/css" href="css/font-awesome.min.css" /> -->
<%-- 引用layui.css --%>
<link rel="stylesheet" type="text/css"href="js/layui/css/layui.css" />
<link rel="stylesheet" type="text/css"href="css/common.css" />
</head>
<body>
	<div class="ibox">
		<div class="ibox-content bodycss">
			<!-- 表单搜索 开始 -->
		 	<section class="panel panel-padding ">
			<form class="layui-form layui-form-pane form-search"
				action="" onsubmit="return false" method="post">
				
				<div class="layui-form-item layui-inline" >
					<label class="layui-form-label">用户姓名</label>
					<div class="layui-input-inline">
						<input name="username" value="" placeholder="请输入用户姓名" class="layui-input" style="width:150px">
					</div>
				</div>

				<div class="layui-form-item layui-inline">
					<label class="layui-form-label">手机号</label>
					<div class="layui-input-inline">
						<input name="userphone" value="" placeholder="请输入手机号" class="layui-input" style="width:150px">
					</div>
				</div>
				
				<div class="layui-form-item layui-inline">
					<label class="layui-form-label">状态</label>
					<div class="layui-input-inline" >
					  <div  style="width:150px">
						<select name="my_status"  > 
							<option value="" >请选择</option>
							<option value="1">正常</option>
							<option value="0">禁用</option>
						</select>
                      </div>
					</div>
				</div>
				<div class="layui-form-item layui-inline" >
					<label class="layui-form-label">类型</label>
					<div class="layui-input-inline" style="width:150px" >
						<select name="my_iden" >
							<option value="">请选择</option>
							<option value="1">老师</option>
							<option value="2">学员</option>
							<option value="3">其他</option>
						</select>
					</div>
				</div>

				<div class="layui-form-item layui-inline">
					<button class="layui-btn layui-btn-primary" lay-submit lay-filter="seach">
						<i class="layui-icon"></i> 搜 索
					</button>
				</div>
			</form>
			</section>
			<!-- 表单搜索 结束 -->
 			<section class="panel panel-padding ">
			<form onsubmit="return false;" data-auto="true" method="post"
				data-listen="true" novalidate="novalidate">
	                	<button id="addSysUser" data-modal="" data-title="添加用户" class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe61f;</i> 添加用户
	                	</button>
		                <button id="delSysUser" data-field="delete" data-action="/admin/menu/del.html" class="layui-btn layui-btn-sm layui-btn-danger"><i class="layui-icon">&#xe640;</i> 批量删除
		                </button>
				<input type="hidden" value="resort" name="action">
				<table class="layui-table" lay-data="{
                        id: 'userTeble',
                        width:'auto',
                        height:'auto',
                        url:'xtgl040/query.do',
                        page:true,
                        even:true,
                        skin:'line',
                        limits:[10,20,30,40,50],
                        limit:10}" lay-filter="userLay">
	                <thead>
	                <tr>
	                	<th lay-data="{checkbox:true,disabledKey:'login_name',disabledKeyValue:'admin'}"></th>
	                    <th lay-data="{field:'user_name', width:150}">用户姓名</th>
	                    <th lay-data="{field:'login_name', width:120}">登录账号</th>
	                    <th lay-data="{field:'gender', width:60, templet:'#gender'}">性别</th>
	                    <th lay-data="{field:'status', width:70, templet:'#user_status'}">状态</th>	                 
	                    <th lay-data="{field:'last_login_time', width:160}">上次登录时间</th> 
	                    <th lay-data="{field:'create_time', width:140}">创建时间</th>
	                    <th lay-data="{field:'create_user_name', width:140}">创建人</th>
	                    <th lay-data="{field:'update_time', width:160}">修改时间</th>
	                    <th lay-data="{field:'update_user_name', width:140}">修改人</th>
	                    <th lay-data="{fixed: 'right', width:280, align:'center', toolbar: '#userBar'}">操作</th>
	                </tr>
	                </thead>
	            </table>
			</form>
			</section>
		</div>
	</div>
	<script type="text/html" id="userBar">
    		<a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="role">设置角色</a>
			<a class="layui-btn layui-bg-cyan layui-btn-xs" lay-event="shou">修改密码</a>
    		<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
            {{#  if(d.user_id != 1) {  }}
    		      <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
			{{# } }}
    </script>
	<script type="text/html" id="user_status">
    	{{#  if(d.status == 1) {  }}
			<span class="layui-badge layui-bg-blue">正常</span>
		{{#  } else {  }}
			<span class="layui-badge layui-bg-gray">禁用</span>
		{{#  }  }}
    </script>
	<script type="text/html" id="gender">
    	{{#  if(d.gender == 1) {  }}
			<span class="layui-badge layui-bg-orange">男</span>
		{{#  } else {  }}
			<span class="layui-badge layui-bg-green">女</span>
		{{#  }  }}
    </script>
	
	<script type="text/html" id="login_times">
		<span class="layui-badge">{{d.login_times}}</span>
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
		
		/**
		 * 监听刷新表格
		 */
		form.on('submit(seach)', function(data){
			//layer.msg(JSON.stringify(data.field));
			table.reload('userTeble', {
			    method:"post",
				where: data.field
			});
			return false;
		});
		
		// 添加用户按钮
		$("#addSysUser").on("click", function(){
			layer.open({
                type: 2,	
                title: '添加用户',
                content: 'xtgl040/toXtgl04002.do',
                area: ['750px', '600px'],
                anim: 5,
                isOutAnim: true,
                maxmin: true,
                resize: false,
                moveOut: true,
                zIndex: 99999,
                end : function(){
                	table.reload("userTeble");
                }
            });
		});
		
		// 删除用户按钮
		$("#delSysUser").on("click", function(){
			var s = table.checkStatus('userTeble');
			if(s.data.length <= 0){
				layer.msg("请选择要删除的用户", {icon: 5,time: 2000});
				return;
			}
			var sid = "";
			for(var i = 0; i < s.data.length;i++){
				sid += s.data[i].user_id + ",";
			}
			
			layer.open({
                icon:3,
                title: "批量删除",
                content : "是否删除这些用户？",
                btn: ['确认', '取消'],
                yes: function(index, layero){
                    $.ajax({
                        type:"post",
                        url:'xtgl040/delSysUser.do',
                        data:{sid : sid.substr(0, sid.length-1)},
                        dataType:"json",
                        success:function(json){
                            if(json.statusCode == 200){
                                table.reload("userTeble", {});
                                layer.msg("删除成功", {icon: 6,time: 2000});
                            }else{
                                layer.msg("删除失败", {icon: 5,time: 2000});
                            }
                        }
                    });
                },
                btn2: function(index, layero){ }
            });
		});
		
		// 监听表格行上的按钮
		table.on('tool(userLay)', function(obj){
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
                            url:'xtgl040/delSysUser.do',
                            data:{sid : data.user_id},
                            dataType:"json",
                            success:function(json){
                                if(json.statusCode == 200){
                                    table.reload("userTeble", {});
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
                    title: '修改用户信息',
                    content: 'xtgl040/toXtgl04003.do?user_status='+data.user_status+'&gender='+data.gender,
                    area: ['750px', '600px'],
                    anim: 5,
                    isOutAnim: true,
                    maxmin: true,
                    resize: false,
                    moveOut: true,
                    zIndex: 99999,
                    success: function(layero, index){
                    	var body = layer.getChildFrame('body', index);
                        body.contents().find("INPUT[name='user_id']").val(data.user_id);
                        body.contents().find("INPUT[name='login_name']").val(data.login_name);
                        body.contents().find("INPUT[name='user_name']").val(data.user_name);
                        body.contents().find("INPUT[name='user_phone']").val(data.user_phone);
                        body.contents().find("INPUT[name='position_e']").val(data.position_e);
                        body.contents().find("INPUT[name='e_mail']").val(data.e_mail);
                    },
                    end : function(){
                    	table.reload("userTeble");
                    }
                });
            } else if(layEvent === 'role'){ //设置角色
            	layer.open({
                    type: 2,
                    title: '设置角色',
                    content: 'xtgl040/toXtgl04004.do?id=' +data.user_id,
                    area: ['600px', '400px'],
                    anim: 5,
                    isOutAnim: true,
                    maxmin: true,
                    resize: false,
                    moveOut: true,
                    zIndex: 99999,
                    success: function(layero, index){
                    	var body = layer.getChildFrame('body', index); 
                        body.contents().find("#id").val(data.user_id);
                    }
                });
            } else if(layEvent === 'shou'){ //修改密码
            	layer.open({
                    type: 2,
                    title: '修改密码',
                    content: 'xtgl040/toXtgl04005.do?id=' +data.user_id,
                    area: ['600px', '400px'],
                    anim: 5,
                    isOutAnim: true,
                    maxmin: true,
                    resize: false,
                    moveOut: true,
                    zIndex: 99999,
                    success: function(layero, index){
                    	var body = layer.getChildFrame('body', index); 
                        body.contents().find("INPUT[name='id']").val(data.user_id);
                    }
                });
            }
        });
	});
</script>
</body>
</html>
