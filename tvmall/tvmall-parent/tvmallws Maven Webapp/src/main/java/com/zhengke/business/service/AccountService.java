package com.zhengke.business.service;

import java.util.List;

import com.zhengke.common.pojo.SysDictionaryItem;
import com.zhengke.common.pojo.TvOrder;
import com.zhengke.common.pojo.TvOrderGoods;
import com.zhengke.common.pojo.TvUser;
import com.zhengke.common.pojo.TvUserIntegralLog;


public interface AccountService {
	
	/**
	 * 查询订单列表
	 * @param userId
	 * @return
	 */
	List<TvOrder> queryOrderList(String userId);
	
	/**
	 * 根据订单ID查询订单商品
	 * @param orderId
	 * @return
	 */
	TvOrderGoods findTvOrderGoods(String orderId);
	
	/**
	 * 查询积分详情
	 * @param userId
	 * @return
	 */
	List<TvUserIntegralLog> queryIntegerList(String userId);
	
	/**
	 * 查询送货时间
	 * @return
	 */
	List<SysDictionaryItem> queryDeliveryTimeList();
	
	/**
	 * 设置送货时间
	 * @param tvUser
	 */
	void setDeliveryTime(TvUser tvUser);
	
	/**
	 * 根据订单ID查询订单详情
	 * @return
	 */
	List<Object[]> findOrderDetail(String orderId);
}
