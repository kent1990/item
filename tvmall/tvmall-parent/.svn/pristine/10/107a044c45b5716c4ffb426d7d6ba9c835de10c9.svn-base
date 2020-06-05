package com.zhengke.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.zhengke.common.dao.CommonDao;
import com.zhengke.pojo.SysUser;


@Service(dynamic=true)
public class LoginServiceImpl implements LoginService{
    
	@Autowired
	private CommonDao dao;	
	
	@Override
	public SysUser querySysUser(String loginName)throws Exception {
		SysUser su = (SysUser)dao.findForObject("sysUserMapper.selectByLoginName", loginName);
		return su;
	}
	
	@Override
	public int updateSysUser(SysUser su) throws Exception {
		int rst  = dao.update("sysUserMapper.updateByPrimaryKeySelective", su);
		return rst;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> queryMenu() throws Exception {
		List<Object> rtnList = new ArrayList<Object>();
		List<Map<String, Object>> lev1 = (List<Map<String, Object>>) dao.findForList("loginMapper.queryMenu", 1);
		List<Map<String, Object>> lev2 = (List<Map<String, Object>>) dao.findForList("loginMapper.queryMenu", 2);
		List<Map<String, Object>> lev3 = (List<Map<String, Object>>) dao.findForList("loginMapper.queryMenu", 3);
		for (Map<String, Object> map1 : lev1) {
			Map<String, Object> data1 = new HashMap<String, Object>();
			data1.put("id", map1.get("menu_id"));
			data1.put("iconfont", map1.get("icon"));
			data1.put("name", map1.get("menu_name"));
			data1.put("url", map1.get("url"));
			List<Object> list1 = new ArrayList<Object>();
			for (Map<String, Object> map2 : lev2) {
				if(map1.get("menu_id").equals(map2.get("pmenu_id"))){
					Map<String, Object> data2 = new HashMap<String, Object>();
					data2.put("id", map2.get("menu_id"));
					data2.put("iconfont", map2.get("icon"));
					data2.put("name", map2.get("menu_name"));
					data2.put("url", map2.get("url"));
					List<Object> list2 = new ArrayList<Object>();
					for (Map<String, Object> map3 : lev3) {
						if(map2.get("menu_id").equals(map3.get("pmenu_id"))){
							Map<String, Object> data3 = new HashMap<String, Object>();
							data3.put("id", map3.get("menu_id"));
							data3.put("iconfont", map3.get("icon"));
							data3.put("name", map3.get("menu_name"));
							data3.put("url", map3.get("url"));
							list2.add(data3);
						}
					}
					data2.put("sub", list2);
					list1.add(data2);
				}
			}
			data1.put("sub", list1);
			rtnList.add(data1);
		}
		
		return rtnList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, String> queryPopedom(String userId,boolean isSuperAdmin) throws Exception {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		List<Map<String, Object>> list = new ArrayList<>();
		
		if(isSuperAdmin){
			list = (List<Map<String, Object>>) dao.findForList("loginMapper.queryAllPopedom", map);
		}else{
			list = (List<Map<String, Object>>) dao.findForList("loginMapper.queryPopedom", map);
		}
		
		Map<String,String> rtnMap = new Hashtable<String,String>();
		for(Map<String,Object> sp : list){
			rtnMap.put(sp.get("item_code")+"", "1");
		}
		return rtnMap;
	}
	
	

	
}
