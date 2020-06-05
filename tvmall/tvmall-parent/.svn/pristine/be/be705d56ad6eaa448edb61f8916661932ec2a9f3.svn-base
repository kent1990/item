package com.zhengke.service.sysmgr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.dubbo.config.annotation.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhengke.common.dao.CommonDao;
import com.zhengke.common.object.Result;
import com.zhengke.common.object.ZTreeNode;
import com.zhengke.pojo.SysPopedom;
import com.zhengke.pojo.SysRoleRights;
import com.zhengke.pojo.SysRoles;

@Service(dynamic=true)
public class XTGL030ServiceImpl implements XTGL030Service {

	@Resource
	private CommonDao commonDao;

	/**
	 * 查询角色数据
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Result query(int page,int limit) throws Exception {
		PageHelper.startPage(page, limit, true);
		List<Map<String, Object>> data = (List<Map<String, Object>>) commonDao.findForList("xtgl030Mapper.queryRole", null);
		PageInfo<Map<String,Object>> pageInfo = new PageInfo<Map<String,Object>>(data);
		Result rs = new Result();
		rs.setCode("0");
		rs.setCount(pageInfo.getTotal());
		rs.setMsg("成功!");
		rs.setData(data);	
		return rs;
	}

	/**
	 * 添加角色
	 */
	@Override
	public Integer saveRole(SysRoles sr) throws Exception {
		return (Integer) commonDao.save("xtgl030Mapper.saveRoles", sr);
	}

	/**
	 * 修改角色
	 */
	@Override
	public Integer updRole(SysRoles sr) throws Exception {
		return (Integer) commonDao.update("xtgl030Mapper.updateRoles", sr);
	}

	/**
	 * 删除角色
	 */
	@Override
	public Integer delRoles(Integer id) throws Exception {
		return (Integer) commonDao.delete("xtgl030Mapper.deleteRoles", id);
	}

