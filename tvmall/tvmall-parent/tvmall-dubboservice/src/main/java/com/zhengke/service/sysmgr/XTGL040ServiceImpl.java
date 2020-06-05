package com.zhengke.service.sysmgr;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.dubbo.config.annotation.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhengke.common.dao.CommonDao;
import com.zhengke.common.object.Result;
import com.zhengke.pojo.SysRoleUser;
import com.zhengke.pojo.SysUser;

@Service(dynamic=true)
public class XTGL040ServiceImpl implements XTGL040Service {

	@Resource
	private CommonDao commonDao;

	/**
	 * 查询所有用户
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Result query(Map<String, Object> param,int page,int limit) throws Exception {
		PageHelper.startPage(page, limit, true);
		List<Map<String, Object>> list = (List<Map<String, Object>>) commonDao.findForList("xtgl040Mapper.queryUser", param);
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);
        Result rs = new Result();
        rs.setCode("0");
        rs.setMsg("成功!");
        rs.setCount(pageInfo.getTotal());
        rs.setData(list);
		return rs;
	}

	/**
	 * 保存一个用户
	 */
	@Override
	public void saveSysUser(SysUser su) throws Exception {
		Integer j = (Integer) commonDao.findForObject("xtgl040Mapper.saveQueryCount", su.getLoginName());
		if(j > 0){
			throw new Exception("此用户名已被占用");
		}
		
		Integer i = (Integer) commonDao.save("xtgl040Mapper.saveSysUser", su);
		if(i <= 0){
			throw new Exception("添加失败");
		}
	}

	/**
	 * 删除用户，可批量操作
	 */
	@Override
	public void delSysUser(String sid) throws Exception {
		String[] id = sid.split(",");
		
		commonDao.delete("xtgl040Mapper.deleteSysUser", id);
	}

	/**
	 * 修改用户
	 */
	@Override
	public void updSysUser(SysUser su) throws Exception {
		Integer j = (Integer) commonDao.findForObject("xtgl040Mapper.saveQueryCount", su.getLoginName());
		if(j > 1){
			throw new Exception("此用户名已被占用");
		}
		
		commonDao.update("xtgl040Mapper.updateSysUser", su);
	}

	/**
	 * 获取所有角色
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> queryRoles(String id) throws Exception {
		// 查询所以权限
		List<Map<String, Object>> data = (List<Map<String, Object>>) commonDao.findForList("xtgl040Mapper.queryRoles", null);
		
		// 查询本用户所拥有的角色
		List<Map<String, Object>> list = (List<Map<String, Object>>) commonDao.findForList("xtgl040Mapper.queryRoleByUser", id);
		
		for (Map<String, Object> map : data) {
			for(Map<String, Object> map1 : list){
				if(Integer.parseInt(map1.get("role_id").toString()) == Integer.parseInt(map.get("role_id").toString())){
					map.put("istrue", true);
					break;
				}
			}
		}
		return data;
	}

	/**
	 * 保存角色
	 */
	@Override
	public void saveRoleUser(List<SysRoleUser> param, Integer id) throws Exception {
		// 删除之前的角色
		commonDao.delete("xtgl040Mapper.deleteRolesUser", id);
		
		// 保存现有的角色
		if(param.size() > 0){
			commonDao.save("xtgl040Mapper.saveRolesUser", param);
		}
	}

	/**
	 * 修改密码
	 */
	@Override
	public void updUserPass(Map<String, Object> param) throws Exception {
		Integer i = (Integer) commonDao.update("xtgl040Mapper.updateUserPass", param);
		if(i <= 0){
			throw new Exception("修改密码失败");
		}
		
	}
	
	/**
	 * 保存用户
	 */
	@Override
	public void saveSysUserMap(Map<String, Object> map) throws Exception {
		// TODO 保存用户
		Integer j = (Integer) commonDao.findForObject("xtgl040Mapper.saveQueryCount", map.get("login_name"));
		if(j > 0){
			//throw new MyException("此用户名已被占用!");
		}
		
		Integer k = (Integer) commonDao.findForObject("xtgl040Mapper.saveQueryCountByPhone", map.get("user_phone"));
		if(k > 0){
			//throw new MyException("此手机号已被占用!");
		}
		
		Integer i = (Integer) commonDao.save("xtgl040Mapper.saveSysUserMap", map);		
		if(i <= 0){
			//throw new MyException("添加失败!");
		}
	}

	@Override
	public void updSysUserMap(Map<String, Object> map) throws Exception {
		// TODO 修改用户信息
		Integer i = (Integer) commonDao.update("xtgl040Mapper.updateSysUserMap", map);
		Integer j = (Integer) commonDao.findForObject("xtgl040Mapper.saveQueryCount", map.get("login_name"));
		if(j > 1){
			//throw new MyException("此用户名已被占用!");
		}
		Integer k = (Integer) commonDao.findForObject("xtgl040Mapper.saveQueryCountByPhone", map.get("user_phone"));
		if(k > 1){
			//throw new MyException("此手机号已被占用!");
		}
		if(i <= 0){
			//throw new MyException("添加失败!");
		}
	}
	
	/**
	 * 根据学员id查询学员权限列表
	 * @param user_id
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> findStuPopedomList(String user_id)
			throws Exception {
		// 查询所有权限
		List<Map<String, Object>> data = (List<Map<String, Object>>) commonDao.findForList("xtgl040Mapper.findStuPopedomList", null);
		
		// 查询本用户所拥有的权限
		List<Map<String, Object>> list = (List<Map<String, Object>>) commonDao.findForList("xtgl040Mapper.findStuPopedomListByUserId", user_id);
		
		for (Map<String, Object> map : data) {
			for(Map<String, Object> map1 : list){
				if(Integer.parseInt(map1.get("popedom_id").toString()) == Integer.parseInt(map.get("id").toString())){
					map.put("istrue", true);
					break;
				}
			}
		}
		return data;
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
		//删除之前的权限
		commonDao.delete("xtgl040Mapper.deleteStuPopedom", user_id);
		
		//保存现在的权限
		if(list.size() > 0){
			commonDao.save("xtgl040Mapper.saveStuPopedom", list);
		}
	}
	
}
