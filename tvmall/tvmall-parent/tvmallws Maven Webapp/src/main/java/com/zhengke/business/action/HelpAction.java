package com.zhengke.business.action;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionContext;
import com.zhengke.business.service.HelpService;
import com.zhengke.common.action.CommonAction;
import com.zhengke.common.pojo.HelpCenter;
import com.zhengke.common.pojo.HelpDetail;
import com.zhengke.common.service.CommonService;
import com.zhengke.common.util.object.AjaxDone;
import com.zhengke.common.util.tools.LoadProperties;

@Controller("HelpAction") @Scope("prototype")
public class HelpAction extends CommonAction {
	private static final long serialVersionUID = 3896110624661690733L;
	@Resource HelpService service;
	@Resource CommonService commonService;
	private AjaxDone json;

	/**
	 * 到帮助列表页面
	 * @return
	 */
	public String toHelpList(){
		ActionContext.getContext().put("tmp", new Date());
		return "toHelpList";
	}
	
	/**
	 * 帮助列表
	 * @return
	 */
	public void helpData(){
		HttpServletResponse response = ServletActionContext.getResponse();
		try{
			List<HelpCenter> list = service.queryBrandList();
			List<Map<String,String>> rtnList = new ArrayList<Map<String,String>>();
			String notFoundPic =  LoadProperties.findValue("losePicForHelpList");
			for(HelpCenter hc : list){
				Map<String,String> temp = new HashMap<String,String>();
				String picPath = hc.getHelpThPath();
				if(picPath==null||"".equals(picPath))
					picPath = ServletActionContext.getServletContext().getRealPath(notFoundPic);
				else{
					File f = new File(picPath);
					if(!f.exists())
						picPath = ServletActionContext.getServletContext().getRealPath(notFoundPic);
				}
				temp.put("picPath", picPath);
				temp.put("helpName", hc.getHelpName());
				temp.put("helpId", hc.getHelpId().toString());
				rtnList.add(temp);
			}
			
			response.setCharacterEncoding("utf-8");
			response.setHeader("Pragma","No-cache"); 
			response.setHeader("Cache-Control","no-cache"); 
			response.setDateHeader("Expires", 0);  
			response.getWriter().print("var dataList="+JSONArray.toJSON(rtnList));	
		}catch(Exception e){
			e.printStackTrace();
		}	
	}
	
	/**
	 * 到帮助详情页面
	 * @return
	 */
	public String toHelpDetail(){
		
		String helpId = ServletActionContext.getRequest().getParameter("helpId");
		ActionContext.getContext().put("tmp", new Date());
		ActionContext.getContext().put("helpId", helpId);
		return "toHelpDetail";
	}
	/**
	 * 帮助详情
	 * @return
	 */
	public void helpDetail(){
		String helpId = ServletActionContext.getRequest().getParameter("helpId");
		HttpServletResponse response = ServletActionContext.getResponse();
		try{
			String notFoundPic =  LoadProperties.findValue("losePicForHelpDetail");
			List<HelpDetail> list = service.findHelpDetail(helpId);
			List<String> list2 = new ArrayList<String>();
			for(HelpDetail hd:list){
				String picPath = hd.getHelpPicPath();
				if(picPath==null||"".equals(picPath)){
					picPath = ServletActionContext.getServletContext().getRealPath(notFoundPic);
				}else{
					File f = new File(picPath);
					if(!f.exists())
						picPath = ServletActionContext.getServletContext().getRealPath(notFoundPic);
				}
				list2.add(picPath);
			}
			
			Map<String,Object> temp = new HashMap<String,Object>();
			temp.put("images", list2);
			temp.put("total", list2.size());			
			
			response.setCharacterEncoding("utf-8");
			response.setHeader("Pragma","No-cache"); 
			response.setHeader("Cache-Control","no-cache"); 
			response.setDateHeader("Expires", 0);  
			response.getWriter().print("var dataList="+JSONObject.toJSON(temp));	
		}catch(Exception e){
			e.printStackTrace();
		}	
	}
	
	
	public AjaxDone getJson() {
		return json;
	}

	public void setJson(AjaxDone json) {
		this.json = json;
	}
}
