package com.zhengke.service;

import java.util.List;
import java.util.Map;

import com.zhengke.pojo.SysUser;

public interface LoginServiceConsumer {

	
	/**
	 *  查询用户信息
	 * @param loginName
	 * @return
	 * @throws Exception
	 */
	public SysUser querySysUser(String loginName)throws Exception;
	
	/**
	 *  更新用户
	 * @param su
	 * @return
	 * @throws Exception
	 */
	public int updateSysUser(SysUser su) throws Exception;
	
	/**
	 * 查询菜单信息
	 * @return
	 * @throws Exception
	 */
	public List<Object> queryMenu() throws Exception;
	
	/**
	 * 查询用户权限
	 * @return
	 * @throws Exception
	 */
	Map<String,String> queryPopedom(String userId,boolean isSuperAdmin) throws Exception;
	
}
