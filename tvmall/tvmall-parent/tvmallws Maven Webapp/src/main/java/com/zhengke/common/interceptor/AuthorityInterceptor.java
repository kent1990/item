package com.zhengke.common.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.zhengke.common.exception.LoginErrorException;

public  class AuthorityInterceptor extends AbstractInterceptor  implements StrutsStatics {
	
	private static final long serialVersionUID = -6483845797031085457L;	
	public static final String SESSION_USER_KEY = "userinfo";	
	public String intercept(ActionInvocation invocation) throws Exception {

		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		String URL = request.getRequestURI(); /*需要判断是否是ajax请求*/
		
		//System.out.println(URL);
		try{
			if(!URL.endsWith("login!login.do")&&!URL.endsWith("logout.do")){ //登录请求不验证				if(ActionContext.getContext().getSession().get(SESSION_USER_KEY)==null){
					throw new LoginErrorException();
				}
			}
			final String res = invocation.invoke(); 
			return res;
		}catch(LoginErrorException e){
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();			
			out.println("{\"statusCode\":\"301\", \"message\":\"会话超时! 请重新登录!\"}");
			out.flush();
			out.close();
		    return null; 
		}catch(Exception e){
             e.printStackTrace(); 
	        return Action.ERROR; 
		}
	}
}