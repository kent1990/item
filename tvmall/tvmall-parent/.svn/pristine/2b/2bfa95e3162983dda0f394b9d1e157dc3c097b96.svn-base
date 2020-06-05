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
import com.zhengke.business.service.BrandService;
import com.zhengke.common.action.CommonAction;
import com.zhengke.common.pojo.MallSupplier;
import com.zhengke.common.pojo.TvUserOpera;
import com.zhengke.common.service.CommonService;
import com.zhengke.common.util.object.AjaxDone;
import com.zhengke.common.util.object.CurrentUser;
import com.zhengke.common.util.tools.CommonUtil;
import com.zhengke.common.util.tools.DateUtil;
import com.zhengke.common.util.tools.LoadProperties;


@Controller("BrandAction") @Scope("prototype")
public class BrandAction extends CommonAction {
	private static final long serialVersionUID = 3896110624661690733L;
	@Resource BrandService service;
	@Resource CommonService commonService;
	private AjaxDone json;

	/**
	 * 到品牌列表页面
	 * @return
	 */
	public String toBrandList(){
		CurrentUser user = getCurrentUser();
		TvUserOpera tvUserOpera = new TvUserOpera();
		tvUserOpera.setId(CommonUtil.createUUID());
		tvUserOpera.setUserId(Integer.parseInt(user.getTvnNo()));
		tvUserOpera.setUserName(user.getUserName());
		tvUserOpera.setType(1);
		tvUserOpera.setTime(DateUtil.currentTime());
		tvUserOpera.setText("品牌入口");
		commonService.sava(tvUserOpera);
		
		ActionContext.getContext().put("tmp", new Date());
		return "toBrandList";
	}
	
	/**
	 * 品牌列表
	 * @return
	 */
	public void brandData(){
		HttpServletResponse response = ServletActionContext.getResponse();
		try{
			List<Object[]> list = service.queryBrandList();
			List<Map<String,String>> rtnList = new ArrayList<Map<String,String>>();
			String notFoundPic =  LoadProperties.findValue("losePicForList");
			for(Object[] ms : list){
				Map<String,String> temp = new HashMap<String,String>();
				String picPath = ms[2].toString();
				if(picPath==null||"".equals(picPath))
					picPath = ServletActionContext.getServletContext().getRealPath(notFoundPic);
				else{
					File f = new File(picPath);
					if(!f.exists())
						picPath = ServletActionContext.getServletContext().getRealPath(notFoundPic);
				}
				temp.put("picPath", picPath);
				temp.put("brandName", ms[1].toString());
				temp.put("brandId", ms[0].toString());
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
	 * 到品牌商品列表页面
	 * @return
	 */
	public String toBrandGoodList(){
		CurrentUser user = getCurrentUser();
		String brandId = ServletActionContext.getRequest().getParameter("brandId");
		
		MallSupplier mallSupplier = (MallSupplier) commonService.getByID(MallSupplier.class, Integer.parseInt(brandId));
		if(mallSupplier!=null){
			TvUserOpera tvUserOpera = new TvUserOpera();
			tvUserOpera.setId(CommonUtil.createUUID());
			tvUserOpera.setUserId(Integer.parseInt(user.getTvnNo()));
			tvUserOpera.setUserName(user.getUserName());
			tvUserOpera.setType(2);
			tvUserOpera.setTime(DateUtil.currentTime());
			tvUserOpera.setText(mallSupplier.getSupplierName());
			
			commonService.sava(tvUserOpera);
		}
		
		ActionContext.getContext().put("tmp", new Date());
		ActionContext.getContext().put("brandId", brandId);
		return "toBrandGoodList";
	}
	
	/**
	 * 品牌商品列表
	 */
	public void brandGoodData(){
		CurrentUser user = getCurrentUser();
		String pointId = user.getStationId();//服务点ID
		String brandId = ServletActionContext.getRequest().getParameter("brandId");
		HttpServletResponse response = ServletActionContext.getResponse();
		try{
			List<Object[]> list = service.queryBrandGoodList(brandId,pointId);
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
