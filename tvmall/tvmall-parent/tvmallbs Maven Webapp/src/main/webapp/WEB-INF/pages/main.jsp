<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <base href="<%=basePath %>">
    <meta charset="UTF-8">
    <title>后台模板</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1,user-scalable=no">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <!-- load css -->
    <link rel="icon" href="image/common/logo.png" type="image/x-icon"/>
    <!-- load css -->
    <link rel="stylesheet" type="text/css" href="<%=basePath %>css/font/iconfont.css?v=1.0.0" media="all">
    <link rel="stylesheet" type="text/css" href="<%=basePath %>js/layui/css/layui.css" media="all">
    <link rel="stylesheet" type="text/css" href="<%=basePath %>css/jqadmin.css?v=2.0.0" media="all">
    <link rel="stylesheet" href="css/business/login/login.css" />
    <style type="text/css">
	    .layui-logo{
		    float: left;
		    min-width: 150px;
		    position: relative;
		    padding-right: 30px;
	    }
    </style>
</head>

<body>
    <ul class='right-click-menu'>
        <li><a href='javascript:;' data-event='fresh'>刷新</a></li>
        <li><a href='javascript:;' data-event='close'>关闭</a></li>
        <li><a href='javascript:;' data-event='other'>关闭其它</a></li>
        <li><a href='javascript:;' data-event='all'>全部关闭</a></li>
    </ul>
    <div class="layui-layout layui-layout-admin">
        <div class="layui-header">
            <!-- logo区域 -->
            <div class="jqadmin-logo-box">
                <a class="logo" href="http://jqadmin.jqcool.net" title="jQAdmin">
                    <h1>jQadmin</h1>
                </a>
                <div class="menu-type"><i class="iconfont">&#xe61a;</i></div>
            </div>
        
            <!-- 主菜单区域 -->
            <div class="jqadmin-main-menu" style="overflow:hidden;">
                <ul class="layui-nav clearfix" id="menu" lay-filter="main-menu" >
                   	<script id="menu-tpl" type="text/html" data-params='{"url":"<%=basePath %>login/queryMenu.do","listid":"menu"}'>
    				{{# layui.each(d.list, function(index, item){ }}
    					<li class="layui-nav-item {{# if(index==0){ }}layui-this{{# } }}">
        					<a href="javascript:;" data-title="{{item.name}}">
								<i class="iconfont  {{# if(!d.showIcon){ }} hide-icon  {{# } }}">
									{{item.iconfont}}
								</i>
								<span style="font-size: 16px">{{item.name}}</span>
							</a>
    					</li>
    				{{# }); }}
					</script>
                </ul>
            </div>

            <!-- 头部右侧导航 -->
            <div class="layui-btn-group">
  
			</div>
            <div class="header-right" >
            
                <ul class="layui-nav jqadmin-header-item right-menu">
                   <li class="layui-nav-item">
                    	<a id="cashier" href="cashier/toCashiermgr.do" target="_blank" style="cursor:pointer"><i class="iconfont ">&#xe611;</i>收银台</a>
                    </li>
                    <li class="layui-nav-item first">
                    	<a><i class="iconfont ">&#xe612;</i>管理员</a>
                        <dl class="layui-nav-child">
                               <dd>
                                  <a id="xgmm" href="javascript:void(0);"><i class="iconfont ">&#xe632; </i>修改密码</a></dd> 
                               <dd>
                                 <a id="exit" href="javaScript:void(0)"><i class="iconfont ">&#xe64b; </i>退出</a>
                               </dd>
                        </dl>
                    </li>
                </ul>
                <button title="刷新" class="layui-btn layui-btn-normal fresh-btn">
                	<i class="iconfont">&#xe62e; </i> 
                </button>
            </div>
        </div>

        <!-- 左侧导航-->
        <div class="layui-side layui-bg-black jqamdin-left-bar">
            <div class="layui-side-scroll">
                <!--子菜单项-->
                <div id="submenu"></div>
                	
 		<script id="submenu-tpl" type="text/html">
    		{{# layui.each(d.list, function(index, menu){ }}
    		<div class="sub-menu">
        		<ul class="layui-nav layui-nav-tree">
            		{{# layui.each(menu.sub, function(index, submenu){ }} 
					{{# if(submenu.sub && submenu.sub.length>0){ }}
            			<li class="layui-nav-item" data-bind="0">
                			<a href="javascript:;" data-title="{{submenu.name}}">
                    			<i class="iconfont {{# if(!d.showIcon){ }} hide-icon  {{# } }}">{{submenu.iconfont}}</i>
                    			<span>{{submenu.name}}</span>
                    			<em class="layui-nav-more"></em>
                			</a>
                			<dl class="layui-nav-child">
                    			{{# layui.each(submenu.sub, function(index, secMenu){ }}
                    			<dd>
                        			<a href="javascript:;" data-url="{{secMenu.url}}" data-title="{{secMenu.name}}">
                            			<i class="iconfont  {{# if(!d.showIcon){ }} hide-icon  {{# } }}" 
											data-icon='{{secMenu.iconfont}}'>{{secMenu.iconfont}}
										</i>
                            			<span>{{secMenu.name}}</span>
                        			</a>
                    			</dd>
                    			{{# }); }}
                			</dl>
            			</li>
            		{{# }else{ }}
            			<li class="layui-nav-item">
                			<a href="javascript:;" data-url="{{submenu.url}}" data-title="{{submenu.name}}">
                    			<i class="iconfont  {{# if(!d.showIcon){ }} hide-icon  {{# } }}" 
									data-icon='{{submenu.iconfont}}'>{{submenu.iconfont}}
								</i>
                    			<span>{{submenu.name}}</span>
                			</a>
            			</li>
            		{{# } }} {{# }); }}
        		</ul>
    		</div>
    		{{# }); }}
		</script>
            </div>
        </div>

        <!-- 左侧侧边导航结束 -->
        <!-- 右侧主体内容 -->
        <div class="layui-body jqadmin-body">

            <div class="layui-tab layui-tab-card jqadmin-tab-box" id="jqadmin-tab" lay-filter="tabmenu" lay-notAuto="true">
                <ul class="layui-tab-title">
                    <li class="layui-this" id="admin-home" lay-id="0" fresh=1><i class="iconfont">&#xe622;</i><em>后台首页</em></li>
                </ul>
                <div class="menu-btn" title="显示左则菜单">
                    <i class="iconfont">&#xe616;</i>
                </div>
                <div class="tab-move-btn">
                    <span>更多<i class="iconfont">&#xe604;</i></span>

                    <!--<span class="move-left-btn"><i class="iconfont">&#xe616;</i></span>
                    <span class="move-right-btn"><i class="iconfont ">&#xe618;</i></span>-->
                </div>
                <div class="layui-tab-content">
                     <div class="layui-tab-item layui-show">
                                                                        欢迎
                       <!--  <iframe class="jqadmin-iframe" data-id='0' src="welcome.html"></iframe> -->
                    </div>
                </div>
            </div>
        </div>
        <!-- 底部区域 -->
        <div class="layui-footer jqadmin-foot">
            <div class="layui-mian">
                <p class="jqadmin-copyright">
                    <span class="layui">2019 &copy;</span> 
                                                  郑州科技学院,<a href="http://www.baidu.com">507</a>. 版权所有 
                    <span class="layui">依赖前端框架layui</span>
                </p>
            </div>
        </div>
    </div>
    <div class="my-tip">
        <img src="images/20170724234211.jpg" alt="" />
    </div>
    <ul class="menu-list" id="menu-list"></ul>
</body>
<script type="text/javascript" src="js/layui/layui.js"></script>
<script type="text/javascript" src="<%=basePath %>js/layui/layui.js"></script>
<script type="text/javascript" src="<%=basePath %>js/common/jquery-1.11.3.js"></script>
<script type="text/javascript">
    var global = {};
    layui.config({
        base: "<%=basePath %>js/",
        version: "2.0.0"
    }).extend({
        jqelem: "layui/lay/jqmodules/jqelem",
        jqmenu: "layui/lay/jqmodules/jqmenu",
        tabmenu: "layui/lay/jqmodules/tabmenu",
        jqajax: "layui/lay/jqmodules/jqajax",
        index:"business/index/index"
    }).use("index");
    $(function(){
    	$("#exit").on("click", function(){
    		window.sessionStorage.clear();
        	window.top.location = "login/exit.do";
        });
        
        /* //打开收银台
        $("#cashier").on("click",function(){
           
        }); */
    });
</script>
<!-- 页签列表模板 -->
<script id="menu-list-tpl" type="text/html">
    {{# layui.each(d.list, function(index, item){ }}
    <li>
        <a href="javascript:;" data-url="{{item.href}}" data-title="{{item.title}}">
            <i class="iconfont" data-icon='{{item.icon}}'>{{item.icon}}</i>
            <span>{{item.title}}</span>
        </a>
    </li>
    {{# }); }}
</script>
</html>