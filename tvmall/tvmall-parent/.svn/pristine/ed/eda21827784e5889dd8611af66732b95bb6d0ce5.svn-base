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
import com.opensymphony.xwork2.ActionContext;
import com.zhengke.business.service.TypeService;
import com.zhengke.common.action.CommonAction;
import com.zhengke.common.pojo.MallGoodsClass;
import com.zhengke.common.pojo.TvUserOpera;
import com.zhengke.common.service.CommonService;
import com.zhengke.common.util.object.AjaxDone;
import com.zhengke.common.util.object.CurrentUser;
import com.zhengke.common.util.tools.CommonUtil;
import com.zhengke.common.util.tools.DateUtil;
import com.zhengke.common.util.tools.LoadProperties;


@Controller("TypeAction") @Scope("prototype")
public class TypeAction extends CommonAction {
	private static final long serialVersionUID = 3896110624661690733L;
	@Resource TypeService service;
	@Resource CommonService commonService;
	private AjaxDone json;

	/**
	 * 到分类列表页面
	 * @return
	 */
	public String toTypeList(){
		CurrentUser user = getCurrentUser();
		TvUserOpera tvUserOpera = new TvUserOpera();
		tvUserOpera.setId(CommonUtil.createUUID());
		tvUserOpera.setUserId(Integer.parseInt(user.getTvnNo()));
		tvUserOpera.setUserName(user.getUserName());
		tvUserOpera.setType(1);
		tvUserOpera.setTime(DateUtil.currentTime());
		tvUserOpera.setText("分类商品");
		commonService.sava(tvUserOpera);
		ActionContext.getContext().put("tmp", new Date());
		return "toTypeList";
	}
	
	/**
	 * 分类列表
	 * @return
	 */
	public void typeData(){
		HttpServletResponse response = ServletActionContext.getResponse();
		try{
			List<MallGoodsClass> list = service.queryTypeList();
			List<Map<String,String>> rtnList = new ArrayList<Map<String,String>>();
			String notFoundPic =  LoadProperties.findValue("losePicForList");
			for(MallGoodsClass mg : list){
				Map<String,String> temp = new HashMap<String,String>();
				String picPath = mg.getGcPicPath();
				if(picPath==null||"".equals(picPath))
					picPath = ServletActionContext.getServletContext().getRealPath(notFoundPic);
				else{
					File f = new File(picPath);
					if(!f.exists())
						picPath = ServletActionContext.getServletContext().getRealPath(notFoundPic);
				}
				temp.put("picPath", picPath);
				temp.put("typeName", mg.getGcName());
				temp.put("typeId", mg.getGcId().toString());
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
	 * 到分类商品列表页面
	 * @return
	 */
	public String toTypeGoodList(){
		String typeId = ServletActionContext.getRequest().getParameter("typeId");
		CurrentUser user = getCurrentUser();
		MallGoodsClass mallGoodsClass = (MallGoodsClass) commonService.getByID(MallGoodsClass.class, Integer.parseInt(typeId));
		if(mallGoodsClass!=null){
			TvUserOpera tvUserOpera = new TvUserOpera();
			tvUserOpera.setId(CommonUtil.createUUID());
			tvUserOpera.setUserId(Integer.parseInt(user.getTvnNo()));
			tvUserOpera.setUserName(user.getUserName());
			tvUserOpera.setType(3);
			tvUserOpera.setTime(DateUtil.currentTime());
			tvUserOpera.setText(mallGoodsClass.getGcName());
			
			commonService.sava(tvUserOpera);
		}
		
		ActionContext.getContext().put("tmp", new Date());
		ActionContext.getContext().put("typeId", typeId);
		return "toTypeGoodList";
	}
	
	/**
	 * 分类商品列表
	 */
	public void typeGoodData(){
		CurrentUser user = getCurrentUser();
		String pointId = user.getStationId();//服务点ID
		String typeId = ServletActionContext.getRequest().getParameter("typeId");
		HttpServletResponse response = ServletActionContext.getResponse();
		try{
			List<Object[]> list = service.queryTypeGoodList(typeId,pointId);
			
			List<Map<String,String>> rtnList = new ArrayList<Map<String,String>>();
			String notFoundPic =  LoadProperties.findValue("losePicForList");
			for(Object[] obj : list){
				Map<String,String> temp = new HashMap<String,String>();
				String picPath = obj[3]==null?"":obj[3].toString();
				if(picPath==null||"".equals(picPath))
					picPath = ServletActionContext.getServletContext().getRealPath(notFoundPic);
				else{
					File f = new File(picPath);
					if(!f.exists())
						picPath = ServletActionContext.getServletContext().getRealPath(notFoundPic);
				}
				temp.put("commonGoodsId", obj[0]==null?"":obj[0].toString());
				temp.put("picPath", picPath);
				temp.put("goodsName", obj[1]==null?"":obj[1].toString());
				temp.put("goodsPromotionPrice", obj[2]==null?"":"￥"+obj[2].toString());
				temp.put("type", obj[4].toString());
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
	
	public AjaxDone getJson() {
		return json;
	}

	public void setJson(AjaxDone json) {
		this.json = json;
	}
}
