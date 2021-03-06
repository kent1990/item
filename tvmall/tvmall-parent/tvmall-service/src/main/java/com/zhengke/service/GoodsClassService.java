package com.zhengke.service;

import java.util.List;

import com.zhengke.common.object.ZTreeNode;
import com.zhengke.pojo.MallGoodsClass;

public interface GoodsClassService {
	
	/**
	 * 查询一级分类
	 * @return
	 */
	List<ZTreeNode> queryParent(String gcParentId);
	
	/**
	 * 根据id查询
	 * @param gcId
	 * @return
	 */
	MallGoodsClass queryById(Integer gcId);
	
    /**
     * 根据主键id删除商品分类信息
     * @param gcId
     * @return
     */
	int deleteById(Integer gcId);
	
	/**
	 * 新增商品分类
	 * @param mgc
	 */
	int insert(MallGoodsClass mgc);
	
	/**
	 * 更新商品分类
	 * @param mgc
	 */
	int update(MallGoodsClass mgc);
	
	/**
	 * 查询是否存在子级分类
	 * @param gcId
	 * @return
	 */
	boolean isExistsChild(String gcId);
	
}
