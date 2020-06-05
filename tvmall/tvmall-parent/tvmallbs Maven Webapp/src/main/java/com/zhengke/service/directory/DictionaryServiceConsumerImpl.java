package com.zhengke.service.directory;

import java.util.List;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import com.zhengke.common.object.ZTreeNode;

@Service
public class DictionaryServiceConsumerImpl implements DictionaryServiceConsumer {

	// @Autowired
	 //private SysDictionaryMapper dao;
	@Reference
	private  DictionaryService  dao;
	
	@Override
	public List<ZTreeNode> queryMasterNodes() {
		return dao.queryMasterNodes();
	}

	@Override
	public List<ZTreeNode> querySlaveNodes(String pid) {
		return dao.querySlaveNodes(pid);
	}
}
