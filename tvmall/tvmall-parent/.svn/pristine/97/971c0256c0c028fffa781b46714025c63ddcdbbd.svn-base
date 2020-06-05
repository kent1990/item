package com.zhengke.service.sysmgr;

import java.util.List;
import java.util.Map;

import com.zhengke.common.object.Result;
import com.zhengke.common.object.ZTreeNode;
import com.zhengke.pojo.SysRoleRights;
import com.zhengke.pojo.SysRoles;


public interface XTGL030ServiceConsumer {

	/**
	 * 查询角色数据
	 * @return
	 * @throws Exception
	 */
	Result query(int page,int limit) throws Exception;
	
	/**
	 * 添加�?个角�?
	 * @param sr
	 * @return
	 * @throws Exception
	 */
	Integer saveRole(SysRoles sr) throws Exception; 
	
	/**
	 * 修改角色
	 * @param sr
	 * @return
	 * @throws Exception
	 */
	Integer updRole(SysRoles sr) throws Exception;
	
	/**
	 * 删除角色
	 * @return
	 * @throws Exception
	 */
	Integer delRoles(Integer id) throws Exception;
	
	/**
	 * 取权限信�?
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	List<ZTreeNode> createTree(String roleId) throws Exception;
	
	/**
	 * 保存权限信息
	 * @param id
	 * @param popedom
	 * @return
	 * @throws Exception
	 */
	void savePopedomRoles(Integer id, List<SysRoleRights> list) throws Exception;
	
	/**
	 * 查询所有拥有当前角色的用户信息
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	List<Map<String,Object>> queryRoleUser(String roleId) throws Exception;
}
