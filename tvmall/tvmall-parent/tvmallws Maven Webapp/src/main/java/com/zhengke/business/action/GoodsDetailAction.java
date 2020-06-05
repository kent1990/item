package com.zhengke.business.action;

import java.io.File;
import java.math.BigDecimal;
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
import com.zhengke.business.service.detail.GoodsDetailService;
import com.zhengke.common.action.CommonAction;
import com.zhengke.common.pojo.CommonGoods;
import com.zhengke.common.pojo.GoodsDetail;
import com.zhengke.common.pojo.MallServiceGoods;
import com.zhengke.common.pojo.MallSupplier;
import com.zhengke.common.pojo.SysDictionaryItem;
import com.zhengke.common.pojo.TvOrder;
import com.zhengke.common.pojo.TvOrderGoods;
import com.zhengke.common.pojo.TvUser;
import com.zhengke.common.pojo.TvUserOpera;
import com.zhengke.common.service.CommonService;
import com.zhengke.common.util.object.AjaxDone;
import com.zhengke.common.util.object.CurrentUser;
import com.zhengke.common.util.tools.CommonUtil;
import com.zhengke.common.util.tools.DateUtil;
import com.zhengke.common.util.tools.LoadProperties;

@Controller("GoodsDetailAction") @Scope("prototype")
public class GoodsDetailAction extends CommonAction{
	private static final long serialVersionUID = 1L;
	@Resource GoodsDetailService service;
	@Resource CommonService commonService;
	
