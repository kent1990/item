package com.zhengke.dao;

import com.zhengke.pojo.SysDictionary;
import com.zhengke.pojo.SysDictionaryItem;

import java.util.List;

public interface SysDictionaryMapper {

	/**
	 * 查询数据字典父节点
	 * @return
	 */
	List<SysDictionary> selectMaster();
	

	/**
	 * 查询数据字典子节点
	 * @param pid
	 * @return
	 */
	List<SysDictionaryItem> selectSlave(String pid);
	
	
	
	
	
    int deleteByPrimaryKey(String dicId);

    int insert(SysDictionary record);

    int insertSelective(SysDictionary record);
    

    SysDictionary selectByPrimaryKey(String dicId);

    int updateByPrimaryKeySelective(SysDictionary record);

    int updateByPrimaryKey(SysDictionary record);
}