package com.zhengke.business.service;

import java.util.List;

import com.zhengke.common.pojo.HelpCenter;
import com.zhengke.common.pojo.HelpDetail;



public interface HelpService {
	
	/**
	 * 查询帮助列表
	 * @return
	 */
	List<HelpCenter> queryBrandList();
	
	/**
	 * 查询帮助详情
	 * @param helpId
	 * @return
	 */
	List<HelpDetail> findHelpDetail(String helpId);
}
