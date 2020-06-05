package com.zhengke.service.sysmgr;

import java.util.List;
import java.util.Map;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import com.zhengke.common.object.Result;
import com.zhengke.pojo.SysPopedom;


@Service
public class XTGL020ServiceImplConsumer implements XTGL020ServiceConsumer {

	/*
	 * @Resource private CommonDao commonDao;
	 */
	@Reference
	private XTGL020Service service;
	/**
	 * 查询用户权限
	 */
	@Override
	public Result query(int page,int limit) throws Exception {
		return service.query(page, limit);
	}

	/**
	 * 查询用户的菜单权�?
	 */
	@Override
	public List<Map<String, Object>> queryMenuPopedom() throws Exception {
		return service.queryMenuPopedom();
	}

	/**
	 * 添加�?个权限项
	 */
	@Override
	public Integer savePopedom(SysPopedom sp) throws Exception {
		return service.savePopedom(sp);
	}

	/**
	 * 修改�?个权限项
	 */
	@Override
	public Integer updPopedom(SysPopedom sp) throws Exception {
		return service.updPopedom(sp);
	}

	/**
	 * 删除�?个权限项
	 */
	@Override
	public Integer delPopedom(Integer id) throws Exception {
		return service.delPopedom(id);
	}
	
}
