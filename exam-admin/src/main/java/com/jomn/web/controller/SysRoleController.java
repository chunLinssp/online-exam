package com.jomn.web.controller;

import com.jomn.constant.api.Result;
import com.jomn.constant.api.ResultHandle;
import com.jomn.core.page.TableDataInfo;
import com.jomn.domain.SysMenu;
import com.jomn.domain.SysRole;
import com.jomn.domain.SysUser;
import com.jomn.service.SysRoleService;
import com.jomn.service.SysUserService;
import com.jomn.shiro.OAuthSessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class SysRoleController extends BaseController{

    @Autowired
    SysRoleService sysRoleService;

    @RequestMapping("/system/role")
    @ResponseBody
    public TableDataInfo roleView(SysRole sysRole) {
        startPage();
        List<SysRole> sysRoles = sysRoleService.selectRoleList(sysRole);
        TableDataInfo tableDataInfo = getTableDataInfo(sysRoles);
        return tableDataInfo;
    }

    @PostMapping("/system/role/edit")
    @ResponseBody
    public Result editRole(SysRole sysRole) {
        sysRoleService.updateRoleById(sysRole);
        return ResultHandle.success();
    }

    @PostMapping("/system/role/delete")
    @ResponseBody
    public Result deleteRole(SysRole sysRole) {
        sysRoleService.deleteRoleById(sysRole.getRoleId());
        Result success = ResultHandle.success();
        return success;
    }

    @PostMapping("/system/role/insert")
    @ResponseBody
    public Result insertRole(SysRole sysRole) {
        sysRoleService.insertRole(sysRole);
        Result success = ResultHandle.success();
        return success;
    }








}
