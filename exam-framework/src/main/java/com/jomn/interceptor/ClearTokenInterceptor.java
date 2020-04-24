package com.jomn.interceptor;

import com.jomn.cache.RedisManager;
import com.jomn.shiro.OAuthSessionManager;
import com.jomn.utlis.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.apache.shiro.session.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Session 超时通知前端删除
 */
public class ClearTokenInterceptor extends HandlerInterceptorAdapter {

    private static final String SESSION_TIME_OUT_K = "SESSION_TIME_OUT";
    private static final String SESSION_TIME_OUT_V = "timeout";

    @Autowired
    private RedisManager redisManager;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader(OAuthSessionManager.OAUTH_TOKEN);
        if(StringUtils.isNotNull(token)) {
            Session session = redisManager.get(token, Session.class);
            if(StringUtils.isNull(session) || StringUtils.isNull(session.getId())) {
                response.setHeader(SESSION_TIME_OUT_K,SESSION_TIME_OUT_V);
            }
        }
        return super.preHandle(request,response,handler);
    }
}
