package com.zhengke.business.action.home;

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
import com.opensymphony.xwork2.ActionContext;
import com.zhengke.business.service.home.HomeService;
import com.zhengke.common.action.CommonAction;
import com.zhengke.common.pojo.IndexPic;
import com.zhengke.common.pojo.ReturnVisit;
import com.zhengke.common.pojo.SysDictionaryItem;
import com.zhengke.common.pojo.TvOrder;
import com.zhengke.common.pojo.TvUser;
import com.zhengke.common.service.CommonService;
import com.zhengke.common.util.object.AjaxDone;
import com.zhengke.common.util.object.CurrentUser;
import com.zhengke.common.util.tools.CommonUtil;
import com.zhengke.common.util.tools.DateUtil;
import com.zhengke.common.util.tools.LoadProperties;

@Controller("MasukAction") @Scope("prototype")
public class MasukAction extends CommonAction {

	private static final long serialVersionUID = 1L;
	@Resource CommonService commonService;
	@Resource HomeService service;
	private AjaxDone json;
	
	/**
	 * Android机顶盒入口
	 * @return
	 */
	public String masuk(){
		String tvnNo = ServletActionContext.getRequest().getParameter("tvnNo");
		try{
			if(tvnNo==null){
				return "info";
			}
			TvUser user = (TvUser) commonService.getByID(TvUser.class, tvnNo);			
			CurrentUser cu = new CurrentUser();
			if(user!=null){
				if(user.getStatu()==(short)0){
					return "info";
				}
				cu.setTvnNo(user.getUserId());
				cu.setStationId(user.getServicePointId().toString());//服务点id
				cu.setCityId(user.getCityId().toString());
				cu.setUserName(user.getUserName());
				cu.setPhone(user.getUserPhone());
				cu.setProvinceId(user.getProvinceId().toString());
				cu.setCountyId("");//目前没有县级
				cu.setStationName(commonService.queryServiceStationName(user.getServicePointId()));
				cu.setAddressDetail(user.getAddressDetail());
				cu.setDeliveryWay(user.getDeliveryWay());
				cu.setReceiptTime(user.getReceiptTime());
				cu.setUserBalance(user.getUserBalance());
				cu.setUserIntegral(user.getUserBalance());
				cu.setUserCardNo(user.getUserCardNumber());
				ActionContext.getContext().getSession().put(SESSION_USER_KEY, cu);
				ActionContext.getContext().put("rem", CommonUtil.createUUID());
			}else{
				return "info";
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		ActionContext.getContext().put("tvnNo", tvnNo);
		return "masuk";
	}
	
	/**
	 * 机顶盒进入页面数据处理
	 */
	public void queryMasuk() {
		HttpServletResponse response = ServletActionContext.getResponse();
		try{
			CurrentUser user = getCurrentUser();
			List<IndexPic> listIp = service.queryIndexPics(user.getProvinceId(),user.getCityId(),user.getStationId(),"1");
			List<List<Map<String,String>>> rtnList = new ArrayList<List<Map<String,String>>>();
			for(IndexPic ip : listIp) {
				List<Map<String,String>> innerList = new ArrayList<Map<String,String>>();
				Map<String,String> innerMap = new HashMap<String,String>();
				if(ip.getPicPath()!=null){
					File f = new File(ip.getPicPath());
					if(!f.exists()){
						innerMap.put("pic_src", ip.getDefaultPic());
						innerMap.put("flag", "0");
					}else{
						innerMap.put("pic_src", ip.getPicPath());
						innerMap.put("flag", "1");
					}
				}else{
					innerMap.put("flag", "0");
					innerMap.put("pic_src", ip.getDefaultPic());
				}
				String adTvMallUrl =  LoadProperties.findValue("adTvMall.url");
				innerMap.put("url", adTvMallUrl);//"toDiscountList.do"
				innerList.add(innerMap);
				rtnList.add(innerList);
			}
			List<Map<String,String>> otherList = new ArrayList<Map<String,String>>();
			
			//电视商城入口
			String tvMallPic=LoadProperties.findValue("tvMall.pic_src");
			String tvMallFlag = LoadProperties.findValue("tvMall.flag");
			String tvMallUrl = LoadProperties.findValue("tvMall.url");
			Map<String,String> secondMap = new HashMap<String,String>();
			secondMap.put("pic_src", tvMallPic);
			secondMap.put("flag", tvMallFlag);
			secondMap.put("url", tvMallUrl);
			otherList.add(secondMap);
			//亲情相册入口		
			String qqxcPic=LoadProperties.findValue("qqxc.pic_src");
			String qqxcFlag = LoadProperties.findValue("qqxc.flag");
			String qqxcUrl = LoadProperties.findValue("qqxc.url");
			Map<String,String> thirdMap = new HashMap<String,String>();
			thirdMap.put("pic_src", qqxcPic);
			thirdMap.put("flag", qqxcFlag);
			thirdMap.put("url", qqxcUrl);
			otherList.add(thirdMap);
			//将第二个数组添加到返回数据Json
			rtnList.add(otherList);
			//广告入口
			List<Map<String,String>> thirdList = new ArrayList<Map<String,String>>();
			String advPic=LoadProperties.findValue("adv.pic_src");
			String advFlag = LoadProperties.findValue("adv.flag");
			String advUrl = LoadProperties.findValue("adv.url");
			Map<String,String> forthMap = new HashMap<String,String>();
			forthMap.put("pic_src", advPic);
			forthMap.put("flag", advFlag);
			forthMap.put("url", advUrl);
			thirdList.add(forthMap);
			//将第二个数组添加到返回数据Json
			rtnList.add(thirdList);
			
			//将封装结果写回浏览器
			response.setCharacterEncoding("utf-8");
			response.setHeader("Pragma","No-cache"); 
			response.setHeader("Cache-Control","no-cache"); 
			response.setDateHeader("Expires", 0);  
			response.getWriter().print("var dataList="+JSONArray.toJSON(rtnList));	
		}catch(Exception e) {
			e.printStackTrace();
		}
	}	
	
	/**
	 * 商城程序入口
	 * @return
	 */
	public String home(){
		String tvnNo = ServletActionContext.getRequest().getParameter("tvnNo");		
		try{
			CurrentUser cu = getCurrentUser();// new CurrentUser();
			if(cu!=null){
				ActionContext.getContext().put("rem", CommonUtil.createUUID());
			}else {
				if(tvnNo==null){
					return "info";
				}			
				TvUser user = (TvUser) commonService.getByID(TvUser.class, tvnNo);			
				if(user!=null){
					if(user.getStatu()==(short)0){
						return "info";
					}
					cu = new CurrentUser();
					cu.setTvnNo(user.getUserId());
					cu.setStationId(user.getServicePointId().toString());//服务点id
					cu.setCityId(user.getCityId().toString());
					cu.setUserName(user.getUserName());
					cu.setPhone(user.getUserPhone());
					cu.setProvinceId(user.getProvinceId().toString());
					cu.setCountyId("");//目前没有县级
					cu.setStationName(commonService.queryServiceStationName(user.getServicePointId()));
					cu.setAddressDetail(user.getAddressDetail());
					cu.setDeliveryWay(user.getDeliveryWay());
					cu.setReceiptTime(user.getReceiptTime());
					cu.setUserBalance(user.getUserBalance());
					cu.setUserIntegral(user.getUserBalance());
					cu.setUserCardNo(user.getUserCardNumber());
					ActionContext.getContext().getSession().put(SESSION_USER_KEY, cu);
					ActionContext.getContext().put("rem", CommonUtil.createUUID());
				}else{
					return "info";
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}				
		return "home";
	}
	
	/**
	 * 查询首页图片
	 */
	public void queryPics(){
		HttpServletResponse response = ServletActionContext.getResponse();
		try{
			
			CurrentUser user = getCurrentUser();			
			List<IndexPic> listIp = service.queryIndexPics(user.getProvinceId(),user.getCityId(),user.getStationId(),null);
			List<List<Map<String,String>>> rtnList = new ArrayList<List<Map<String,String>>>();
			List<Map<String,String>> otherList = new ArrayList<Map<String,String>>();
			for(IndexPic ip : listIp){
				if(ip.getId()==1){
					List<Map<String,String>> innerList = new ArrayList<Map<String,String>>();
					Map<String,String> innerMap = new HashMap<String,String>();
					if(ip.getPicPath()!=null){
						File f = new File(ip.getPicPath());
						if(!f.exists()){
							innerMap.put("pic_src", ip.getDefaultPic());
							innerMap.put("flag", "0");
						}else{
							innerMap.put("pic_src", ip.getPicPath());
							innerMap.put("flag", "1");
						}
					}else{
						innerMap.put("flag", "0");
						innerMap.put("pic_src", ip.getDefaultPic());
					}
					innerMap.put("url", "toDiscountList.do");
					innerList.add(innerMap);
					rtnList.add(innerList);
				}else{
					if(ip.getId()==2){
						Map<String,String> innerMap = new HashMap<String,String>();
						if(ip.getPicPath()!=null){
							File f = new File(ip.getPicPath());
							if(!f.exists()){
								innerMap.put("pic_src", ip.getDefaultPic());
								innerMap.put("flag", "0");
							}else{
								innerMap.put("pic_src", ip.getPicPath());
								innerMap.put("flag", "1");
							}
						}else{
							innerMap.put("flag", "0");
							innerMap.put("pic_src", ip.getDefaultPic());
						}
						innerMap.put("url", "toSalesList.do");
						otherList.add(innerMap);
					}
					if(ip.getId()==3){
						Map<String,String> innerMap = new HashMap<String,String>();
						if(ip.getPicPath()!=null){
							File f = new File(ip.getPicPath());
							if(!f.exists()){
								innerMap.put("pic_src", ip.getDefaultPic());
								innerMap.put("flag", "0");
							}else{
								innerMap.put("pic_src", ip.getPicPath());
								innerMap.put("flag", "1");
							}
						}else{
							innerMap.put("flag", "0");
							innerMap.put("pic_src", ip.getDefaultPic());
						}
						innerMap.put("url", "toBrandList.do");
						otherList.add(innerMap);
					}
					if(ip.getId()==4){
						Map<String,String> innerMap = new HashMap<String,String>();
						if(ip.getPicPath()!=null){
							File f = new File(ip.getPicPath());
							if(!f.exists()){
								innerMap.put("pic_src", ip.getDefaultPic());
								innerMap.put("flag", "0");
							}else{
								innerMap.put("pic_src", ip.getPicPath());
								innerMap.put("flag", "1");
							}
						}else{
							innerMap.put("flag", "0");
							innerMap.put("pic_src", ip.getDefaultPic());
						}
						innerMap.put("url", "toTypeList.do");
						otherList.add(innerMap);
					}
					if(ip.getId()==5){
						Map<String,String> innerMap = new HashMap<String,String>();
						if(ip.getPicPath()!=null){
							File f = new File(ip.getPicPath());
							if(!f.exists()){
								innerMap.put("pic_src", ip.getDefaultPic());
								innerMap.put("flag", "0");
							}else{
								innerMap.put("pic_src", ip.getPicPath());
								innerMap.put("flag", "1");
							}
						}else{
							innerMap.put("flag", "0");
							innerMap.put("pic_src", ip.getDefaultPic());
						}
						innerMap.put("url", "toExperieList.do");
						otherList.add(innerMap);
					}
					if(ip.getId()==6){
						Map<String,String> innerMap = new HashMap<String,String>();
						if(ip.getPicPath()!=null){
							File f = new File(ip.getPicPath());
							if(!f.exists()){
								innerMap.put("pic_src", ip.getDefaultPic());
								innerMap.put("flag", "0");
							}else{
								innerMap.put("pic_src", ip.getPicPath());
								innerMap.put("flag", "1");
							}
						}else{
							innerMap.put("flag", "0");
							innerMap.put("pic_src", ip.getDefaultPic());
						}
						innerMap.put("url", "toIntegralList.do");
						otherList.add(innerMap);
					}
					if(ip.getId()==7){
						Map<String,String> innerMap = new HashMap<String,String>();
						if(ip.getPicPath()!=null){
							File f = new File(ip.getPicPath());
							if(!f.exists()){
								innerMap.put("pic_src", ip.getDefaultPic());
								innerMap.put("flag", "0");
							}else{
								innerMap.put("pic_src", ip.getPicPath());
								innerMap.put("flag", "1");
							}
						}else{
							innerMap.put("flag", "0");
							innerMap.put("pic_src", ip.getDefaultPic());
						}
						innerMap.put("url", "toAccountCenter.do");
						otherList.add(innerMap);
					}
				}
			}		
			rtnList.add(otherList);	
			
			List<Map<String,String>> thirdList = new ArrayList<Map<String,String>>();
			Map<String,String> thirdMap = new HashMap<String,String>();
			thirdMap.put("pic_src", "/images/index/pic8.png");
			thirdMap.put("flag", "0");
			thirdMap.put("url", "toHelpList.do");
			thirdList.add(thirdMap);
			rtnList.add(thirdList);	
			
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
	 * 查询新闻信息
	 */
	public void news(){
		CurrentUser user = getCurrentUser();
		String userId = user.getTvnNo();//用户ID
		HttpServletResponse response = ServletActionContext.getResponse();
		try{
			//查询有没有已配货和已发货的订单
			List<TvOrder> orderList = commonService.findOrderList(userId);
			//查询新闻
			List<SysDictionaryItem> itemList = commonService.queryDicItemByDicId("0007");
			//查询滚动时间
			List<SysDictionaryItem> timeList = commonService.queryDicItemByDicId("0008");
			List<String> list = new ArrayList<String>();
			if(timeList.size()>0){
				list.add(timeList.get(0).getParamValue());
			}
			if(orderList.size()>0){
				list.add("温馨提示：您的订单正在配送中......");
			}
			for(SysDictionaryItem item:itemList){
				list.add(item.getParamValue());
			}
			response.setCharacterEncoding("utf-8");
			response.setHeader("Pragma","No-cache"); 
			response.setHeader("Cache-Control","no-cache"); 
			response.setDateHeader("Expires", 0);  
			response.getWriter().print("var marqueeContent="+JSONArray.toJSON(list));	
		}catch(Exception e){
			e.printStackTrace();
		}	
		
	}
	
	/**
	 * 呼叫人工服务
	 */
	public String call(){
		String tvn = ServletActionContext.getRequest().getParameter("tvn");
		try{
			TvUser user = (TvUser) commonService.getByID(TvUser.class, tvn);
			if(user!=null){
				ReturnVisit rv = new ReturnVisit();
				rv.setVisitId(user.getUserId());
				rv.setVisitCard(user.getUserCardNumber());
				rv.setVisitName(user.getUserName());
				rv.setVisitPhone(user.getUserPhone());
				rv.setVisitHomePhone(user.getUserHomePhone());
				rv.setVisitAddress(user.getAddressDetail());
				rv.setVisitBalance(user.getUserBalance());
				rv.setVisitIntegral(user.getUserIntegral());
				rv.setCreateTime(DateUtil.currentTime());
				rv.setStatus(0);
				service.save(rv);
				json = new AjaxDone("200","已呼叫人工服务，请耐心等待电话。。。","","","","");
			}else{
				json = new AjaxDone("300","读取用户信息出错，请重新登录","","","","");
			}
		}catch(Exception e){
			e.printStackTrace();
			json = new AjaxDone("300","未知错误","","","","");
		}	
		return "ajaxResult";
	}

	/**
	 * 到广告页面
	 * @return
	 */
	public String toAdv() {
		return "toAdv";
	}
	
	public AjaxDone getJson() {
		return json;
	}

	public void setJson(AjaxDone json) {
		this.json = json;
	}
}
