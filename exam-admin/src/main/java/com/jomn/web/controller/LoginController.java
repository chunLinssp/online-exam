package com.jomn.web.controller;

import com.auth0.jwt.JWT;
import com.google.code.kaptcha.Constants;
import com.jomn.constant.api.Result;
import com.jomn.constant.api.ResultCode;
import com.jomn.constant.api.ResultHandle;
import com.jomn.domain.SysUser;
import com.jomn.service.SysUserService;
import com.jomn.shiro.OAuthSessionManager;
import com.jomn.utlis.JWTUtil;
import com.jomn.utlis.StringUtils;
import com.jomn.web.listen.MySessionContext;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    SysUserService sysUserService;

    @PostMapping("/admin/login")
    @ResponseBody
    public Result login(@RequestBody SysUser sysUser, HttpServletRequest request) {
        String loginName = sysUser.getLoginName();
        String password = sysUser.getPassword();
        String verificationCode =(String) sysUser.getParams().get("verificationCode");
        Result result = executeLogin(request,loginName, password, verificationCode);
        return result;
    }






    private Result executeLogin( HttpServletRequest request ,String loginName,String password,String code) {
        Result result = new Result();
        String header = request.getHeader("access-token");
        MySessionContext myc= MySessionContext.getInstance();
        Session sess = myc.getSession(header);
        String rightCode =(String) sess.getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if(StringUtils.isNotNull(rightCode) && StringUtils.isNotNull(code)) {
            if(!code.equals(rightCode)) {
                result.setResultCode(ResultCode.ERROR_CAPTCHA);
                return result;
            }
        }
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(loginName,password);
        Subject subject = SecurityUtils.getSubject();
        try{
            subject.login(usernamePasswordToken);
            result.setResultCode(ResultCode.SUCCESS);
            Map<String,Object> map = new HashMap<>();
            loadCertificatesDto(map, loginName, password);
            result.setData(map);
        }catch (UnknownAccountException e) {
            result.setResultCode(ResultCode.USER_NOT_EXIST);
        }catch (LockedAccountException e) {
            result.setResultCode(ResultCode.USER_ACCOUNT_FORBIDDEN);
        }catch (AuthenticationException e) {
            result.setResultCode(ResultCode.USER_LOGIN_ERROR);
        }catch (Exception e){
            result.setResultCode(ResultCode.ERROR);
        }finally {
            return result;
        }
    }

    /**
     * 传递的认证信息
     */
    public void loadCertificatesDto(Map<String,Object> map,String loginName,String password) {
        SysUser sysUser = sysUserService.selectUserByLoginName(loginName);
        map.put("account",sysUser.getLoginName());
        map.put("name",sysUser.getUserName());
        map.put("avatar",sysUser.getAvatar());
        map.put("id",sysUser.getUserId());
        map.put(OAuthSessionManager.OAUTH_TOKEN, JWTUtil.sign(loginName,password));
    }








}
