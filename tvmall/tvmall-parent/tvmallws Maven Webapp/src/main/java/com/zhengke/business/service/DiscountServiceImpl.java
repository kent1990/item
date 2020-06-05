package com.zhengke.business.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zhengke.common.dao.CommonDao;


@Service @Transactional
public class DiscountServiceImpl implements DiscountService {
	@Resource CommonDao commonDao;

	/**
	 * 查询打折商品列表
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Object[]> queryDiscountList(String stationId) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("select gd.goods_id,cg.goods_name,cg.thumb_picPath,gd.goods_price,gd.is_normal from common_goods cg ")
				.append(" inner join goods_detail gd on cg.goods_common_id=gd.common_goods_id")
				.append(" inner join mall_service_goods msg on msg.goods_id=gd.goods_id")
				.append(" where gd.is_normal=1 and cg.`status`=1 and gd.`status`=1 and msg.goods_type=6 and msg.goods_destine_quota>'0' and msg.service_point_id="+stationId)
				.append(" union")
				.append(" select cg.goods_common_id,cg.goods_name,cg.thumb_picPath,cg.common_price,msg.goods_type from common_goods cg ")
				.append(" inner join mall_service_goods msg on msg.goods_id=cg.goods_common_id")
				.append(" where cg.`type`=1 and cg.`status`=1 and msg.goods_type=5 and msg.goods_destine_quota>'0' and msg.service_point_id="+stationId);		
		List<Object[]> rtnList = commonDao.queryBySql(buffer.toString(), null);
		return rtnList;
	}
	
}
