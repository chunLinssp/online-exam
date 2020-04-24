package com.jomn.web.controller;

import com.google.code.kaptcha.Constants;
import com.jomn.constant.api.Result;
import com.jomn.constant.api.ResultHandle;
import com.jomn.domain.SysUser;
import com.jomn.service.SysUserService;
import com.jomn.web.listen.MySessionContext;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class DemoController {

    @Autowired
    SysUserService sysUserService;

    @PostMapping("/admin/test1")
    @ResponseBody
    public Result test1(@RequestBody SysUser sysUser, HttpServletRequest request) {
        String header = request.getHeader("access-token");
        MySessionContext myc= MySessionContext.getInstance();
        Session sess = myc.getSession(header);
        Object attribute = sess.getAttribute(Constants.KAPTCHA_SESSION_KEY);
        List<SysUser> sysUsers = sysUserService.selectAllUserList(null);
        Result success = ResultHandle.success(sysUsers);
        return success;
    }

    @GetMapping("/admin/test2")
    @ResponseBody
    public Result test2( HttpServletRequest request) {
        String header = request.getHeader("access-token");
        MySessionContext myc= MySessionContext.getInstance();
        Session sess = myc.getSession(header);
        Object attribute = sess.getAttribute(Constants.KAPTCHA_SESSION_KEY);
        List<SysUser> sysUsers = sysUserService.selectAllUserList(null);
        Result success = ResultHandle.success(sysUsers);
        return success;
    }

}
