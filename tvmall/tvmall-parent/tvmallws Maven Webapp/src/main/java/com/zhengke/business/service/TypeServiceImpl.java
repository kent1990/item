package com.zhengke.business.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zhengke.common.dao.CommonDao;
import com.zhengke.common.pojo.MallGoodsClass;


@Service @Transactional
public class TypeServiceImpl implements TypeService {
	@Resource CommonDao commonDao;
	
	/**
	 * 查询分类列表
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<MallGoodsClass> queryTypeList() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" from MallGoodsClass where gcParentId ='0' order by gcId desc ");
		
		List<MallGoodsClass> rtnList = (List<MallGoodsClass>)commonDao.queryByHql(buffer.toString(), null);
		
		return rtnList;
	}
	
	/**
	 * 查询分类商品列表
	 * @param brandId
	 * @return
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Object[]> queryTypeGoodList(String typeId,String pointId) {
		StringBuffer buffer = new StringBuffer();
		Map<String,String> param = new HashMap<String,String>();
		
		buffer.append("select cg.goods_common_id,cg.goods_name,cg.common_price,cg.thumb_picPath,cg.type from mall_service_goods msg ")
		.append("inner join common_goods cg on msg.goods_id=cg.goods_common_id ")
		.append(" where msg.goods_type=0 and msg.goods_destine_quota>0 and cg.status=1 ");
		if(typeId!=null&&!"".equals(typeId)){
			buffer.append(" and cg.gc_id1 =:typeId");
			param.put("typeId", typeId);
		}
		if(pointId!=null&&!"".equals(pointId)){
			buffer.append(" and msg.service_point_id =:pointId");
			param.put("pointId", pointId);
		}
		
		List<Object[]> rtnList = commonDao.queryBySql(buffer.toString(), param);
		
		return rtnList;
	}
	
}
