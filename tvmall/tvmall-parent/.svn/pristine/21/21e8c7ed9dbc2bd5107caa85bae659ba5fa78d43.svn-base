package com.zhengke.service;

import java.util.List;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import com.zhengke.common.object.ZTreeNode;
import com.zhengke.pojo.MallGoodsClass;

@Service 
public class GoodsClassServiceImplConsumer implements GoodsClassServiceConsumer  {
	

	@Reference
	private GoodsClassService service;

	@Override
	public List<ZTreeNode> queryParent(String gcParentId) {
		return service.queryParent(gcParentId);
	}
	
	@Override
	public MallGoodsClass queryById(Integer gcId) {
		return service.queryById(gcId);
	}
	
	@Override
	public int deleteById(Integer gcId) {
		return service.deleteById(gcId);
	}

	@Override
	public int insert(MallGoodsClass mgc) {
		return service.insert(mgc);
	}

	@Override
	public int update(MallGoodsClass mgc) {
		return service.update(mgc);
	}

	@Override
	public boolean isExistsChild(String gcId) {
		return false;
	}	
}