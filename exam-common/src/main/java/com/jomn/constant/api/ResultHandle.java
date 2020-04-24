package com.jomn.constant.api;


import com.jomn.constant.SystemConstant;

public class ResultHandle {

    public static Result success(Object data){
        Result result = new Result();
        result.setCode(200);
        result.setData(data);
        result.setMessage("请求成功");
        return result;
    }

    public static Result success(){
        Result result = new Result();
        result.setCode(200);
        result.setMessage("请求成功");
        return result;
    }

    public static Result BuildApiResult(Integer code,String message,Object data){
        Result result = new Result();
        result.setMessage(message);
        result.setCode(code);
        result.setData(data);
        return result;
    }
    public static Result BuildApiResult(ResultCode resultCode,Object data){
        Result result = new Result();
        result.setMessage(resultCode.message());
        result.setCode(resultCode.code());
        result.setData(data);
        return result;
    }

    public static Result BuildFailApiResult(ResultCode resultCode){
        Result result = new Result();
        result.setMessage(resultCode.message());
        result.setCode(resultCode.code());
        result.setData(ResultCode.ERROR);
        return result;
    }

    public static Result BuildSuccessApiResult(ResultCode resultCode){
        Result result = new Result();
        result.setMessage(resultCode.message());
        result.setCode(resultCode.code());
        result.setData(ResultCode.ERROR);
        return result;
    }
}
