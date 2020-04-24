package com.jomn.shiro.filter;

import com.jomn.shiro.OAuthSessionManager;
import com.jomn.shiro.domain.JWTToken;
import com.jomn.utlis.StringUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class JwtFilter extends BasicHttpAuthenticationFilter {

    private final Logger logger = LoggerFactory.getLogger(JwtFilter.class);

    /**
     * 判断用户是否想要登入
     */
    @Override
    protected boolean isLoginAttempt(ServletRequest request, ServletResponse response) {
        HttpServletRequest req = (HttpServletRequest)request;
        String token = req.getHeader(OAuthSessionManager.OAUTH_TOKEN);
        if(StringUtils.isNotNull(token)) {
            return true;
        }
        return false;
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        if(isLoginAttempt(request,response)) {
            try{
                executeLogin(request,response);
            }catch (Exception e) {
                logger.error(e.getMessage());
            }
        }
        return true;
    }

    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest req = (HttpServletRequest)request;
        String token = req.getHeader(OAuthSessionManager.OAUTH_TOKEN);
        JWTToken jwtToken = new JWTToken(token);
        Subject subject = getSubject(request, response);
        subject.login(jwtToken);
        return true;
    }
}
