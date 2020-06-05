package com.zhengke.service.sysmgr;

import java.util.List;
import java.util.Map;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import com.zhengke.common.object.Result;
import com.zhengke.pojo.SysMenu;

@Service
public class XTGL010ServiceImplConsumer implements XTGL010ServiceConsumer {

	/* @Resource CommonDao commonDao; */
	@Reference
	private XTGL010Service service;
	
	@Override
    public Result query(int page,int limit) throws Exception {
    	return service.query(page, limit);      
    }

	@Override
    public List<Map<String, Object>> querySelect() throws Exception {
        return service.querySelect();
    }

	@Override
    public void addMenu(SysMenu sm) throws Exception {       
        service.addMenu(sm);
    }

    @Override
    public void updMenu(SysMenu sm) throws Exception {
       service.updMenu(sm);
    }

    @Override
    public void delMenu(String menuId) throws Exception {
       service.delMenu(menuId);
    }
}
