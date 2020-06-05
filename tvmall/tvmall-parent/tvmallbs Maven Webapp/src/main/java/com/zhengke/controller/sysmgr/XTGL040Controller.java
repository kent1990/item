package com.zhengke.controller.sysmgr;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhengke.common.object.AjaxDone;
import com.zhengke.common.object.Result;
import com.zhengke.common.util.StringUtil;
import com.zhengke.controller.common.BaseController;
import com.zhengke.pojo.SysRoleUser;
import com.zhengke.service.sysmgr.XTGL040Service;


@Controller @RequestMapping("xtgl040/")
public class XTGL040Controller extends BaseController {

	@Reference
	private XTGL040Service service;
	
	/**
	 * 跳转到用户管理页面
	 * @return
	 */
	@RequestMapping("toXtgl04001.do")
	public String toXtgl04001(){
		return "sysmgr/xtgl040/xtgl04001";
	}
	
	/**
	 * 获取用户数据
	 * @param reqquest
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping("query.do") 
	public Result query(HttpServletRequest reqquest,int page,int limit){
		
		String userName = reqquest.getParameter("username");
		String userPhone = reqquest.getParameter("userphone");
		String user_status = reqquest.getParameter("my_status");
		String iden = reqquest.getParameter("my_iden");
		
		Result rs = null;
		try{
			Map<String, Object> param = new HashMap<String, Object>();			
			param.put("name", userName);
			param.put("phone", userPhone);
			param.put("user_status", user_status);
			param.put("iden", iden);
			
			rs = service.query(param,page,limit);
			return rs;
		} catch(Exception e){
			e.printStackTrace();			
		}
		return new Result();
	}
	
	/**
	 * 跳转到添加用户页�?
	 * @return
	 */
	@RequestMapping("toXtgl04002.do")
	public String toXtgl04002(ModelMap model){
		return "sysmgr/xtgl040/xtgl04002";
	}
	
	/**
	 * 添加用户
	 * @param su
	 * @param request
	 * @param response
	 * @return
	 */
	
