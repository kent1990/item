package com.zhengke.service.sysmgr;

import java.util.List;
import java.util.Map;

import com.zhengke.common.object.Result;
import com.zhengke.pojo.SysRoleUser;
import com.zhengke.pojo.SysUser;



public interface XTGL040Service {

	/**
	 * 查询�?有用�?
	 * @return
	 * @throws Exception
	 */
	Result query(Map<String, Object> param,int page,int limit) throws Exception;
	
	/**
	 * 保存用户
	 * @param su
	 * @throws Exception
	 */
	void saveSysUser(SysUser su) throws Exception;
	
	/**
	 * 删除用户，可批量操作
	 * @param sid
	 * @throws Exception
	 */
	void delSysUser(String sid) throws Exception;
	
	/**
	 * 修改用户
	 * @param su
	 * @throws Exception
	 */
	void updSysUser(SysUser su) throws Exception;
	
	/**
	 * 获取全部角色
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> queryRoles(String id) throws Exception;
	
	/**
	 * 保存角色
	 * @param param
	 * @throws Exception
	 */
	void saveRoleUser(List<SysRoleUser> param, Integer id) throws Exception;
	
	/**
	 * 修改用户密码
	 * @param param
	 * @throws Exception
	 */
	void updUserPass(Map<String, Object> param) throws Exception;

	/**
	 * 保存用户
	 * @param map
	 * @throws Exception 
	 */
	void saveSysUserMap(Map<String, Object> map) throws Exception;
    
	/**
	 * 修改用户信息
	 * @param map
	 * @throws Exception 
	 */
	void updSysUserMap(Map<String, Object> map) throws Exception;
	
	/**
	 * 根据学员id查询学员权限列表
	 * @param user_id
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> findStuPopedomList(String user_id) throws Exception;
	
	/**
	 * 保存学员权限信息
	 * @param list
	 * @param parseInt
	 * @throws Exception
	 */
	void saveStuPopedom(List<Map<String, Object>> list, int parseInt) throws Exception;
	
}
