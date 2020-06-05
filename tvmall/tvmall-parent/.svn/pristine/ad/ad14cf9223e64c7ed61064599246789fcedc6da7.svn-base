package com.zhengke.service.sysmgr;

import java.util.List;
import java.util.Map;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import com.zhengke.common.object.Result;
import com.zhengke.pojo.SysRoleUser;
import com.zhengke.pojo.SysUser;

@Service
public class XTGL040ServiceImplConsumer implements XTGL040ServiceConsumer {

	
	@Reference
	private XTGL040Service service;

	/**
	 * 查询所有用户
	 */
	@Override
	public Result query(Map<String, Object> param,int page,int limit) throws Exception {
		return service.query(param, page, limit);
	}

	/**
	 * 保存一个用户
	 */
	@Override
	public void saveSysUser(SysUser su) throws Exception {
		service.saveSysUser(su);
	}

	/**
	 * 删除用户，可批量操作
	 */
	@Override
	public void delSysUser(String sid) throws Exception {
		service.delSysUser(sid);
	}

	/**
	 * 修改用户
	 */
	@Override
	public void updSysUser(SysUser su) throws Exception {
		service.updSysUser(su);
	}

	/**
	 * 获取所有角色
	 */
	@Override
	public List<Map<String, Object>> queryRoles(String id) throws Exception {
		return service.queryRoles(id); 
	}

	/**
	 * 保存角色
	 */
	@Override
	public void saveRoleUser(List<SysRoleUser> param, Integer id) throws Exception {
		service.saveRoleUser(param, id);
	}

	/**
	 * 修改密码
	 */
	@Override
	public void updUserPass(Map<String, Object> param) throws Exception {
		service.updUserPass(param);
	}
	
	/**
	 * 保存用户
	 */
	@Override
	public void saveSysUserMap(Map<String, Object> map) throws Exception {
		service.saveSysUserMap(map);
	}

	@Override
	public void updSysUserMap(Map<String, Object> map) throws Exception {
		service.updSysUserMap(map);
	}
	
	/**
	 * 根据学员id查询学员权限列表
	 * @param user_id
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> findStuPopedomList(String user_id)
			throws Exception {
		return service.findStuPopedomList(user_id);
	}
	
	/**
	 * 保存学员权限信息
	 * @param list
	 * @param parseInt
	 * @throws Exception
	 */
	@Override
	public void saveStuPopedom(List<Map<String, Object>> list, int user_id)
			throws Exception {
	 service.saveStuPopedom(list, user_id);
	}
	
}
