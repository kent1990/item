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


@Service @Transactional
public class SalesServiceImpl implements SalesService {
	@Resource CommonDao commonDao;
	
	/**
	 * 查询销售排行商品
	 * @return
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Object[]> querySalesList(String pointId,String type) {
		StringBuffer buffer = new StringBuffer();
		Map<String,String> param = new HashMap<String,String>();
		buffer.append("select mg.goods_common_id,mg.goods_name,mg.common_price,mg.thumb_picPath,msg.goods_type,a.num ")
				.append(" from mall_service_goods msg inner join common_goods mg on msg.goods_id=mg.goods_common_id ")
				.append(" left join (select sum(tog.goods_num) num,tog.goods_id from tv_order_goods tog ")
				.append(" inner join tv_order tod on tod.order_id=tog.order_id ");
		if("0".equals(type)){
			buffer.append(" where tog.state='1' group by tog.goods_id) a on mg.goods_common_id=a.goods_id ");
		}
		if("1".equals(type)){
			buffer.append(" where tog.state='1' and substring(tod.finish_time,6,2)= month(now())")
					.append(" group by tog.goods_id) a on mg.goods_common_id=a.goods_id ");
		}
		if("2".equals(type)){
			buffer.append(" where tog.state='1' and (date_format(tod.finish_time,'%Y-%m-%d'))>= ")
					.append(" (select date_sub(curdate(),INTERVAL WEEKDAY(curdate()) + 1 DAY)) ")
					.append(" group by tog.goods_id) a on mg.goods_common_id=a.goods_id ");
		}
		buffer.append(" where mg.`status`='1' and msg.goods_destine_quota >'0' and msg.goods_type<6 ");
		
		if(pointId!=null&&!"".equals(pointId)){
			buffer.append(" and msg.service_point_id =:pointId");
			param.put("pointId", pointId);
		}
		
		buffer.append(" order by a.num desc ");
		List<Object[]> rtnList = commonDao.queryBySql(buffer.toString(), param);
		
		return rtnList;
	}
	
	/**
	 * 查询后台设置排序方式
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<SysDictionaryItem> findDicItem() {
		StringBuffer buffer = new StringBuffer();
		Map<String,String> param = new HashMap<String,String>();
		buffer.append("from SysDictionaryItem where dicId=0004 and isSet=1 ");
		
		List<SysDictionaryItem> rtnList = (List<SysDictionaryItem>) commonDao.queryByHql(buffer.toString(), param);
		
		return rtnList;
	}
	
	/**
	 * 查询销售排行商品(手动设置排序)
	 * @return
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Object[]> querySalesList2(String pointId) {
		StringBuffer buffer = new StringBuffer();
		Map<String,String> param = new HashMap<String,String>();
		buffer.append("select mg.goods_common_id,mg.goods_name,mg.common_price,mg.thumb_picPath,msg.goods_type ")
				.append(" from mall_service_goods msg inner join common_goods mg on msg.goods_id=mg.goods_common_id ")
				.append(" where mg.`status`='1' and msg.goods_destine_quota >'0' and msg.goods_type<6 ");
		
		if(pointId!=null&&!"".equals(pointId)){
			buffer.append(" and msg.service_point_id =:pointId");
			param.put("pointId", pointId);
		}
		
		List<Object[]> rtnList = commonDao.queryBySql(buffer.toString(), param);
		
		return rtnList;
	}

	@Override
	public List<Object[]> querySalesList3() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("select rs.id,rs.goods_id from rank_setting rs ");
		
		List<Object[]> rtnList = commonDao.queryBySql(buffer.toString(), null);
		
		return rtnList;
	}
	
}
