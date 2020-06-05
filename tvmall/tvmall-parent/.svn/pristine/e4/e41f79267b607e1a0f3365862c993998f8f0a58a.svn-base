package com.zhengke.common.service;

import java.util.List;

import com.zhengke.common.pojo.SysDictionaryItem;
import com.zhengke.common.pojo.TvOrder;

public interface CommonService {

	/**
	 * 根据给定的标识符返回给定的实体类的持久化实例，如果持久化实例不存在返回NULL
	 * 
	 * @param c
	 *            实体类的class属性
	 * @param id
	 *            实体类的标识符，一般对应数据表中的主键
	 * @return 返回一个实体类对象
	 */
	Object getByID(Class<?> c,String id) ;
	
	/**
	 * （重载）根据给定的标识符返回给定的实体类的持久化实例，如果持久化实例不存在返回NULL
	 * 
	 * @param c
	 *            实体类的class属性
	 * @param id
	 *            实体类的标识符，一般对应数据表中的主键
	 * @return 返回一个实体类对象
	 */
	Object getByID(Class<?> c,int id);	
	
	/**
	 * 查询登录验证码
	 * @param memberId
	 * @return
	 */
	String queryLoginRandomMa(String memberId);
	
	/**
	 * 根据服务点id查询服务点名称
	 * @param stationId
	 * @return
	 */
	String queryServiceStationName(int stationId);
	
	/**
	 * 根据数据字典id查询数据字典项
	 * @param dicId
	 * @return
	 */
	List<SysDictionaryItem> queryDicItemByDicId(String dicId);
	
	/**
	 * 根据数据字典项id查询参数值
	 * @param itemId
	 * @return
	 */
	String queryParamValueByItemId(String itemId);
	
	/**
	 * 查询已配货和已发货订单
	 * @param userId
	 * @return
	 */
	List<TvOrder> findOrderList(String userId);
	
	/**
	 * 保存新增对象
	 */
	void sava(Object obj);
}
