package com.zhengke.common.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zhengke.common.dao.CommonDao;
import com.zhengke.common.pojo.SysArea;
import com.zhengke.common.pojo.SysDictionaryItem;
import com.zhengke.common.pojo.TvOrder;

@Service  @Transactional
public class CommonServiceImpl implements CommonService {
 
	@Resource CommonDao commonDao;

	/**
	 * 根据给定的标识符返回给定的实体类的持久化实例，如果持久化实例不存在返回NULL
	 * 
	 * @param c
	 *            实体类的class属性
	 * @param id
	 *            实体类的标识符，一般对应数据表中的主键
	 * @return 返回一个实体类对象
	 */
	@Override
	public Object getByID(Class<?> c, String id) {
		return commonDao.getByID(c, id);
	}
	
	/**
	 * （重载）根据给定的标识符返回给定的实体类的持久化实例，如果持久化实例不存在返回NULL
	 * 
	 * @param c
	 *            实体类的class属性
	 * @param id
	 *            实体类的标识符，一般对应数据表中的主键
	 * @return 返回一个实体类对象
	 */
	@Override
	public Object getByID(Class<?> c, int id) {
		return commonDao.getByID(c, id);
	}

	/**
	 * 查询登录验证码
	 */
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public String queryLoginRandomMa(String memberId) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select loginRandomMa from members where id="+memberId);
		String loginRandomMa = commonDao.queryOneColBySql(buffer.toString(), null);
		
		return loginRandomMa;
	}

	/**
	 * 根据服务点id查询服务点名称
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public String queryServiceStationName(int stationId) {
		SysArea sa = (SysArea)commonDao.getByID(SysArea.class, stationId);
		if(sa!=null)
			return sa.getAreaName();
		return "";
	}

	/**
	 * 根据数据字典id查询数据字典项
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<SysDictionaryItem> queryDicItemByDicId(String dicId) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" from SysDictionaryItem where dicId='"+dicId+"' and status=1 and idSelected=1");
		List<SysDictionaryItem> rtnList = (List<SysDictionaryItem>)commonDao.queryByHql(buffer.toString(), null);
		return rtnList;
	}
	
	/**
	 * 根据数据字典项id查询参数值
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public String queryParamValueByItemId(String itemId) {
		if(itemId==""||itemId==null)
			return null;
		SysDictionaryItem dicItem = (SysDictionaryItem)commonDao.getByID(SysDictionaryItem.class, itemId);
		if(dicItem!=null)
			return dicItem.getParamValue();		
		return null;
	}

	/**
	 * 查询已配货和已发货订单
	 * @param userId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<TvOrder> findOrderList(String userId) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" from TvOrder where userId='"+userId+"' and orderState>=30 and orderState<=40 ");
		List<TvOrder> rtnList = (List<TvOrder>)commonDao.queryByHql(buffer.toString(), null);
		return rtnList;
	}
	
	/**
	 * 保存新增对象
	 */
	@Override
	public void sava(Object obj) {
		if(obj!=null)
			commonDao.save(obj);
	}
}
