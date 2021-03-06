package com.jomn.service;

import com.jomn.domain.SysMenu;

import java.util.List;

public interface SysMenuService {

    /**
     * 修改菜单信息
     */
    public void updateMenuById(SysMenu sysMenu);

    /**
     * 增加菜单信息
     */
    public void insertMenu(SysMenu sysMenu);

    /**
     * 删除菜单
     */
    public void delteMenuById(Long menuId);

    /**
     * 查询所有菜单 加载父子节点
     */
    public List<SysMenu> selectMenuList(SysMenu sysMenu);

    /**
     * 查询所有菜单
     */
    public List<SysMenu> selectMenuListByCondition(SysMenu sysMenu);


}
