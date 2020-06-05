package com.zhengke.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhengke.common.object.Result;
import com.zhengke.common.util.FileExport;
import com.zhengke.pojo.TvOrder;
import com.zhengke.service.OrderService;

@Controller
@RequestMapping("order")
public class TVOrderController {
	@Reference
	private OrderService service;
	/**
	 * 去订单列表
	 * @return
	 */
	@RequestMapping("query.do")
	public String toQuery() {
		return "order/list";
	}
    
	/**
	 * 订单列表
	 * @return
	 */
	@ResponseBody
    @RequestMapping("list.do")
	public Result list(String orderSn, String userId, String userName, String orderState,int page,int limit){
    	Result rs = null;    	
    	try {
			 rs = service.queryAll(orderSn, userId, userName, orderState, page, limit);
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
		}  	
		return new Result();
	}
    
    /**
     * export Excel
     * @param orderSn
     * @param userId
     * @param userName
     * @param orderState
     */
    @SuppressWarnings("unchecked")
	@RequestMapping("export.do")
    public void exportExcel(String orderSn, String userId, String userName, String orderState,HttpServletResponse response) {
    	Result rs = null;    	
    	try {
			 rs = service.queryAll(orderSn, userId, userName, orderState, 0, 0);
			 String[] topName = {"订单编号","用户id", "用户姓名"};
			 List<Object[]> list = new ArrayList<Object[]>();
			 for(TvOrder order : (List<TvOrder>)rs.getData()) {
				 Object [] obj =new Object[topName.length];
				 obj[0]=order.getOrderSn();
				 obj[1]=order.getUserId();
				 obj[2]=order.getUserName();
				 
				 list.add(obj);
			 }			 
			FileExport.exportExcel(topName, list, "订单信息", response);
		} catch (Exception e) {
			e.printStackTrace();
		} 
    	
    	
    }
	
}
