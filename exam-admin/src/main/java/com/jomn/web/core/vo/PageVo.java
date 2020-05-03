package com.jomn.web.core.vo;

import com.jomn.constant.api.ResultCode;

import java.util.List;

public class PageVo {

    private List<?> data;

    /** 消息状态码 */
    private int code;

    /** 消息内容 */
    private String msg;

    /** 总记录数 */
    private long total;

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
    public void setResultCode(ResultCode resultCode) {
        this.code = resultCode.code();
        this.msg = resultCode.message();
    }
}