	private AjaxDone json;
	/**
	 * 到商品详情页面
	 * @return
	 */
	public String toGoodsDetail(){
		CurrentUser cu = getCurrentUser();
		String goodsId = ServletActionContext.getRequest().getParameter("goodsId");//商品id
		String orderNumber = ServletActionContext.getRequest().getParameter("orderNumber");//商品数量
		String type = ServletActionContext.getRequest().getParameter("type");
		//商品类型，“5”打包品，“1”打折品,"0"正品,"2"体验品,"3"积分兑换商品,"7"可兑换打包品，
		
		String pageTitle = ServletActionContext.getRequest().getParameter("pageTitle");
		ActionContext.getContext().put("pageTitle", pageTitle);
		
		String i = commonService.queryParamValueByItemId("00010001");
		String[] str = i.split(":");
		double a = Double.parseDouble(str[0]);
		double b = Double.parseDouble(str[1]);
		try{
			List<Object[]> list = new ArrayList<Object[]>();
			double commonPrice = 0.0d;
			if("1".equals(type)||"2".equals(type)||"3".equals(type)||"7".equals(type)){
				list = service.findGoodsDetail(goodsId);
			}else{
				list = service.findGoodsDetail2(goodsId);
				if("5".equals(type)){
					if(list.size()>0){
						List<Object[]> list3 = service.findBaleGoods(list.get(0)[0].toString());
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
					ActionContext.getContext().put("commonPrice", "￥"+obj[2]);//原价
				}
				if("5".equals(type)){
					ActionContext.getContext().put("commonPrice", "￥"+commonPrice);//原价
				}
				if("3".equals(type)||"7".equals(type)){
					String goodsPrice  = obj[3]==null?"":obj[3].toString();
					double d = Double.parseDouble(goodsPrice)*(a/b);
					ActionContext.getContext().put("commonPrice", d);//所需兑换积分
				}
				
				String shippingFee  = obj[4]==null?"":obj[4].toString();
				double s = Double.parseDouble(shippingFee)*(a/b);
				ActionContext.getContext().put("shippingFee", s);//运费
				
				TvUserOpera tvUserOpera = new TvUserOpera();
				tvUserOpera.setId(CommonUtil.createUUID());
				tvUserOpera.setUserId(Integer.parseInt(cu.getTvnNo()));
				tvUserOpera.setUserName(cu.getUserName());
				tvUserOpera.setType(4);
				tvUserOpera.setTime(DateUtil.currentTime());
				tvUserOpera.setText(obj[1].toString());
				
				commonService.sava(tvUserOpera);
				
				
				ActionContext.getContext().put("goodsId", goodsId);
				ActionContext.getContext().put("picList", rtnList);
				ActionContext.getContext().put("goodsName", obj[1]);
				ActionContext.getContext().put("goodsPrice", "￥"+obj[3]);//打折价
				ActionContext.getContext().put("deliveryWay", cu.getDeliveryWay());//收货方式
				ActionContext.getContext().put("supplierName", obj[6]);//供应商名称
				ActionContext.getContext().put("supplierId", obj[5]);//供应商id
				ActionContext.getContext().put("infoPicPath", infoPicPath);//介绍图片
				ActionContext.getContext().put("awardedIntegral", obj[13]);//赠送积分
				ActionContext.getContext().put("specifications", obj[14]);//商品规格
			}
			
			if(orderNumber==null||"".equals(orderNumber))
				ActionContext.getContext().put("orderNumber", 1);
			else
				ActionContext.getContext().put("orderNumber", orderNumber);
			
			//图片查询滚动时间
			List<SysDictionaryItem> timeList = commonService.queryDicItemByDicId("0008");
			if(timeList.size()>0){
				ActionContext.getContext().put("time", timeList.get(0).getParamValue());//轮播图片滚动时间
			}
			if("0".equals(type)||"2".equals(type)){
				ActionContext.getContext().put("show", "0");//显示类型
			}else{
				ActionContext.getContext().put("show", "1");//显示类型
			}
			ActionContext.getContext().put("type", type);//商品类型
			
			
		}catch(Exception e){
			e.printStackTrace();
		}		
		return "toGoodsDetail";
	}
	
	/**
	 * 到订单页面
	 * @return
	 */
	public String toOrderPage(){
		String goodsId = ServletActionContext.getRequest().getParameter("goodsId");
		String number = ServletActionContext.getRequest().getParameter("number");
		String type = ServletActionContext.getRequest().getParameter("type");
		String sFeeInte = ServletActionContext.getRequest().getParameter("shippingFee");//运费所需积分
		String gPriceInte = ServletActionContext.getRequest().getParameter("goodsPrice");//商品所需积分
		String specifications = ServletActionContext.getRequest().getParameter("specifications");//商品规格
		//商品类型，“5”打包品，“1”打折品,"0"正品,"2"体验品,"3"积分兑换商品,"7"可兑换打包品，
		try{
			
			CurrentUser cu = getCurrentUser();
			ActionContext.getContext().put("userName",cu.getUserName());//用户名(收货人姓名)
			ActionContext.getContext().put("phone",cu.getPhone());//电话（收货人电话
			ActionContext.getContext().put("address", cu.getAddressDetail());//收货地址
			
			//收货方式
			String receiptTime = cu.getReceiptTime();
			/*if(receiptTime==null){
				ActionContext.getContext().put("flag", "rt");//区分不同功能
				return "setReceiptTime";
			}
			else*/
				ActionContext.getContext().put("receiptTime", receiptTime);
			
			Short deliveryWay = cu.getDeliveryWay();
			if(deliveryWay==null){				
				ActionContext.getContext().put("flag", "dw");//区分不同功能
				ActionContext.getContext().put("goodsId", goodsId);
				ActionContext.getContext().put("number", number);
				ActionContext.getContext().put("tmp", CommonUtil.createUUID());
				return "setDeliverWay";
			}else{
				ActionContext.getContext().put("deliverWay",deliveryWay);
			}
			
			CommonGoods commonGoods = null;
			GoodsDetail goodsDetail = null;
			if("0".equals(type)||"5".equals(type)){
				commonGoods = (CommonGoods) commonService.getByID(CommonGoods.class, Integer.parseInt(goodsId));
			}else{
				goodsDetail = (GoodsDetail) commonService.getByID(GoodsDetail.class, Integer.parseInt(goodsId));
				commonGoods = (CommonGoods) commonService.getByID(CommonGoods.class, goodsDetail.getCommonGoodsId());
			}
			
			ActionContext.getContext().put("goodsName", commonGoods.getGoodsName());
			int sendIntegral = 0;
			//订单商品总价
			BigDecimal num = new BigDecimal(number);
			BigDecimal total = new BigDecimal(0).setScale(2, BigDecimal.ROUND_HALF_UP);
			BigDecimal total2 = new BigDecimal(0).setScale(2, BigDecimal.ROUND_HALF_UP);
			if("0".equals(type)||"5".equals(type)){
				BigDecimal price = new BigDecimal(commonGoods.getCommonPrice()).setScale(2, BigDecimal.ROUND_HALF_UP);
				total = price.multiply(num).setScale(2, BigDecimal.ROUND_HALF_UP);
				ActionContext.getContext().put("price", price);
				ActionContext.getContext().put("total", total);
				sendIntegral = commonGoods.getSendInte()*Integer.parseInt(number);
			}else if("3".equals(type)||"7".equals(type)){
				BigDecimal gPriceInte2 = new BigDecimal(gPriceInte).setScale(2, BigDecimal.ROUND_HALF_UP);
				total2 = gPriceInte2.multiply(num).setScale(2, BigDecimal.ROUND_HALF_UP);
				
				ActionContext.getContext().put("price", gPriceInte2);
				ActionContext.getContext().put("total", total2);
				sendIntegral = goodsDetail.getAwardedIntegral()*Integer.parseInt(number);
			}else{ 
				BigDecimal price = new BigDecimal(goodsDetail.getGoodsPrice()).setScale(2, BigDecimal.ROUND_HALF_UP);
				total = price.multiply(num).setScale(2, BigDecimal.ROUND_HALF_UP);
				ActionContext.getContext().put("price",  price);
				ActionContext.getContext().put("total", total);
				sendIntegral = goodsDetail.getAwardedIntegral()*Integer.parseInt(number);
			}
			//订单总价
			BigDecimal shippingFee = new BigDecimal(commonGoods.getShippingFee()).setScale(2, BigDecimal.ROUND_HALF_UP);
			if(deliveryWay==0){
				BigDecimal sFeeInte2 = new BigDecimal(sFeeInte).setScale(2, BigDecimal.ROUND_HALF_UP);
				BigDecimal sFeeInte2Total = sFeeInte2.multiply(num).setScale(2, BigDecimal.ROUND_HALF_UP);
				if("3".equals(type)||"7".equals(type)){
					BigDecimal orderAmount = total2.add(sFeeInte2).setScale(2, BigDecimal.ROUND_HALF_UP);
					ActionContext.getContext().put("total2", orderAmount.doubleValue());//订单总价
				}else{
					BigDecimal orderAmount = total.add(shippingFee).setScale(2, BigDecimal.ROUND_HALF_UP);
					ActionContext.getContext().put("total2", orderAmount.doubleValue());//订单总价
				}
				ActionContext.getContext().put("shippingFee", sFeeInte2Total.doubleValue());//配送积分
			}else{
				if("3".equals(type)||"7".equals(type)){
					ActionContext.getContext().put("total2", total2.doubleValue());//订单总价
				}else
					ActionContext.getContext().put("total2", total.doubleValue());//订单总价
			}
			
			ActionContext.getContext().put("sendIntegral", sendIntegral);//赠送积分
			ActionContext.getContext().put("number", number);
			
			ActionContext.getContext().put("goodsId", goodsId);
			ActionContext.getContext().put("type", type);
			ActionContext.getContext().put("flag", "normal");//区分不同功能
			ActionContext.getContext().put("tmp", CommonUtil.createUUID());
			ActionContext.getContext().put("specifications", specifications);//商品规格
		}catch(Exception e){
			e.printStackTrace();
		}
		return "toOrderPage";
	}
	
	/**
	 * 设置收货方式
	 * @return
	 */
	public String doSetDeliveryWay(){
		String way = ServletActionContext.getRequest().getParameter("way");
		String goodsId = ServletActionContext.getRequest().getParameter("goodsId");
		String number = ServletActionContext.getRequest().getParameter("number");
		CurrentUser cu = getCurrentUser();
		try{
			TvUser tu = (TvUser)commonService.getByID(TvUser.class, cu.getTvnNo());
			tu.setDeliveryWay(Short.parseShort(way));
			service.setTvUser(tu);
			
			Map<String,String> rtnMap = new HashMap<String,String>();
			rtnMap.put("goodsId", goodsId);
			rtnMap.put("number", number);
			json = new AjaxDone("200","设置成功！",rtnMap);
			cu.setDeliveryWay(Short.parseShort(way));
			ActionContext.getContext().getSession().put(SESSION_USER_KEY, cu);
		}catch(Exception e){
			e.printStackTrace();
			json = new AjaxDone("300","设置失败！",null);
		}
		return "ajaxResult";
	}
	
	/**
	 * 到设置收货时间页面
	 * @return
	 */
	public String toSetTime(){
		String goodsId = ServletActionContext.getRequest().getParameter("goodsId");
		String number = ServletActionContext.getRequest().getParameter("number");
		String way = ServletActionContext.getRequest().getParameter("way");
			
		ActionContext.getContext().put("goodsId", goodsId);
		ActionContext.getContext().put("number", number);
		ActionContext.getContext().put("way", way);	
		ActionContext.getContext().put("tmp", CommonUtil.createUUID());
		
		return "toSetTime";
	}
	
	/**
	 * 查询系统设置的收货时间
	 */
	public void queryReceiptTime(){
		List<SysDictionaryItem> list = commonService.queryDicItemByDicId("0003");
		try{
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("utf8");			
			response.setHeader("Pragma","No-cache"); 
			response.setHeader("Cache-Control","no-cache"); 
			response.setDateHeader("Expires", 0);  
			response.getWriter().print("var dataList="+JSONArray.toJSON(list));	
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 设置收货时间
	 * @return
	 */
	public String setReceiptTime(){
		String goodsId = ServletActionContext.getRequest().getParameter("goodsId");
		String number = ServletActionContext.getRequest().getParameter("number");
		String way = ServletActionContext.getRequest().getParameter("way");
		String time = ServletActionContext.getRequest().getParameter("time");
		try{
			CurrentUser cu = getCurrentUser();
			TvUser tu = (TvUser)commonService.getByID(TvUser.class, cu.getTvnNo());
			tu.setDeliveryWay(Short.parseShort(way));
			tu.setReceiptTime(time);
			service.setTvUser(tu);
			
			Map<String,String> rtnMap = new HashMap<String,String>();
			rtnMap.put("goodsId", goodsId);
			rtnMap.put("number", number);
			cu.setDeliveryWay(Short.parseShort(way));
			cu.setReceiptTime(time);
			ActionContext.getContext().getSession().put(SESSION_USER_KEY, cu);			
			json = new AjaxDone("200","设置成功！",null);
		}catch(Exception e){
			e.printStackTrace();
			json = new AjaxDone("300","设置失败！",null);
		}
		return "ajaxResult";
	}
	
	/**
	 * 生成订单
	 * @return
	 */
	public String createOrder(){
		String goodsId = ServletActionContext.getRequest().getParameter("goodsId");
		String number = ServletActionContext.getRequest().getParameter("number");
		String type = ServletActionContext.getRequest().getParameter("type");
		String sFeeInte = ServletActionContext.getRequest().getParameter("shippingFee");//运费所需积分
		String gPriceInte = ServletActionContext.getRequest().getParameter("goodsPrice");//商品所需积分
		String specifications = ServletActionContext.getRequest().getParameter("specifications");//商品规格
		//商品类型，“5”打包品，“1”打折品,"0"正品,"2"体验品,"3"积分兑换商品,"7"可兑换打包品，
		try{
			CurrentUser cu = getCurrentUser();
			String goodType = "0";
			if("0".equals(type)||"5".equals(type))
				goodType = type;
			else
				goodType = "6";
			List<MallServiceGoods> list = service.findServiceGoods(cu.getStationId(),goodsId,goodType);
			//List<Object[]> list2 = service.findTvGoods(goodsId,type);
			//int id = 0;//服务点主键自增ID
			MallServiceGoods msg = null;
			if(list.size()>0){
				msg = list.get(0);
				if(msg.getGoodsDestineQuota()<Integer.parseInt(number)){
					json = new AjaxDone("300","下单失败，商品剩余数量不足！",null);
					return "ajaxResult";
				}
				/*
				if(list2.size()>0){
					int a = Integer.parseInt(list2.get(0)[0].toString());
					if(a>=msg.getGoodsDestineQuota()){
						json = new AjaxDone("300","下单失败，商品剩余数量不足！",null);
						return "ajaxResult";
					}
				}*/
				//id = msg.getId();
			}else{
				json = new AjaxDone("300","下单失败，该商品已下架！",null);
				return "ajaxResult";
			}
			
			CommonGoods commonGoods = null;
			GoodsDetail goodsDetail = null;
			if("0".equals(type)||"5".equals(type)){
				commonGoods = (CommonGoods) commonService.getByID(CommonGoods.class, Integer.parseInt(goodsId));
			}else{
				goodsDetail = (GoodsDetail) commonService.getByID(GoodsDetail.class, Integer.parseInt(goodsId));
				commonGoods = (CommonGoods) commonService.getByID(CommonGoods.class, goodsDetail.getCommonGoodsId());
			}
			
			/*
			 *构造保存订单商品信息 
			 */
			TvOrderGoods tog = new TvOrderGoods();
			tog.setGoodsId(Integer.parseInt(goodsId));
			tog.setGoodsName(commonGoods.getGoodsName());
			
			/*
			 *构造保存订单信息 
			 */
			TvOrder to = new TvOrder();
			to.setOrderSn(service.createOrderSn(cu.getTvnNo()));//订单编号
			to.setUserId(cu.getTvnNo()); //用户id tvn号码
			to.setUserName(cu.getUserName()); //用户名称
			to.setUserCardNumber(cu.getUserCardNo()); //用户卡号
			to.setAddTime(DateUtil.getSystemDateTime());//生成时间
			tog.setGoodsTime(DateUtil.getSystemDateTime());
			
			
			//订单商品总价
			BigDecimal num = new BigDecimal(number);
			BigDecimal total = new BigDecimal(0).setScale(2, BigDecimal.ROUND_HALF_UP);
			BigDecimal price = new BigDecimal(0).setScale(2, BigDecimal.ROUND_HALF_UP);
			if("0".equals(type)||"5".equals(type)){
				price = new BigDecimal(commonGoods.getCommonPrice()).setScale(2, BigDecimal.ROUND_HALF_UP);
				total = price.multiply(num).setScale(2, BigDecimal.ROUND_HALF_UP);
			}else if("3".equals(type)||"7".equals(type)){
				price = new BigDecimal(gPriceInte).setScale(2, BigDecimal.ROUND_HALF_UP);
				total = price.multiply(num).setScale(2, BigDecimal.ROUND_HALF_UP);
			}else{ 
				price = new BigDecimal(goodsDetail.getGoodsPrice()).setScale(2, BigDecimal.ROUND_HALF_UP);
				total = price.multiply(num).setScale(2, BigDecimal.ROUND_HALF_UP);
			}
			tog.setGoodsPrice(price.doubleValue());//商品价格
			tog.setGoodsPayPrice(price.doubleValue());//商品实际成交价
			to.setGoodsAmount(total.doubleValue());	//订单商品总价	
			
			//查询用户积分
			//TvUser tvUser = (TvUser) commonService.getByID(TvUser.class, cu.getTvnNo());
			//List<Object[]> listI = service.findInteGoods(cu.getTvnNo());
			
			//订单总价
			Short deliveryWay = cu.getDeliveryWay();
			BigDecimal shippingFee = new BigDecimal(commonGoods.getShippingFee()).setScale(2, BigDecimal.ROUND_HALF_UP);
			BigDecimal shippingFee2 = new BigDecimal(sFeeInte).setScale(2, BigDecimal.ROUND_HALF_UP);
			BigDecimal shippingFee3 = new BigDecimal(0).setScale(2, BigDecimal.ROUND_HALF_UP); 
			BigDecimal orderAmount = new BigDecimal(0).setScale(2, BigDecimal.ROUND_HALF_UP); 
			if(deliveryWay==0){
				if("3".equals(type)||"7".equals(type)){
					shippingFee3 = shippingFee2.multiply(num).setScale(2, BigDecimal.ROUND_HALF_UP);
					orderAmount = total.add(shippingFee3).setScale(2, BigDecimal.ROUND_HALF_UP);
					/*if(listI.size()>0){
						double d = Double.parseDouble(listI.get(0)[0].toString());
						if(orderAmount.doubleValue()+d>tvUser.getUserIntegral()){
							json = new AjaxDone("300","下单失败，您的积分不够！",null);
							return "ajaxResult";
						}
					}*/
				}else{
					shippingFee3 = shippingFee.multiply(num).setScale(2, BigDecimal.ROUND_HALF_UP);
					orderAmount = total.add(shippingFee3).setScale(2, BigDecimal.ROUND_HALF_UP);
				}
				BigDecimal shippingFee4 = shippingFee2.multiply(num).setScale(2, BigDecimal.ROUND_HALF_UP);
				to.setShippingFee(shippingFee4.doubleValue());//订单运费
				
				to.setOrderAmount(orderAmount.doubleValue());//订单总价
				to.setDeliveryTime(cu.getReceiptTime());//送货时间段
			}else{
				/*if("3".equals(type)||"7".equals(type)){
					if(listI.size()>0){
						double d = Double.parseDouble(listI.get(0)[0].toString());
						if(total.doubleValue()+d>tvUser.getUserIntegral()){
							json = new AjaxDone("300","下单失败，您的积分不够！",null);
							return "ajaxResult";
						}
					}
				}*/
				to.setOrderAmount(total.doubleValue());//订单总价
			}
			
			to.setOrderState((short)10);//订单状态  生成时设定已确认  订单状态：0:已取消;10(默认):待确认;20:已确认;30:已配货;40:已发货;50:已收款;60:已退货
			
			//技术订单商品赠送积分			
			BigDecimal integral = new BigDecimal(commonGoods.getSendInte()).multiply(num).setScale(2, BigDecimal.ROUND_HALF_UP);
			if("1".equals(type)||"5".equals(type))
				to.setIntegralHandsel(0.0d);//订单赠送积分
			else
				to.setIntegralHandsel(integral.doubleValue());//订单赠送积分
			
			to.setServicePointId(Integer.parseInt(cu.getStationId()));//服务点id
			
			to.setReceiverName(cu.getUserName()); //收货人姓名
			to.setReceiverAddress(cu.getAddressDetail()); //收货人地址
			to.setReceiveProvinceId(Integer.parseInt(cu.getProvinceId()));//收货人省份id
			to.setReceiveCityId(Integer.parseInt(cu.getCityId()));//收货人城市id
			to.setReceiptMethod(cu.getDeliveryWay());
			to.setReceiverPhone(cu.getPhone());
			
			//继续保存订单商品信息
			if("2".equals(type)){
				to.setIsExperie((short)1);
			}else if("3".equals(type)||"7".equals(type)){
				to.setIsExperie((short)2);
			}else{
				to.setIsExperie((short)0);
			}
			tog.setIsDelivery((short)0);
			
			tog.setGoodsNum(Short.parseShort(number));
			tog.setServicePointId(Integer.parseInt(cu.getStationId()));
			tog.setUserId(cu.getTvnNo());
			tog.setGoodsType(Short.parseShort(type));//商品属性(1默认2折扣商品3打包组合4体验品)
			tog.setState((short)1);
			tog.setSpecifications(specifications);//商品规格
			
			//减少预定限额
			msg.setGoodsDestineQuota(msg.getGoodsDestineQuota()-Integer.parseInt(number));
			
			service.createOrder(to, tog,msg);			
			json = new AjaxDone("200","您的订单已生成！",null);			
		}catch(Exception e){
			e.printStackTrace();
			json = new AjaxDone("300","下单失败，请稍后再试！",null);
		}	
		
		return "ajaxResult";
	}
	
	/**
	 * 到提示页面
	 * @return
	 */
	public String toTips(){		
		
		return "tips";
	}
	
	/**
	 * 供应商信息
	 * @return
	 */
	public String toSupplierDetail(){
		try{
			String supplierId = ServletActionContext.getRequest().getParameter("supplierId");
			MallSupplier ms = (MallSupplier) commonService.getByID(MallSupplier.class, Integer.parseInt(supplierId));
			ActionContext.getContext().put("ms", ms);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "toSupplierDetail";
	}
	
	public AjaxDone getJson() {
		return json;
	}

	public void setJson(AjaxDone json) {
		this.json = json;
	}
}
