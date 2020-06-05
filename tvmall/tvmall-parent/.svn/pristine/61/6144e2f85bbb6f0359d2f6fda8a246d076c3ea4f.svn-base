package com.zhengke.service.sysmgr;

import java.util.List;
import java.util.Map;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import com.zhengke.common.object.Result;
import com.zhengke.common.object.ZTreeNode;
import com.zhengke.pojo.SysRoleRights;
import com.zhengke.pojo.SysRoles;

@Service
public class XTGL030ServiceImplConsumer implements XTGL030ServiceConsumer {

	/*
	 * @Resource private CommonDao commonDao;
	 */
	@Reference
	private XTGL030Service service;
	/**
	 * 查询角色数据
	 */
	@Override
	public Result query(int page,int limit) throws Exception {
		return service.query(page, limit);
	}

	/**
	 * 添加角色
	 */
	@Override
	public Integer saveRole(SysRoles sr) throws Exception {
		return service.saveRole(sr);
	}

	/**
	 * 修改角色
	 */
	@Override
	public Integer updRole(SysRoles sr) throws Exception {
		return service.updRole(sr);
	}

	/**
	 * 删除角色
	 */
	@Override
	public Integer delRoles(Integer id) throws Exception {
		return service.delRoles(id);
	}

	/**
	 * 生成树状菜单
	 * 
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<ZTreeNode> createTree(String roleId) throws Exception {
		return service.createTree(roleId);
	}
	
	/**
	 * 保存权限信息
	 */
	@Override
	public void savePopedomRoles(Integer id, List<SysRoleRights> list)
			throws Exception {
		service.savePopedomRoles(id, list);

	}

	@Override
	public List<Map<String, Object>> queryRoleUser(String roleId) throws Exception {
		return service.queryRoleUser(roleId);
	}
}
