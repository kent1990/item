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
import com.zhengke.business.service.SalesService;
import com.zhengke.common.action.CommonAction;
import com.zhengke.common.pojo.MallGoods;
import com.zhengke.common.pojo.SysDictionaryItem;
import com.zhengke.common.pojo.TvUserOpera;
import com.zhengke.common.service.CommonService;
import com.zhengke.common.util.object.AjaxDone;
import com.zhengke.common.util.object.CurrentUser;
import com.zhengke.common.util.tools.CommonUtil;
import com.zhengke.common.util.tools.DateUtil;
import com.zhengke.common.util.tools.LoadProperties;

@Controller("SalesAction") @Scope("prototype")
public class SalesAction extends CommonAction {
	private static final long serialVersionUID = 3896110624661690733L;
	@Resource SalesService service;
	@Resource CommonService commonService;
	private AjaxDone json;

	/**
	 * 到销售排行列表页面
	 * @return
	 */
	public String toSalesList(){
		CurrentUser user = getCurrentUser();
		TvUserOpera tvUserOpera = new TvUserOpera();
		tvUserOpera.setId(CommonUtil.createUUID());
		tvUserOpera.setUserId(Integer.parseInt(user.getTvnNo()));
		tvUserOpera.setUserName(user.getUserName());
		tvUserOpera.setType(1);
		tvUserOpera.setTime(DateUtil.currentTime());
		tvUserOpera.setText("销售排行");
		commonService.sava(tvUserOpera);
		ActionContext.getContext().put("tmp", new Date());
		return "toSalesList";
	}
	
	/**
	 * 销售排行商品列表
	 */
	public void salesData(){
		CurrentUser user = getCurrentUser();
		String pointId = user.getStationId();//服务点ID
		HttpServletResponse response = ServletActionContext.getResponse();
		try{
			
			List<SysDictionaryItem> dicItem = service.findDicItem();
			List<Object[]> list = new ArrayList<Object[]>();
			if(dicItem.size()>0){
				if(dicItem.get(0).getParamValue().equals("按月销量")){
					list = service.querySalesList(pointId,"1");
				}
				else if(dicItem.get(0).getParamValue().equals("按周销量")){
					list = service.querySalesList(pointId,"2");
				}
				else if(dicItem.get(0).getParamValue().equals("手工设置")){
					List<Object[]> list2 = service.querySalesList2(pointId);
					List<Object[]> list3 = service.querySalesList3();
					if(list3.size()==0){
						list = list2;
					}else{
						List<Object[]> list4 = new ArrayList<Object[]>();
						for(int i=0;i<list3.size();i++){
							for(int j=0;j<list2.size();j++){
								if(list3.get(i)[1].toString().equals(list2.get(j)[0].toString())){
									list4.add(list2.get(j));
									list2.remove(j);
								}
							}
						}
						for(int i=0;i<list2.size();i++){
							list4.add(list2.get(i));
						}
						list = list4;
					}
				}
				else
					list = service.querySalesList(pointId,"0");
			}else{
				list = service.querySalesList(pointId,"0");
			}
			
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
	
	/**
	 * 到商品详情页面
	 * @return
	 */
	public String toDetail(){
		String goodsId = ServletActionContext.getRequest().getParameter("goodsId");
		try{
			MallGoods mg = (MallGoods)commonService.getByID(MallGoods.class, Integer.parseInt(goodsId));
			ActionContext.getContext().put("mallGoods", mg);
			
		}catch(Exception e){
			e.printStackTrace();
		}	
		
		return "goodsDetail";
	}
	
	
	
	public AjaxDone getJson() {
		return json;
	}

	public void setJson(AjaxDone json) {
		this.json = json;
	}
}
