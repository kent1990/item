/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-06-07 05:48:10 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class main_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("    <base href=\"");
      out.print(basePath );
      out.write("\">\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <title>后台模板</title>\r\n");
      out.write("    <meta name=\"renderer\" content=\"webkit\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1,user-scalable=no\">\r\n");
      out.write("    <meta name=\"apple-mobile-web-app-status-bar-style\" content=\"black\">\r\n");
      out.write("    <meta name=\"apple-mobile-web-app-capable\" content=\"yes\">\r\n");
      out.write("    <meta name=\"format-detection\" content=\"telephone=no\">\r\n");
      out.write("    <!-- load css -->\r\n");
      out.write("    <link rel=\"icon\" href=\"image/common/logo.png\" type=\"image/x-icon\"/>\r\n");
      out.write("    <!-- load css -->\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(basePath );
      out.write("css/font/iconfont.css?v=1.0.0\" media=\"all\">\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(basePath );
      out.write("js/layui/css/layui.css\" media=\"all\">\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(basePath );
      out.write("css/jqadmin.css?v=2.0.0\" media=\"all\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/business/login/login.css\" />\r\n");
      out.write("    <style type=\"text/css\">\r\n");
      out.write("\t    .layui-logo{\r\n");
      out.write("\t\t    float: left;\r\n");
      out.write("\t\t    min-width: 150px;\r\n");
      out.write("\t\t    position: relative;\r\n");
      out.write("\t\t    padding-right: 30px;\r\n");
      out.write("\t    }\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("    <ul class='right-click-menu'>\r\n");
      out.write("        <li><a href='javascript:;' data-event='fresh'>刷新</a></li>\r\n");
      out.write("        <li><a href='javascript:;' data-event='close'>关闭</a></li>\r\n");
      out.write("        <li><a href='javascript:;' data-event='other'>关闭其它</a></li>\r\n");
      out.write("        <li><a href='javascript:;' data-event='all'>全部关闭</a></li>\r\n");
      out.write("    </ul>\r\n");
      out.write("    <div class=\"layui-layout layui-layout-admin\">\r\n");
      out.write("        <div class=\"layui-header\">\r\n");
      out.write("            <!-- logo区域 -->\r\n");
      out.write("            <div class=\"jqadmin-logo-box\">\r\n");
      out.write("                <a class=\"logo\" href=\"http://jqadmin.jqcool.net\" title=\"jQAdmin\">\r\n");
      out.write("                    <h1>jQadmin</h1>\r\n");
      out.write("                </a>\r\n");
      out.write("                <div class=\"menu-type\"><i class=\"iconfont\">&#xe61a;</i></div>\r\n");
      out.write("            </div>\r\n");
      out.write("        \r\n");
      out.write("            <!-- 主菜单区域 -->\r\n");
      out.write("            <div class=\"jqadmin-main-menu\" style=\"overflow:hidden;\">\r\n");
      out.write("                <ul class=\"layui-nav clearfix\" id=\"menu\" lay-filter=\"main-menu\" >\r\n");
      out.write("                   \t<script id=\"menu-tpl\" type=\"text/html\" data-params='{\"url\":\"");
      out.print(basePath );
      out.write("login/queryMenu.do\",\"listid\":\"menu\"}'>\r\n");
      out.write("    \t\t\t\t{{# layui.each(d.list, function(index, item){ }}\r\n");
      out.write("    \t\t\t\t\t<li class=\"layui-nav-item {{# if(index==0){ }}layui-this{{# } }}\">\r\n");
      out.write("        \t\t\t\t\t<a href=\"javascript:;\" data-title=\"{{item.name}}\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<i class=\"iconfont  {{# if(!d.showIcon){ }} hide-icon  {{# } }}\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t{{item.iconfont}}\r\n");
      out.write("\t\t\t\t\t\t\t\t</i>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span style=\"font-size: 16px\">{{item.name}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t</a>\r\n");
      out.write("    \t\t\t\t\t</li>\r\n");
      out.write("    \t\t\t\t{{# }); }}\r\n");
      out.write("\t\t\t\t\t</script>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <!-- 头部右侧导航 -->\r\n");
      out.write("            <div class=\"layui-btn-group\">\r\n");
      out.write("  \r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("            <div class=\"header-right\" >\r\n");
      out.write("            \r\n");
      out.write("                <ul class=\"layui-nav jqadmin-header-item right-menu\">\r\n");
      out.write("                   <li class=\"layui-nav-item\">\r\n");
      out.write("                    \t<a id=\"cashier\" href=\"cashier/toCashiermgr.do\" target=\"_blank\" style=\"cursor:pointer\"><i class=\"iconfont \">&#xe611;</i>收银台</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"layui-nav-item first\">\r\n");
      out.write("                    \t<a><i class=\"iconfont \">&#xe612;</i>管理员</a>\r\n");
      out.write("                        <dl class=\"layui-nav-child\">\r\n");
      out.write("                               <dd>\r\n");
      out.write("                                  <a id=\"xgmm\" href=\"javascript:void(0);\"><i class=\"iconfont \">&#xe632; </i>修改密码</a></dd> \r\n");
      out.write("                               <dd>\r\n");
      out.write("                                 <a id=\"exit\" href=\"javaScript:void(0)\"><i class=\"iconfont \">&#xe64b; </i>退出</a>\r\n");
      out.write("                               </dd>\r\n");
      out.write("                        </dl>\r\n");
      out.write("                    </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("                <button title=\"刷新\" class=\"layui-btn layui-btn-normal fresh-btn\">\r\n");
      out.write("                \t<i class=\"iconfont\">&#xe62e; </i> \r\n");
      out.write("                </button>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <!-- 左侧导航-->\r\n");
      out.write("        <div class=\"layui-side layui-bg-black jqamdin-left-bar\">\r\n");
      out.write("            <div class=\"layui-side-scroll\">\r\n");
      out.write("                <!--子菜单项-->\r\n");
      out.write("                <div id=\"submenu\"></div>\r\n");
      out.write("                \t\r\n");
      out.write(" \t\t<script id=\"submenu-tpl\" type=\"text/html\">\r\n");
      out.write("    \t\t{{# layui.each(d.list, function(index, menu){ }}\r\n");
      out.write("    \t\t<div class=\"sub-menu\">\r\n");
      out.write("        \t\t<ul class=\"layui-nav layui-nav-tree\">\r\n");
      out.write("            \t\t{{# layui.each(menu.sub, function(index, submenu){ }} \r\n");
      out.write("\t\t\t\t\t{{# if(submenu.sub && submenu.sub.length>0){ }}\r\n");
      out.write("            \t\t\t<li class=\"layui-nav-item\" data-bind=\"0\">\r\n");
      out.write("                \t\t\t<a href=\"javascript:;\" data-title=\"{{submenu.name}}\">\r\n");
      out.write("                    \t\t\t<i class=\"iconfont {{# if(!d.showIcon){ }} hide-icon  {{# } }}\">{{submenu.iconfont}}</i>\r\n");
      out.write("                    \t\t\t<span>{{submenu.name}}</span>\r\n");
      out.write("                    \t\t\t<em class=\"layui-nav-more\"></em>\r\n");
      out.write("                \t\t\t</a>\r\n");
      out.write("                \t\t\t<dl class=\"layui-nav-child\">\r\n");
      out.write("                    \t\t\t{{# layui.each(submenu.sub, function(index, secMenu){ }}\r\n");
      out.write("                    \t\t\t<dd>\r\n");
      out.write("                        \t\t\t<a href=\"javascript:;\" data-url=\"{{secMenu.url}}\" data-title=\"{{secMenu.name}}\">\r\n");
      out.write("                            \t\t\t<i class=\"iconfont  {{# if(!d.showIcon){ }} hide-icon  {{# } }}\" \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tdata-icon='{{secMenu.iconfont}}'>{{secMenu.iconfont}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</i>\r\n");
      out.write("                            \t\t\t<span>{{secMenu.name}}</span>\r\n");
      out.write("                        \t\t\t</a>\r\n");
      out.write("                    \t\t\t</dd>\r\n");
      out.write("                    \t\t\t{{# }); }}\r\n");
      out.write("                \t\t\t</dl>\r\n");
      out.write("            \t\t\t</li>\r\n");
      out.write("            \t\t{{# }else{ }}\r\n");
      out.write("            \t\t\t<li class=\"layui-nav-item\">\r\n");
      out.write("                \t\t\t<a href=\"javascript:;\" data-url=\"{{submenu.url}}\" data-title=\"{{submenu.name}}\">\r\n");
      out.write("                    \t\t\t<i class=\"iconfont  {{# if(!d.showIcon){ }} hide-icon  {{# } }}\" \r\n");
      out.write("\t\t\t\t\t\t\t\t\tdata-icon='{{submenu.iconfont}}'>{{submenu.iconfont}}\r\n");
      out.write("\t\t\t\t\t\t\t\t</i>\r\n");
      out.write("                    \t\t\t<span>{{submenu.name}}</span>\r\n");
      out.write("                \t\t\t</a>\r\n");
      out.write("            \t\t\t</li>\r\n");
      out.write("            \t\t{{# } }} {{# }); }}\r\n");
      out.write("        \t\t</ul>\r\n");
      out.write("    \t\t</div>\r\n");
      out.write("    \t\t{{# }); }}\r\n");
      out.write("\t\t</script>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <!-- 左侧侧边导航结束 -->\r\n");
      out.write("        <!-- 右侧主体内容 -->\r\n");
      out.write("        <div class=\"layui-body jqadmin-body\">\r\n");
      out.write("\r\n");
      out.write("            <div class=\"layui-tab layui-tab-card jqadmin-tab-box\" id=\"jqadmin-tab\" lay-filter=\"tabmenu\" lay-notAuto=\"true\">\r\n");
      out.write("                <ul class=\"layui-tab-title\">\r\n");
      out.write("                    <li class=\"layui-this\" id=\"admin-home\" lay-id=\"0\" fresh=1><i class=\"iconfont\">&#xe622;</i><em>后台首页</em></li>\r\n");
      out.write("                </ul>\r\n");
      out.write("                <div class=\"menu-btn\" title=\"显示左则菜单\">\r\n");
      out.write("                    <i class=\"iconfont\">&#xe616;</i>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"tab-move-btn\">\r\n");
      out.write("                    <span>更多<i class=\"iconfont\">&#xe604;</i></span>\r\n");
      out.write("\r\n");
      out.write("                    <!--<span class=\"move-left-btn\"><i class=\"iconfont\">&#xe616;</i></span>\r\n");
      out.write("                    <span class=\"move-right-btn\"><i class=\"iconfont \">&#xe618;</i></span>-->\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"layui-tab-content\">\r\n");
      out.write("                     <div class=\"layui-tab-item layui-show\">\r\n");
      out.write("                                                                        欢迎\r\n");
      out.write("                       <!--  <iframe class=\"jqadmin-iframe\" data-id='0' src=\"welcome.html\"></iframe> -->\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- 底部区域 -->\r\n");
      out.write("        <div class=\"layui-footer jqadmin-foot\">\r\n");
      out.write("            <div class=\"layui-mian\">\r\n");
      out.write("                <p class=\"jqadmin-copyright\">\r\n");
      out.write("                    <span class=\"layui\">2019 &copy;</span> \r\n");
      out.write("                                                  郑州科技学院,<a href=\"http://www.baidu.com\">507</a>. 版权所有 \r\n");
      out.write("                    <span class=\"layui\">依赖前端框架layui</span>\r\n");
      out.write("                </p>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"my-tip\">\r\n");
      out.write("        <img src=\"images/20170724234211.jpg\" alt=\"\" />\r\n");
      out.write("    </div>\r\n");
      out.write("    <ul class=\"menu-list\" id=\"menu-list\"></ul>\r\n");
      out.write("</body>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/layui/layui.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(basePath );
      out.write("js/layui/layui.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(basePath );
      out.write("js/common/jquery-1.11.3.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("    var global = {};\r\n");
      out.write("    layui.config({\r\n");
      out.write("        base: \"");
      out.print(basePath );
      out.write("js/\",\r\n");
      out.write("        version: \"2.0.0\"\r\n");
      out.write("    }).extend({\r\n");
      out.write("        jqelem: \"layui/lay/jqmodules/jqelem\",\r\n");
      out.write("        jqmenu: \"layui/lay/jqmodules/jqmenu\",\r\n");
      out.write("        tabmenu: \"layui/lay/jqmodules/tabmenu\",\r\n");
      out.write("        jqajax: \"layui/lay/jqmodules/jqajax\",\r\n");
      out.write("        index:\"business/index/index\"\r\n");
      out.write("    }).use(\"index\");\r\n");
      out.write("    $(function(){\r\n");
      out.write("    \t$(\"#exit\").on(\"click\", function(){\r\n");
      out.write("    \t\twindow.sessionStorage.clear();\r\n");
      out.write("        \twindow.top.location = \"login/exit.do\";\r\n");
      out.write("        });\r\n");
      out.write("        \r\n");
      out.write("        /* //打开收银台\r\n");
      out.write("        $(\"#cashier\").on(\"click\",function(){\r\n");
      out.write("           \r\n");
      out.write("        }); */\r\n");
      out.write("    });\r\n");
      out.write("</script>\r\n");
      out.write("<!-- 页签列表模板 -->\r\n");
      out.write("<script id=\"menu-list-tpl\" type=\"text/html\">\r\n");
      out.write("    {{# layui.each(d.list, function(index, item){ }}\r\n");
      out.write("    <li>\r\n");
      out.write("        <a href=\"javascript:;\" data-url=\"{{item.href}}\" data-title=\"{{item.title}}\">\r\n");
      out.write("            <i class=\"iconfont\" data-icon='{{item.icon}}'>{{item.icon}}</i>\r\n");
      out.write("            <span>{{item.title}}</span>\r\n");
      out.write("        </a>\r\n");
      out.write("    </li>\r\n");
      out.write("    {{# }); }}\r\n");
      out.write("</script>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
