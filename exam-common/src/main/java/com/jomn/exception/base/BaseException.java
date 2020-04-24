package com.jomn.exception.base;

public class BaseException extends RuntimeException{

    /**
     * 异常模块
     */
    private String module;

    /**
     * 异常参数
     */
    private Object[] args;

    /**
     * 错误码
     */
    private String code;

    /**
     * 错误消息
     */
    private String message;

    public BaseException(String module, Object[] args, String code, String message) {
        this.module = module;
        this.args = args;
        this.code = code;
        this.message = message;
    }

    public BaseException(String module, Object[] args, String code) {
        this.module = module;
        this.args = args;
        this.code = code;

    }

    public BaseException(Object[] args, String code) {
        this.args = args;
        this.code = code;
    }

    public BaseException(String module, String message) {
        this.module = module;
        this.message = message;
    }

    public BaseException(String message) {
        this.message = message;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
