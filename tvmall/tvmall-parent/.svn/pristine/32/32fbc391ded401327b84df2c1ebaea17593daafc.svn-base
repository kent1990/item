package com.zhengke.controller.sysmgr;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhengke.common.object.AjaxDone;
import com.zhengke.common.object.Result;
import com.zhengke.controller.common.BaseController;
import com.zhengke.pojo.SysPopedom;
import com.zhengke.service.sysmgr.XTGL020Service;



@Controller @RequestMapping("xtgl020/")
public class XTGL020Controller extends BaseController {
	  @Reference
		 private XTGL020Service service;
	
	@RequestMapping("toXtgl02001.do")
	public String toXtgl02001(){
		System.out.println();
		return "sysmgr/xtgl020/xtgl02001";
	}
	
	/**
	 * 取权限项列表
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("query.do") 
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
	 * 跳转到修改页�?
	 * @param model 下拉菜单数据
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("toXtgl02002.do")
	public String toXtgl02002(ModelMap model) throws Exception  {
		List<Map<String, Object>> list = service.queryMenuPopedom();
		model.put("data", list);
		return "sysmgr/xtgl020/xtgl02002";
	}
	
	/**
	 * 添加信息
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("addPopedom.do") @ResponseBody
	public AjaxDone addPopedom(HttpServletRequest request, HttpServletResponse response){
		String menuId = request.getParameter("menu_id");
		String itemName = request.getParameter("item_name");
		String itemCode = request.getParameter("item_code");
		
		try{
			SysPopedom sp = new SysPopedom();
			sp.setMenuId(menuId);
			sp.setItemName(itemName);
			sp.setItemCode(itemCode);
			sp.setItemType("0");
			sp.setCreateTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
			sp.setCreateUser(getLoginObject(request).getLoginName());
			
			Integer i = service.savePopedom(sp);
			if(i <= 0){
				return new AjaxDone("300","请求失败");
			} 
			return new AjaxDone("200","请求成功");
		} catch(Exception e){
			e.printStackTrace();
			return new AjaxDone("300","请求失败");
		}
	}
	
	/**
	 * 跳转到修改页�?
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("toXtgl02003.do")
	public String toXtgl02003(String menuId,ModelMap model) throws Exception{
		List<Map<String, Object>> list = service.queryMenuPopedom();
		model.put("data", list);
		model.put("tempMenuId", menuId);
		return "sysmgr/xtgl020/xtgl02003";
		
	}
	
	/**
	 * 修改权限�?
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("updPopedom.do") @ResponseBody
	public AjaxDone updPopedom(HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("pope_id");
		// String menuId = request.getParameter("menu_id");
		String itemName = request.getParameter("item_name");
		String itemCode = request.getParameter("item_code");
		
		try{
			SysPopedom sp = new SysPopedom();
			sp.setId(Integer.parseInt(id));
			sp.setItemName(itemName);
			sp.setItemCode(itemCode);
			sp.setUpdateDate(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
			sp.setUpdateUser(getLoginObject(request).getUserName());
			
			Integer i = service.updPopedom(sp);
			if(i <= 0){
				return new AjaxDone("300","请求失败");
			} 
			return new AjaxDone("200","请求成功");
		} catch(Exception e){
			e.printStackTrace();
			return new AjaxDone("300","请求失败");
		}
	}
	
	/**
	 * 删除权限�?
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("delPopedom.do") @ResponseBody
	public AjaxDone delPopedom(HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("id");
		
		try{
			Integer i = service.delPopedom(Integer.parseInt(id));
			if(i <= 0){
				return new AjaxDone("300","请求失败");
			} 
			return new AjaxDone("200","请求成功");
		} catch(Exception e){
			e.printStackTrace();
			return new AjaxDone("300","请求失败");
		}
	}
}
