package com.zhengke.business.action;

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
import com.zhengke.business.service.AccountService;
import com.zhengke.common.action.CommonAction;
import com.zhengke.common.pojo.SysDictionaryItem;
import com.zhengke.common.pojo.TvOrder;
import com.zhengke.common.pojo.TvOrderGoods;
import com.zhengke.common.pojo.TvUser;
import com.zhengke.common.pojo.TvUserIntegralLog;
import com.zhengke.common.service.CommonService;
import com.zhengke.common.util.object.AjaxDone;
import com.zhengke.common.util.object.CurrentUser;


@Controller("AccountAction") @Scope("prototype")
public class AccountAction extends CommonAction {
	private static final long serialVersionUID = 3896110624661690733L;
	@Resource AccountService service;
	@Resource CommonService commonService;
	private AjaxDone json;

	/**
	 * 到我的账户页面
	 * @return
	 */
	public String toAccountCenter(){
		CurrentUser user = getCurrentUser();
		String userId = user.getTvnNo();//用户ID
		/*TvUser tvUser = (TvUser) commonService.getByID(TvUser.class, userId);
		ActionContext.getContext().put("tmp", new Date());
		ActionContext.getContext().put("userInte", tvUser.getUserIntegral());
		ActionContext.getContext().put("userBalan", tvUser.getUserBalance());*/
		ActionContext.getContext().put("tmp", new Date());
		ActionContext.getContext().put("tvnNo", userId);
		return "toAccountCenter";
	}
	
	/**
	 * 到订单列表页
	 * @return
	 */
	public String toOrdersData(){
		CurrentUser user = getCurrentUser();
		String userId = user.getTvnNo();//用户ID
		ActionContext.getContext().put("tvnNo", userId);
		ActionContext.getContext().put("tmp", new Date());
		return "toOrdersData";
	}
	