	@RequestMapping("saveSysUser.do") @ResponseBody
	public AjaxDone saveSysUser( HttpServletRequest request,
			HttpServletResponse response,@RequestParam Map<String, Object> map){
		
		try{
			map.put("create_time",new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
			map.put("create_user_id",getLoginObject(request).getUserId());
			map.put("create_user_name",getLoginObject(request).getUserName());
			map.put("login_times",0);
			map.put("login_pwd",StringUtil.str2MD5(map.get("login_pwd").toString()));
			map.put("last_login_time", "未登�?");
			service.saveSysUserMap(map);
			return new AjaxDone("200", "添加成功");
		}catch(Exception e){
			e.printStackTrace();
			return new AjaxDone("300", "系统繁忙,请稍后再�?!");
		}
	}
	
	/**
	 * 删除用户，可批量操作
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("delSysUser.do") @ResponseBody
	public AjaxDone delSysUser(HttpServletRequest request, HttpServletResponse response){
		String sid = request.getParameter("sid");
		
		try{
			service.delSysUser(sid);
			return new AjaxDone("200", "删除成功");
		} catch(Exception e){
			e.printStackTrace();
			return new AjaxDone("300", "系统繁忙,请稍后再�?!");
		}
	}
	
	/**
	 * 跳转到修改用户页�?
	 * @return
	 */
	@RequestMapping("toXtgl04003.do")
	public String toXtgl04003(HttpServletRequest request, HttpServletResponse response, ModelMap model){
		String user_status = request.getParameter("user_status");
		String gender = request.getParameter("gender");
		try {			
			
			model.put("user_status", user_status);
			model.put("gender", gender);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "sysmgr/xtgl040/xtgl04003";
	}
	
	/**
	 * 修改用户
	 * @param su
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("updSysUser.do") @ResponseBody
	public AjaxDone updSysUser( HttpServletRequest request,
			HttpServletResponse response,@RequestParam Map<String, Object> map){
		try{
			map.put("update_time",new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
			map.put("update_user_id",getLoginObject(request).getUserId());
			map.put("update_user_name",getLoginObject(request).getUserName());
			
			service.updSysUserMap(map);
			return new AjaxDone("200", "修改成功");
		}catch(Exception e){
			e.printStackTrace();
			return new AjaxDone("300", "系统繁忙,请稍后重试!");
		}
	}
	
	/**
	 * 跳转到设置角色页�?
	 * @return
	 */
	@RequestMapping("toXtgl04004.do")
	public String toXtgl04004(HttpServletRequest request, 
				HttpServletResponse response, ModelMap model){
		String id = request.getParameter("id");
		
		try{
			List<Map<String, Object>> list = service.queryRoles(id);
			model.put("data", list);
		} catch(Exception e){
			e.printStackTrace();
		}
		return "sysmgr/xtgl040/xtgl04004";
	}
	
	/**
	 * 设置角色
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("setRole.do") @ResponseBody
	public AjaxDone setPopedom(HttpServletRequest request, HttpServletResponse response){
		String[] k = request.getParameterValues("like[]");
		String id = request.getParameter("id");
		
		try{
			List<SysRoleUser> param = new ArrayList<SysRoleUser>();
			if(k != null){
				for (String str : k) {
					SysRoleUser ssr = new SysRoleUser();
					ssr.setRoleId(Integer.parseInt(str));
					ssr.setUserId(Integer.parseInt(id));
					ssr.setcreateTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
					ssr.setCreateUserId(getLoginObject(request).getUserId());
					ssr.setCreateUserName(getLoginObject(request).getUserName());
					param.add(ssr);
				}
			}
			service.saveRoleUser(param, Integer.parseInt(id));
			return new AjaxDone("200", "设置角色成功!");
		} catch(Exception e){
			e.printStackTrace();
			return new AjaxDone("300", "系统繁忙,请稍后再试!");
		}
	}
	
	/** 
	 * 跳转到修改密码页�?
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("toXtgl04005.do")
	public String toXtgl04005(){
		
		return "sysmgr/xtgl040/xtgl04005";
	}
	
	/**
	 * 修改密码
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("updUserPass.do") @ResponseBody
	public AjaxDone updUserPass(HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("id");
		String pass = request.getParameter("login_pwd1");
		
		try{
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("user_id", Integer.parseInt(id));
			param.put("login_pwd", StringUtil.str2MD5(pass));
			
			service.updUserPass(param);
			return new AjaxDone("200", "密码修改成功");
		} catch(Exception e){
			e.printStackTrace();
			return new AjaxDone("300", "系统繁忙,请稍后再�?!");
		}
	}
	
	/**
	 * 跳转到设置学员权限页�?
	 * @return
	 */
	@RequestMapping("toXtgl04006.do")
	public String toXtgl04006(HttpServletRequest request, HttpServletResponse response, ModelMap model){
		String user_id = request.getParameter("user_id");
		try {
			
			List<Map<String,Object>> list = service.findStuPopedomList(user_id);
			
			model.put("user_id", user_id);
			model.put("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "sysmgr/xtgl040/xtgl04006";
	}
	
	/**
	 * 设置学员权限
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("setStuPopedom.do") 
	@ResponseBody
	public AjaxDone setStuPopedom(HttpServletRequest request, HttpServletResponse response){
		String user_id = request.getParameter("user_id");//学员用户id
		String [] popedom_ids = request.getParameterValues("like");
		try{
			List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
			if(popedom_ids != null){
				for (String popedom_id : popedom_ids) {
					Map<String,Object> map = new HashMap<String,Object>();
					map.put("stu_user_id", user_id);
					map.put("popedom_id", popedom_id);
					map.put("create_time", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
					map.put("create_user_id", getLoginObject(request).getUserId());
					map.put("create_user_name", getLoginObject(request).getUserName());
					list.add(map);
				}
			}
			service.saveStuPopedom(list, Integer.parseInt(user_id));
			return new AjaxDone("200", "保存成功");
		} catch(Exception e){
			e.printStackTrace();
			return new AjaxDone("300", "系统繁忙,请稍后再�?!");
		}
	}
}
