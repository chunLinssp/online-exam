package com.jomn.mapper;

import com.jomn.domain.SysUser;

import java.util.List;

public interface SysUserMapper {

    public List<SysUser> selectAllUserList(SysUser sysUser);

    public SysUser selectUserByLoginName(String loginName);

    public void updateUserById(SysUser sysUser);

    public void deleteUserById(Long userId);

    public void insertUser(SysUser sysUser);

    public void deleteUserByIds(Long[] ids);

    /**
     * 通过id查询用户信息
     */
    public SysUser selectUserById(Long userId);

}
