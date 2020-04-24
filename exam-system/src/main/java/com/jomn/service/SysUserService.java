package com.jomn.service;

import com.jomn.domain.SysMenu;
import com.jomn.domain.SysUser;

import java.util.List;

public interface SysUserService {

    public List<SysUser> selectAllUserList(SysUser sysUser);

    public SysUser login(String loginName);

    public SysUser selectUserByLoginName(String loginName);

    /**
     * 加载用户菜单
     */
    public List<SysMenu>  loadIndexPage(String header);

    public void updateUserById(SysUser sysUser);

    public void deleteUserById(Long userId);

    public void insertUser(SysUser sysUser);

    public void deleteUserByIds(Long[] ids);

    /**
     * 通过id查询用户信息
     */
    public SysUser selectUserById(Long userId);

}
