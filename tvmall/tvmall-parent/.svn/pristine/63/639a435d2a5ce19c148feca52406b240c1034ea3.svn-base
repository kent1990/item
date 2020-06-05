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
public class BrandServiceImpl implements BrandService {
	@Resource CommonDao commonDao;
	
	/**
	 * 查询品牌列表
	 * @return
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Object[]> queryBrandList() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("select ms.supplier_id,ms.supplier_name,mgb.brand_pic from mall_supplier ms ")
				.append("left join mall_goods_brand mgb on ms.supplier_id=mgb.brand_id where ms.supplier_status=1 order by ms.sort desc ");
		
		List<Object[]> rtnList = commonDao.queryBySql(buffer.toString(), null);
		
		return rtnList;
	}
	
	/**
	 * 查询品牌商品列表
	 * @param brandId
	 * @return
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Object[]> queryBrandGoodList(String brandId,String pointId) {
		StringBuffer buffer = new StringBuffer();
		Map<String,String> param = new HashMap<String,String>();
		buffer.append("select cg.goods_common_id,cg.goods_name,cg.common_price,cg.thumb_picPath,cg.type from mall_service_goods msg ")
				.append("inner join common_goods cg on msg.goods_id=cg.goods_common_id ")
				.append(" where msg.goods_type=0 and msg.goods_destine_quota>0 and cg.`status`=1 ");
		if(brandId!=null&&!"".equals(brandId)){
			buffer.append(" and cg.brand_id =:brandId");
			param.put("brandId", brandId);
		}
		if(pointId!=null&&!"".equals(pointId)){
			buffer.append(" and msg.service_point_id =:pointId");
			param.put("pointId", pointId);
		}
		
		List<Object[]> rtnList = commonDao.queryBySql(buffer.toString(), param);
		
		return rtnList;
	}
	
}
