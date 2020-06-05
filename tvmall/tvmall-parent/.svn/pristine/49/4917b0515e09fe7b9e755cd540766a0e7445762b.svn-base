package com.zhengke.business.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zhengke.common.dao.CommonDao;
import com.zhengke.common.pojo.SysDictionaryItem;
import com.zhengke.common.pojo.TvOrder;
import com.zhengke.common.pojo.TvOrderGoods;
import com.zhengke.common.pojo.TvUser;
import com.zhengke.common.pojo.TvUserIntegralLog;


@Service 
@Transactional
public class AccountServiceImpl implements AccountService {
	@Resource CommonDao commonDao;
	
	/**
	 * 查询订单列表
	 * @param userId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<TvOrder> queryOrderList(String userId) {
		StringBuffer buffer = new StringBuffer();
		Map<String,String> param = new HashMap<String,String>();
		buffer.append("from TvOrder where userId =:userId order by orderSn desc");
		if(userId!=null&&!"".equals(userId)){
			param.put("userId", userId);
		}
		List<TvOrder> rtnList = (List<TvOrder>) commonDao.queryByHql(buffer.toString(), param);
		
		return rtnList;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public TvOrderGoods findTvOrderGoods(String orderId) {
		StringBuffer buffer = new StringBuffer();
		Map<String,String> param = new HashMap<String,String>();
		buffer.append("from TvOrderGoods where orderId =:orderId ");
		param.put("orderId", orderId);
		List<TvOrderGoods> rtnList = (List<TvOrderGoods>) commonDao.queryByHql(buffer.toString(), param);
		if(rtnList.size()>0)
			return rtnList.get(0);
		return null;
	}
	
	/**
	 * 查询积分详情
	 * @param userId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<TvUserIntegralLog> queryIntegerList(String userId) {
		StringBuffer buffer = new StringBuffer();
		Map<String,String> param = new HashMap<String,String>();
		buffer.append("from TvUserIntegralLog where userId =:userId order by time desc");
		param.put("userId", userId);
		List<TvUserIntegralLog> rtnList = (List<TvUserIntegralLog>) commonDao.queryByHql(buffer.toString(), param);
		
		return rtnList;
	}
	
	/**
	 * 查询送货时间
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<SysDictionaryItem> queryDeliveryTimeList() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("from SysDictionaryItem where dicId=0003");
		List<SysDictionaryItem> rtnList = (List<SysDictionaryItem>) commonDao.queryByHql(buffer.toString(), null);
		return rtnList;
	}
	
	/**
	 * 设置送货时间
	 * @param tvUser
	 */
	@Override
	public void setDeliveryTime(TvUser tvUser) {
		commonDao.update(tvUser);
	}

	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Object[]> findOrderDetail(String orderId) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("select tod.order_sn,tod.add_time,tod.order_amount,tod.shipping_fee,tod.integral_handsel,")
				.append("tod.receipt_method,tog.goods_id,tog.goods_name,tog.goods_num,sa.area_name,tod.receiver_address,tod.order_state,tog.goods_type,tod.goods_amount from tv_order tod ")
				.append(" left join tv_order_goods tog on tod.order_id=tog.order_id ")
				.append(" left join sys_area sa on tod.service_point_id=sa.area_id where tod.order_id='"+orderId+"'");
		List<Object[]> rtnList = commonDao.queryBySql(buffer.toString(), null);
		return rtnList;
	}
	
}
