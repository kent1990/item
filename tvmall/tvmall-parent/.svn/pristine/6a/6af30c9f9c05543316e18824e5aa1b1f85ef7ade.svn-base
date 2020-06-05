package com.zhengke.service.directory;

import java.util.ArrayList;
import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.zhengke.common.object.ZTreeNode;
import com.zhengke.dao.SysDictionaryMapper;
import com.zhengke.pojo.SysDictionary;
import com.zhengke.pojo.SysDictionaryItem;

@Service(dynamic=true)
public class DictionaryServiceImpl implements DictionaryService {

	 @Autowired
	 private SysDictionaryMapper dao;
	
	@Override
	public List<ZTreeNode> queryMasterNodes() {
		List<SysDictionary> list = dao.selectMaster();
		List<ZTreeNode> rtnList = new ArrayList<ZTreeNode>();
		for(SysDictionary dict : list) {
			ZTreeNode node = new ZTreeNode();
			node.setId(dict.getDicId());
			node.setName(dict.getDicName());
			node.setIsParent(true);
			rtnList.add(node);
		}		
		return rtnList;
	}

	@Override
	public List<ZTreeNode> querySlaveNodes(String pid) {
		List<SysDictionaryItem> list = dao.selectSlave(pid);
		List<ZTreeNode> rtnList = new ArrayList<ZTreeNode>();
		for(SysDictionaryItem item : list) {
			ZTreeNode node = new ZTreeNode();
			node.setId(item.getItemId());
			node.setName(item.getParamName());
			node.setIsParent(false);
			rtnList.add(node);
		}		
		return rtnList;
	}
	
	

}
