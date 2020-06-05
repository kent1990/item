package com.zhengke.service.sysmgr;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.dubbo.config.annotation.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhengke.common.dao.CommonDao;
import com.zhengke.common.object.Result;
import com.zhengke.pojo.SysPopedom;

@Service(dynamic=true)
public class XTGL020ServiceImpl implements XTGL020Service {

	@Resource
	private CommonDao commonDao;

	/**
	 * 查询用户权限
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Result query(int page,int limit) throws Exception {
		PageHelper.startPage(page, limit, true);
		List<Map<String, Object>> list = (List<Map<String, Object>>) commonDao.findForList("xtgl020Mapper.queryPopedom", null);
		PageInfo<Map<String,Object>> pageInfo = new PageInfo<Map<String,Object>>(list);
		Result rs = new Result();
		rs.setCode("0");
		rs.setCount(pageInfo.getTotal());
        rs.setData(list);		
		return rs;
	}

	/**
	 * 查询用户的菜单权�?
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> queryMenuPopedom() throws Exception {
		List<Map<String, Object>> list = (List<Map<String, Object>>) commonDao.findForList("xtgl020Mapper.queryMenuPopedom", null);
		for (Map<String, Object> map : list) {
			String itemName = map.get("item_name").toString();
			Integer length = map.get("menu_id").toString().length();
			for(int i = 0;i < length / 2;i++){
				itemName = "&nbsp;&nbsp;&nbsp;├&nbsp;&nbsp;" + itemName;
			}
			map.put("item_name", itemName);
		}
		return list;
	}

	/**
	 * 添加�?个权限项
	 */
	@Override
	public Integer savePopedom(SysPopedom sp) throws Exception {
		
		// 保存�?条记�?
		Integer i = (Integer) commonDao.save("xtgl020Mapper.savePopedom", sp);
		
		return i;
	}

	/**
	 * 修改�?个权限项
	 */
	@Override
	public Integer updPopedom(SysPopedom sp) throws Exception {
		Integer i = (Integer) commonDao.update("xtgl020Mapper.updatePopedom", sp);
		return i;
	}

	/**
	 * 删除�?个权限项
	 */
	@Override
	public Integer delPopedom(Integer id) throws Exception {
		Integer i = (Integer) commonDao.delete("xtgl020Mapper.deletePopedom", id);
		return i;
	}
	
}
