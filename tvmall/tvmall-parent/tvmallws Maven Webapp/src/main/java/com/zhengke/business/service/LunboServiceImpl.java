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
public class LunboServiceImpl implements LunboService {
	@Resource CommonDao commonDao;
	
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Object[]> query(String pointId) {
		StringBuffer buffer = new StringBuffer();
		Map<String,String> param = new HashMap<String,String>();
		buffer.append("select mg.goods_common_id,mg.goods_name,mg.common_price,mg.thumb_picPath,msg.goods_type ")
		.append(" from mall_service_goods msg inner join common_goods mg on msg.goods_id=mg.goods_common_id ");
		buffer.append(" where mg.`status`='1' and msg.goods_destine_quota >'0' and msg.goods_type<6 ");
		
		if(pointId!=null&&!"".equals(pointId)){
			buffer.append(" and msg.service_point_id =:pointId");
			param.put("pointId", pointId);
		}
		List<Object[]> rtnList = commonDao.queryBySql(buffer.toString(), param);
		
		return rtnList;
	}

}
