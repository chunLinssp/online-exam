package com.jomn.web.controller;

import com.jomn.constant.api.Result;
import com.jomn.constant.api.ResultHandle;
import com.jomn.core.page.TableDataInfo;
import com.jomn.domain.SysMenu;
import com.jomn.domain.SysUser;
import com.jomn.service.SysUserService;
import com.jomn.shiro.OAuthSessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class SysUserController extends BaseController{

    @Autowired
    SysUserService sysUserService;

    @GetMapping("/admin/index")
    @ResponseBody
    public Result index(HttpServletRequest request) {
        String header = request.getHeader(OAuthSessionManager.OAUTH_TOKEN);
        List<SysMenu> menus = sysUserService.loadIndexPage(header);
        Result success = ResultHandle.success(menus);
        return success;
    }


    @GetMapping("/system/user")
    @ResponseBody
    public TableDataInfo userView(SysUser sysUser, HttpServletRequest request) {
        startPage();
        List<SysUser> sysUsers = sysUserService.selectAllUserList(sysUser);
        return getTableDataInfo(sysUsers);
    }

    @PostMapping("/system/user/edit")
    @ResponseBody
    public Result editUser(SysUser sysUser) {
        sysUserService.updateUserById(sysUser);
        return ResultHandle.success();
    }

    @PostMapping("/system/user/delete")
    @ResponseBody
    public Result deleteUser(SysUser sysUser) {
        sysUserService.deleteUserById(sysUser.getUserId());
        Result success = ResultHandle.success();
        return success;
    }

    @PostMapping("/system/user/insert")
    @ResponseBody
    public Result insertUser(SysUser sysUser) {
        sysUserService.insertUser(sysUser);
        Result success = ResultHandle.success();
        return success;
    }



}
