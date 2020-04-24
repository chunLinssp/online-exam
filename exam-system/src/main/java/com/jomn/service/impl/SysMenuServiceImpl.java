package com.jomn.service.impl;

import com.jomn.domain.SysMenu;
import com.jomn.mapper.SysMenuMapper;
import com.jomn.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return menus;
    }

//    public List<SysMenu> loadMenu(List<SysMenu> list) {
//        for (SysMenu sysMenu : list) {
//            Long menuId = sysMenu.getMenuId();
//            for (SysMenu menu : list) {
//                if(menu.getParentId()!= null) {
//                    if(menu.getParentId().equals(menuId)) {
//                    }
//                }
//            }
//        }
//    }





}
