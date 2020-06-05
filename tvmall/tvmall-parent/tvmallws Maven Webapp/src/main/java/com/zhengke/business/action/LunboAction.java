package com.zhengke.business.action;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSONArray;
import com.zhengke.business.service.LunboService;
import com.zhengke.business.service.detail.GoodsDetailService;
import com.zhengke.common.action.CommonAction;
import com.zhengke.common.pojo.SysDictionaryItem;
import com.zhengke.common.service.CommonService;
import com.zhengke.common.util.object.AjaxDone;
import com.zhengke.common.util.object.CurrentUser;
import com.zhengke.common.util.tools.LoadProperties;

@Controller("LunboAction") @Scope("prototype")
public class LunboAction extends CommonAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource GoodsDetailService goodDetailService;
	@Resource LunboService service;
	@Resource CommonService commonService;
	private AjaxDone json;
	
	/**
	 * 到轮播页面
	 *
	 * @return
	 * @author 陈晨
	 * @datetime 2017-2-13 上午9:30:26
	 * @editnote 
	 *
	 */
	public String toLunbo(){
		CurrentUser user = getCurrentUser();
		String pointId = user.getStationId();//服务点ID
		HttpServletResponse response = ServletActionContext.getResponse();
		try{
			List<Object[]> list = service.query(pointId);
			List<Map<String,Object>> rtnList = new ArrayList<Map<String,Object>>();
			for(Object[] obj : list){
				Map<String,Object> temp = detail( obj[0]==null?"":obj[0].toString(),obj[4].toString());
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
		 
		return "toLunbo";
	}
	
	public Map<String,Object> detail(String goodsId,String type){
		CurrentUser cu = getCurrentUser();
		Map<String,Object> temp = new HashMap<String,Object>();
		String i = commonService.queryParamValueByItemId("00010001");
		String[] str = i.split(":");
		double a = Double.parseDouble(str[0]);
		double b = Double.parseDouble(str[1]);
		try{
			List<Object[]> list = new ArrayList<Object[]>();
			double commonPrice = 0.0d;
			if("1".equals(type)||"2".equals(type)||"3".equals(type)||"7".equals(type)){
				list = goodDetailService.findGoodsDetail(goodsId);
			}else{
				list = goodDetailService.findGoodsDetail2(goodsId);
				if("5".equals(type)){
					if(list.size()>0){
						List<Object[]> list3 = goodDetailService.findBaleGoods(list.get(0)[0].toString());
						for(Object [] obj:list3){
							commonPrice+=(Double.parseDouble(obj[3].toString())*Integer.parseInt(obj[4].toString()));
						}
					}
				}
			}
			
			for(Object[] obj:list){
				String infoPicPath = obj[12].toString();
				String notInfoPic =  LoadProperties.findValue("loseInfoPicForGoodsDetail");
				if(infoPicPath==null||"".equals(infoPicPath))
					infoPicPath = ServletActionContext.getServletContext().getRealPath(notInfoPic);
				else{
					File f = new File(infoPicPath);
					if(!f.exists())
						infoPicPath = ServletActionContext.getServletContext().getRealPath(notInfoPic);
				}
				
				List<String> rtnList = new ArrayList<String>();
				
				if(obj[7]!=null&&!"".equals(obj[7]))
					rtnList.add(obj[7].toString());
				if(obj[8]!=null&&!"".equals(obj[8]))
					rtnList.add(obj[8].toString());
				if(obj[9]!=null&&!"".equals(obj[9]))
					rtnList.add(obj[9].toString());
				if(obj[10]!=null&&!"".equals(obj[10]))
					rtnList.add(obj[10].toString());
				if(obj[11]!=null&&!"".equals(obj[11]))
					rtnList.add(obj[11].toString());
				
				if(rtnList.size()==0){
					String notFoundPic =  LoadProperties.findValue("losePicForGoods");
					rtnList.add(ServletActionContext.getServletContext().getRealPath(notFoundPic));
				}
				if("1".equals(type)){
					temp.put("commonPrice", "￥"+obj[2]);//原价
				}
				if("5".equals(type)){
					temp.put("commonPrice", "￥"+commonPrice);//原价
				}
				if("3".equals(type)||"7".equals(type)){
					String goodsPrice  = obj[3]==null?"":obj[3].toString();
					double d = Double.parseDouble(goodsPrice)*(a/b);
					temp.put("commonPrice", d);//所需兑换积分
				}
				String shippingFee  = obj[4]==null?"":obj[4].toString();
				double s = Double.parseDouble(shippingFee)*(a/b);
				temp.put("shippingFee", s);//运费
				
				temp.put("goodsId", goodsId);
				temp.put("picList", rtnList);
				temp.put("goodsName", obj[1]);
				temp.put("goodsPrice", "￥"+obj[3]);//打折价
				temp.put("deliveryWay", cu.getDeliveryWay());//收货方式
				temp.put("supplierName", obj[6]);//供应商名称
				temp.put("supplierId", obj[5]);//供应商id
				temp.put("infoPicPath", infoPicPath);//介绍图片
				temp.put("awardedIntegral", obj[13]);//赠送积分
				temp.put("specifications", obj[14]);//商品规格
			}
			
			
			//图片查询滚动时间
			List<SysDictionaryItem> timeList = commonService.queryDicItemByDicId("0008");
			if(timeList.size()>0){
				temp.put("time", timeList.get(0).getParamValue());//轮播图片滚动时间
			}
			if("0".equals(type)||"2".equals(type)){
				temp.put("show", "0");//显示类型
			}else{
				temp.put("show", "1");//显示类型
			}
			temp.put("type", type);//商品类型
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return temp;
	}
	
	
	
	
	public AjaxDone getJson() {
		return this.json;
	}
	public void setJson(AjaxDone json) {
		this.json = json;
	}
	
}
