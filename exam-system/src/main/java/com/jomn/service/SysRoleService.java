package com.jomn.service;

import com.jomn.domain.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysRoleService {

    /**
     * 查询所有角色
     */
    public List<SysRole> selectRoleList(SysRole role);

    /**
     * 更新角色信息
     */
    public void updateRoleById(SysRole sysRole);

    /**
     * 删除角色信息
     */
    public void deleteRoleById(Long roleId);

    /**
     * 增加角色信息role表操作
     */
    public void insertRole(SysRole sysRole);

    /**
     * 增加角色信息role_menu表操作
     */
    public void insertRoleById(@Param("roleId")Long roleId,Long[] menuIds);

    /**
     * 增加用户角色操作user_role表操作
     */
    public void insertRoleByUserId(@Param("userId")Long userId,Long[] roleIds);


}
