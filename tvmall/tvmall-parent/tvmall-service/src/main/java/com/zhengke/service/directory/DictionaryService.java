package com.zhengke.service.directory;

import java.util.List;

import com.zhengke.common.object.ZTreeNode;

/*********************************************
 *                                           *
 * 										     *
 * @author xuejy                             *
 * writed by xuejy @20191216 9:28            *
 *                                           *
 *********************************************/

public interface DictionaryService {
    
	/**
	 * 查询数据字典父级节点
	 * @return
	 */
	public List<ZTreeNode> queryMasterNodes();
	
	/**
	 * 查询数据字典子级节点
	 * @return
	 */
	public List<ZTreeNode> querySlaveNodes(String pid);

}
