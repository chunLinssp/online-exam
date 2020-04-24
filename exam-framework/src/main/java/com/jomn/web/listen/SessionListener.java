package com.jomn.web.listen;

import org.apache.shiro.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SessionListener implements org.apache.shiro.session.SessionListener {
    private MySessionContext myc = MySessionContext.getInstance();
    private  final Logger log = LoggerFactory.getLogger(SessionListener.class);

    @Override
    public void onStart(Session session) {
        log.info(session.getId().toString() + " set into session");
        myc.addSession(session);
    }

    @Override
    public void onStop(Session session) {
        log.info(session.getId().toString() + " out of session");
        myc.delSession(session);
    }

    @Override
    public void onExpiration(Session session) {
        log.info(session.getId().toString() + " session out of time ");
        myc.delSession(session);
    }
}
