package com.zhengke.business.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zhengke.common.dao.CommonDao;



@Service @Transactional
public class IntegralServiceImpl implements IntegralService {
	@Resource CommonDao commonDao;
	
	/**
	 * 查询可积分兑换商品
	 * @param pointId
	 * @return
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Object[]> queryIntegralList(String pointId) {
		StringBuffer buffer = new StringBuffer();
		Map<String,String> param = new HashMap<String,String>();
		buffer.append("select gd.goods_id,cg.goods_name,cg.common_price,cg.thumb_picPath,gd.goods_exch_integral,gd.is_normal from mall_service_goods msg ")
				.append(" inner join goods_detail gd on msg.goods_id=gd.goods_id ")
				.append(" inner join common_goods cg on cg.goods_common_id=gd.common_goods_id ")
				.append(" where msg.goods_type=6 and cg.`status`=1 and msg.goods_destine_quota>0 ")
				.append(" and gd.`status`=1 and gd.is_normal=3 ");
		if(pointId!=null&&!"".equals(pointId)){
			buffer.append(" and msg.service_point_id =:pointId");
			param.put("pointId", pointId);
		}
		List<Object[]> rtnList = commonDao.queryBySql(buffer.toString(), param);
		
		return rtnList;
	}
	
}
