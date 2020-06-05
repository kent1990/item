package com.zhengke.business.service;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zhengke.common.dao.CommonDao;
import com.zhengke.common.pojo.HelpCenter;
import com.zhengke.common.pojo.HelpDetail;


@Service @Transactional
public class HelpServiceImpl implements HelpService {
	@Resource CommonDao commonDao;
	
	/**
	 * 查询帮助列表
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<HelpCenter> queryBrandList() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" from HelpCenter ");
		
		List<HelpCenter> rtnList = (List<HelpCenter>)commonDao.queryByHql(buffer.toString(), null);
		
		return rtnList;
	}
	
	/**
	 * 查询帮助详情
	 * @param helpId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<HelpDetail> findHelpDetail(String helpId) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" from HelpDetail where helpId ='"+helpId+"' order by helpOrder asc");
		
		List<HelpDetail> rtnList = (List<HelpDetail>)commonDao.queryByHql(buffer.toString(), null);
		
		return rtnList;
	}
	
}
