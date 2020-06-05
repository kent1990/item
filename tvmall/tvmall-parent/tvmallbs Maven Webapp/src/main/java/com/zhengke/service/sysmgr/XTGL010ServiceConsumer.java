package com.zhengke.service.sysmgr;

import java.util.List;
import java.util.Map;

import com.zhengke.common.object.Result;
import com.zhengke.pojo.SysMenu;


public interface XTGL010ServiceConsumer {

    /**
     * 查询所有的菜单
     * @return
     * @throws Exception
     */
    Result query(int page,int limit) throws Exception;

    /**
     * 添加菜单时下拉框内容
     * @return
     * @throws Exception
     */
    List<Map<String, Object>> querySelect() throws Exception;

    /**
     * 新增菜单
     * @param sm
     * @throws Exception
     */
    void addMenu(SysMenu sm) throws Exception;

    /**
     * 修改菜单
     * @param sm
     * @throws Exception
     */
    void updMenu(SysMenu sm) throws Exception;

    /**
     * 删除菜单
     * @param sm
     * @throws Exception
     */
    void delMenu(String menuId) throws Exception;
}
