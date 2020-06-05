package com.zhengke.dao;

import java.util.List;


import com.zhengke.pojo.MallGoodsClass;


public interface MallGoodsClassDao {
	
	/**
	 * 查询商品分类的父级节点
	 * @return
	 */
	List<MallGoodsClass> queryParent(String gcParentId);
	
	/**
	 * 根据id查询商品分类信息
	 * @param gcId
	 * @return
	 */
	MallGoodsClass selectById(Integer gcId);
	
    /**
     * 根据id删除商品分类信息
     * @param gcId
     * @return
     */
    int deleteById(Integer gcId);
    
    /**
     * 更新商品分类信息
     * @param mgc
     * @return
     */
    int update(MallGoodsClass mgc);
    
    
    /**
     * 新增商品分类
     * @param record
     * @return
     */
    int insertSelective(MallGoodsClass record); 


}