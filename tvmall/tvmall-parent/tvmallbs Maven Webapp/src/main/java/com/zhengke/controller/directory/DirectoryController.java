package com.zhengke.controller.directory;

import java.util.List;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhengke.common.object.ZTreeNode;
import com.zhengke.controller.common.BaseController;
import com.zhengke.service.directory.DictionaryService;

@Controller
@RequestMapping("directory")
public class DirectoryController extends BaseController {
	
	@Reference
	private  DictionaryService  service;
   /**
          * 进入这个功能的controller
    * 
    */
	@RequestMapping("toDirectory.do")
	public String toDirectory() {
		return "directory/directoryMgr";
	}
	
	/**
	 * 生成字典树
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("tree.do")
	public List<ZTreeNode> tree(String id){
		List<ZTreeNode> list = null;
		try {
			if(id!=null) {
				list = service.querySlaveNodes(id);
				return list;
			}
			
		list = service.queryMasterNodes();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
}
