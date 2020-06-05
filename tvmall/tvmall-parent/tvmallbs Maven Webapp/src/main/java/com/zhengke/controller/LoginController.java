package com.zhengke.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhengke.common.object.LoginObject;
import com.zhengke.common.util.DateUtil;
import com.zhengke.common.util.StringUtil;
import com.zhengke.common.util.VerifyCode;
import com.zhengke.controller.common.BaseController;
import com.zhengke.pojo.SysUser;
import com.zhengke.service.LoginService;

@Controller
@RequestMapping("login")
public class LoginController extends BaseController {
	
	@Reference
	private LoginService loginService;
	
	/**
	 * s 登录
	 * @param loginName
	 * @param loginPwd
	 * @return
	 */
	@RequestMapping("login.do")
	public String login(String loginName,String loginPwd,String verifyCode,ModelMap model,HttpServletRequest request) {
		SysUser su = null;
		try{
			//判断是否输入登录账号
			if(loginName==null||"".equals(loginName)){
				model.put("errorMsg", "❈请输入用户名!");
				return "../../login";
			}
			if(loginPwd==null||"".equals(loginPwd)){
				model.put("loginName", loginName);
				model.put("errorMsg", "❈请输入密码!");
				return "../../login";
			}
			
			if(StringUtils.isEmpty(verifyCode)){
				model.put("loginName", loginName);
				model.put("loginPwd", loginPwd);
				model.put("errorMsg", "❈请输入图片验证码!");
				return "../../login";
			}
			
			String verifyCodeSession = String.valueOf(request.getSession().getAttribute("verifyCode"));
			if(!verifyCodeSession.equalsIgnoreCase(verifyCode)){
				model.put("loginName", "");
				model.put("loginPwd", "");
				model.put("errorMsg", "❈会话超时请登录!");
				return "../../login";
			}
			
			su = loginService.querySysUser(loginName);
			//判断账号是否存在
			if(su == null){
				model.put("loginName", loginName);
				model.put("errorMsg", "❈该账号不存在");
				return "../../login";
			}
			//判断账号当前的状态
			if(su.getStatus()==0){
				model.put("loginName", loginName);
				model.put("errorMsg", "❈该账号被禁用");
				return "../../login";
			}
			//判断账号的密码
			if(!StringUtil.str2MD5(loginPwd).equals(su.getLoginPwd())){
				model.put("loginName", loginName);
				model.put("errorMsg", "❈密码错误");
				return "../../login";
			}
			
			//获取登录时的信息
			String loginDate = DateUtil.getSystemDateTime();
			String loginIp = StringUtil.getIpAddr(request);
			int loginTimes = su.getLoginTimes()+1;
			
			//登录Session中账号信息
			LoginObject login = new LoginObject();
			login.setUserId(su.getUserId());
			login.setLoginName(su.getLoginName());
			if(su.getProvinceId()!=null){
				login.setProvinceId(su.getProvinceId().toString());
			}
			if(su.getCityId()!=null){
				login.setCityId(su.getCityId().toString());
			}
			if(su.getServicePointId()!=null){
				login.setServicePointId(su.getServicePointId().toString());
			}
			login.setCrtLoginIp(loginIp);
			login.setCrtLoginTime(loginDate);
			login.setLastLoginIp(su.getLastLoginIp());
			login.setLastLoginTime(su.getLastLoginTime());
			login.setLoginTimes(String.valueOf(loginTimes));
			login.setLoginName(su.getLoginName());
			login.setUserName(su.getUserName());
			//判断是否存在会话
			if(getLoginObject(request)==null)
			{
				//更新登录账号信息
				su.setLastLoginTime(loginDate);
				su.setLastLoginIp(loginIp);
				su.setLoginTimes(loginTimes);
				loginService.updateSysUser(su);
			}
			
			request.getSession().setAttribute(SESSION_USER_KEY, login);
			
			
			//查询权限
			Map<String, String> popedomMap = loginService.queryPopedom(String.valueOf(login.getUserId()),su.getUserId()==1);
			request.getSession().setAttribute(USER_POPEDOM_KEY, popedomMap);
			//将当前用户的会话对象写入到application对象中
			ServletContext application = request.getSession().getServletContext();
			application.setAttribute(String.valueOf(login.getUserId()),request.getSession());
		}catch(Exception e) {
			e.printStackTrace();			
		}
		return "main";
	}
	
	/**
	 * 图片验证码
	 */
	@RequestMapping("verify.do")
	public void graphicVerify(HttpServletRequest request,HttpServletResponse response) {
		response.setContentType("image/jpeg");  
        //禁止图像缓存。  
        response.setHeader("Pragma", "no-cache");  
        response.setHeader("Cache-Control", "no-cache");  
        response.setDateHeader("Expires", 0);  
      
        HttpSession session = request.getSession(); 
        
        String verifyCode = VerifyCode.runVerifyCode(4);
        session.setAttribute("verifyCode", verifyCode);
        try {
			ImageIO.write(VerifyCode.CreateImage(verifyCode), "JPEG", response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 退出登陆
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/exit.do", method = RequestMethod.GET)
	public String exit(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		session.removeAttribute(SESSION_USER_KEY);
		session.removeAttribute(USER_POPEDOM_KEY);
		return "../../login";
	}
	
	/**
	 * 菜单的
	 * @return
	 */
	@RequestMapping(value = "/queryMenu.do", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> queryMenu(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		try{
			List<Object> list = loginService.queryMenu();
			Map<String, Object> map = new HashMap<String, Object>();
			rtnMap.put("status", 200);
			map.put("list", list);
			rtnMap.put("data", map);
		} catch(Exception e){
			e.printStackTrace();
		}
		return rtnMap;
	}
	
	@RequestMapping("/query/{id}/{name}" )
	@ResponseBody
	public String testREST(@PathVariable int id,@PathVariable String name){
		System.out.println(id+"----------------------"+name);
		return id+"----------------------"+name;
	}	
}
