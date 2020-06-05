package com.zhengke.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler) throws Exception {
        
        String requestType = request.getHeader("X-Requested-With"); 
       
        if(request.getSession() != null && request.getSession().getAttribute("userinfo") != null) {
            return true;
        }
        if("XMLHttpRequest".equals(requestType)){
        	PrintWriter pw = response.getWriter();
        	response.setHeader("timeout", "timeout");
        	response.setHeader("url", request.getContextPath()+"/login/exit.do");
        	pw.flush();
        } else{
        	response.setCharacterEncoding("utf-8");
        	response.getWriter().print("<script type='text/javascript'>window.top.location='" + request.getContextPath() + "/login/exit.do';</script>");
        }
        return false;
	}
}
