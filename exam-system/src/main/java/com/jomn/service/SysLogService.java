package com.jomn.service;

import com.jomn.domain.SysLog;

public interface SysLogService {

    /**
     * 删除日志信息
     */
    public void delteLogById(Long operId);

    /**
     * 删除大量之日信息
     */
    public void delteLogById(Long[] operIds);

    /**
     * 增加日志信息
     */
    public void insertLog(SysLog sysLog);








}
