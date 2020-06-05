package com.zhengke.dao;

import com.zhengke.pojo.SysDictionaryItem;

public interface SysDictionaryItemMapper {

    int deleteByPrimaryKey(String itemId);

    int insert(SysDictionaryItem record);

    int insertSelective(SysDictionaryItem record);

  

    SysDictionaryItem selectByPrimaryKey(String itemId);

    
    int updateByPrimaryKeySelective(SysDictionaryItem record);

    int updateByPrimaryKey(SysDictionaryItem record);
}