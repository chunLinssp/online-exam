package com.jomn.service.impl;

import com.jomn.domain.SysMenu;
import com.jomn.domain.SysRole;
import com.jomn.domain.SysUser;
import com.jomn.exception.user.UserNotExistsException;
import com.jomn.mapper.SysUserMapper;
import com.jomn.service.SysUserService;
import com.jomn.utlis.JWTUtil;
import com.jomn.utlis.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    SysUserMapper sysUserMapper;

    public List<SysUser> selectAllUserList(SysUser sysUser){
        return sysUserMapper.selectAllUserList(sysUser);
    }



    @Override
    public SysUser login(String loginName) {
        SysUser sysUser = sysUserMapper.selectUserByLoginName(loginName);
        if(StringUtils.isNull(sysUser)) {
            throw new UserNotExistsException();
        }
        return sysUser;
    }

    @Override
    public SysUser selectUserByLoginName(String loginName) {
        SysUser sysUser = sysUserMapper.selectUserByLoginName(loginName);
        return sysUser;
    }


    @Override
    public List<SysMenu> loadIndexPage(String header) {
        if(header != null) {
            String username = JWTUtil.getUsername(header);
            SysUser sysUser = sysUserMapper.selectUserByLoginName(username);
            if(StringUtils.isNotNull(sysUser)) {
                List<SysMenu> menus = loadMenu(sysUser);
                return menus;
            }
        }
        return null;
    }

    @Override
    public void updateUserById(SysUser sysUser) {
        sysUserMapper.updateUserById(sysUser);
    }

    @Override
    public void deleteUserById(Long userId) {
        sysUserMapper.deleteUserById(userId);
    }

    @Override
    public void insertUser(SysUser sysUser) {
        sysUserMapper.insertUser(sysUser);
    }

    @Override
    public void deleteUserByIds(Long[] ids) {
        sysUserMapper.deleteUserByIds(ids);
    }

    @Override
    public SysUser selectUserById(Long userId) {
        SysUser sysUser = sysUserMapper.selectUserById(userId);
        return sysUser;
    }

    public List<SysMenu> loadMenu(SysUser sysUser) {
        List<SysRole> roles = sysUser.getRoles();
        List<SysMenu> menus = new ArrayList<>();
        for (SysRole role : roles) {
            List<SysMenu> sysMenuList = role.getSysMenuList();
            for (SysMenu sysMenu : sysMenuList) {

                String menuType = sysMenu.getMenuType();
                if(menuType != null && menuType.equals("M")) {

                    Long parentId = sysMenu.getMenuId();
                    Set<SysMenu> sonList = new HashSet<SysMenu>();
                    for (SysMenu smenu : sysMenuList) {
                        String smenuType = smenu.getMenuType();
                        if(smenuType != null && smenuType.equals("C")) {
                            Long sonId = smenu.getParentId();
                            if(sonId.equals(parentId)) {
                                sonList.add(smenu);
                            }
                        }
                    }
                    sysMenu.setChildren(sonList);
                    menus.add(sysMenu);
                }

            }
        }
        return removeSameMenuF(menus);
    }

    /**
     * 去重 ，存在一个角色有相同菜单的情况
     */
    public List<SysMenu> removeSameMenuF(List<SysMenu> sysMenus) {
        List<SysMenu> finalMenu = new ArrayList<>();
        for (SysMenu sysMenu : sysMenus) {
            String menuName = sysMenu.getMenuName();
            Long menuId = sysMenu.getMenuId();
            Set<SysMenu> children = sysMenu.getChildren();
            for (SysMenu sonMenu : sysMenus) {
                if(sonMenu.equals(menuName) && !sonMenu.getMenuId().equals(menuId)) {
                    Set<SysMenu> children1 = sonMenu.getChildren();
                    for (SysMenu menu : children1) {
                        children.add(menu);
                    }
                }
            }
            sysMenu.setChildren(children);
            finalMenu.add(sysMenu);
        }
        return finalMenu;
    }




}
