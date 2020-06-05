package com.zhengke.service.sysmgr;

import java.util.List;
import java.util.Map;

import com.zhengke.common.object.Result;
import com.zhengke.pojo.SysPopedom;



public interface XTGL020Service {

	/**
	 * 查询用户权限
	 * @param param
	 * @return
	 * @throws Exception
	 */
	Result query(int page,int limit) throws Exception;
	
	/**
	 * 查询用户的菜单权�?
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> queryMenuPopedom() throws Exception;
	
	/**
	 * 添加�?个权限项
	 * @param param
	 * @return
	 * @throws Exception
	 */
	Integer savePopedom(SysPopedom sp) throws Exception;
	
	/**
	 * 修改�?个权限项
	 * @param sp
	 * @return
	 * @throws Exception
	 */
	Integer updPopedom(SysPopedom sp) throws Exception;
	
	/**
	 * 删除�?个权限项
	 * @param id
	 * @return
	 * @throws Exception
	 */
	Integer delPopedom(Integer id) throws Exception;
}
