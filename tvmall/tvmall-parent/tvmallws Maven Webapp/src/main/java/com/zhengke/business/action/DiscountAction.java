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
import com.zhengke.business.service.DiscountService;
import com.zhengke.common.action.CommonAction;
import com.zhengke.common.pojo.TvUserOpera;
import com.zhengke.common.service.CommonService;
import com.zhengke.common.util.object.AjaxDone;
import com.zhengke.common.util.object.CurrentUser;
import com.zhengke.common.util.tools.CommonUtil;
import com.zhengke.common.util.tools.DateUtil;
import com.zhengke.common.util.tools.LoadProperties;

@Controller("DiscountAction") @Scope("prototype")
public class DiscountAction extends CommonAction {
	private static final long serialVersionUID = 3896110624661690733L;
	@Resource DiscountService service;
	@Resource CommonService commonService;
	private AjaxDone json;

	/**
	 * 到打折商品页面
	 * @return
	 */
	public String toDiscountList(){
		CurrentUser user = getCurrentUser();
		TvUserOpera tvUserOpera = new TvUserOpera();
		tvUserOpera.setId(CommonUtil.createUUID());
		tvUserOpera.setUserId(Integer.parseInt(user.getTvnNo()));
		tvUserOpera.setUserName(user.getUserName());
		tvUserOpera.setType(1);
		tvUserOpera.setTime(DateUtil.currentTime());
		tvUserOpera.setText("打折商品");
		commonService.sava(tvUserOpera);
		ActionContext.getContext().put("tmp", new Date());
		return "toDiscountList";
	}
	
	/**
	 * 打折商品列表
	 * @return
	 */
	public void discountData(){
		HttpServletResponse response = ServletActionContext.getResponse();
		try{
			CurrentUser  cu = getCurrentUser();	
			List<Object[]> list = service.queryDiscountList(cu.getStationId());//打折商品
			List<Map<String,String>> rtnList = new ArrayList<Map<String,String>>();
			String notFoundPic =  LoadProperties.findValue("losePicForList");
			for(Object[] mg : list){
				Map<String,String> temp = new HashMap<String,String>();
				String picPath = mg[2].toString();
				if(picPath==null||"".equals(picPath))
					picPath = ServletActionContext.getServletContext().getRealPath(notFoundPic);
				else{
					File f = new File(picPath);
					if(!f.exists())
						picPath = ServletActionContext.getServletContext().getRealPath(notFoundPic);
				}
				temp.put("goodsId", mg[0].toString());
				temp.put("picPath", picPath);
				temp.put("goodsName", mg[1].toString());
				temp.put("goodsPromotionPrice", "￥"+mg[3].toString());
				temp.put("type", mg[4].toString());
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
