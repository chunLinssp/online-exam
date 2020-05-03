package com.jomn.service.impl;

import com.jomn.constant.SystemConstant;
import com.jomn.domain.SysMenu;
import com.jomn.mapper.SysMenuMapper;
import com.jomn.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    SysMenuMapper sysMenuMapper;


    @Override
    public void updateMenuById(SysMenu sysMenu) {
        sysMenuMapper.updateMenuById(sysMenu);
    }

    @Override
    public void insertMenu(SysMenu sysMenu) {
        sysMenuMapper.insertMenu(sysMenu);
    }

    @Override
    public void delteMenuById(Long menuId) {
        sysMenuMapper.delteMenuById(menuId);
    }

    @Override
    public List<SysMenu> selectMenuList(SysMenu sysMenu) {
        List<SysMenu> menus = sysMenuMapper.selectMenuList(sysMenu);
        return loadMenu(menus);
    }

    @Override
    public List<SysMenu> selectMenuListByCondition(SysMenu sysMenu) {
        return sysMenuMapper.selectMenuList(sysMenu);
    }

    public List<SysMenu> loadMenu(List<SysMenu> list) {
        List<SysMenu> menus = new ArrayList<>();
        for (SysMenu sysMenu : list) {
            if(SystemConstant.MAIN_MENU_TYPE.equals(sysMenu.getMenuType())) {
                Long menuId = sysMenu.getMenuId();
                Set<SysMenu> twiceMenus = new HashSet<>();
                sysMenu.setChildren(twiceMenus);
                for (SysMenu menu : list) {
                    if(SystemConstant.TWICE_MENU_TYPE.equals(menu.getMenuType()) && menu.getParentId().equals(menuId)) {
                        twiceMenus.add(menu);
                        Long twiceId = menu.getMenuId();
                        Set<SysMenu> lastMenus = new HashSet<>();
                        menu.setChildren(lastMenus);
                        for(SysMenu lastMenu : list) {
                            if(twiceId.equals(lastMenu.getParentId())) {
                                lastMenus.add(lastMenu);
                            }
                        }
                    }
                }
                menus.add(sysMenu);
            }
        }
        return menus;
    }





}
