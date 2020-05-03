package com.jomn.web.controller;

import com.jomn.constant.api.Result;
import com.jomn.constant.api.ResultHandle;
import com.jomn.core.page.TableDataInfo;
import com.jomn.domain.SysMenu;
import com.jomn.domain.SysRole;
import com.jomn.service.SysMenuService;
import com.jomn.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SysMenuController extends BaseController{

    @Autowired
    SysMenuService sysMenuService;

    @RequestMapping("/system/menu")
    @ResponseBody
    public Result menuView(@RequestBody(required = false) SysMenu sysMenu) {
        List<SysMenu> menus = loadMenuData(sysMenu);
        Result success = ResultHandle.success(menus);
        return success;
    }

    @PostMapping("/system/menu/edit")
    @ResponseBody
    public Result editMenu(@RequestBody SysMenu sysMenu) {
        sysMenuService.updateMenuById(sysMenu);
        return ResultHandle.success();
    }

    @PostMapping("/system/menu/delete")
    @ResponseBody
    public Result deleteMenu(@RequestBody SysMenu sysMenu) {
        sysMenuService.delteMenuById(sysMenu.getMenuId());
        Result success = ResultHandle.success();
        return success;
    }

    @PostMapping("/system/menu/insert")
    @ResponseBody
    public Result insertMenu(SysMenu sysMenu) {
        sysMenuService.insertMenu(sysMenu);
        Result success = ResultHandle.success();
        return success;
    }

    public List<SysMenu> loadMenuData(SysMenu sysMenu) {
        List<SysMenu> menus = new ArrayList<>();
        if(sysMenu == null) {
            menus =  sysMenuService.selectMenuList(sysMenu);
        }else {
            menus = sysMenuService.selectMenuListByCondition(sysMenu);
        }
        return menus;
    }




}
