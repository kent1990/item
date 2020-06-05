package com.zhengke.controller.sysmgr;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhengke.common.object.AjaxDone;
import com.zhengke.common.object.Result;
import com.zhengke.common.object.ZTreeNode;
import com.zhengke.controller.common.BaseController;
import com.zhengke.pojo.SysRoleRights;
import com.zhengke.pojo.SysRoles;
import com.zhengke.service.LoginService;
import com.zhengke.service.sysmgr.XTGL030Service;


@Controller @RequestMapping("xtgl030/")
public class XTGL030Controller extends BaseController {

	 @Reference
	private XTGL030Service service;
	@Reference
	private LoginService loginService;
	/**
	 * 跳转到角色页面
	 * @return
	 */
	@RequestMapping("toXtgl03001.do")
	public String toXtgl03001(){
		
		return "sysmgr/xtgl030/xtgl03001";
	}

	/**
	 * 取角色信息
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("query.do") @ResponseBody
	public Result query(int page,int limit){
		Result rs = null;
		try{
			rs = service.query(page,limit);
			return rs;
			
		} catch(Exception e){
			e.printStackTrace();
		}
		return new Result();
	}
	
	/**
	 * 跳转到添加角色页面
	 * @return
	 */
	@RequestMapping("toXtgl03002.do") 
	public String toXtgl03002(){
		return "sysmgr/xtgl030/xtgl03002";
	}
	
	/**
	 * 添加角色
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("addRoles.do") @ResponseBody
	public AjaxDone addRoles(HttpServletRequest request, HttpServletResponse response){
		String roleName = request.getParameter("role_name");
		String status = request.getParameter("status");
		
		try{
			SysRoles sr = new SysRoles();
			sr.setRoleName(roleName);
			sr.setStatus(status);
			sr.setCreateTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
			sr.setCreateUser(getLoginObject(request).getUserName());
			
			Integer i = service.saveRole(sr);
			if(i <= 0){
				return new AjaxDone("300", "系统繁忙,请稍后再试!");
			}
			return new AjaxDone("200", "请求成功");
		} catch(Exception e){
			e.printStackTrace();
			return new AjaxDone("300", "系统繁忙,请稍后再试!");
		}
	}
	
	/**
	 * 跳转到修改角色页面
	 * @return
	 */
	@RequestMapping("toXtgl03003.do")
	public String toXtgl03003(){
		return "sysmgr/xtgl030/xtgl03003";
	}
	
	/** 
	 * 修改角色信息
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("updRoles.do") @ResponseBody
	public AjaxDone updRoles(HttpServletRequest request, HttpServletResponse response){
		String roleId = request.getParameter("role_id");
		String roleName = request.getParameter("role_name");
		String status = request.getParameter("status");
		
		try{
			SysRoles sr = new SysRoles();
			sr.setRoleId(Integer.parseInt(roleId));
			sr.setRoleName(roleName);
			sr.setStatus(status);
			sr.setUpdateDate(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
			sr.setUpdateUser(getLoginObject(request).getUserName());
			
			Integer i = service.updRole(sr);
			if(i <= 0){
				return new AjaxDone("300", "系统繁忙,请稍后再试!");
			}
			return new AjaxDone("200", "请求成功");
		} catch(Exception e){
			e.printStackTrace();
			return new AjaxDone("300", "系统繁忙,请稍后再试!");
		}
	}
	
	/** 
	 * 删除角色
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("delRelos.do") @ResponseBody
	public AjaxDone delRelos(HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("id");
		
		try{
			Integer i = service.delRoles(Integer.parseInt(id));
			if(i <= 0){
				return new AjaxDone("300", "系统繁忙,请稍后再试!");
			}
			return new AjaxDone("200", "删除成功");
		} catch(Exception e){
			e.printStackTrace();
			return new AjaxDone("300", "系统繁忙,请稍后再试!");
		}
	}
	
	/**
	 * 跳转到授权页面
	 * @return
	 */
	@RequestMapping("toXtgl03004.do")
	public String toXtgl03004(String id,ModelMap model){
		model.put("id", id);
		return "sysmgr/xtgl030/xtgl03004";
	}
	
	@ResponseBody
	@RequestMapping("queryPopedom.do") 
	public List<ZTreeNode> queryPopedom(HttpServletRequest request, HttpServletResponse response){
		String roleId = request.getParameter("roleId");
		try{
			List<ZTreeNode> ztn = service.createTree(roleId);
			return ztn;
		} catch(Exception e){
			e.printStackTrace(); 
		}
		return null;
	}
	
	/**
	 * 保持角色权限信息
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping("saveRolesPopedom.do") 
	public AjaxDone saveRolesPopedom(HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("roleId");
		String popedom = request.getParameter("ids");
		
		try{
			Integer roleId = Integer.parseInt(id);
			String[] roles = popedom.split(",");
			List<SysRoleRights> list = new ArrayList<SysRoleRights>();
			
			if(!"".equals(popedom)){
				for (String role : roles) {
					SysRoleRights srr = new SysRoleRights();
					srr.setRoleId(roleId);
					srr.setPopedomId(Integer.parseInt(role));
					srr.setCreateTime(new SimpleDateFormat().format(new Date()));
					srr.setCreateUserId(getLoginObject(request).getUserId());
					srr.setCreateUserName(getLoginObject(request).getUserName());
					list.add(srr);
				}
			}			
			service.savePopedomRoles(roleId, list);
			
			/**
			 * 1. 同时查询当前角色对应的后台管理用户的userId <br/>
			 * 2. 循环遍历每一个后台管理员用户，查询出每个后台管理员用户对应的权限信息（修改角色权限后的状态）<br/>
			 * 3. 从Application对象中找出每个后台用户对应的session对象，重置session对象中的权限信息，
			 * 	     如果找不到session对象（该用户未登录）返回null，不做操作<br/>
			 */
			List<Map<String,Object>> sruList = service.queryRoleUser(String.valueOf(roleId));
			for(Map<String,Object> sru : sruList){
				//从Application对象中取得对应用户的session信息，如果取不到则返回session对象为null
				//如果后台用户权限被重新设定则立即刷新对应在线用户的权限session信息
				String userId = String.valueOf(sru.get("user_id")); 
				HttpSession session = (HttpSession)request.getSession().getServletContext().getAttribute(userId);
				if(session!=null) {
					Map<String, String> popedomMap = loginService.queryPopedom(userId,"1".equals(userId));			
					session.setAttribute(USER_POPEDOM_KEY,popedomMap);
				}
			}			
			return new AjaxDone("200", "请求成功");
		} catch(Exception e){
			e.printStackTrace();
			return new AjaxDone("300", "系统繁忙,请稍后再试!");
		}
	}
}