	/**
	 * 查询订单列表
	 * @return
	 */
	public void ordersData(){
		CurrentUser user = getCurrentUser();
		String userId = user.getTvnNo();//用户ID
		HttpServletResponse response = ServletActionContext.getResponse();
		try{
			List<TvOrder> orderlist = service.queryOrderList(userId);
			List<Map<String,String>> rtnList = new ArrayList<Map<String,String>>();
			for(TvOrder to : orderlist){
				Map<String,String> temp = new HashMap<String,String>();
				TvOrderGoods tog = service.findTvOrderGoods(to.getOrderId().toString());
				if(tog!=null){
					if(tog.getGoodsType()==3||tog.getGoodsType()==7){
						temp.put("goodsAmount", to.getGoodsAmount().toString()+"分");
						temp.put("orderAmount", to.getOrderAmount().toString()+"分");
					}
					else{
						temp.put("goodsAmount", "￥"+to.getGoodsAmount().toString());
						temp.put("orderAmount", "￥"+to.getOrderAmount().toString());
					}
					temp.put("goodsId", tog.getGoodsId().toString());
					temp.put("orderNumber", tog.getGoodsNum().toString());
				}
				temp.put("orderSn", to.getOrderSn());
				temp.put("orderId", to.getOrderId().toString());
				temp.put("addTime", to.getAddTime());
				temp.put("finishTime", to.getFinishTime());
				if(to.getOrderState()==0)
					temp.put("orderState", "已取消");
				if(to.getOrderState()==10)
					temp.put("orderState", "待确认");
				if(to.getOrderState()==20)
					temp.put("orderState", "已确认");
				if(to.getOrderState()==30)
					temp.put("orderState", "已配货");
				if(to.getOrderState()==40)
					temp.put("orderState", "已发货");
				if(to.getOrderState()==50)
					temp.put("orderState", "已收款");
				if(to.getOrderState()==60)
					temp.put("orderState", "已退货");
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
	 * 订单详情
	 */
	public String toOrderDetail(){
		String orderId = ServletActionContext.getRequest().getParameter("orderId");
		try{
			List<Object[]> list = service.findOrderDetail(orderId);
			if(list.size()>0){
				if("0".equals(list.get(0)[11].toString()))
					ActionContext.getContext().put("state", "已取消");
				if("10".equals(list.get(0)[11].toString()))
					ActionContext.getContext().put("state", "待确认");
				if("20".equals(list.get(0)[11].toString()))
					ActionContext.getContext().put("state", "已确认");
				if("30".equals(list.get(0)[11].toString()))
					ActionContext.getContext().put("state", "已配货");
				if("40".equals(list.get(0)[11].toString()))
					ActionContext.getContext().put("state", "已发货");
				if("50".equals(list.get(0)[11].toString()))
					ActionContext.getContext().put("state", "已收款");
				if("60".equals(list.get(0)[11].toString()))
					ActionContext.getContext().put("state", "已退货");
				
				if("0".equals(list.get(0)[12].toString()))
					ActionContext.getContext().put("goodsType", "正品");
				if("1".equals(list.get(0)[12].toString()))
					ActionContext.getContext().put("goodsType", "打折品");
				if("2".equals(list.get(0)[12].toString()))
					ActionContext.getContext().put("goodsType", "体验品");
				if("3".equals(list.get(0)[12].toString())||"7".equals(list.get(0)[12].toString()))
					ActionContext.getContext().put("goodsType", "积分兑换商品");
				if("4".equals(list.get(0)[12].toString()))
					ActionContext.getContext().put("goodsType", "已发货");
				if("5".equals(list.get(0)[12].toString()))
					ActionContext.getContext().put("goodsType", "打包品");
				
				ActionContext.getContext().put("list", list.get(0));
				ActionContext.getContext().put("goodsId", list.get(0)[6]);
				ActionContext.getContext().put("num", list.get(0)[8]);
				ActionContext.getContext().put("type", list.get(0)[12]);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "toOrderDetail";
	}
	
	
	/**
	 * 到个人中心页面
	 * @return
	 */
	public String toUserCenter(){
		CurrentUser user = getCurrentUser();
		String userId = user.getTvnNo();//用户ID
		TvUser tvUser = (TvUser) commonService.getByID(TvUser.class, userId);
		ActionContext.getContext().put("tmp", new Date());
		ActionContext.getContext().put("userInte", tvUser.getUserIntegral());
		ActionContext.getContext().put("userBalan", tvUser.getUserBalance());
		ActionContext.getContext().put("tvnNo", userId);
		return "toUserCenter";
	}
	
	/**
	 * 查询个人中心信息
	 * @return
	 */
	public void userData(){
		CurrentUser user = getCurrentUser();
		String userId = user.getTvnNo();//用户ID
		HttpServletResponse response = ServletActionContext.getResponse();
		try{
			List<TvUserIntegralLog> list = service.queryIntegerList(userId);
			List<Map<String,String>> rtnList = new ArrayList<Map<String,String>>();
			for(TvUserIntegralLog to : list){
				Map<String,String> temp = new HashMap<String,String>();
				temp.put("inteNum", to.getIntegralNum().toString());
				temp.put("inteTime", to.getTime());
				if(to.getSign()==0){
					temp.put("sign", "抵扣");
				}
				if(to.getSign()==1){
					temp.put("sign", "赠送");
				}
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
	 * 到送货信息页面
	 * @return
	 */
	public String toDeliveryTime(){
		CurrentUser user = getCurrentUser();
		String userId = user.getTvnNo();//用户ID
		ActionContext.getContext().put("tvnNo", userId);
		ActionContext.getContext().put("tmp", new Date());
		return "toDeliveryTime";
	}
	
	/**
	 * 查询送货时间
	 * @return
	 */
	public void deliveryTime(){
		HttpServletResponse response = ServletActionContext.getResponse();
		try{
			List<SysDictionaryItem> list = service.queryDeliveryTimeList();
			List<Map<String,String>> rtnList = new ArrayList<Map<String,String>>();
			Map<String,String> map = new HashMap<String,String>();
			map.put("deployId", "");
			map.put("deployInfo", "自提");
			rtnList.add(map);
			for(SysDictionaryItem to : list){
				Map<String,String> temp = new HashMap<String,String>();
				temp.put("deployId", to.getItemId());
				temp.put("deployInfo", to.getParamValue());
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
	 * 设置送货信息
	 * @return
	 */
	public String setDeliveryTime(){
		CurrentUser user = getCurrentUser();
		String userId = user.getTvnNo();//用户ID
		String deployId = ServletActionContext.getRequest().getParameter("deployId");
		String deployInfo = ServletActionContext.getRequest().getParameter("deployInfo");
		try{
			TvUser tvUser = (TvUser) commonService.getByID(TvUser.class, userId);
			if(deployId==null||"".equals(deployId)){
				tvUser.setDeliveryWay((short)1);
				tvUser.setReceiptTime("");
				user.setDeliveryWay((short)1);
			}
			else{
				tvUser.setDeliveryWay((short)0);
				tvUser.setReceiptTime(deployInfo);
				user.setDeliveryWay((short)1);
			}
			service.setDeliveryTime(tvUser);
			
			user.setReceiptTime(deployInfo);
			ActionContext.getContext().getSession().put(SESSION_USER_KEY, user);//更新session
			
			json = new AjaxDone("200","设置成功！","","","","");
		}catch(Exception e){
			e.printStackTrace();
			json = new AjaxDone("300","设置失败！"+e.getMessage(),"","","","");
		}
		return "ajaxResult";
	}
	
	
	public AjaxDone getJson() {
		return json;
	}

	public void setJson(AjaxDone json) {
		this.json = json;
	}
}
