package com.jomn.service.impl;

import com.jomn.domain.SysRole;
import com.jomn.mapper.SysRoleMapper;
import com.jomn.service.SysRoleService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    SysRoleMapper sysRoleMapper;

    @Override
    public List<SysRole> selectRoleList(SysRole sysRole){
         List<SysRole> sysRoles = sysRoleMapper.selectRoleList(sysRole);
         return sysRoles;
     }

    @Override
    public void updateRoleById(SysRole sysRole){
        sysRoleMapper.updateRoleById(sysRole);
    }

    @Override
    public void deleteRoleById(Long roleId){
        sysRoleMapper.deleteRoleById(roleId);
    }

    @Override
    public void insertRole(SysRole sysRole){
        sysRoleMapper.insertRole(sysRole);
    }

    @Override
    public void insertRoleById(@Param("roleId") Long roleId, Long[] menuIds){
        sysRoleMapper.insertRoleById(roleId,menuIds);
    }

    @Override
    public void insertRoleByUserId(@Param("userId") Long userId, Long[] roleIds){
        sysRoleMapper.insertRoleByUserId(userId,roleIds);
    }


}
