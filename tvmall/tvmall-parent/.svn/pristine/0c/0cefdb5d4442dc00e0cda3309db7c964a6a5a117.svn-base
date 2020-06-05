package com.zhengke.service;

import java.util.List;
import java.util.Map;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import com.zhengke.pojo.SysUser;

@Service
public class LoginServiceImplConsumer implements LoginServiceConsumer{
    
	@Reference
	private LoginService service;
	
	@Override
	public SysUser querySysUser(String loginName)throws Exception {
		return service.querySysUser(loginName);
	}
	
	@Override
	public int updateSysUser(SysUser su) throws Exception {
		return service.updateSysUser(su);
	}

	@Override
	public List<Object> queryMenu() throws Exception {
		return service.queryMenu();
	}

	@Override
	public Map<String, String> queryPopedom(String userId,boolean isSuperAdmin) throws Exception {
	  return service.queryPopedom(userId, isSuperAdmin);
	}
}
