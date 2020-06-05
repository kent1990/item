package com.zhengke.business.service.home;

import java.util.List;

import com.zhengke.common.pojo.IndexPic;
import com.zhengke.common.pojo.ReturnVisit;
import com.zhengke.common.pojo.TvUser;

public interface HomeService {

	/**
	 * 根据tvnNo查询系统中的电视用户信息
	 * @return
	 */
	TvUser queryUser(String tvnNo);
	
	/**
	 * 查询首页图片
	 * @return
	 */
	List<IndexPic> queryIndexPics(String proviceId,String cityId
			,String servicePointId,String picId);
	
	/**
	 * 生成回访记录
	 */
	void save(ReturnVisit rv);
}