	/**
	 * 生成树状菜单
	 * 
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ZTreeNode> createTree(String roleId) throws Exception {
		// 查询菜单权限项表
		List<SysPopedom> listLev = (List<SysPopedom>) commonDao.findForList(
				"xtgl030Mapper.selectSysPopedom", null);

		List<ZTreeNode> rtnList = new ArrayList<ZTreeNode>();
		for (SysPopedom spp : listLev) {
			ZTreeNode item = new ZTreeNode(spp.getItemName(), spp.getId()
					.toString());

			Map<String, String> map = new HashMap<String, String>();
			map.put("popId", spp.getId().toString());
			map.put("roleId", roleId);
			int num = (int) commonDao.findForObject("xtgl030Mapper.selectnum1",	map);
			if (num > 0) // 查询角色是否拥有此权限
				item.setChecked(true);

			item.setIsParent(true);
			item.setOpen(true);
			// 查询二级菜单
			item.setChildren(createNodeLev1(spp.getMenuId().toString(), roleId));
			rtnList.add(item);
		}
		return rtnList;
	}

	/**
	 * 查询二级节点
	 * 
	 * @param menuId
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<ZTreeNode> createNodeLev1(String menuId, String roleId)
			throws Exception {
		// 查询二级菜单
		List<Map<String, Object>> listLev0 = (List<Map<String, Object>>) commonDao.findForList("xtgl030Mapper.selectmap1", menuId);

		List<ZTreeNode> rtnList = new ArrayList<ZTreeNode>();
		for (Map<String, Object> map : listLev0) {
			ZTreeNode item = new ZTreeNode(map.get("item_name").toString(), map
					.get("id").toString());

			map.put("popId", map.get("id"));
			map.put("roleId", roleId);
			int num = (int) commonDao.findForObject("xtgl030Mapper.selectnum1",map);
			if (num > 0) // 拥有权限在设置页面显示
				item.setChecked(true);
			item.setOpen(true); // 打开状态
			if (map.get("url") != null&& !"none".equals(map.get("url").toString())) {
				// 如果不是菜单 ，加上菜单功能项
				Map<String, Object> param = new HashMap<String, Object>();
				param.put("roleId", roleId);
				param.put("menuId", map.get("menu_id").toString());
				// 查询功能项
				List<Map<String, String>> ppList = (List<Map<String, String>>) commonDao.findForList("xtgl030Mapper.selectmap2", param);
				List<Map<String, Object>> mList = new ArrayList<Map<String, Object>>();
				for (Map<String, String> map1 : ppList) {
					Map<String, Object> ppMap = new HashMap<String, Object>();
					ppMap.put("id", map1.get("id"));
					ppMap.put("menuId", map1.get("menu_id"));
					ppMap.put("itemCode", map1.get("item_code"));
					ppMap.put("itemName", map1.get("item_name"));
					if (map1.get("checked") != null)
						ppMap.put("checked", map1.get("checked"));
					mList.add(ppMap);
				}
				item.setModel(mList);
			} else {
				// 是菜�? 查询
				item.setIsParent(true);
				item.setOpen(true);
				item.setChildren(createNodeLev2(map.get("menu_id").toString(),roleId));
				// 查询下级菜单
			}
			rtnList.add(item);
		}
		return rtnList;
	}

	/**
	 * 3级菜单查询
	 * 
	 * @param menuId
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<ZTreeNode> createNodeLev2(String menuId, String roleId)
			throws Exception {

		// 查询菜单
		List<Map<String, Object>> listLev0 = (List<Map<String, Object>>) commonDao.findForList("xtgl030Mapper.selectmap3", menuId);
		List<ZTreeNode> rtnList = new ArrayList<ZTreeNode>();
		for (Map<String, Object> map : listLev0) {
			ZTreeNode item = new ZTreeNode(map.get("item_name").toString(), map.get("id").toString());
			map.put("popId", map.get("id"));
			map.put("roleId", roleId);
			int num = (int) commonDao.findForObject("xtgl030Mapper.selectnum1",map);
			if (num > 0) // 如过有权追加选中
				item.setChecked(true);
			item.setOpen(true); // 打开状
			if (map.get("url") != null
					&& !"none".equals(map.get("url").toString())) {
				// 加上菜单功能项目
				Map<String, Object> param = new HashMap<String, Object>();
				param.put("roleId", roleId);
				param.put("menuId", map.get("menu_id")); // 查询功能
				List<Map<String, String>> ppList = (List<Map<String, String>>) commonDao.findForList("xtgl030Mapper.selectmap2", param);

				List<Map<String, Object>> mList = new ArrayList<Map<String, Object>>();
				for (Map<String, String> map1 : ppList) {

					Map<String, Object> ppMap = new HashMap<String, Object>();
					ppMap.put("id", map1.get("id"));
					ppMap.put("menuId", map1.get("menu_id"));
					ppMap.put("itemCode", map1.get("item_code"));
					ppMap.put("itemName", map1.get("item_name"));
					if (map1.get("checked") != null)
						ppMap.put("checked", map1.get("checked"));
					mList.add(ppMap);
				}
				item.setModel(mList);

			} else {
				// 如果是菜单 继续递归查询追加
				item.setIsParent(true);
				item.setOpen(true);
				item.setChildren(createNodeLev2(map.get("menu_id").toString(),roleId));
			}
			rtnList.add(item);
		}
		return rtnList;
	}

	/**
	 * 保存权限信息
	 */
	@Override
	public void savePopedomRoles(Integer id, List<SysRoleRights> list)
			throws Exception {
		// 删除已经有的id
		commonDao.delete("xtgl030Mapper.deletePopedomRoles", id);

		// 将新的添加进�?
		if(list.size() > 0){
			Integer j = (Integer) commonDao.save("xtgl030Mapper.savePopedomRoles", list);
			if (j <= 0) {
				throw new Exception("删除失败");
			}
		}

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> queryRoleUser(String roleId) throws Exception {
		Map<String,String> param = new HashMap<String,String>();
		param.put("roleId", roleId);
        List<Map<String,Object>> list = (List<Map<String,Object>>)commonDao.findForList("xtgl030Mapper.queryRoleUser", param);
		return list;
	}
	
	
}
